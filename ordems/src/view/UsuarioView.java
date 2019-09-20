package view;

//Importando os componentes*
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Declarando a classe na janela
public class UsuarioView extends JFrame{
  
  public UsuarioView() { // construtor da view OS.
      super("OrdemS : Cadastro de Orden de Serviço");
      
      criaFormulario();
  }
  
  private void criaFormulario() {
      
      setLayout(new BorderLayout());
      
//Inicia o painel de título        
      JPanel painelTitulo = new JPanel();
      painelTitulo.setLayout(new FlowLayout());
      
      JLabel titulo = new JLabel("Cadstro de Usuário.");
      titulo.setFont(new Font("Arial", Font.BOLD, 14));
      
      painelTitulo.add(titulo);
      
//Inicia o painel dos campos digitáveis        
      JPanel painelCadastro = new JPanel();
      painelCadastro.setLayout(new FlowLayout());
      
                  
      JLabel usuarioLabel = new JLabel("Usuario");
      JTextField usuarioField = new JTextField(20);
      painelCadastro.add(usuarioLabel);
      painelCadastro.add(usuarioField);
      
      JLabel CargoLabel = new JLabel("Cargo");
      JTextField CargoField = new JTextField(20);
      painelCadastro.add(CargoLabel);
      painelCadastro.add(CargoField);
      
      JLabel depLabel = new JLabel("Departamento");
      JTextField dpField = new JTextField(20);
      painelCadastro.add(depLabel);
      painelCadastro.add(dpField);
      
      JLabel MatriculaLabel = new JLabel("Matricula");
      JTextField MatriculaField = new JTextField(20);
      painelCadastro.add(MatriculaLabel);
      painelCadastro.add(MatriculaField);
      
      JLabel loginLabel = new JLabel("Login");
      JTextField loginField = new JTextField(20);
      painelCadastro.add(loginLabel);
      painelCadastro.add(loginField);
      
      JLabel senhaLabel = new JLabel("Senha");
      JPasswordField senhaField = new JPasswordField(20);
      painelCadastro.add(senhaLabel);
      painelCadastro.add(senhaField);
      
      
      
      
                  
      
//Inicia o painel dos botoes
      JPanel painelBotoes = new JPanel();
      painelBotoes.setLayout(new FlowLayout());
      
      JButton botaoSalvar = new JButton("Salvar");
      JButton botaoCancelar = new JButton("Cancelar");
      
      painelBotoes.add(botaoSalvar);
      painelBotoes.add(botaoCancelar);
      
      
      botaoSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("cliquei no botao salvar");
				//Usuario
				String usuario = usuarioField.getText();
				System.out.println(usuario);
				//Cargo
				String Cargo = CargoField.getText();
				System.out.println(Cargo);
				//departamento
				String departamento  =dpField  .getText();
				System.out.println(departamento);
				//matricula
				String  matricula = MatriculaField .getText();
				System.out.println(matricula);
				//login
				String login   = loginField .getText();
				System.out.println(login);
				//senha
				String senha  = senhaField .getText();
				System.out.println(senha);
				
			}
      	
      });
      
      botaoCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("cliquei no botao cancelar");
			}
      	
      });
//Adicionando os paineis em suas respectivas posições        
      add(painelTitulo, BorderLayout.NORTH);
      add(painelCadastro, BorderLayout.CENTER);
      add(painelBotoes, BorderLayout.SOUTH);
      
  }
  

}
