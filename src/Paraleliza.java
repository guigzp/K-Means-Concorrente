import java.util.ArrayList;
import java.lang.Thread;
import java.util.List;


public class Paraleliza extends  Thread{
    private ArrayList<Centroide> centroides;
    private List<Elemento> elementos;

    public Paraleliza(ArrayList<Centroide> centroides, List<Elemento> elementos) {
        this.centroides = centroides;
        this.elementos = elementos;
    }

    @Override
    public void run(){
        for (Elemento e : this.elementos){
            melhorCentroide(e);
        }
    }

    public void melhorCentroide(Elemento e){
        Integer menorDistancia = Integer.MAX_VALUE;
        Centroide melhor = new Centroide();
        for (Centroide c : this.centroides){
            int aux = calculaDistancia(e, c);
            if (menorDistancia > aux){
                menorDistancia = aux;
                melhor = c;
            }
        }
        e.setIndiceCentroide(this.centroides.indexOf(melhor));
    }

    public int calculaDistancia(Elemento e, Centroide c){
        int qtd = e.getCoordenadas().size();
        int somatorio = 0;
        for (int i = 0; i < qtd; i++){
            somatorio += Math.pow(e.getCoordenadas().get(i) - c.getCoordenadas().get(i), 2.0);
        }
        return (int) Math.sqrt(somatorio);
    }

}
