import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {

    private static void lerArquivo(ArrayList<Elemento> elementos) {
        System.out.print("Insira o nome do arquivo de entrada: ");
        //Scanner entrada = new Scanner(System.in);
        //String nomeArquivo = entrada.nextLine();
        String nomeArquivo = "bases/int_base_1601.data";
        ArrayList<Integer> aux = new ArrayList<>();
        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            while ((linha = lerArq.readLine()) != null) {
                String[] lido = linha.split(",");
                for (int i = 0; i < lido.length; i++){
                    aux.add(parseInt(lido[i]));
                }
                elementos.add( new Elemento(aux));
                aux.clear();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    private static void lerArquivoCentroide(ArrayList<Centroide> centroides) {
        System.out.print("Insira o nome do arquivo de entrada: ");
        //Scanner entrada = new Scanner(System.in);
        //String nomeArquivo = entrada.nextLine();
        String nomeArquivo = "bases/int_centroid_1601_20.data";
        ArrayList<Integer> aux = new ArrayList<>();
        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            while ((linha = lerArq.readLine()) != null) {
                String[] lido = linha.split(",");
                for (int i = 0; i < lido.length; i++){
                    aux.add(parseInt(lido[i]));
                }
                centroides.add( new Centroide(aux));
                aux.clear();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ArrayList<Elemento> elementos = new ArrayList<>();
        lerArquivo(elementos);
        ArrayList<Centroide> centroides = new ArrayList<>();
        lerArquivoCentroide(centroides);
        KMeansConcorrente teste = new KMeansConcorrente(centroides,elementos);
        long tempoInicial = System.currentTimeMillis();
        teste.executa();
        long tempoFinal = System.currentTimeMillis();
        long tempo = tempoFinal - tempoInicial;
        System.out.println(tempo);
        for (Centroide c : teste.getCentroides()){
            System.out.println(c.getElementos().size());
        }
    }
}
