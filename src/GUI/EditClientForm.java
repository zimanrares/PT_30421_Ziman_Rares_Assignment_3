package GUI;
import BLL.ClientBLL;
import Model.Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.util.LinkedList;
import java.util.List;

/**
 * Clasa pentru editarea datelor unui client. Contine patru campuri in care trebuie
 * sa introducem obligatoriu ID-ul clientului impreuna cu datele ce dorim a fi modificate.
 */
public class EditClientForm {

    private JFrame frmEditClientForm;
    private JTextField txtNume;
    private JTextField textField_Nume;
    private JTextField txtPrenume;
    private JTextField txtEmail;
    private JTextField textField_Prenume;
    private JTextField textField_Email;
    private JButton btnEdit;
    private JTextField txtID;
    private JTextField textField_ID;
    public JFrame getFrame()
    {
        return this.frmEditClientForm;
    }

    public EditClientForm() {
        initialize();
    }

    /**
     * Initializeaza fereastra-formular pentru editarea unui client.
     */
    private void initialize() {
        frmEditClientForm = new JFrame();
        frmEditClientForm.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        frmEditClientForm.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        frmEditClientForm.getContentPane().setBackground(new Color(255, 255, 255));
        frmEditClientForm.getContentPane().setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        frmEditClientForm.setTitle("Edit Client Form");
        frmEditClientForm.setResizable(false);
        frmEditClientForm.setBounds(100, 100, 328, 290);
        frmEditClientForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmEditClientForm.getContentPane().setLayout(null);

        textField_Nume = new JTextField();
        textField_Nume.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Nume.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
        textField_Nume.setBorder(null);
        textField_Nume.setBackground(Color.LIGHT_GRAY);
        textField_Nume.setBounds(136, 52, 155, 27);
        frmEditClientForm.getContentPane().add(textField_Nume);
        textField_Nume.setColumns(10);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setBounds(0, 0, 126, 265);
        frmEditClientForm.getContentPane().add(panel);
        panel.setLayout(null);

        txtNume = new JTextField();
        txtNume.setBounds(0, 51, 126, 27);
        panel.add(txtNume);
        txtNume.setBorder(null);
        txtNume.setFocusable(false);
        txtNume.setFocusTraversalKeysEnabled(false);
        txtNume.setEditable(false);
        txtNume.setForeground(new Color(255, 255, 255));
        txtNume.setBackground(new Color(0, 153, 255));
        txtNume.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
        txtNume.setHorizontalAlignment(SwingConstants.CENTER);
        txtNume.setText("Nume");
        txtNume.setColumns(10);

        txtPrenume = new JTextField();
        txtPrenume.setText("Prenume");
        txtPrenume.setHorizontalAlignment(SwingConstants.CENTER);
        txtPrenume.setForeground(Color.WHITE);
        txtPrenume.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
        txtPrenume.setFocusable(false);
        txtPrenume.setFocusTraversalKeysEnabled(false);
        txtPrenume.setEditable(false);
        txtPrenume.setColumns(10);
        txtPrenume.setBorder(null);
        txtPrenume.setBackground(new Color(0, 153, 255));
        txtPrenume.setBounds(0, 91, 126, 27);
        panel.add(txtPrenume);

        txtEmail = new JTextField();
        txtEmail.setText("Email");
        txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmail.setForeground(Color.WHITE);
        txtEmail.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
        txtEmail.setFocusable(false);
        txtEmail.setFocusTraversalKeysEnabled(false);
        txtEmail.setEditable(false);
        txtEmail.setColumns(10);
        txtEmail.setBorder(null);
        txtEmail.setBackground(new Color(0, 153, 255));
        txtEmail.setBounds(0, 129, 126, 27);
        panel.add(txtEmail);

        txtID = new JTextField();
        txtID.setText("ID");
        txtID.setHorizontalAlignment(SwingConstants.CENTER);
        txtID.setForeground(Color.WHITE);
        txtID.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
        txtID.setFocusable(false);
        txtID.setFocusTraversalKeysEnabled(false);
        txtID.setEditable(false);
        txtID.setColumns(10);
        txtID.setBorder(null);
        txtID.setBackground(new Color(0, 153, 255));
        txtID.setBounds(0, 167, 126, 27);
        panel.add(txtID);

        textField_Prenume = new JTextField();
        textField_Prenume.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Prenume.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
        textField_Prenume.setColumns(10);
        textField_Prenume.setBorder(null);
        textField_Prenume.setBackground(Color.LIGHT_GRAY);
        textField_Prenume.setBounds(136, 92, 155, 27);
        frmEditClientForm.getContentPane().add(textField_Prenume);

        textField_Email = new JTextField();
        textField_Email.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Email.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
        textField_Email.setColumns(10);
        textField_Email.setBorder(null);
        textField_Email.setBackground(Color.LIGHT_GRAY);
        textField_Email.setBounds(136, 130, 155, 27);
        frmEditClientForm.getContentPane().add(textField_Email);

        btnEdit = new JButton("Edit");
        btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnEdit.setRolloverEnabled(false);
        btnEdit.setRequestFocusEnabled(false);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnEdit.setFocusable(false);
        btnEdit.setFocusTraversalKeysEnabled(false);
        btnEdit.setFocusPainted(false);
        btnEdit.setBorder(null);
        btnEdit.setBackground(new Color(0, 153, 204));
        btnEdit.setBounds(202, 206, 89, 34);
        frmEditClientForm.getContentPane().add(btnEdit);

        textField_ID = new JTextField();
        textField_ID.setHorizontalAlignment(SwingConstants.CENTER);
        textField_ID.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
        textField_ID.setColumns(10);
        textField_ID.setBorder(null);
        textField_ID.setBackground(Color.LIGHT_GRAY);
        textField_ID.setBounds(136, 168, 155, 27);
        frmEditClientForm.getContentPane().add(textField_ID);

        //ACTION LISTENERS BUTOANE
        /**
         * Editeaza clientul in baza de date pe baza datelor introduse.
         */
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nume = textField_Nume.getText();
                String prenume = textField_Prenume.getText();
                String email = textField_Email.getText();
                String id = textField_ID.getText();
                List<String> fieldNames = new LinkedList<String>();
                List<String> values = new LinkedList<String>();
                if(nume.equals("") == false)
                {
                    fieldNames.add("name");
                    values.add(nume);
                }
                if(prenume.equals("") == false)
                {
                    fieldNames.add("prenume");
                    values.add(nume);
                }
                if(email.equals("") == false) {
                    fieldNames.add("email");
                    values.add(email);
                }
                ClientBLL cbll = new ClientBLL();
                cbll.editClient(id, fieldNames, values);
                JOptionPane.showMessageDialog(frmEditClientForm,
                        "Client editat cu succes!");
                frmEditClientForm.dispose();
            }
        });
    }
}
