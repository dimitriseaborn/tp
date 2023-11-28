package tp5G3SeabornD2351867;

import tp5G3SeabornD2351867.Main21;
import tp5G3SeabornD2351867._utile.Utile;
import tp5G3SeabornD2351867.paquet.Paquet;

public class Partie21 {
    private Main21 jeuBanquier;
    private Main21 jeuJoueur;
    private Paquet paquet;

    public void jouer() {
        paquet = new Paquet(true);
        jeuJoueur = new Main21(paquet);
        jeuBanquier = new Main21(paquet);
        debuterPartie();
        faireJouerLeJoueur();
    }

    private boolean faireJouerLeJoueur() {
        String strReponse;
        boolean estReponseValide;


        do { //tant que le joueur ne conserve pas sa main
            do { //tant que la réponse du joueur n'est pas valide
                strReponse = Utile.lireString("(C)onserver son jeu ou (d)emander une carte ?");
                estReponseValide = strReponse.equalsIgnoreCase("e") || strReponse.equalsIgnoreCase("c");
                if (!estReponseValide) {
                    System.out.println("Entrez un choix valide (cd)");
                }
            } while (!estReponseValide);

            if (strReponse.equalsIgnoreCase("d")) {
                jeuJoueur.pigerAu21();
                afficherJeuJoueur();
            }
        } while (!strReponse.equalsIgnoreCase("c"));
        return jeuJoueur.main21GagnanteOuPerdante();
    }

    private boolean debuterPartie() {
        jeuBanquier.pigerAu21();
        jeuBanquier.pigerAu21();
        jeuJoueur.pigerAu21();
        jeuJoueur.pigerAu21();

        afficherJeuBanquier();
        System.out.println();
        afficherJeuJoueur();
        System.out.println();
        return jeuBanquier.main21GagnanteOuPerdante() || jeuJoueur.main21GagnanteOuPerdante();
    }

    private void afficherJeuJoueur() {
        System.out.print("Votre jeu :\n" + jeuJoueur);
    }

    private void afficherJeuBanquier() {
        System.out.print("Jeu du banquier :\n" + jeuBanquier);
    }
}