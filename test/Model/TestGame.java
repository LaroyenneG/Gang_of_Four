package Model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sangry on 21/11/16.
 */
public class TestGame {

    private int after(int i,boolean horaire){
        int next;
        if(horaire){
            next = (i+1)%4;
        }else {
            next = (i-1)%4;
        }
        if(next<0){
            next=next+4;
        }
        return next;
    }

    @Test
    public void testDistribution(){
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        Joueur j3 = new Joueur();
        Joueur j4 = new Joueur();
        Game game = new Game(j1,j2,j3,j4);

        List<Carte> l1 = j1.getMain();
        List<Carte> l2 = j2.getMain();
        List<Carte> l3 = j3.getMain();
        List<Carte> l4 = j4.getMain();

        Assert.assertEquals(l1.size(),16);
        Assert.assertEquals(l2.size(),16);
        Assert.assertEquals(l3.size(),16);
        Assert.assertEquals(l4.size(),16);

        Carte[] tabPrincipale;
        tabPrincipale=new Carte[64];
        for (int i = 0; i< 16; i++){
            tabPrincipale[i*4] =l1.get(i);
            tabPrincipale[i*4+1]=l2.get(i);
            tabPrincipale[i*4+2]=l3.get(i);
            tabPrincipale[i*4+3]=l4.get(i);
        }
        AlgoCarte.trierCarte(tabPrincipale);
        Deck deck2 = new Deck();
        Carte[] tab2 = deck2.getTabCarte();
        AlgoCarte.trierCarte(tab2);

        int compteur = 0;
        for (int i =0; i< 64; i++){
            if (tabPrincipale[i].equals(tab2[i]))
                compteur++;
        }
        Assert.assertEquals(compteur,tabPrincipale.length);
    }

    @Test
    public void testPasserSonTour(){
        Game game = new Game();
        for(int i=0; i<game.getTabJoueur().length;i++){
            Assert.assertTrue(game.getTabJoueur()[i].peutJouer);
        }
        game.passerSonTour(1);
        Assert.assertFalse(game.getTabJoueur()[1].peutJouer);
        Assert.assertTrue(game.getTabJoueur()[0].peutJouer);
        Assert.assertTrue(game.getTabJoueur()[2].peutJouer);
        Assert.assertTrue(game.getTabJoueur()[3].peutJouer);
    }

    @Test
    public void testNextJoueur(){
        Game game = new Game();
        int manche = game.getManche();
        for (int i=0; i<20;i++){
            int player=game.getJoueurPlay();
            game.nextJoueur();
            if(manche%2==1){
                if (game.getTabJoueurIndex(after(player,true)).peutJouer){
                    Assert.assertEquals(game.getJoueurPlay(),after(player,true));
                }else {
                    Assert.assertNotEquals(game.getJoueurPlay(),after(player,true));
                }
            }else {
                if (game.getTabJoueurIndex(after(player, false)).peutJouer) {
                    Assert.assertEquals(game.getJoueurPlay(), after(player, false));
                } else {
                    Assert.assertNotEquals(game.getJoueurPlay(), after(player, false));
                }
            }
            if(i==2||i==12){
                game.getTabJoueurIndex(2).peutJouer=false;
            }
            if(i==3||i==13){
                game.getTabJoueurIndex(1).peutJouer=false;
            }
            if(i==8||i==18){
                game.getTabJoueurIndex(0).peutJouer=false;
            }
            if(i==10){
                game.nextManche();
                manche = game.getManche();
            }
        }
    }

    @Test
    public void testQuiGagne(){
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        Joueur j3 = new Joueur();
        Joueur j4 = new Joueur();
        List<Carte> l1 = j1.getMain();
        Game game = new Game(j1,j2,j3,j4);
        Assert.assertFalse(game.siGagne(j1, 0 ));
        Assert.assertFalse(game.siGagne(j2, 1 ));
        Assert.assertFalse(game.siGagne(j3, 2 ));
        Assert.assertFalse(game.siGagne(j4, 3 ));
        l1.clear();
        Assert.assertTrue(game.siGagne(j1,0));
    }

    @Test
    public void testFirstPlayer(){
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        Joueur j3 = new Joueur();
        Joueur j4 = new Joueur();
        Game game = new Game(j1,j2,j3,j4);
        int premierJ = game.firstPlayer();
        Joueur[] tabJoueur = game.getTabJoueur();
        Assert.assertTrue(tabJoueur[premierJ].premiereCarte().equals(new Carte(Carte.Couleur.MULTI)));
    }

