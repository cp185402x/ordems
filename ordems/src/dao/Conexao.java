package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	public static Connection getConexao() throws SQLException {
		Connection conn = null;
		
		//carregando o driver
		//String driverName = "conn.mysql.jdbc.Driver";
		
		try {
			//Class.forName(driverName);
			
			//Bancod de dados em cloud link8	
			
			String databasehost = "162.241.39.192:3306";
			
			String database = "wwlink_ordems";
			
			String url = "jdbc:mysql://" + databasehost + "/" + database;
			
			String userName = "wwlink_ordems";
			
			String password = "Link8@OR2020";
			
			/* Banco de dados no google cloud plataform
			 * 
			String databasehost = "35.247.221.35:3306";
			
			String database = "ordems_db";
			
			String url = "jdbc:mysql://" + databasehost + "/" + database;
			
			String userName = "ordems";
			
			String password = "100";
			
			 */
			conn = DriverManager.getConnection(url,userName,password);
			
			if(conn != null)
				System.out.println("Conectado.");
			
			else {
				System.out.println("Não conectado.");
			}
			return conn;
	
		} 
		catch (SQLException e) {

			//System.out.println("Erro ao conectar-se com o banco de dados.");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha ao conectar-se com o banco de dados, contate o suporte!", "Error!", JOptionPane.ERROR_MESSAGE);
			
			return null;
		}
		
		
	}

	public static void fechaConexao(com.mysql.jdbc.Connection conn) {
		
	}
	
	
}

