import java.util.ArrayList;

public class Elemento {
    private ArrayList<Double> coordenadas = new ArrayList<>();

    public Elemento(ArrayList<Double> coordenadas) {
        this.coordenadas = (ArrayList) coordenadas.clone();
    }

    public ArrayList<Double> getCoordenadas() {
        return this.coordenadas;
    }
}
