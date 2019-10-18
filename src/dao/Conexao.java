package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Conexao {
	
	public static Connection getConexao() throws SQLException {
		Connection conn = null;
		
		//carregando o driver
		String driverName = "conn.mysql.jdbc.Driver";
		try {
			//Class.forName(driverName);
			
			/*String serverName = "localhost:3307";*/
			
			String serverName = "35.247.221.35:3306";
			
			String mydatabase = "ordems_db";
			
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			
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

			System.out.println("Problema ao conectar com o banco de dados.");
			
			return null;
		}
		
		
	}

	public static void fechaConexao(com.mysql.jdbc.Connection conn) {
		// TODO Auto-generated method stub
		
	}
	
	
}

