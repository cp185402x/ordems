package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PrincipalView extends JFrame implements ActionListener{

	//atributos
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuCliente;
	JMenuItem menuUsuario;
	
	//construtor
	public PrincipalView() {
		this.inicializarCliente();
		this.inicializarUsuario();
		this.construirCliente();
		this.construirUsuario();
		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1366,768);
		this.setVisible(true);		
	}
	
	//método para inicializar
	public void inicializarCliente() {
		menuBar = new JMenuBar();
		menu = new JMenu("Cadastro");
		menuCliente = new JMenuItem("Cliente");
		menuCliente.addActionListener(this);
		menuCliente.setActionCommand("cadastrarCliente");
	}
		
	public void inicializarUsuario() {
		menuBar = new JMenuBar();
		menu = new JMenu("Cadastro");
		menuUsuario = new JMenuItem("Usuário");
		menuUsuario.addActionListener(this);
		menuUsuario.setActionCommand("cadastrarUsuario");
		
	}
	
	//método para construir os menus na janela
	public void construirCliente() {
		
		menu.add(menuCliente);
		menuBar.add(menu);
	}	
	
	public void construirUsuario() {
		
		menu.add(menuUsuario);
		menuBar.add(menu);
	}


	//Evoca os formularios
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("cadastrarCliente")) {
			ClienteView cv = new ClienteView();
			this.getContentPane().removeAll();
			this.getContentPane().add(cv);
			this.revalidate();
		    this.repaint();
		}

		if(e.getActionCommand().equals("cadastrarUsuario")) {
			UsuarioView uv = new UsuarioView();
			this.getContentPane().removeAll();
			this.getContentPane().add(uv);
			this.revalidate();
		    this.repaint();
		}
		
	}

}
