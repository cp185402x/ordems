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
					+ "(cliente_id, usuario_id, data_previsao, data_pronto, data_entrega, tipo, modelo, marca, cor, serie, garantia, info_cliente, info_tecnico, info_entrega, info_interna, status_id) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do usuário		
		st.setInt(2, Os.getCliente_id());
		st.setInt(3, Os.getUsuario_id());
		st.setString(4, Os.getData_previsao());
		st.setString(5, Os.getData_pronto());
		st.setString(6, Os.getData_entrega());
		st.setString(7, Os.getTipo());
		st.setString(8, Os.getModelo());
		st.setString(9, Os.getMarca());
		st.setString(10, Os.getCor());
		st.setString(11, Os.getSerie());
		st.setInt(12, Os.getGarantia());
		st.setString(13, Os.getInfo_cliente());
		st.setString(14, Os.getInfo_tecnico());
		st.setString(15, Os.getInfo_entrega());
		st.setString(16, Os.getInfo_interna());
		st.setString(17, Os.getStatus_id());
		st.execute();
		
		conn.close();
	//----------------	
		
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
	
	
 
	// public Os getOsById(int id_Os) {
	//    Connection conn = null;
	//    PreparedStatement pstm = null;
	//    ResultSet rs = null;
	//   Os Os = new Os();
	//   try {
	//      conn = Conexao.getConexao();
	//     pstm = conn.prepareStatement(LISTBYID);
	////     pstm.setInt(1, id_Os);
	//   //   rs = pstm.executeQuery();
	////   while (rs.next()) {
	//      Os.setId(rs.getInt("id_Os"));
	//       //       Os.setNome(rs.getString("nm_Os"));
	//     Os.setCelular(rs.getString("celular"));
	//     Os.setEmail(rs.getString("email"));
	// }
	//    Conexao.fechaConexao(conn, pstm, rs);
	// } catch (Exception e) {
	//    JOptionPane.showMessageDialog(null, "Erro ao listar Os" + e.getMessage());
	// }
	//return Os;
    }
}
