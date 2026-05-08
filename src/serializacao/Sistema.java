import java.util.List;


public class Sistema {
    public static void main(String[] args) {
        List<Transacao> listaTransacoes = GerenciadorArquivos.carregarDados();
        System.out.println("Total de transações carregadas: " + listaTransacoes.size());

        try {
            Despesa d1 = new Despesa("Conta de agua", 56.31, "25/02/2026");
            listaTransacoes.add(d1);
        }catch(ValorInvalidoException | IllegalArgumentException e){
            System.out.println(" \n Erro ao criar transação:" + e.getMessage());
        }

        GerenciadorArquivos.salvarDados(listaTransacoes);

        System.out.println("\n EXTRATO FINAL");

        for (Transacao item : listaTransacoes) {

            item.exibirDetalhes();

            if (item instanceof Tributavel) {
                Tributavel itemTributavel = (Tributavel) item;
                System.out.println(" \n Imposto a ser pago: R$ " + itemTributavel.calcularImposto() );
            }
        }

        GerenciadorArquivos.gerarExtrato(listaTransacoes);

    }
}
