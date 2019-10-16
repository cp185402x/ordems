package controller;

import java.sql.SQLException;

import dao.ClienteDAO;
import dao.Conexao;
import model.Cliente;

public class UsuarioController  {
	//Metodo para receber os dados,tratar e chamar o metodo insere do ClienteDAO
	private Conexao bd;
	public void UsuarioContoller() {
		setBd(new Conexao());
	}
	
	
	public void validaCampos (String usuario, String cargo, String departamento, String matricula, String login, String senha) {
		System.out.println("contoller" + usuario);
		System.out.println("contoller" + cargo);
		System.out.println("contoller" + departamento);
		System.out.println("contoller" + matricula);
		System.out.println("contoller" + login);
		System.out.println("contoller" + senha);
		
	}


	public Conexao getBd() {
		return bd;
	}


	public void setBd(Conexao bd) {
		this.bd = bd;
	}
	public boolean cadastrarUsuario(Usuario u) throws SQLException {
		// toda validação dos campos
		if(true) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuairoDAO.inserir(u);
			
			return true;
		}
		else {
			return false;

}
	}
}