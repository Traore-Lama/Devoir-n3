import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            // Affichage du menu principal
            System.out.println("1 - Exercice 1");
            System.out.println("2 - Exercice 2");
            System.out.println("0 - Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            // Gestion des choix
            switch (choix) {
                case 1:
                    // Lancer l'exercice 1
                    exercice1();
                    break;
                case 2:
                    // Lancer l'exercice 2
                    exercice2();
                    break;
                case 0:
                    // Fin du programme
                    System.out.println("Fin du programme.");
                    break;
                default:
                    // Message en cas de choix invalide
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 0); // Boucle jusqu'à ce que l'utilisateur quitte

        // Ne pas fermer le scanner ici si vous l'utilisez dans plusieurs endroits
    }

    // Exercice 1 : Simulation d'une partie de cartes
    public static void exercice1() {
        // Initialisation du paquet
        int[] paquet = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Mélange du tableau
        melangerTableau(paquet);

        // Distribution des cartes entre deux joueurs
        int[] paquetJoueur1 = new int[5];
        int[] paquetJoueur2 = new int[5];
        dispatcherTableaux(paquetJoueur1, paquetJoueur2, paquet);

        // Affichage des résultats
        System.out.println("Paquet mélangé : " + Arrays.toString(paquet));
        System.out.println("Paquet Joueur 1 : " + Arrays.toString(paquetJoueur1));
        System.out.println("Paquet Joueur 2 : " + Arrays.toString(paquetJoueur2));

        // Comparaison des cartes et affichage du vainqueur
        comparerCartes(paquetJoueur1, paquetJoueur2);
    }

    // Mélanger le tableau en échangeant des indices aléatoires
    public static void melangerTableau(int[] unTableau) {
        Random random = new Random();
        for (int i = 0; i < unTableau.length * 2; i++) {  // Augmenter les échanges pour améliorer le mélange
            // On tire deux nombres aléatoires entre 0 et la longueur du tableau
            int idx1 = random.nextInt(unTableau.length);
            int idx2 = random.nextInt(unTableau.length);

            // On inverse les cases correspondantes aux indices des 2 nombres obtenus préalablement
            echanger(unTableau, idx1, idx2);
        }
    }

    // Échanger deux éléments dans un tableau
    public static void echanger(int[] tableau, int i, int j) {
        int temp = tableau[i];
        tableau[i] = tableau[j];
        tableau[j] = temp;
    }

    // Distribution des cartes entre deux joueurs
    public static void dispatcherTableaux(int[] tabJoueur1, int[] tabJoueur2, int[] tabPaquet) {
        for (int i = 0; i < tabPaquet.length; i++) {
            // Alternance des cartes entre les deux joueurs
            if (i % 2 == 0) {
                tabJoueur1[i / 2] = tabPaquet[i];
            } else {
                tabJoueur2[i / 2] = tabPaquet[i];
            }
        }
    }

    // Comparaison des cartes pour déterminer le vainqueur
    public static void comparerCartes(int[] tabJoueur1, int[] tabJoueur2) {
        int scoreJoueur1 = 0;
        int scoreJoueur2 = 0;

        // Comparaison des plis un par un
        System.out.println("\nDéroulement de la partie :");
        for (int i = 0; i < tabJoueur1.length; i++) {
            if (tabJoueur1[i] > tabJoueur2[i]) {
                // Joueur 1 gagne le pli
                System.out.println("Pli " + (i + 1) + " : Joueur 1 gagne (" + tabJoueur1[i] + " > " + tabJoueur2[i] + ")");
                scoreJoueur1++;
            } else if (tabJoueur1[i] < tabJoueur2[i]) {
                // Joueur 2 gagne le pli
                System.out.println("Pli " + (i + 1) + " : Joueur 2 gagne (" + tabJoueur1[i] + " < " + tabJoueur2[i] + ")");
                scoreJoueur2++;
            } else {
                // Égalité sur le pli
                System.out.println("Pli " + (i + 1) + " : Égalité (" + tabJoueur1[i] + " = " + tabJoueur2[i] + ")");
            }
        }

        // Affichage des scores finaux
        System.out.println("\nScore final :");
        System.out.println("Joueur 1 : " + scoreJoueur1 + " points");
        System.out.println("Joueur 2 : " + scoreJoueur2 + " points");

        // Détermination du vainqueur global
        if (scoreJoueur1 > scoreJoueur2) {
            System.out.println("Le vainqueur est le Joueur 1 !");
        } else if (scoreJoueur1 < scoreJoueur2) {
            System.out.println("Le vainqueur est le Joueur 2 !");
        } else {
            System.out.println("La partie se termine par une égalité !");
        }
    }

    // Exercice 2 : Gestion des films et des notes
    public static void exercice2() {
        // Initialisation des tableaux pour les genres, films et notes
        String[][] genres = new String[5][2];
        String[][] films = new String[5][4];
        int[][] notes = new int[5][7];

        // Remplissage des tableaux avec des données d'exemple
        remplirTableauxExo2(genres, films, notes);

        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            // Affichage du menu de l'exercice 2
            System.out.println("1 - Afficher informations");
            System.out.println("2 - Noter un film");
            System.out.println("0 - Retour au menu principal");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    // Affichage des informations sur les films et leurs notes
                    afficherInfos(genres, films, notes);
                    break;
                case 2:
                    // Ajouter une note à un film
                    noterFilm(notes, films);
                    break;
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 0);
    }

    // Remplissage des tableaux pour l'exercice 2
    public static void remplirTableauxExo2(String[][] genres, String[][] films, int[][] notes) {
        genres[0] = new String[]{"1", "Genre A"};
        genres[1] = new String[]{"2", "Genre B"};
        genres[2] = new String[]{"3", "Genre C"};
        genres[3] = new String[]{"4", "Genre D"};
        genres[4] = new String[]{"5", "Genre E"};

        films[0] = new String[]{"1", "Film A", "1", "21"};
        films[1] = new String[]{"2", "Film B", "2", "19"};
        films[2] = new String[]{"3", "Film C", "3", "24"};
        films[3] = new String[]{"4", "Film D", "4", "20"};
        films[4] = new String[]{"5", "Film E", "5", "14"};

        notes[0] = new int[]{5, 4, 5, 4, 3, 0, 0};
        notes[1] = new int[]{3, 4, 4, 5, 3, 0, 0};
        notes[2] = new int[]{5, 5, 5, 4, 5, 0, 0};
        notes[3] = new int[]{4, 4, 3, 4, 5, 0, 0};
        notes[4] = new int[]{3, 2, 3, 2, 4, 0, 0};
    }

    // Affichage des informations sur les films
    public static void afficherInfos(String[][] genres, String[][] films, int[][] notes) {
        System.out.println("Films et genres :");
        for (int i = 0; i < films.length; i++) {
            System.out.println("Film : " + films[i][1] + " | Genre : " + genres[i][1]);
            System.out.print("Notes : ");
            boolean hasNotes = false;
            for (int note : notes[i]) {
                if (note != 0) {
                    System.out.print(note + " ");
                    hasNotes = true;
                }
            }
            if (!hasNotes) {
                System.out.print("Aucune note disponible.");
            }
            System.out.println();
        }
    }

    // Ajouter une note à un film
    public static void noterFilm(int[][] notes, String[][] films) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro du film que vous souhaitez noter (1-5) : ");
        int filmNum = scanner.nextInt() - 1;

        // Validation du numéro de film
        if (filmNum < 0 || filmNum >= films.length) {
            System.out.println("Film non valide.");
            return;
        }

        // Entrer la note
        System.out.print("Entrez la note pour le film " + films[filmNum][1] + " (1-5) : ");
        int note = scanner.nextInt();
        if (note < 1 || note > 5) {
            System.out.println("Note invalide.");
            return;
        }

        // Recherche d'une case vide pour ajouter la note
        for (int i = 0; i < notes[filmNum].length; i++) {
            if (notes[filmNum][i] == 0) {
                notes[filmNum][i] = note;

                // Mise à jour du score total
                int total = Integer.parseInt(films[filmNum][3]); // Total actuel des notes
                total += note; // Ajouter la nouvelle note
                films[filmNum][3] = String.valueOf(total); // Mettre à jour le total dans les données du film

                System.out.println("Note ajoutée ! Total des notes mis à jour pour " + films[filmNum][1]);
                return;
            }
        }

        System.out.println("Le film " + films[filmNum][1] + " a déjà atteint le nombre maximal de notes.");
    }
}
