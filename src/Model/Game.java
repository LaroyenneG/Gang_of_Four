package Model;

/**
 * Created by sangry on 21/11/16.
 */
public class Game {

    private Joueur j1;
    private Joueur j2;
    private Joueur j3;
    private Joueur j4;


    public Game (){
        j1=new Joueur();
        j2=new Joueur();
        j3=new Joueur();
        j4=new Joueur();
    }

    public Game (Joueur j1, Joueur j2, Joueur j3, Joueur j4){
        this.j1=j1;
        this.j2=j2;
        this.j3=j3;
        this.j4=j4;
    }

    public void distribuerCarte(){
        Deck deck= new Deck();
        Carte[] tab= deck.getTabCarte();
        for (int i=0; i< tab.length; i++){
            if (i%4 == 0) j1.addALaMain(tab[i]);
            else if (i%4 == 1) j2.addALaMain(tab[i]);
            else if (i%4 == 2) j3.addALaMain(tab[i]);
            else if (i%4 == 3) j4.addALaMain(tab[i]);
        }
    }
}

