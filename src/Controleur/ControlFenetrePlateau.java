package Controleur;

import Model.Carte;
import Model.Game;
import Model.Joueur;
import Vue.Fenetre;
import Vue.FenetrePlateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class ControlFenetrePlateau extends Control implements ActionListener {

    public ControlFenetrePlateau(Fenetre fenetre, Game game){
        super(fenetre, game);
        fenetre.setControlFenetrePlateau(this);
    }
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Jouer":
                game.poseTable(game.getTabJoueur()[0].getMain());
                game.getTable();
                changerVue();
                break;
            case "Passer le Tour":
                game.passerSonTour(0);
                FenetrePlateau.passertour.setText("Tour Passé!");
                changerVue();
                break;
        }
    }
}