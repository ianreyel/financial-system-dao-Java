public class Despesa extends Transacao{
    public Despesa(String descricao, double valor, String data) throws ValorInvalidoException,IllegalArgumentException{
        super(descricao, valor, data);
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("\n Informações da Despesa " +
                "\n Descrição: " + getDescricao() +
                "\n valor: -" + getValor() +
                "\n data: " + getData() );
    }
}
