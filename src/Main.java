import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

// Sans interface, cette partis est utilisé pour simuler un plateau
    // Ajout de la liste des bateaux
    public static ArrayList<Bateau> listBateau = new ArrayList<Bateau>();

    // Plateau utilisé
    public static int[][] plateauExemple = {
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 3, 3, 3, 3, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    // Construction des bateaux
    static Bateau bateau1 = new Bateau("bateau1",3);
    static Bateau bateau2 = new Bateau("bateau2",2);
    static Bateau bateau3 = new Bateau("bateau3",5);
    static Bateau bateau4 = new Bateau("bateau4",2);

    // Construction du plateau
    static Plateau plateau1 = new Plateau(listBateau,plateauExemple);

    // Indice de la matrice (utilisé pour l'enregistrement de fichier)
    static int indice = plateau1.getTabCase().length;
    // Nom du fichier de sauvegarde
    static String fichierPhysic = "save.dat";

    // Permet d'afficher un plateau ainsi que l'état des bateaux
    public static void afficherJeu(){
        System.out.println("-------------- Plateau -------------");
        plateau1.afficherPlateau();
        System.out.println("-------------- Bateaux -------------");
        System.out.println("Nom : " + plateau1.getListBateau().get(0).getNom() + " | pv : " + plateau1.getListBateau().get(0).getPvBateau());
        System.out.println("Nom : " + plateau1.getListBateau().get(1).getNom() + " | pv : " + plateau1.getListBateau().get(1).getPvBateau());
        System.out.println("Nom : " + plateau1.getListBateau().get(2).getNom() + " | pv : " + plateau1.getListBateau().get(2).getPvBateau());
        System.out.println("Nom : " + plateau1.getListBateau().get(3).getNom() + " | pv : " + plateau1.getListBateau().get(3).getPvBateau());
    }


    public static void main(String[] args) throws IOException {
        // Ajout des bateaux
        listBateau.add(bateau1);
        listBateau.add(bateau2);
        listBateau.add(bateau3);
        listBateau.add(bateau4);


        // Initialisation de la variable scanner pour la saisie au clavier
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veux tu tester la création de fichier ? oui = 1, non = 0");
        if(scanner.nextInt() != 1) {

            // boucle tant que la liste est pas vide
            while (!plateau1.getListBateau().isEmpty()) {
                afficherJeu();

                System.out.println("         ----- Réponse -----");
                System.out.println("Choisissez une case en x: ");
                int interX = scanner.nextInt();
                System.out.println("Choisissez une case en y: ");
                int interY = scanner.nextInt();

                plateau1.updatePlateau(interX, interY);
            }
            System.out.println("GG");
            scanner.close();
        }else {
            // ------------------------------partie fichier ------------------------------

            sauveMat(plateau1.getTabCase(), fichierPhysic);
            lireMat(plateau1.getTabCase(), fichierPhysic);
        }

    }

    // Fonction permettant de sauvegarder ou ecraser un fichier
    private static void sauveMat (int[][] M, String fichierPhysic) throws IOException {
        String ligneEcrite;
        int i,j;
        boolean yesOrNo;

        // Supprime au cas où il existe
        File tmp = new File(fichierPhysic);
        yesOrNo=tmp.delete();

        // Cree un fichier avec le nom
        PrintWriter fichier = new PrintWriter(new FileWriter(fichierPhysic,true));
        for(i=0;i<indice;i=i+1) {
            ligneEcrite = "";
            for(j=0;j<indice;j=j+1) {
                ligneEcrite = ligneEcrite + M[i][j] + "|";
            }
            fichier.println(ligneEcrite);
        }
        fichier.close();
    }

    // LireMatrice
    private static void lireMat(int[][] M, String fichierPhysic) throws IOException {
        int[] vecteur=new int[indice];
        int i,j;
        String ligne;
        RandomAccessFile fichier = new RandomAccessFile(fichierPhysic,"r");
        fichier.seek(0);
        i=0;

        ligne = fichier.readLine();
        while (ligne != null) {
            vecteur = interprete(ligne);

            for (j=0;j<indice;j=j+1) {
                M[i][j] = vecteur[j];
            }
            i = i + 1;
            ligne = fichier.readLine();
        }
        fichier.close();
    }

    static int[] interprete(String ligne) {
        String valstr;
        int i,j;
        int[] vecteur=new int[indice];
        // dimensionnement et declaration du tableau de caracteres composant la ligne
        char[ ] tabCar = new char [ligne.length( )];
        // transformation String en Array of Char, de la ligne en tabCar
        tabCar = ligne.toCharArray( );
        i=0; //indice dans la ligne

        for (j = 0;j<indice;j=j+1) //indice dans le vecteur ligne
        {
            valstr = "";
            while (( i < (ligne.length( )) ) && (tabCar[i] != '|' )) {
                valstr = valstr + tabCar[i];
                i = i + 1;
            }
            vecteur[j] = Integer.valueOf(valstr).intValue();
            i = i + 1;
        }
        return(vecteur);
    }
}