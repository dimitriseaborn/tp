package tp4G3SeabornD2351867;
/**
 * Classe de tests pour TableauDouble
 * TableauDouble est une structure de données qui emmagasine des réels (double). Le
 * premier élément est stocké à l'indice 0.
 *
 * @link https://github.com/robertAube/201A23-demos-RA/tree/main/TP4
 * @author Robert Aubé
 * @version A23 420-201 TP4a 2023-11-06  V1
 */
public class TableauDoubleTest {
    //    Ces variables d'instance doivent être décommentées aussitôt que votre classe TableauTest est créé
    private TableauDouble t1;
    private TableauDouble t2;
    private TableauDouble t3;

    private TestHelper testHelper;

    public TableauDoubleTest() {
        System.out.println("201-TP4 - Tests pour TableauDouble - Version 3");
        System.out.println("https://github.com/robertAube/201A23-demos-RA/tree/main/TP4");
        testHelper = new TestHelper();
        tester();
        testHelper.afficherBilan();
    }

    public void tester() {
        tester_instancierEtToString(); //1
        tester_setAll(); //2
        tester_size(); //3
        tester_set(); //4
        tester_get(); //5
        tester_add(); //6
        tester_clear(); //7
        tester_remove(); //8
        tester_permuter(); //9
        tester_shuffle(); //10
        tester_setTab(); //11
        tester_setSomme(); //12
        tester_estPlusPetit1Argument(); //13
        tester_estPlusPetit2Arguments(); //14
    }

    /**
     * 1 - tester_instancierEtToString()
     */
    private void tester_instancierEtToString() {
        System.out.println("1 - tester_instancierEtToString()");
        System.out.println("\ta. " + testHelper.shouldBeTrue(TableauDouble.LONGUEUR_DEFAUT >= 0));
        System.out.println("\tb. " + testHelper.shouldBeEqual(TableauDouble.VALEUR_DEFAUT, 0.0));
        t1 = new TableauDouble(4, 2);
        System.out.println("\tc. " + t1);

        //note: ce constructeur sans paramètre avec un paramètre doit appeler le constructeur avec paramètres
        t2 = new TableauDouble(3);
        System.out.println("\td. " + t2);

        //note: ce constructeur sans paramètre doit appeler le constructeur avec paramètres
        t3 = new TableauDouble();
        System.out.println("\te. " + t3);

        System.out.println("\tf. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 4 [2.0, 2.0, 2.0, 2.0]"));
        System.out.println("\tg. " + testHelper.shouldBeEqual(t2.toString(), "longueur: 3 [0.0, 0.0, 0.0]"));
        System.out.println("\th. " + testHelper.shouldBeEqual(t3.toString(), "longueur: 5 [0.0, 0.0, 0.0, 0.0, 0.0]"));

