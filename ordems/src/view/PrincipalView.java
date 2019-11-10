package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ClienteController;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PrincipalView extends JFrame implements ActionListener{

	//Cria a barra de menus
	JMenuBar menuBar;
	
	//Cria o menu Cadastros
	JMenu menuCadastro;
	JMenuItem menuCliente;
	JMenuItem menuFornecedor;
	JMenuItem menuOs;
	JMenuItem menuPeca;
	JMenuItem menuUsuario;
	
	//Teste de para listar os clientes cadastrados
	JMenuItem menuConsultar;
	
	//Cria o menu Relatórios
	JMenu menuRelatorios;
	JMenuItem menuitemClienteRel;
	JMenuItem menuitemFornecedorRel;
	JMenuItem menuitemosRel;
	JMenuItem menuitemPecaRel;
	JMenuItem menuitemUsuarioRel;
	
	//Cria o menu Ajuda
	JMenu menuAjuda;
	JMenuItem menuitemFAQ;
	JMenuItem menuitemSobre;
	
	//Cria botão sair na barra de menus
	JMenu menuSair;
	
	//Construtores
	public PrincipalView() {
		setTitle(":. Ordem-S .::. v1.3.71");
		this.inicializarCadastro();
		this.inicializarRelatorio();
		this.inicializarAjuda();
		this.construirCadastro();
		this.construirRelatorio();
		this.construirAjuda();
		this.setJMenuBar(menuBar);
		

		
		menuSair = new JMenu("Sair");
		menuBar.add(menuSair);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(MAXIMIZED_BOTH);
		this.setSize(1024,700);
	  	this.setLocationRelativeTo(null);
	  	getContentPane().setLayout(null);
		this.setVisible(true);
	}

	//Métodos para inicializar cadastros
	public void inicializarCadastro() {
		menuBar = new JMenuBar();
		menuCadastro = new JMenu("Cadastros");
		
		menuCliente = new JMenuItem("Cliente");
		//menuCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
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
		/*
		//Teste de consulta via console
		menuConsultar = new JMenuItem("Consultar cliente");
		menuConsultar.addActionListener(this);
		menuConsultar.setActionCommand("consultarCliente");
		*/
	}
	
	//Métodos para inicializar os relatórios
	public void inicializarRelatorio() {
		
		menuBar = new JMenuBar();
		menuRelatorios = new JMenu("Relatórios");
		
		menuitemClienteRel = new JMenuItem("Clientes");
		menuitemClienteRel.addActionListener(this);
		menuitemClienteRel.setActionCommand("relatorioCliente");
		
		menuitemFornecedorRel = new JMenuItem("Fornecedores");
		menuitemFornecedorRel.addActionListener(this);
		menuitemFornecedorRel.setActionCommand("relatorioFornecedor");
		
		menuitemosRel = new JMenuItem("Ordens de Serviços");
		menuitemosRel.addActionListener(this);
		menuitemosRel.setActionCommand("relatorioOs");
		
		menuitemPecaRel = new JMenuItem("Peças");
		menuitemPecaRel.addActionListener(this);
		menuitemPecaRel.setActionCommand("relatorioPeca");
		
		menuitemUsuarioRel = new JMenuItem("Usuários");
		menuitemUsuarioRel.addActionListener(this);
		menuitemUsuarioRel.setActionCommand("relatorioUsuario");
	}	
	
	public void inicializarAjuda() {
		
		menuBar = new JMenuBar();		
		menuAjuda = new JMenu("Ajuda");
		
		menuitemFAQ = new JMenuItem("Guia do Usuário");
		menuitemFAQ.addActionListener(this);
		menuitemFAQ.setActionCommand("guiaUsuario");
		
		menuitemSobre = new JMenuItem("Sobre");
		menuitemSobre.addActionListener(this);
		menuitemSobre.setActionCommand("sobreSistema");
		
	}
	
	//Métodos para construir os menus das janela
	public void construirCadastro() {		

		menuBar.add(menuCadastro);
		menuCadastro.add(menuCliente);
		menuCadastro.add(menuFornecedor);
		menuCadastro.add(menuOs);
		menuCadastro.add(menuPeca);
		menuCadastro.add(menuUsuario);
		//menuCadastro.add(menuConsultar);
	}
	public void construirRelatorio() {

		menuBar.add(menuRelatorios);
		menuRelatorios.add(menuitemClienteRel);
		menuRelatorios.add(menuitemFornecedorRel);
		menuRelatorios.add(menuitemosRel);
		menuRelatorios.add(menuitemPecaRel);
		menuRelatorios.add(menuitemUsuarioRel);
		
	}
	public void construirAjuda() {
	
		menuBar.add(menuAjuda);
		menuAjuda.add(menuitemFAQ);
		menuAjuda.add(menuitemSobre);

	}
	

	//Métodos para evocar os formularios (views)
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("cadastrarCliente")) {
			ClienteView cv = new ClienteView();
			this.getContentPane().removeAll();
			//this.getContentPane().add(cv);
			this.revalidate();
		    this.repaint();
		}

		if(e.getActionCommand().equals("cadastrarFornecedor")) {
			FornecedorView fv = new FornecedorView();
			this.getContentPane().removeAll();
			//this.getContentPane().add(fv);
			this.revalidate();
		    this.repaint();
		}

		if(e.getActionCommand().equals("cadastrarOs")) {
			OsView ov = new OsView();
			this.getContentPane().removeAll();
			//this.getContentPane().add(ov);
			this.revalidate();
		    this.repaint();
		}

		if(e.getActionCommand().equals("cadastrarPeca")) {
			PecaView pv = new PecaView();
			this.getContentPane().removeAll();
			//this.getContentPane().add(pv);
			this.revalidate();
		    this.repaint();
		}

		if(e.getActionCommand().equals("cadastrarUsuario")) {
			UsuarioView uv = new UsuarioView();
			this.getContentPane().removeAll();
			//this.getContentPane().add(uv);
			this.revalidate();
		    this.repaint();
		}		
		
		if(e.getActionCommand().equals("sobreSistema")) {
			SobreView sov = new SobreView();
			this.getContentPane().removeAll();
			//this.getContentPane().add(sov);
			this.revalidate();
		    this.repaint();
		}
		/*
		//Teste consultar cliente via console
		if(e.getActionCommand().equals("consultarCliente")) {
			//System.out.println("Cliquei no botao consulta");
			ClienteController controleCliente = new ClienteController();
			try {
				controleCliente.consultarCliente();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		*/
	}
}
