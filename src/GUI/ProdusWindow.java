package GUI;

import BLL.ClientBLL;
import BLL.ProductBLL;
import Model.Client;
import Model.Product;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *  Clasa ProdusWindow - reprezinta fereastra pentru meniul de produse pe care se
 *  regasesc butoane pentru:
 *  -adaugarea unui produs
 *  -stergerea unui produs
 *  -editarea unui produs
 *  -vizualizarea produselor.
 */
public class ProdusWindow {

    private JFrame frmMeniuClienti;
    private JTextField txtMeniuClienti;
    private JTable table;


    public JFrame getFrame()
    {
        return this.frmMeniuClienti;
    }

    public ProdusWindow() {
        initialize();
    }

    /**
     * Se initializeaza frame-ul pentru fereastra meniului de produse.
     */
    private void initialize() {
        frmMeniuClienti = new JFrame();
        frmMeniuClienti.setTitle("Meniu produse");
        frmMeniuClienti.setResizable(false);
        frmMeniuClienti.setBounds(100, 100, 760, 465);
        frmMeniuClienti.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        frmMeniuClienti.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 230, 433);
        panel_1.setBackground(new Color(0, 0, 51));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JButton btnVizualizareProdus = new JButton("Vizualizare produse");
        btnVizualizareProdus.setBounds(23, 301, 176, 53);
        panel_1.add(btnVizualizareProdus);
        btnVizualizareProdus.setRolloverEnabled(false);
        btnVizualizareProdus.setRequestFocusEnabled(false);
        btnVizualizareProdus.setForeground(Color.WHITE);
        btnVizualizareProdus.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnVizualizareProdus.setFocusable(false);
        btnVizualizareProdus.setFocusTraversalKeysEnabled(false);
        btnVizualizareProdus.setFocusPainted(false);
        btnVizualizareProdus.setBorder(null);
        btnVizualizareProdus.setBackground(new Color(0, 153, 204));

        JButton btnEditeazaProdus = new JButton("Editeaza produs");
        btnEditeazaProdus.setBounds(23, 237, 176, 53);
        panel_1.add(btnEditeazaProdus);
        btnEditeazaProdus.setRolloverEnabled(false);
        btnEditeazaProdus.setRequestFocusEnabled(false);
        btnEditeazaProdus.setForeground(Color.WHITE);
        btnEditeazaProdus.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnEditeazaProdus.setFocusable(false);
        btnEditeazaProdus.setFocusTraversalKeysEnabled(false);
        btnEditeazaProdus.setFocusPainted(false);
        btnEditeazaProdus.setBorder(null);
        btnEditeazaProdus.setBackground(new Color(0, 153, 204));

        JButton btnStergeProdus = new JButton("Sterge produs");
        btnStergeProdus.setBounds(23, 173, 176, 53);
        panel_1.add(btnStergeProdus);
        btnStergeProdus.setRolloverEnabled(false);
        btnStergeProdus.setRequestFocusEnabled(false);
        btnStergeProdus.setForeground(Color.WHITE);
        btnStergeProdus.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnStergeProdus.setFocusable(false);
        btnStergeProdus.setFocusTraversalKeysEnabled(false);
        btnStergeProdus.setFocusPainted(false);
        btnStergeProdus.setBorder(null);
        btnStergeProdus.setBackground(new Color(0, 153, 204));

        JButton btnAdaugaProdus = new JButton("Adauga produs");
        btnAdaugaProdus.setBounds(23, 109, 176, 53);
        panel_1.add(btnAdaugaProdus);
        btnAdaugaProdus.setRolloverEnabled(false);
        btnAdaugaProdus.setRequestFocusEnabled(false);
        btnAdaugaProdus.setForeground(Color.WHITE);
        btnAdaugaProdus.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnAdaugaProdus.setFocusable(false);
        btnAdaugaProdus.setFocusTraversalKeysEnabled(false);
        btnAdaugaProdus.setFocusPainted(false);
        btnAdaugaProdus.setBorder(null);
        btnAdaugaProdus.setBackground(new Color(0, 153, 204));

        txtMeniuClienti = new JTextField();
        txtMeniuClienti.setBorder(null);
        txtMeniuClienti.setFocusable(false);
        txtMeniuClienti.setFocusTraversalKeysEnabled(false);
        txtMeniuClienti.setEditable(false);
        txtMeniuClienti.setForeground(new Color(255, 255, 255));
        txtMeniuClienti.setFont(new Font("Mongolian Baiti", Font.ITALIC, 25));
        txtMeniuClienti.setBackground(new Color(0, 153, 204));
        txtMeniuClienti.setBounds(0, 0, 230, 82);
        panel_1.add(txtMeniuClienti);
        txtMeniuClienti.setHorizontalAlignment(SwingConstants.CENTER);
        txtMeniuClienti.setText("Meniu produse");
        txtMeniuClienti.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(240, 0, 504, 426);
        scrollPane.setBackground(new Color(0, 153, 204));
        panel.add(scrollPane);
        // exemplu
        table = new JTable();
        scrollPane.setViewportView(table);

        // ACTION LISTENERS BUTOANE

        // ADAUGA PRODUS
        /**
         * Se creeaza si deschide formularul pentru adaugarea unui produs.
         */
        btnAdaugaProdus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddProdusForm apf = new AddProdusForm();
                apf.getFrame().setVisible(true);
            }
        });
        // EDITEAZA PRODUS
        /**
         * Se creeaza si deschide formularul pentru editarea unui produs.
         */
        btnEditeazaProdus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditProdusForm epf = new EditProdusForm();
                epf.getFrame().setVisible(true);
            }
        });

        // STERGE CLIENT DUPA ID
        /**
         * Se deschide o fereastra in care se introduce ID-ul produsului care se doreste a fi sters.
         */
        btnStergeProdus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = (String) JOptionPane.showInputDialog(
                        frmMeniuClienti,
                        "Introduceti ID-ul produsului pe care\n" +
                                "doriti sa il stergeti!",
                        "Stergere produs",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null, ""
                );
                ProductBLL cbll = new ProductBLL();
                cbll.deleteFrom(s);
            }
        });

        // VIZUALIZARE PRODUSE
        /**
         * Se preiau produsele din baza de date si se afiseaza in JTable-ul din fereastra.
         */
        btnVizualizareProdus.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ProductBLL cbll = new ProductBLL();
                List<Product> products = cbll.findAll();
                String[] columnNames = {"ID", "Nume", "Pret", "Stoc"};
                String[][] productsString = new String[products.size()][4];
                System.out.println(products.size());
                int i = -1;
                for(Product pd: products)
                {
                    ++i;
                    productsString[i][0] = String.valueOf(pd.getId());
                    productsString[i][1] = pd.getName();
                    productsString[i][2] = String.valueOf(pd.getPrice());
                    productsString[i][3] = String.valueOf(pd.getStock());

                    System.out.println(pd.getName() + " " + pd.getPrice() + " " + pd.getStock() + " " + pd.getId());
                }
                table = new JTable(productsString, columnNames);
                scrollPane.setViewportView(table);
            }
        }));

    }
}
