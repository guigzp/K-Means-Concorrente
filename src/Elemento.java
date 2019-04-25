import java.util.ArrayList;

public class Elemento {
    private ArrayList<Integer> coordenadas = new ArrayList<>();

    public Elemento(ArrayList<Integer> coordenadas) {
        this.coordenadas = (ArrayList) coordenadas.clone();
    }

    public ArrayList<Integer> getCoordenadas() {
        return this.coordenadas;
    }
}
