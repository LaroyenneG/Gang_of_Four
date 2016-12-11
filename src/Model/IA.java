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
        List<Carte>[] goodList=AlgoIA.getCombinaisonJouable(table,main);


        int theBest = 0;


        if(goodList.length==0){
            peutJouer=false;
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
        
        main.removeAll(goodList[theBest]);
        combinaisonEnCours=goodList[theBest];
    }

}
