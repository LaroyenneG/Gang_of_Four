package Controleur;

import Vue.Fenetre;

import java.io.IOException;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class ControlGroup {



    public ControlGroup(Fenetre fenetre) throws IOException { // prend la fenettre en param


        ControlFenetrePlateau controlFenetrePlateau = new ControlFenetrePlateau(fenetre);
        //ControlCarte controlCarte = new ControlCarte(fenetre);
        ControlFenetreAccueil controlFenetreAccueil = new ControlFenetreAccueil(fenetre);
    }
}