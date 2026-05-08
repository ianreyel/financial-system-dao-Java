import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory{
    private static final String Userdb = "USUARIO_DO_BANCO";
    private static final String Senhadb = "SENHA_DO_BANCO";
    private static final String URLdb = "jdbc:mariadb://localhost:3306/SEU_BANCO";


    public static Connection conectar(){
        try {
        return DriverManager.getConnection(URLdb, Userdb, Senhadb);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no banco: " + e.getMessage());
        }
    }
}
