package tp4G3SeabornD2351867;
/**
 * Classe de tests pour TableauObject
 * TableauObject est une structure de données qui emmagasine des réels . Le
 * premier élément est stocké à l'indice 0.
 *
 * @link https://github.com/robertAube/201A23-demos-RA/tree/main/TP4
 * @author Robert Aubé
 * @version A23 420-201 TP4a 2023-11-06  Version 5
 */
public class TableauObjectTest {
    //    Ces variables d'instance doivent être décommentées aussitôt que votre classe TableauTest est créé
    private TableauObject t1;
    private TableauObject t2;
    private TableauObject t3;

    private TestHelper testHelper;

    public TableauObjectTest() {
        System.out.println("201-TP4B - Tests pour TableauObject - Version 5");
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
    }

    /**
     * 1 - tester_instancierEtToString()
     */
    private void tester_instancierEtToString() {
        System.out.println("1 - tester_instancierEtToString()");
        System.out.println("\ta. " + testHelper.shouldBeTrue(TableauObject.LONGUEUR_DEFAUT >= 0));
        System.out.println("\tb. " + testHelper.shouldBeEqual(TableauObject.VALEUR_DEFAUT, null));
        t1 = new TableauObject(4, 2);
        System.out.println("\tc. " + t1);

        //note: ce constructeur sans paramètre avec un paramètre doit appeler le constructeur avec paramètres
        t2 = new TableauObject(3);
        System.out.println("\td. " + t2);

        //note: ce constructeur sans paramètre doit appeler le constructeur avec paramètres
        t3 = new TableauObject();
        System.out.println("\te. " + t3);

        System.out.println("\tf. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 4 [2, 2, 2, 2]"));
        System.out.println("\tg. " + testHelper.shouldBeEqual(t2.toString(), "longueur: 3 [null, null, null]"));
        System.out.println("\th. " + testHelper.shouldBeEqual(t3.toString(), "longueur: 5 [null, null, null, null, null]"));

        System.out.println("\ti. " + testHelper.shouldBeEqual(new TableauObject(0, 0).toString(), "longueur: 0 []"));
    }

    /**
     * 2 - tester_setAll()
     */
    private void tester_setAll() {
        System.out.println("2 - tester_setAll()");
        t1 = new TableauObject(4, 2);
        System.out.println("\ta. " + t1);
        t1.setAll(1);
        System.out.println("\tb. " + t1);
        System.out.println("\tc. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 4 [1, 1, 1, 1]"));
    }

    /**
     * 3 - tester_size()
     */
    private void tester_size() {
        System.out.println("3 - tester_size()");
        t1 = new TableauObject(4);
        t2 = new TableauObject(0);
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
        t1 = new TableauObject(4);
        System.out.println("\ta. " + t1);
        for (int i = 0; i < t1.size(); i++) {
            t1.set(i, i + 1);
        }
        System.out.println("\tb. " + t1);
        System.out.println("\tc. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 4 [1, 2, 3, 4]"));
    }

    /**
     * 5 - tester_get()
     */
    private void tester_get() {
        System.out.println("5 - tester_get()");
        Object valeurEcrite;
        Object valeurLu;

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
        Object[] tObject = {1, 2, 3, 4};

        t1 = new TableauObject(0);
        System.out.println("\ta. " + t1.toString());

        for (int i = 0; i < tObject.length; i++) {
            t1.add(tObject[i]);
        }

        System.out.println("\tb. " + t1.toString());
        System.out.println("\tc. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 4 [1, 2, 3, 4]"));
    }


    /**
     * 7 - tester_clear()
     */
    private void tester_clear() {
        System.out.println("7 - tester_clear()");
        Object[] tObject = {1, 2, 3, 4};

        t1 = new TableauObject(4, 3);

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
        Object elementRetire;

        t1 = new TableauObject(0);
        System.out.println("\ta. " + t1.toString());

        for (int i = 0; i < 5; i++) {
            t1.add(i + 1);
        }

        System.out.println("\tb. " + t1.toString());
        elementRetire = t1.remove(0);
        System.out.println("\tc. " + testHelper.shouldBeEqual(elementRetire, 1));
        System.out.println("\td. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 4 [2, 3, 4, 5]"));

        System.out.println("\te. " + t1.toString());
        elementRetire = t1.remove(1);
        System.out.println("\tf. " + testHelper.shouldBeEqual(elementRetire, 3));
        System.out.println("\tg. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 3 [2, 4, 5]"));

        System.out.println("\th. " + t1.toString());
        elementRetire = t1.remove(2);
        System.out.println("\ti. " + testHelper.shouldBeEqual(elementRetire, 5));
        System.out.println("\tj. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 2 [2, 4]"));
    }


    /**
     * 9 - tester_permuter()
     */
    private void tester_permuter() {
        System.out.println("9 - tester_permuter()");
        t1 = new TableauObject(0);

        for (int i = 0; i < 5; i++) {
            t1.add(i + 1);
        }

        System.out.println("\ta. " + t1.toString());
        t1.permuter(0, 1);
        System.out.println("\tb. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 5 [2, 1, 3, 4, 5]"));

        System.out.println("\tc. " + t1.toString());
        t1.permuter(0, 4);
        System.out.println("\td. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 5 [5, 1, 3, 4, 2]"));

        System.out.println("\te. " + t1.toString());
        t1.permuter(1, 1);
        System.out.println("\tf. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 5 [5, 1, 3, 4, 2]"));
    }


    /**
     * 10 - tester_shuffle()
     */
    private void tester_shuffle() {
        String str = "10 - tester_shuffle()\n";

        char lettre = 'a';
        t1 = new TableauObject(0);
        final int longueurVecteur = 5;
        int nbFois;

        for (int i = 0; i < longueurVecteur; i++) {
            t1.add( i + 1);
        }

        str += "\t" + lettre++ + ". " + t1.toString() + '\n';
        for (int i = 0; i < 5; i++) {
            t1.shuffle();
            str += "\t" + lettre++ + ". " + t1.toString() + " <- mélangé" + '\n';
        }
        str += "\t" + lettre++ + ". Grandeur inchangé : " + testHelper.shouldBeEqual(t1.size(), longueurVecteur) + '\n';

        //chaque nombre devrait se trouver qu'une seule fois et tous les nombres devraient y être
        for (Integer nbStocke = 1; nbStocke < longueurVecteur + 1; nbStocke++) {
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
        Object tab[] = {1.0, 2.0};
        String str = "11 - tester_setTab()\n";

        t1 = new TableauObject(0);
        str += "\ta. " + t1 + '\n';
        t1.set(new Object[]{4.0, 2.0});
        str += "\tb. " + t1 + '\n';
        str += "\tc. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 2 [4.0, 2.0]") + '\n';

        t1 = new TableauObject(4);
        str += "\td. " + t1 + '\n';
        t1.set(new Object[]{});
        str += "\te. " + t1 + '\n';
        str += "\tf. " + testHelper.shouldBeEqual(t1.toString(), "longueur: 0 []") + '\n';

        t1 = new TableauObject(1);
        str += "\tg. " + t1 + '\n';
        t1.set(tab);
        str += "\th. " + t1 + '\n';
        tab[0] = 99;  //ici, on teste que le tableau encapsulé ne soit pas le même tableau que celui passé en argument.
        str += "\ti. " + testHelper.shouldBeEqual(t1.get(0), 1.0);
        System.out.println(str);
    }


    public static void main(String[] args) {
        new TableauObjectTest();
    }

}
