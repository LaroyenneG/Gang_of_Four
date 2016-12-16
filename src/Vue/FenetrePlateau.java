package Vue;

import Controleur.ControlFenetrePlateau;
import Model.Game;

import javax.swing.*;
import java.awt.*;

import static Vue.Fenetre.X;
import static Vue.Fenetre.Y;


/**
 * Created by Florian Vaissiere on 21/11/2016.
 */
public class FenetrePlateau extends JPanel{

    public JButton jouer;
    public JButton passertour;
    public JButton annuler;
    public JButton envoyer;
    public Game game;
    public JButton[] cartesMain;
    public JButton[] cartesChoixMulti;
    public JLabel texteDontCarte;

    public FenetrePlateau(Game game) { // ajout d'un game en paramètre pour récupérer les mains des joueurs
        this.game = game;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        creerBouton();
        creerBouton1Multi();

        jouer = new JButton("Jouer");
        jouer.setActionCommand("Jouer");
        annuler = new JButton("Annuler");
        annuler.setActionCommand("Annuler");
        passertour = new JButton("Passer le Tour");
        passertour.setActionCommand("Passer le Tour");
        envoyer = new JButton("Envoyer");
        envoyer.setActionCommand("Envoyer");

        texteDontCarte = new JLabel("Votre Meilleur Carte a été donné !");

        add(jouer);
        add(annuler);
        add(passertour);
        add(envoyer);
        add(texteDontCarte);
    }

    public void supprimerBouton(){

        for (int i = 0; i < cartesMain.length; i++) {
            remove(cartesMain[i]);
        }
    }

    public void creerBouton1Multi (){

        cartesChoixMulti = new JButton[3];

        for (int i = 0; i < 3;i++ )
        {
            cartesChoixMulti[i] = new JButton();
            cartesChoixMulti[i].setActionCommand("CarteMulti"+i);
            add(cartesChoixMulti[i]);
        }
    }

    public void creerBouton (){

        cartesMain = new JButton[game.getTabJoueurIndex(0).getMain().size()];

        for (int i = 0; i < game.getTabJoueurIndex(0).getMain().size();i++ )
        {
            cartesMain[i] = new JButton();
            cartesMain[i].setActionCommand("Carte"+i);
            add(cartesMain[i]);
        }
    }

    public int unMultiColor(){
        if (cartesChoixMulti[0].isSelected()){
            return 1;
        }else if(cartesChoixMulti[1].isSelected()){
            return 2;
        }else{
            return 3;
        }
    }

    public void setControl(ControlFenetrePlateau controlFenetrePlateau) {

        //Bouton permetant le jeu
        jouer.addActionListener(controlFenetrePlateau);
        annuler.addActionListener(controlFenetrePlateau);
        passertour.addActionListener(controlFenetrePlateau);
        envoyer.addActionListener(controlFenetrePlateau);

        //Bouton des Cartes
        for (int i = 0; i<game.getTabJoueurIndex(0).getMain().size();i++ )
        {
            cartesMain[i].addActionListener(controlFenetrePlateau);
        }

        //Bouton des CartesMulti
        for (int i = 0; i <3 ;i++ )
        {
            cartesChoixMulti[i].addActionListener(controlFenetrePlateau);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int posX = ((((X-200))-5*16)/16);

        Font f=new Font("Arial", Font.BOLD, 18);

        //Bouton (11 / 30.0 * X), (int) (13.5 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));

        passertour.setBounds((int) (1 / 30.0 * X), (int) (8.25 / 15.0 * Y), (int) (1 / 6.0 * X), (int) (1 / 12.0 * Y));
        passertour.setBackground(new Color(0, 0, 0, 0));
        passertour.setFont(f);
        passertour.setForeground(Color.WHITE);
        passertour.setFocusable(false);
        passertour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        passertour.setBorder(null);

        jouer.setBounds((int) (24 / 30.0 * X), (int) (8.25 / 15.0 * Y), (int) (1 / 6.0 * X), (int) (1 / 12.0 * Y));
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setFont(f);
        jouer.setForeground(Color.WHITE);
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);

        annuler.setBounds((int) (24 / 30.0 * X), (int) (9.75 / 15.0 * Y), (int) (1 / 6.0 * X), (int) (1 / 12.0 * Y));
        annuler.setBackground(new Color(0, 0, 0, 0));
        annuler.setFont(f);
        annuler.setForeground(Color.WHITE);
        annuler.setFocusable(false);
        annuler.setCursor(new Cursor(Cursor.HAND_CURSOR));
        annuler.setBorder(null);

        envoyer.setBounds((int) (1 / 30.0 * X), (int) (9.75 / 15.0 * Y), (int) (1 / 6.0 * X), (int) (1 / 12.0 * Y));
        envoyer.setBackground(new Color(0, 0, 0, 0));
        envoyer.setFont(f);
        envoyer.setForeground(Color.WHITE);
        envoyer.setFocusable(false);
        envoyer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        envoyer.setBorder(null);

        //Fond

        Image img = getToolkit().getImage("image/fondplateau.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        //Cartes des autres joueurs

        Image imgJ2 = getToolkit().getImage("cartes/carteDos.jpg");
        g.drawImage(imgJ2,  (int)(X*0.1), 300, posX, (int) (posX*1.5), this);
        g.drawImage(imgJ2, (int)(X*0.85),300, posX, (int) (posX*1.5), this);
        g.drawImage(imgJ2, (X/2-(posX/2)), 100, posX, (int) (posX*1.5), this);

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));;
        g.drawString((Integer.toString(game.getTabJoueurIndex(1).getMain().size())),(int)(X*0.1)+posX,300);
        g.drawString((Integer.toString(game.getTabJoueurIndex(2).getMain().size())),(int)(X*0.85)+posX,300);
        g.drawString((Integer.toString(game.getTabJoueurIndex(3).getMain().size())),(X/2-(posX/2))+posX, 100);

