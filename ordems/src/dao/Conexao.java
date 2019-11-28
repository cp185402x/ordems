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
			
			/*String databasehost = "localhost:3307";*/
			
			String databasehost = "35.247.221.35:3306";
			
			String database = "ordems_db";
			
			String url = "jdbc:mysql://" + databasehost + "/" + database;
			
			String userName = "ordems";
			
			String password = "100";
			
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
			JOptionPane.showMessageDialog(null, "Erro ao conectar-se com o banco de dados, contate o suporte!");
			
			return null;
		}
		
		
	}

	public static void fechaConexao(com.mysql.jdbc.Connection conn) {
		
	}
	
	
}

