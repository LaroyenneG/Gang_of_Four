package Model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by guillaume on 11/11/16.
 */
public class TestDeck {

    @Test
    public void testConstructor(){
        Deck deck =new Deck();
        Assert.assertEquals(64, deck.getTabCarte().length);
        for (int i=0; i<deck.getTabCarte().length; i++){
            Assert.assertNotNull(deck.getTabCarte()[i]);
        }
    }

    @Test
    public void testGetListCarte(){
        Deck deck = new Deck();
        List<Carte> carteList=deck.getCarteList();

        Assert.assertEquals(64, carteList.size());

        for (int i=0; i<carteList.size(); i++){
            Assert.assertNotNull(carteList.get(i));
        }

        int nbNombre = 3*10*2+1; //3*10 carte nombre + multi
        int nbrouge=2*10+1; //2*carte nombre + dragon
        int nbverte=2*10+1; //2*10 carte nombre + phenix vert
        int nbjaune=2*10+1; //2*10 carte nombre + phenix jaune
        int nbmulti=1;
        int nbfigue=3;


        int cnbNombre=0;
        int cnbrouge=0;
        int cnbverte=0;
        int cnbjaune=0;
        int cnbmulti=0;
        int cnbfigue=0;

        for (int i=0; i<carteList.size();i++){
            if (carteList.get(i).valeur<11){
                cnbNombre++;
            }
            if (carteList.get(i).couleur== Carte.Couleur.ROUGE){
                cnbrouge++;
            }
            if (carteList.get(i).couleur== Carte.Couleur.VERT){
                cnbverte++;
            }
            if (carteList.get(i).couleur== Carte.Couleur.JAUNE){
                cnbjaune++;
            }
            if(carteList.get(i).figure!=Carte.Figure.NOMBRE){
                cnbfigue++;
            }
            if(carteList.get(i).couleur== Carte.Couleur.MULTI){
                cnbmulti++;
            }
        }

        Assert.assertEquals(cnbNombre, nbNombre);
        Assert.assertEquals(cnbrouge, nbrouge);
        Assert.assertEquals(cnbjaune, nbjaune);
        Assert.assertEquals(cnbverte, nbverte);
        Assert.assertEquals(cnbfigue, nbfigue);
        Assert.assertEquals(cnbmulti, nbmulti);
    }

    @Test
    public void testMelangeCarte(){
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Carte[] tab1 = deck1.getTabCarte();
        Carte[] tab2 = deck2.getTabCarte();
        int compteur = 0;
        for (int i =0; i< 64; i++){
            if (tab1[i].equals(tab2[i]))
                compteur++;
        }
        Assert.assertEquals(compteur,tab2.length);

        deck2.melangerDeck();
        int compteur2 = 0;
        for (int i =0; i< 64; i++){
            if (tab1[i].equals(tab2[i]))
                compteur2++;
        }
        Assert.assertNotEquals(compteur2,tab2.length);


    }

    @Test
    public void TestMelangeSansPerte(){
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Carte[] tab1 = deck1.getTabCarte();
        Carte[] tab2 = deck2.getTabCarte();

        Carte[] tableau1=AlgoCarte.trierCarte(tab1);

        deck2.melangerDeck();
        Carte[] tableau2=AlgoCarte.trierCarte(tab2);

        int compteur = 0;
        for (int i =0; i< 64; i++){
            if (tableau1[i].equals(tableau2[i]))
                compteur++;
        }
        Assert.assertEquals(compteur,tableau2.length);
    }
}
