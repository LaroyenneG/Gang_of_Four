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
        retour.addActionListener(controlFenetrePlateau);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Model.Carte carte1 = new Carte(1,Carte.Couleur.ROUGE);
        String nomimage = carte1.getFileName();

        Model.Carte carte2 = new Carte(Carte.Couleur.MULTI);
        String nomimage1 = carte2.getFileName();

        Model.Carte carte3 = new Carte(Carte.Figure.DRAGON,Carte.Couleur.ROUGE);
        String nomimage2 = carte3.getFileName();

        Model.Carte carte4 = new Carte(Carte.Figure.PHENIX,Carte.Couleur.VERT);
        String nomimage3 = carte4.getFileName();

        Model.Carte carte5 = new Carte(10,Carte.Couleur.JAUNE);
        String nomimage4 = carte5.getFileName();

        Model.Carte carte6 = new Carte(8,Carte.Couleur.JAUNE);
        String nomimage5 = carte6.getFileName();

        retour.setBounds((int) (1 / 30.0 * X), (int) (49 / 54.0 * Y), (int) (2 / 15.0 * X), (int) (2 / 45.0 * Y));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setForeground(Color.WHITE);
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("image/fondplateau.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        Image imgi = getToolkit().getImage("cartes/"+ nomimage);
        g.drawImage(imgi, 200, 800, 100, 150, this);

        Image imgi1 = getToolkit().getImage("cartes/"+ nomimage1);
        g.drawImage(imgi1, 325, 800, 100, 150, this);

        Image imgi2 = getToolkit().getImage("cartes/"+ nomimage2);
        g.drawImage(imgi2, 450, 800, 100, 150, this);

        Image imgi3 = getToolkit().getImage("cartes/"+ nomimage3);
        g.drawImage(imgi3, 575, 800, 100, 150, this);

        Image imgi4 = getToolkit().getImage("cartes/"+ nomimage4);
        g.drawImage(imgi4, 700, 800, 100, 150, this);

        Image imgi5 = getToolkit().getImage("cartes/"+ nomimage5);
        g.drawImage(imgi5, 825, 800, 100, 150, this);


    }
}