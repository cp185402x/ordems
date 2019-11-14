package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Os;
import dao.Conexao;

public class OsDAO {
	//Metodo inserir
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
