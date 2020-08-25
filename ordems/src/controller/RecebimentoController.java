package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.RecebimentoDAO;
import dao.Conexao;
import model.Recebimento;

public class RecebimentoController {
	///Metodo para receber os dados,tratar e chamar o metodo insere do ClienteDAO
	private Conexao bd;
	public void OsContoller() {
		setBd(new Conexao());
	}
	
	
	public void validaCampos (int cliente_id, int usuario_id, String data_previsao, String status_id  ) {
		
		System.out.println("contoller" + cliente_id);
		System.out.println("contoller" + usuario_id);
		System.out.println("contoller" + data_previsao);
		System.out.println("contoller" + status_id);
	}


	public Conexao getBd() {
		return bd;
	}


	public void setBd(Conexao bd) {
		this.bd = bd;
	}


	public boolean cadastrarRec(Recebimento r) throws SQLException {
		RecebimentoDAO osDAO = new RecebimentoDAO();
		recebimentoDAO.inserir(r);
		
		return true;
	}
		public boolean atualizarRec(Recebimento r) throws SQLException {
			System.out.println("ID = " + r.getId());
			RecebimentoDAO recebimentoDAO = new RecebimentoDAO();
			recebimentoDAO.atualizar(r);
			
			return true;
			
			
		
	}
	public ArrayList<Recebimento> consultarRec() throws SQLException {
		//System.out.println("Cheguei no consultar os");
		RecebimentoDAO recebimentoDAO = new RecebimentoDAO();
		return recebimentoDAO.consultar();
		
	}
	
	public void removerRec(int id) throws SQLException {
		RecebimentoDAO recebimentoDAO = new RecebimentoDAO();
		recebimentoDAO.excluir(id);

}


	
	}
