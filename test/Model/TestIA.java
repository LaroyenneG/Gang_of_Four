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

        for(int t=0; t<100; t++){
            Game game = new Game();
            IA ia = (IA) game.getTabJoueur()[1];
            List<Carte> table = new ArrayList<>();
            table.add(new Carte(1, Carte.Couleur.VERT));
            game.poseTable(table);

            Assert.assertTrue(game.playerHasAnPossibilityToPlay(1));
            ia.findBestCombinaison(game.getTable());
            Assert.assertTrue(game.joueurCanPlayCombinaison(1));
        }


        for(int t=0; t<100; t++){
            Game game = new Game();
            IA ia = (IA) game.getTabJoueur()[1];
            List<Carte> table = new ArrayList<>();
            table.add(new Carte(1, Carte.Couleur.VERT));
            table.add(new Carte(1, Carte.Couleur.VERT));
            game.poseTable(table);


            if(game.playerHasAnPossibilityToPlay(1)){
                ia.findBestCombinaison(game.getTable());

                if(!game.joueurCanPlayCombinaison(1)){
                    System.err.println("Anomaly :");

                    System.out.println(game.getTabJoueur()[1].getCombinaisonEnCours());
                }
                Assert.assertTrue(game.joueurCanPlayCombinaison(1));
                for (int i=0; i<game.getTabJoueur()[1].combinaisonEnCours.size();i++){
                    Assert.assertNotEquals(game.getTabJoueur()[1].combinaisonEnCours.get(i), new Carte(Carte.Couleur.MULTI));
                }

                Assert.assertEquals(game.getTabJoueur()[1].getMain().size(),16-game.getTabJoueur()[1].combinaisonEnCours.size());
            }
        }
    }

    @Test
    public void testGetCarteForPlayer(){
        Game game = new Game();
        IA ia = (IA) game.getTabJoueur()[1];

        Assert.assertEquals(16, ia.getMain().size());
        Carte carte = ia.getCarteForPlayer();
        Assert.assertNotNull(carte);
        Assert.assertEquals(15,ia.getMain().size());
    }
}
