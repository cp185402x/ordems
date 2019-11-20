package teste;
//Teste de conexão com o banco
import java.sql.Connection;
import java.sql.SQLException;
import dao.Conexao;

public class ConexaoTeste {

	public static void main(String[] args) {

		try {
			Connection conn = Conexao.getConexao();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
