package Model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangry on 21/11/16.
 */
public class TestGame {
    @Test
    public void testDistribution(){
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        Joueur j3 = new Joueur();
        Joueur j4 = new Joueur();
        Game game = new Game(j1,j2,j3,j4);

        game.distribuerCarte();
        List<Carte> l1 = j1.getMain();
        List<Carte> l2 = j2.getMain();
        List<Carte> l3 = j3.getMain();
        List<Carte> l4 = j4.getMain();

        Assert.assertEquals(l1.size(),16);
        Assert.assertEquals(l2.size(),16);
        Assert.assertEquals(l3.size(),16);
        Assert.assertEquals(l4.size(),16);

        Carte[] tabPrincipale;
        tabPrincipale=new Carte[64];
        for (int i = 0; i< 16; i++){
            tabPrincipale[i*4] =l1.get(i);
            tabPrincipale[i*4+1]=l2.get(i);
            tabPrincipale[i*4+2]=l3.get(i);
            tabPrincipale[i*4+3]=l4.get(i);
        }
        AlgoCarte.trierCarte(tabPrincipale);
        Deck deck2 = new Deck();
        Carte[] tab2 = deck2.getTabCarte();
        AlgoCarte.trierCarte(tab2);

        int compteur = 0;
        for (int i =0; i< 64; i++){
            if (tabPrincipale[i].equals(tab2[i]))
                compteur++;
        }
        Assert.assertEquals(compteur,tabPrincipale.length);
    }
}
