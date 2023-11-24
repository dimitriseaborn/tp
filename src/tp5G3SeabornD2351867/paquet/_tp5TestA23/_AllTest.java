package tp5G3SeabornD2351867.paquet._tp5TestA23;

import tp5G3SeabornD2351867.paquet._tp5TestA23.utilTest.ITest;

/**
 * @author Robert Aubé
 * @version 1.0 (Date de création : 2023-11-19)
 */
public class _AllTest {
    private final ITest[] tabTest = {
            new CarteTest(),
            new PaquetTest(),
    };

    public _AllTest() {
        int iTest;
        for (iTest = 0; iTest < tabTest.length; iTest++) {
            tester(iTest);
        }
        System.out.println("############### Terminé!!! " + iTest + "/" + tabTest.length);
    }

    public static void main(String[] args) {
        new _AllTest();
    }

    private void tester(int iTest) {

        String str = (iTest != 0 ? "\n" : "") +
                "#######  " + (iTest + 1) + " - " + (tabTest[iTest].getClass().getName()) + "()"; //cette ligne affiche le nom de la classe
        System.out.println(str);
        tabTest[iTest].tester();
    }
}
