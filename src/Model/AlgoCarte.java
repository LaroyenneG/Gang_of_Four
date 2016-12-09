package Model;

import java.util.List;

/**
 * Created by guillaume on 12/11/16.
 */
public class AlgoCarte {

    /*
    L'algo fonctionne mais il transforme provisoirement la liste en tableau.
     */
    public static List<Carte> trierCarte(List<Carte> carteList){
        Carte tabcarte[] =new Carte[carteList.size()];
        for (int i=0; i<tabcarte.length;i++){
            tabcarte[i]=carteList.get(i);
        }
        carteList.clear();
        tabcarte=trierCarte(tabcarte);
        for (Carte aTabcarte : tabcarte) {
            carteList.add(aTabcarte);
        }
        return carteList;
    }

    public static Carte[] trierCarte(Carte[] tabcarte){
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

    public static boolean gangOfN(List<Carte> carteAJouer){
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

    public static boolean combinaisonDe1carte(List<Carte> carteAJouer){
        return carteAJouer.size() == 1;
    }

    public static boolean combinaisonDe2cartes(List<Carte> carteAJouer) {
        int i;
        return carteAJouer.size() == 2 && carteAJouer.get(0).valeur == carteAJouer.get(1).valeur;
    }

    public static boolean combinaisonDe3cartes(List<Carte> carteAJouer){
        int i;
        if (carteAJouer.size() != 3){
            return false;
        }
        for (i = 1; i < 3 ; i++) {
            if (carteAJouer.get(0).valeur != carteAJouer.get(i).valeur){
                return false;
            }
        }
        return true;
    }

    public static boolean combinaisonDe5Cartes(List<Carte> carteAJouerNonTriees){
        List<Carte> carteAJouer = trierCarte(carteAJouerNonTriees);
        if (carteAJouer.size() != 5) return false;
        if (estUneSuite(carteAJouer) || estUneCouleur(carteAJouer) || estUneSuiteCouleur(carteAJouer) || estUnFull(carteAJouer)) return true;
        else return false;
    }

    public static boolean estUneSuite(List<Carte> carteAJouerNonTriees){ // A tester après le test de la suite Couleur
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

    public static boolean estUneCouleur(List<Carte> carteAJouerNonTriees){ // A tester après le test de la suite Couleur
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

    public static boolean estUneSuiteCouleur(List<Carte> carteAJouer){ // a Tester avant de tester si la combinaison est une suite ou une couleur
        return estUneCouleur(carteAJouer) && estUneSuite(carteAJouer);
    }

    public static boolean estUnFull(List<Carte> carteAJouerNonTriees){
        List<Carte> carteAJouer = trierCarte(carteAJouerNonTriees);
        if ((carteAJouer.get(0).valeur == carteAJouer.get(1).valeur) && (carteAJouer.get(3).valeur == carteAJouer.get(4).valeur) && (carteAJouer.get(0).valeur != carteAJouer.get(4).valeur)){
            if (carteAJouer.get(2).valeur == carteAJouer.get(1).valeur || carteAJouer.get(2).valeur == carteAJouer.get(3).valeur){
                return true;
            }
        }
        return false;
    }


    public static int cestQuoi(List<Carte> list){

        if(list.size()<1||list.size()>5){
            return -1;
        }
        if(AlgoCarte.combinaisonDe1carte(list)){
            return 1;
        }
        if(AlgoCarte.combinaisonDe2cartes(list)){
            return 2;
        }
        if(AlgoCarte.combinaisonDe3cartes(list)){
            return 3;
        }
        if(AlgoCarte.combinaisonDe5Cartes(list)){
            return 5;
        }
        if(AlgoCarte.gangOfN(list)){
            return 6;
        }

        return 0;
    }

    public static int colorValue(Carte.Couleur c){
        if(Carte.Couleur.VERT==c){
            return 1;
        }
        if(Carte.Couleur.JAUNE==c){
            return 2;
        }
        if(Carte.Couleur.ROUGE==c){
            return 3;
        }
        System.err.println("Error in colorValue(), color invalid");
        System.exit(-6);
        return 0;
    }

    public static int level(List<Carte> list){
        if(cestQuoi(list)!=5){
            return 0;
        }
        if(estUneSuite(list)&&!estUneCouleur(list)){
            return 1;
        }
        if(estUneCouleur(list)&&!estUneSuiteCouleur(list)){
            return 2;
        }
        if(estUnFull(list)){
            return 3;
        }
        if(estUneSuiteCouleur(list)){
            return 4;
        }
        return 0;
    }


    /*
    return true if cartes1 > cartes2
     */
    public static boolean estPlusFort(List<Carte> cartes1, List<Carte> cartes2){
        //on trie les cartes
        cartes1=trierCarte(cartes1);
        cartes2=trierCarte(cartes2);

        if(cartes1.size()!=cartes2.size()){
            System.err.println("Error in estPlusFort(), size of list is not equals");
            System.exit(-5);
        }

        int somme1=0;
        int somme2=0;

        for (Carte aCartes1 : cartes1) {
            somme1 += aCartes1.valeur;
        }
        for (Carte aCartes2 : cartes2) {
            somme2 += aCartes2.valeur;
        }

        if(somme1>somme2){
            return true;
        }

        if(somme1<somme2){
            return false;
        }

        for (int i=cartes1.size()-1; i>=0; i--){
            if(cartes1.get(i).valeur<cartes2.get(i).valeur){
                return false;
            }else {
                if(cartes1.get(i).valeur==cartes2.get(i).valeur){
                    if(colorValue(cartes1.get(i).couleur)>colorValue(cartes2.get(i).couleur)){
                        return true;
                    }
                    if(colorValue(cartes1.get(i).couleur)<colorValue(cartes2.get(i).couleur)){
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
