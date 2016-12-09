package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangry on 21/11/16.
 */
public class Game {

    private int manche;
    private int joueurPlay;
    
    private Joueur[] tabJoueur = new Joueur[4];
    private int dernierGagnant;

    private List<Carte> table;

    public Game (){
        for (int i=0; i<4; i++){
            tabJoueur[i] = new Joueur();
        }
        distribuerCarte();
        for (int i=0; i<4; i++){
            tabJoueur[i].ordoMain();
        }

        manche=1;
        joueurPlay=firstPlayer();
        table=new ArrayList<>();
    }

    public Game (Joueur j1, Joueur j2, Joueur j3, Joueur j4){
        tabJoueur[0] = j1;
        tabJoueur[1] = j2;
        tabJoueur[2] = j3;
        tabJoueur[3] = j4;
        distribuerCarte();
        for (int i=0; i<4; i++){
            tabJoueur[i].ordoMain();
        }
        manche=1;
        joueurPlay=firstPlayer();
        table=new ArrayList<>();
    }

    public void distribuerCarte(){
        Deck deck= new Deck();
        deck.melangerDeck(); // j'ai ajouter la distrib pour voir si ça marche
        Carte[] tab= deck.getTabCarte();
        for (int i=0; i< tab.length; i++){
            if (i%4 == 0) tabJoueur[0].addALaMain(tab[i]);
            else if (i%4 == 1) tabJoueur[1].addALaMain(tab[i]);
            else if (i%4 == 2) tabJoueur[2].addALaMain(tab[i]);
            else if (i%4 == 3) tabJoueur[3].addALaMain(tab[i]);
        }
    }
    //// ajout des getters pour les joueurs
    public Joueur[] getTabJoueur() {
        return tabJoueur;
    }

    public Joueur getTabJoueurIndex(int indexTab){
        return tabJoueur[indexTab];
    }

    public void passerSonTour(int numJoueur){
        if (numJoueur < 0 || numJoueur > 3 ){
            System.err.println("Error passer son tour");
            return ;
        }
        tabJoueur[numJoueur].peutJouer=false;
    }

    public void nextManche(){
        for(int i=0; i<tabJoueur.length;i++){
            tabJoueur[i]=new Joueur();
        }
        distribuerCarte();
        manche++;
        joueurPlay=firstPlayer();
        table.clear();
    }

    public int firstPlayer(){
        if (manche==1){
            for (int i=0; i< 4; i++){
                if (tabJoueur[i].premiereCarte().equals(new Carte(Carte.Couleur.MULTI))){
                    return i;
                }

            }
        }
        else{
            return dernierGagnant;
        }
        System.err.println("Erreur premier joueur");
        return -1;
    }

    public boolean siGagne(Joueur j,int indexJoueur){
        if (j.getMain().size()==0){
               dernierGagnant = indexJoueur;
               return true;
        }
        return false;
    }

    /*
    sens de rotation horaire j0->j1->j2->j3 loop
    sens de rotation antihoraire j0->j3->j2->j1 loop
     */
    public void nextJoueur(){
        int sens;
        if (manche%2==0){
            sens=-1;
        }else {
            sens=1;
        }
        setJoueurPlay((joueurPlay+sens)%4);
        int count=0;
        while (!tabJoueur[joueurPlay].peutJouer){
            setJoueurPlay((joueurPlay+sens)%4);
            count++;
            if(count>tabJoueur.length){
                System.err.println("Error in nextJoueur(), no player can play");
                break;
            }
        }
    }

    private void setJoueurPlay(int j){
        if(j<-tabJoueur.length){
            System.err.println("Error in setJoueurPlay(), invalid j");
        }
        if(j < 0 ){
            j=j+tabJoueur.length;
        }
        if(joueurPlay==j){
            System.err.println("Error in setJoueurPlay(), value hasn't change");
        }
        joueurPlay=j;
    }

    public void poseTable(List<Carte> jeu){
        //provisoir
        for (Carte aJeu : jeu) {
            table.add(aJeu);
        }
    }

    public void clearTable(){
        table.clear();
    }

    public boolean joueurCanPlayCombinaison(int i){

        if(i<0 || i>tabJoueur.length){
            System.err.println("Error in joueurCanPlayCombinaison(), i is invalid");
            System.exit(-1);
        }

        if(!tabJoueur[i].peutJouer){
            return false;
        }

        List<Carte> combinaisonEnCours =tabJoueur[i].getCombinaisonEnCours();

        if (table.size()==0){
            if(AlgoCarte.cestQuoi(combinaisonEnCours)!=-1){
                return true;
            }
        }else {
            if(AlgoCarte.cestQuoi(table)==-1){
                System.err.println("Error master, combinator invalid in the table");
                System.exit(-1);
            }

            if(table.size()!=combinaisonEnCours.size()){
                if(AlgoCarte.cestQuoi(combinaisonEnCours)==6 && AlgoCarte.cestQuoi(table)!=6){
                    return true;
                }
                if(AlgoCarte.cestQuoi(table)==6 && AlgoCarte.cestQuoi(combinaisonEnCours)==6){
                    if(table.size()==combinaisonEnCours.size()){
                        return AlgoCarte.estPlusFort(combinaisonEnCours, table);
                    }else if(table.size()<combinaisonEnCours.size()){
                        return true;
                    }else {
                        return false;
                    }
                }
                return false;
            }

            //gang of for
            if(AlgoCarte.cestQuoi(table)==6&&AlgoCarte.cestQuoi(combinaisonEnCours)!=6){
                return false;
            }

            if(AlgoCarte.cestQuoi(table)!=5&&AlgoCarte.cestQuoi(table)==AlgoCarte.cestQuoi(combinaisonEnCours)){
                return AlgoCarte.estPlusFort(combinaisonEnCours,table);
            }

            //5 cartes
            if(AlgoCarte.cestQuoi(table)==5&&AlgoCarte.cestQuoi(combinaisonEnCours)==AlgoCarte.cestQuoi(table)){
                int levelTable=AlgoCarte.level(table);
                int levelcombi=AlgoCarte.level(combinaisonEnCours);
                if( levelTable== levelcombi){
                    return AlgoCarte.estPlusFort(combinaisonEnCours,table);
                }
                if( levelTable < levelcombi){
                    return true;
                }
            }

        }

        return false;
    }

    public int getJoueurPlay() {
        return joueurPlay;
    }

    public int getManche() {
        return manche;
    }

    public List<Carte> getTable(){
        return table;
    }
}

