package controller;

import java.sql.SQLException;
import java.util.ArrayList;


import dao.Conexao;
import dao.PecaDAO;

import model.Peca;

public class PecaController {
	///Metodo para receber os dados,tratar e chamar o metodo insere do ClienteDAO
	private Conexao bd;
	public void PecaContoller() {
		setBd(new Conexao());
	}
	
	
	public void validaCampos (String nm_peca, String vl_custo, String vl_venda, String sku ) {
		
		System.out.println("contoller" + nm_peca);
		System.out.println("contoller" + vl_custo);
		System.out.println("contoller" + vl_venda);
		System.out.println("contoller" + sku);
	}


	public Conexao getBd() {
		return bd;
	}


	public void setBd(Conexao bd) {
		this.bd = bd;
	}


	public boolean cadastrarPeca(Peca p) throws SQLException {
		PecaDAO pecaDAO = new PecaDAO();
		pecaDAO.inserir(p);
		
		return true;
		
		
	}
	
	public boolean atualizarPeca(Peca p) throws SQLException {
		System.out.println("ID = " + p.getId());
		PecaDAO pecaDAO = new PecaDAO();
		pecaDAO.atualizar(p);
		
		return true;
		
		
	}


	public ArrayList<Peca> consultarPeca() throws SQLException {
		//System.out.println("Cheguei no consultar peca");
		PecaDAO pecaDAO = new PecaDAO();
		return pecaDAO.consultar();
		
	}
	
	public void removerPeca(int id) throws SQLException {
		PecaDAO pecaDAO = new PecaDAO();
		pecaDAO.excluir(id);
	}

}
