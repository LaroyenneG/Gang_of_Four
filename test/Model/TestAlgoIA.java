package Model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by guillaume on 09/12/16.
 */
public class TestAlgoIA {
    @Test
    public void testgetCombinaisonJouable(){

        List<Carte> table =new ArrayList<>();
        List<Carte> main = new ArrayList<>();
        List<Carte>[] tabCombi;

        main.clear();
        table.clear();

        table.add(new Carte(1, Carte.Couleur.VERT));

        main.add(new Carte(1, Carte.Couleur.ROUGE));

        tabCombi = AlgoIA.getCombinaisonJouable(table,main);

        Assert.assertEquals(1, tabCombi.length);


        main.clear();
        table.clear();

        table.add(new Carte(1, Carte.Couleur.VERT));

        main.add(new Carte(1, Carte.Couleur.ROUGE));
        main.add(new Carte(1, Carte.Couleur.ROUGE));

        tabCombi = AlgoIA.getCombinaisonJouable(table,main);

        Assert.assertEquals(2, tabCombi.length);


        main.clear();
        table.clear();

        table.add(new Carte(1, Carte.Couleur.ROUGE));
        table.add(new Carte(1, Carte.Couleur.ROUGE));

        main.add(new Carte(1, Carte.Couleur.JAUNE));
        main.add(new Carte(2, Carte.Couleur.JAUNE));
        main.add(new Carte(3, Carte.Couleur.JAUNE));
        main.add(new Carte(4, Carte.Couleur.VERT));
        main.add(new Carte(4, Carte.Couleur.JAUNE));
        main.add(new Carte(4, Carte.Couleur.JAUNE));
        main.add(new Carte(4, Carte.Couleur.VERT));
        main.add(new Carte(5, Carte.Couleur.JAUNE));

        tabCombi = AlgoIA.getCombinaisonJouable(table,main);


        Assert.assertEquals(7, tabCombi.length);


        /*
        multi
         */
        main.clear();
        table.clear();

        table.add(new Carte(1, Carte.Couleur.VERT));

        main.add(new Carte(Carte.Couleur.MULTI));

        tabCombi = AlgoIA.getCombinaisonJouable(table,main);

        Assert.assertEquals(2, tabCombi.length);
    }
}
