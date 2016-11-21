package Vue;

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
public class FenetrePlateau extends JPanel{

    public JButton jouer;

    public FenetrePlateau() {

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        jouer = new JButton("Jouer");
        jouer.setActionCommand("Jouer");


        add(jouer);

    }

    public void setControl(ControlFenetrePlateau controlFenetrePlateau) {
        jouer.addActionListener(controlFenetrePlateau);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Model.Carte carte1 = new Carte(1,Carte.Couleur.ROUGE);
        String nomimage = carte1.getFileName();

        Image imgi = getToolkit().getImage("cartes/"+ nomimage);
        g.drawImage(imgi, 300, 100, 400, 600, this);

        jouer.setBounds((int) (13 / 20.0 * X), (int) (27 / 40.0 * Y), (int) (5 / 24.0 * X), (int) (1 / 20.0 * Y));
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);


        //Image img = getToolkit().getImage("cartes/fond.jpg");
        //g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}