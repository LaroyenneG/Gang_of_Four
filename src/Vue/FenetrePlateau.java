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

    public static JButton jouer;
    public static JButton passertour;
    public static JButton annuler;
    public Game game;

    public FenetrePlateau(Game game) { // ajout d'un game en paramètre pour récupérer les mains des joueurs
        this.game = game;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        jouer = new JButton("Jouer");
        jouer.setActionCommand("Jouer");
        annuler = new JButton("Annuler");
        annuler.setActionCommand("Annuler");
        passertour = new JButton("Passer le Tour");
        passertour.setActionCommand("Passer le Tour");

        add(jouer);
        add(annuler);
        add(passertour);
    }

    public void setControl(ControlFenetrePlateau controlFenetrePlateau) {
        jouer.addActionListener(controlFenetrePlateau);
        annuler.addActionListener(controlFenetrePlateau);
        passertour.addActionListener(controlFenetrePlateau);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int posX = ((((X-200))-5*game.getTabJoueurIndex(0).getMain().size())/game.getTabJoueurIndex(0).getMain().size());

        //Bouton (11 / 30.0 * X), (int) (13.5 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));

        passertour.setBounds((int) (11 / 30.0 * X), (int) (13.5 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));
        passertour.setBackground(new Color(0, 0, 0, 0));
        passertour.setForeground(Color.WHITE);
        passertour.setFocusable(false);
        passertour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        passertour.setBorder(null);

        jouer.setBounds((int) (20 / 30.0 * X), (int) (13.5 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setForeground(Color.WHITE);
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);

        annuler.setBounds((int) (2 / 30.0 * X), (int) (13.5 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));
        annuler.setBackground(new Color(0, 0, 0, 0));
        annuler.setForeground(Color.WHITE);
        annuler.setFocusable(false);
        annuler.setCursor(new Cursor(Cursor.HAND_CURSOR));
        annuler.setBorder(null);

        //Fond

        Image img = getToolkit().getImage("image/fondplateau.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        //Cartes des autres joueurs

        Image imgJ2 = getToolkit().getImage("cartes/carteDos.jpg");
        g.drawImage(imgJ2,  (int)(X*0.1), 400, posX, (int) (posX*1.5), this);
        g.drawImage(imgJ2, (int)(X*0.85),400, posX, (int) (posX*1.5), this);
        g.drawImage(imgJ2, (X/2-(posX/2)), 100, posX, (int) (posX*1.5), this);

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));;
        g.drawString((Integer.toString(game.getTabJoueurIndex(1).getMain().size())),(int)(X*0.1)+posX,400);
        g.drawString((Integer.toString(game.getTabJoueurIndex(2).getMain().size())),(int)(X*0.85)+posX,400);
        g.drawString((Integer.toString(game.getTabJoueurIndex(3).getMain().size())),(X/2-(posX/2))+posX, 100);

        //Piles Plateau

        for (int i=0; i<game.getTable().size()-11;i++) // on récupére la taille de la main du j1 de game
        {
            // pour chaque cartes en main
            Image imgi = getToolkit().getImage("cartes/"+game.getTabJoueurIndex(0).getMain().get(i).getFileName());// on récup le nom de la carte
            g.drawImage(imgi, (650+((posX+5)*i)), (int)(Y*0.37), posX, (int) (posX*1.5), this); // on dessine
        }

        //Main du joueur

        for (int i=0; i<game.getTabJoueurIndex(0).getMain().size();i++) // on récupére la taille de la main du j1 de game
        {
            // pour chaque cartes en main
            Image imgi = getToolkit().getImage("cartes/"+game.getTabJoueurIndex(0).getMain().get(i).getFileName());// on récup le nom de la carte
            g.drawImage(imgi, (posX+((posX+5)*i)), (int)(Y*0.74), posX, (int) (posX*1.5), this); // on dessine
        }

    }
}