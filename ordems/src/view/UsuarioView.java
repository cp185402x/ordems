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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
//Declarando a classe na janela
public class UsuarioView extends JFrame implements ActionListener{
	//atributos globais da classe
		JPanel painelTitulo;
		JPanel painelCadastro;
		
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
	    JTextField senhaaaaaField;
	    
	    JLabel statusLabel;
	    JTextField statusField;
	    
	  //Inicia o painel dos botoes
	    JPanel painelBotoes;
	    JButton botaoSalvar;
	    JButton botaoCancelar;
	    private JPanel painelCadastro_1;
	    private JTextField textField;
	    private JPasswordField senhaField;

	    public UsuarioView() { // construtor da view Usuario.
			super("Cadastro de usuário");
			
		                
		        criaFormulario();
		    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	this.setSize(630, 600);
		    	this.setVisible(true);
		    	this.setLocationRelativeTo(null);
    
  }
  
  private void criaFormulario() {
      
      getContentPane().setLayout(new BorderLayout());
      
//Inicia o painel de título        
      painelTitulo = new JPanel();
      painelTitulo.setLayout(new FlowLayout());
      
//Inicia o painel dos campos digitáveis        
      JPanel painelCadastro = new JPanel();
      painelCadastro.setLayout(new FlowLayout());
      
                  
      painelCadastro_1 = new JPanel();
      painelCadastro_1.setLayout(null);
      
      
                  
      
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
      
      getContentPane().add(painelTitulo, BorderLayout.NORTH);
      getContentPane().add(painelCadastro_1, BorderLayout.CENTER);
      
      JPanel panel = new JPanel();
      panel.setBounds(10, 11, 594, 150);
      panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
      painelCadastro_1.add(panel);
      panel.setLayout(null);
      
      nm_usuarioLabel = new JLabel("Nome");
      nm_usuarioLabel.setBounds(42, 11, 326, 14);
      panel.add(nm_usuarioLabel);
      nm_usuarioField = new JTextField(40);
      nm_usuarioField.setBounds(42, 26, 326, 20);
      panel.add(nm_usuarioField);
      matriculaField = new JTextField(20);
      matriculaField.setBounds(378, 26, 166, 20);
      panel.add(matriculaField);
      
      matriculaLabel = new JLabel("Matrícula");
      matriculaLabel.setBounds(378, 11, 166, 14);
      panel.add(matriculaLabel);
      statusField = new JTextField(10);
      statusField.setBounds(378, 71, 166, 20);
      panel.add(statusField);
      
      statusLabel = new JLabel("Status");
      statusLabel.setBounds(378, 57, 86, 14);
      panel.add(statusLabel);
      cargoField = new JTextField(20);
      cargoField.setBounds(42, 71, 166, 20);
      panel.add(cargoField);
      
      cargoLabel = new JLabel("Cargo");
      cargoLabel.setBounds(42, 57, 166, 14);
      panel.add(cargoLabel);
      
      departamentoLabel = new JLabel("Departamento");
      departamentoLabel.setBounds(218, 57, 150, 14);
      panel.add(departamentoLabel);
      departamentoField = new JTextField(20);
      departamentoField.setBounds(218, 71, 150, 20);
      panel.add(departamentoField);
      
      loginLabel = new JLabel("Login");
      loginLabel.setBounds(42, 102, 86, 14);
      panel.add(loginLabel);
      loginField = new JTextField(10);
      loginField.setBounds(42, 116, 166, 20);
      panel.add(loginField);
      
      senhaaaaaField = new JTextField(10);
      senhaaaaaField.setBounds(394, 116, 150, 20);
      panel.add(senhaaaaaField);
      
      senhaLabel = new JLabel("Senha");
      senhaLabel.setBounds(218, 102, 86, 14);
      panel.add(senhaLabel);      
      senhaField = new JPasswordField(10);
      senhaField.setEchoChar('*');
      senhaField.setBounds(218, 116, 150, 20);
      panel.add(senhaField);
      
      textField = new JTextField();
      textField.setBounds(10, 172, 285, 26);
      textField.setForeground(SystemColor.info);
      textField.setColumns(10);
      painelCadastro_1.add(textField);
      
      JButton button = new JButton("Buscar");
      button.setBounds(305, 173, 90, 25);
      painelCadastro_1.add(button);
      
      JButton button_1 = new JButton("Editar");
      button_1.setBounds(414, 173, 90, 25);
      painelCadastro_1.add(button_1);
      
      JButton button_2 = new JButton("Excluir");
      button_2.setBounds(514, 173, 90, 25);
      painelCadastro_1.add(button_2);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 209, 594, 281);
      painelCadastro_1.add(scrollPane);
      getContentPane().add(painelBotoes, BorderLayout.SOUTH);
  }

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equalsIgnoreCase("salvar")) {
					Usuario u = new Usuario();
					
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
		 
			dispose();
		
			}
      	

	
	
}
}
	





