import java.util.ArrayList;

public class Plateau {
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

    public void tirer(int x, int y){
    }

}
