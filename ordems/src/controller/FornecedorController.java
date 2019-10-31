package controller;

import java.sql.SQLException;

import dao.Conexao;
import dao.FornecedorDAO;
import model.Fornecedor;


public class FornecedorController {
	//Metodo para receber os dados,tratar e chamar o metodo insere do FornecedorDAO
	private Conexao bd;
	public void FornecedorContoller() {
		setBd(new Conexao());
	}
	
	
	public void validaCampos (String nome, String documento, String rgie, String data, String fone_re, String celular, String email, String contato, String cep, String endereco, String numero, String complemento, String bairro, String cidade, String estado) {
		
		System.out.println("contoller" + nome);
		System.out.println("contoller" + documento);
		System.out.println("contoller" + rgie);
		System.out.println("contoller" + data);
		System.out.println("contoller" + fone_re);
		System.out.println("contoller" + celular);
		System.out.println("contoller" + email);
		System.out.println("contoller" + contato);
		System.out.println("contoller" + cep);
		System.out.println("contoller" + endereco);
		System.out.println("contoller" + numero);
		System.out.println("contoller" + complemento);
		System.out.println("contoller" + bairro);
		System.out.println("contoller" + cidade);
		System.out.println("contoller" + estado);
		
	}


	public Conexao getBd() {
		return bd;
	}


	public void setBd(Conexao bd) {
		this.bd = bd;
	}


	public boolean cadastrarFornecedor(Fornecedor f) throws SQLException {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		fornecedorDAO.inserir(f);
		
		return true;
		
		
	}


	public Fornecedor consultarFornecedor() throws SQLException {
		//System.out.println("Cheguei no consultar fornecedor");
		Fornecedor fornecedor;
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		fornecedorDAO.consultar();
		fornecedor = new Fornecedor();
		
		return fornecedor;
		
	}

}
