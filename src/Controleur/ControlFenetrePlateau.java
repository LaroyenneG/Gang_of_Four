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

                String nombre="";

                for (int i=5;i<e.getActionCommand().length();i++){
                    nombre+=e.getActionCommand().charAt(i);
                }

                int i = Integer.valueOf(nombre);
                FenetrePlateau.jouer.setVisible(true);
                FenetrePlateau.annuler.setVisible(true);

                if (game.getTabJoueur()[0].addCombinaisonEnCours(game.getTabJoueurIndex(0).getMain().get(i))) {
                    game.getTabJoueur()[0].main.remove(i);
                    game.getTabJoueur()[0].getCombinaisonEnCours();
                }

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
                    game.clearTable();
                    game.poseTable(game.getTabJoueur()[0].getCombinaisonEnCours());
                    game.getTabJoueur()[0].clearCombinaisonEnCours();
                    changerVue();
                }
                break;

            case "Annuler":
                for(int i=0; i<game.getTabJoueur()[0].getCombinaisonEnCours().size();i++){
                    game.getTabJoueur()[0].addALaMain(game.getTabJoueur()[0].getCombinaisonEnCours().get(i));
                }
                fenetre.panelFenetrePlateau.creerBouton();
                game.getTabJoueur()[0].clearCombinaisonEnCours();
                game.getTabJoueur()[0].ordoMain();
                FenetrePlateau.jouer.setVisible(false);
                FenetrePlateau.annuler.setVisible(false);
                changerVue();
                break;
        }
    }
}