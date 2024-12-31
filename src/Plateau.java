import java.util.ArrayList;
import java.util.function.Function;

public class Plateau{
// ---Constante indiquant la taille du plateau. Ici on auras un plateau de 10 par 15---
    private static int nbCaseX = 10;
    private static int nbCaseY = 10;

// ---Variable d'un plateau. Ici un plateau est composé d'une liste de bateau et d'un tableau de case à 2 dimension appelé tabCase---
    private ArrayList<Bateau> listBateau;
    private int [][] tabCase;

// ---Constructeur d'un plateau prenant en paramètre la liste des bateaux---
    public Plateau(ArrayList<Bateau> _listBateau, int [][] _tabCase){
        // Initialisation des variables
        this.listBateau = _listBateau;
        this.tabCase = _tabCase;
    }

// ---Getter and Setter---
    public ArrayList<Bateau> getListBateau() { return listBateau;}
    public void setListBateau(ArrayList<Bateau> listBateau) {this.listBateau = listBateau;}


    public int[][] getTabCase() {return tabCase;}
    public void setTabCase(int[][] tabCase) {this.tabCase = tabCase;}

// ---Fonction---

    // Fonction qui affiche le tableau
    public void afficherPlateau(){
        for (int i = 0; i < tabCase.length; i++) {
            for (int j = 0; j < tabCase[i].length; j++) {
                System.out.print(tabCase[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Fonction qui après avoir saisis des coordonnées, vérifie la présence d'un bateau ou non, on utilise une variable intermédiaire (bateauTemp) pour update un bateau complet (ct plus facile)
    // Il faudrat penser à gérer le plateau depuis l'interface. ex : empecher de cliquer sur une case qui à déjà été explorer
    public void updatePlateau(int tirex, int tirey){
        // On vérifie si la case contient un bateau (valeur != 0)
        if(tabCase[tirex][tirey] != 0) {
            // index du bateau sur laquelle on a cliqué
            int indexList =tabCase[tirex][tirey] - 1;
            
            // On enleve un pv au bateau (Pour listBateau.get(indexList), on fais -1 pcq une liste commence à 0)
            Bateau bateauTemp = listBateau.get(indexList);
            bateauTemp.enleverPvBateau(1);
            listBateau.set(indexList, bateauTemp);
            System.out.println("Touché !");

            // Si les pv du bateau sont à 0 on l'enlève
            if(listBateau.get(indexList).getPvBateau() == 0 ){
                listBateau.remove(indexList);
                System.out.println("COULE !!");
            }
        }// Sinon c un coup dans l'eau
        else {System.out.println("coup dans l'eau !");}

    }
}
