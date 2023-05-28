package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Button;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clasa GUI reprezinta prima fereastra care se deschide atunci cand rulam programul.
 * Regasim 3 butoane "Client", "Comanda" si "Produs" care, la apasare, vor deschide alte
 * ferestre.
 */
public class GUI {

    private JFrame frmManagerDeComenzi;
    private JTextField txtManagerDeComenzi;

    public JFrame getFrame() {
        return this.frmManagerDeComenzi;
    }

    public GUI() {
        initialize();
    }

    /**
     * Se initializeaza fereastra principala.
     */
    private void initialize() {
        frmManagerDeComenzi = new JFrame();
        frmManagerDeComenzi.setResizable(false);
        frmManagerDeComenzi.setTitle("Manager de Comenzi");
        frmManagerDeComenzi.setBounds(100, 100, 324, 390);
        frmManagerDeComenzi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setFocusTraversalPolicyProvider(true);
        panel.setFocusable(false);
        panel.setRequestFocusEnabled(false);
        panel.setDoubleBuffered(false);
        panel.setForeground(new Color(0, 0, 0));
        panel.setBackground(new Color(0, 0, 51));
        frmManagerDeComenzi.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("Client");
        btnNewButton.setFocusable(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setFocusTraversalKeysEnabled(false);
        btnNewButton.setRolloverEnabled(false);
        btnNewButton.setRequestFocusEnabled(false);
        btnNewButton.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 153, 204));
        btnNewButton.setBorder(null);
        btnNewButton.setBounds(67, 124, 176, 53);
        panel.add(btnNewButton);

        JButton btnProdus = new JButton("Produs");
        btnProdus.setActionCommand("");
        btnProdus.setRolloverEnabled(false);
        btnProdus.setRequestFocusEnabled(false);
        btnProdus.setForeground(Color.WHITE);
        btnProdus.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnProdus.setFocusable(false);
        btnProdus.setFocusTraversalKeysEnabled(false);
        btnProdus.setFocusPainted(false);
        btnProdus.setBorder(null);
        btnProdus.setBackground(new Color(0, 153, 204));
        btnProdus.setBounds(67, 252, 176, 53);
        panel.add(btnProdus);

        JButton btnComanda = new JButton("Comanda");
        btnComanda.setRolloverEnabled(false);
        btnComanda.setRequestFocusEnabled(false);
        btnComanda.setForeground(Color.WHITE);
        btnComanda.setFont(new Font("Ebrima", Font.BOLD, 17));
        btnComanda.setFocusable(false);
        btnComanda.setFocusTraversalKeysEnabled(false);
        btnComanda.setFocusPainted(false);
        btnComanda.setBorder(null);
        btnComanda.setBackground(new Color(0, 153, 204));
        btnComanda.setActionCommand("");
        btnComanda.setBounds(67, 188, 176, 53);
        panel.add(btnComanda);

        txtManagerDeComenzi = new JTextField();
        txtManagerDeComenzi.setBorder(null);
        txtManagerDeComenzi.setFocusTraversalKeysEnabled(false);
        txtManagerDeComenzi.setFocusable(false);
        txtManagerDeComenzi.setEditable(false);
        txtManagerDeComenzi.setForeground(new Color(255, 255, 255));
        txtManagerDeComenzi.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 17));
        txtManagerDeComenzi.setBackground(new Color(0, 0, 51));
        txtManagerDeComenzi.setHorizontalAlignment(SwingConstants.CENTER);
        txtManagerDeComenzi.setText("Manager de Comenzi");
        txtManagerDeComenzi.setBounds(67, 51, 176, 46);
        panel.add(txtManagerDeComenzi);
        txtManagerDeComenzi.setColumns(10);

        // Actiuni butoane
        // Buton CLIENTI
        /**
         * Se creeaza si deschide fereastra "Meniu Clienti"
         */
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientWindow cw = new ClientWindow();
                cw.getFrame().setVisible(true);
            }
        });
        // BUTON COMANDA
        /**
         * Se creeaza si deschide fereastra "Meniu Comanda"
         */
        btnComanda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ComandaWindow comw = new ComandaWindow();
                comw.getFrame().setVisible(true);
            }
        });
        // BUTON PRODUS
        /**
         * Se creeaza si deschide fereastra "Meniu Produs"
         */
        btnProdus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProdusWindow pw = new ProdusWindow();
                pw.getFrame().setVisible(true);
            }
        });
    }
}

