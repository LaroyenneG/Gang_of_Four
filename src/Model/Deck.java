package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by guillaume on 11/11/16.
 */
public class Deck {
    private Carte[] carteList;

    public Deck(){
        carteList=new Carte[64];

        int count=0;

        for (int x=0; x<2; x++){
            //Rouge
            for (int i=1; i<=10;i++){
                carteList[count]=new Carte(i, Carte.Couleur.ROUGE);
                count++;
            }
            //Jaune
            for (int i=1; i<=10;i++){
                carteList[count]=new Carte(i, Carte.Couleur.JAUNE);
                count++;
            }
            //VERT
            for (int i=1; i<=10;i++){
                carteList[count]=new Carte(i, Carte.Couleur.VERT);
                count++;
            }
        }

        //MULTI
        carteList[count]=new Carte(Carte.Couleur.MULTI);
        count++;

        //DRAGON ROUGE
        carteList[count]=new Carte(Carte.Figure.DRAGON, Carte.Couleur.ROUGE);
        count++;
        //PHENIX
        carteList[count]=new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT);
        count++;
        carteList[count]=new Carte(Carte.Figure.PHENIX, Carte.Couleur.JAUNE);

    }

    public Carte[] getTabCarte(){
        return carteList;
    }

    public String toString(){
        String message="Deck =\n";
        message+="Size="+carteList.length;
        for (int i=0; i<carteList.length; i++){
            message+=carteList[i].toString();

        }
        message+="end deck";
        return message;
    }

    public List<Carte> getCarteList() {
        List<Carte> list = new ArrayList<>();
        for (int i=0; i<carteList.length; i++){
            list.add(carteList[i]);
        }
        return list;
    }

    public void ordoDeck(){
        carteList=AlgoCarte.trierCarte(carteList);
    }

    public void melangerDeck(){
        for (int nbMelange=0; nbMelange < 100; nbMelange++) {
            for (int i = 0; i < 64; i++) {
                Random rand = new Random();
                int r = rand.nextInt(64);
                Carte tampon = carteList[i];
                carteList[i] = carteList[r];
                carteList[r] = tampon;
            }
        }
    }
}
