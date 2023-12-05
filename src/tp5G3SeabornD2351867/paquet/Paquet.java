/*  420-201 - TP5
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

package tp5G3SeabornD2351867.paquet;

import tp5G3SeabornD2351867._utile.TableauObject;

public class Paquet {
    private final TableauObject paquet;

    public Paquet(boolean melange) {
        paquet = new TableauObject(0);
        for (int couleurNum = 0; couleurNum < Carte.COULEURS_VALIDES.length; couleurNum++) {
            for (int valeur = 1; valeur <= 13; valeur++) {
                paquet.add(new Carte(valeur, Carte.COULEURS_VALIDES[couleurNum]));
            }
        }
        if (melange) {
            melanger();
        }
    }

    public Carte piger() {
        return (getNombreDeCartes() == 0) ? null : (Carte) paquet.remove(0);
    }

    public void melanger() {
        paquet.shuffle();
    }

    public boolean estVide() {
        return getNombreDeCartes() == 0;
    }

    public int getNombreDeCartes() {
        return paquet.size();
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < paquet.size(); i++) {
            str += paquet.get(i).toString();
        }
        return str;
    }
}
