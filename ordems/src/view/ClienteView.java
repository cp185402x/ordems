package view;

//Importando os componentes
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

import controller.ClienteController;
//Declarando a classe na janela
public class ClienteView extends JFrame{
	private ClienteController clienteController;

	public ClienteView() { // construtor da view Cliente.
        super("Cadastro de cliente");
        
        
        criaFormulario();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(1024, 500);
    	this.setVisible(true);
    	this.setLocationRelativeTo(null);
    	clienteController=new ClienteController();

    }
    
    private void criaFormulario() {
        
        setLayout(new BorderLayout());
        
//Inicia o painel de título        
        JPanel painelTitulo = new JPanel();
        painelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel("Cadastro de Cliente");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
//Inicia o painel dos campos digitáveis        
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new FlowLayout());
        
        JLabel nomeLabel = new JLabel("Nome");
        JTextField nomeField = new JTextField(20);
        painelCadastro.add(nomeLabel);
        painelCadastro.add(nomeField);
        
        JLabel usuarioLabel = new JLabel("CPF/CNPJ");
        JTextField usuarioField = new JTextField(20);
        painelCadastro.add(usuarioLabel);
        painelCadastro.add(usuarioField);
        
        JLabel rgieLabel = new JLabel("RG/IE");
        JTextField rgieField = new JTextField(20);
        painelCadastro.add(rgieLabel);
        painelCadastro.add(rgieField);
        
        JLabel datanascLabel = new JLabel("Data de nascimento");
        JTextField datanascField = new JTextField(20);
        painelCadastro.add(datanascLabel);
        painelCadastro.add(datanascField);
        
        JLabel celularLabel = new JLabel("Telefone Celular");
        JTextField celularField = new JTextField(20);
        painelCadastro.add(celularLabel);
        painelCadastro.add(celularField);
        
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField(20);
        painelCadastro.add(emailLabel);
        painelCadastro.add(emailField);
        
        JLabel pescontatoLabel = new JLabel("Pessoa de Contato");
        JTextField pescontatoField = new JTextField(20);
        painelCadastro.add(pescontatoLabel);
        painelCadastro.add(pescontatoField);
        
        JLabel cepLabel = new JLabel("CEP");
        JTextField cepField = new JTextField(20);
        painelCadastro.add(cepLabel);
        painelCadastro.add(cepField);
        
        JLabel enderecoLabel = new JLabel("Endereço");
        JTextField enderecoField = new JTextField(20);
        painelCadastro.add(enderecoLabel);
        painelCadastro.add(enderecoField);
        
        JLabel numeroLabel = new JLabel("Numero");
        JTextField numeroField = new JTextField(20);
        painelCadastro.add(numeroLabel);
        painelCadastro.add(numeroField);
        
        JLabel complementoLabel = new JLabel("Complemento");
        JTextField complementoField = new JTextField(20);
        painelCadastro.add(complementoLabel);
        painelCadastro.add(complementoField);
        
        JLabel bairroLabel = new JLabel("Bairro");
        JTextField bairroField = new JTextField(20);
        painelCadastro.add(bairroLabel);
        painelCadastro.add(bairroField);
        
        JLabel cidadeLabel = new JLabel("Cidade");
        JTextField cidadeField = new JTextField(20);
        painelCadastro.add(cidadeLabel);
        painelCadastro.add(cidadeField);
        
        JLabel estadoLabel = new JLabel("Estado");
        JTextField estadoField = new JTextField(20);
        painelCadastro.add(estadoLabel);
        painelCadastro.add(estadoField);
        
// Inicia o painel dos botoes
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        
        JButton botaoSalvar = new JButton("Salvar");
        JButton botaoCancelar = new JButton("Cancelar");
        
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);
        
        botaoSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("cliquei no botao salvar");
				//nome
				String nome = nomeField.getText();
				System.out.println(nome);
				
				//documento
				String doc = usuarioField.getText();
				System.out.println(doc);
				
				//RGIE
				String  rgie  = rgieField .getText();
				System.out.println(rgie);
				
				//Data de nascimento
				String datanasc = datanascField .getText();
				System.out.println(datanasc);
				
				//telefone
				String tel  = celularField .getText();
				System.out.println(tel);
				
				//Email
				String email  = emailField .getText();
				System.out.println(email);
				
				//pessoa
				String pes  = pescontatoField .getText();
				System.out.println(pes);
				
				//CEP
				String  cep  = cepField .getText();
				System.out.println(cep);
				
				//endereço
				String end   = enderecoField .getText();
				System.out.println(end);
				
				//Numero
				String num = numeroField .getText();
				System.out.println(num);
				
				//complemento
				String  comp  = complementoField .getText();
				System.out.println(comp);
				
				//bairro
				String bar   = bairroField .getText();
				System.out.println(bar);
				
				//cidade
				String cid   = cidadeField .getText();
				System.out.println(cid);
				
				//estado
				String uf   = estadoField .getText();
				System.out.println(uf);
			
			}
        	
        });
        
        botaoCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println("Cliquei no botao cancelar");
			}
				
        	
        });
//Adicionando os paineis em suas respectivas posições        
        add(painelTitulo, BorderLayout.NORTH);
        add(painelCadastro, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
        
    }
    

}

