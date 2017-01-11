package Controleur;

import Model.Game;
import Model.IA;


import javax.swing.*;

import static java.lang.Thread.sleep;

/**
 * Created by guillaume on 19/12/16.
 */
public class Automate {

    private Control control;
    private Game game;

    private Thread automate;
    private boolean run;

    private static final int timeSleep=0;

    public Automate(Control control){
        this.control=control;
        game=control.game;
        run=false;
        automate=null;
    }

    public void auto(){

        run=true;

        if(automate!=null){
            automate.interrupt();
        }

        automate = new Thread(new Runnable() {
            @Override
            public void run() {
                while (run){

                    for (int i=0;i<4;i++){
                        if (game.siGagne(i)){

                            game.nextManche();

                            String messageWin="";

                            if(i==0){
                                messageWin="vous avez gagné";
                            }else {
                                messageWin=((IA)game.getTabJoueurIndex(i)).getName()+" à gagné";
                            }
                            JOptionPane dialog = new JOptionPane();
                            JOptionPane.showMessageDialog(dialog, "Nouvelle manche\n"+messageWin, "Manche terminé", 1);


                            control.fenetre.panelFenetrePlateau.creerBouton();
                            control.changerVue();

                            break;
                        }
                    }




                      //attente de la fin du joueur
                    while (game.getJoueurPlay()==0){
                        try {
                            sleep(400);
                        } catch (InterruptedException e) {
                            //e.printStackTrace();
                        }
                    }

                    //action des robots
                    actionIA();
                }
            }
        });

        automate.start();
    }

    private void actionIA(){

        while (game.getJoueurPlay()!=0){
            for (int i=0;i<4;i++){
                if (game.siGagne(i)){
                    return;
                }
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            for (int t=0; t<timeSleep; t++){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            game.faireJouerIA();


            for (int i=0;i<4;i++){
                if (game.siGagne(i)){
                    return;
                }
            }

            game.nextJoueur();

            control.changerVue();
        }
    }


    public void stopAutomate(){
        run=false;
        if (automate!=null){
            automate.interrupt();
            System.out.println("State "+automate.getState());
        }
    }


    public boolean isRun(){
        if(automate==null){
            return false;
        }

        return run;
    }

}
