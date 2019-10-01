package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.ClienteController;
import model.Cliente;
import dao.Conexao;

public class ClienteDAO {
	//metodo inserir
	//metodo consultar
	//deletar 
	//atualizar
	//metodos sempre recebem objeto
	
	Connection conn = null;
	PreparedStatement st = null;
	
	conn = Conexao.getConnection();
	
	st = conn.prepareStatement(
			"INSERT INTO cliente"
			+ "(usuario_id, data_nasc, data_uedit, nm_cliente, tipo_cliente, doc_num, rg_ie, celular, fone_re, email, pes_contato, cep, endereco, numero, complemento, bairro, cidade, estado) "
			+ "VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	
	st.setInt(1, "");
	st.setDate(2, new java.sql.Date(sdf.parse("").getTime()));
	st.setDate(3, new java.sql.Date(sdf.parse("").getTime()));
	st.setString(4, "");
	st.setInt(5, "");
	st.set
	st.set
	st.set
	st.set
	st.set
	st.set
	st.set
	st.set
	st.set
	st.set
	st.set
	st.set
	st.set
	st.set


}
