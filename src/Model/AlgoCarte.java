package Model;

import java.util.ArrayList;
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

        if(list.size()<1||list.size()>7){
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


    public static boolean canPlayCombinaison(List<Carte> table, List<Carte> combinaisonAtester ){

        if (table.size()==0){
            if(AlgoCarte.cestQuoi(combinaisonAtester)!=-1&&AlgoCarte.cestQuoi(combinaisonAtester)!=0){
                return true;
            }
        }else {
            if(AlgoCarte.cestQuoi(table)==-1){
                System.err.println("Error master, combinator invalid in the table");
                System.exit(-1);
            }

            if(table.size()!=combinaisonAtester.size()){
                if(AlgoCarte.cestQuoi(combinaisonAtester)==6 && AlgoCarte.cestQuoi(table)!=6){
                    return true;
                }
                if(AlgoCarte.cestQuoi(table)==6 && AlgoCarte.cestQuoi(combinaisonAtester)==6){
                    if(table.size()==combinaisonAtester.size()){
                        return AlgoCarte.estPlusFort(combinaisonAtester, table);
                    }else if(table.size()<combinaisonAtester.size()){
                        return true;
                    }else {
                        return false;
                    }
                }
                return false;
            }

            //gang of for
            if(AlgoCarte.cestQuoi(table)==6&&AlgoCarte.cestQuoi(combinaisonAtester)!=6){
                return false;
            }

            if(AlgoCarte.cestQuoi(table)!=5&&AlgoCarte.cestQuoi(table)==AlgoCarte.cestQuoi(combinaisonAtester)){
                return AlgoCarte.estPlusFort(combinaisonAtester,table);
            }

            //5 cartes
            if(AlgoCarte.cestQuoi(table)==5&&AlgoCarte.cestQuoi(combinaisonAtester)==AlgoCarte.cestQuoi(table)){
                int levelTable=AlgoCarte.level(table);
                int levelcombi=AlgoCarte.level(combinaisonAtester);
                if( levelTable== levelcombi){
                    return AlgoCarte.estPlusFort(combinaisonAtester,table);
                }
                if( levelTable < levelcombi){
                    return true;
                }
            }

        }

        return false;
    }


    /*
    maths
     */


    public static long fact(int n){
        long x=1;
        for (int i=2; i<n+1;i++){
            x*=i;
        }
        return x;
    }

    public static long combi(int n, int k) {
        return fact(n)/(fact(k)*fact(n-k));
    }



    public static List<Carte[][]> getCombinaison(List<Carte> carteList){
        if(carteList.size()<1){
            System.err.println("Error in getCombinaison(), size=0");
            System.exit(-3);
        }

        List<Carte[][]> list = new ArrayList<>();

        for (int l=1; l<=carteList.size(); l++){

            List<Carte> copyList = new ArrayList<>();

            for (Carte aCarteList : carteList) {
                copyList.add(aCarteList);
            }

            List<Carte> combiN = combinaisonCarte(copyList, l, copyList.size()-l);
            Carte[][] tabCombo = new Carte[(int) combi(carteList.size(),l)][l];

            int i=0;
            for (int y=0; y<combi(carteList.size(),l); y++){
                for (int x=0; x<l;x++){
                    tabCombo[y][x]=combiN.get(i);
                    i++;
                }
            }


            list.add(tabCombo);
        }

        return list;
    }


    public static List<Carte> combinaisonCarte(List<Carte> list, int N, int k){
        int h=0;
        int i=0;
        int j=0;
        Integer n[] = new Integer[N-1];
        for (int z=0; z<N-1;z++){
            n[z]=0;
        }
        List<Carte> g = new ArrayList<>();
        List<Carte> s = new ArrayList<>();
        if(list.size()<N){
            return g;
        }else if(N==1){
            return list;
        }else if (list.size()==N){
            while (i<list.size()){
                s.add(list.get(i));
                i=i+1;
            }
            for (Carte value : s) {
                g.add(value);
            }
        }else if(list.size()>N){
            int l= (int) (fact(list.size()-1)/(fact(N-1)*fact((list.size()-1)-(N-1))));
            while (i<l){
                s.clear();
                s.add(list.get(list.size()-1));
                while (h<n.length){
                    if(j>0 && j<n.length){
                        n[j]=n[j-1]+1;
                    }
                    s.add(list.get(n[h]));
                    h=h+1;
                    j=j+1;
                }
                for (Carte value : s) {
                    g.add(value);
                }
                h=0;
                j=0;
                while (j<n.length && n[j]!=j+k){
                    j=j+1;
                }
                if(j>0){
                    n[j-1]=n[j-1]+1;
                }
                i=i+1;
            }
            list.remove(list.size()-1);
            List<Carte> newList = combinaisonCarte(list,N,k-1);
            for (Carte aNewList : newList) {
                g.add(aNewList);
            }

        }
        return g;
    }

    public static void incrementScore(Joueur joueur){
        int addAuScore , nbDeCarteFinDeManche;
        nbDeCarteFinDeManche = joueur.getMain().size();
        if (nbDeCarteFinDeManche <= 7) addAuScore = nbDeCarteFinDeManche;
        else if (nbDeCarteFinDeManche <= 10) addAuScore = nbDeCarteFinDeManche*2;
        else if (nbDeCarteFinDeManche <= 13) addAuScore = nbDeCarteFinDeManche*3;
        else if (nbDeCarteFinDeManche <= 15) addAuScore = nbDeCarteFinDeManche*4;
        else addAuScore = 80;
        joueur.setScore(joueur.getScore()+addAuScore);

    }
}
