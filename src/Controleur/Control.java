package Controleur;

import Model.Game;
import Model.IA;
import Vue.Fenetre;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public abstract class Control {

    protected Fenetre fenetre;
    protected Game game;

    protected Automate automate;


    public Control(Fenetre fenetre, Game game) {
        this.fenetre = fenetre;
        this.game = game;
        automate=new Automate(this);
    }

    protected void changerVue() {
        fenetre.repaint();
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.requestFocus();
        IA ia1 = (IA) game.getTabJoueur()[1];
        IA ia2 = (IA) game.getTabJoueur()[2];
        IA ia3 = (IA) game.getTabJoueur()[3];
        fenetre.barreMenu.scorej1.setText("Vous : "  + game.getTabJoueur()[0].getScore());
        fenetre.barreMenu.scorej2.setText(ia1.getName()+": " + game.getTabJoueur()[1].getScore());
        fenetre.barreMenu.scorej3.setText(ia2.getName()+": " + game.getTabJoueur()[2].getScore());
        fenetre.barreMenu.scorej4.setText(ia3.getName()+": " + game.getTabJoueur()[3].getScore());
        if(game.getTabJoueurIndex(0).peutJouer){
            fenetre.panelFenetrePlateau.passertour.setText("Passer le tour");
        }else {
            fenetre.panelFenetrePlateau.passertour.setText("Tour Passé!");
        }
    }

}
