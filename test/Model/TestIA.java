package Model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guillaume on 10/12/16.
 */
public class TestIA {
    @Test
    public void testFindBestCombinaison(){
        for(int t=0; t<1000; t++){
            Game game = new Game();
            IA ia = (IA) game.getTabJoueur()[1];
            List<Carte> table = new ArrayList<>();
            table.add(new Carte(1, Carte.Couleur.VERT));
            game.poseTable(table);
            ia.findBestCombinaison(game.getTable());

            Assert.assertTrue(game.joueurCanPlayCombinaison(1));
            for (int i=0; i<game.getTabJoueur()[1].combinaisonEnCours.size();i++){
                Assert.assertNotEquals(game.getTabJoueur()[1].combinaisonEnCours.get(i), new Carte(Carte.Couleur.MULTI));
            }

            Assert.assertEquals(game.getTabJoueur()[1].getMain().size(),16-game.getTabJoueur()[1].combinaisonEnCours.size());
        }
    }
}
