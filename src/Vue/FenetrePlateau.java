package Vue;

import Controleur.ControlFenetrePlateau;
import Model.Game;

import javax.swing.*;
import java.awt.*;

import static Vue.Fenetre.X;
import static Vue.Fenetre.Y;


/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class FenetrePlateau extends JPanel{

    public JButton jouer, retour;
    public Game game;

    public FenetrePlateau(Game game) { // ajout d'un game en paramètre pour récupérer les mains des joueurs
        this.game = game;

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

        retour.setBounds((int) (1 / 30.0 * X), (int) (49 / 54.0 * Y), (int) (2 / 15.0 * X), (int) (2 / 45.0 * Y));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setForeground(Color.WHITE);
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("image/fondplateau.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);


        for (int i=0; i<game.getTabJoueurIndex(0).getMain().size();i++) // on récupére la taille de la main du j1 de game
        {
            // pour chaque cartes en main
            Image imgi = getToolkit().getImage("cartes/"+game.getTabJoueurIndex(0).getMain().get(i).getFileName()); // on récup le nom de la carte
            g.drawImage(imgi, (100+(105*i)), 800, 100, 150, this); // on dessine
        }











    }
}