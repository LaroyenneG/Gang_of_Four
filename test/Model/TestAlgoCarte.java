package Model;

/**
 * Created by sangry on 05/12/16.
 */

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAlgoCarte {
    @Test
    public void testCombiniaison1Cartes(){
        List<Carte> carteAjouer = new ArrayList<Carte>();
        carteAjouer.add(new Carte(Carte.Figure.PHENIX,Carte.Couleur.VERT));
        Assert.assertTrue(AlgoCarte.combinaisonDe1carte(carteAjouer));
        carteAjouer.add(new Carte(3, Carte.Couleur.ROUGE));
        Assert.assertFalse(AlgoCarte.combinaisonDe1carte(carteAjouer));
    }

    @Test
    public void testCombinaisionDe2Cartes(){
        List<Carte> carteAjouer = new ArrayList<Carte>();
        carteAjouer.add(new Carte(Carte.Figure.PHENIX,Carte.Couleur.VERT));
        Assert.assertFalse(AlgoCarte.combinaisonDe2cartes(carteAjouer));
        carteAjouer.add(new Carte(3, Carte.Couleur.ROUGE));
        Assert.assertFalse(AlgoCarte.combinaisonDe2cartes(carteAjouer));

        carteAjouer.clear();

        carteAjouer.add(new Carte(3, Carte.Couleur.ROUGE));
        carteAjouer.add(new Carte(3, Carte.Couleur.JAUNE));
        Assert.assertTrue(AlgoCarte.combinaisonDe2cartes(carteAjouer));
    }

    @Test
    public void testCombinaisionDe3Cartes(){
        List<Carte> carteAjouer = new ArrayList<Carte>();
        carteAjouer.add(new Carte(Carte.Figure.PHENIX,Carte.Couleur.VERT));
        carteAjouer.add(new Carte(3, Carte.Couleur.JAUNE));
        Assert.assertFalse(AlgoCarte.combinaisonDe3cartes(carteAjouer));
        carteAjouer.add(new Carte(3, Carte.Couleur.ROUGE));
        Assert.assertFalse(AlgoCarte.combinaisonDe3cartes(carteAjouer));

        carteAjouer.clear();

        carteAjouer.add(new Carte(3, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(3, Carte.Couleur.ROUGE));
        carteAjouer.add(new Carte(3, Carte.Couleur.JAUNE));
        Assert.assertTrue(AlgoCarte.combinaisonDe3cartes(carteAjouer));

        carteAjouer.clear();

        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.ROUGE));
        carteAjouer.add(new Carte(3, Carte.Couleur.JAUNE));
        Assert.assertFalse(AlgoCarte.combinaisonDe3cartes(carteAjouer));
    }

    @Test
    public void testCombinaisonGangOfN(){
        List<Carte> carteAjouer = new ArrayList<Carte>();
        carteAjouer.add(new Carte(3, Carte.Couleur.JAUNE));
        carteAjouer.add(new Carte(3, Carte.Couleur.VERT));
        Assert.assertFalse(AlgoCarte.gangOfN(carteAjouer));

        carteAjouer.add(new Carte(3, Carte.Couleur.ROUGE));
        carteAjouer.add(new Carte(3, Carte.Couleur.JAUNE));
        Assert.assertTrue(AlgoCarte.gangOfN(carteAjouer));

        carteAjouer.add(new Carte(3, Carte.Couleur.VERT));
        Assert.assertTrue(AlgoCarte.gangOfN(carteAjouer));

        carteAjouer.clear();
        carteAjouer.add(new Carte(3, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(5, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(6, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(7, Carte.Couleur.VERT));
        Assert.assertFalse(AlgoCarte.gangOfN(carteAjouer));
    }

    @Test
    public void testSuite(){
        List<Carte> carteAjouer = new ArrayList<Carte>();
        carteAjouer.add(new Carte(3, Carte.Couleur.JAUNE));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(6, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(5, Carte.Couleur.ROUGE));
        carteAjouer.add(new Carte(7, Carte.Couleur.VERT));
        Assert.assertTrue(AlgoCarte.estUneSuite(carteAjouer));

        carteAjouer.clear();
        carteAjouer.add(new Carte(3, Carte.Couleur.JAUNE));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(5, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(8, Carte.Couleur.ROUGE));
        carteAjouer.add(new Carte(7, Carte.Couleur.VERT));
        Assert.assertFalse(AlgoCarte.estUneSuite(carteAjouer));

        carteAjouer.clear();
        carteAjouer.add(new Carte(10, Carte.Couleur.JAUNE));
        carteAjouer.add(new Carte(7, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(8, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(9, Carte.Couleur.ROUGE));
        carteAjouer.add(new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT));
        Assert.assertFalse(AlgoCarte.estUneSuite(carteAjouer));
    }

    @Test
    public void testCouleur(){
        List<Carte> carteAjouer = new ArrayList<Carte>();
        carteAjouer.add(new Carte(3, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(6, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(9, Carte.Couleur.VERT));
        Assert.assertTrue(AlgoCarte.estUneCouleur(carteAjouer));

        carteAjouer.clear();
        carteAjouer.add(new Carte(3, Carte.Couleur.ROUGE));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(6, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(9, Carte.Couleur.VERT));
        Assert.assertFalse(AlgoCarte.estUneCouleur(carteAjouer));

        carteAjouer.clear();
        carteAjouer.add(new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(6, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(9, Carte.Couleur.VERT));
        Assert.assertFalse(AlgoCarte.estUneCouleur(carteAjouer));
    }

    @Test
    public void testSuiteCouleur(){
        List<Carte> carteAjouer = new ArrayList<Carte>();
        carteAjouer.add(new Carte(3, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(5, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(6, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(7, Carte.Couleur.VERT));
        Assert.assertTrue(AlgoCarte.estUneSuiteCouleur(carteAjouer));

        carteAjouer.clear();
        carteAjouer.add(new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(6, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(9, Carte.Couleur.VERT));
        Assert.assertFalse(AlgoCarte.estUneSuiteCouleur(carteAjouer));
    }

    @Test
    public void testEstUnFull(){
        List<Carte> carteAjouer = new ArrayList<Carte>();
        carteAjouer.add(new Carte(5, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(3, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(3, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(5, Carte.Couleur.JAUNE));
        carteAjouer.add(new Carte(5, Carte.Couleur.ROUGE));
        Assert.assertTrue(AlgoCarte.estUnFull(carteAjouer));

        carteAjouer.clear();
        carteAjouer.add(new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(Carte.Figure.PHENIX, Carte.Couleur.JAUNE));
        carteAjouer.add(new Carte(5, Carte.Couleur.JAUNE));
        carteAjouer.add(new Carte(5, Carte.Couleur.ROUGE));
        carteAjouer.add(new Carte(5, Carte.Couleur.VERT));
        Assert.assertTrue(AlgoCarte.estUnFull(carteAjouer));

        carteAjouer.clear();
        carteAjouer.add(new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(4, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(6, Carte.Couleur.VERT));
        carteAjouer.add(new Carte(9, Carte.Couleur.VERT));
        Assert.assertFalse(AlgoCarte.estUnFull(carteAjouer));
    }

    @Test
    public void testColorValue(){


        List<Carte> list1 = new ArrayList<>();
        List<Carte> list2 = new ArrayList<>();

        //gang of four
        list1.add(new Carte(1, Carte.Couleur.VERT));
        list1.add(new Carte(1, Carte.Couleur.VERT));
        list1.add(new Carte(1, Carte.Couleur.JAUNE));
        list1.add(new Carte(1, Carte.Couleur.JAUNE));

        list2.add(new Carte(1, Carte.Couleur.VERT));
        list2.add(new Carte(1, Carte.Couleur.VERT));
        list2.add(new Carte(1, Carte.Couleur.JAUNE));
        list2.add(new Carte(1, Carte.Couleur.JAUNE));
        Assert.assertFalse(AlgoCarte.estPlusFort(list1,list2));
        Assert.assertFalse(AlgoCarte.estPlusFort(list2,list1));

        list1.clear();
        list2.clear();

        list1.add(new Carte(1, Carte.Couleur.VERT));
        list1.add(new Carte(1, Carte.Couleur.VERT));
        list1.add(new Carte(1, Carte.Couleur.JAUNE));
        list1.add(new Carte(1, Carte.Couleur.JAUNE));

        list2.add(new Carte(1, Carte.Couleur.ROUGE));
        list2.add(new Carte(1, Carte.Couleur.ROUGE));
        list2.add(new Carte(1, Carte.Couleur.VERT));
        list2.add(new Carte(1, Carte.Couleur.VERT));
        Assert.assertFalse(AlgoCarte.estPlusFort(list1,list2));
        Assert.assertTrue(AlgoCarte.estPlusFort(list2,list1));

        //suite
        list1.clear();
        list2.clear();

        list1.add(new Carte(1, Carte.Couleur.VERT));
        list1.add(new Carte(2, Carte.Couleur.VERT));
        list1.add(new Carte(3, Carte.Couleur.JAUNE));
        list1.add(new Carte(4, Carte.Couleur.JAUNE));
        list1.add(new Carte(5, Carte.Couleur.VERT));

        list2.add(new Carte(1, Carte.Couleur.ROUGE));
        list2.add(new Carte(2, Carte.Couleur.ROUGE));
        list2.add(new Carte(3, Carte.Couleur.VERT));
        list2.add(new Carte(4, Carte.Couleur.VERT));
        list2.add(new Carte(5, Carte.Couleur.VERT));

        Assert.assertTrue(AlgoCarte.estPlusFort(list1,list2));
        Assert.assertFalse(AlgoCarte.estPlusFort(list2,list1));

        //suite
        list1.clear();
        list2.clear();

        list1.add(new Carte(1, Carte.Couleur.VERT));
        list1.add(new Carte(2, Carte.Couleur.VERT));
        list1.add(new Carte(3, Carte.Couleur.JAUNE));
        list1.add(new Carte(4, Carte.Couleur.JAUNE));
        list1.add(new Carte(5, Carte.Couleur.VERT));

        list2.add(new Carte(3, Carte.Couleur.ROUGE));
        list2.add(new Carte(2, Carte.Couleur.ROUGE));
        list2.add(new Carte(3, Carte.Couleur.VERT));
        list2.add(new Carte(4, Carte.Couleur.VERT));
        list2.add(new Carte(5, Carte.Couleur.VERT));

        Assert.assertFalse(AlgoCarte.estPlusFort(list1,list2));
        Assert.assertTrue(AlgoCarte.estPlusFort(list2,list1));


        list1.clear();
        list2.clear();

        list1.add(new Carte(9, Carte.Couleur.VERT));
        list1.add(new Carte(8, Carte.Couleur.VERT));
        list1.add(new Carte(7, Carte.Couleur.VERT));
        list1.add(new Carte(6, Carte.Couleur.ROUGE));
        list1.add(new Carte(5, Carte.Couleur.VERT));

        list2.add(new Carte(9, Carte.Couleur.JAUNE));
        list2.add(new Carte(8, Carte.Couleur.VERT));
        list2.add(new Carte(7, Carte.Couleur.VERT));
        list2.add(new Carte(6, Carte.Couleur.VERT));
        list2.add(new Carte(5, Carte.Couleur.VERT));

        Assert.assertFalse(AlgoCarte.estPlusFort(list1,list2));
        Assert.assertTrue(AlgoCarte.estPlusFort(list2,list1));
    }


    @Test
    public void testFact(){
        Assert.assertEquals(AlgoCarte.fact(5),120);
        Assert.assertEquals(AlgoCarte.fact(10), 3628800);
    }

    @Test
    public void testcombi(){
        Assert.assertEquals(AlgoCarte.combi(5,3),10);
        Assert.assertEquals(AlgoCarte.combi(3,2),3);
        Assert.assertEquals(AlgoCarte.combi(16,1),16);
    }

    @Test
    public void testCombinaisonCarte(){
        List<Carte> list = new ArrayList<>();
        list.add(new Carte(1, Carte.Couleur.JAUNE));
        list.add(new Carte(1, Carte.Couleur.ROUGE));
        list.add(new Carte(1, Carte.Couleur.VERT));
        int size =list.size();


        int n=2;
        List<Carte> combi = AlgoCarte.combinaisonCarte(list, n,list.size()-n);

        Assert.assertEquals(combi.size()/n,AlgoCarte.combi(size,n));
    }

    @Test
    public void testGetCombinaison(){

        //test over flow
        Game game = new Game();
        List<Carte> list = game.getTabJoueur()[0].getMain();
        List<Carte[][]> listcombi = AlgoCarte.getCombinaison(list);


        list = new ArrayList<>();
        list.add(new Carte(1, Carte.Couleur.JAUNE));
        list.add(new Carte(2, Carte.Couleur.JAUNE));
        list.add(new Carte(3, Carte.Couleur.ROUGE));

        listcombi = AlgoCarte.getCombinaison(list);

        int cout=1;
        for(int i=0; i<listcombi.size();i++){
            Assert.assertEquals(listcombi.get(i)[0].length,cout);
            Assert.assertEquals(listcombi.get(i).length,AlgoCarte.combi(list.size(),cout));
            cout++;
        }

    }
}
