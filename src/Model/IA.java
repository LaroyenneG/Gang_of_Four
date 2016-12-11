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



        combinaisonEnCours=goodList[theBest];
    }

}
