package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Cliente;
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
	
	//.
	public void inserir(Os os) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO os"
					+ "(usuario_id, cliente_id, data_previsao, data_pronto, data_entrega, tipo, modelo, marca, cor, serie, garantia, info_cliente, info_tecnico, info_entrega, info_interna, status_id) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1,os.getUsuario().getId());
		st.setInt(2, os.getCliente().getId());
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
		System.out.println(os);
		st.execute();
		
		conn.close();
	//----------------	
		
	}
	
	//Consulta OS
		public ArrayList<Os> consultar() throws SQLException {
			
			conn = (Connection) Conexao.getConexao();
			
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"SELECT * FROM os ORDER BY id_os DESC LIMIT 1000");
			}
			

			ArrayList<Os> lista = new ArrayList<Os>();
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
	            Os os = new Os();

	           os.setId(rs.getInt("id_os"));
	           os.setData_os(rs.getString("data_os"));
	           os.getCliente().setId(rs.getInt("cliente_id"));
	           os.setMarca(rs.getString("marca"));
	           os.setModelo(rs.getString("modelo"));
	           os.setCor(rs.getString("cor"));
	           os.setSerie(rs.getString("serie"));
	           os.setGarantia(rs.getInt("garantia"));
	           os.setInfo_cliente(rs.getString("info_cliente"));
	           os.setInfo_tecnico(rs.getString("info_tecnico"));
	           os.setInfo_entrega(rs.getString("info_entrega"));
	           os.setInfo_interna(rs.getString("info_interna"));
	           os.setData_previsao(rs.getString("data_previsao"));
	           os.setData_pronto(rs.getString("data_pronto"));
	           os.setData_entrega(rs.getString("data_entrega"));
	          
	           
	           
	           
	           
	           lista.add(os);

	           
	        }
			
			conn.close();
			
			return lista;
			
		}
		
		public void atualizar(Os os) throws SQLException {
			
			conn = (Connection) Conexao.getConexao();
			
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"UPDATE os SET "
						+ " usuario_id = ?,"
						+ " cliente_id = ?,"
						+ " data_os = ?,"
						+ " data_previsao = ?,"
						+ " data_pronto = ?,"
						+ " data_entrega = ?,"
						+ " tipo = ?,"
						+ " modelo = ?,"
						+ " marca = ?,"
						+ " cor = ?,"
						+ " serie = ?,"
						+ " garantia = ?,"
						+ " info_cliente = ?,"
						+ " info_tecnico = ?,"
						+ " info_entrega = ?,"
						+ " info_interna = ? "
						+ " status_id = ? "
						+ " WHERE id_os = " + os.getId() + ";"
						);
			}
			
			
			st.setInt(1, 1019);
			st.setInt(2, os.getCliente().getId());
			st.setString(3, os.getData_os());
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
						"DELETE FROM os WHERE id_os = " + id + ";");
						
			}
			st.execute();
			conn.close();
			
		}

	
			
		}
        

