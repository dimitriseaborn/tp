package tp5G3SeabornD2351867.paquet._tp5TestA23;

import tp5G3SeabornD2351867.paquet.*;
import tp5G3SeabornD2351867.paquet._tp5TestA23.utilTest.ITest;
import tp5G3SeabornD2351867.paquet._tp5TestA23.utilTest.TestHelper;

/**
 * Classe de test de la classe Paquet
 * Pour Fonctionner :
 * 1 - PaquetTest doit préalablement passer tous les tests sur votre classe Paquet.
 * 2 - Vous devez respecter les noms de méthodes données dans ce travail.
 *
 * @author Robert Aubé
 * @version 201A22 - V1
 */

public class PaquetTest implements ITest {
    private final TestHelper testH;

    private boolean testReussi;
    private String descriptionTest;

    public PaquetTest() {
        testH = new TestHelper(true);
    }

    @Override
    public void tester() {
        explicationsDesTests();

        tester_unPaquetA52Cartes();
        tester_unPaquetOrdonneEstOrdonne();
        tester_onPeutPigerSeulement52CartesPeuImporteLeTypeDePaquet();
        tester_onNAPas2CartesPareillesDansUnPaquetMelange(10);
        tester_unPaquetMelangeEstBienMelange(10);
        tester_toStringRetouneUneStrDesCartesDuPaquet();

        System.out.println();
        testH.afficherBilan();
    }

    /**
     * Vide le paquet en pigeant exactement 52 cartes.
     */
    private void onPeutPigerSeulement52Cartes(Paquet paquet) {
        Carte c;

        System.out.println("Il faut pouvoir piger 52 cartes");
        for (int cpt = 1; cpt <= 52; cpt++) {
            c = paquet.piger();
            testH.shouldNotBeNull(c);
        }

        System.out.println("Après avoir piger 52 cartes, on ne devrait pu pouvoir piger une autre carte.");
        c = paquet.piger();
        testH.shouldBeNull(c);
    }

    private void tester_toStringRetouneUneStrDesCartesDuPaquet() {
        System.out.println("\ntester_toStringRetouneUneStrDesCartesDuPaquet()");
        boolean testReussi;

        String paquetOrdonneValeurCouleur = "1 de pique (♠)1 de trèfle (♣)1 de carreau (♦)1 de coeur (❤)2 de pique (♠)2 de trèfle (♣)2 de carreau (♦)2 de coeur (❤)3 de pique (♠)3 de trèfle (♣)3 de carreau (♦)3 de coeur (❤)4 de pique (♠)4 de trèfle (♣)4 de carreau (♦)4 de coeur (❤)5 de pique (♠)5 de trèfle (♣)5 de carreau (♦)5 de coeur (❤)6 de pique (♠)6 de trèfle (♣)6 de carreau (♦)6 de coeur (❤)7 de pique (♠)7 de trèfle (♣)7 de carreau (♦)7 de coeur (❤)8 de pique (♠)8 de trèfle (♣)8 de carreau (♦)8 de coeur (❤)9 de pique (♠)9 de trèfle (♣)9 de carreau (♦)9 de coeur (❤)10 de pique (♠)10 de trèfle (♣)10 de carreau (♦)10 de coeur (❤)11 de pique (♠)11 de trèfle (♣)11 de carreau (♦)11 de coeur (❤)12 de pique (♠)12 de trèfle (♣)12 de carreau (♦)12 de coeur (❤)13 de pique (♠)13 de trèfle (♣)13 de carreau (♦)13 de coeur (❤)";
        String paquetOrdonneCouleurValeur = "1 de pique (♠)2 de pique (♠)3 de pique (♠)4 de pique (♠)5 de pique (♠)6 de pique (♠)7 de pique (♠)8 de pique (♠)9 de pique (♠)10 de pique (♠)11 de pique (♠)12 de pique (♠)13 de pique (♠)1 de trèfle (♣)2 de trèfle (♣)3 de trèfle (♣)4 de trèfle (♣)5 de trèfle (♣)6 de trèfle (♣)7 de trèfle (♣)8 de trèfle (♣)9 de trèfle (♣)10 de trèfle (♣)11 de trèfle (♣)12 de trèfle (♣)13 de trèfle (♣)1 de carreau (♦)2 de carreau (♦)3 de carreau (♦)4 de carreau (♦)5 de carreau (♦)6 de carreau (♦)7 de carreau (♦)8 de carreau (♦)9 de carreau (♦)10 de carreau (♦)11 de carreau (♦)12 de carreau (♦)13 de carreau (♦)1 de coeur (❤)2 de coeur (❤)3 de coeur (❤)4 de coeur (❤)5 de coeur (❤)6 de coeur (❤)7 de coeur (❤)8 de coeur (❤)9 de coeur (❤)10 de coeur (❤)11 de coeur (❤)12 de coeur (❤)13 de coeur (❤)";
        Paquet pOrdononne = new Paquet(false);
        Paquet pVide = new Paquet(true);

        System.out.println("Un paquet ordonne retourne un toString des 52 cartes au départ.");

        testReussi = pOrdononne.toString().equalsIgnoreCase(paquetOrdonneCouleurValeur);
        testReussi |= pOrdononne.toString().equalsIgnoreCase(paquetOrdonneValeurCouleur);
        testH.shouldBeTrue(testReussi);

        System.out.println("Un paquet vide retourne toString vide.");
        onPeutPigerSeulement52Cartes(pVide);
        testReussi = pVide.toString().equals("") || pVide.toString().equals("");
        testH.shouldBeTrue(testReussi);
    }


