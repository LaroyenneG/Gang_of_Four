package Controleur;

import Model.Carte;
import Model.Game;
import Model.Joueur;
import Vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Model.Carte.Couleur.MULTI;
import static java.lang.Thread.sleep;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class ControlFenetrePlateau extends Control implements ActionListener {
    Carte c;


    public ControlFenetrePlateau(Fenetre fenetre, Game game){
        super(fenetre, game);
        fenetre.setControlFenetrePlateau(this);
        c =null;
    }
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().contains("Carte")){
            if (game.getTabJoueur()[0].peutJouer) {

                String nombre="";

                for (int i=5;i<e.getActionCommand().length();i++){
                    nombre+=e.getActionCommand().charAt(i);
                }

                int i = Integer.valueOf(nombre);
                fenetre.panelFenetrePlateau.jouer.setVisible(true);
                fenetre.panelFenetrePlateau.annuler.setVisible(true);


                //Selection de la couleur du 1 Multicolor
                if (game.getTabJoueurIndex(0).getMain().get(i).couleur.equals(MULTI)){

                    for (int j = 0; j < 3; j++) {
                        fenetre.panelFenetrePlateau.cartesChoixMulti[j].setVisible(true);
                        fenetre.autorisationDessiner = true;
                    }
                    
                    changerVue();
                }

                if (game.getTabJoueur()[0].addCombinaisonEnCours(game.getTabJoueurIndex(0).getMain().get(i))) {
                    game.getTabJoueur()[0].getMain().remove(i);
                    game.getTabJoueur()[0].getCombinaisonEnCours();
                }


                fenetre.panelFenetrePlateau.creerBouton();

                changerVue();
            } else {
                fenetre.panelFenetrePlateau.passertour.setText("Votre Tour est Passé!");
                changerVue();
            }
        }

        if (e.getActionCommand().contains("Multi")){
            String nombre="";

            for (int i=5;i<e.getActionCommand().length();i++){
                nombre+=e.getActionCommand().charAt(i);
            }

            int i = Integer.valueOf(nombre);

            c = game.choixDeLaCouleurDuMulticolor(i);

            for (int j = 0; j < 3; j++) {
                fenetre.panelFenetrePlateau.cartesChoixMulti[j].setVisible(false);
            }

            fenetre.autorisationDessiner = false;
            fenetre.panelFenetrePlateau.jouer.setVisible(true);

            for (int k = 0; k<game.getTabJoueur()[0].getCombinaisonEnCours().size();k++)
            {
                if (game.getTabJoueur()[0].getCombinaisonEnCours().get(k).couleur.equals(MULTI))
                    game.getTabJoueur()[0].getCombinaisonEnCours().remove(k);
            }

            changerVue();
            game.getTabJoueur()[0].addCombinaisonEnCours(c);
            game.getTabJoueur()[0].combiMulti = true;
        }


        switch (e.getActionCommand()) {
            case "Passer le Tour":
                if(game.getJoueurPlay()==0) {
                    game.passerSonTour(0);
                    changerVue();
                    game.nextJoueur();
                }
                break;

            case "Jouer":

                if (game.joueurCanPlayCombinaison(0)&&game.getJoueurPlay()==0) {
                    game.clearTable();
                    game.poseTable(game.getTabJoueur()[0].getCombinaisonEnCours());

                    game.getTabJoueur()[0].clearCombinaisonEnCours();

                    changerVue();
                    game.nextJoueur();
                }

                break;

            case "Annuler":

                game.getTabJoueurIndex(0).resetCombinaison(c);
                fenetre.panelFenetrePlateau.jouer.setVisible(false);
                fenetre.panelFenetrePlateau.annuler.setVisible(false);
                changerVue();

                break;

            case "Envoyer":

                game.getTabJoueur()[0].ordoMain();
                fenetre.panelFenetrePlateau.jouer.setVisible(false);
                fenetre.panelFenetrePlateau.annuler.setVisible(false);
                fenetre.panelFenetrePlateau.envoyer.setVisible(false);
                changerVue();
                break;

        }
    }
}