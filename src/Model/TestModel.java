package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guillaume on 11/11/16.
 */
public class TestModel {
    public static void main(String args[]){
        Deck deck = new Deck();
        //System.out.println(deck);

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
        joueur.printMain();
    }
}
