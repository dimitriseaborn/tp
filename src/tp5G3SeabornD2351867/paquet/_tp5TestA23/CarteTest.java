package tp5G3SeabornD2351867.paquet._tp5TestA23;

/**
 * Classe de tests de la classe Paquet
 *
 * @version 201A23 - V1
 * @author Robert Aubé
 */


import tp5G3SeabornD2351867.paquet.Carte;
import tp5G3SeabornD2351867.paquet._tp5TestA23.utilTest.ITest;
import tp5G3SeabornD2351867.paquet._tp5TestA23.utilTest.TestHelper;

import java.util.Arrays;

public class CarteTest implements ITest {
    private final TestHelper testH;
    private boolean testReussi;
    private String descriptionTest;

    public CarteTest() {
        testH = new TestHelper(true);
    }

    public static void main(String[] args) {
        CarteTest cTest = new CarteTest();

        cTest.tester();
    }

    public void tester() {
        tester_constantesDeClasse();
        tester_ValiderCouleur();
        tester_ValiderValeur();
        tester_Constructeurs();
        tester_MutateursEtAccesseur_couleur();
        tester_MutateursEtAccesseur_valeur();
        tester_toString();
        tester_equals();

        System.out.println();
        testH.afficherBilan();
    }

    private void tester_constantesDeClasse() {
        System.out.println("La constante de classe COULEURS_CAR est bien déclaré.");
        testH.shouldBeEqual(Arrays.toString(Carte.COULEURS_CAR), "[♠, ♣, ♦, ❤]");
        System.out.println("La constante de classe COULEURS_VALIDES est bien déclaré.");
        testH.shouldBeEqual(Arrays.toString(Carte.COULEURS_VALIDES), "[pique, trèfle, carreau, coeur]");
    }

    private void tester_ValiderCouleur() {
        String[] couleursValides = {"pique", "trèfle", "carreau", "coeur"};
        String[] couleursInValides = {"", "trefle", "careau", "chat"};

        System.out.println("tester_ValiderCouleur()");

        System.out.println("Toutes les couleurs valides passent en minuscule.");
        for (int i = 0; i < couleursValides.length; i++) {
            testH.shouldBeTrue(Carte.couleurEstValide(couleursValides[i]));
        }

        System.out.println("Toutes les couleurs valides passent en majuscule.");
        for (int i = 0; i < couleursValides.length; i++) {
            testH.shouldBeTrue(Carte.couleurEstValide(couleursValides[i].toUpperCase()));
        }

        System.out.println("Toutes les couleurs invalides ne passent pas.");
        for (int i = 0; i < couleursInValides.length; i++) {
            testH.shouldBeFalse(Carte.couleurEstValide(couleursInValides[i].toUpperCase()));
        }
    }

    private void tester_ValiderValeur() {
        System.out.println("tester_ValiderValeur()");
        System.out.println("Les valeurs entre 1 et 13 sont valides.");
        for (int valeur = 1; valeur <= 13; valeur++) {
            testH.shouldBeTrue(Carte.valeurEstValide(valeur));
        }

        System.out.println("Les valeurs inférieures à 1 sont invalides.");
        for (int valeur = -20; valeur <= 0; valeur++) {
            testH.shouldBeFalse(Carte.valeurEstValide(valeur));
        }

        System.out.println("Les valeurs supérieures à 13 sont invalides.");
        for (int valeur = 14; valeur <= 60; valeur++) {
            testH.shouldBeFalse(Carte.valeurEstValide(valeur));
        }
    }

    private void tester_MutateursEtAccesseur_couleur() {
        String[] couleursValides = {"pique", "trèfle", "carreau", "coeur"};
        Carte carte;

        System.out.println("tester_MutateursEtAccesseur_couleur()");

        carte = new Carte(1, "coeur");

        System.out.println("Mutateur de couleur");
        for (int i = 0; i < couleursValides.length; i++) {
            carte.setCouleur(couleursValides[i]);
            testH.shouldBeEqual(carte.getCouleur(), couleursValides[i]);
        }

        System.out.println("Mutateur de couleur accepte aussi les majuscules, mais retourne toujours en minuscule.");
        for (int i = 0; i < couleursValides.length; i++) {
            carte.setCouleur(couleursValides[i].toUpperCase());
            testH.shouldBeEqual(carte.getCouleur(), couleursValides[i]);
        }
    }

