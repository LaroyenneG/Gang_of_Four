package Model;

/**
 * Created by sangry on 21/11/16.
 */
public class Game {

    private int manche;
    private int joueurPlay;
    
    private Joueur[] tabJoueur = new Joueur[4];
    

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
        joueurPlay=firstPlayer();
        manche++;
    }

    public int firstPlayer(){
        /*
        a completer
         */
        return 0;
    }

    /*
    sens de rotation horaire j0->j1->j2->j3->j4 loop
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

    public int getJoueurPlay() {
        return joueurPlay;
    }

    public int getManche() {
        return manche;
    }
}

