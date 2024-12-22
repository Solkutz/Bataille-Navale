import java.util.Arrays;

public class Bateau {
    private String nom;
    private int pvBateau;
    private int [] positionX;
    private int [] positionY;

    public Bateau(String _nom, int _pbBateau, int [] _positionX, int [] _positionY){
        this.nom = _nom;
        this.pvBateau = _pbBateau;
        this.positionX = _positionX;
        this.positionY = _positionY;
    }

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public int getPvBateau() {return pvBateau;}
    public void setPvBateau(int pvBateau) {this.pvBateau = pvBateau;}

    public int[] getPositionX() {return positionX;}
    public void setPositionX(int[] positionX) {this.positionX = positionX;}

    public int[] getPositionY() {return positionY;}
    public void setPositionY(int[] positionY) {this.positionY = positionY;}

    public boolean estTouche(int tirex, int tirey){
        for (int i = 0; i < positionX.length; i++) {
            for (int j = 0; j < positionY.length; j++) {
                if(positionX[i] == tirex && positionY[i] == tirey){
                    pvBateau -= 1;
                    return true;
                }
            }
        }
        return false;
    }
}
