/*  420-201 - TP5
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

package tp5G3SeabornD2351867;

import tp5G3SeabornD2351867._utile.Utile;
import tp5G3SeabornD2351867.paquet.Paquet;

public class Partie21 {
    private Main21 jeuBanquier;
    private Main21 jeuJoueur;
    private Paquet paquet;

    public void jouer() {
        paquet = new Paquet(true);
        jeuJoueur = new Main21(paquet, 2);
        jeuBanquier = new Main21(paquet, 2);
        if (!debuterPartie()) {
            if (!faireJouerLeJoueur()) {
                faireJouerLeBanquier();
            }
        }
        afficherMessagePartieTermine();
    }

    private void afficherMessagePartieTermine() {
        if(jeuBanquier.main21Perdante() && jeuJoueur.main21Perdante()) {
            System.out.println("Vous avez perdu en dépassant 21 !\n" +
                    "Le banquier a perdu en dépassant 21 !");
        } else if (jeuBanquier.main21Gagnante() && jeuJoueur.main21Gagnante()) {
            System.out.println("Vous avez gagné!\n" +
                    "Le banquier a gagné!");
        } else if (jeuJoueur.main21Perdante()) {
            System.out.println("Vous avez perdu: vous avez dépassé 21.");
        } else if (jeuBanquier.main21Perdante()) {
            System.out.println("Vous avez gagné! Le banquier a dépassé 21");
        } else if (jeuJoueur.getValeurMainDe21() > jeuBanquier.getValeurMainDe21()) {
            System.out.println("Vous avez gagné!");
        } else {
            System.out.println("Le banquier a gagné!");
        }
        System.out.println();
    }

    private void faireJouerLeBanquier() {
        while (jeuBanquier.getValeurMainDe21() <= jeuJoueur.getValeurMainDe21() && !jeuBanquier.main21GagnanteOuPerdante()) {
            System.out.println("Le banquier pige...");
            jeuBanquier.pigerAu21();
            afficherJeuBanquier();
            System.out.println();
        }
    }

    private boolean faireJouerLeJoueur() {
        String strReponse;
        boolean estReponseValide;


        do { //tant que le joueur ne conserve pas sa main
            do { //tant que la réponse du joueur n'est pas valide
                strReponse = Utile.lireString("(C)onserver son jeu ou (d)emander une carte ?");
                estReponseValide = strReponse.equalsIgnoreCase("d") || strReponse.equalsIgnoreCase("c");
                if (!estReponseValide) {
                    System.out.print("Entrez un choix valide (cd)");
                }
                System.out.println();
            } while (!estReponseValide);

            if (strReponse.equalsIgnoreCase("d")) {
                jeuJoueur.pigerAu21();
                afficherJeuJoueur();
            }
        } while (!strReponse.equalsIgnoreCase("c") && !jeuJoueur.main21GagnanteOuPerdante());
        return jeuJoueur.main21GagnanteOuPerdante();
    }

    private boolean debuterPartie() {
        afficherJeuBanquier();
        System.out.println();
        afficherJeuJoueur();
        return jeuBanquier.main21GagnanteOuPerdante() || jeuJoueur.main21GagnanteOuPerdante();
    }

    private void afficherJeuJoueur() {
        System.out.print("Votre jeu :\n" + jeuJoueur);
    }

    private void afficherJeuBanquier() {
        System.out.print("Jeu du banquier :\n" + jeuBanquier);
    }
}