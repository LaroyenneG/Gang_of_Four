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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
