package BLL;

import DAO.ClientDAO;
import DAO.ProductDAO;
import Model.Client;
import Model.Product;

import java.util.List;
import java.util.NoSuchElementException;
/**
 * Business logic layer pentru Produs
 * Se implementeaza metodele pentru efectuarea operatiilor cerute asupra produselor din BD.
 */
public class ProductBLL {
    private ProductDAO productDAO;
    public ProductBLL()
    {
        productDAO = new ProductDAO();
    }
    /**
     * Se cauta toate produsele si se returneaza o lista cu acestia, care va fi afisata in interfata.
     */
    public List<Product> findAll() {
        List<Product> st = productDAO.findAll();
        if (st == null) {
            throw new NoSuchElementException("The products were not found!");
        }
        return st;
    }
    /**
     * Se insereaza in baza de date produsul ale carui date au fost preluate din interfata prin
     * intermediul parametrului "args".
     * @param args
     */
    public void insertInto(List<String> args)
    {
        try
        {
            productDAO.insert(args);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Se sterge din baza de date produsul ale carui date au fost preluate din interfata prin
     * intermediul parametrului "args".
     * @param args
     */
    public void deleteFrom(String args)
    {
        try
        {
            productDAO.deleteFrom(args);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Se editeaza in baza de date produsul ale carui date au fost preluate din interfata prin
     * intermediul parametrilor "id", "fieldNames" si "values"
     * @param id - id-ul clientului asupra caruia se efectueaza modificarile
     * @param fieldNames - campurile care se doresc a fi modificate
     * @param values - valorile noi care vor fi modificate in campurile din lista fieldNames
     */
    public void editProduct(String id, List<String> fieldNames, List<String> values)
    {
        try
        {
            productDAO.updateTable(id, fieldNames, values);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
