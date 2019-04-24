import java.util.ArrayList;
import java.util.List;

public class Elemento {
    private ArrayList<Integer> coordenadas = new ArrayList<Integer>();

    public Elemento(ArrayList<Integer> coordenadas) {
        this.coordenadas = (ArrayList) coordenadas.clone();
    }

    public ArrayList<Integer> getCoordenadas() {
        return this.coordenadas;
    }
}
