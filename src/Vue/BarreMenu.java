package Vue;

import Controleur.ControlBarreMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class BarreMenu extends JMenuBar {

    public JMenuItem menu;

    public BarreMenu() {

        menu = new JMenuItem("Menu");
        menu.setActionCommand("Menu");

        add(menu);
    }

    public void setControl(ControlBarreMenu controlBarreMenu){
        menu.addActionListener(controlBarreMenu);
    }

}