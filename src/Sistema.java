import java.sql.SQLException;
import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        TransacaoDAO dao = new TransacaoDAO();

        List<Transacao> listaTransacoes;
        listaTransacoes = dao.listar();

        System.out.println("Total de transações carregadas: " + listaTransacoes.size());
        try {
            Despesa d1 = new Despesa("mercado", 158.69, "18/03/2026");
            Receita r1 = new Receita("bico", 142.50, "20/03/2026");
            try {
                dao.salvar(d1);
                dao.salvar(r1);
            }catch (SQLException e) {
                System.err.println("Erro ao salvar no banco: " + e.getMessage());
            }
            listaTransacoes.add(r1);
        }catch(ValorInvalidoException | IllegalArgumentException e){
            System.out.println(" \n Erro ao criar transação:" + e.getMessage());
        }

        System.out.println("\n EXTRATO FINAL");

        for (Transacao item : listaTransacoes) {

            item.exibirDetalhes();

            if (item instanceof Tributavel) {
                Tributavel itemTributavel = (Tributavel) item;
                System.out.println(" \n Imposto a ser pago: R$ " + itemTributavel.calcularImposto() );
            }
        }
    }
}
