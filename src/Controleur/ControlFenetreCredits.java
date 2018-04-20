package Controleur;

import Modele.Game;
import Vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Florian Vaissiere on 22/11/2016.
 */
public class ControlFenetreCredits extends Control implements ActionListener {

    public ControlFenetreCredits(Fenetre fenetre, Game game){
        super(fenetre, game);
        fenetre.setControlFenetreCredits(this);
    }
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                fenetre.setContentPane(fenetre.panelFenetreAccueil);
                changerVue();
                break;
        }
    }
}
