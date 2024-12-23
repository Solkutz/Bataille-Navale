import java.util.ArrayList;
import java.util.function.Function;

public class Main {
    /*
         0123456789
        0..111.....
        1..........
        2........2.
        3........2.
        4..........
        5..........
        6..33333...
        7..4.......
        8..4.......
        9..........
     */
    public static void main(String[] args) {
        Function<Case, String> etatDeLaCase = (etatCase) -> (etatCase.getEtat() == EtatCase.INVISIBLE ? "." : etatCase.getEtat() == EtatCase.VISIBLE ?  "O" : "X");
        ArrayList<Bateau> listBateau = new ArrayList<Bateau>();

        Plateau plateau1 = new Plateau(listBateau);
        ParcourirTableau tableau = new ParcourirTableau();

        int [] x1 = {2,3,4};
        int [] y1 = {0,0,0};
        Bateau bateau1 = new Bateau("bateau1",3,x1,y1);

        int [] x2 = {8,8};
        int [] y2 = {2,3};
        Bateau bateau2 = new Bateau("bateau2",3,x2,y2);

        int [] x3 = {2,3,4,5,6};
        int [] y3 = {6,6,6,6,6};
        Bateau bateau3 = new Bateau("bateau3",3,x3,y3);

        int [] x4 = {2,2};
        int [] y4 = {7,8};
        Bateau bateau4 = new Bateau("bateau4",2,x4,y4);

        listBateau.add(bateau1);
        listBateau.add(bateau2);
        listBateau.add(bateau3);
        listBateau.add(bateau4);

        for (int i = 0; i < plateau1.getListBateau().size(); i++) {

        }
        System.out.println("---------------------------");
        plateau1.updatePlateau(8,2);
        tableau.AfficherTableau(plateau1.getTabCase(), etatDeLaCase);

        System.out.println("---------------------------");
        plateau1.updatePlateau(1,1);
        tableau.AfficherTableau(plateau1.getTabCase(), etatDeLaCase);
    }
}