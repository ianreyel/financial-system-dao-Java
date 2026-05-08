import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class GerenciadorArquivos {

    private static final String ArquivoSer = "transacoes.bin";
    private static final String ArquivoCsv = "transacoes.bin";

    public static void salvarDados ( List<Transacao> transacoes){
        try (FileOutputStream fos = new FileOutputStream(ArquivoSer); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(transacoes);
            System.out.println("\nSucesso: A lista foi serializada no arquivo 'transacoes.bin'");
        } catch (IOException e) {
            System.out.println("\nErro ao tentar serializar: " + e.getMessage());
        }
    }

    public static List<Transacao> carregarDados(){
        List<Transacao> listaTransacoes = new ArrayList<>();

        try (java.io.FileInputStream fis = new java.io.FileInputStream(ArquivoSer); java.io.ObjectInputStream ois = new java.io.ObjectInputStream(fis)) {
            listaTransacoes = (List<Transacao>) ois.readObject();
            System.out.println("\nSucesso: Arquivo lido e desserializado");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("\nAviso: Arquivo não encontrado ou erro de leitura. Iniciando com lista vazia.");
        }
        return listaTransacoes;
    }

    public static void gerarExtrato(List<Transacao> transacoes) {
        try (FileWriter fw = new FileWriter(ArquivoCsv);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (Transacao i : transacoes) {
                String linha = i.getDescricao() + ";" + i.getValor() + ";" + i.getData();
                bw.write(linha);
                bw.newLine();
            }

            System.out.println("\nSucesso: Arquivo 'extrato.csv' gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("\nErro ao gerar o extrato: " + e.getMessage());
        }
    }
}
