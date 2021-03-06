package Modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sangry on 21/11/16.
 */
public class Game {

    private int manche;
    private int joueurPlay;

    private Joueur[] tabJoueur;
    private int dernierGagnant;
    private int perdantDernierePartie;

    private List<Carte> table;
    private int i;

    public Game() {
        tabJoueur = new Joueur[4];

        tabJoueur[0] = new Joueur();
        for (int i = 1; i < tabJoueur.length; i++) {
            tabJoueur[i] = new IA();
        }
        distribuerCarte();
        for (int i = 0; i < 4; i++) {
            tabJoueur[i].ordoMain();
        }

        manche = 1;
        joueurPlay = firstPlayer();
        table = new ArrayList<>();
    }

    public Game(Joueur j1, Joueur j2, Joueur j3, Joueur j4) {
        tabJoueur = new Joueur[4];

        tabJoueur[0] = j1;
        tabJoueur[1] = j2;
        tabJoueur[2] = j3;
        tabJoueur[3] = j4;
        distribuerCarte();
        for (int i = 0; i < 4; i++) {
            tabJoueur[i].ordoMain();
        }
        manche = 1;
        joueurPlay = firstPlayer();
        table = new ArrayList<>();
    }

    public void distribuerCarte() {

        for (Joueur aTabJoueur : tabJoueur) {
            aTabJoueur.clearCombinaisonEnCours();
            aTabJoueur.clearMain();
        }

        Deck deck = new Deck();
        deck.melangerDeck(); // j'ai ajouter la distrib pour voir si ça marche
        Carte[] tab = deck.getTabCarte();
        for (int i = 0; i < tab.length; i++) {
            if (i % 4 == 0) tabJoueur[0].addALaMain(tab[i]);
            else if (i % 4 == 1) tabJoueur[1].addALaMain(tab[i]);
            else if (i % 4 == 2) tabJoueur[2].addALaMain(tab[i]);
            else if (i % 4 == 3) tabJoueur[3].addALaMain(tab[i]);
        }
    }

    //// ajout des getters pour les joueurs
    public Joueur[] getTabJoueur() {
        return tabJoueur;
    }

    public Joueur getTabJoueurIndex(int indexTab) {
        return tabJoueur[indexTab];
    }

    public void passerSonTour(int numJoueur) {
        if (numJoueur < 0 || numJoueur > 3) {
            System.err.println("Error passer son tour");
            return;
        }
        tabJoueur[numJoueur].peutJouer = false;
    }

    public void nextManche() {
        setQuiPerd();
        for (Joueur aTabJoueur : tabJoueur) {
            AlgoCarte.incrementScore(aTabJoueur);
            aTabJoueur.clearMain();
            aTabJoueur.peutJouer = true;
        }
        distribuerCarte();
        donDeLaMeilleurCarte();
        donDeLaCarteNulle(tabJoueur[perdantDernierePartie].getMain().get(0));
        manche++;
        table.clear();
        for (Joueur aTabJoueur : tabJoueur) aTabJoueur.ordoMain();
    }

    public int firstPlayer() {
        if (manche == 1) {
            for (int i = 0; i < 4; i++) {
                if (tabJoueur[i].premiereCarte().equals(new Carte(Carte.Couleur.MULTI))) {
                    return i;
                }

            }
        } else {
            return dernierGagnant;
        }

        return -1;
    }

    public boolean siGagne(int indexJoueur) {
        if (tabJoueur[indexJoueur].getMain().size() == 0 && tabJoueur[indexJoueur].getcombinaisonEnCours().size() == 0) {
            dernierGagnant = indexJoueur;
            return true;
        }
        return false;
    }

    public void setQuiPerd() {
        int perdantLocal = 0;
        int tamponQuiPerd = tabJoueur[0].getMain().size();
        for (int i = 1; i < 4; i++) {
            if (tabJoueur[i].getMain().size() > tamponQuiPerd) {
                tamponQuiPerd = tabJoueur[i].getMain().size();
                perdantLocal = i;
            }
        }
        perdantDernierePartie = perdantLocal;
    }

    public int getPerdantDernierePartie() {
        return perdantDernierePartie;
    }
    /*
    sens de rotation horaire j0->j1->j2->j3 loop
    sens de rotation antihoraire j0->j3->j2->j1 loop
     */

    private int nextJoueurOracle() {
        int memory = joueurPlay;
        int id = joueurPlay;
        int sens;
        if (manche % 2 == 0) {
            sens = -1;
        } else {
            sens = 1;
        }
        id = idJoueur((id + sens) % 4);
        int count = 0;
        while (!tabJoueur[id].peutJouer) {
            id = idJoueur((id + sens) % 4);
            count++;
            if (count > tabJoueur.length) {
                return memory;
            }
        }
        return id;
    }

    public void donDeLaMeilleurCarte() {
        AlgoCarte.trierCarte(tabJoueur[dernierGagnant].getMain());
        AlgoCarte.trierCarte(tabJoueur[perdantDernierePartie].getMain());
        tabJoueur[dernierGagnant].addALaMain(tabJoueur[perdantDernierePartie].getMain().get(tabJoueur[perdantDernierePartie].getMain().size() - 1));
        tabJoueur[perdantDernierePartie].getMain().remove(tabJoueur[perdantDernierePartie].getMain().get(15));
        AlgoCarte.trierCarte(tabJoueur[dernierGagnant].getMain());
        AlgoCarte.trierCarte(tabJoueur[perdantDernierePartie].getMain());
    }

