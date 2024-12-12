import java.util.function.Function;

public class ParcourirTableau implements ParcourirTableau2D{

    @Override
    public void AfficherTableau(Object[][] tableau, Function condition) {
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                System.out.print(condition.apply(tableau[i][j]));
            }
            System.out.println();
        }
    }
}
