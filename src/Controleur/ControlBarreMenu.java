package Controleur;

import Vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class ControlBarreMenu extends Control implements ActionListener {

    protected ControlBarreMenu(Fenetre fenetre) {
        super(fenetre);
        fenetre.setControlBarreMenu(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Nouvelle Partie":
                fenetre.setContentPane(fenetre.panelFenetrePlateau);
                fenetre.barreMenu.setVisible(true);
                changerVue();
                break;

            case "Menu Principal":
                fenetre.setContentPane(fenetre.panelFenetreAccueil);
                fenetre.barreMenu.setVisible(false);
                changerVue();
                break;

            case "Quitter":
                System.exit(0);
                break;
        }
    }
}