 package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import model.Fornecedor;
import dao.Conexao;

public class FornecedorDAO {
	//Metodo inserir
	//metodo consultar
	//deletar 
	//atualizar
	//metodos sempre recebem objeto
	Connection conn = null;
	PreparedStatement st = null;
	
	
	
	public void inserir(Fornecedor fornecedor) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO fornecedor"
					+ "(usuario_id, nm_fornecedor, tipo_fornecedor, doc_num, rg_ie, celular, fone_re, email, pes_contato, cep, endereco, numero, complemento, bairro, cidade, estado) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1019); //mudar aqui para associar o id do us		
		st.setString(2, fornecedor.getNm_fornecedor());
		st.setInt(3, fornecedor.getTipo());
		st.setString(4, fornecedor.getDoc_num());
		st.setString(5, fornecedor.getRg_ie());
		st.setString(6, fornecedor.getCelular());
		st.setString(7, fornecedor.getFone_re());
		st.setString(8, fornecedor.getEmail());
		st.setString(9, fornecedor.getPes_contato());
		st.setString(10, fornecedor.getAPIConsultaCEP().getCep());
		st.setString(11, fornecedor.getAPIConsultaCEP().getLogradouro());
		st.setString(11, fornecedor.getNumero());
		st.setString(13, fornecedor.getComplemento());
		st.setString(14, fornecedor.getAPIConsultaCEP().getBairro());
		st.setString(15, fornecedor.getAPIConsultaCEP().getCidade());
		st.setString(16, fornecedor.getAPIConsultaCEP().getUf());
		
		st.execute();
		
		conn.close();
	}
public void atualizar(Fornecedor fornecedor) throws SQLException {
		
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"UPDATE fornecedor SET "
					+ " usuario_id = ?,"
					+ " nm_fornecedor = ?,"
					+ " tipo_fornecedor = ?,"
					+ " doc_num = ?,"
					+ " rg_ie = ?,"
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
					+ " estado = ? "
					+ " WHERE id_fornecedor = " + fornecedor.getId() + ";"
					);
		}
		
		st.setInt(1, 1019); //mudar aqui para associar o id do us		
		st.setString(2, fornecedor.getNm_fornecedor());
		st.setInt(3, fornecedor.getTipo());
		st.setString(4, fornecedor.getDoc_num());
		st.setString(5, fornecedor.getRg_ie());
		st.setString(6, fornecedor.getCelular());
		st.setString(7, fornecedor.getFone_re());
		st.setString(8, fornecedor.getEmail());
		st.setString(9, fornecedor.getPes_contato());
		st.setString(10, fornecedor.getAPIConsultaCEP().getCep());
		st.setString(11, fornecedor.getAPIConsultaCEP().getLogradouro());
		st.setString(11, fornecedor.getNumero());
		st.setString(13, fornecedor.getAPIConsultaCEP().getCep());
		st.setString(14, fornecedor.getAPIConsultaCEP().getBairro());
		st.setString(15, fornecedor.getAPIConsultaCEP().getCidade());
		st.setString(16, fornecedor.getAPIConsultaCEP().getUf());
		
		System.out.println(fornecedor);
		
		st.executeUpdate();

		conn.close();
	}
	
	//----------------
	//Consulta Fornecedor
	
	public ArrayList<Fornecedor> consultar() throws SQLException {
		
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"SELECT * FROM fornecedor order by id_fornecedor desc limit 25");
		}
		

		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor();

           fornecedor.setId(rs.getInt("id_fornecedor"));
           fornecedor.setNm_fornecedor(rs.getString("nm_fornecedor"));
           fornecedor.setEmail(rs.getString("email"));
           fornecedor.setCelular(rs.getString("celular"));
           fornecedor.setFone_re(rs.getString("fone_re"));
           fornecedor.setDoc_num(rs.getString("doc_num"));
           fornecedor.setRg_ie(rs.getString("rg_ie"));
           fornecedor.setPes_contato(rs.getString("pes_contato"));
           fornecedor.setTipo_fornecedor(rs.getInt("tipo_fornecedor"));
         
           fornecedor.getEndereco().setTCEP(rs.getString("cep"));
           fornecedor.getEndereco().setTRUA(rs.getString("endereco"));
           fornecedor.getEndereco().setTBAIRRO(rs.getString("Bairro"));
           fornecedor.getEndereco().setTCIDADE(rs.getString("Cidade"));
           fornecedor.getEndereco().setCESTADO(rs.getString("Estado"));
           fornecedor.getEndereco().setNumero(rs.getString("Numero"));
           lista.add(fornecedor);

           
        }
		conn.close();
		
		return lista;
		
		}
	
	public void excluir (int id) throws SQLException {
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"DELETE FROM fornecedor WHERE id_fornecedor = " + id + ";");
					
		}
		st.execute();
		conn.close();
		
		
		
		
		
	    }
}

	 
	


