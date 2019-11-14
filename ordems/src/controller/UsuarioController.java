package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import dao.UsuarioDAO;
import dao.Conexao;
import model.Usuario;


public class UsuarioController  {
	///Metodo para receber os dados,tratar e chamar o metodo insere do ClienteDAO
	private Conexao bd;
	public void UsuarioContoller() {
		setBd(new Conexao());
	}
	
	
	public void validaCampos (String nm_usuario, String cargo, String departamento, String matricula, String login, String senha, String status) {
		System.out.println("contoller" + nm_usuario);
		System.out.println("contoller" + cargo);
		System.out.println("contoller" + departamento);
		System.out.println("contoller" + matricula);
		System.out.println("contoller" + login);
		System.out.println("contoller" + senha);
		System.out.println("contoller" + status);
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
		} else
			return false;
	}
}