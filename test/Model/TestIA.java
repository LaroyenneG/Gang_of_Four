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
        Game game = new Game();
        IA ia = (IA) game.getTabJoueur()[1];
        List<Carte> table = new ArrayList<>();
        table.add(new Carte(1, Carte.Couleur.ROUGE));
        game.poseTable(table);
        ia.findBestCombinaison(game.getTable());

        Assert.assertTrue(game.joueurCanPlayCombinaison(1));
        Assert.assertEquals(game.getTabJoueur()[1].getMain().size(),16-game.getTabJoueur()[1].combinaisonEnCours.size());
    }
}
