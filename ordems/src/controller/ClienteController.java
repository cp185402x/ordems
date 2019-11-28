package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ClienteDAO;
import dao.Conexao;
import model.Cliente;

//teste
public class ClienteController {
	///Metodo para receber os dados,tratar e chamar o metodo insere do ClienteDAO
	private Conexao bd;
	public void ClienteContoller() {
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


	public boolean cadastrarCliente(Cliente c) throws SQLException {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserir(c);
		
		return true;
		
		
	}
	
	public boolean atualizarCliente(Cliente c) throws SQLException {
		System.out.println("ID = " + c.getId());
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.atualizar(c);
		
		return true;
		
		
	}


	public ArrayList<Cliente> consultarCliente() throws SQLException {
		//System.out.println("Cheguei no consultar cliente");
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.consultar();
		
	}
	
	public void removerCliente(int id) throws SQLException {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.excluir(id);
	}

}
