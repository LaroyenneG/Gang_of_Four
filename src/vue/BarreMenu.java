package vue;

import controleur.ControlBarreMenu;

import javax.swing.*;
import java.awt.*;


public class BarreMenu extends JMenuBar {

    public JMenuItem menu;

    public BarreMenu() {

        menu = new JMenuItem("Menu");
        menu.setActionCommand("Menu");

        add(menu);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void setControl(ControlBarreMenu controlBarreMenu) {
        menu.addActionListener(controlBarreMenu);
    }
}