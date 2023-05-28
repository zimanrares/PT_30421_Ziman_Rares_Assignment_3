package Model;

import java.util.ArrayList;
import java.util.Date;
/**
 * Modelul Comanda pentru baza de date.
 */
public class Comanda {
    private int id;
    private int clientID;
    private String clientName;
    private String clientPrenume;
    private String clientEmail;
    private Date date;
    private int quantity;
    private int totalPrice;
    public Comanda() {
    }

    public Comanda(int id, int clientID, String clientName, String clientPrenume, String clientEmail, Date date, int quantity, int totalPrice) {
        this.id = id;
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientPrenume = clientPrenume;
        this.clientEmail = clientEmail;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPrenume() {
        return clientPrenume;
    }

    public void setClientPrenume(String clientPrenume) {
        this.clientPrenume = clientPrenume;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
