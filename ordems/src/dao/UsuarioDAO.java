package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


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
		//st.setInt(1, 1006);
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
	
			public ArrayList<Usuario> consultar() throws SQLException {
				
				conn = (Connection) Conexao.getConexao();
				
				if(conn != null) {
					st = (PreparedStatement) conn.prepareStatement(
							"SELECT * FROM usuario order by id_usuario desc limit 25");
				}
				

				ArrayList<Usuario> lista = new ArrayList<Usuario>();
				ResultSet rs = st.executeQuery();
				
				while (rs.next()) {
		            Usuario usuario = new Usuario();

		           usuario.setNm_usuario(rs.getString("nm_usuario"));
		           usuario.setMatricula(rs.getString("matricula"));
		           usuario.setCargo(rs.getString("cargo"));
		           usuario.setDepartamento(rs.getString("departamento"));
		           usuario.setStatus(rs.getInt("status"));
		          
		           lista.add(usuario);

		           
		        }
				
				conn.close();
				
				return lista;
				
			}

	}
		    


