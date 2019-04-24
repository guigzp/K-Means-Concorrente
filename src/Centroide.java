import java.util.ArrayList;
import java.util.List;

public class Centroide {
    private ArrayList<Double> coordenadas = new ArrayList<>();
    private ArrayList<Elemento> elementos = new ArrayList<>();

    public Centroide(ArrayList<Double> coordenadas) {
        this.coordenadas = (ArrayList) coordenadas.clone();
    }

    public Centroide(){

    }

    public void addElemento(Elemento e){
        this.elementos.add(e);
    }

    public ArrayList<Double> getCoordenadas() {
        return coordenadas;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public Boolean moveCentroide(){
        int qtdCoordenadas = this.coordenadas.size();
        ArrayList<Double> aux = new ArrayList<>();
        Double soma = 0.0;
        for(int i = 0; i < qtdCoordenadas; i++){
            for(Elemento e: this.elementos){
                soma += e.getCoordenadas().get(i);
            }
            aux.add(soma);
            soma = 0.0;
        }
        this.elementos.clear();
        if(this.coordenadas.equals(aux)){
            return false;
        }else{
            this.coordenadas = aux;
            return true;
        }
    }

}
