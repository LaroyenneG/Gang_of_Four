package Controleur;

import Model.Game;
import Vue.Fenetre;

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
                fenetre.panelFenetrePlateau.jouer.setVisible(true);
                fenetre.panelFenetrePlateau.annuler.setVisible(true);
                fenetre.panelFenetrePlateau.envoyer.setVisible(true);

                //Selection de la couleur du 1 Multicolor
                if (game.getTabJoueurIndex(0).getMain().get(i) == game.getTabJoueurIndex(0).getMain().get(0)){

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

                //Suppression et création des boutons représentant les cartes
                /*if (fenetre.panelFenetrePlateau.cartesMain.length > 0) {
                    fenetre.panelFenetrePlateau.supprimerBouton();
                }*/

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

            System.out.println("coucou");
            System.out.println(game.getTabJoueur()[0].addCombinaisonEnCours(game.choixDeLaCouleurDuMulticolor(i)));
            System.out.println(game.choixDeLaCouleurDuMulticolor(i));


        }


        switch (e.getActionCommand()) {
            case "Passer le Tour":
                game.passerSonTour(0);
                changerVue();
                game.nextJoueur();
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
                game.getTabJoueurIndex(0).resetCombinaison();
                fenetre.panelFenetrePlateau.creerBouton();
                fenetre.panelFenetrePlateau.jouer.setVisible(false);
                fenetre.panelFenetrePlateau.annuler.setVisible(false);
                changerVue();
                break;

            case "Envoyer":
                if (game.siGagne(0)){

                    if(game.getTabJoueur()[0].getCombinaisonEnCours().size()==1){
                        int i =0;
                        game.donDeLaCarteNulle(game.getTabJoueur()[0].getCombinaisonEnCours().get(i));
                        game.getTabJoueur()[0].clearCombinaisonEnCours();
                        game.donDeLaMeilleurCarte();
                    }else{
                        fenetre.panelFenetrePlateau.envoyer.setText("Trop de Carte!");
                    }
                }
                game.getTabJoueur()[0].ordoMain();
                fenetre.panelFenetrePlateau.jouer.setVisible(false);
                fenetre.panelFenetrePlateau.annuler.setVisible(false);
                fenetre.panelFenetrePlateau.envoyer.setVisible(false);
                changerVue();
                break;
        }
    }
}