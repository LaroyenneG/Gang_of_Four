package Controleur;

import Vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class ControlFenetrePlateau extends Control implements ActionListener {

    public ControlFenetrePlateau(Fenetre fenetre){
        super(fenetre);
        fenetre.setControlFenetrePlateau(this);
    }
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Passer le Tour":
                fenetre.setContentPane(fenetre.panelFenetreAccueil);
                fenetre.barreMenu.setVisible(false);
                changerVue();
                break;
        }
    }
}