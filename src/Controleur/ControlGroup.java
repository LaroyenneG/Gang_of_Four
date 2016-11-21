package Controleur;

import Vue.Fenetre;

import java.io.IOException;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class ControlGroup {

    public Fenetre fenetre;

    public ControlGroup() throws IOException {
        fenetre = new Fenetre();

        ControlFenetrePlateau controlFenetrePlateau = new ControlFenetrePlateau(fenetre);
    }
}