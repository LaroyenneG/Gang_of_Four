package Controleur;

import Model.Game;
import Vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

/**
 * Created by guillaume on 19/12/16.
 */
public class ControlIA extends Control implements ActionListener {


    public ControlIA(Fenetre fenetre, Game game){
        super(fenetre, game);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("next")){
            automate.stopWaitIA();
        }
    }
}
