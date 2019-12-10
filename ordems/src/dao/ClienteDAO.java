package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Cliente;
import dao.Conexao;

public class ClienteDAO {

	Connection conn = null;
	PreparedStatement st = null;
	
	
	public void inserir(Cliente cliente) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO cliente"
					+ "(usuario_id, nm_cliente, data_nasc, tipo_cliente, doc_num, celular, fone_re, email, pes_contato, cep, endereco, numero, complemento, bairro, cidade, estado, rg_ie) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do us		
		st.setString(2, cliente.getNm_cliente());
		st.setString(3, cliente.getData_nasc());
		st.setInt(4, cliente.getTipo());
		st.setString(5, cliente.getDoc_num());
		st.setString(6, cliente.getCelular());
		st.setString(7, cliente.getFone_re());
		st.setString(8, cliente.getEmail());
		st.setString(9, cliente.getPes_contato());
		st.setString(10, cliente.getEndereco().getCep());
		st.setString(11, cliente.getEndereco().getLogradouro());
		st.setString(12, cliente.getEndereco().getNumero());
		st.setString(13, cliente.getEndereco().getComplemento());
		st.setString(14, cliente.getEndereco().getBairro());
		st.setString(15, cliente.getEndereco().getCidade());
		st.setString(16, cliente.getEndereco().getEstado());
		st.setString(17, cliente.getRg_ie());
		
		st.execute();
		
		conn.close();
	}
	 
	public void atualizar(Cliente cliente) throws SQLException {
		
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"UPDATE cliente SET "
					+ " usuario_id = ?,"
					+ " nm_cliente = ?,"
					+ " data_nasc = ?,"
					+ " tipo_cliente = ?,"
					+ " doc_num = ?,"
					+ " celular = ?,"
					+ " fone_re = ?,"
					+ " email = ?,"
					+ " pes_contato = ?,"
					+ " cep = ?,"
					+ " endereco = ?,"
					+ " numero = ?,"
					+ " complemento = ?,"
					+ " bairro = ?,"
					+ " cidade = ?,"
					+ " estado = ?,"
					+ " rg_ie = ?"
					+ " WHERE id_cliente = " + cliente.getId() + ";"
					);
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do us		
		st.setString(2, cliente.getNm_cliente());
		st.setString(3, cliente.getData_nasc());
		st.setInt(4, cliente.getTipo());
		st.setString(5, cliente.getDoc_num());
		st.setString(6, cliente.getCelular());
		st.setString(7, cliente.getFone_re());
		st.setString(8, cliente.getEmail());
		st.setString(9, cliente.getPes_contato());
		st.setString(10, cliente.getEndereco().getCep());
		st.setString(11, cliente.getEndereco().getLogradouro());
		st.setString(12, cliente.getEndereco().getNumero());
		st.setString(13, cliente.getEndereco().getComplemento());
		st.setString(14, cliente.getEndereco().getBairro());
		st.setString(15, cliente.getEndereco().getCidade());
		st.setString(16, cliente.getEndereco().getEstado());
		st.setString(17, cliente.getRg_ie());
		
		System.out.println(cliente);
		
		st.executeUpdate();

		conn.close();
	}
	
	//Consulta Cliente
	
		public ArrayList<Cliente> consultar() throws SQLException {
			
			conn = (Connection) Conexao.getConexao();
			
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"SELECT * FROM cliente order by id_cliente desc limit 1000");
			}
			

			ArrayList<Cliente> lista = new ArrayList<Cliente>();
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
	            Cliente cliente = new Cliente();

	           cliente.setId(rs.getInt("id_cliente"));
	           cliente.setNm_cliente(rs.getString("nm_cliente"));
	           cliente.setData_nasc(rs.getString("data_nasc"));
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
	           lista.add(cliente);

	           
	        }
			
			conn.close();
			
			return lista;
			
		}
		
		
		public void excluir (int id) throws SQLException {
			conn = (Connection) Conexao.getConexao();
			
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"DELETE FROM cliente WHERE id_cliente = " + id + ";");
						
			}
			st.execute();
			conn.close();
			
		}
		

}
	    

	 
	


