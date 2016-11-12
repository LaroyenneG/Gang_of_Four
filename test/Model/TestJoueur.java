package Model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guillaume on 12/11/16.
 */
public class TestJoueur {
    @Test
    public void testConstructor(){
        List<Carte> list = new ArrayList<>();
        list.add(new Carte(1, Carte.Couleur.ROUGE));
        list.add(new Carte(1, Carte.Couleur.VERT));
        Joueur joueur = new Joueur(list);
        Assert.assertEquals(list, joueur.getMain());
    }

    @Test
    public void testOrdoMain(){
        List<Carte> list =new ArrayList<>();
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

        List<Carte> listTrie =new ArrayList<>();
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

        for (int i=0; i<listTrie.size();i++){
            Assert.assertTrue(list.get(i).equals(listTrie.get(i)));
        }

    }
}
