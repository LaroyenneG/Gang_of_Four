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
    }
}
