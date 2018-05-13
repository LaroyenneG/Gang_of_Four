package Modele;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guillaume LAROYENNE on 12/11/16.
 */
public class Joueur {
    public boolean peutJouer;
    public boolean combiMulti;
    protected List<Carte> main;
    protected List combinaisonEnCours;
    protected int score;

    public Joueur() {
        main = new ArrayList<Carte>();
        score = 0;
        peutJouer = true;
        combinaisonEnCours = new ArrayList<>();
        combiMulti = false;
    }

    public Joueur(List<Carte> main) {
        this.main = main;
        score = 0;
        peutJouer = true;
        combinaisonEnCours = new ArrayList<>();
    }

    /*
    prend la carte du rang i dans la main et la place dans combinaison en cours
     */
    public boolean veutJouer(int i) {
        if (i < 0 || i >= main.size()) {
            System.err.println("Error in veutJouer(), i invalid");
            return false;
        }
        if (addCombinaisonEnCours(main.get(i))) {
            main.remove(i);
            return true;
        }
        return false;
    }

    /*
    annule la combinaison en cours
     */
    public void resetCombinaison() {

        main.addAll(combinaisonEnCours);
        combinaisonEnCours.clear();
        ordoMain();
    }

    public void resetCombinaison(Carte c) {

        if (combiMulti) {
            boolean trouver = false;
            for (int i = 0; i < combinaisonEnCours.size(); i++) {
                if (combinaisonEnCours.get(i).equals(c) && !trouver) {
                    combinaisonEnCours.remove(i);
                    combinaisonEnCours.add(new Carte(Carte.Couleur.MULTI));
                    trouver = true;

                }
                main.addAll(combinaisonEnCours);
                combinaisonEnCours.clear();
                ordoMain();
            }
        } else {
            main.addAll(combinaisonEnCours);
            combinaisonEnCours.clear();
            ordoMain();
        }

    }

    public void ordoMain() {
        main = AlgoCarte.trierCarte(main);
    }

    public List<Carte> getMain() {
        return main;
    }

    public void printMain() {
        for (Carte aMain : main) {
            System.out.print(aMain);
        }
    }

    public Carte premiereCarte() {
        if (main.size() > 0)
            return main.get(0);
        else return null;
    }

    public void clearMain() {
        main.clear();
    }

    public boolean addCombinaisonEnCours(Carte carte) {
        if (combinaisonEnCours.size() < 7) {
            combinaisonEnCours.add(carte);
            return true;
        }
        return false;
    }

    public boolean plusQuUneCarte() {
        return main.size() == 1;
    }

    public Carte plusForteCarte() {
        if (main.size() == 0) {
            return null;
        }
        return main.get(main.size() - 1);
    }

    public void passeSonTour() {
        peutJouer = false;
    }

    public List<Carte> getCombinaisonEnCours() {
        return combinaisonEnCours;
    }

    public void clearCombinaisonEnCours() {
        combinaisonEnCours.clear();
    }

    public void addALaMain(Carte carteAAdd) {
        main.add(carteAAdd);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        String chaine = "Joueur\n main=" + main.size() + "\n combinaisonEnCours=" + combinaisonEnCours.size() + "\n peutJouer=" + peutJouer + "\n score=" + score + "\n";
        return chaine;
    }


    public List<Carte> getcombinaisonEnCours() {
        return combinaisonEnCours;
    }
}
