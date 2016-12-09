package Vue;

import Controleur.ControlBarreMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class BarreMenu extends JMenuBar {

    public JMenu menu;
    public JMenuItem nouvellePartie, menuPrincipal, quitter, regle ;

    public BarreMenu() {

        //JMenu
        menu = new JMenu("Menu");
        menu.setActionCommand("Menu");

        //JMenuItem
        nouvellePartie = new JMenuItem("Nouvelle Partie");
        nouvellePartie.setActionCommand("Nouvelle Partie");
        menuPrincipal = new JMenuItem("Menu Principal");
        menuPrincipal.setActionCommand("Menu Principal");
        quitter = new JMenuItem("Quitter");
        quitter.setActionCommand("Quitter");
        regle = new JMenuItem("Combinaison");
        regle.setActionCommand("Combinaison");

        //JMenu
        add(menu);
        add(regle);

        //JMenuItem
        menu.add(nouvellePartie);
        menu.add(menuPrincipal);
        menu.add(quitter);
    }

    public void setControl(ControlBarreMenu controlBarreMenu){

        //JMenu
        menu.addActionListener(controlBarreMenu);

        //JMenuItem
        nouvellePartie.addActionListener(controlBarreMenu);
        menuPrincipal.addActionListener(controlBarreMenu);
        quitter.addActionListener(controlBarreMenu);
        regle.addActionListener(controlBarreMenu);
    }

}
