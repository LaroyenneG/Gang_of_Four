package Model;

/**
 * Created by sangry on 21/11/16.
 */
public class Game {

    private Joueur[] tabJoueur = new Joueur[4];


    public Game (){
        for (int i=0; i<4; i++){
            tabJoueur[i] = new Joueur();
        }
        distribuerCarte();
        for (int i=0; i<4; i++){
            tabJoueur[i].ordoMain();
        }
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
}