        //Piles Plateau

        for (int i=0; i<game.getTable().size();i++) // on récupére la taille de la main du j1 de game
        {
            // pour chaque cartes en main
            Image imgi = getToolkit().getImage("cartes/"+game.getTable().get(i).getFileName());// on récup le nom de la carte
            g.drawImage(imgi, (650+((posX+5)*i)), (int)(Y*0.37), posX, (int) (posX*1.5), this); // on dessine
        }

        //Carte à Jouer

        for (int i=0; i<game.getTabJoueur()[0].getCombinaisonEnCours().size();i++) // on récupére la taille de la main du j1 de game
        {
            // pour chaque cartes en main
            Image imgi = getToolkit().getImage("cartes/"+game.getTabJoueur()[0].getCombinaisonEnCours().get(i).getFileName());// on récup le nom de la carte
            g.drawImage(imgi, (650+((posX+5)*i)), (int)(Y*0.57), posX, (int) (posX*1.5), this); // on dessine
        }

        //Carte pour le choixn de la couleur du 1 Multi

            // on propose que 3 cartes
        for (int i = 0; i < 3 ; i ++){
            if (i == 0) {
                Image img1 = getToolkit().getImage("cartes/" + "1vert.jpg");// on donne le nom de la carte
                cartesChoixMulti[i].setBounds((650 + ((posX + 5) * i)), (int) (Y * 0.57), posX, (int) (posX * 1.5));
                cartesChoixMulti[i].setBackground(new Color(0, 0, 0, 0));
                cartesChoixMulti[i].setFocusable(false);
                cartesChoixMulti[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                cartesChoixMulti[i].setBorder(null);
                g.drawImage(img1, (650 + ((posX + 5) * i)), (int) (Y * 0.57), posX, (int) (posX * 1.5), this); // on dessine
            } else if (i == 1) {
                Image img2 = getToolkit().getImage("cartes/"+"1jaune.jpg");// on donne le nom de la carte
                cartesChoixMulti[i].setBounds((650+((posX+5) * i)), (int)(Y*0.57), posX, (int) (posX*1.5));
                cartesChoixMulti[i].setBackground(new Color(0, 0, 0, 0));
                cartesChoixMulti[i].setFocusable(false);
                cartesChoixMulti[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                cartesChoixMulti[i].setBorder(null);
                g.drawImage(img2, (650+((posX+5) * i)), (int)(Y*0.57), posX, (int) (posX*1.5), this); // on dessine
            }else {
                Image img3 = getToolkit().getImage("cartes/"+"1rouge.jpg");// on donne le nom de la carte
                cartesChoixMulti[i].setBounds((650+((posX+5)*2)), (int)(Y*0.57), posX, (int) (posX*1.5));
                cartesChoixMulti[i].setBackground(new Color(0, 0, 0, 0));
                cartesChoixMulti[i].setFocusable(false);
                cartesChoixMulti[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                cartesChoixMulti[i].setBorder(null);
                g.drawImage(img3, (650+((posX+5) * i)), (int)(Y*0.57), posX, (int) (posX*1.5), this); // on dessine
            }
        }

        //Main du Joueur

        for (int i=0; i<game.getTabJoueurIndex(0).getMain().size();i++) // on récupére la taille de la main du j1 de game
        {
            // pour chaque cartes en main
            Image imgi = getToolkit().getImage("cartes/"+game.getTabJoueurIndex(0).getMain().get(i).getFileName());// on récup le nom de la carte
            cartesMain[i].setBounds((posX+((posX+5)*i)), (int)(Y*0.74), posX, (int) (posX*1.5));
            cartesMain[i].setBackground(new Color(0, 0, 0, 0));
            cartesMain[i].setFocusable(false);
            cartesMain[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            cartesMain[i].setBorder(null);
            g.drawImage(imgi, (posX+((posX+5)*i)), (int)(Y*0.74), posX, (int) (posX*1.5), this); // on dessine
        }

    }
}