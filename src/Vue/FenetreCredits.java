package Vue;

import Controleur.ControlFenetreCredits;

import javax.swing.*;
import java.awt.*;

import static Vue.Fenetre.X;
import static Vue.Fenetre.Y;


/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class FenetreCredits extends JPanel {

    public JButton retour;

    public FenetreCredits() {

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        retour = new JButton("Retour");
        retour.setActionCommand("Retour");

        add(retour);

    }

    public void setControl(ControlFenetreCredits controlFenetreCredits) {
        retour.addActionListener(controlFenetreCredits);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Font f = new Font("Arial", Font.BOLD, 18);

        retour.setBounds((int) (11 / 30.0 * X), (int) (12.5 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setFont(f);
        retour.setForeground(Color.WHITE);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("image/fondcredits.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}