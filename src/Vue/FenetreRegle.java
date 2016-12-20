package Vue;

import Controleur.ControlFenetreAccueil;
import Controleur.ControlFenetreCredits;
import Controleur.ControlFenetrePlateau;
import Controleur.ControlFenetreRegle;
import Model.*;
import Model.Carte;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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

        retour.setBounds((int) (11 / 30.0 * X), (int) (12.5 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("image/Regles_Gang_Of_Four.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}

