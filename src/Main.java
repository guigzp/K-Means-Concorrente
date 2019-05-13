import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {

    private static void lerArquivos(ArrayList<Centroide> centroides, ArrayList<Elemento> elementos, String nomeArquivoCentroide, String nomeArquivoBase) {
        ArrayList<Integer> aux = new ArrayList<>();
        ArrayList<Integer> aux2 = new ArrayList<>();
        String linha;
        try {
            FileReader arq = new FileReader(nomeArquivoCentroide);
            BufferedReader lerArq = new BufferedReader(arq);
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
        try {
            FileReader arq = new FileReader(nomeArquivoBase);
            BufferedReader lerArq = new BufferedReader(arq);
            while ((linha = lerArq.readLine()) != null) {
                String[] lido = linha.split(",");
                for (int i = 0; i < lido.length; i++){
                    aux2.add(parseInt(lido[i]));
                }
                elementos.add( new Elemento(aux2));
                aux2.clear();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    private static void menu(){
        System.out.println("Algoritmo K-Means Paralelo e Sequencial");
        System.out.println("Escolha o tamanho da base:");
        System.out.println("1) 59\n2) 161\n3) 256\n4) 1380\n5) 1601");
    }


    public static void main(String[] args) throws InterruptedException{
        int opcao;
        Scanner entrada = new Scanner(System.in);
        String nomeArquivoCentroide ="", nomeArquivoBase="";
        do{
            menu();
            opcao = entrada.nextInt();
            if(opcao < 1 || opcao >5){
                System.out.println("Valor Inválido!\n");
            }
        }while(opcao < 1 || opcao > 5);
        switch (opcao){
            case 1:
                nomeArquivoBase = "bases/int_base_59.data";
                nomeArquivoCentroide = "bases/int_centroid_59_20.data";
                break;
            case 2:
                nomeArquivoBase = "bases/int_base_161.data";
                nomeArquivoCentroide = "bases/int_centroid_161_20.data";
                break;
            case 3:
                nomeArquivoBase = "bases/int_base_256.data";
                nomeArquivoCentroide = "bases/int_centroid_256_20.data";
                break;
            case 4:
                nomeArquivoBase = "bases/int_base_1380.data";
                nomeArquivoCentroide = "bases/int_centroid_1380_20.data";
                break;
            case 5:
                nomeArquivoBase = "bases/int_base_1601.data";
                nomeArquivoCentroide = "bases/int_centroid_1601_20.data";
                break;
            default:
                break;
        }
        ArrayList<Elemento> elementos = new ArrayList<>();
        ArrayList<Centroide> centroides = new ArrayList<>();
        lerArquivos(centroides, elementos, nomeArquivoCentroide, nomeArquivoBase);
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
