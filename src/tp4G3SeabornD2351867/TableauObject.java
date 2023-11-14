/*  420-201 - TP4a
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

package tp4G3SeabornD2351867;

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
        Object tmp = tableau[i1];

        tableau[i1] = tableau[i2];
        tableau[i2] = tmp;
    }

    public Object remove(int i) {
        Object[] nouveauTableau = new Object[size() - 1];
        Object elementRetire = tableau[i];

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
        this.tableau = new Object[0];
    }

    public void add(Object valeur) {
        Object[] nouveauTableau = new Object[size() + 1];

        for (int i = 0; i < size(); i++) {
            nouveauTableau[i] = tableau[i];
        }
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
