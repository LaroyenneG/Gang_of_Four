package Controleur;

import Model.Game;
import Vue.Fenetre;

import java.io.IOException;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class ControlGroup {

    public ControlGroup(Fenetre fenetre, Game game) throws IOException { // prend la fenettre en param

        ControlFenetrePlateau controlFenetrePlateau = new ControlFenetrePlateau(fenetre, game);
        //ControlCarte controlCarte = new ControlCarte(fenetre);
        ControlFenetreAccueil controlFenetreAccueil = new ControlFenetreAccueil(fenetre, game);
        ControlFenetreCredits controlFenetreCredits = new ControlFenetreCredits(fenetre, game);
        ControlBarreMenu controlBarreMenu = new ControlBarreMenu(fenetre, game);
    }
}