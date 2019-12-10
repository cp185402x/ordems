package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Cliente;
import model.Usuario;
import dao.Conexao;

public class UsuarioDAO {
	//Metodo inserir
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
					+ "(nm_usuario, cargo, departamento, matricula, login, senha, status) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)");
		}
		st.setString(1, usuario.getNm_usuario());
		st.setString(2, usuario.getCargo());
		st.setString(3, usuario.getDepartamento());
		st.setString(4, usuario.getMatricula());
		st.setString(5, usuario.getLogin());
		st.setString(6, usuario.getSenha());
		st.setInt(7, usuario.getStatus());
		
		st.execute();
		
		conn.close();
		
		
	}
	
	//Consulta Usuario
	
public void atualizar(Usuario usuario) throws SQLException {
		
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"UPDATE usuario SET "
					+ " nm_usuario = ?,"
					+ " cargo = ?,"
					+ " departamento = ?,"
					+ " matricula = ?,"
					+ " login = ?,"
					+ " senha = ?,"
					+ " status = ?"
					+ " WHERE id_usuario = " + usuario.getId() + ";"
					);
		}
		
		
		st.setString(1, usuario.getNm_usuario());
		st.setString(2, usuario.getCargo());
		st.setString(3, usuario.getDepartamento());
		st.setString(4, usuario.getMatricula());
		st.setString(5, usuario.getLogin());
		st.setString(6, usuario.getSenha());
		st.setInt(7, usuario.getStatus());
		
		System.out.println(usuario);
		
		st.executeUpdate();

		conn.close();
	}
	
	//Consulta Cliente
	
		public ArrayList<Usuario> consultar() throws SQLException {
			
			conn = (Connection) Conexao.getConexao();
			
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"SELECT * FROM usuario order by id_usuario desc limit 1000");
			}
			

			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();

				usuario.setId(rs.getInt("id_usuario"));
				usuario.setNm_usuario(rs.getString("nm_usuario"));
				usuario.setCargo(rs.getString("cargo"));
				usuario.setDepartamento(rs.getString("departamento"));
				usuario.setMatricula(rs.getString("matricula"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setStatus(rs.getString("status"));
				
	           lista.add(usuario);

	           
	        }
			
			conn.close();
			
			return lista;
			
		}
		
		
		public void excluir (int id) throws SQLException {
			conn = (Connection) Conexao.getConexao();
			
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"DELETE FROM usuario WHERE id_usuario = " + id + ";");
						
			}
			st.execute();
			conn.close();
			
		}
		

}
	    

	 
	



	
		    


