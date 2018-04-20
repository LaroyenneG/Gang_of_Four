package Vue;

import Controleur.ControlBarreMenu;
import Modele.Game;
import Modele.IA;

import javax.swing.*;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class BarreMenu extends JMenuBar {

    private Game game;

    public JMenu menu, score;
    public JMenuItem nouvellePartie, menuPrincipal, quitter, regle, scorej1, scorej2, scorej3, scorej4 ;

    public BarreMenu(Game game) {

        //JMenu
        menu = new JMenu("Menu");
        menu.setActionCommand("Menu");
        score = new JMenu("Score");
        score.setActionCommand("Score");

        //JMenuItem
        nouvellePartie = new JMenuItem("Nouvelle Partie");
        nouvellePartie.setActionCommand("Nouvelle Partie");
        menuPrincipal = new JMenuItem("Menu Principal");
        menuPrincipal.setActionCommand("Menu Principal");
        quitter = new JMenuItem("Quitter");
        quitter.setActionCommand("Quitter");
        regle = new JMenuItem("Combinaison");
        regle.setActionCommand("Combinaison");

        //JMenu
        add(menu);
        add(score);

        //JMenuItem
        menu.add(nouvellePartie);
        menu.add(regle);
        menu.add(menuPrincipal);
        menu.add(quitter);

        //Affichage des Scores
        IA ia1 = (IA) game.getTabJoueur()[1];
        IA ia2 = (IA) game.getTabJoueur()[2];
        IA ia3 = (IA) game.getTabJoueur()[3];
        scorej1 = new JMenuItem("Vous : " + game.getTabJoueur()[0].getScore());
        scorej2 = new JMenuItem(ia1.getName()+": " + game.getTabJoueur()[1].getScore());
        scorej3 = new JMenuItem(ia2.getName()+": " + game.getTabJoueur()[2].getScore());
        scorej4 = new JMenuItem(ia3.getName()+": " + game.getTabJoueur()[3].getScore());

        //ScoreItem
        score.add(scorej1);
        score.add(scorej2);
        score.add(scorej3);
        score.add(scorej4);

    }

    public void setControl(ControlBarreMenu controlBarreMenu){

        //JMenu
        menu.addActionListener(controlBarreMenu);

        //JMenuItem
        nouvellePartie.addActionListener(controlBarreMenu);
        menuPrincipal.addActionListener(controlBarreMenu);
        quitter.addActionListener(controlBarreMenu);
        regle.addActionListener(controlBarreMenu);

    }

}
