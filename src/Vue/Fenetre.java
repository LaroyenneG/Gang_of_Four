package Vue;

import Controleur.*;
import Model.Game;

import javax.swing.*;
import java.awt.*;

import static Vue.FenetrePlateau.annuler;
import static Vue.FenetrePlateau.jouer;

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
    private FenetreRegle panelFenetreRegle;
    public BarreMenu barreMenu;


    public Fenetre(Game game){

        init(game);
        barreMenu.setVisible(false);
        jouer.setVisible(false);
        annuler.setVisible(false);
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
        setPanelFenetreRegle(new FenetreRegle());
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
    public void setControlFenetreRegle (ControlFenetreRegle controlFenetreRegle){
        getPanelFenetreRegle().setControl(controlFenetreRegle);
    }

    public FenetreRegle getPanelFenetreRegle() {
        return panelFenetreRegle;
    }

    public void setPanelFenetreRegle(FenetreRegle panelFenetreRegle) {
        this.panelFenetreRegle = panelFenetreRegle;
    }
}