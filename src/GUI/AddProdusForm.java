package GUI;


import BLL.ClientBLL;
import BLL.ProductBLL;
import Model.Product;

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
 * Clasa AddProdusForm reprezinta formularul de adaugarea al unui produs.
 * In textFieldurile prezente se vor introduce datele cerute.
 */
public class AddProdusForm {

    private JFrame frmAddProdusForm;
    private JTextField txtNume;
    private JTextField textField_Nume;
    private JTextField txtPrice;
    private JTextField txtStoc;
    private JTextField textField_Price;
    private JTextField textField_Stoc;
    private JButton btnOk;
    private JTextField txtID;
    private JTextField textField_ID;
    public JFrame getFrame()
    {
        return this.frmAddProdusForm;
    }


    public AddProdusForm() {
        initialize();
    }

    /**
     * Initializeaza formularul pentru adaugarea produsului.
     */
    private void initialize() {
        frmAddProdusForm = new JFrame();
        frmAddProdusForm.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        frmAddProdusForm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        frmAddProdusForm.getContentPane().setBackground(new Color(255, 255, 255));
        frmAddProdusForm.getContentPane().setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        frmAddProdusForm.setTitle("Add Produs Form");
        frmAddProdusForm.setResizable(false);
        frmAddProdusForm.setBounds(100, 100, 328, 290);
        frmAddProdusForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmAddProdusForm.getContentPane().setLayout(null);

        textField_Nume = new JTextField();
        textField_Nume.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Nume.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
        textField_Nume.setBorder(null);
        textField_Nume.setBackground(Color.LIGHT_GRAY);
        textField_Nume.setBounds(136, 52, 155, 27);
        frmAddProdusForm.getContentPane().add(textField_Nume);
        textField_Nume.setColumns(10);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setBounds(0, 0, 126, 265);
        frmAddProdusForm.getContentPane().add(panel);
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

        txtPrice = new JTextField();
        txtPrice.setText("Pret");
        txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
        txtPrice.setForeground(Color.WHITE);
        txtPrice.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
        txtPrice.setFocusable(false);
        txtPrice.setFocusTraversalKeysEnabled(false);
        txtPrice.setEditable(false);
        txtPrice.setColumns(10);
        txtPrice.setBorder(null);
        txtPrice.setBackground(new Color(0, 153, 255));
        txtPrice.setBounds(0, 91, 126, 27);
        panel.add(txtPrice);

        txtStoc = new JTextField();
        txtStoc.setText("Stoc");
        txtStoc.setHorizontalAlignment(SwingConstants.CENTER);
        txtStoc.setForeground(Color.WHITE);
        txtStoc.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
        txtStoc.setFocusable(false);
        txtStoc.setFocusTraversalKeysEnabled(false);
        txtStoc.setEditable(false);
        txtStoc.setColumns(10);
        txtStoc.setBorder(null);
        txtStoc.setBackground(new Color(0, 153, 255));
        txtStoc.setBounds(0, 129, 126, 27);
        panel.add(txtStoc);

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

        textField_Price = new JTextField();
        textField_Price.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Price.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
        textField_Price.setColumns(10);
        textField_Price.setBorder(null);
        textField_Price.setBackground(Color.LIGHT_GRAY);
        textField_Price.setBounds(136, 92, 155, 27);
        frmAddProdusForm.getContentPane().add(textField_Price);

        textField_Stoc = new JTextField();
        textField_Stoc.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Stoc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
        textField_Stoc.setColumns(10);
        textField_Stoc.setBorder(null);
        textField_Stoc.setBackground(Color.LIGHT_GRAY);
        textField_Stoc.setBounds(136, 130, 155, 27);
        frmAddProdusForm.getContentPane().add(textField_Stoc);

        btnOk = new JButton("OK");
        btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnOk.setRolloverEnabled(false);
        btnOk.setRequestFocusEnabled(false);
        btnOk.setForeground(Color.WHITE);
        btnOk.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnOk.setFocusable(false);
        btnOk.setFocusTraversalKeysEnabled(false);
        btnOk.setFocusPainted(false);
        btnOk.setBorder(null);
        btnOk.setBackground(new Color(0, 153, 204));
        btnOk.setBounds(211, 200, 80, 40);
        frmAddProdusForm.getContentPane().add(btnOk);

        textField_ID = new JTextField();
        textField_ID.setHorizontalAlignment(SwingConstants.CENTER);
        textField_ID.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
        textField_ID.setColumns(10);
        textField_ID.setBorder(null);
        textField_ID.setBackground(Color.LIGHT_GRAY);
        textField_ID.setBounds(136, 168, 155, 27);
        frmAddProdusForm.getContentPane().add(textField_ID);

        //ACTION LISTENERS BUTOANE

        // OK
        /**
         * Adauga produsul in baza de date la apasarea butonului "OK"!.
         */
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = textField_ID.getText();
                String nume = textField_Nume.getText();
                String pret = textField_Price.getText();
                String stoc = textField_Stoc.getText();
                ProductBLL cl = new ProductBLL();
                List<String> args = new LinkedList<String>();
                args.add(id);
                args.add(nume);
                args.add(pret);
                args.add(stoc);
                cl.insertInto(args);
                JOptionPane.showMessageDialog(frmAddProdusForm,
                        "Produs adaugat cu succes!");
                frmAddProdusForm.dispose();
            }
        });
    }
}
