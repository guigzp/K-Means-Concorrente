import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

public class KMeansConcorrente {
    private ArrayList<Centroide> centroides;
    private ArrayList<Elemento> elementos;
    private int iteracoes = 0;
    private int quantidadeThreads;

    public int getIteracoes() {
        return iteracoes;
    }
    public void incrementaIteracaoes(){
        this.iteracoes ++;
    }

    public KMeansConcorrente(ArrayList<Centroide> centroides, ArrayList<Elemento> elementos, int quantidadeThreads) {
        this.centroides = (ArrayList) centroides.clone();
        this.elementos = (ArrayList) elementos.clone();
        this.quantidadeThreads = quantidadeThreads;
    }

    public ArrayList<Centroide> getCentroides() {
        return centroides;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void executa() throws InterruptedException {
        Boolean moveu;
        ArrayList<Paraleliza> threads = new ArrayList<>();
        ArrayList<List<Elemento>> elementosThreads = new ArrayList<>();
        int inicio = 0, qtdElementos = this.elementos.size(),
                qtdElementosThread = qtdElementos / this.quantidadeThreads, fim = qtdElementosThread;

        for(int i = 0; i < this.quantidadeThreads; i++){
            if (i == this.quantidadeThreads - 1){
                fim = qtdElementos;
            }
            elementosThreads.add(this.elementos.subList(inicio, fim));
            inicio = fim;
            fim += qtdElementosThread;
        }

        do{
            incrementaIteracaoes();
            for (Centroide c : this.centroides){
                c.getElementos().clear();
            }
            moveu = false;

            for (int i = 0; i < this.quantidadeThreads; i++){
                threads.add(new Paraleliza(this.centroides,  elementosThreads.get(i)));
            }

            for(Paraleliza p : threads){
                p.start();
            }

            for(Paraleliza p : threads){
                p.join();
            }
            for(Elemento e : this.elementos){
                this.centroides.get(e.getIndiceCentroide()).addElemento(e);
            }
            for(Centroide c : this.centroides){
                if(c.moveCentroide()){
                    moveu = true;
                }
            }
            threads.clear();
        }while(moveu);
    }
}
