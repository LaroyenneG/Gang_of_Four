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
                            sleep(400);
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
        boolean testSiUnGagnant= false;

        while (game.getJoueurPlay()!=0){
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            game.faireJouerIA();

            for (int i=1;i<4;i++){
                if (game.siGagne(i)){ testSiUnGagnant = true; }
            }
            if (testSiUnGagnant){
                control.changerVue();
                game.nextManche();
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                control.changerVue();
                stopAutomate();
            }
            else {
                game.nextJoueur();
            }
            System.out.println("test avant repaint");
            control.changerVue();
            System.out.println("test apres repaint");
            for (int t=0; t<10 && wait[0]; t++){
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

    public void stopAutomate(){
        System.out.println("test1");
        if (automate!=null){
            System.out.println("test2");
            automate.interrupt();
            automate.stop();
            System.out.println(automate.getState());
        }
    }
}