    @Test
    public void testJoueurCanPlayCombinaison(){
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        Joueur j3 = new Joueur();
        Joueur j4 = new Joueur();
        Game game = new Game(j1,j2,j3,j4);

        List<Carte> carteList = new ArrayList<>();

        /*
        passe son tour
         */
        j2.peutJouer=false;
        j2.addCombinaisonEnCours(new Carte(1, Carte.Couleur.JAUNE));
        Assert.assertFalse(game.joueurCanPlayCombinaison(1));

        /*
        1 carte
         */
        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();
        carteList.add(new Carte(5, Carte.Couleur.VERT));
        game.poseTable(carteList);
        j1.addCombinaisonEnCours(new Carte(4, Carte.Couleur.JAUNE));

        Assert.assertFalse(game.joueurCanPlayCombinaison(0));


        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();
        carteList.add(new Carte(4, Carte.Couleur.VERT));
        game.poseTable(carteList);
        j1.addCombinaisonEnCours(new Carte(4, Carte.Couleur.JAUNE));

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));

        /*
        pair et brelan
         */
        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();
        carteList.add(new Carte(4, Carte.Couleur.VERT));
        carteList.add(new Carte(5, Carte.Couleur.JAUNE));
        game.poseTable(carteList);

        j1.addCombinaisonEnCours(new Carte(4, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.JAUNE));

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));


        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();
        carteList.add(new Carte(5, Carte.Couleur.VERT));
        carteList.add(new Carte(5, Carte.Couleur.JAUNE));
        carteList.add(new Carte(5, Carte.Couleur.JAUNE));
        game.poseTable(carteList);

        j1.addCombinaisonEnCours(new Carte(4, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(4, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(4, Carte.Couleur.ROUGE));

        Assert.assertFalse(game.joueurCanPlayCombinaison(0));



        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();
        carteList.add(new Carte(4, Carte.Couleur.VERT));
        carteList.add(new Carte(5, Carte.Couleur.JAUNE));
        game.poseTable(carteList);

        j1.addCombinaisonEnCours(new Carte(4, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.JAUNE));

        Assert.assertFalse(game.joueurCanPlayCombinaison(0));

        /*
        gang of N
         */
        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();
        carteList.add(new Carte(4, Carte.Couleur.VERT));
        carteList.add(new Carte(4, Carte.Couleur.JAUNE));
        carteList.add(new Carte(4, Carte.Couleur.VERT));
        carteList.add(new Carte(4, Carte.Couleur.ROUGE));
        game.poseTable(carteList);

        j1.addCombinaisonEnCours(new Carte(9, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(9, Carte.Couleur.JAUNE));

        Assert.assertFalse(game.joueurCanPlayCombinaison(0));


        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();
        carteList.add(new Carte(9, Carte.Couleur.VERT));
        carteList.add(new Carte(9, Carte.Couleur.JAUNE));
        game.poseTable(carteList);

        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.ROUGE));
        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.VERT));

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));

        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();
        carteList.add(new Carte(3, Carte.Couleur.VERT));
        carteList.add(new Carte(3, Carte.Couleur.JAUNE));
        carteList.add(new Carte(3, Carte.Couleur.VERT));
        carteList.add(new Carte(3, Carte.Couleur.ROUGE));
        game.poseTable(carteList);

        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.ROUGE));
        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.VERT));

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));

        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();
        carteList.add(new Carte(3, Carte.Couleur.VERT));
        carteList.add(new Carte(3, Carte.Couleur.JAUNE));
        carteList.add(new Carte(3, Carte.Couleur.ROUGE));
        carteList.add(new Carte(3, Carte.Couleur.ROUGE));
        game.poseTable(carteList);

        j1.addCombinaisonEnCours(new Carte(1, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(1, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(1, Carte.Couleur.ROUGE));
        j1.addCombinaisonEnCours(new Carte(1, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(1, Carte.Couleur.VERT));

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));


        /*
        pour une suite simple
         */
        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();

        carteList.add(new Carte(4, Carte.Couleur.VERT));
        carteList.add(new Carte(5, Carte.Couleur.JAUNE));
        carteList.add(new Carte(6, Carte.Couleur.JAUNE));
        carteList.add(new Carte(7, Carte.Couleur.VERT));
        carteList.add(new Carte(8, Carte.Couleur.JAUNE));


        j1.addCombinaisonEnCours(new Carte(4, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(6, Carte.Couleur.ROUGE));
        j1.addCombinaisonEnCours(new Carte(7, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(8, Carte.Couleur.ROUGE));
        game.poseTable(carteList);

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));


        carteList.clear();
        j1.clearCombinaisonEnCours();
        game.clearTable();

        carteList.add(new Carte(4, Carte.Couleur.VERT));
        carteList.add(new Carte(5, Carte.Couleur.JAUNE));
        carteList.add(new Carte(6, Carte.Couleur.JAUNE));
        carteList.add(new Carte(7, Carte.Couleur.ROUGE));
        carteList.add(new Carte(8, Carte.Couleur.ROUGE));


        j1.addCombinaisonEnCours(new Carte(4, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(6, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(7, Carte.Couleur.ROUGE));
        j1.addCombinaisonEnCours(new Carte(8, Carte.Couleur.JAUNE));
        game.poseTable(carteList);

        Assert.assertFalse(game.joueurCanPlayCombinaison(0));

        //suite couleur
        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();

        carteList.add(new Carte(2, Carte.Couleur.ROUGE));
        carteList.add(new Carte(5, Carte.Couleur.ROUGE));
        carteList.add(new Carte(6, Carte.Couleur.ROUGE));
        carteList.add(new Carte(7, Carte.Couleur.ROUGE));
        carteList.add(new Carte(8, Carte.Couleur.ROUGE));


        j1.addCombinaisonEnCours(new Carte(2, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(7, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(8, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(9, Carte.Couleur.VERT));
        game.poseTable(carteList);

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));

        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();

        carteList.add(new Carte(2, Carte.Couleur.ROUGE));
        carteList.add(new Carte(5, Carte.Couleur.ROUGE));
        carteList.add(new Carte(6, Carte.Couleur.ROUGE));
        carteList.add(new Carte(7, Carte.Couleur.ROUGE));
        carteList.add(new Carte(9, Carte.Couleur.ROUGE));


        j1.addCombinaisonEnCours(new Carte(2, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(6, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(7, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(8, Carte.Couleur.VERT));
        game.poseTable(carteList);

        Assert.assertFalse(game.joueurCanPlayCombinaison(0));

        //suite de couleur
        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();

        carteList.add(new Carte(2, Carte.Couleur.ROUGE));
        carteList.add(new Carte(3, Carte.Couleur.ROUGE));
        carteList.add(new Carte(4, Carte.Couleur.ROUGE));
        carteList.add(new Carte(5, Carte.Couleur.ROUGE));
        carteList.add(new Carte(6, Carte.Couleur.ROUGE));


        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(4, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(6, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(7, Carte.Couleur.VERT));
        game.poseTable(carteList);

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));

        //full
        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();

        carteList.add(new Carte(3, Carte.Couleur.VERT));
        carteList.add(new Carte(3, Carte.Couleur.VERT));
        carteList.add(new Carte(3, Carte.Couleur.JAUNE));
        carteList.add(new Carte(4, Carte.Couleur.ROUGE));
        carteList.add(new Carte(4, Carte.Couleur.ROUGE));


        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.ROUGE));
        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.ROUGE));
        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.VERT));
        game.poseTable(carteList);

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));

        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();

        carteList.add(new Carte(2, Carte.Couleur.JAUNE));
        carteList.add(new Carte(2, Carte.Couleur.ROUGE));
        carteList.add(new Carte(6, Carte.Couleur.JAUNE));
        carteList.add(new Carte(6, Carte.Couleur.ROUGE));
        carteList.add(new Carte(6, Carte.Couleur.ROUGE));


        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.ROUGE));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.ROUGE));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.ROUGE));
        game.poseTable(carteList);

        Assert.assertFalse(game.joueurCanPlayCombinaison(0));

        /*
        vs
         */
        //suite vs couleur
        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();

        carteList.add(new Carte(4, Carte.Couleur.VERT));
        carteList.add(new Carte(5, Carte.Couleur.JAUNE));
        carteList.add(new Carte(6, Carte.Couleur.JAUNE));
        carteList.add(new Carte(7, Carte.Couleur.VERT));
        carteList.add(new Carte(8, Carte.Couleur.JAUNE));

        j1.addCombinaisonEnCours(new Carte(2, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(7, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(8, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(9, Carte.Couleur.VERT));
        game.poseTable(carteList);

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));

        //couleur vs full
        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();

        carteList.add(new Carte(1, Carte.Couleur.ROUGE));
        carteList.add(new Carte(3, Carte.Couleur.ROUGE));
        carteList.add(new Carte(4, Carte.Couleur.ROUGE));
        carteList.add(new Carte(5, Carte.Couleur.ROUGE));
        carteList.add(new Carte(6, Carte.Couleur.ROUGE));

        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.ROUGE));
        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.ROUGE));
        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.VERT));
        game.poseTable(carteList);

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));


        //full vs suite de couleur
        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();

        carteList.add(new Carte(3, Carte.Couleur.VERT));
        carteList.add(new Carte(3, Carte.Couleur.VERT));
        carteList.add(new Carte(3, Carte.Couleur.JAUNE));
        carteList.add(new Carte(4, Carte.Couleur.ROUGE));
        carteList.add(new Carte(4, Carte.Couleur.ROUGE));

        j1.addCombinaisonEnCours(new Carte(3, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(4, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(5, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(6, Carte.Couleur.VERT));
        j1.addCombinaisonEnCours(new Carte(7, Carte.Couleur.VERT));
        game.poseTable(carteList);

        Assert.assertTrue(game.joueurCanPlayCombinaison(0));

        //suite couleur vs gang of n

        /*
        game.clearTable();
        carteList.clear();
        j1.clearCombinaisonEnCours();

        carteList.add(new Carte(2, Carte.Couleur.ROUGE));
        carteList.add(new Carte(3, Carte.Couleur.ROUGE));
        carteList.add(new Carte(4, Carte.Couleur.ROUGE));
        carteList.add(new Carte(5, Carte.Couleur.ROUGE));
        carteList.add(new Carte(6, Carte.Couleur.ROUGE));

        j1.addCombinaisonEnCours(new Carte(9, Carte.Couleur.JAUNE));
        j1.addCombinaisonEnCours(new Carte(9, Carte.Couleur.JAUNE));

        Assert.assertFalse(game.joueurCanPlayCombinaison(0));
        */
    }
}
