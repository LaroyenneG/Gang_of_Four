package vue;

import controleur.ControlFenetrePlateau;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;


public class FenetrePlateau extends JPanel {

    public JButton jouerCarte;

    public FenetrePlateau() {

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        jouerCarte=new JButton("Poser ces Cartes");
        jouerCarte.setActionCommand("PoserCartes");

        add(jouerCarte);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        jouerCarte.setBounds((int) (13 / 20.0 * X), (int) (7 / 18.0 * Y), (int) (5 / 24.0 * X), (int) (1 / 20.0 * Y));
        jouerCarte.setBackground(new Color(0, 0, 0, 0));
        jouerCarte.setFocusable(false);
        jouerCarte.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouerCarte.setBorder(null);
    }

    public void setControl(ControlFenetrePlateau controlFenetrePlateau){
        jouerCarte.addActionListener(controlFenetrePlateau);
    }
}