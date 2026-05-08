import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO{

    public void salvar(Transacao t)throws SQLException{
        String tipo;
        if(t instanceof Receita){
            tipo = "Receita";
        }else{
            tipo = "Despesa";
        }
        String Insert = "INSERT INTO transacoes (descricao, valor, data, tipo) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoFactory.conectar(); PreparedStatement stmt = conn.prepareStatement(Insert)){
        stmt.setString(1, t.getDescricao());
        stmt.setDouble(2, t.getValor());
        stmt.setString(3, t.getData());
        stmt.setString(4, tipo);

        stmt.executeUpdate();

        }catch (SQLException e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }

    public List<Transacao> listar(){
        List<Transacao> lista = new ArrayList<>();
        String Select = "SELECT * FROM transacoes;";

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(Select);
             ResultSet resul = stmt.executeQuery()){
            while (resul.next()){
                String dsc = resul.getString("descricao");
                Double valor = resul.getDouble("valor");
                String data = resul.getString("data");
                String tipo = resul.getString("tipo");

                if("Despesa".equalsIgnoreCase(tipo)){
                    try {
                        Despesa d1 = new Despesa(dsc, valor,data);
                        lista.add(d1);
                    }catch(ValorInvalidoException | IllegalArgumentException e){
                        System.out.println(" \n Erro ao criar transação:" + e.getMessage());
                    }
                }else{
                    try {
                        Receita r1 = new Receita(dsc, valor,data);
                        lista.add(r1);
                    }catch(ValorInvalidoException | IllegalArgumentException e){
                        System.out.println(" \n Erro ao criar transação:" + e.getMessage());
                    }
                }
            }

        }catch (SQLException e) {
            System.err.println("Erro ao ler o banco: " + e.getMessage());
        }
        return lista;
    }
}




