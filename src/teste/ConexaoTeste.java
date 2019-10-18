package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dao.ClienteDAO;
import dao.Conexao;
import model.Cliente;

public class ConexaoTeste {

	public static void main(String[] args) {

		try {
			Connection conn = Conexao.getConexao();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
