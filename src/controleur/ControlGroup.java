package controleur;

import model.Jeu;
import vue.Fenetre;

import java.io.IOException;

/**
 * Created by bastien on 28/09/16.
 */

public class ControlGroup {

    public Fenetre fenetre;

    public ControlGroup(Jeu jeu) throws IOException {
        fenetre = new Fenetre();

        ControlFenetrePlateau controlFenetrePlateau = new ControlFenetrePlateau();
    }
}