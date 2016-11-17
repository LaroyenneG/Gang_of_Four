import controleur.ControlGroup;
import model.Jeu;
import vue.Fenetre;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by bastien on 22/09/16.
 */

public class Appli {

    public static void main(String[] args) throws IOException, SQLException {

        Jeu jeu = new Jeu();
        ControlGroup controlGroup = new ControlGroup(jeu);
    }
}