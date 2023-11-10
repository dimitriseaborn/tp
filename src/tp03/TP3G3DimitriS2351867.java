/*  420-201 - TP3
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

package tp03;

import java.util.Arrays;
import java.util.Random;

public class TP3G3DimitriS2351867 {
    public TP3G3DimitriS2351867() {
        tester_calculerGuerreDesNombres();
        tester_calculerGuerresDesNombres();
        tester_estEnOrdreCroissant();
        tester_tronquer();
        tester_creerTableau2DAleatoire();
    }

    private void tester_creerTableau2DAleatoire() {
        System.out.println("======creerTableau2DAleatoire======");
        System.out.println(Arrays.deepToString(creerTableau2DAleatoire(0, 0, 100, 120)));
        System.out.println(Arrays.deepToString(creerTableau2DAleatoire(2, 5, 100, 120)));
        System.out.println(Arrays.deepToString(creerTableau2DAleatoire(6, 2, -100, 120)));
    }

    private int[][] creerTableau2DAleatoire(int nbLignes, int nbColonnes, int valeurMin, int valeurMax) {
        int[][] tableauRetour = new int[nbLignes][nbColonnes];

        for (int ligne = 0; ligne < nbLignes; ligne++) {
            tableauRetour[ligne] = creerTableau1dAleatoire(nbColonnes, valeurMin, valeurMax);
        }
        return tableauRetour;
    }

    private int[] creerTableau1dAleatoire(int longueur, int valeurMin, int valeurMax) {
        int[] tab = new int[longueur];
        for (int i = 0; i < longueur; i++) {
            tab[i] = getNombreAleatoireEntreBorne(valeurMin, valeurMax);
        }
        return tab;
    }

    public int getNombreAleatoireEntreBorne(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max doit être plus grand que min");
        }
        Random r = new Random(); //Instantiation de la classe Random
        return r.nextInt((max - min) + 1) + min;
    }

    private void tester_tronquer() {
        int[] tVide = {};
        int[] tab1 = {1, 2, 3, 4, 5};
        int[] tab2 = {1, 2, 3};
        int[] tRep;
        System.out.println("======tronquerTableau======");
        tRep = tronquerTableau(tVide, 0);
        System.out.println(sontDesTableauxEgaux(tRep, tVide)); //true
        tRep = tronquerTableau(tab1, 5);
        System.out.println(sontDesTableauxEgaux(tRep, tab1)); //true
        tRep = tronquerTableau(tab1, 3);
        System.out.println(sontDesTableauxEgaux(tRep, tab2)); //true
        tRep = tronquerTableau(tab1, 0);
        System.out.println(sontDesTableauxEgaux(tRep, tVide)); //true
    }

    private int[] tronquerTableau(int[] tab, int longueur) {
        int[] tabRetour = new int[longueur];

        for (int i = 0; i < longueur; i++) {
            tabRetour[i] = tab[i];
        }
        return tabRetour;
    }

    private void tester_estEnOrdreCroissant() {
        System.out.println("======estEnOrdreCroissant======");
        System.out.println(estEnOrdreCroissant(new int[]{}));
        System.out.println(estEnOrdreCroissant(new int[]{1}));
        System.out.println(estEnOrdreCroissant(new int[]{-9999999}));
        System.out.println(estEnOrdreCroissant(new int[]{1, 1, 2, 3, 5, 8, 13}));
        System.out.println(!estEnOrdreCroissant(new int[]{-2, 3, 4, -1, 2, 4}));
        System.out.println(estEnOrdreCroissant(new int[]{-5, -2, 0}));
    }

    private boolean estEnOrdreCroissant(int[] tab) {
        boolean estCroissant = true;
        int precedent = Integer.MIN_VALUE;

        for (int i = 0; i < tab.length && estCroissant; i++) {
            estCroissant = precedent <= tab[i];
            precedent = tab[i];
        }
        return estCroissant;
    }

    private void tester_calculerGuerresDesNombres() {
        System.out.println("======calculerGuerresDesNombres(int[][])======");
        System.out.println(calculerGuerresDesNombres(new int[][]{{4, 8, 7, 5}, {2, -8, 7, -5}}) == -8);
        System.out.println(calculerGuerresDesNombres(new int[][]{{}, {2, 8, 7, -5}, {4, 1, 7}}) == 4);
    }

    private int calculerGuerresDesNombres(int[][] matrice) {
        int total = 0;

        for (int i = 0; i < matrice.length; i++) {
            total += calculerGuerreDesNombres(matrice[i]);
        }
        return total;
    }

    private void tester_calculerGuerreDesNombres() {
        System.out.println("======calculerGuerreDesNombres(int[])======");
        System.out.println(calculerGuerreDesNombres(new int[]{2, 8, 7, 5}) == -2);
        System.out.println(calculerGuerreDesNombres(new int[]{4, 8, 7, 5}) == 0);
        System.out.println(calculerGuerreDesNombres(new int[]{2, -8, 7, -5}) == -8);
        System.out.println(calculerGuerreDesNombres(new int[]{}) == 0);
        System.out.println(calculerGuerreDesNombres(new int[]{4, 1, 7}) == -4);
    }

    private int calculerGuerreDesNombres(int[] tab) {
        int sommePaire = 0;
        int sommeImpaire = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 == 0) {
                sommePaire += tab[i];
            } else {
                sommeImpaire += tab[i];
            }
        }
        return sommePaire - sommeImpaire;
    }

    private boolean sontDesTableauxEgaux(int[] tab1, int[] tab2) {
        boolean estEgal = tab1.length == tab2.length;

        for (int i = 0; i < tab1.length && estEgal; i++) {
            estEgal = tab1[i] == tab2[i];
        }
        return estEgal;
    }

    public static void main(String[] args) {
        new TP3G3DimitriS2351867();
    }
}
