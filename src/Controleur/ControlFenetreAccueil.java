package Controleur;

import Vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Florian Vaissiere on 22/11/2016.
 */
public class ControlFenetreAccueil extends Control implements ActionListener {

    public ControlFenetreAccueil(Fenetre fenetre){
        super(fenetre);
        fenetre.setControlFenetreAccueil(this);
    }
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Jouer":
                fenetre.setContentPane(fenetre.panelFenetrePlateau);
                fenetre.barreMenu.setVisible(true);
                changerVue();
                break;

            case "Quitter":
                System.exit(0);
                break;
        }
    }
}

