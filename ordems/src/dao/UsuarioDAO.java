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
					+ "(nm_cliente, tipo_cliente, doc_num, rg_ie, celular, fone_re, email, pes_contato, cep, endereco, numero, complemento, bairro, cidade, estado) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do usuário		
		st.setString(2, cliente.getNome());
		st.setInt(3, cliente.getTipo());
		st.setString(4, cliente.getDocumento());
		st.setString(5, cliente.getRgie());
		st.setString(6, cliente.getTelefonecel());
		st.setString(7, cliente.getTelefoneres());
		st.setString(8, cliente.getEmail());
		st.setString(9, cliente.getPessoa());
		st.setString(10, cliente.getEndereco().getCep());
		st.setString(11, cliente.getEndereco().getLogradouro());
		st.setString(12, cliente.getEndereco().getNumero());
		st.setString(13, cliente.getEndereco().getComplemento());
		st.setString(14, cliente.getEndereco().getBairro());
		st.setString(15, cliente.getEndereco().getCidade());
		st.setString(16, cliente.getEndereco().getEstado());
		
		st.execute();
		
		conn.close();
		
		
	}
	
	


}