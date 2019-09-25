package view;

import java.awt.Dimension;
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
	JMenuItem menuItem;
	
	//construtor
	public PrincipalView() {
		this.inicializar();
		this.construir();
		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1366,768);
		this.setVisible(true);
		
		
	}
	
	
	//método para inicializar
	public void inicializar() {
		menuBar = new JMenuBar();
		menu = new JMenu("Cadastro");
		menuItem = new JMenuItem("Cliente");
		menuItem.addActionListener(this);
		menuItem.setActionCommand("cadastrarCliente");
		
	}
	
	//método para construir os menus na janela
	public void construir() {
		menu.add(menuItem);
		menuBar.add(menu);
	}


	//Evoca os formularios
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("cadastrarCliente")) {
			ClienteView pw = new ClienteView();
			this.getContentPane().removeAll();
			this.getContentPane().add(pw);
			this.revalidate();
		    this.repaint();
		}
		
	}

}
