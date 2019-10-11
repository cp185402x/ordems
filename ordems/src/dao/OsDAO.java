package dao;

import java.awt.List;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.OsController;
import model.Os;
import dao.Conexao;

public class OsDAO {
	//metodo inserir
	//metodo consultar
	//deletar 
	//atualizar
	//metodos sempre recebem objeto
	Connection conn = null;
	PreparedStatement st = null;
	
	
	public void inserir(Os Os) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO Os"
					+ "(usuario_id, nm_Os, tipo_Os, doc_num, rg_ie, celular, fone_re, email, pes_contato, cep, endereco, numero, complemento, bairro, cidade, estado) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do usuário		
		st.setString(2, Os.getNome());
		st.setInt(3, Os.getTipo());
		st.setString(4, Os.getDocumento());
		st.setString(5, Os.getRgie());
		st.setString(6, Os.getTelefonecel());
		st.setString(7, Os.getTelefoneres());
		st.setString(8, Os.getEmail());
		st.setString(9, Os.getPessoa());
		st.setString(10, Os.getEndereco().getCep());
		st.setString(11, Os.getEndereco().getLogradouro());
		st.setString(12, Os.getEndereco().getNumero());
		st.setString(13, Os.getEndereco().getComplemento());
		st.setString(14, Os.getEndereco().getBairro());
		st.setString(15, Os.getEndereco().getCidade());
		st.setString(16, Os.getEndereco().getEstado());
		
		st.execute();
		
		conn.close();
	//----------------	
		
	}
	
	//metodo consultar
	
	public List<Os> getOs() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Os> Os = new ArrayList<Os>();
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Os Os = new Os();
 
                Os.setId(rs.getInt("id_Os"));
                Os.setNome(rs.getString("nm_Os"));
                Os.setCelular(rs.getString("celular"));
                Os.setEmail(rs.getString("email"));
                Os.add(Os);
            }
            Conexao.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Os" + e.getMessage());
        }
        return Os;
    }
	
	
 
    public Os getOsById(int id_Os) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Os Os = new Os();
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id_Os);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Os.setId(rs.getInt("id_Os"));
                Os.setNome(rs.getString("nm_Os"));
                Os.setCelular(rs.getString("celular"));
                Os.setEmail(rs.getString("email"));
            }
            Conexao.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Os" + e.getMessage());
        }
        return Os;
    }
}
