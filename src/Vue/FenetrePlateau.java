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

    public JButton jouer;
    public static JButton passertour;
    public Game game;

    public FenetrePlateau(Game game) { // ajout d'un game en paramètre pour récupérer les mains des joueurs
        this.game = game;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        jouer = new JButton("Jouer");
        jouer.setActionCommand("Jouer");
        passertour = new JButton("Passer le Tour");
        passertour.setActionCommand("Passer le Tour");

        add(jouer);
        add(passertour);
    }

    public void setControl(ControlFenetrePlateau controlFenetrePlateau) {
        jouer.addActionListener(controlFenetrePlateau);
        passertour.addActionListener(controlFenetrePlateau);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        passertour.setBounds((int) (11 / 30.0 * X), (int) (13.5 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));
        passertour.setBackground(new Color(0, 0, 0, 0));
        passertour.setForeground(Color.WHITE);
        passertour.setFocusable(false);
        passertour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        passertour.setBorder(null);

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