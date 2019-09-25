package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dao.Conexao;

public class ConexaoTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection conn = Conexao.getConexao();
			Statement st = conn.createStatement();
			st.execute("INSERT INTO cliente (id_cliente, usuario_id, data_cad, data_nasc, data_uedit, nm_cliente, tipo_cliente, doc_num, rg_ie, celular, fone_re, email, pes_contato, cep, endereco, numero, complemento, bairro, cidade, estado) VALUES (5, 1007, '2019-09-24 21:46:48', '1979-09-12', '2019-09-12', 'EDILSON R BARROS', 1, '83250927573', '39112563', '19988020800', '1932540100', 'edilson.barros@aluno.ifsp.edu.br', 'O MESMO', '13010000', 'AV. DR. MORAES SALES', '1000', 'APTO-1079', 'NOVA CAMPINAS', 'CAMPINAS', 'SP')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
