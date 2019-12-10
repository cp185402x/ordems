package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import dao.UsuarioDAO;
import dao.ClienteDAO;
import dao.Conexao;
import model.Cliente;
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
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.inserir(u);
		
		return true;
		
		
	}
	
	public boolean atualizarUsuario(Usuario u) throws SQLException {
		System.out.println("ID = " + u.getId());
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.atualizar(u);
		
		return true;
		
		
	}


	public ArrayList<Usuario> consultarUsuario() throws SQLException {
		//System.out.println("Cheguei no consultar usaurio");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.consultar();
		
	}
	
	public void removerUsuario(int id) throws SQLException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(id);
	}

}
