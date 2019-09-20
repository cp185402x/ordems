
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
//Declarando a classe na janela
public class ClienteView extends JFrame{
    
    public ClienteView() { // construtor da view OS.
        super("OrdemS : Cadastro de Orden de Serviço");
        
        criaFormulario();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(1024, 500);
    	this.setVisible(true);
    	this.setLocationRelativeTo(null);

    }
    
    private void criaFormulario() {
        
        setLayout(new BorderLayout());
        
//Inicia o painel de título        
        JPanel painelTitulo = new JPanel();
        painelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel("Cadastrar de Cliente");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
//Inicia o painel dos campos digitáveis        
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new FlowLayout());
        
        JLabel nomeLabel = new JLabel("Nome");
        JTextField nomeField = new JTextField(20);
        painelCadastro.add(nomeLabel);
        painelCadastro.add(nomeField);
        
        
        JLabel usuarioLabel = new JLabel("Documento");
        JTextField usuarioField = new JTextField(20);
        painelCadastro.add(usuarioLabel);
        painelCadastro.add(usuarioField);
        
        JLabel statuaLabel = new JLabel("Telefone Celular");
        JTextField statusField = new JTextField(20);
        painelCadastro.add(statuaLabel);
        painelCadastro.add(statusField);
        
        JLabel dataIniLabel = new JLabel("Pessoa de Contato");
        JTextField dataIniField = new JTextField(20);
        painelCadastro.add(dataIniLabel);
        painelCadastro.add(dataIniField);
        
        JLabel dataFinLabel = new JLabel("Endereço");
        JTextField dataFinField = new JTextField(20);
        painelCadastro.add(dataFinLabel);
        painelCadastro.add(dataFinField);
        
        JLabel tipoLabel1 = new JLabel("Bairro");
        JTextField tipoField1 = new JTextField(20);
        painelCadastro.add(tipoLabel1);
        painelCadastro.add(tipoField1);
        
        JLabel tipoLabel11 = new JLabel("Cidade");
        JTextField tipoField11 = new JTextField(20);
        painelCadastro.add(tipoLabel11);
        painelCadastro.add(tipoField11);
        
        JLabel tipoLabel12 = new JLabel("Estado");
        JTextField tipoField12 = new JTextField(20);
        painelCadastro.add(tipoLabel11);
        painelCadastro.add(tipoField11);
        
        JLabel tipoLabel111 = new JLabel("Complemento");
        JTextField tipoField111 = new JTextField(20);
        painelCadastro.add(tipoLabel111);
        painelCadastro.add(tipoField111);
        
        JLabel garantiaLabel = new JLabel("CEP");
        JTextField garantiaField = new JTextField(20);
        painelCadastro.add(garantiaLabel);
        painelCadastro.add(garantiaField);
        
        JLabel tipoLabel = new JLabel("RgE");
        JTextField tipoField = new JTextField(20);
        painelCadastro.add(tipoLabel);
        painelCadastro.add(tipoField);
        
        JLabel tipoLabel1111 = new JLabel("Email");
        JTextField tipoField1111 = new JTextField(20);
        painelCadastro.add(tipoLabel1111);
        painelCadastro.add(tipoField1111);
        
        JLabel tipoLabel11111 = new JLabel("Numero");
        JTextField tipoField11111 = new JTextField(20);
        painelCadastro.add(tipoLabel11111);
        painelCadastro.add(tipoField11111);
        
        JLabel tipoLabel3 = new JLabel("Data de nascimento");
        JTextField tipoField3 = new JTextField(20);
        painelCadastro.add(tipoLabel11111);
        painelCadastro.add(tipoField11111);
        
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
				// TODO Auto-generated method stub
				System.out.println("cliquei no botao salvar");
				//nome
				String name = nomeField.getText();
				System.out.println(name);
				//documento
				String doc = usuarioField.getText();
				System.out.println(doc);
				//telefone
				String tel  = statusField .getText();
				System.out.println(tel);
				//pessoa
				String pe  = dataIniField .getText();
				System.out.println(pe);
				//endereço
				String ende   = dataFinField .getText();
				System.out.println(ende);
				//bairro
				String ba   = tipoField1 .getText();
				System.out.println(ba);
				//cidade
				String cid   = tipoField11.getText();
				System.out.println(cid);
				//estado
				String es   = tipoField12 .getText();
				System.out.println(es);
				//complemento
				String  cn  = tipoField111 .getText();
				System.out.println(cn);
				//CEP
				String  cep  = garantiaField .getText();
				System.out.println(cep);
				//RGE
				String  rge  =tipoField .getText();
				System.out.println(rge);
				//Email
				String email   =tipoField1111 .getText();
				System.out.println(email);
				//Numero
				String num = tipoField11111 .getText();
				System.out.println(num);
				//Data de nascimento
				String dtn = tipoField3 .getText();
				System.out.println(dtn);
				
				
			
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

