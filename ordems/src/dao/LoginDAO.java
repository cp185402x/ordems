package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import model.Usuario;
import dao.Conexao;


public class LoginDAO {
	

public Usuario checarUsuario(Usuario u){
	
	Usuario usuario = null;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
	
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			pst = (PreparedStatement) conn.prepareStatement(
					"SELECT * FROM usuario WHERE login = ? AND senha = ?");
		
		pst.setString(1, u.getLogin());
		pst.setString(2, u.getSenha());
		
		rs = pst.executeQuery();
		
		while (rs.next()) {
			usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			
		}
		
		
		
	} catch (Exception e) {
	System.out.println("Error en obtener usuario");
	}
	
	
	return usuario;
	
}
	

}
