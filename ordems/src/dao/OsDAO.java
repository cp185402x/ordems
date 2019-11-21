package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
					+ "(usuario_id, cliente_id, data_previsao, data_pronto, data_entrega, tipo, modelo, marca, cor, serie, garantia, info_cliente, info_tecnico, info_entrega, info_interna, status_id) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1007); //mudar aqui para associar o id do usuário		
		st.setInt(2, 1);
		st.setString(3, os.getData_previsao());
		st.setString(4, os.getData_pronto());
		st.setString(5, os.getData_entrega());
		st.setString(6, os.getTipo());
		st.setString(7, os.getModelo());
		st.setString(8, os.getMarca());
		st.setString(9, os.getCor());
		st.setString(10, os.getSerie());
		st.setInt(11, os.getGarantia());
		st.setString(12, os.getInfo_cliente());
		st.setString(13, os.getInfo_tecnico());
		st.setString(14, os.getInfo_entrega());
		st.setString(15, os.getInfo_interna());
		st.setString(16, os.getStatus_id());
		
		st.execute();
		
		conn.close();
	//----------------	
		
	}
	
	//Consulta OS
		public ArrayList<Os> consultar() throws SQLException {
			
			conn = (Connection) Conexao.getConexao();
			
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"SELECT * FROM os ORDER BY id_os DESC LIMIT 5");
			}
			

			ArrayList<Os> lista = new ArrayList<Os>();
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
	            Os os = new Os();

	           os.setId_os(rs.getInt("id_os"));
	           os.setData_os(rs.getString("data_os"));
	           os.setCliente_id(rs.getInt("cliente_id"));
	           os.setMarca(rs.getString("marca"));
	           os.setModelo(rs.getString("modelo"));
	           lista.add(os);

	           
	        }
			
			conn.close();
			
			return lista;
			
		}
		
	//Deletar registro
        public void delete(Os os) {
            try {
                st = (PreparedStatement) conn.prepareStatement(
                		"DELETE FROM os WHERE id_os=?");
                st.setLong(1, os.getId_os());
                st.execute();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

}