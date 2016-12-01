package Controleur;

import Model.Game;
import Vue.Fenetre;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class Control {

    Fenetre fenetre;
    Game game;

    protected Control(Fenetre fenetre, Game game) {

        this.fenetre = fenetre;
        this.game = game;
    }

    protected void changerVue() {
        fenetre.repaint();
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.requestFocus();
    }
}
