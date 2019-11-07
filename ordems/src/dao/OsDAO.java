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
		
	}

		//Consulta OS
		
			public ArrayList<Os> consultar() throws SQLException {
				
				conn = (Connection) Conexao.getConexao();
				
				if(conn != null) {
					st = (PreparedStatement) conn.prepareStatement(
							"SELECT * FROM os order by id_os desc limit 10");
				}
				

				ArrayList<Os> lista = new ArrayList<Os>();
				ResultSet rs = st.executeQuery();
				
				while (rs.next()) {
		            Os os = new Os();
		            
		    		os.setCliente_id(rs.getInt("cliente_id"));
		    		os.setUsuario_id(rs.getInt("usuario_id"));
		    		os.setData_previsao(rs.getString("data_previsao"));
		    		os.setData_pronto(rs.getString("data_pronto"));
		    		os.setData_entrega(rs.getString("data_entrega"));
		    		os.setTipo(rs.getString("tipo"));
		    		os.setModelo(rs.getString("modelo"));
		    		os.setMarca(rs.getString("marca"));
		    		os.setCor(rs.getString("cor"));
		    		os.setSerie(rs.getString("serie"));
		    		os.setGarantia(rs.getInt("garantia"));
		    		os.setInfo_cliente(rs.getString("info_cliente"));
		    		os.setInfo_tecnico(rs.getString("info_tecnico"));
		    		os.setInfo_entrega(rs.getString("info_entrega"));
		    		os.setInfo_interna(rs.getString("info_interna"));
		    		os.setStatus_id(rs.getString("status_id"));
		    		
		           lista.add(os);

		           
		        }
				
				//System.out.println("Resultado da consulta" + rs);
				
				conn.close();
				
				return lista;
				
				
			//----------------	
				
			}
			
}

