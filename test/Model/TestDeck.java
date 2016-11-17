package model;

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
            if (carteList.get(i).valeur!=0){
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

        Assert.assertEquals(nbNombre, cnbNombre);
        Assert.assertEquals(nbrouge, cnbrouge);
        Assert.assertEquals(nbjaune, cnbjaune);
        Assert.assertEquals(nbverte, cnbverte);
        Assert.assertEquals(nbfigue, cnbfigue);
        Assert.assertEquals(nbmulti, cnbmulti);
    }
}
