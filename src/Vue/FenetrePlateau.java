package Vue;

import Controleur.ControlFenetrePlateau;
import Model.Carte;

import javax.swing.*;
import java.awt.*;

import static Vue.Fenetre.X;
import static Vue.Fenetre.Y;


/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class FenetrePlateau extends JPanel{

    public JButton jouer, retour;

    public FenetrePlateau() {

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        jouer = new JButton("Jouer");
        jouer.setActionCommand("Jouer");
        retour = new JButton("Retour");
        retour.setActionCommand("Retour");

        add(jouer);
        add(retour);

    }

    public void setControl(ControlFenetrePlateau controlFenetrePlateau) {
        jouer.addActionListener(controlFenetrePlateau);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Model.Carte carte1 = new Carte(1,Carte.Couleur.ROUGE);
        String nomimage = carte1.getFileName();

        retour.setBounds((int) (1 / 30.0 * X), (int) (49 / 54.0 * Y), (int) (2 / 15.0 * X), (int) (2 / 45.0 * Y));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("cartes/fond.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        Image imgi = getToolkit().getImage("cartes/"+ nomimage);
        g.drawImage(imgi, 200, 800, 100, 150, this);
    }
}