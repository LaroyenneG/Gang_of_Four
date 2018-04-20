import Controleur.ControlGroup;
import Modele.Game;
import Vue.Fenetre;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class Appli {
    public static void main(String[] args) {

        Game game = new Game(); // creation du game
        Fenetre fenetre = new Fenetre(game); // creation de la fenetre
        ControlGroup controlGroup = new ControlGroup(fenetre, game); // on passe la fennetre au controlGroup
    }
}
