package Controleur;

import Vue.Fenetre;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class Control {

    Fenetre fenetre;

    protected Control(Fenetre fenetre) {

        this.fenetre = fenetre;
    }

    protected void changerVue() {
        fenetre.repaint();
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.requestFocus();
    }
}
