package dao;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.PecaController;
import model.Peca;
import dao.Conexao;

public class PecaDAO {
	//metodo inserir
	//metodo consultar
	//deletar 
	//atualizar
	//metodos sempre recebem objeto
	Connection conn = null;
	PreparedStatement st = null;
	
	
	public void inserir(Peca peca) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO peca"
					+ "(nm_peca, vl_custo, vl_venda) "
					+ "VALUES "
					+ "(?, ?, ?)");
		}
		
		st.setString(1, Peca.getNm_peca());
		st.setString(2, Peca.getVl_custo());
		st.setString(3, Peca.getVl_venda());
		
		st.execute();
		
		conn.close();
		
		
	}
	
	


}