        System.out.println("\ti. " + testHelper.shouldBeEqual(new TableauDouble(0, 0).toString(), "longueur: 0 []"));
    }

    /**
     * 2 - tester_setAll()
     */
    private void tester_setAll() {
        System.out.println("2 - tester_setAll()");
        t1 = new TableauDouble(4, 2);
        System.out.println("\ta. " + t1);
        t1.setAll(1);
        System.out.println("\tb. " + t1);
        System.out.println("\tc. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 4 [1.0, 1.0, 1.0, 1.0]"));
    }

    /**
     * 3 - tester_size()
     */
    private void tester_size() {
        System.out.println("3 - tester_size()");
        t1 = new TableauDouble(4);
        t2 = new TableauDouble(0);
        System.out.println("\ta. " + t1);
        System.out.println("\tb. " + testHelper.shouldBeEqual(t1.size(), 4));
        System.out.println("\tc. " + t2);
        System.out.println("\td. " + testHelper.shouldBeEqual(t2.size(), 0));
    }

    /**
     * 4 - tester_set()
     */
    private void tester_set() {
        System.out.println("4 - tester_set()");
        t1 = new TableauDouble(4);
        System.out.println("\ta. " + t1);
        for (int i = 0; i < t1.size(); i++) {
            t1.set(i, i + 1);
        }
        System.out.println("\tb. " + t1);
        System.out.println("\tc. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 4 [1.0, 2.0, 3.0, 4.0]"));
    }

    /**
     * 5 - tester_get()
     */
    private void tester_get() {
        System.out.println("5 - tester_get()");
        double valeurEcrite;
        double valeurLu;

        for (int i = 0; i < t1.size(); i++) {
            valeurEcrite = i + 1;
            t1.set(i, valeurEcrite);
            valeurLu = t1.get(i);
            System.out.println("\t" + (char) ('a' + i) + ". valeur écrite : " + valeurEcrite + " - valeur lu : " + valeurLu + " -> " + testHelper.shouldBeEqual(valeurEcrite, valeurLu));
        }
    }

    /**
     * 6 - tester_add()
     */
    private void tester_add() {
        System.out.println("6 - tester_add()");
        double[] tDouble = {1, 2, 3, 4};

        t1 = new TableauDouble(0);
        System.out.println("\ta. " + t1.toString());

        for (int i = 0; i < tDouble.length; i++) {
            t1.add(tDouble[i]);
        }

        System.out.println("\tb. " + t1.toString());
        System.out.println("\tc. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 4 [1.0, 2.0, 3.0, 4.0]"));
    }


    /**
     * 7 - tester_clear()
     */
    private void tester_clear() {
        System.out.println("7 - tester_clear()");
        double[] tDouble = {1, 2, 3, 4};

        t1 = new TableauDouble(4, 3);

        System.out.println("\ta. " + t1.toString());
        t1.clear();
        System.out.println("\tb. " + t1.toString());

        System.out.println("\tc. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 0 []"));
    }


    /**
     * 8 - tester_remove()
     */
    private void tester_remove() {
        System.out.println("8 - tester_remove()");
        double elementRetire;

        t1 = new TableauDouble(0);
        System.out.println("\ta. " + t1.toString());

        for (int i = 0; i < 5; i++) {
            t1.add((double) i + 1);
        }

        System.out.println("\tb. " + t1.toString());
        elementRetire = t1.remove(0);
        System.out.println("\tc. " + testHelper.shouldBeEqual(elementRetire, 1.0));
        System.out.println("\td. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 4 [2.0, 3.0, 4.0, 5.0]"));

        System.out.println("\te. " + t1.toString());
        elementRetire = t1.remove(1);
        System.out.println("\tf. " + testHelper.shouldBeEqual(elementRetire, 3.0));
        System.out.println("\tg. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 3 [2.0, 4.0, 5.0]"));

        System.out.println("\th. " + t1.toString());
        elementRetire = t1.remove(2);
        System.out.println("\ti. " + testHelper.shouldBeEqual(elementRetire, 5.0));
        System.out.println("\tj. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 2 [2.0, 4.0]"));
    }


    /**
     * 9 - tester_permuter()
     */
    private void tester_permuter() {
        System.out.println("9 - tester_permuter()");
        t1 = new TableauDouble(0);

        for (int i = 0; i < 5; i++) {
            t1.add((double) i + 1);
        }

        System.out.println("\ta. " + t1.toString());
        t1.permuter(0, 1);
        System.out.println("\tb. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 5 [2.0, 1.0, 3.0, 4.0, 5.0]"));

        System.out.println("\tc. " + t1.toString());
        t1.permuter(0, 4);
        System.out.println("\td. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 5 [5.0, 1.0, 3.0, 4.0, 2.0]"));

        System.out.println("\te. " + t1.toString());
        t1.permuter(1, 1);
        System.out.println("\tf. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 5 [5.0, 1.0, 3.0, 4.0, 2.0]"));
    }


    /**
     * 10 - tester_shuffle()
     */
    private void tester_shuffle() {
        String str = "10 - tester_shuffle()\n";
        char lettre = 'a';
        t1 = new TableauDouble(0);
        final int longueurVecteur = 5;
        int nbFois;

        for (int i = 0; i < longueurVecteur; i++) {
            t1.add((double) i + 1);
        }

        str += "\t" + lettre++ + ". " + t1.toString() + '\n';
        for (int i = 0; i < 5; i++) {
            t1.shuffle();
            str += "\t" + lettre++ + ". " + t1.toString() + " <- mélangé" + '\n';
        }
        str += "\t" + lettre++ + ". Grandeur inchangé : " + testHelper.shouldBeEqual(t1.size(), longueurVecteur) + '\n';

        //chaque nombre devrait se trouver qu'une seule fois et tous les nombres devraient y être
        for (double nbStocke = 1.0; nbStocke < longueurVecteur + 1; nbStocke++) {
            nbFois = 0;
            for (int i = 0; i < longueurVecteur; i++) {
                if (nbStocke == t1.get(i)) {
                    nbFois++;
                }
            }
            str += "\t" + lettre++ + ". " + nbStocke + " se trouve une seule fois : " + testHelper.shouldBeEqual(nbFois, 1);
            str += nbStocke < longueurVecteur ?  '\n' : "";
        }
        System.out.println(str);
    }


    /**
     * tester_setTab()
     */
    private void tester_setTab() {
        double tab[] = {1.0, 2.0};
        String str = "11 - tester_setTab()";

        t1 = new TableauDouble(0);
        str += "\ta. " + t1 + '\n';
        t1.set(new double[]{4.0, 2.0});
        str += "\tb. " + t1;
        str += "\tc. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 2 [4.0, 2.0]") + '\n';

        t1 = new TableauDouble(4);
        str += "\td. " + t1 + '\n';
        t1.set(new double[]{});
        str += "\te. " + t1 + '\n';
        str += "\tf. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 0 []") + '\n';

        t1 = new TableauDouble(1);
        str += "\tg. " + t1 + '\n';
        t1.set(tab);
        str += "\th. " + t1 + '\n';
        tab[0] = 99;  //ici, on teste que le tableau encapsulé ne soit pas le même tableau que celui passé en argument.
        str += "\ti. " + testHelper.shouldBeEqual(t1.get(0), 1.0);
        System.out.println(str);
    }


    /**
     * tester_setSomme()
     */
    private void tester_setSomme() {
        System.out.println("12 - tester_getSomme()");

        t1 = new TableauDouble(0);
        System.out.println("\ta. " + t1.toString());
        System.out.println("\tb. " + testHelper.shouldBeEqual(t1.getSomme(), 0.0));

        t1 = new TableauDouble(4, 1);
        System.out.println("\tc. " + t1.toString());
        System.out.println("\td. " + testHelper.shouldBeEqual(t1.getSomme(), 4.0));
    }


    /**
     * tester_estPlusPetit1Argument()
     */
    private void tester_estPlusPetit1Argument() {
        System.out.println("13 - tester_estPlusPetit1Argument()");

        t1 = new TableauDouble(0);
        System.out.println("\ta. " + t1.toString());
        t2 = new TableauDouble(0);
        System.out.println("\tb. " + t2.toString());
        System.out.println("\tc. " + testHelper.shouldBeFalse(t1.estPlusPetit(t2)));

        t1 = new TableauDouble(6, 1);
        System.out.println("\td. " + t1.toString());
        t2 = new TableauDouble(6, 1);
        System.out.println("\te. " + t2.toString());
        System.out.println("\tf. " + testHelper.shouldBeFalse(t1.estPlusPetit(t2)));

        t1 = new TableauDouble(6, 2);
        System.out.println("\tg. " + t1.toString());
        t2 = new TableauDouble(6, 1);
        System.out.println("\th. " + t2.toString());
        System.out.println("\ti. " + testHelper.shouldBeFalse(t1.estPlusPetit(t2)));

        t1 = new TableauDouble(2, 1);
        System.out.println("\tj. " + t1.toString());
        t2 = new TableauDouble(2, 2);
        System.out.println("\tk. " + t2.toString());
        System.out.println("\tl. " + testHelper.shouldBeTrue(t1.estPlusPetit(t2)));
    }

    /**
     * tester_estPlusPetit2Arguments()
     */
    private void tester_estPlusPetit2Arguments() {
        System.out.println("14 - tester_estPlusPetit2Arguments()");

        t1 = new TableauDouble(0);
        System.out.println("\ta. t1: " + t1.toString());
        t2 = new TableauDouble(0);
        System.out.println("\tb. t2: " + t2.toString());
        System.out.println("\tc. t1 n'est pas plus petit que t2 : " + testHelper.shouldBeFalse(TableauDouble.estPlusPetit(t1, t2)));

        t1 = new TableauDouble(6, 1);
        System.out.println("\td. " + t1.toString());
        t2 = new TableauDouble(6, 1);
        System.out.println("\te. " + t2.toString());
        System.out.println("\tf. " + testHelper.shouldBeFalse(TableauDouble.estPlusPetit(t1, t2)));

        t1 = new TableauDouble(6, 2);
        System.out.println("\tg. " + t1.toString());
        t2 = new TableauDouble(6, 1);
        System.out.println("\th. " + t2.toString());
        System.out.println("\ti. " + testHelper.shouldBeFalse(TableauDouble.estPlusPetit(t1, t2)));

        t1 = new TableauDouble(0);
        t1.set(new double[]{-1, 2, 5});
        System.out.println("\tj. " + t1.toString());
        t2 = new TableauDouble(0);
        t2.set(new double[]{-1, 2, 6});
        System.out.println("\tk. " + t2.toString());
        System.out.println("\tl. " + testHelper.shouldBeTrue(TableauDouble.estPlusPetit(t1, t2)));
    }

    public static void main(String[] args) {
        new TableauDoubleTest();
    }

}
