package dao;

import java.awt.List;
import java.sql.ResultSet;
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
	
	
	public void inserir(Os os) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO Os"
					+ "(cliente_id, usuario_id, data_previsao, data_pronto, data_entrega, tipo, modelo, marca, cor, serie, garantia, info_cliente, info_tecnico, info_entrega, info_interna, status_id) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1007); //mudar aqui para associar o id do usuário		
		st.setInt(2, os.getCliente_id());
		st.setInt(3, os.getUsuario_id());
		st.setString(4, os.getData_previsao());
		st.setString(5, os.getData_pronto());
		st.setString(6, os.getData_entrega());
		st.setString(7, os.getTipo());
		st.setString(8, os.getModelo());
		st.setString(9, os.getMarca());
		st.setString(10, os.getCor());
		st.setString(11, os.getSerie());
		st.setInt(12, os.getGarantia());
		st.setString(13, os.getInfo_cliente());
		st.setString(14, os.getInfo_tecnico());
		st.setString(15, os.getInfo_entrega());
		st.setString(16, os.getInfo_interna());
		st.setString(17, os.getStatus_id());
		
		st.execute();
		
		conn.close();
	//----------------	
		
	}
	
}
	
	//metodo consultar
	
	//public List<Os> getOs() {
	//   Connection conn = null;
	//  PreparedStatement pstm = null;
	//  ResultSet rs = null;
	// ArrayList<Os> Os = new ArrayList<Os>();
        // try {
	//   conn = Conexao.getConexao();
	// pstm = conn.prepareStatement(LIST);
	//   rs = pstm.executeQuery();
	//      while (rs.next()) {
	//          Os Os = new Os();
	//
	//          Os.setId(rs.getInt("id_Os"));
	//          Os.setNome(rs.getString("nm_Os"));
	//          Os.setCelular(rs.getString("celular"));
	//          Os.setEmail(rs.getString("email"));
	//          Os.add(Os);
	//      }
	//      Conexao.fechaConexao(conn, pstm, rs);
	//  } catch (Exception e) {
	//     JOptionPane.showMessageDialog(null, "Erro ao listar Os" + e.getMessage());
	//  }
	//  return Os;
	//  }
	
	
 
//	 public Os getOsById(int id_Os) {
//	    Connection conn = null;
//	    PreparedStatement pstm = null;
//	    ResultSet rs = null;
//	   Os Os = new Os();
//	   try {
//	      conn = (Connection) Conexao.getConexao();
//	    pstm = conn.prepareStatement(LISTBYID);
//	     pstm.setInt(1, id_Os);
//	   rs = pstm.executeQuery();
//	   while (rs.next()) {
//	      Os.setId(rs.getInt("id_Os"));
//	            Os.setNome(rs.getString("nm_Os"));
//	     Os.setCelular(rs.getString("celular"));
//	     Os.setEmail(rs.getString("email"));
//	 }
//	    Conexao.fechaConexao(conn, pstm, rs);
//	 } catch (Exception e) {
//    JOptionPane.showMessageDialog(null, "Erro ao listar Os" + e.getMessage());
// }
//	return Os;
  //  }

