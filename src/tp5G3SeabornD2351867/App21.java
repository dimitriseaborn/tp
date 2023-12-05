/*  420-201 - TP5
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

package tp5G3SeabornD2351867;

import tp5G3SeabornD2351867._utile.Utile;

public class App21 {
    private Partie21 p;

    public App21() {
        System.out.println("Seaborn, Dimitri");
        boolean rejouer;
        do {
            p = new Partie21();
            p.jouer();
            String reponse;
            do {
                reponse = Utile.lireString("Partie terminée, voulez vous jouer une autre partie? [o/n]");
            } while (!(reponse.equalsIgnoreCase("o") || reponse.equalsIgnoreCase("n")));
            rejouer = reponse.equalsIgnoreCase("o");
        } while (rejouer);
        System.out.println("Seaborn, Dimitri");
        System.out.println("Au revoir !");
    }

    public static void main(String[] args) {
        new App21();
    }
}
