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
                List<Carte> listTest = new ArrayList<>();
                Collections.addAll(listTest, anACombinaison);
                if (AlgoCarte.canPlayCombinaison(table, listTest)) {
                    isGood.add(listTest);
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
