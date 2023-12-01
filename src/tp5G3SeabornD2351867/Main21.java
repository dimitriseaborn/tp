/*  420-201 - TP5
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

package tp5G3SeabornD2351867;

import tp5G3SeabornD2351867.paquet.Carte;
import tp5G3SeabornD2351867.paquet.Paquet;

import java.util.ArrayList;

public class Main21 {
    private ArrayList<Carte> mainDe21;
    private Paquet paquet;

    public Main21(Paquet paquet) {
        this.paquet = paquet;
        mainDe21 =new ArrayList<>();
    }

    private String getStrMain21() {
        String str = "";
        for (int i = 0; i < mainDe21.size(); i++) {
            str += i + 1 + " - " + mainDe21.get(i).toString() + "\n";
        }
        return str;
    }

    public boolean main21GagnanteOuPerdante() {
        return main21Perdante() || main21Gagnante();
    }

    public boolean main21Perdante() {
        return getValeurMainDe21() > 21;
    }

    public boolean main21Gagnante() {
        return getValeurMainDe21() == 21;
    }

    public int getValeurMainDe21() {
        int valeurMain = 0;
        for (int i = 0; i < mainDe21.size(); i++) {
            valeurMain += getValeurCarteDe21(mainDe21.get(i));
        }
        return valeurMain;
    }

    public static int getValeurCarteDe21(Carte carte) {
        int valeur = 0;
        switch (carte.getValeur()) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9:
                valeur = carte.getValeur();
                break;
            case 10, 11, 12:
                valeur = 10;
                break;
            case 13:
                valeur = 11;
                break;
        }
        return valeur;
    }

    public int getNbCartesDsMain() {
        return mainDe21.size();
    }

    public void pigerAu21() {
        mainDe21.add(paquet.piger());
    }

    @Override
    public String toString() {
        String str = getStrMain21();
        str += "valeur du jeu 21 : " + getValeurMainDe21() + " -> ";
        str += main21Perdante() ? "21 est dépassé\n" : 21 - getValeurMainDe21() + " pour dépasser.\n";
        return str;
    }
}
