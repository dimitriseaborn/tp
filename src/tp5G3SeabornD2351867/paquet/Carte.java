/*  420-201 - TP5
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

package tp5G3SeabornD2351867.paquet;

import java.util.Objects;

public class Carte {
    private int valeur;
    private String couleur;
    public static final String[] COULEURS_VALIDES = {"pique", "trèfle", "carreau", "coeur"};
    public static final char[] COULEURS_CAR = {'\u2660', '\u2663', '\u2666', '\u2764'};

    public Carte(int valeur, String couleur) {
        setValeur(valeur);
        setCouleur(couleur);
    }

    public static boolean couleurEstValide(String couleur) {
        boolean estValide = false;

        for (int i = 0; i < COULEURS_VALIDES.length && !estValide; i++) {
            estValide = COULEURS_VALIDES[i].equalsIgnoreCase(couleur);
        }
        return estValide;
    }

    public static boolean valeurEstValide(int valeur) {
        return 1 <= valeur && valeur <= 13;
    }

    public char getCharCarte() {
        char c = 0;

        for (int i = 0; i < COULEURS_VALIDES.length && c == 0; i++) {
            if (COULEURS_VALIDES[i].equals(couleur)) {
                c = COULEURS_CAR[i];
            }
        }
        return c;
    }

    public int getValeur() {
        return valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setValeur(int valeur) {
        if (valeurEstValide(valeur)) {
            this.valeur = valeur;
        } else {
            throw new IllegalArgumentException("La valeur d'une carte doit être entre 1 et 13 inclusivement. Valeur tentée: " + valeur);
        }
    }

    public void setCouleur(String couleur) {
        if (couleurEstValide(couleur)) {
            this.couleur = couleur.toLowerCase();
        } else {
            throw new IllegalArgumentException("La couleur d'une carte doit être \"pique\", \"trèfle\", \"carreau\" ou \"coeur\". Valeur tentée: " + couleur);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return valeur == carte.valeur && Objects.equals(couleur, carte.couleur);
    }

    @Override
    public String toString() {
        return valeur + " de " + couleur + " (" + getCharCarte() + ")";
    }
}
