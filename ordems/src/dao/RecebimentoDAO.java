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
					+ "(usuario_id, cliente_id, os_id, peca_id, formaPagamento, valorRecebimento, statusRecebimento) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1,recebimento.getUsuario().getId());
		st.setInt(1,recebimento.getCliente().getId());
		st.setInt(3, recebimento.getOs().getId());
		st.setInt(4,recebimento.getPeca().getId());
		st.setString(5,recebimento.getformaPagamento());
		st.setFloat(6,recebimento.getValorRecebimento());
		st.setInt(7,recebimento.getStatusRecebimento());
		System.out.println(recebimento);
		st.execute();
		
		conn.close();
	//----------------	
		
	}
	
		public ArrayList<Recebimento> consultar() throws SQLException {
			
			conn = (Connection) Conexao.getConexao();
			
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"SELECT * FROM recebimento ORDER BY id_os DESC LIMIT 1000");
			}
			

			ArrayList<Recebimento> lista = new ArrayList<Recebimento>();
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
	            Recebimento recebimento = new Recebimento();

	            recebimento.setId(rs.getInt("id_recibemento"));
	            recebimento.getUsuario().setId(rs.getInt("usuario_id"));
	            recebimento.getCliente().setId(rs.getInt("cliente_id"));
	            recebimento.getOs().setId(rs.getInt("os_id"));
	            recebimento.getPeca().setId(rs.getInt("peca_id"));
	            recebimento.setformaPagamento(rs.getString("formaPagamento"));
	            recebimento.setValorRecebimento(rs.getFloat("valorRecebimento"));
	            recebimento.setStatusRecebimento(rs.getInt("statusRecebimeto"));
	           
	           
	           
	           lista.add(recebimento);

	           
	        }
			
			conn.close();
			
			return lista;
			
		}
		
		private void .setId(int int1) {
			// TODO Auto-generated method stub
			
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
        

