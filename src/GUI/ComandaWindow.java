package GUI;

import BLL.ClientBLL;
import BLL.ComandaBLL;
import BLL.ProductBLL;
import Model.Client;
import Model.Comanda;
import Model.Product;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Clasa CommandWindow - responsabila pentru plasarea de comenzi.
 * Contine 2 comboBox-uri si un textField cu ajutorul carora se vor efectua comenzile.
 */
public class ComandaWindow {

    private JFrame frmMeniuComanda;
    private JTextField txtMeniuComanda;
    private JTextField txtListaClienti;
    private JTextField txtListaProduse;

    public JFrame getFrame()
    {
        return this.frmMeniuComanda;
    }
    public ComandaWindow() {
        initialize();
    }

    /**
     * Se initializeaza frame-ul pentru fereastra meniului de comenzi.
     */
    private void initialize() {
        frmMeniuComanda = new JFrame();
        frmMeniuComanda.setTitle("Meniu comanda");
        frmMeniuComanda.setFocusableWindowState(true);
        frmMeniuComanda.setFocusable(false);
        frmMeniuComanda.setFocusCycleRoot(true);
        frmMeniuComanda.setFocusTraversalKeysEnabled(true);
        frmMeniuComanda.setBounds(100, 100, 752, 323);
        frmMeniuComanda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmMeniuComanda.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        frmMeniuComanda.getContentPane().add(panel, BorderLayout.CENTER);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(0, 0, 51));
        panel_1.setBounds(0, 0, 230, 284);
        panel.add(panel_1);

        txtMeniuComanda = new JTextField();
        txtMeniuComanda.setText("Meniu comanda");
        txtMeniuComanda.setHorizontalAlignment(SwingConstants.CENTER);
        txtMeniuComanda.setForeground(Color.WHITE);
        txtMeniuComanda.setFont(new Font("Mongolian Baiti", Font.ITALIC, 25));
        txtMeniuComanda.setFocusable(false);
        txtMeniuComanda.setFocusTraversalKeysEnabled(false);
        txtMeniuComanda.setEditable(false);
        txtMeniuComanda.setColumns(10);
        txtMeniuComanda.setBorder(null);
        txtMeniuComanda.setBackground(new Color(0, 153, 204));
        txtMeniuComanda.setBounds(0, 0, 230, 82);
        panel_1.add(txtMeniuComanda);

        JTextArea txtrSelecteazaClientulSelecteaza = new JTextArea();
        txtrSelecteazaClientulSelecteaza.setBackground(new Color(0, 0, 51));
        txtrSelecteazaClientulSelecteaza.setForeground(new Color(255, 255, 255));
        txtrSelecteazaClientulSelecteaza.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        txtrSelecteazaClientulSelecteaza.setEditable(false);
        txtrSelecteazaClientulSelecteaza.setText("1. Selecteaza clientul.\r\n\r\n2. Selecteaza produsul.\r\n\r\n3. Apasa \"Comanda!\" pentru\r\na finaliza operatiunea.");
        txtrSelecteazaClientulSelecteaza.setBounds(10, 107, 198, 155);
        panel_1.add(txtrSelecteazaClientulSelecteaza);

        JComboBox comboBoxClienti = new JComboBox();
        comboBoxClienti.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
        comboBoxClienti.setForeground(new Color(255, 255, 255));
        comboBoxClienti.setBackground(new Color(0, 153, 255));
        comboBoxClienti.setFocusTraversalKeysEnabled(false);
        comboBoxClienti.setFocusable(false);
        comboBoxClienti.setRequestFocusEnabled(false);
        comboBoxClienti.setBorder(null);
        comboBoxClienti.setBounds(240, 101, 486, 29);
        panel.add(comboBoxClienti);

        JButton btnComandaNoua = new JButton("Comanda!");
        btnComandaNoua.setBounds(550, 222, 176, 53);
        panel.add(btnComandaNoua);
        btnComandaNoua.setRolloverEnabled(false);
        btnComandaNoua.setRequestFocusEnabled(false);
        btnComandaNoua.setForeground(Color.WHITE);
        btnComandaNoua.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnComandaNoua.setFocusable(false);
        btnComandaNoua.setFocusTraversalKeysEnabled(false);
        btnComandaNoua.setFocusPainted(false);
        btnComandaNoua.setBorder(null);
        btnComandaNoua.setBackground(new Color(0, 153, 204));

        JComboBox comboBoxProduse = new JComboBox();
        comboBoxProduse.setForeground(new Color(255, 255, 255));
        comboBoxProduse.setBackground(new Color(0, 153, 255));
        comboBoxProduse.setFocusTraversalKeysEnabled(false);
        comboBoxProduse.setFocusable(false);
        comboBoxProduse.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
        comboBoxProduse.setBorder(null);
        comboBoxProduse.setBounds(240, 170, 486, 29);
        panel.add(comboBoxProduse);

