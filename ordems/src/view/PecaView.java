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
        super("Cadastro de peças");
        
        criaFormulario();
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(580, 600);
    	this.setVisible(true);
    	this.setLocationRelativeTo(null);

    }
    
    private void criaFormulario() {
        
        setLayout(new BorderLayout());
        
//Inicia o painel de título        
        JPanel painelTitulo = new JPanel();
        painelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel("Cadastrar de peças");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
//Inicia o painel dos campos digitáveis        
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new FlowLayout());
        
        
        JLabel nomeLabel = new JLabel("Nome da Peça");
        JTextField nomeField = new JTextField(40);
        painelCadastro.add(nomeLabel);
        painelCadastro.add(nomeField);
        
        JLabel vlcLabel = new JLabel("Valor de Custo");
        JTextField vlcField = new JTextField(10);
        painelCadastro.add(vlcLabel);
        painelCadastro.add(vlcField);
        
        JLabel vlvLabel = new JLabel("Valor de Venda");
        JTextField vlvField= new JTextField(10);
        painelCadastro.add(vlvLabel);
        painelCadastro.add(vlvField);
        
        
        
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
				System.out.println("Cliquei no botao salvar");
				//Numero
				String nm_peca =nomeField .getText();
				System.out.println(nm_peca);
				//valor custo
				String valorcusto  = vlcField .getText();
				System.out.println(valorcusto);
				//Valor venda
				String valorVenda  =vlvField  .getText();
				System.out.println(valorVenda);
				
			
			}
        	
        });
        
        botaoCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 
				dispose();
			}
        	
        });
//Adicionando os paineis em suas respectivas posições        
        add(painelTitulo, BorderLayout.NORTH);
        add(painelCadastro, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
        
    }
    

}
