/*  420-201 - TP5
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

package tp5G3SeabornD2351867._utile;

import java.util.Random;

public class TableauObject {
    private Object[] tableau;
    public static final Object VALEUR_DEFAUT = null;
    public static final int LONGUEUR_DEFAUT = 5;

    public TableauObject() {
        this(LONGUEUR_DEFAUT);
    }

    public TableauObject(int longueur) {
        this(longueur, VALEUR_DEFAUT);
    }

    public TableauObject(int longueur, Object valeurInitiale) {
        tableau = new Object[longueur];
        setAll(valeurInitiale);
    }

    public void set(Object[] tableau) {
        this.tableau = new Object[tableau.length];

        if (size() >= 0) System.arraycopy(tableau, 0, this.tableau, 0, size());
    }

    public void shuffle() {
        Random random = new Random();

        // algorithme de Fisher–Yates
        for (int i = size() - 1; i > 0; i--) {
            permuter(i, random.nextInt(i));
        }
    }

    public void permuter(int i1, int i2) {
        Object tmp = tableau[i1];

        tableau[i1] = tableau[i2];
        tableau[i2] = tmp;
    }

    public Object remove(int i) {
        Object[] nouveauTableau = new Object[size() - 1];
        Object elementRetire = tableau[i];

        System.arraycopy(tableau, 0, nouveauTableau, 0, i);
        if (size() - (i + 1) >= 0) System.arraycopy(tableau, i + 1, nouveauTableau, i + 1 - 1, size() - (i + 1));
        tableau = nouveauTableau;
        return elementRetire;
    }

    public void clear() {
        this.tableau = new Object[0];
    }

    public void add(Object valeur) {
        Object[] nouveauTableau = new Object[size() + 1];

        if (size() >= 0) System.arraycopy(tableau, 0, nouveauTableau, 0, size());
        nouveauTableau[nouveauTableau.length - 1] = valeur;
        tableau = nouveauTableau;
    }

    public Object get(int i) {
        return tableau[i];
    }

    public void set(int i, Object valeur) {
        tableau[i] = valeur;
    }

    public int size() {
        return tableau.length;
    }

    public void setAll(Object valeurInitiale) {
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
