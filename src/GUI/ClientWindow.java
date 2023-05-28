package GUI;

import BLL.ClientBLL;
import Model.Client;

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
import javax.swing.table.DefaultTableColumnModel;

/**
 *  Clasa ClientWindow - reprezinta fereastra pentru meniul de clienti pe care se
 *  regasesc butoane pentru:
 *  -adaugarea unui client
 *  -stergerea unui client
 *  -editarea unui client
 *  -vizualizarea clientilor.
 */
public class ClientWindow {

    private JFrame frmMeniuClienti;
    private JTextField txtMeniuClienti;
    private JTable table;


    public JFrame getFrame()
    {
        return this.frmMeniuClienti;
    }

    public ClientWindow() {
        initialize();
    }

    /**
     * Se initializeaza frame-ul pentru fereastra meniului de clienti.
     */
    private void initialize() {
        frmMeniuClienti = new JFrame();
        frmMeniuClienti.setTitle("Meniu clienti");
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

        JButton btnVizualizareClienti = new JButton("Vizualizare clienti");
        btnVizualizareClienti.setBounds(23, 301, 176, 53);
        panel_1.add(btnVizualizareClienti);
        btnVizualizareClienti.setRolloverEnabled(false);
        btnVizualizareClienti.setRequestFocusEnabled(false);
        btnVizualizareClienti.setForeground(Color.WHITE);
        btnVizualizareClienti.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnVizualizareClienti.setFocusable(false);
        btnVizualizareClienti.setFocusTraversalKeysEnabled(false);
        btnVizualizareClienti.setFocusPainted(false);
        btnVizualizareClienti.setBorder(null);
        btnVizualizareClienti.setBackground(new Color(0, 153, 204));

        JButton btnEditeazaClient = new JButton("Editeaza client");
        btnEditeazaClient.setBounds(23, 237, 176, 53);
        panel_1.add(btnEditeazaClient);
        btnEditeazaClient.setRolloverEnabled(false);
        btnEditeazaClient.setRequestFocusEnabled(false);
        btnEditeazaClient.setForeground(Color.WHITE);
        btnEditeazaClient.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnEditeazaClient.setFocusable(false);
        btnEditeazaClient.setFocusTraversalKeysEnabled(false);
        btnEditeazaClient.setFocusPainted(false);
        btnEditeazaClient.setBorder(null);
        btnEditeazaClient.setBackground(new Color(0, 153, 204));

        JButton btnStergeClient = new JButton("Sterge client");
        btnStergeClient.setBounds(23, 173, 176, 53);
        panel_1.add(btnStergeClient);
        btnStergeClient.setRolloverEnabled(false);
        btnStergeClient.setRequestFocusEnabled(false);
        btnStergeClient.setForeground(Color.WHITE);
        btnStergeClient.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnStergeClient.setFocusable(false);
        btnStergeClient.setFocusTraversalKeysEnabled(false);
        btnStergeClient.setFocusPainted(false);
        btnStergeClient.setBorder(null);
        btnStergeClient.setBackground(new Color(0, 153, 204));

        JButton btnAdaugaClient = new JButton("Adauga client");
        btnAdaugaClient.setBounds(23, 109, 176, 53);
        panel_1.add(btnAdaugaClient);
        btnAdaugaClient.setRolloverEnabled(false);
        btnAdaugaClient.setRequestFocusEnabled(false);
        btnAdaugaClient.setForeground(Color.WHITE);
        btnAdaugaClient.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnAdaugaClient.setFocusable(false);
        btnAdaugaClient.setFocusTraversalKeysEnabled(false);
        btnAdaugaClient.setFocusPainted(false);
        btnAdaugaClient.setBorder(null);
        btnAdaugaClient.setBackground(new Color(0, 153, 204));

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
        txtMeniuClienti.setText("Meniu clienti");
        txtMeniuClienti.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(240, 0, 504, 426);
        scrollPane.setBackground(new Color(0, 153, 204));
        panel.add(scrollPane);

        //
        table = new JTable();
        scrollPane.setViewportView(table);
        // ACTION LISTENERS BUTOANE

        // ADAUGA CLIENT
        /**
         * Se creeaza si deschide formularul pentru adaugarea unui client.
         */
        btnAdaugaClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddClientForm addClientForm = new AddClientForm();
                addClientForm.getFrame().setVisible(true);
            }
        });
        // STERGE CLIENT DUPA ID
        /**
         * Se deschide o fereastra in care se introduce ID-ul clientului care se doreste a fi sters.
         */
        btnStergeClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = (String)JOptionPane.showInputDialog(
                        frmMeniuClienti,
                        "Introduceti ID-ul clientului pe care\n" +
                                "doriti sa il stergeti!",
                        "Stergere client",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null, ""
                        );
                ClientBLL cbll = new ClientBLL();
                cbll.deleteFrom(s);
            }
        });
        // EDITARE CLIENTI
        /**
         * Se creeaza si deschide formularul pentru editarea unui client.
         */
        btnEditeazaClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditClientForm ecf = new EditClientForm();
                ecf.getFrame().setVisible(true);
            }
        });

        // VIZUALIZARE CLIENTI
        /**
         * Se preiau clientii din baza de date si se afiseaza in JTable-ul din fereastra.
         */
        btnVizualizareClienti.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ClientBLL  cbll = new ClientBLL();
                List<Client> clients = cbll.findAll();
                String[] columnNames = {"ID", "Nume", "Prenume", "Email"};
                String[][] clientsString = new String[clients.size()][4];
                System.out.println(clients.size());
                int i = -1;
                for(Client cl: clients)
                {
                    ++i;
                    clientsString[i][1] = cl.getName();
                    clientsString[i][2] = cl.getPrenume();
                    clientsString[i][3] = cl.getEmail();
                    clientsString[i][0] = String.valueOf(cl.getId());

                    System.out.println(cl.getName() + " " + cl.getPrenume() + " " + cl.getEmail() + " " + cl.getId());
                }
                table = new JTable(clientsString, columnNames);
                scrollPane.setViewportView(table);
            }
        }));
    }
}

