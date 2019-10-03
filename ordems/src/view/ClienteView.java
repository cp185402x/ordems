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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;

import controller.ClienteController;
import model.Cliente;
//Declarando a classe na janela
public class ClienteView extends JFrame implements ActionListener{
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JLabel titulo;
    JLabel nomeLabel;
    JTextField nomeField;
    JLabel usuarioLabel;
    JTextField usuarioField;
    JLabel rgieLabel;
    JTextField rgieField;
    JLabel datanascLabel;
    JTextField datanascField;
    JLabel celularLabel;
    JTextField celularField;
    JLabel emailLabel;
    JTextField emailField;
    JLabel pescontatoLabel;
    JTextField pescontatoField;
    JLabel cepLabel;
    JTextField cepField;
    JLabel enderecoLabel;
    JTextField enderecoField;
    JLabel numeroLabel;
    JTextField numeroField;
    JLabel complementoLabel;
    JTextField complementoField;
    JLabel bairroLabel;
    JTextField bairroField;
    JLabel cidadeLabel;
    JTextField cidadeField;
    JLabel estadoLabel;
    JTextField estadoField;
    
    //Inicia o painel dos botoes
    JPanel painelBotoes;
    JButton botaoSalvar;
    JButton botaoCancelar;

	public ClienteView() { // construtor da view Cliente.
        super("Cadastro de cliente");
                
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
        
        titulo = new JLabel("Cadastro de Cliente");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
        //Inicia o painel dos campos digitáveis        
        painelCadastro = new JPanel();
        painelCadastro.setLayout(new FlowLayout());
        
        nomeLabel = new JLabel("Nome");
        nomeField = new JTextField(20);
        painelCadastro.add(nomeLabel);
        painelCadastro.add(nomeField);
        
        usuarioLabel = new JLabel("CPF/CNPJ");
        usuarioField = new JTextField(20);
        painelCadastro.add(usuarioLabel);
        painelCadastro.add(usuarioField);
        
        rgieLabel = new JLabel("RG/IE");
        rgieField = new JTextField(20);
        painelCadastro.add(rgieLabel);
        painelCadastro.add(rgieField);
        
        datanascLabel = new JLabel("Data de nascimento");
        datanascField = new JTextField(20);
        painelCadastro.add(datanascLabel);
        painelCadastro.add(datanascField);
        
        celularLabel = new JLabel("Telefone Celular");
        celularField = new JTextField(20);
        painelCadastro.add(celularLabel);
        painelCadastro.add(celularField);
        
        emailLabel = new JLabel("Email");
        emailField = new JTextField(20);
        painelCadastro.add(emailLabel);
        painelCadastro.add(emailField);
        
        pescontatoLabel = new JLabel("Pessoa de Contato");
        pescontatoField = new JTextField(20);
        painelCadastro.add(pescontatoLabel);
        painelCadastro.add(pescontatoField);
        
        cepLabel = new JLabel("CEP");
        cepField = new JTextField(20);
        painelCadastro.add(cepLabel);
        painelCadastro.add(cepField);
        
        enderecoLabel = new JLabel("Endereço");
        enderecoField = new JTextField(20);
        painelCadastro.add(enderecoLabel);
        painelCadastro.add(enderecoField);
        
        numeroLabel = new JLabel("Numero");
        numeroField = new JTextField(20);
        painelCadastro.add(numeroLabel);
        painelCadastro.add(numeroField);
        
        complementoLabel = new JLabel("Complemento");
        complementoField = new JTextField(20);
        painelCadastro.add(complementoLabel);
        painelCadastro.add(complementoField);
        
        bairroLabel = new JLabel("Bairro");
        bairroField = new JTextField(20);
        painelCadastro.add(bairroLabel);
        painelCadastro.add(bairroField);
        
        cidadeLabel = new JLabel("Cidade");
        cidadeField = new JTextField(20);
        painelCadastro.add(cidadeLabel);
        painelCadastro.add(cidadeField);
        
        estadoLabel = new JLabel("Estado");
        estadoField = new JTextField(20);
        painelCadastro.add(estadoLabel);
        painelCadastro.add(estadoField);
        
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
			Cliente c = new Cliente();
			
			//tratar a ação de salvar o cliente
			System.out.println("cliquei no botao salvar");
			//nome
			c.setNome(nomeField.getText());
			
			//documento
			c.setDocumento(usuarioField.getText());
			
			//RGIE
			c.setRgie(rgieField .getText());
			
			//Data de nascimento
			/*String datanasc = datanascField .getText();
			System.out.println(datanasc);*/
			
			//telefone
			/*String tel  = celularField .getText();
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
			System.out.println(uf);*/
			ClienteController controleCliente = new ClienteController();
			try {
				if(controleCliente.cadastrarCliente(c) == true) {
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

