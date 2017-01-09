package Controleur;

import Model.Game;


import static java.lang.Thread.sleep;

/**
 * Created by guillaume on 19/12/16.
 */
public class Automate {

    private Control control;
    private Game game;

    private Thread automate;

    private final boolean[] wait;

    public Automate(Control control){
        this.control=control;
        game=control.game;

        wait= new boolean[1];
        wait[0]=false;
    }

    public void auto(){

        if(automate!=null){
            automate.interrupt();
        }

        automate = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                      //attente de la fin du joueur
                    while (game.getJoueurPlay()==0){
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
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
        wait[0]=true;

        while (game.getJoueurPlay()!=0){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            game.faireJouerIA();
            game.nextJoueur();
            control.changerVue();

            for (int t=0; t<60 && wait[0]; t++){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    annule le timer
     */
    public void stopWaitIA(){
        wait[0]=false;
    }
}
