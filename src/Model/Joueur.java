package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guillaume on 12/11/16.
 */
public class Joueur {
    private List<Carte> main;
    private List<Carte> combinaisonEnCours;
    private int score;
    public boolean peutJouer;

    public Joueur(){
        main=new ArrayList<Carte>();
        score=0;
        peutJouer=true;
        combinaisonEnCours = new ArrayList<>();
    }

    public Joueur(List<Carte> main){
        this.main=main;
        score=0;
        peutJouer=true;
        combinaisonEnCours = new ArrayList<>();
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

    public Carte premiereCarte() {
        if (main.size()>0)
            return main.get(0);
        else return null;
    }

    public boolean addCombinaisonEnCours(Carte carte){
        if(combinaisonEnCours.size()<=5){
            combinaisonEnCours.add(carte);
            return true;
        }
        return false;
    }

    public List<Carte> getCombinaisonEnCours(){
        return combinaisonEnCours;
    }

    public void clearCombinaisonEnCours(){
        combinaisonEnCours.clear();
    }

    public void addALaMain(Carte carteAAdd) {
        main.add(carteAAdd);
    }
}
