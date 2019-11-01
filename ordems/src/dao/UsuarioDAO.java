package dao;


import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.UsuarioController;
import model.Usuario;
import dao.Conexao;

public class UsuarioDAO {
	//metodo inserir
	//metodo consultar
	//deletar 
	//atualizar
	//metodos sempre recebem objeto
	Connection conn = null;
	PreparedStatement st = null;
	
	
	public void inserir(Usuario usuario) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO usuario"
					+ "(nm_usuario,cargo, departamento, matricula, login, senha, status) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setString(1, usuario.getNm_usuario());
		st.setString(2, usuario.getCargo());
		st.setString(3, usuario.getDepartamento());
		st.setString(4, usuario.getMatricula());
		st.setString(5, usuario.getLogin());
		st.setString(6, usuario.getSenha());
		st.setString(7, usuario.getStatus());
		
		st.execute();
		
		conn.close();
		
		
	}
	
	


}