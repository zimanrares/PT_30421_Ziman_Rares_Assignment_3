package DAO;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;
import Model.Client;

/**
 * Clasa AbstractDAO se ocupa cu efectuarea operatiilor asupra bazei de date.
 * Parametrul T reprezinta clasa sau obiectul pe care realizam operatiile.
 * @param <T>
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Se creeaza query-ul pentru selectarea unui obiect pe baza unui camp dorit.
     * @param field - campul dupa care se face cautarea
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Se creeaza query-ul pentru inserearea unui obiect pe baza argumentelor oferite.
     * @param arguments
     */
    public String insertInto(List<String> arguments)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append(" ( ");
        for(Field d: type.getDeclaredFields())
        {
            sb.append(d.getName() + ", ");
        }
        sb.deleteCharAt(sb.length()-2);
        sb.append(") values (" );
        for(String s: arguments)
        {
            sb.append("\"" + s + "\", ");
        }
        sb.deleteCharAt(sb.length()-2);
        sb.append(" )");
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * Se creeaza query-ul pentru selectarea tuturor obiectelor dintr-o tabela.
     */
    private String createFindAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * Se creeaza query-ul pentru stergerea unui obiect pe baza id-ului oferit ca parametru.
     * @param id
     */
    private String deleteQuery(String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE ID = \" ");
        sb.append(id);
        sb.append(" \";");

        return sb.toString();
    }

    /**
     * Se creeaza query-ul pentru actualizarea unui obiect pe baza parametrilor.
     * @param id - id-ul obiectului asupra caruia efectuam operatiunea
     * @param fieldNames - campurile care se vor modifica
     * @param values - valorile campurilor care se modifica
     */
    private String updateQuery(String id, List<String> fieldNames, List<String> values)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE " + type.getSimpleName() + " SET ");
        int i = -1;
        for(String fn: fieldNames)
        {
            ++i;
            sb.append( fn + " = " + "\"" +values.get(i) + "\"" + ", ");
        }
        sb.deleteCharAt(sb.length()-2);
        sb.append(" WHERE id = " + id + ";");
        System.out.println(sb);
        return sb.toString();
    }

    /**
     * Se efectueaza operatia de cautare a tuturor obiectelor din tabela T si se returneaza urmand a fi afisate
     * in interfata.
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createFindAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return (List<T>) createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Se efectueaza operatia de cautare a obiectului din tabela T cu id-ul "id" si se returneaza obiectul.
     * @param id
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * In mod generic, se creeaza obiectele rezultate in urma unei operatii, transmise prin "resultSet" si se returneaza
     * obiectele create.
     * @param resultSet
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException | IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Se insereaza in tabelul T obiectul preluat de la interfata prin parametrul "args".
     * @param args
     */
    public T insert(List<String> args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = insertInto(args);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insertInto " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Se sterge din tabelul T obiectul cu id-ul "id", preluat de la interfata.
     * @param id
     */
    public T deleteFrom(String id)
    {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = deleteQuery(id);
        System.out.println(query);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteFrom " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * In tabelul T obiectului cu id-ul "id" i se vor modifica campurile transmise prin parametrul fieldNames
     * cu valorile values.
     * @param id
     * @param fieldNames
     * @param values
     */
    public T updateTable(String id, List<String> fieldNames, List<String> values)
    {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = updateQuery(id, fieldNames, values);
        System.out.println(query);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:updateTable " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

}
