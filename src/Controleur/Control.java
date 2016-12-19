package Controleur;

import Model.Game;
import Vue.Fenetre;

import static java.lang.Thread.sleep;

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
    }

}
