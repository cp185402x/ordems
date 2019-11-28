package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Peca;
import dao.Conexao;

public class PecaDAO {
	//Metodo inserir
	//metodo consultar
	//deletar 
	//atualizar
	//metodos sempre recebem objeto
	Connection conn = null;
	PreparedStatement st = null;
	
	//Teste
	public void inserir(Peca peca) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO peca"
					+ "( nm_peca, vl_custo, vl_venda) "
					+ "VALUES "
					+ "(?, ?, ?)");
		}
		st.setString(1, peca.getNm_peca());
		st.setString(2, peca.getVl_custo());
		st.setString(3, peca.getVl_venda());
		
		st.execute();
		
		conn.close();
		
		
		
	}
	
	public void atualizar(Peca peca) throws SQLException {
		
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"UPDATE peca SET "
					+ " nm_peca = ?,"
					+ " vl_custo = ?,"
					+ " vl_venda = ?,"					
					+ " WHERE id_peca = " + peca.getId() + ";"
					);
		}
			
		st.setString(1, peca.getNm_peca());
		st.setString(2, peca.getVl_custo());
		st.setString(3, peca.getVl_venda());
		
		System.out.println(peca);
		
		st.executeUpdate();

		conn.close();
	}
	//Consulta Peca
	
			public ArrayList<Peca> consultar() throws SQLException {
				
				conn = (Connection) Conexao.getConexao();
				
				if(conn != null) {
					st = (PreparedStatement) conn.prepareStatement(
							"SELECT * FROM peca order by id_peca desc limit 25");
				}
				

				ArrayList<Peca> lista = new ArrayList<Peca>();
				ResultSet rs = st.executeQuery();
				
				while (rs.next()) {
					Peca peca = new Peca();

					peca.setId(rs.getInt("id_peca"));
		           peca.setNm_peca(rs.getString("nm_peca"));
		           peca.setVl_custo(rs.getString("vl_custo"));
		           peca.setVl_venda(rs.getString("vl_venda"));
		           lista.add(peca);

		           
		        }
				
				conn.close();
				
				return lista;
				
			}

			public void excluir (int id) throws SQLException {
				conn = (Connection) Conexao.getConexao();
				
				if(conn != null) {
					st = (PreparedStatement) conn.prepareStatement(
							"DELETE FROM peca WHERE id_peca = " + id + ";");
							
				}
				st.execute();
				conn.close();
				
			}
	}
		    

		 
		



	


