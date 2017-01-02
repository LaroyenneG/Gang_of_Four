package Controleur;

import Model.Game;
import Model.Joueur;
import Vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class ControlBarreMenu extends Control implements ActionListener {

    public ControlBarreMenu(Fenetre fenetre, Game game){
        super(fenetre, game);
        fenetre.setControlBarreMenu(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Nouvelle Partie":
                fenetre.getContentPane().removeAll();
                game.clearTable();
                game.distribuerCarte();
                game.getTabJoueur()[0].ordoMain();
                game.getTabJoueur()[1].ordoMain();
                game.getTabJoueur()[2].ordoMain();
                game.getTabJoueur()[3].ordoMain();
                fenetre.setContentPane(fenetre.panelFenetrePlateau);
                fenetre.barreMenu.setVisible(true);
                changerVue();
                automate.auto();
                break;

            case "Menu Principal":
                fenetre.setContentPane(fenetre.panelFenetreAccueil);
                fenetre.barreMenu.setVisible(false);
                changerVue();
                break;

            case "Quitter":
                System.exit(0);
                break;

            case "Combinaison":
                fenetre.setContentPane(fenetre.panelFenetreRegle);
                changerVue();
                break;
        }
    }
}