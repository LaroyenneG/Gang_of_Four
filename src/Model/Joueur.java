package Model;

import java.util.List;

/**
 * Created by guillaume on 12/11/16.
 */
public class Joueur {
    private List<Carte> main;

    public Joueur(){
        main=null;
    }

    public Joueur(List<Carte> main){
        this.main=main;
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
}
