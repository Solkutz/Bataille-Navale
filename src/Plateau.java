import java.util.ArrayList;
import java.util.function.Function;

public class Plateau{
    private static int nbCaseX = 10;
    private static int nbCaseY = 15;

    private ArrayList<Bateau> listBateau;
    private Case [][] tabCase;

    public Plateau(ArrayList<Bateau> _listBateau){
        this.listBateau = _listBateau;
        this.tabCase = new Case [nbCaseX][nbCaseY];
        creerPlateau();
    }

    public ArrayList<Bateau> getListBateau() { return listBateau;}
    public void setListBateau(ArrayList<Bateau> listBateau) {this.listBateau = listBateau;}

    public void creerPlateau(){
        for (int i = 0; i < nbCaseX; i++) {
            for (int j = 0; j < nbCaseY; j++) {
                tabCase[i][j] = new Case(EtatCase.INVISIBLE);
            }
        }
    }

    public Case[][] getTabCase() {return tabCase;}
    public void setTabCase(Case[][] tabCase) {this.tabCase = tabCase;}

    public void updatePlateau(int tirex, int tirey){
        for (int i = 0; i < listBateau.size(); i++) {
            System.out.println("- bateau :"+listBateau.get(i).estTouche(tirex,tirey));
            if (listBateau.get(i).estTouche(tirex,tirey) ){
                tabCase[tirex][tirey].setEtat(EtatCase.TOUCHE);
                return;
            }
        }
        tabCase[tirex][tirey].setEtat(EtatCase.VISIBLE);
    }
}
