package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ClienteController;

public class PrincipalView extends JFrame implements ActionListener{

	//atributos
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuCliente;
	JMenuItem menuFornecedor;
	JMenuItem menuOs;
	JMenuItem menuPeca;
	JMenuItem menuUsuario;
	JMenuItem menuConsultar;
	
	//construtor
	public PrincipalView() {
		this.inicializarCadastro();
		this.construirCadastro();
		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(MAXIMIZED_BOTH);
		this.setSize(1024,700);
	  	this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	//método para inicializar
	public void inicializarCadastro() {
		menuBar = new JMenuBar();
		menu = new JMenu("Cadastro");
		
		menuCliente = new JMenuItem("Cliente");
		menuCliente.addActionListener(this);
		menuCliente.setActionCommand("cadastrarCliente");
	
		menuFornecedor = new JMenuItem("Fornecedor");
		menuFornecedor.addActionListener(this);
		menuFornecedor.setActionCommand("cadastrarFornecedor");
	
		menuOs = new JMenuItem("Ordem de Serviço");
		menuOs.addActionListener(this);
		menuOs.setActionCommand("cadastrarOs");
	
		menuPeca = new JMenuItem("Peça");
		menuPeca.addActionListener(this);
		menuPeca.setActionCommand("cadastrarPeca");
	
		menuUsuario = new JMenuItem("Usuário");
		menuUsuario.addActionListener(this);
		menuUsuario.setActionCommand("cadastrarUsuario");
		
		menuConsultar = new JMenuItem("Consultar cliente");
		menuConsultar.addActionListener(this);
		menuConsultar.setActionCommand("consultarCliente");
		
	}
	
	
	//método para construir os menus na janela
	public void construirCadastro() {
		
		menu.add(menuCliente);
		menu.add(menuFornecedor);
		menu.add(menuOs);
		menu.add(menuPeca);
		menu.add(menuUsuario);
		menu.add(menuConsultar);
		menuBar.add(menu);
	}

	//Evocar os formularios
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("cadastrarCliente")) {
			ClienteView cv = new ClienteView();
			this.getContentPane().removeAll();
			this.getContentPane().add(cv);
			this.revalidate();
		    this.repaint();
		}

		if(e.getActionCommand().equals("cadastrarFornecedor")) {
			FornecedorView fv = new FornecedorView();
			this.getContentPane().removeAll();
			this.getContentPane().add(fv);
			this.revalidate();
		    this.repaint();
		}

		if(e.getActionCommand().equals("cadastrarOs")) {
			OsView ov = new OsView();
			this.getContentPane().removeAll();
			this.getContentPane().add(ov);
			this.revalidate();
		    this.repaint();
		}

		if(e.getActionCommand().equals("cadastrarPeca")) {
			PecaView pv = new PecaView();
			this.getContentPane().removeAll();
			this.getContentPane().add(pv);
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
		
		if(e.getActionCommand().equals("consultarCliente")) {
			//System.out.println("Cliquei no botao consulta");
			ClienteController controleCliente = new ClienteController();
			controleCliente.consultarCliente();
		}
		
	}

}
