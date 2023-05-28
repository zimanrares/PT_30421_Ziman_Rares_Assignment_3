package GUI;

import BLL.ClientBLL;
import BLL.ProductBLL;

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
 * Clasa pentru editarea datelor unui produs. Contine patru campuri in care trebuie
 * sa introducem obligatoriu ID-ul produsului impreuna cu datele ce dorim a fi modificate.
 */
public class EditProdusForm {

    private JFrame frmEditProdusForm;
    private JTextField txtNume;
    private JTextField textField_Nume;
    private JTextField txtPrice;
    private JTextField txtStock;
    private JTextField textField_Price;
    private JTextField textField_Stoc;
    private JButton btnEdit;
    private JTextField txtID;
    private JTextField textField_ID;
    public JFrame getFrame()
    {
        return this.frmEditProdusForm;
    }

    public EditProdusForm() {
        initialize();
    }

    /**
     * Initializeaza fereastra-formular pentru editarea unui client.
     */
    private void initialize() {
        frmEditProdusForm = new JFrame();
        frmEditProdusForm.setResizable(false);
        frmEditProdusForm.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        frmEditProdusForm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        frmEditProdusForm.getContentPane().setBackground(new Color(255, 255, 255));
        frmEditProdusForm.getContentPane().setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        frmEditProdusForm.setTitle("Edit Produs Form");
        frmEditProdusForm.setBounds(100, 100, 328, 290);
        frmEditProdusForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmEditProdusForm.getContentPane().setLayout(null);

        textField_Nume = new JTextField();
        textField_Nume.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Nume.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
        textField_Nume.setBorder(null);
        textField_Nume.setBackground(Color.LIGHT_GRAY);
        textField_Nume.setBounds(136, 52, 155, 27);
        frmEditProdusForm.getContentPane().add(textField_Nume);
        textField_Nume.setColumns(10);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setBounds(0, 0, 126, 265);
        frmEditProdusForm.getContentPane().add(panel);
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

        txtStock = new JTextField();
        txtStock.setText("Stoc");
        txtStock.setHorizontalAlignment(SwingConstants.CENTER);
        txtStock.setForeground(Color.WHITE);
        txtStock.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
        txtStock.setFocusable(false);
        txtStock.setFocusTraversalKeysEnabled(false);
        txtStock.setEditable(false);
        txtStock.setColumns(10);
        txtStock.setBorder(null);
        txtStock.setBackground(new Color(0, 153, 255));
        txtStock.setBounds(0, 129, 126, 27);
        panel.add(txtStock);

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
        frmEditProdusForm.getContentPane().add(textField_Price);

        textField_Stoc = new JTextField();
        textField_Stoc.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Stoc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
        textField_Stoc.setColumns(10);
        textField_Stoc.setBorder(null);
        textField_Stoc.setBackground(Color.LIGHT_GRAY);
        textField_Stoc.setBounds(136, 130, 155, 27);
        frmEditProdusForm.getContentPane().add(textField_Stoc);

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
        frmEditProdusForm.getContentPane().add(btnEdit);

        textField_ID = new JTextField();
        textField_ID.setHorizontalAlignment(SwingConstants.CENTER);
        textField_ID.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
        textField_ID.setColumns(10);
        textField_ID.setBorder(null);
        textField_ID.setBackground(Color.LIGHT_GRAY);
        textField_ID.setBounds(136, 168, 155, 27);
        frmEditProdusForm.getContentPane().add(textField_ID);

        //ACTION LISTENERS BUTOANE
        /**
         * Editeaza clientul in baza de date pe baza datelor introduse.
         */
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nume = textField_Nume.getText();
                String price = textField_Price.getText();
                String stoc = textField_Stoc.getText();
                String id = textField_ID.getText();
                List<String> fieldNames = new LinkedList<String>();
                List<String> values = new LinkedList<String>();
                if(nume.equals("") == false)
                {
                    fieldNames.add("name");
                    values.add(nume);
                }
                if(price.equals("") == false)
                {
                    fieldNames.add("price");
                    values.add(nume);
                }
                if(stoc.equals("") == false) {
                    fieldNames.add("stock");
                    values.add(stoc);
                }
                ProductBLL cbll = new ProductBLL();
                cbll.editProduct(id, fieldNames, values);
                JOptionPane.showMessageDialog(frmEditProdusForm,
                        "Produs editat cu succes!");
                frmEditProdusForm.dispose();
            }
        });
    }
}
