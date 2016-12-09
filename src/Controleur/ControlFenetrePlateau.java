package Controleur;

import Model.Game;
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

        if(e.getActionCommand().contains("Carte")){
            if (game.getTabJoueur()[0].peutJouer) {
                int i = Integer.valueOf(String.valueOf(e.getActionCommand().charAt(5)));
                FenetrePlateau.jouer.setVisible(true);
                FenetrePlateau.annuler.setVisible(true);
                game.getTabJoueur()[0].addCombinaisonEnCours(game.getTabJoueurIndex(0).getMain().get(i));
                game.getTabJoueur()[0].main.remove(i);
                game.getTabJoueur()[0].getCombinaisonEnCours();
                fenetre.panelFenetrePlateau.creerBouton();
                changerVue();
            } else {
                FenetrePlateau.passertour.setText("Votre Tour est Passé!");
                changerVue();
            }
        }

        switch (e.getActionCommand()) {
            case "Passer le Tour":
                game.passerSonTour(0);
                FenetrePlateau.passertour.setText("Tour Passé!");
                changerVue();
                break;

            case "Jouer":
                if (game.joueurCanPlayCombinaison(0)) {
                    game.poseTable(game.getTabJoueur()[0].getCombinaisonEnCours());
                    game.getTabJoueur()[0].clearCombinaisonEnCours();
                    changerVue();
                }
                break;

            case "Annuler":
                game.getTabJoueur()[0].addALaMain(game.getTabJoueur()[0].getCombinaisonEnCours().get(0));
                game.getTabJoueur()[0].ordoMain();
                game.getTabJoueur()[0].clearCombinaisonEnCours();
                FenetrePlateau.jouer.setVisible(false);
                FenetrePlateau.annuler.setVisible(false);
                changerVue();
                break;
        }
    }
}