    public void donDeLaCarteNulle(Carte carteADonner) {
        AlgoCarte.trierCarte(tabJoueur[dernierGagnant].getMain());
        AlgoCarte.trierCarte(tabJoueur[perdantDernierePartie].getMain());
        tabJoueur[perdantDernierePartie].addALaMain(carteADonner);
        tabJoueur[dernierGagnant].getMain().remove(tabJoueur[dernierGagnant].getMain().get(0));
        AlgoCarte.trierCarte(tabJoueur[dernierGagnant].getMain());
        AlgoCarte.trierCarte(tabJoueur[perdantDernierePartie].getMain());
    }

    public void nextJoueur() {
        int j = nextJoueurOracle();
        if (j == joueurPlay) {
            hardTable();
        } else {
            setJoueurPlay(nextJoueurOracle());
        }
    }

    private int idJoueur(int j) {
        if (j < 0) {
            j = j + tabJoueur.length;
        }
        return j;
    }

    public void poseTable(List<Carte> jeu) {
        clearTable();
        for (Carte aJeu : jeu) {
            table.add(aJeu);
        }
    }

    public void clearTable() {
        table.clear();
    }

    /*
    regarde si tout les joueurs on passe, si oui la table est vide
     */
    public void hardTable() {
        table.clear();

        for (Joueur aTabJoueur : tabJoueur) {
            aTabJoueur.peutJouer = true;
        }
    }

    public boolean joueurCanPlayCombinaison(int i) {
        if (i < 0 || i > tabJoueur.length) {
            System.err.println("Error in joueurCanPlayCombinaison(), i is invalid");
            System.exit(-1);
        }

        if (!tabJoueur[i].peutJouer) {
            return false;
        }

        return AlgoCarte.canPlayCombinaison(table, tabJoueur[i].getCombinaisonEnCours());
    }

    public boolean playerHasAnPossibilityToPlay(int i) {

        if (i < 0 || i > tabJoueur.length) {
            System.err.println("Error in playerHasAnPossibilityToPlay(), invalid i");
            System.exit(-5);
        }
        if (!tabJoueur[i].peutJouer) {
            return false;
        }
        List<Carte[][]> listCombi = AlgoCarte.getCombinaison(tabJoueur[i].getMain());

        for (Carte[][] combi : listCombi) {
            for (Carte[] aCombi : combi) {

                int multicouleur = -1;
                for (int z = 0; z < aCombi.length; z++) {
                    if (aCombi[z].couleur == Carte.Couleur.MULTI) {
                        multicouleur = z;
                        break;
                    }
                }

                List<Carte> aTester = new ArrayList<>();
                if (multicouleur != -1) {
                    Carte[] carteForSwitch = new Carte[3];
                    carteForSwitch[0] = new Carte(1, Carte.Couleur.VERT);
                    carteForSwitch[1] = new Carte(1, Carte.Couleur.JAUNE);
                    carteForSwitch[2] = new Carte(1, Carte.Couleur.ROUGE);

                    for (Carte aCarteForSwitch : carteForSwitch) {
                        aCombi[multicouleur] = aCarteForSwitch;
                        Collections.addAll(aTester, aCombi);
                        if (AlgoCarte.canPlayCombinaison(table, aTester)) {
                            return true;
                        }
                        aTester.clear();
                    }
                } else {
                    Collections.addAll(aTester, aCombi);
                    if (AlgoCarte.canPlayCombinaison(table, aTester)) {
                        return true;
                    }
                }
                aTester.clear();
            }
        }
        return false;
    }

    public void faireJouerIA() {

        if (joueurPlay != 0) {

            ((IA) tabJoueur[joueurPlay]).findBestCombination(table);

            List<Carte> combi = tabJoueur[joueurPlay].getCombinaisonEnCours();
            if (combi.size() > 0) {
                clearTable();
                poseTable(combi);
                tabJoueur[joueurPlay].clearCombinaisonEnCours();
            }
        } else {
            System.err.println("IA can't play play !");
        }
    }

    public Carte choixDeLaCouleurDuMulticolor(int couleurCarte) {
        if (couleurCarte == 0) return new Carte(1, Carte.Couleur.VERT);
        else if (couleurCarte == 1) return new Carte(1, Carte.Couleur.JAUNE);
        else if (couleurCarte == 2) return new Carte(1, Carte.Couleur.ROUGE);
        return null;
    }

    public int getJoueurPlay() {
        return joueurPlay;
    }

    private void setJoueurPlay(int j) {
        if (j < -tabJoueur.length) {
            System.err.println("Error in setJoueurPlay(), invalid j");
            System.exit(-1);
        }

        joueurPlay = j;
    }

    public List<Carte> getTable() {
        return table;
    }

    public String toString() {
        StringBuilder chaine = new StringBuilder("Game\n manche=" + manche + "\n joueurPlay=" + joueurPlay + "\n dernierGagnant=" + dernierGagnant + "\n perdantDernierePartie=" + perdantDernierePartie + "\n table=" + table.size() + "\n next joueur oracle=" + nextJoueurOracle() + "\n joueurs :\n");
        for (Joueur joueur : tabJoueur) {
            chaine.append(joueur);
        }
        return chaine.toString();
    }
}

