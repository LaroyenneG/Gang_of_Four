package Model;

/**
 * Created by sangry on 05/12/16.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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
}
