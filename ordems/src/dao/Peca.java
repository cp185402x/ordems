package dao;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.PecaController;
import model.Peca;
import dao.Conexao;

public class PecaDAO {
	//metodo inserir
	//metodo consultar
	//deletar 
	//atualizar
	//metodos sempre recebem objeto
	Connection conn = null;
	PreparedStatement st = null;
	
	
	public void inserir(Peca peca) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO peca"
					+ "(nm_Peca, tipo_Peca, doc_num, rg_ie, celular, fone_re, email, pes_contato, cep, endereco, numero, complemento, bairro, cidade, estado) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do usuário		
		st.setString(2, Peca.getNome());
		st.setInt(3, Peca.getTipo());
		st.setString(4, Peca.getDocumento());
		st.setString(5, Peca.getRgie());
		st.setString(6, Peca.getTelefonecel());
		st.setString(7, Peca.getTelefoneres());
		st.setString(8, Peca.getEmail());
		st.setString(9, Peca.getPessoa());
		st.setString(10, Peca.getEndereco().getCep());
		st.setString(11, Peca.getEndereco().getLogradouro());
		st.setString(12, Peca.getEndereco().getNumero());
		st.setString(13, Peca.getEndereco().getComplemento());
		st.setString(14, Peca.getEndereco().getBairro());
		st.setString(15, Peca.getEndereco().getCidade());
		st.setString(16, Peca.getEndereco().getEstado());
		
		st.execute();
		
		conn.close();
		
		
	}
	
	


}