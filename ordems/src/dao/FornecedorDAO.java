 package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Cliente;
import model.Fornecedor;
import dao.Conexao;

public class FornecedorDAO {
	//metodo inserir
	//metodo consultar
	//deletar 
	//atualizar
	//metodos sempre recebem objeto
	Connection conn = null;
	PreparedStatement st = null;
	private Fornecedor fornecedor;
	
	
	public void inserir(Fornecedor fornecedor) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO fornecedor"
					+ "(id_fornecedor, nm_fornecedor, tipo_fornecedor, doc_num, rg_ie, celular, fone_re, email, pes_contato, cep, endereco, numero, complemento, bairro, cidade, estado) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do us		
		st.setString(2, fornecedor.getNm_fornecedor());
		st.setInt(3, fornecedor.getTipo_fornecedor());
		st.setString(4, fornecedor.getDoc_num());
		st.setString(5, fornecedor.getRg_ie());
		st.setString(6, fornecedor.getCelular());
		st.setString(7, fornecedor.getFone_re());
		st.setString(8, fornecedor.getEmail());
		st.setString(9, fornecedor.getPes_contato());
		st.setString(10, fornecedor.getEndereco().getCep());
		st.setString(11, fornecedor.getEndereco().getLogradouro());
		st.setString(12, fornecedor.getEndereco().getNumero());
		st.setString(13, fornecedor.getEndereco().getComplemento());
		st.setString(14, fornecedor.getEndereco().getBairro());
		st.setString(15, fornecedor.getEndereco().getCidade());
		st.setString(16, fornecedor.getEndereco().getEstado());
		
		st.execute();
		
		conn.close();
	}
	
	
	//----------------
	//Consulta Fornecedor
	
	public ArrayList<Fornecedor> consultar() throws SQLException {
		
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"SELECT * FROM cliente order by id_cliente desc limit 25");
		}
		

		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
            Cliente cliente = new Cliente();

           cliente.setId(rs.getInt("id_cliente"));
           cliente.setNm_cliente(rs.getString("nm_cliente"));
           cliente.setEmail(rs.getString("email"));
           cliente.setCelular(rs.getString("celular"));
           cliente.setFone_re(rs.getString("fone_re"));
           cliente.setDoc_num(rs.getString("doc_num"));
           cliente.setRg_ie(rs.getString("rg_ie"));
           cliente.setPes_contato(rs.getString("pes_contato"));
           cliente.setTipo_cliente(rs.getInt("tipo_cliente"));
         
           cliente.getEndereco().setCep(rs.getString("cep"));
           cliente.getEndereco().setLogradouro(rs.getString("endereco"));
           cliente.getEndereco().setBairro(rs.getString("Bairro"));
           cliente.getEndereco().setCidade(rs.getString("Cidade"));
           cliente.getEndereco().setEstado(rs.getString("Estado"));
           cliente.getEndereco().setNumero(rs.getString("Numero"));
           lista.add(fornecedor);

           
        }
		conn.close();
		
		return lista;
		}
		
		
		
		
	    }
	    

	 
	


