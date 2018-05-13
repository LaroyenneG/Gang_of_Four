package Modele;

import java.util.*;

/**
 * Created by Guillaume LAROYENNE on 11/11/16.
 */
public class Deck {
    private Carte[] carteList;

    public Deck() {
        carteList = new Carte[64];

        int count = 0;

        for (int x = 0; x < 2; x++) {
            //Rouge
            for (int i = 1; i <= 10; i++) {
                carteList[count] = new Carte(i, Carte.Couleur.ROUGE);
                count++;
            }
            //Jaune
            for (int i = 1; i <= 10; i++) {
                carteList[count] = new Carte(i, Carte.Couleur.JAUNE);
                count++;
            }
            //VERT
            for (int i = 1; i <= 10; i++) {
                carteList[count] = new Carte(i, Carte.Couleur.VERT);
                count++;
            }
        }

        //MULTI
        carteList[count] = new Carte(Carte.Couleur.MULTI);
        count++;

        //DRAGON ROUGE
        carteList[count] = new Carte(Carte.Figure.DRAGON, Carte.Couleur.ROUGE);
        count++;
        //PHENIX
        carteList[count] = new Carte(Carte.Figure.PHENIX, Carte.Couleur.VERT);
        count++;
        carteList[count] = new Carte(Carte.Figure.PHENIX, Carte.Couleur.JAUNE);

    }

    public Carte[] getTabCarte() {
        return carteList;
    }

    public String toString() {
        StringBuilder message = new StringBuilder("Deck =\n");
        message.append("Size=").append(carteList.length);
        for (Carte aCarteList : carteList) {
            message.append(aCarteList.toString());

        }
        message.append("end deck");
        return message.toString();
    }

    public List<Carte> getCarteList() {
        return new ArrayList<>(Arrays.asList(carteList));
    }

    public void ordoDeck() {
        carteList = AlgoCarte.trierCarte(carteList);
    }

    public void melangerDeck() {
        for (int nbMelange = 0; nbMelange < 300; nbMelange++) {
            for (int i = 0; i < 64; i++) {
                Random rand = new Random(Calendar.getInstance().getTimeInMillis());
                int r = rand.nextInt(64);
                Carte tampon = carteList[i];
                carteList[i] = carteList[r];
                carteList[r] = tampon;
            }
        }
    }
}
