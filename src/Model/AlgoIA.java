package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by guillaume on 09/12/16.
 */
public class AlgoIA {

    public static List<Carte>[] getCombinaisonJouable(List<Carte> table, List<Carte> main){

        List<Carte[][]> combinaison = AlgoCarte.getCombinaison(main);

        List<List<Carte>> isGood = new ArrayList<>();

        for (Carte[][] aCombinaison : combinaison) {
            for (Carte[] anACombinaison : aCombinaison) {

                int multicouleur=-1;
                for (int z=0; z<anACombinaison.length; z++){
                    if(anACombinaison[z].equals(new Carte(Carte.Couleur.MULTI))){
                        multicouleur=z;
                        break;
                    }
                }

                if(multicouleur!=-1){
                    Carte[] carteForSwitch = new Carte[3];
                    carteForSwitch[0]=new Carte(1, Carte.Couleur.VERT);
                    carteForSwitch[1]=new Carte(1, Carte.Couleur.JAUNE);
                    carteForSwitch[2]=new Carte(1, Carte.Couleur.ROUGE);

                    for (Carte aCarteForSwitch : carteForSwitch) {
                        List<Carte> listTest = new ArrayList<>();
                        anACombinaison[multicouleur] = aCarteForSwitch;
                        Collections.addAll(listTest, anACombinaison);
                        if (AlgoCarte.canPlayCombinaison(table, listTest)) {
                            isGood.add(listTest);
                        }
                    }
                }else {
                    List<Carte> listTest = new ArrayList<>();
                    Collections.addAll(listTest, anACombinaison);
                    if (AlgoCarte.canPlayCombinaison(table, listTest)) {
                        isGood.add(listTest);
                    }
                }
            }
        }

        List<Carte>[] tabGoodCombi = new List[isGood.size()];

        for (int i=0; i<tabGoodCombi.length; i++){
            tabGoodCombi[i]= isGood.get(i);
        }

        return tabGoodCombi;
    }

}
