import java.util.ArrayList;

public class KMeans {
    private ArrayList<Centroide> centroides;
    private ArrayList<Elemento> elementos;

    public KMeans(ArrayList<Centroide> centroides, ArrayList<Elemento> elementos) {
        this.centroides = (ArrayList) centroides.clone();
        this.elementos = (ArrayList) elementos.clone();
    }

    public ArrayList<Centroide> getCentroides() {
        return centroides;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void atribuiConjuntos(){
        for (Elemento e : this.elementos){
            melhorCentroide(e);
        }
    }

    public void melhorCentroide(Elemento e){
        Double menorDistancia = Double.MAX_VALUE;
        Centroide melhor = new Centroide();
        for (Centroide c : this.centroides){
            Double aux = calculaDistancia(e, c);
            if (menorDistancia > aux){
                menorDistancia = aux;
                melhor = c;
            }
        }
        int aux2 = this.centroides.indexOf(melhor);
        this.centroides.get(aux2).addElemento(e);
    }

    public Double calculaDistancia(Elemento e, Centroide c){
        int qtd = e.getCoordenadas().size();
        Double somatorio = 0.0;
        for (int i = 0; i < qtd; i++){
            somatorio += Math.pow(e.getCoordenadas().get(i) - c.getCoordenadas().get(i), 2.0);
        }
        return Math.sqrt(somatorio);
    }
}
