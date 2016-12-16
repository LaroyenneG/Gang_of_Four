package Vue;

import Controleur.ControlBarreMenu;
import Model.Game;

import javax.swing.*;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class BarreMenu extends JMenuBar {

    private Game game;

    public JMenu menu, scorej1, scorej2, scorej3, scorej4;
    public JMenuItem nouvellePartie, menuPrincipal, quitter, regle ;

    public BarreMenu(Game game) {

        //JMenu
        menu = new JMenu("Menu");
        menu.setActionCommand("Menu");

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

        //JMenuItem
        menu.add(nouvellePartie);
        menu.add(regle);
        menu.add(menuPrincipal);
        menu.add(quitter);
    }

    /*public void score() {
        scorej1 = new JMenu("" + game.getTabJoueur()[0].getScore());

        scorej2 = new JMenu("" + game.getTabJoueur()[1].getScore());

        scorej3 = new JMenu("" + game.getTabJoueur()[2].getScore());

        scorej4 = new JMenu("" + game.getTabJoueur()[3].getScore());
        add(scorej1);
        add(scorej2);
        add(scorej3);
        add(scorej4);

    }*/

    public void setControl(ControlBarreMenu controlBarreMenu){

        //JMenu
        menu.addActionListener(controlBarreMenu);

        //JMenuItem
        nouvellePartie.addActionListener(controlBarreMenu);
        menuPrincipal.addActionListener(controlBarreMenu);
        quitter.addActionListener(controlBarreMenu);
        regle.addActionListener(controlBarreMenu);

        /*scorej1.setText("" + game.getTabJoueur()[0].getScore());
        scorej2.setText("" + game.getTabJoueur()[1].getScore());
        scorej3.setText("" + game.getTabJoueur()[2].getScore());
        scorej4.setText("" + game.getTabJoueur()[3].getScore());

        scorej1.repaint();
        scorej2.repaint();
        scorej3.repaint();
        scorej4.repaint();*/

    }

}
