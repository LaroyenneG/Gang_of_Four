package Vue;

import Controleur.ControlFenetreAccueil;
import Controleur.ControlFenetrePlateau;
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
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class FenetreAccueil extends JPanel{

    public JButton jouer, credits, quitter;

    public FenetreAccueil() {

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        jouer = new JButton("Jouer");
        jouer.setActionCommand("Jouer");
        credits = new JButton("Credits");
        credits.setActionCommand("Credits");
        quitter = new JButton("Quitter");
        quitter.setActionCommand("Quitter");

        add(jouer);
        add(credits);
        add(quitter);

    }

    public void setControl(ControlFenetreAccueil controlFenetreAccueil) {
        jouer.addActionListener(controlFenetreAccueil);
        credits.addActionListener(controlFenetreAccueil);
        quitter.addActionListener(controlFenetreAccueil);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Font f=new Font("Arial", Font.BOLD, 18);

        jouer.setBounds((int) (11 / 30.0 * X), (int) (11 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setFont(f);
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);

        credits.setBounds((int) (11 / 30.0 * X), (int) (12.25 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));
        credits.setBackground(new Color(0, 0, 0, 0));
        credits.setFont(f);
        credits.setFocusable(false);
        credits.setCursor(new Cursor(Cursor.HAND_CURSOR));
        credits.setBorder(null);

        quitter.setBounds((int) (11 / 30.0 * X), (int) (13.5 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));
        quitter.setBackground(new Color(0, 0, 0, 0));
        quitter.setFont(f);
        quitter.setFocusable(false);
        quitter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quitter.setBorder(null);

        Image img = getToolkit().getImage("image/fondprinci.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}