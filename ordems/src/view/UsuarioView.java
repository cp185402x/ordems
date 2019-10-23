package view;

//Importando os componentes
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.UsuarioController;
import model.Usuario;

import javax.swing.JOptionPane;
//Declarando a classe na janela
public class UsuarioView extends JFrame implements ActionListener{
	//atributos globais da classe
		JPanel painelTitulo;
		JPanel painelCadastro;
		JLabel titulo;
		
	    JLabel nm_usuarioLabel;
	    JTextField nm_usuarioField;
	    
	    JLabel cargoLabel;
	    JTextField cargoField;
	    
	    JLabel departamentoLabel;
	    JTextField departamentoField;
	    
	    JLabel matriculaLabel;
	    JTextField matriculaField;
	    
	    JLabel loginLabel;
	    JTextField loginField;
	    
	    JLabel senhaLabel;
	    JTextField senhaField;
	    
	    JLabel statusLabel;
	    JTextField statusField;
	    
	  //Inicia o painel dos botoes
	    JPanel painelBotoes;
	    JButton botaoSalvar;
	    JButton botaoCancelar;

	    public UsuarioView() { // construtor da view Usuario.
			super("Cadastro de usuário");
			
		                
		        criaFormulario();
		    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	this.setSize(580, 600);
		    	this.setVisible(true);
		    	this.setLocationRelativeTo(null);
  
	
 
      
  }
  
  private void criaFormulario() {
      
      setLayout(new BorderLayout());
      
//Inicia o painel de título        
      painelTitulo = new JPanel();
      painelTitulo.setLayout(new FlowLayout());
      
      titulo = new JLabel("Cadastro de Usuário");
      titulo.setFont(new Font("Arial", Font.BOLD, 14));
      
      painelTitulo.add(titulo);
      
//Inicia o painel dos campos digitáveis        
      JPanel painelCadastro = new JPanel();
      painelCadastro.setLayout(new FlowLayout());
      
                  
      painelCadastro = new JPanel();
      painelCadastro.setLayout(new FlowLayout());
      
      nm_usuarioLabel = new JLabel("Nome do Usuário");
      nm_usuarioField = new JTextField(40);
      painelCadastro.add(nm_usuarioLabel);
      painelCadastro.add(nm_usuarioField);
      
      cargoLabel = new JLabel("Cargo");
      cargoField = new JTextField(20);
      painelCadastro.add(cargoLabel);
      painelCadastro.add(cargoField);
      
      departamentoLabel = new JLabel("Departamento");
      departamentoField = new JTextField(20);
      painelCadastro.add(departamentoLabel);
      painelCadastro.add(departamentoField);
      
      matriculaLabel = new JLabel("matrícula");
      matriculaField = new JTextField(20);
      painelCadastro.add(matriculaLabel);
      painelCadastro.add(matriculaField);
      
      loginLabel = new JLabel("Login");
      loginField = new JTextField(10);
      painelCadastro.add(loginLabel);
      painelCadastro.add(loginField);
      
      senhaLabel = new JLabel("Senha");
      senhaField = new JTextField(10);
      painelCadastro.add(senhaLabel);
      painelCadastro.add(senhaField);
      
      statusLabel = new JLabel("Status");
      statusField = new JTextField(10);
      painelCadastro.add(statusLabel);
      painelCadastro.add(statusField);
      
      
                  
      
//Inicia o painel dos botoes
      painelBotoes = new JPanel();
      painelBotoes.setLayout(new FlowLayout());
      
      botaoSalvar = new JButton("Salvar");
      botaoCancelar = new JButton("Cancelar");
      
      painelBotoes.add(botaoSalvar);
      painelBotoes.add(botaoCancelar);
      
      botaoSalvar.addActionListener(this);
      botaoSalvar.setActionCommand("salvar");
      botaoCancelar.addActionListener(this);
      botaoCancelar.setActionCommand("cancelar");
      
      add(painelTitulo, BorderLayout.NORTH);
      add(painelCadastro, BorderLayout.CENTER);
      add(painelBotoes, BorderLayout.SOUTH);
  }

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equalsIgnoreCase("salvar")) {
					Usuario u = new Usuario();
					System.out.println("cliquei no botao salvar");
					//usuario
					u.setNm_usuario(nm_usuarioField.getText());
					
					//cargo
					u.setCargo(cargoField.getText());
					
					//departamento
					u.setDepartamento(departamentoField.getText());
					
					//matricula
					u.setMatricula( matriculaField.getText());
					
					//login
					u.setLogin( loginField.getText());
				
					//senha
					u.setSenha( senhaField.getText());
					//status
					u.setStatus( statusField.getText());
				
			
      
      UsuarioController controleUsuario = new UsuarioController();
		try {
			if(controleUsuario.cadastrarUsuario(u) == true) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro!");
		}
	}
	else if(e.getActionCommand().equalsIgnoreCase("Cancelar")) {
		//tratar a ação de cancelar 
			}
      	

	
	
}
  



}
	





