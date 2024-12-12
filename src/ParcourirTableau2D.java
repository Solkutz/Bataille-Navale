import java.util.function.Function;

public interface ParcourirTableau2D<T, R> {
    void AfficherTableau(T[][] tableau, Function<T, R> condition);
}