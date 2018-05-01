package Controleur;

import Modele.Game;
import Vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Florian Vaissiere on 22/11/2016.
 */
public class ControlFenetreAccueil extends Control implements ActionListener {

    public ControlFenetreAccueil(Fenetre fenetre, Game game) {
        super(fenetre, game);
        fenetre.setControlFenetreAccueil(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Jouer":

                if (!automate.isRun()) {
                    automate.auto();
                }
                fenetre.setContentPane(fenetre.panelFenetrePlateau);

                break;

            case "Credits":
                fenetre.setContentPane(fenetre.panelFenetreCredits);
                break;

            case "Quitter":
                System.exit(0);
                break;
        }

        fenetre.barreMenu.setVisible(false);
        changerVue();
    }
}


