package BLL;

import DAO.ClientDAO;
import DAO.ComandaDAO;
import Model.Client;
import Model.Comanda;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * Business logic layer pentru Comanda
 * Se implementeaza metodele pentru efectuarea operatiilor cerute asupra Comenzilor din BD.
 */
public class ComandaBLL {
    private ComandaDAO comandaDAO;

    public ComandaBLL()
    {
        comandaDAO = new ComandaDAO();
    }
    /**
     * Se insereaza in baza de date comanda ale carei date au fost preluate din interfata prin
     * intermediul parametrului "args".
     * @param args
     */
    public void createOrder(List<String> args) {
            try
            {
                comandaDAO.insert(args);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    /**
     * Se cauta toate comenzile. Functia este folosita pentru determinarea ID-ului comenzii curente.
     */
    public List<Comanda> findAll() {
        List<Comanda> st = comandaDAO.findAll();
        if (st == null) {
            throw new NoSuchElementException("The comands were not found!");
        }
        return st;
    }

    /**
     * La plasarea unei comenzi se scade stocul produsului respectiv.
     * @param id - id-ul produsului comandat
     * @param stocNou - noul stoc dupa scaderea cantitatii comandate
     */
    public void scadeStoc(int id, int stocNou)
    {
        ProductBLL produs = new ProductBLL();
        List<String> fieldNames = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        fieldNames.add("stock");
        values.add(String.valueOf(stocNou));
        produs.editProduct(String.valueOf(id), fieldNames, values);
    }
}
