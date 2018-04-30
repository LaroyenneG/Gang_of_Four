package Modele;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guillaume on 12/11/16.
 */
public class TestJoueur {
    @Test
    public void testConstructor() {
        List<Carte> list = new ArrayList<>();
        list.add(new Carte(1, Carte.Couleur.ROUGE));
        list.add(new Carte(1, Carte.Couleur.VERT));
        Joueur joueur = new Joueur(list);
        Assert.assertEquals(list, joueur.getMain());
    }

    @Test
    public void testPlusQuUneCarte() {
        List<Carte> list = new ArrayList<>();
        list.add(new Carte(1, Carte.Couleur.ROUGE));
        list.add(new Carte(1, Carte.Couleur.VERT));
        Joueur joueur = new Joueur(list);
        Assert.assertFalse(joueur.plusQuUneCarte());
        list.clear();
        list.add(new Carte(1, Carte.Couleur.ROUGE));
        Assert.assertTrue(joueur.plusQuUneCarte());
    }

    @Test
    public void testPlusForteCarte() {
        List<Carte> list = new ArrayList<>();
        list.add(new Carte(1, Carte.Couleur.ROUGE));
        list.add(new Carte(5, Carte.Couleur.VERT));
        list.add(new Carte(9, Carte.Couleur.ROUGE));
        list.add(new Carte(6, Carte.Couleur.VERT));
        list.add(new Carte(9, Carte.Couleur.JAUNE));
        Joueur joueur = new Joueur(AlgoCarte.trierCarte(list));
        Assert.assertTrue(new Carte(9, Carte.Couleur.ROUGE).equals(joueur.plusForteCarte()));
    }

    @Test
    public void testOrdoMain() {
        List<Carte> list = new ArrayList<>();
        list.add(new Carte(8, Carte.Couleur.ROUGE));
        list.add(new Carte(2, Carte.Couleur.JAUNE));
        list.add(new Carte(Carte.Figure.DRAGON, Carte.Couleur.ROUGE));
        list.add(new Carte(3, Carte.Couleur.ROUGE));
        list.add(new Carte(8, Carte.Couleur.VERT));
        list.add(new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT));
        list.add(new Carte(2, Carte.Couleur.VERT));
        list.add(new Carte(8, Carte.Couleur.JAUNE));
        list.add(new Carte(Carte.Figure.PHENIX, Carte.Couleur.JAUNE));
        list.add(new Carte(1, Carte.Couleur.JAUNE));
        list.add(new Carte(Carte.Couleur.MULTI));

        Joueur joueur = new Joueur(list);
        joueur.ordoMain();

        List<Carte> listTrie = new ArrayList<>();
        listTrie.add(new Carte(Carte.Couleur.MULTI));
        listTrie.add(new Carte(1, Carte.Couleur.JAUNE));
        listTrie.add(new Carte(2, Carte.Couleur.VERT));
        listTrie.add(new Carte(2, Carte.Couleur.JAUNE));
        listTrie.add(new Carte(3, Carte.Couleur.ROUGE));
        listTrie.add(new Carte(8, Carte.Couleur.VERT));
        listTrie.add(new Carte(8, Carte.Couleur.JAUNE));
        listTrie.add(new Carte(8, Carte.Couleur.ROUGE));
        listTrie.add(new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT));
        listTrie.add(new Carte(Carte.Figure.PHENIX, Carte.Couleur.JAUNE));
        listTrie.add(new Carte(Carte.Figure.DRAGON, Carte.Couleur.ROUGE));

        for (int i = 0; i < listTrie.size(); i++) {
            Assert.assertTrue(list.get(i).equals(listTrie.get(i)));
        }
    }

    @Test
    public void testAddCarte() {
        List<Carte> main;
        Carte carte = new Carte(1, Carte.Couleur.VERT);
        Joueur joueur = new Joueur();
        joueur.addALaMain(carte);
        main = joueur.getMain();
        Assert.assertTrue(main.contains(carte));
    }

    @Test
    public void testPremiereCarte() {
        Joueur joueur1 = new Joueur();
        joueur1.addALaMain(new Carte(8, Carte.Couleur.ROUGE));
        joueur1.addALaMain(new Carte(2, Carte.Couleur.JAUNE));
        joueur1.addALaMain(new Carte(Carte.Figure.DRAGON, Carte.Couleur.ROUGE));
        joueur1.addALaMain(new Carte(3, Carte.Couleur.ROUGE));
        joueur1.addALaMain(new Carte(8, Carte.Couleur.VERT));
        Assert.assertTrue(joueur1.premiereCarte().equals(new Carte(8, Carte.Couleur.ROUGE)));

        Joueur joueur2 = new Joueur();
        joueur2.addALaMain(new Carte(Carte.Figure.DRAGON, Carte.Couleur.ROUGE));
        joueur2.addALaMain(new Carte(8, Carte.Couleur.ROUGE));
        joueur2.addALaMain(new Carte(2, Carte.Couleur.JAUNE));
        joueur2.addALaMain(new Carte(3, Carte.Couleur.ROUGE));
        joueur2.addALaMain(new Carte(8, Carte.Couleur.VERT));
        Assert.assertTrue(joueur2.premiereCarte().equals(new Carte(Carte.Figure.DRAGON, Carte.Couleur.ROUGE)));
        Assert.assertFalse(joueur2.premiereCarte().equals(new Carte(8, Carte.Couleur.ROUGE)));

        Joueur joueur3 = new Joueur();
        Assert.assertTrue(joueur3.premiereCarte() == null);
    }

    @Test
    public void testAddCombinaisonEnCours() {
        Joueur joueur = new Joueur();
        for (int i = 0; i < 7; i++) {
            Assert.assertTrue(joueur.addCombinaisonEnCours(new Carte(Carte.Couleur.MULTI)));
        }
        Assert.assertFalse(joueur.addCombinaisonEnCours(new Carte(Carte.Couleur.MULTI)));
    }

    @Test
    public void testVeutJouerAndReset() {
        Game game = new Game();
        Assert.assertEquals(game.getTabJoueur()[0].getMain().size(), 16);


        Assert.assertTrue(game.getTabJoueur()[0].veutJouer(0));
        Assert.assertTrue(game.getTabJoueur()[0].veutJouer(1));

        Assert.assertEquals(game.getTabJoueur()[0].getMain().size(), 14);

        Assert.assertEquals(game.getTabJoueur()[0].getCombinaisonEnCours().size(), 2);

        //reset
        game.getTabJoueur()[0].resetCombinaison();
        Assert.assertEquals(game.getTabJoueur()[0].getMain().size(), 16);
        Assert.assertEquals(game.getTabJoueur()[0].getCombinaisonEnCours().size(), 0);
    }
}
