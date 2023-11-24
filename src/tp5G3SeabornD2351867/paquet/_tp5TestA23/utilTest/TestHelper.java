package tp5G3SeabornD2351867.paquet._tp5TestA23.utilTest;

import tp5G3SeabornD2351867.paquet.Carte;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Inspiré par les Fluents Assertions:
 *
 * @author Robert Aubé
 * @version novembre 2023 - v3.0
 * @see <a href="https://fluentassertions.com/tips/</a>
 */
public class TestHelper {
    public static final boolean EXCEPTION_ENABLE = false;
    private final boolean exceptionEnable;
    public boolean testReussi;
    public String descriptionTest;

    private int nbTestReussi = 0;
    private int nbTestEchec = 0;

    /**
     * Test Helper offre des méthodes de vérification d'erreurs.
     * afficherBilan(), affichera un bilan en ce qui concerne le nombre d'erreurs détectées.
     * Par défaut n'arrête pas si le teste est en erreur
     */
    public TestHelper() {
        this(EXCEPTION_ENABLE);
    }

    /**
     * Test Helper offre des méthodes de vérification d'erreurs.
     * afficherBilan(), affichera un bilan en ce qui concerne le nombre d'erreurs détectées.
     * Lance une exception et provoque l'arrêt de l'exécution si exceptionEnable est true
     *
     * @param exceptionEnable Si à true, lors d'une erreur, une exception est lancée provoquant l'arrêt du programme où l'erreur s'est produite.
     */
    public TestHelper(boolean exceptionEnable) {
        this.exceptionEnable = exceptionEnable;
        setEncodage_UTF8ToStdOut();
        //  afficherInstruction();
    }

    public static void afficherInstruction() {

        String strInstructions = "Pour que ça fonctionne :" +
                "\n1 - Attention de décommenter tous les tests!" +
                "\n2 - Vous devez absolument respecter les noms de méthodes du diagramme de classe de l'examen." +
                "\nATTENTION:" +
                "\n    Ne changez pas le code des classes de tests. C'est avec ceux-ci que la correction se fait.";

        System.out.println(strInstructions);
    }

    /**
     * Utiliser l'encodage UTF8
     */
    public static void setEncodage_UTF8ToStdOut() {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
    }

    public void afficherResultatDuTest() {
        String str;
        str = testReussi ? "Ok: " : "XXXXXXXXX - Le test ne passe pas: ";
        str += descriptionTest;
        System.out.println(str);
    }

    public void afficherBilan() {
        String str;
        int nbTest;

        nbTest = nbTestReussi + nbTestEchec;

        if (nbTest == 0) {
            str = "Aucun test n'a été réalisé.";
        } else {
            str = getStrBilan();
        }
        System.out.println(str);
    }

    private String getStrBilan() {
        String str = "";
        int nbTest;
        double pourCent;
        String strPourCent;
        String strRes;

        nbTest = nbTestReussi + nbTestEchec;
        if (nbTest >= 0) {
            pourCent = (double) nbTestReussi / nbTest * 100;
            strPourCent = String.format("%,.1f", pourCent);
            strRes = String.format("%,.1f", (pourCent * 0.50));
            str = "Il y a eu " + nbTestReussi + " tests réussis ";
            str += "et " + nbTestEchec + " échecs ";
            str += "pour un total de " + nbTest + " tests.";
            str += " (" + strPourCent + "%)";
            str += " (" + strRes + "/ 50)";
        }

        return str;
    }

    public boolean shouldBeEqual(int actual, int expected) {
        boolean testReussi = actual == expected;
        if (!testReussi) {
            System.out.println("Résultat: \"" + actual + "\"");
            System.out.println("Attendu : \"" + expected + "\"");
            lancerException("shouldBeEqual( actual:" + actual + ", expected:" + expected + ")");
            nbTestEchec++;
        } else nbTestReussi++;
        return testReussi;
    }

    private void lancerException(String messageException) {
        if (exceptionEnable) {
            throw new RuntimeException(messageException);
        }
    }

    public boolean shouldBeEqual(double actual, double expected) {
        boolean testReussi = actual == expected;
        if (!testReussi) {
            System.out.println("Résultat: \"" + actual + "\"");
            System.out.println("Attendu : \"" + expected + "\"");
            lancerException("shouldBeEqual( actual:" + actual + ", expected:" + expected + ")");
            nbTestEchec++;
        } else nbTestReussi++;
        return testReussi;
    }

    public boolean shouldBeEqual(boolean actual, boolean expected) {
        boolean testReussi = actual == expected;
        if (!testReussi) {
            System.out.println("Résultat: \"" + actual + "\"");
            System.out.println("Attendu : \"" + expected + "\"");
            lancerException("shouldBeEqual( actual:" + actual + ", expected:" + expected + ")");
            nbTestEchec++;
        } else nbTestReussi++;
        return testReussi;
    }

    public boolean shouldBeTrue(boolean actual) {
        boolean testReussi;

        testReussi = actual;
        if (!testReussi) {
            System.out.println("Résultat: \"" + actual + "\"");
            System.out.println("Attendu : \"" + true + "\"");
            lancerException("shouldBeTrue( actual:" + actual + ", expected:" + true + ")");
            nbTestEchec++;
        } else nbTestReussi++;

        return testReussi;
    }

    public boolean shouldBeFalse(boolean actual) {
        boolean testReussi;

        testReussi = !actual;
        if (!testReussi) {
            System.out.println("Résultat: \"" + actual + "\"");
            System.out.println("Attendu : \"" + false + "\"");
            lancerException("shouldBeFalse( actual:" + actual + ", expected:" + false + ")");
            nbTestEchec++;
        } else nbTestReussi++;

        return testReussi;
    }

    public boolean shouldBeNull(Object actual) {
        boolean testReussi;

        testReussi = actual == null;
        if (!testReussi) {
            System.out.println("Devrait être à null: \"" + actual + "\"");
            lancerException("shouldBeNull( devrait être à null:" + actual + ")");
            nbTestEchec++;
        } else nbTestReussi++;

        return testReussi;
    }

    public boolean shouldNotBeNull(Object actual) {
        boolean testReussi;

        testReussi = actual != null;
        if (!testReussi) {
            System.out.println("Ne devrait pas être à null: \"" + actual + "\"");
            lancerException("shouldNotBeNull( actual:" + actual + ")");
            nbTestEchec++;
        } else nbTestReussi++;

        return testReussi;
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
            lancerException("shouldBeEqual( actual:" + actual + ", expected:" + expected + ")");
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
            System.out.println("Résultat ne devrait pas être : \"" + actual + "\"");
            lancerException("Résultat ne devrait pas être : \"" + actual + "\"");
            nbTestEchec++;
        } else nbTestReussi++;
        return testReussi;
    }

    public void error(String message) {
        System.out.println(message);
        lancerException(message);
        nbTestEchec++;
    }

    public void succes() {
        nbTestReussi++;
    }

    public void shouldNotBeNull(Carte c) {
    }
}