    private void tester_MutateursEtAccesseur_valeur() {
        Carte carte;

        System.out.println("tester_MutateursEtAccesseur_valeur()");

        carte = new Carte(1, "coeur");

        System.out.println("Mutateur de couleur");
        for (int valeur = 1; valeur <= 13; valeur++) {
            carte.setValeur(valeur);
            testH.shouldBeEqual(carte.getValeur(), valeur);
        }

        System.out.println("Les valeurs inférieures à 1 lancent une exception.");
        for (int valeur = -20; valeur <= 0; valeur++) {
            try {
                carte.setValeur(valeur);
                testH.error(valeur + " doit lancer une exception.");
            } catch (IllegalArgumentException e) {
                testH.succes();
            }
        }

        System.out.println("Les valeurs supérieures à 13 lancent une exception.");
        for (int valeur = 14; valeur <= 60; valeur++) {
            try {
                carte.setValeur(valeur);
                testH.error(valeur + " doit lancer une exception.");
            } catch (IllegalArgumentException e) {
                testH.succes();
            }
        }
    }

    private void tester_Constructeurs() {
        Carte carte;

        System.out.println("tester_Constructeurs()");

        carte = new Carte(1, "coeur");

        System.out.println("Le constructeur place la bonne valeur de carte.");
        testH.shouldBeEqual(carte.getValeur(), 1);

        System.out.println("Le constructeur place la bonne couleur de carte.");
        testH.shouldBeEqual(carte.getCouleur(), "coeur");

        System.out.println("Une valeur invalide lance une exception");
        try {
            new Carte(-1, "coeur");
            testH.error(-1 + " comme valeur dans le constructeur doit lancer une exception.");
        } catch (IllegalArgumentException e) {
            testH.succes();
        }
        System.out.println("Une couleur invalide lance une exception.");
        try {
            new Carte(1, "ccoeur");
            testH.error("ccoeur" + " comme couleur dans le constructeur doit lancer une exception.");
        } catch (IllegalArgumentException e) {
            testH.succes();
        }
    }

    private void tester_toString() {
        Carte[] tabCarte = {new Carte(1, "pique"), new Carte(10, "trèfle"), new Carte(13, "carreau"), new Carte(2, "coeur")};
        String[] strAttendu = {"1 de pique (\u2660)", "10 de trèfle (\u2663)", "13 de carreau (\u2666)", "2 de coeur (\u2764)"};
        String retourToString;

        System.out.println("tester_toString()");

        System.out.println("La carte retourne la bonne chaîne.");
        for (int i = 0; i < tabCarte.length; i++) {
            retourToString = tabCarte[i].toString();
            testH.shouldBeEqual(retourToString, strAttendu[i]);
        }
    }

    private void tester_equals() {
        Carte c2pi = new Carte(2, "pique");
        Carte c1pi = new Carte(1, "pique");
        Carte c2co = new Carte(2, "coeur");
        Carte c2piV2 = new Carte(2, "pique");
        Carte cNull = null;

        System.out.println("tester_equals()");
        System.out.println("equals : la comparaison de la même instance de carte retourne true");
        testH.shouldBeEqual(c2pi, c2pi);

        System.out.println("equals : la comparaison avec une carte null retourne false");
        testH.shouldNotBeEqual(c2pi, cNull);

        System.out.println("equals : la comparaison d'une variable de types différents retourne false");
        testH.shouldNotBeEqual(c2pi, "chat");

        System.out.println("equals : la comparaison de 2 cartes de valeurs différentes retourne false");
        testH.shouldNotBeEqual(c2pi, c1pi);

        System.out.println("equals : la comparaison de 2 cartes de couleurs différentes retourne false");
        testH.shouldNotBeEqual(c2pi, c2co);

        System.out.println("equals : la comparaison de 2 cartes de même couleur, de même valeur et d'instances différentes retourne true.");
        testH.shouldBeEqual(c2pi, c2piV2);
    }
}
