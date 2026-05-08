public class Receita extends Transacao implements Tributavel{

    public Receita(String descricao, double valor, String data) throws ValorInvalidoException,IllegalArgumentException{
        super(descricao, valor, data);
    }

    @Override
    public double calcularImposto() {
        return getValor() * 0.1;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(" \n Informações da Receita " +
                "\n Descrição: " + getDescricao() +
                "\n valor: " + getValor() +
                "\n data: " + getData() +
                "\n total de Imposto: " + calcularImposto());
    }
}
