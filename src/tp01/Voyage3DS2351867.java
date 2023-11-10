/*  TP1
 *  Cours 420-201 - Introduction à la programmation
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

package tp01;

import java.util.Scanner;

public class Voyage3DS2351867 {
    public Voyage3DS2351867() {
        tester_afficherInfoVoyage();
        demanderInfosEtAfficherVoyage();
    }

    public String to2Decimal(double value) {
        String strFormatAvec2Decimales;
        java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
        strFormatAvec2Decimales = df.format(value);
        return strFormatAvec2Decimales;
    }

    private void demanderInfosEtAfficherVoyage() {
        double distance;
        double temps;
        double prixEssence;
        double litreEssence;

        distance = lireDouble("Quelle distance avez-vous parcourue? ");
        temps = lireDouble("En combien de temps (en heure)? ");
        prixEssence = lireDouble("Quel est le prix de l'essence? ");
        litreEssence = lireDouble("Combien de litres d'essence avez-vous utilisés? ");
        afficherInfoVoyage(distance, temps, prixEssence, litreEssence);
    }

    private double lireDouble(String question) {
        double reponse;

        reponse = Double.parseDouble(lireString(question));
        return reponse;
    }

    private void tester_afficherInfoVoyage() {
        afficherInfoVoyage(100, 1, 1.0, 10);
        afficherInfoVoyage(1, 0.3, 22, 10);
        afficherInfoVoyage(5.5, 1.2, 2.7, 3.24);
    }

    private void afficherInfoVoyage(double distance, double temps, double prixEssence, double litreEssence) {
        String vitesseMoyenne;
        String consommationMoyenneAu100Km;
        String prixVoyage;
        String str;

        vitesseMoyenne = to2Decimal(calculerVitesseMoyenne(distance, temps));
        consommationMoyenneAu100Km = to2Decimal(calculerConsommationAu100Km(litreEssence, distance));
        prixVoyage = to2Decimal(calculerPrixVoyage(litreEssence, prixEssence));
        str = "==================================================================\n";
        str += "Vous avez parcouru " + distance + " km en " + temps + " heures.\n";
        str += "Le prix de l'essence est de $" + prixEssence + ".\n";
        str += "Vous avez utilisé " + litreEssence + " litres d'essence.\n";
        str += "La vitesse moyenne de la voiture est de : " + vitesseMoyenne + " km/heure.\n";
        str += "Cette voiture a une consommation moyenne de : " + consommationMoyenneAu100Km + " litres/100 km.\n";
        str += "Le voyage a coûté $" + prixVoyage + ".\n";
        str += "==================================================================";
        System.out.println(str);
    }

    private double calculerPrixVoyage(double litreUtilise, double prixEssence) {
        double prixVoyage;

        prixVoyage = litreUtilise * prixEssence;
        return prixVoyage;
    }

    private double calculerVitesseMoyenne(double distance, double temps) {
        double vitesseMoyenne;

        vitesseMoyenne = distance / temps;
        return vitesseMoyenne;
    }

    private double calculerConsommationAu100Km(double litreUtilise, double distance) {
        double consommation;

        consommation = (100 * litreUtilise) / distance;
        return consommation;
    }

    /**
     * Lit une chaine de caractère au clavier et la retourne.
     *
     * @param question la question affichée pour l'utilisateur
     * @return la réponse saisit par l'utilisateur
     */
    private String lireString(String question) {
        Scanner sc;
        String reponse;

        sc = new Scanner(System.in);
        System.out.print(question);
        reponse = sc.nextLine();
        return reponse;
    }

    public static void main(String[] args) {
        new Voyage3DS2351867();
    }
}
