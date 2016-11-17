package vue;

import controleur.*;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    public static Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public static final int X = (int)tailleEcran.getWidth();
    public static final int Y = (int)tailleEcran.getHeight();
    public FenetrePlateau panelFenetrePlateau;

    public BarreMenu barreMenu;

    public Fenetre() {

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

    public void init() {
        panelFenetrePlateau = new FenetrePlateau();
    }

    public void setControlFenetrePlateau(ControlFenetrePlateau controlFenetrePlateau) {
        panelFenetrePlateau.setControl(controlFenetrePlateau);
    }
}