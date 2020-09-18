package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import view.rel.*;

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
	JMenuItem menuSair;
	
	//Cria o menu Relat�rios
	JMenu menuRelatorios;
	JMenuItem menuitemClienteRel;
	JMenuItem menuitemFornecedorRel;
	JMenuItem menuitemOsRel;
	JMenuItem menuitemPecaRel;
	JMenuItem menuitemUsuarioRel;
	
	//Cria o menu Ajuda
	JMenu menuAjuda;
	JMenuItem menuitemFAQ;
	JMenuItem menuitemSobre;
	
	//Construtores
	public PrincipalView() {
		setTitle(":. Ordem-S .:. VEC System .:");
		this.inicializarCadastro();
		this.inicializarRelatorio();
		this.inicializarAjuda();
		this.construirCadastro();
		this.construirRelatorio();
		this.construirAjuda();
		this.setJMenuBar(menuBar);
				

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(MAXIMIZED_BOTH);
		this.setSize(1024,700);
	  	this.setLocationRelativeTo(null);
	  	getContentPane().setLayout(null);
		this.setVisible(true);
	}

	//M�todos para inicializar cadastros
	public void inicializarCadastro() {
		menuBar = new JMenuBar();
		menuCadastro = new JMenu("Cadastros");
		
		menuCliente = new JMenuItem("Cliente");
		menuCliente.addActionListener(this);
		menuCliente.setActionCommand("cadastrarCliente");
	
		menuFornecedor = new JMenuItem("Fornecedor");
		menuFornecedor.addActionListener(this);
		menuFornecedor.setActionCommand("cadastrarFornecedor");
	
		menuOs = new JMenuItem("Ordem de Servi�o");
		menuOs.addActionListener(this);
		menuOs.setActionCommand("cadastrarOs");
	
		menuPeca = new JMenuItem("Pe�a");
		menuPeca.addActionListener(this);
		menuPeca.setActionCommand("cadastrarPeca");
	
		menuUsuario = new JMenuItem("Usu�rio");
		menuUsuario.addActionListener(this);
		menuUsuario.setActionCommand("cadastrarUsuario");
		
		menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(this);
		menuSair.setActionCommand("sair");

	}
	
	//M�todos para inicializar os relat�rios
	public void inicializarRelatorio() {
		
		menuBar = new JMenuBar();
		menuRelatorios = new JMenu("Relat�rios");
		
		menuitemClienteRel = new JMenuItem("Clientes");
		menuitemClienteRel.addActionListener(this);
		menuitemClienteRel.setActionCommand("relatorioCliente");
		
		menuitemFornecedorRel = new JMenuItem("Fornecedores");
		menuitemFornecedorRel.addActionListener(this);
		menuitemFornecedorRel.setActionCommand("relatorioFornecedor");
		
		menuitemOsRel = new JMenuItem("Ordens de Servi�os");
		menuitemOsRel.addActionListener(this);
		menuitemOsRel.setActionCommand("relatorioOs");
		
		menuitemPecaRel = new JMenuItem("Pe�as");
		menuitemPecaRel.addActionListener(this);
		menuitemPecaRel.setActionCommand("relatorioPeca");
		
		menuitemUsuarioRel = new JMenuItem("Usu�rios");
		menuitemUsuarioRel.addActionListener(this);
		menuitemUsuarioRel.setActionCommand("relatorioUsuario");
	}	
	
	public void inicializarAjuda() {
		
		menuBar = new JMenuBar();		
		menuAjuda = new JMenu("Ajuda");
		menuitemSobre = new JMenuItem("Sobre");
		menuitemSobre.addActionListener(this);
		menuitemSobre.setActionCommand("sobreSistema");
		
	}
	//M�todos para construir os menus das janela
	public void construirCadastro() {		

		menuBar.add(menuCadastro);
		menuCadastro.add(menuCliente);
		menuCadastro.add(menuFornecedor);
		menuCadastro.add(menuOs);
		menuCadastro.add(menuPeca);
		menuCadastro.add(menuUsuario);
		menuCadastro.add(menuSair);
	}
	public void construirRelatorio() {

		menuBar.add(menuRelatorios);
		menuRelatorios.add(menuitemClienteRel);
		menuRelatorios.add(menuitemFornecedorRel);
		menuRelatorios.add(menuitemOsRel);
		menuRelatorios.add(menuitemPecaRel);
		menuRelatorios.add(menuitemUsuarioRel);
		
	}
	public void construirAjuda() {
	
		menuBar.add(menuAjuda);
		menuAjuda.add(menuitemSobre);

	}

	//M�todos para evocar os formularios (views)
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
			OsView ov = new OsView(null);
			this.getContentPane().removeAll();
			this.getContentPane().add(ov);
			this.revalidate();
		    this.repaint();
		}

		if(e.getActionCommand().equals("cadastrarPeca")) {
			PecaView pv = new PecaView(null);
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
		//Sobre
		if(e.getActionCommand().equals("sobreSistema")) {
			SobreView sv = new SobreView();
			this.getContentPane().removeAll();
			this.getContentPane().add(sv);
			this.revalidate();
		    this.repaint();
		}
		
		//Menu Relat�rios
		if(e.getActionCommand().equals("relatorioCliente")) {
			RelClienteView rc = new RelClienteView("imprimir");
			this.getContentPane().removeAll();
			this.getContentPane().add(rc);
			this.revalidate();
		    this.repaint();
		}
		if(e.getActionCommand().equals("relatorioFornecedor")) {
			RelFornecedorView rf = new RelFornecedorView("imprimir");
			this.getContentPane().removeAll();
			this.getContentPane().add(rf);
			this.revalidate();
		    this.repaint();
		}
		if(e.getActionCommand().equals("relatorioOs")) {
			RelOsView ro = new RelOsView();
			this.getContentPane().removeAll();
			this.getContentPane().add(ro);
			this.revalidate();
		    this.repaint();
		}
		if(e.getActionCommand().equals("relatorioUsuario")) {
			RelUsuarioView ru = new RelUsuarioView();
			this.getContentPane().removeAll();
			this.getContentPane().add(ru);
			this.revalidate();
		    this.repaint();
		}
		if(e.getActionCommand().equals("relatorioPeca")) {
			RelPecaView rp = new RelPecaView();
			this.getContentPane().removeAll();
			this.getContentPane().add(rp);
			this.revalidate();
		    this.repaint();
		}

		//Sair do sistema
		if(e.getActionCommand().equals("sair")) {

			dispose();	
		
		}
	}
}
