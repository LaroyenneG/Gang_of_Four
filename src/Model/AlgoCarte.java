package model;

import java.util.List;

/**
 * Created by guillaume on 12/11/16.
 */
public class AlgoCarte {

    static List<Carte> trierCarte(List<Carte> carteList){
        Carte tabcarte[] =new Carte[carteList.size()];

        for (int i=0; i<tabcarte.length;i++){
            tabcarte[i]=carteList.get(i);
        }
        carteList.clear();

        boolean trier=false;
        while (!trier){
            trier=true;
            for (int i=0; i<tabcarte.length-1; i++){
                if (tabcarte[i].couleur==Carte.Couleur.MULTI&&i!=0){
                    Carte carte1 = tabcarte[0];
                    Carte carte2 = tabcarte[i];
                    tabcarte[0]=carte2;
                    tabcarte[i]=carte1;
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

        for (int i=0; i<tabcarte.length;i++){
            carteList.add(tabcarte[i]);
        }
        return carteList;
    }
}
