package Modele;

/**
 * Created by guillaume on 11/11/16.
 */


public class Carte {

    public int valeur;
    public Figure figure;
    public Couleur couleur;

    public Carte(int valeur, Couleur couleur) {
        figure = Figure.NOMBRE;
        if (valeur < 1 || valeur > 10) {
            System.err.println("Carte : Invalid value");
        }
        if (couleur == Couleur.MULTI) {
            System.err.println("Carte : Invalid constructor");
        }
        this.valeur = valeur;
        this.couleur = couleur;
    }
    public Carte(Couleur couleur) {
        figure = Figure.NOMBRE;
        if (couleur != Couleur.MULTI) {
            System.err.println("Carte : Invalid constructor");
        }
        valeur = 1;
        this.couleur = couleur;
    }

    public Carte(Figure figure, Couleur couleur) {
        if (figure == Figure.DRAGON && couleur != Couleur.ROUGE) {
            System.err.println("Carte : DRAGON invalid color");
        }

        if (figure == Figure.PHENIX && couleur == Couleur.ROUGE) {
            System.err.println("Carte : PHENIX invalid color");
        }
        if (figure == Figure.DRAGON) {
            valeur = 12;
        } else {
            valeur = 11;
        }

        this.couleur = couleur;
        this.figure = figure;
    }

    /*
    getFileName()
    cette methode returne le String correspondant au nom du fichier de l'image de la carte.
    PS : ne pas oublier de completer les tests dans la methode testGetFileName.
     */
    public String getFileName() {
        String color = "";
        String fileName = "";
        if (couleur == Couleur.VERT) color = "vert";
        else if (couleur == Couleur.JAUNE) color = "jaune";
        else if (couleur == Couleur.ROUGE) color = "rouge";
        else if (couleur == Couleur.MULTI) color = "multicolor";

        if (figure == Figure.NOMBRE) fileName = valeur + color;
        else if (figure == Figure.PHENIX) fileName = figure + color;
        else if (figure == Figure.DRAGON) fileName = figure + color;

        return fileName + ".jpg";
    }

    public boolean equals(Object carte) {
        if (!(carte instanceof Carte)) {
            return false;
        }

        Carte test = (Carte) carte;

        if (valeur == test.valeur && figure == test.figure && couleur == test.couleur) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "\nCarte : \n valeur=" + valeur + "\n couleur=" + couleur + "\n figure=" + figure + "\n";
    }

    public enum Couleur {
        ROUGE,
        JAUNE,
        MULTI,
        VERT;
    }

    public enum Figure {
        NOMBRE,
        DRAGON,
        PHENIX;
    }
}
