package view;

//Importando os componentes*
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ClienteController;
import controller.UsuarioController;
import model.Cliente;
import model.Usuario;
//Declarando a classe na janela
public class UsuarioView extends JFrame implements ActionListener{
	//atributos globais da classe
		JPanel painelTitulo;
		JPanel painelCadastro;
		JLabel titulo;
	    JLabel usuarioLabel;
	    JTextField usuarioField;
	    JLabel cargLabel;
	    JTextField cargField;
	    JLabel depLabel;
	    JTextField dpField;
	    JLabel MatriculaLabel;
	    JTextField MatriculaField;
	    JLabel loginLabel;
	    JTextField loginField;
	    JLabel senhaLabel;
	    JTextField senhaField;
	    
	  //Inicia o painel dos botoes
	    JPanel painelBotoes;
	    JButton botaoSalvar;
	    JButton botaoCancelar;

	    public UsuarioView() { // construtor da view Usuario.
			super("Cadastro de usuário");
			
		                
		        criaFormulario();
		    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	this.setSize(1024, 500);
		    	this.setVisible(true);
		    	this.setLocationRelativeTo(null);
  
	
 
      
  }
  
  private void criaFormulario() {
      
      setLayout(new BorderLayout());
      
//Inicia o painel de título        
      painelTitulo = new JPanel();
      painelTitulo.setLayout(new FlowLayout());
      
      titulo = new JLabel("Cadastro de Usuario");
      titulo.setFont(new Font("Arial", Font.BOLD, 14));
      
      painelTitulo.add(titulo);
      
      painelTitulo.add(titulo);
      
//Inicia o painel dos campos digitáveis        
      JPanel painelCadastro = new JPanel();
      painelCadastro.setLayout(new FlowLayout());
      
                  
      painelCadastro = new JPanel();
      painelCadastro.setLayout(new FlowLayout());
      
      usuarioLabel = new JLabel("Usuario");
      usuarioField = new JTextField(20);
      painelCadastro.add(usuarioLabel);
      painelCadastro.add(usuarioField);
      
      cargLabel = new JLabel("Usuario");
      cargField = new JTextField(20);
      painelCadastro.add(cargLabel);
      painelCadastro.add(cargField);
      
      depLabel = new JLabel("Departamento");
      dpField = new JTextField(20);
      painelCadastro.add(depLabel);
      painelCadastro.add(dpField);
      
      MatriculaLabel = new JLabel("Matricula");
      MatriculaField = new JTextField(20);
      painelCadastro.add(MatriculaLabel);
      painelCadastro.add(MatriculaField);
      
      loginLabel = new JLabel("login");
      loginField = new JTextField(20);
      painelCadastro.add(loginLabel);
      painelCadastro.add(loginField);
      
      senhaLabel = new JLabel("senha");
      senhaField = new JTextField(20);
      painelCadastro.add(senhaLabel);
      painelCadastro.add(senhaField);
      
      
      
                  
      
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
			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equalsIgnoreCase("salvar")) {
					Usuario u = new Usuario();
					System.out.println("cliquei no botao salvar");
					//usuario
					u.setUsuario(usuarioField.getText());
					
					//cargo
					u.setCargo(cargField.getText());
					
					//departamento
					u.setDepartamento(dpField.getText());
					
					//matricula
					u.setMatricula( MatriculaField.getText());
					
					//login
					u.setLogin( loginField.getText());
				
					//senha
					u.setSenha( senhaField.getText());
				
					
				
			
      
      ClienteController controleCliente = new ClienteController();
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
	else if(e.getActionCommand().equalsIgnoreCase("cancelar")) {
		//tratar a ação de cancelar 
			}
      	

	
	
}
  



}
	





