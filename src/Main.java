import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import static java.lang.Double.parseDouble;

public class Main {

    private static void lerArquivo(ArrayList<Elemento> elementos) {
        System.out.print("Insira o nome do arquivo de entrada: ");
        //Scanner entrada = new Scanner(System.in);
        //String nomeArquivo = entrada.nextLine();
        String nomeArquivo = "bases/int_base_59.data";
        ArrayList<Double> aux = new ArrayList<>();
        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            while ((linha = lerArq.readLine()) != null) {
                String[] lido = linha.split(",");
                for (int i = 0; i < lido.length; i++){
                    aux.add(parseDouble(lido[i]));
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
        String nomeArquivo = "bases/int_centroid_59_20.data";
        ArrayList<Double> aux = new ArrayList<>();
        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            while ((linha = lerArq.readLine()) != null) {
                String[] lido = linha.split(",");
                for (int i = 0; i < lido.length; i++){
                    aux.add(parseDouble(lido[i]));
                }
                centroides.add( new Centroide(aux));
                aux.clear();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    public static void main(String[] args) {
        ArrayList<Elemento> elementos = new ArrayList<>();
        lerArquivo(elementos);
        ArrayList<Centroide> centroides = new ArrayList<>();
        lerArquivoCentroide(centroides);
        KMeans teste = new KMeans(centroides,elementos);
        teste.executa();
    }
}
