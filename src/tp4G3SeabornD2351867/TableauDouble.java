/*  420-201 - TP4a
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

package tp4G3SeabornD2351867;

import java.util.Random;

public class TableauDouble {
    private double[] tableau;
    public static final double VALEUR_DEFAUT = 0;
    public static final int LONGUEUR_DEFAUT = 5;

    public TableauDouble() {
        this(LONGUEUR_DEFAUT);
    }

    public TableauDouble(int longueur) {
        this(longueur, VALEUR_DEFAUT);
    }

    public TableauDouble(int longueur, double valeurInitiale) {
        tableau = new double[longueur];
        setAll(valeurInitiale);
    }

    public static boolean estPlusPetit(TableauDouble tableau1, TableauDouble tableau2) {
        return getSomme(tableau1) < getSomme(tableau2);
    }

    public boolean estPlusPetit(TableauDouble tableau1) {
        return getSomme() < getSomme(tableau1);
    }

    public double getSomme() {
        return getSomme(this);
    }

    private static double getSomme(TableauDouble tableauDouble) {
        double somme = 0;

        for (int i = 0; i < tableauDouble.size(); i++) {
            somme += tableauDouble.get(i);
        }
        return somme;
    }

    public void set(double[] tableau) {
        this.tableau = new double[tableau.length];

        for (int i = 0; i < size(); i++) {
            this.tableau[i] = tableau[i];
        }
    }

    public void shuffle() {
        Random random = new Random(System.currentTimeMillis());

        // algorithme de Fisher–Yates
        for (int i = size() - 1; i > 0; i--) {
            permuter(i, random.nextInt(i));
        }
    }

    public void permuter(int i1, int i2) {
        double tmp = tableau[i1];

        tableau[i1] = tableau[i2];
        tableau[i2] = tmp;
    }

    public double remove(int i) {
        double[] nouveauTableau = new double[size() - 1];
        double elementRetire = tableau[i];

        for (int j = 0; j < i; j++) {
            nouveauTableau[j] = tableau[j];
        }
        for (int j = i + 1; j < size(); j++) {
            nouveauTableau[j - 1] = tableau[j];
        }
        tableau = nouveauTableau;
        return elementRetire;
    }

    public void clear() {
        this.tableau = new double[0];
    }

    public void add(double valeur) {
        double[] nouveauTableau = new double[size() + 1];

        for (int i = 0; i < size(); i++) {
            nouveauTableau[i] = tableau[i];
        }
        nouveauTableau[nouveauTableau.length - 1] = valeur;
        tableau = nouveauTableau;
    }

    public double get(int i) {
        return tableau[i];
    }

    public void set(int i, double valeur) {
        tableau[i] = valeur;
    }

    public int size() {
        return tableau.length;
    }

    public void setAll(double valeurInitiale) {
        for (int i = 0; i < size(); i++) {
            tableau[i] = valeurInitiale;
        }
    }

    @Override
    public String toString() {
        String s = "longueur: " + tableau.length + " [";
        for (int i = 0; i < tableau.length; i++) {
            s += tableau[i] + ((i < tableau.length - 1) ? ", " : "");
        }
        s += ']';
        return s;
    }
}
