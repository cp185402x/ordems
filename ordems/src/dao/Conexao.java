package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConexao() throws SQLException {
		Connection conn = null;
		
		//carregando o driver
		String driverName = "conn.mysql.jdbc.Driver";
		try {
			//Class.forName(driverName);
			
			String serverName = "localhost";
			
			String mydatabase = "ordems_db";
			
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			
			String userName = "root";
			
			String password = "";
			
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
	
	
}

