package dao;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.ClienteController;
import model.Cliente;
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
					+ "(nm_usuario,cargo, departamento, matricula, login, senha) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do usuário		
		st.setString(2, cliente.getUsuario());
		st.setInt(3, cliente.getCargo());
		st.setString(4, cliente.getDepartamento());
		st.setString(5, cliente.getMatricula());
		st.setString(6, cliente.getLogin());
		st.setString(7, cliente.getSenha());
		st.setString(8, cliente.getEmail());
		
		
		st.execute();
		
		conn.close();
		
		
	}
	
	


}