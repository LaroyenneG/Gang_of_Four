package Model;

import java.util.Objects;

/**
 * Created by guillaume on 11/11/16.
 */


/*
    Il n'y a pas de getter et de setter dans cette classe, les attribue de la classe sont en public.
    Car les données des cartes non pas besoin d'etre modifié en dehors du constructeur. Donc pas besoin de faire un contrôle des données.
 */
public class Carte {
    public enum Couleur {
        ROUGE,
        JAUNE,
        MULTI,
        VERT;
    }

    public enum Figure{
        NOMBRE,
        DRAGON,
        PHENIX;
    }

    public int valeur;

    public Figure figure;
    public Couleur couleur;

    public Carte(int valeur, Couleur couleur){
        figure=Figure.NOMBRE;
        if (valeur<1||valeur>10){
            System.err.println("Carte : Invalid value");
        }
        if(couleur==Couleur.MULTI){
            System.err.println("Carte : Invalid constructor");
        }
        this.valeur=valeur;
        this.couleur=couleur;
    }

    public Carte(Couleur couleur){
        figure=Figure.NOMBRE;
        if(couleur!=Couleur.MULTI){
            System.err.println("Carte : Invalid constructor");
        }
        valeur=1;
        this.couleur=couleur;
    }

    public Carte(Figure figure, Couleur couleur){
        if(figure==Figure.DRAGON&&couleur!=Couleur.ROUGE){
            System.err.println("Carte : DRAGON invalid color");
        }

        if(figure==Figure.PHENIX&&couleur==Couleur.ROUGE){
            System.err.println("Carte : PHENIX invalid color");
        }
        if(figure==Figure.DRAGON){
            valeur=12;
        }else {
            valeur=11;
        }

        this.couleur=couleur;
        this.figure=figure;
    }

    public boolean equals(Object carte){
        if(!(carte instanceof Carte)){
            return false;
        }

        Carte test = (Carte)carte;

        if(valeur==test.valeur&&figure==test.figure&&couleur==test.couleur){
            return true;
        }
        return false;
    }

    public String toString(){
        String message="\nCarte : \n valeur="+valeur+"\n couleur="+couleur+"\n figure="+figure+"\n";
        return message;
    }
}
