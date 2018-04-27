package Vue;

import Controleur.ControlFenetreRegle;

import javax.swing.*;
import java.awt.*;

import static Vue.Fenetre.X;
import static Vue.Fenetre.Y;

/**
 * Created by Florian Vaissiere on 09/12/2016.
 */
public class FenetreRegle extends JPanel {

    public JButton retour;

    public FenetreRegle() {

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        retour = new JButton("Retour");
        retour.setActionCommand("Retour");

        add(retour);

    }

    public void setControl(ControlFenetreRegle controlFenetreRegle) {
        retour.addActionListener(controlFenetreRegle);
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Font f = new Font("Arial", Font.BOLD, 20);

        retour.setBounds((int) (5 / 30.0 * X), (int) (13 / 15.0 * Y), (int) (0.5 / 4.0 * X), (int) (0.5 / 12.0 * Y));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setForeground(Color.WHITE);
        retour.setFont(f);
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("image/Regles_Gang_Of_Four.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}

