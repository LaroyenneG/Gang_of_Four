package Model;

import java.util.List;

/**
 * Created by guillaume on 12/11/16.
 */
public class AlgoCarte {

    /*
    L'algo fonctionne mais il transforme provisoirement la liste en tableau.
     */
    static List<Carte> trierCarte(List<Carte> carteList){
        Carte tabcarte[] =new Carte[carteList.size()];
        for (int i=0; i<tabcarte.length;i++){
            tabcarte[i]=carteList.get(i);
        }
        carteList.clear();
        tabcarte=trierCarte(tabcarte);
        for (int i=0; i<tabcarte.length;i++){
            carteList.add(tabcarte[i]);
        }
        return carteList;
    }

    static Carte[] trierCarte(Carte[] tabcarte){
        boolean trier=false;
        while (!trier){
            trier=true;
            for (int i=0; i<tabcarte.length-1; i++){
                if (tabcarte[i].couleur==Carte.Couleur.MULTI&&i!=0){
                    Carte carte1 = tabcarte[0];
                    Carte carte2 = tabcarte[i];
                    tabcarte[0]=carte2;
                    tabcarte[i]=carte1;
                    trier=false;
                }
                if(tabcarte[i].valeur>tabcarte[i+1].valeur){
                    Carte carte1 = tabcarte[i];
                    Carte carte2 = tabcarte[i+1];
                    tabcarte[i]=carte2;
                    tabcarte[i+1]=carte1;
                    trier=false;
                }
                if((tabcarte[i].couleur==Carte.Couleur.ROUGE&&tabcarte[i+1].couleur==Carte.Couleur.JAUNE&&tabcarte[i].valeur==tabcarte[i+1].valeur)
                        ||(tabcarte[i].couleur==Carte.Couleur.ROUGE&&tabcarte[i+1].couleur==Carte.Couleur.VERT&&tabcarte[i].valeur==tabcarte[i+1].valeur)
                        ||(tabcarte[i].couleur==Carte.Couleur.JAUNE&&tabcarte[i+1].couleur==Carte.Couleur.VERT&&tabcarte[i].valeur==tabcarte[i+1].valeur)
                        ){
                    Carte carte1 = tabcarte[i];
                    Carte carte2 = tabcarte[i+1];
                    tabcarte[i]=carte2;
                    tabcarte[i+1]=carte1;
                    trier=false;
                }
            }
        }
        return tabcarte;
    }

    static boolean gangOfN(List<Carte> carteAJouer){
        int n,i;
        n=carteAJouer.size();
        if (n < 4 || n > 7 ) {
            return false;
        }
        for (i = 1; i<n ; i++) {
            if (carteAJouer.get(0).valeur != carteAJouer.get(i).valeur){
                return false;
            }
        }
        return true;
    }

    static boolean combinaisonDe1carte(List<Carte> carteAJouer){
        return carteAJouer.size() == 1;
    }

    static boolean combinaisonDe2cartes(List<Carte> carteAJouer) {
        int i;
        return carteAJouer.size() == 2 && carteAJouer.get(0).valeur == carteAJouer.get(1).valeur;

    }

    static boolean combinaisonDe3cartes(List<Carte> carteAJouer){
        int i;
        if (carteAJouer.size() != 3){
            return false;
        }
        for (i = 1; i < 2 ; i++) {
            if (carteAJouer.get(0).valeur != carteAJouer.get(i).valeur){
                return false;
            }
        }
        return true;
    }

    static boolean cominaisonDe5Cartes(List<Carte> carteAJouerNonTriees){
        List<Carte> carteAJouer = trierCarte(carteAJouerNonTriees);
        if (carteAJouer.size() != 5) return false;
        if (estUneSuite(carteAJouer) || estUneCouleur(carteAJouer) || estUneSuiteCouleur(carteAJouer) || estUnFull(carteAJouer)) return true;
        else return false;
    }

    static boolean estUneSuite(List<Carte> carteAJouerNonTriees){ // A tester après le test de la suite Couleur
        List<Carte> carteAJouer = trierCarte(carteAJouerNonTriees);
        for (int j = 0; j < 5; j++){
            if (carteAJouer.get(j).figure != Carte.Figure.NOMBRE){
                return false;
            }
        }
        for (int i = 1; i < 5; i++){
            if (carteAJouer.get(0).valeur != carteAJouer.get(i).valeur -i ){
                return false;
            }
        }
        return true;
    }

    static boolean estUneCouleur(List<Carte> carteAJouerNonTriees){ // A tester après le test de la suite Couleur
        List<Carte> carteAJouer = trierCarte(carteAJouerNonTriees);
        for (int j = 0; j < 5; j++){
            if (carteAJouer.get(j).figure != Carte.Figure.NOMBRE){
                return false;
            }
        }
        for (int i = 1; i < 5; i++){
            if (carteAJouer.get(0).couleur != carteAJouer.get(i).couleur ){
                return false;
            }
        }
        return true;
    }

    static boolean estUneSuiteCouleur(List<Carte> carteAJouer){ // a Tester avant de tester si la combinaison est une suite ou une couleur
        return estUneCouleur(carteAJouer) && estUneSuite(carteAJouer);
    }

    static boolean estUnFull(List<Carte> carteAJouerNonTriees){
        List<Carte> carteAJouer = trierCarte(carteAJouerNonTriees);
        if ((carteAJouer.get(0).valeur == carteAJouer.get(1).valeur) && (carteAJouer.get(3).valeur == carteAJouer.get(4).valeur) && (carteAJouer.get(0).valeur != carteAJouer.get(4).valeur)){
            if (carteAJouer.get(2).valeur == carteAJouer.get(1).valeur || carteAJouer.get(2).valeur == carteAJouer.get(3).valeur){
                return true;
            }
        }
        return false;
    }
}