    private void tester_unPaquetA52Cartes() {
        System.out.println("\ntester_unPaquetA52Cartes()");
        Paquet pMelange = new Paquet(true);
        Paquet pOrdononne = new Paquet(false);

        System.out.println("Un paquet mélangé ou un paquet non mélangé ont 52 cartes au départ.");
        testH.shouldBeEqual(pMelange.getNombreDeCartes(), 52);
        testH.shouldBeEqual(pOrdononne.getNombreDeCartes(), 52);
    }

    private void tester_onPeutPigerSeulement52CartesPeuImporteLeTypeDePaquet() {
        System.out.println("\ntester_onPeutPigerSeulement52CartesPeuImporteLeTypeDePaquet()");
        Paquet pMelange = new Paquet(true);
        Paquet pOrdononne = new Paquet(false);

        System.out.println("Pour le paquet mélangé:");
        onPeutPigerSeulement52Cartes(pMelange);
        System.out.println("Pour le paquet ordonné:");
        onPeutPigerSeulement52Cartes(pOrdononne);
    }


    private void tester_unPaquetOrdonneEstOrdonne() {
        System.out.println("\ntester_unPaquetOrdonneEstOrdonne()");
        String paquetOrdonneValeurCouleur = "1 de pique (♠)1 de trèfle (♣)1 de carreau (♦)1 de coeur (❤)2 de pique (♠)2 de trèfle (♣)2 de carreau (♦)2 de coeur (❤)3 de pique (♠)3 de trèfle (♣)3 de carreau (♦)3 de coeur (❤)4 de pique (♠)4 de trèfle (♣)4 de carreau (♦)4 de coeur (❤)5 de pique (♠)5 de trèfle (♣)5 de carreau (♦)5 de coeur (❤)6 de pique (♠)6 de trèfle (♣)6 de carreau (♦)6 de coeur (❤)7 de pique (♠)7 de trèfle (♣)7 de carreau (♦)7 de coeur (❤)8 de pique (♠)8 de trèfle (♣)8 de carreau (♦)8 de coeur (❤)9 de pique (♠)9 de trèfle (♣)9 de carreau (♦)9 de coeur (❤)10 de pique (♠)10 de trèfle (♣)10 de carreau (♦)10 de coeur (❤)11 de pique (♠)11 de trèfle (♣)11 de carreau (♦)11 de coeur (❤)12 de pique (♠)12 de trèfle (♣)12 de carreau (♦)12 de coeur (❤)13 de pique (♠)13 de trèfle (♣)13 de carreau (♦)13 de coeur (❤)";
        String paquetOrdonneCouleurValeur = "1 de pique (♠)2 de pique (♠)3 de pique (♠)4 de pique (♠)5 de pique (♠)6 de pique (♠)7 de pique (♠)8 de pique (♠)9 de pique (♠)10 de pique (♠)11 de pique (♠)12 de pique (♠)13 de pique (♠)1 de trèfle (♣)2 de trèfle (♣)3 de trèfle (♣)4 de trèfle (♣)5 de trèfle (♣)6 de trèfle (♣)7 de trèfle (♣)8 de trèfle (♣)9 de trèfle (♣)10 de trèfle (♣)11 de trèfle (♣)12 de trèfle (♣)13 de trèfle (♣)1 de carreau (♦)2 de carreau (♦)3 de carreau (♦)4 de carreau (♦)5 de carreau (♦)6 de carreau (♦)7 de carreau (♦)8 de carreau (♦)9 de carreau (♦)10 de carreau (♦)11 de carreau (♦)12 de carreau (♦)13 de carreau (♦)1 de coeur (❤)2 de coeur (❤)3 de coeur (❤)4 de coeur (❤)5 de coeur (❤)6 de coeur (❤)7 de coeur (❤)8 de coeur (❤)9 de coeur (❤)10 de coeur (❤)11 de coeur (❤)12 de coeur (❤)13 de coeur (❤)";
        String strPaquetOrdonne;
        Paquet pOrdononne = new Paquet(false);
        boolean testReussi;

        System.out.println("Votre paquet contient l'ensemble des cartes d'un paquet ordonnée");
        strPaquetOrdonne = paquetToString(pOrdononne);
        testReussi = strPaquetOrdonne.equalsIgnoreCase(paquetOrdonneCouleurValeur);
        testReussi |= strPaquetOrdonne.equalsIgnoreCase(paquetOrdonneValeurCouleur);
        testH.shouldBeTrue(testReussi);
    }

