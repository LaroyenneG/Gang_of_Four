package Controleur;

import Modele.Game;
import Vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Florian Vaissiere on 09/12/2016.
 */
public class ControlFenetreRegle extends Control implements ActionListener {

    public ControlFenetreRegle(Fenetre fenetre, Game game){
        super(fenetre, game);
        fenetre.setControlFenetreRegle(this);
    }
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                fenetre.setContentPane(fenetre.panelFenetrePlateau);
                changerVue();
                break;
        }
    }
}
