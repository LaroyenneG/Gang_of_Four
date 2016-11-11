package Model;

import java.util.ArrayList;
import java.util.List;

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

    public String toString(){
        String message="Deck =\n";
        message+="Size="+carteList.length;
        for (int i=0; i<carteList.length; i++){
            message+=carteList[i].toString();

        }
        message+="end deck";
        return message;
    }

}
