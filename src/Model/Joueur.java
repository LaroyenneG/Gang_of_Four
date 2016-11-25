package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guillaume on 12/11/16.
 */
public class Joueur {
    private List<Carte> main;
    private int score;
    public boolean peutJouer;

    public Joueur(){
        main=new ArrayList<Carte>();
        score=0;
    }

    public Joueur(List<Carte> main){
        this.main=main;
        score=0;
    }

    /*
    trie les cartes pour que le joueur est une main plus lisible
     */
    public void ordoMain(){
        main=AlgoCarte.trierCarte(main);
    }

    public List<Carte> getMain(){
        return main;
    }

    public void printMain(){
        for (int i=0; i<main.size();i++){
            System.out.print(main.get(i));
        }
    }

    public void addALaMain(Carte carteAAdd) {
        main.add(carteAAdd);
    }
}
