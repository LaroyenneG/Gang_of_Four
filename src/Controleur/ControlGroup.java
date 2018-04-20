package Controleur;

import Modele.Game;
import Vue.Fenetre;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class ControlGroup {

    public ControlGroup(Fenetre fenetre, Game game) { // prend la fenettre en param

        ControlFenetrePlateau controlFenetrePlateau = new ControlFenetrePlateau(fenetre, game);
        ControlFenetreAccueil controlFenetreAccueil = new ControlFenetreAccueil(fenetre, game);
        ControlFenetreCredits controlFenetreCredits = new ControlFenetreCredits(fenetre, game);
        ControlFenetreRegle controlFenetreRegle = new ControlFenetreRegle(fenetre, game);
        ControlBarreMenu controlBarreMenu = new ControlBarreMenu(fenetre, game);

    }
}