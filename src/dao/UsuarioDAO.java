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
					+ "(nm_usuario, cargo, departamento, matricula,login, senha, status, perfil_id, cep, endereco, numero, complemento, bairro, cidade, estado) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do usuário		
		st.setString(2, usuario.getNome());
		st.setInt(3, usuario.getTipo());
		st.setString(4, usuario.getDocumento());
		st.setString(5, usuario.getRgie());
		st.setString(6, usuario.getTelefonecel());
		st.setString(7, usuario.getTelefoneres());
		st.setString(8, usuario.getEmail());
		st.setString(9, usuario.getPessoa());
		st.setString(10, usuario.getEndereco().getCep());
		st.setString(11, usuario.getEndereco().getLogradouro());
		st.setString(12, usuario.getEndereco().getNumero());
		st.setString(13, usuario.getEndereco().getComplemento());
		st.setString(14, usuario.getEndereco().getBairro());
		st.setString(15, usuario.getEndereco().getCidade());
		st.setString(16, usuario.getEndereco().getEstado());
		
		st.execute();
		
		conn.close();
		
		
	}
	
	


}