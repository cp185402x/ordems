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
public class PecaView extends JFrame{
    
    public PecaView() { // construtor da view OS.
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
        
        JLabel titulo = new JLabel("Cadastrar de Fornecedor");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
//Inicia o painel dos campos digitáveis        
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new FlowLayout());
        
        JLabel dtLabel = new JLabel("Data de cadastro");
        JTextField dtField = new JTextField(20);
        painelCadastro.add(dtLabel);
        painelCadastro.add(dtField);
        
        
        JLabel numLabel = new JLabel("Numero da Peça");
        JTextField numField = new JTextField(20);
        painelCadastro.add(numLabel);
        painelCadastro.add(numField);
        
        JLabel vlvLabel = new JLabel("Valor de Venda");
        JTextField vlvField= new JTextField(20);
        painelCadastro.add(vlvLabel);
        painelCadastro.add(vlvField);
        
        JLabel vlcLabel = new JLabel("Valor de Custo");
        JTextField vlcField = new JTextField(20);
        painelCadastro.add(vlcLabel);
        painelCadastro.add(vlcField);
        
        
        
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
				//Data de cadastro
				String data = dtField.getText();
				System.out.println(data);
				//Numero
				String numero =numField .getText();
				System.out.println(numero);
				//Valor venda
				String valor  =vlvField  .getText();
				System.out.println(valor);
				//valor custo
				String valorcusto  = vlcField .getText();
				System.out.println(valorcusto);
				
			
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
