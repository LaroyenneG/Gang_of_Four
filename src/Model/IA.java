package Model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by guillaume on 09/12/16.
 */
public class IA extends Joueur {

    public IA(){
        super();
    }

    public void findBestCombinaison(List<Carte> table){
        peutJouer=true;

        List<Carte>[] goodList=AlgoIA.getCombinaisonJouable(table,main);

        int theBest = 0;

        if(goodList.length==0){
            System.out.println("non"+Arrays.toString(goodList));
            passeSonTour();
            return;
        }

        for (int i=0; i<goodList.length;i++){
            if(goodList[theBest].size()==goodList[i].size()){
                if(AlgoCarte.estPlusFort(goodList[theBest], goodList[i])){
                    theBest=i;
                }
            }else if(goodList[theBest].size()<goodList[i].size()){
                theBest=i;
            }
        }


        for(int y=0; y<goodList[theBest].size();y++){
            boolean in=false;
            for (int x=0; x<main.size(); x++){
                if(main.get(x).equals(goodList[theBest].get(y))){
                    main.remove(x);
                    in=true;
                }
            }
            if(!in){
                main.remove(new Carte(Carte.Couleur.MULTI));
            }
        }

        if(!(goodList[theBest].size()>0)){
            System.err.println("Anomaly in IA");
        }
        combinaisonEnCours=goodList[theBest];
    }

    public Carte getCarteForPlayer(){
        if(combinaisonEnCours.size()!=0){
            System.err.println("Anomaly in getCarteForPlayer ->  correction in process : clear combinaison");
            combinaisonEnCours.clear();
        }
        ordoMain();
        if(main.size()==0){
            System.err.println("Error in getCarteForPlayer(), main size is 0");
            System.exit(-8);
        }

        if(main.get(0).couleur != Carte.Couleur.MULTI){
            return main.remove(0);
        }else if(main.size()>=2){
            return main.remove(1);
        }else {
            return main.remove(0);
        }
    }

}