    private void tester_unPaquetMelangeEstBienMelange(int nbPaquet) {
        System.out.println("\ntester_unPaquetMelangeEstBienMelange(int nbPaquet)");
        String[] tabStrPaquet = new String[nbPaquet];
        Paquet p;
        boolean testReussi;

        if (nbPaquet < 2) {
            System.out.println("Pour être significatif le test paquets unPaquetMelangeEstMelange() doit avoir plus d'un paquet à comparer.");
            testH.error("");
        } else {
            System.out.println(nbPaquet + " paquets mélangés sont différents.");
            //Ici, on compare chaque chaine des paquets mélangés du tableau avec la chaine de caractère d'un paquet mélangé.
            //(elles devraient tous être différentes (La probabilité d'Avoir 2 paquets mélangés pareils est de 1 sur 52! = à peu près 19^52))
            for (int i = 0; i < tabStrPaquet.length; i++) {
                p = new Paquet(true);
                tabStrPaquet[i] = paquetToString(p);
                for (int j = 0; j < i; j++) {
                    testH.shouldBeTrue(!tabStrPaquet[j].equalsIgnoreCase(tabStrPaquet[i]));
                }
            }
        }
    }

    private String paquetToString(Paquet paquet) {
        String strPaquet;
        Carte c;

        strPaquet = "";
        for (int cpt = 1; cpt <= 52; cpt++) {
            c = paquet.piger();
            strPaquet += c.toString();
        }

        return strPaquet;
    }

    private void tester_onNAPas2CartesPareillesDansUnPaquetMelange(int nbTeste) {
        System.out.println("\ntester_onNAPas2CartesPareillesDansUnPaquetMelange(int nbTeste)");

        System.out.println("Un paquet mélangé n'a jamais 2 cartes pareilles.");
        for (int i = 0; i < nbTeste; i++) {
            testH.shouldBeTrue(onNAPas2CartesPareilsDansUnPaquetMelange());
        }
    }

    private boolean onNAPas2CartesPareilsDansUnPaquetMelange() {
        Paquet pMelange = new Paquet(true);
        Carte[] paquetTest = getCartesFromPaquet(pMelange);
        boolean testReussi;

        testReussi = true;
        for (int i = 0; i < pMelange.getNombreDeCartes() && testReussi; i++) {
            for (int j = 0; j < pMelange.getNombreDeCartes() && testReussi; j++) {
                if (i != j) {
                    if (paquetTest[i].toString().equals(paquetTest[j])) {
                        testReussi = false;
                    }
                }
            }
        }
        return testReussi;
    }

    private Carte[] getCartesFromPaquet(Paquet paquet) {
        Carte c;
        Carte[] tabPaquet = new Carte[52];

        for (int i = 0; !paquet.estVide(); i++) {
            c = paquet.piger();
            tabPaquet[i] = c;
        }
        return tabPaquet;
    }

    /**
     * Méthodes utilitaires pour faire les tests
     */
    public void explicationsDesTests() {
        String s;
        s = "Pour Fonctionner :";
        s += "\n1 - CarteTestTp4b doit préalablement passer tous les tests sur votre classe Paquet.";
        s += "\n2 - Vous devez respecter les noms de méthodes données dans ce travail.";

        System.out.println(s);
    }

    public static void main(String[] args) {
        PaquetTest pTest = new PaquetTest();

        pTest.tester();
    }
}
