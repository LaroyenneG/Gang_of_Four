package Vue;

import Controleur.ControlBarreMenu;
import Controleur.ControlFenetreAccueil;
import Controleur.ControlFenetreCredits;
import Controleur.ControlFenetrePlateau;
import Model.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class Fenetre extends JFrame{
    public static Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public static final int X = (int)tailleEcran.getWidth();//1600;//(int)tailleEcran.getWidth();
    public static final int Y = (int)tailleEcran.getHeight();//1000;//(int)tailleEcran.getHeight();

    public FenetrePlateau panelFenetrePlateau;
    public FenetreAccueil panelFenetreAccueil;
    public FenetreCredits panelFenetreCredits;
    public BarreMenu barreMenu;


    public Fenetre(Game game){

        init(game);
        barreMenu.setVisible(false);
        setJMenuBar(barreMenu);
        setUndecorated(true);
        setContentPane(panelFenetreAccueil);
        pack();
        setTitle("Gang Of Four");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init(Game game){
        panelFenetreAccueil = new FenetreAccueil();
        panelFenetrePlateau = new FenetrePlateau(game);
        panelFenetreCredits = new FenetreCredits();
        barreMenu = new BarreMenu();
    }

    public void setControlFenetrePlateau(ControlFenetrePlateau controlFenetrePlateau){
        panelFenetrePlateau.setControl(controlFenetrePlateau);
    }
    public void setControlFenetreAccueil(ControlFenetreAccueil controlFenetreAccueil){
        panelFenetreAccueil.setControl(controlFenetreAccueil);
    }
    public void setControlFenetreCredits(ControlFenetreCredits controlFenetreCredits){
        panelFenetreCredits.setControl(controlFenetreCredits);
    }
    public void setControlBarreMenu (ControlBarreMenu controlBarreMenu){
        barreMenu.setControl(controlBarreMenu);
    }
    /*public void setControlCarte (ControlCarte controlCarte){
        carte.setControl(controlCarte);
    }*/

}