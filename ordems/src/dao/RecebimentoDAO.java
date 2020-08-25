package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Recebimento;
import model.Os;
import dao.Conexao;

public class RecebimentoDAO {
	
	Connection conn = null;
	PreparedStatement st = null;
	
	//.
	public void inserir(Recebimento recebimento) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO recebimento"
					+ "(usuario_id, cliente_id, data_previsao, status_id) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1,recebimento.getUsuario().getId());
		st.setInt(2, recebimento.getCliente().getId());
		st.setString(16, recebimento.getStatusRecebimento());
		System.out.println(recebimento);
		st.execute();
		
		conn.close();
	//----------------	
		
	}
	
		public ArrayList<Os> consultar() throws SQLException {
			
			conn = (Connection) Conexao.getConexao();
			
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"SELECT * FROM recebimento ORDER BY id_os DESC LIMIT 1000");
			}
			

			ArrayList<Os> lista = new ArrayList<Os>();
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
	            Os os = new Os();

	           os.setId(rs.getInt("id_os"));
	           os.setData_os(rs.getString("data_os"));
	           os.getCliente().setId(rs.getInt("cliente_id"));
	          
	           
	           
	           
	           
	           lista.add(os);

	           
	        }
			
			conn.close();
			
			return lista;
			
		}
		
		public void atualizar(Os os) throws SQLException {
			
			conn = (Connection) Conexao.getConexao();
			
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"UPDATE recebimento SET "
						+ " usuario_id = ?,"
						+ " cliente_id = ?,"
						+ " data_os = ?,"
						+ " status_id = ? "
						+ " WHERE id_os = " + os.getId() + ";"
						);
			}
			
			
			st.setInt(1, os.getUsuario_id());
			st.setInt(2, os.getCliente().getId());
			st.setString(3, os.getData_os());
			st.setString(16, os.getStatus_id());
			System.out.println(os);
			
			st.executeUpdate();

			conn.close();
		}
		
	//Deletar registro
		public void excluir (int id) throws SQLException {
			conn = (Connection) Conexao.getConexao();
			System.out.println(id);
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"DELETE FROM recebimento WHERE id_os = " + id + ";");
						
			}
			st.execute();
			conn.close();
			
		}

	
			
		}
        

