package Modele;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guillaume on 11/11/16.
 */
public class TestCarte {
    @Test
    public void testConstructor() {
        //Rouge 1
        Carte carte = new Carte(1, Carte.Couleur.ROUGE);
        Assert.assertEquals(1, carte.valeur);
        Assert.assertEquals(carte.couleur, Carte.Couleur.ROUGE);
        Assert.assertEquals(carte.figure, Carte.Figure.NOMBRE);

        //Vert 2
        carte = new Carte(2, Carte.Couleur.VERT);
        Assert.assertEquals(2, carte.valeur);
        Assert.assertEquals(carte.couleur, Carte.Couleur.VERT);
        Assert.assertEquals(carte.figure, Carte.Figure.NOMBRE);

        //JAUNE 3
        carte = new Carte(3, Carte.Couleur.JAUNE);
        Assert.assertEquals(3, carte.valeur);
        Assert.assertEquals(carte.couleur, Carte.Couleur.JAUNE);
        Assert.assertEquals(carte.figure, Carte.Figure.NOMBRE);

        //DRAGON ROUGE
        carte = new Carte(Carte.Figure.DRAGON, Carte.Couleur.ROUGE);
        Assert.assertEquals(12, carte.valeur);
        Assert.assertEquals(carte.couleur, Carte.Couleur.ROUGE);
        Assert.assertEquals(carte.figure, Carte.Figure.DRAGON);

        //DRAGON PHENIX VERT
        carte = new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT);
        Assert.assertEquals(11, carte.valeur);
        Assert.assertEquals(carte.couleur, Carte.Couleur.VERT);
        Assert.assertEquals(carte.figure, Carte.Figure.PHENIX);

        //DRAGON PHENIX JAUNE
        carte = new Carte(Carte.Figure.PHENIX, Carte.Couleur.JAUNE);
        Assert.assertEquals(11, carte.valeur);
        Assert.assertEquals(carte.couleur, Carte.Couleur.JAUNE);
        Assert.assertEquals(carte.figure, Carte.Figure.PHENIX);

        //MULTICOULEUR
        carte = new Carte(Carte.Couleur.MULTI);
        Assert.assertEquals(1, carte.valeur);
        Assert.assertEquals(carte.couleur, Carte.Couleur.MULTI);
        Assert.assertEquals(carte.figure, Carte.Figure.NOMBRE);
    }

    @Test
    public void testEquals() {
        Carte carte1 = new Carte(Carte.Couleur.MULTI);
        Carte carte2 = new Carte(2, Carte.Couleur.ROUGE);
        Carte carte3 = new Carte(3, Carte.Couleur.VERT);
        Carte carte4 = new Carte(Carte.Figure.DRAGON, Carte.Couleur.ROUGE);
        Carte carte5 = new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT);
        Carte carte6 = new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT);
        Carte carte7 = new Carte(Carte.Couleur.MULTI);

        Assert.assertTrue(carte5.equals(carte6));
        Assert.assertTrue(carte1.equals(carte7));
        Assert.assertFalse(carte2.equals(carte3));
        Assert.assertFalse(carte3.equals(carte4));
        Assert.assertFalse(carte1.equals(carte4));
        Assert.assertFalse(carte1.equals(carte2));
    }

    @Test
    public void testGetFileName() {
        // Test du 1 multicolor
        Carte carte0 = new Carte(Carte.Couleur.MULTI);
        String name0 = carte0.getFileName();
        Assert.assertEquals("1multicolor.jpg", name0);

        for (int i = 1; i <= 10; i++) { //Vert
            Carte carte = new Carte(i, Carte.Couleur.VERT);
            String name = carte.getFileName();
            Assert.assertEquals(i + "vert.jpg", name);
        }

        for (int i = 1; i <= 10; i++) { //Jaune
            Carte carte = new Carte(i, Carte.Couleur.JAUNE);
            String name = carte.getFileName();
            Assert.assertEquals(i + "jaune.jpg", name);
        }

        for (int i = 1; i <= 10; i++) { //Rouge
            Carte carte = new Carte(i, Carte.Couleur.ROUGE);
            String name = carte.getFileName();
            Assert.assertEquals(i + "rouge.jpg", name);
        }

        //Test des phénix
        Carte carte1 = new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT);
        Carte carte2 = new Carte(Carte.Figure.PHENIX, Carte.Couleur.JAUNE);
        Carte carte3 = new Carte(Carte.Figure.DRAGON, Carte.Couleur.ROUGE);
        String name1 = carte1.getFileName();
        String name2 = carte2.getFileName();
        String name3 = carte3.getFileName();
        Assert.assertEquals("PHENIXvert.jpg", name1);
        Assert.assertEquals("PHENIXjaune.jpg", name2);
        Assert.assertEquals("DRAGONrouge.jpg", name3);
    }
}
