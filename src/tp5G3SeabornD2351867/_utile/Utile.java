/*  420-201 - TP5
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

package tp5G3SeabornD2351867._utile;

import java.util.Random;
import java.util.Scanner;

public class Utile {

    public static String lireString(String question) {
        Scanner sc;
        String reponse;

        sc = new Scanner(System.in);
        System.out.print(question + ' '); //Éviter que la réponse soit collée à la question
        reponse = sc.nextLine();
        return reponse;
    }

    public static int lireInt(String question) {
        int reponse;

        reponse = Integer.parseInt(lireString(question));
        return reponse;
    }

    public static int getNombreAleatoireEntreBorne(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max doit être plus grand que min");
        }
        Random r = new Random(); //Instantiation de la classe Random
        return r.nextInt((max - min) + 1) + min;
    }

    public static int trouverStr(String string, String[] tabStrings) {
        int indexStr = -1;

        for (int i = 0; i < tabStrings.length && indexStr == -1; i++) {
            if (tabStrings[i].equalsIgnoreCase(string)) {
                indexStr = i;
            }
        }
        return indexStr;
    }


}
