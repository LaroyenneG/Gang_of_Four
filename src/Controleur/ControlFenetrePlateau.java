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
            case "Passer le Tour":
                game.passerSonTour(0);
                FenetrePlateau.passertour.setText("Tour Passé!");
                changerVue();
                break;
            case "Bouton":
                if (game.getTabJoueur()[0].peutJouer == true) {
                    FenetrePlateau.jouer.setVisible(true);
                    FenetrePlateau.annuler.setVisible(true);
                    changerVue();
                } else {
                    FenetrePlateau.jouer.setText("Votre Tour est Passé!");
                    FenetrePlateau.annuler.setText("Votre Tour est Passé!");
                    changerVue();
                }
                switch (e.getActionCommand()) {
                    case "Jouer":
                        game.poseTable(game.getTabJoueur()[0].getMain());
                        game.getTable();
                        changerVue();
                        /*}else{
                        FenetrePlateau.jouer.setText("Votre Tour est Passé!");
                        changerVue();
                        }*/
                        break;
                    case "Annuler":

                        break;
                }
                break;
        }
    }
}