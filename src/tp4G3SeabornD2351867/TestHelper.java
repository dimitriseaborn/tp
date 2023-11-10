package tp4G3SeabornD2351867;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Inspiré par les Fluents Assertions:
 *
 * @author Robert Aubé
 * @version décembre 2023
 * @see <a href="https://fluentassertions.com/tips/</a>
 */
public class TestHelper {
    public boolean testReussi;
    public String descriptionTest;

    private int nbTestReussi = 0;
    private int nbTestEchec = 0;

    public TestHelper() {
        setEncodage_UTF8ToStdOut();
        //  afficherInstruction();
    }

    public void afficherResultatDuTest() {
        String str;
        str = testReussi ? "Ok: " : "XXXXXXXXX - Le test ne passe pas: ";
        str += descriptionTest;
        System.out.println(str);
    }

    public void afficherBilan() {
        String str;
        int nbTest = nbTestReussi + nbTestEchec;
        double pourCent = (double) nbTestReussi / nbTest * 100;
        String strPourCent = String.format("%,.1f", pourCent);
        String strRes = String.format("%,.1f", (pourCent * 0.50));
        str = "Il y a eu " + nbTestReussi + " tests réussis ";
        str += "et " + nbTestEchec + " échecs ";
        str += "pour un total de " + nbTest + " tests.";
        str += " (" + strPourCent + "%)";
        str += " (" + strRes + "/ 50)";
        System.out.println(str);
    }

    public static void afficherInstruction() {
        StringBuilder strInstructions = new StringBuilder();

        strInstructions.append("Pour que ça fonctionne :");
        strInstructions.append("\n1 - Attention de décommenter tous les tests!");
        strInstructions.append("\n2 - Vous devez absolument respecter les noms de méthodes du diagramme de classe de l'examen.");
        strInstructions.append("\nATTENTION:");
        strInstructions.append("\n    Ne changez pas le code des classes de tests. C'est avec ceux-ci que la correction se fait.");

        System.out.println(strInstructions);
    }

    /**
     * Utiliser l'encodage UTF8
     */
    public static void setEncodage_UTF8ToStdOut() {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
    }

    public boolean shouldBeEqual(int actual, int expected) {
        boolean testReussi = actual == expected;
        if (!testReussi) {
            System.out.println("Résultat: \"" + actual + "\"");
            System.out.println("Attendu : \"" + expected + "\"");
            nbTestEchec++;
        } else nbTestReussi++;
        return testReussi;
    }

    public boolean shouldBeEqual(double actual, double expected) {
        boolean testReussi = actual == expected;
        if (!testReussi) {
            System.out.println("Résultat: \"" + actual + "\"");
            System.out.println("Attendu : \"" + expected + "\"");
            nbTestEchec++;
        } else nbTestReussi++;
        return testReussi;
    }

    public boolean shouldBeEqual(boolean actual, boolean expected) {
        boolean testReussi = actual == expected;
        if (!testReussi) {
            System.out.println("Résultat: \"" + actual + "\"");
            System.out.println("Attendu : \"" + expected + "\"");
            nbTestEchec++;
        } else nbTestReussi++;
        return testReussi;
    }

    public boolean shouldBeTrue(boolean actual) {
        return shouldBeEqual(actual, true);
    }

    public boolean shouldBeFalse(boolean actual) {
        return shouldBeEqual(actual, false);
    }

    public boolean shouldBeNull(Object actual) {
        return shouldBeEqual(actual, null);
    }

    public boolean shouldBeEqual(Object actual, Object expected) {
        boolean testReussi;
        if (actual == null && expected == null) {
            testReussi = true;
        } else {
            testReussi = actual.equals(expected);
        }
        if (!testReussi) {
            System.out.println("Résultat: \"" + actual + "\"");
            System.out.println("Attendu : \"" + expected + "\"");
            nbTestEchec++;
        } else nbTestReussi++;

        return testReussi;
    }

    public boolean shouldNotBeEqual(Object actual, Object expected) {
        boolean testReussi;
        if (actual == null && expected != null) {
            testReussi = true;
        } else {
            testReussi = !actual.equals(expected);
        }
        if (!testReussi) {
            System.out.println("Résultat: \"" + actual + "\"");
            System.out.println("Attendu : \"" + expected + "\"");
            nbTestEchec++;
        } else nbTestReussi++;
        return testReussi;
    }
}
