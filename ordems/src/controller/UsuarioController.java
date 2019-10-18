package controller;

import java.sql.SQLException;

import dao.ClienteDAO;
import dao.Conexao;
import dao.UsuarioDAO;
import model.Cliente;
import model.Usuario;

public class UsuarioController  {
	//Metodo para receber os dados,tratar e chamar o metodo insere do ClienteDAO
	private Conexao bd;
	public void UsuarioContoller() {
		setBd(new Conexao());
	}
	
	
	public void validaCampos (String nmusuario, String cargo, String departamento, int matricula, String login, String senha) {
		System.out.println("contoller" + nmusuario);
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
			usuarioDAO.inserir(u);
			
			return true;
		}
		else {
			return false;

}
	}
}