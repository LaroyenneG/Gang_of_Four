import Controleur.ControlGroup;
import Model.Game;
import Vue.Fenetre;

import java.io.IOException;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class Appli {
    public static void main(String[] args) throws IOException {

        Game game = new Game(); // creation du game
        Fenetre fenetre = new Fenetre(game); // creation de la fenetre
        ControlGroup controlGroup = new ControlGroup(fenetre); // on passe la fennetre au controlGroup
    }
}