        txtListaClienti = new JTextField();
        txtListaClienti.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        txtListaClienti.setBackground(Color.WHITE);
        txtListaClienti.setBorder(null);
        txtListaClienti.setEditable(false);
        txtListaClienti.setText("Lista clienti");
        txtListaClienti.setBounds(240, 75, 86, 20);
        panel.add(txtListaClienti);
        txtListaClienti.setColumns(10);

        txtListaProduse = new JTextField();
        txtListaProduse.setText("Lista produse");
        txtListaProduse.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        txtListaProduse.setEditable(false);
        txtListaProduse.setColumns(10);
        txtListaProduse.setBorder(null);
        txtListaProduse.setBackground(Color.WHITE);
        txtListaProduse.setBounds(240, 149, 86, 20);
        panel.add(txtListaProduse);

        JTextField txtCantitate;
        txtCantitate = new JTextField();
        txtCantitate.setText("Cantitate");
        txtCantitate.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        txtCantitate.setEditable(false);
        txtCantitate.setColumns(10);
        txtCantitate.setBorder(null);
        txtCantitate.setBackground(Color.WHITE);
        txtCantitate.setBounds(240, 210, 86, 20);
        panel.add(txtCantitate);

        JTextArea txtrText = new JTextArea();
        txtrText.setDisabledTextColor(Color.LIGHT_GRAY);
        txtrText.setFocusTraversalPolicyProvider(true);
        txtrText.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        txtrText.setBackground(Color.LIGHT_GRAY);
        txtrText.setBounds(240, 232, 115, 29);
        panel.add(txtrText);


        // INITIALIZARE COMBOBOXURI
        // COMBOBOX CLIENTI
        ClientBLL cbll = new ClientBLL();
        List<Client> clients = cbll.findAll();

        for(Client c: clients)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("ID: " + c.getId() + " NUME: " + c.getName() + " PRENUME: " + c.getPrenume() + " EMAIL: " + c.getEmail());
            comboBoxClienti.addItem(sb.toString());
            //System.out.println(sb);
        }
        // COMBOBOX PRODUSE
        ProductBLL pbll = new ProductBLL();
        List<Product> produse = pbll.findAll();

        for(Product c: produse)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("ID: " + c.getId() + " NUME: " + c.getName() + " PRET: " + c.getPrice() + " STOC: " + c.getStock());
            comboBoxProduse.addItem(sb.toString());
            //System.out.println(sb);
        }
        //ACTION LISTENERS
        // BUTON COMANDA
        /**
         * Adauga listener pe butonul "Comanda"
         * Se preia clientul, produsul si cantitatea selectata
         * si se genereaza comanda impreuna cu fisierul text.
         */
        btnComandaNoua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String client = (String) comboBoxClienti.getSelectedItem();
                //System.out.println("CLIENTUL ESTE " + client);
                String produs = (String) comboBoxProduse.getSelectedItem();
                ComandaBLL cbll = new ComandaBLL();
                List<Comanda> products = cbll.findAll();
                for(Comanda cc: products)
                {
                    cc.toString();
                }
                int id = products.size()+1;
                List<String> args = new ArrayList<String>();
                args.add(String.valueOf(id));

                StringTokenizer st = new StringTokenizer(client);
                int counter = 0;
                while (st.hasMoreTokens()) {
                    st.nextToken();
                    args.add(st.nextToken());
                }

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                args.add(String.valueOf(formatter.format(date)));
                int quantity = Integer.parseInt(txtrText.getText());
                args.add(String.valueOf(quantity));

                st = new StringTokenizer(produs);
                int idProdus=-1;
                for(int j = 0; j < 5; j++)
                {
                    if(j==1)
                        idProdus = Integer.parseInt(st.nextToken());
                    else st.nextToken();
                }
                args.add(String.valueOf(quantity * Integer.parseInt(st.nextToken())));
                System.out.println("/////////////");
                for(String s: args)
                {
                    System.out.println(s);
                }
                st.nextToken();
                String stocActual = st.nextToken();
                if(Integer.parseInt(stocActual) < quantity)
                {
                    JOptionPane.showMessageDialog(frmMeniuComanda,
                            "Cantitate prea mare!");
                }
                else {
                    cbll.createOrder(args);
                    cbll.scadeStoc(idProdus, Integer.parseInt(stocActual) - quantity);
                    JOptionPane.showMessageDialog(frmMeniuComanda,
                            "Comanda efectuata cu succes!");
                    frmMeniuComanda.dispose();
                    try {
                        File myObj = new File("order" + id + ".txt");
                        if (myObj.createNewFile()) {
                            FileWriter myWriter = new FileWriter("order" + id + ".txt");
                            myWriter.write(args.toString());
                            myWriter.close();
                            System.out.println("File created: " + myObj.getName());
                        } else {
                            System.out.println("File already exists.");
                        }
                    } catch (IOException ex) {
                        System.out.println("An error occurred.");
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}
