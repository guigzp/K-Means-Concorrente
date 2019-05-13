import java.util.ArrayList;
import java.io.IOException;

public class KMeansConcorrente {
    private ArrayList<Centroide> centroides;
    private ArrayList<Elemento> elementos;

    public KMeansConcorrente(ArrayList<Centroide> centroides, ArrayList<Elemento> elementos) {
        this.centroides = (ArrayList) centroides.clone();
        this.elementos = (ArrayList) elementos.clone();
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
        ArrayList<Elemento> elementosAux = new ArrayList<>();
        ArrayList<Elemento> elementosAux2 = new ArrayList<>();

        for(int i = 0; i < this.elementos.size() / 2; i++){
            elementosAux.add(this.elementos.get(i));
        }

        for(int i = this.elementos.size() / 2; i < this.elementos.size(); i++){
            elementosAux2.add(this.elementos.get(i));
        }

        do{
            for (Centroide c : this.centroides){
                c.getElementos().clear();
            }
            moveu = false;

            threads.add(new Paraleliza(this.centroides, elementosAux));
            threads.add(new Paraleliza(this.centroides, elementosAux2));

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
