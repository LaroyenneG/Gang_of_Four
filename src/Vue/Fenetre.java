package Vue;

import Controleur.ControlBarreMenu;
import Controleur.ControlFenetrePlateau;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class Fenetre extends JFrame{
    public static Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public static final int X = 1200;//(int)tailleEcran.getWidth();
    public static final int Y = 800;//(int)tailleEcran.getHeight();

    public FenetrePlateau panelFenetrePlateau;
    public BarreMenu barreMenu;


    public Fenetre(){

        init();
        barreMenu.setVisible(true);
        setJMenuBar(barreMenu);
        setUndecorated(false);
        setContentPane(panelFenetrePlateau);
        pack();
        setTitle("Jeu");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init(){
        panelFenetrePlateau = new FenetrePlateau();
        barreMenu = new BarreMenu();
    }

    public void setControlFenetrePlateau(ControlFenetrePlateau controlFenetrePlateau){
        panelFenetrePlateau.setControl(controlFenetrePlateau);
    }
    public void setControlBarreMenu (ControlBarreMenu controlBarreMenu){
        barreMenu.setControl(controlBarreMenu);
    }
}
