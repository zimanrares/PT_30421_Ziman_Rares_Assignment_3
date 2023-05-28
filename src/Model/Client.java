package Model;

/**
 * Modelul Client pentru baza de date.
 */
public class Client {
    private int id;
    private  String name;
    private  String prenume;
    private String email;

    public Client(){}

    public Client(int id, String name, String prenume, String email) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
