import java.util.Arrays;

public class Bateau {
// ---Variable d'un bateau, son nom (id) et ses pv--
    private String nom;
    private int pvBateau;

// --Constructeur du bateau, un constructeur est utilisé à l'initialisation de la classe (quand on fait "Bateau bateau1 = new Bateau("bateau1",3);")--
    public Bateau(String _nom, int _pbBateau){
        this.nom = _nom;
        this.pvBateau = _pbBateau;
    }

// --Getter and Setter--
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public int getPvBateau() {return pvBateau;}
    public void setPvBateau(int pvBateau) {this.pvBateau = pvBateau;}

    public void enleverPvBateau(int enleverPv) {this.pvBateau -= enleverPv;}
}
