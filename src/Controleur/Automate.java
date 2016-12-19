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

    private boolean wait;

    public Automate(Control control){
        this.control=control;
        game=control.game;
        wait=true;
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
        wait=true;

        while (game.getJoueurPlay()!=0){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            game.faireJouerIA();
            game.nextJoueur();
            control.changerVue();
            if(wait){
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
