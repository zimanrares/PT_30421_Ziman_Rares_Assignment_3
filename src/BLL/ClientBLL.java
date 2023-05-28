package BLL;

import DAO.ClientDAO;
import Model.Client;

import java.util.List;
import java.util.NoSuchElementException;
/**
 * Business logic layer pentru Client
 * Se implementeaza metodele pentru efectuarea operatiilor cerute asupra clientilor din BD.
 */
public class ClientBLL {

    private ClientDAO clientDAO;
    public ClientBLL()
    {
        clientDAO = new ClientDAO();
    }

    /**
     * Se cauta toti clientii si se returneaza o lista cu acestia, care va fi afisata in interfata.
     */
    public List<Client> findAll() {
        List<Client> st = clientDAO.findAll();
        if (st == null) {
            throw new NoSuchElementException("The clients were not found!");
        }
        return st;
    }

    /**
     * Se insereaza in baza de date clientul ale carui date au fost preluate din interfata prin
     * intermediul parametrului "args".
     * @param args
     */
    public void insertInto(List<String> args)
    {
        try
        {
            clientDAO.insert(args);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Se sterge din baza de date clientul ale carui date au fost preluate din interfata prin
     * intermediul parametrului "args".
     * @param args
     */
    public void deleteFrom(String args)
    {
        try
        {
            clientDAO.deleteFrom(args);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Se editeaza in baza de date clientul ale carui date au fost preluate din interfata prin
     * intermediul parametrilor "id", "fieldNames" si "values"
     * @param id - id-ul clientului asupra caruia se efectueaza modificarile
     * @param fieldNames - campurile care se doresc a fi modificate
     * @param values - valorile noi care vor fi modificate in campurile din lista fieldNames
     */
    public void editClient(String id, List<String> fieldNames, List<String> values)
    {
        try
        {
            clientDAO.updateTable(id, fieldNames, values);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
