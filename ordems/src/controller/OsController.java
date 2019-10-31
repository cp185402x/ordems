package controller;

import java.sql.SQLException;

import dao.OsDAO;
import dao.Conexao;
import model.Os;

public class OsController {
	//Metodo para receber os dados,tratar e chamar o metodo insere do ClienteDAO
	private Conexao bd;
	public void OsContoller() {
		setBd(new Conexao());
	}
	
	
	public void validaCampos (int cliente_id, int usuario_id, String data_previsao, String data_pronto, String data_entrega, String tipo, String modelo, String marca, String cor, String serie, int garantia, String info_cliente, String info_tecnico, String info_entrega, String info_interna,String status_id  ) {
		
		System.out.println("contoller" + cliente_id);
		System.out.println("contoller" + usuario_id);
		System.out.println("contoller" + data_previsao);
		System.out.println("contoller" + data_pronto);
		System.out.println("contoller" + data_entrega);
		System.out.println("contoller" + tipo);
		System.out.println("contoller" + modelo);
		System.out.println("contoller" + marca);
		System.out.println("contoller" + cor);
		System.out.println("contoller" + serie);
		System.out.println("contoller" + garantia);
		System.out.println("contoller" + info_cliente);
		System.out.println("contoller" + info_tecnico);
		System.out.println("contoller" + info_entrega);
		System.out.println("contoller" + status_id);
	}


	public Conexao getBd() {
		return bd;
	}


	public void setBd(Conexao bd) {
		this.bd = bd;
	}


	public boolean cadastrarOs(Os o) throws SQLException {
		OsDAO osDAO = new OsDAO();
		osDAO.inserir(o);
		
		return true;
		
		
	}

}