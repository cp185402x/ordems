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
public class FornecedorView extends JFrame{
    
    public FornecedorView() { 
    	// construtor da view Fornecedor.
        super("Cadastro de Fornecedores");
        
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
        
        JLabel titulo = new JLabel("Cadastro de Fornecedores");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
        //Inicia o painel dos campos digitáveis        
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new FlowLayout());
        
        JLabel nomeLabel = new JLabel("Nome");
        JTextField nomeFieldfor = new JTextField(40);
        painelCadastro.add(nomeLabel);
        painelCadastro.add(nomeFieldfor);
        
        JLabel statuaLabel = new JLabel("Documento");
        JTextField tipoFielddocumento = new JTextField(20);
        painelCadastro.add(statuaLabel);
        painelCadastro.add(tipoFielddocumento);
        
        JLabel dataIniLabel = new JLabel("RG/IE");
        JTextField tipoFieldRGe = new JTextField(20);
        painelCadastro.add(dataIniLabel);
        painelCadastro.add(tipoFieldRGe);        
        
        JLabel usuarioLabel = new JLabel("Email");
        JTextField tipoFieldemail = new JTextField(40);
        painelCadastro.add(usuarioLabel);
        painelCadastro.add(tipoFieldemail);
        
        JLabel tipoLabel = new JLabel("Telefone fixo");
        JTextField tipoFieldtelf = new JTextField(10);
        painelCadastro.add(tipoLabel);
        painelCadastro.add(tipoFieldtelf);
        
        JLabel FinLabel = new JLabel("Celular");
        JTextField tipoFieldcel = new JTextField(10);
        painelCadastro.add(FinLabel);
        painelCadastro.add(tipoFieldcel);
        
        JLabel tipoLabel2 = new JLabel("Pessoa de contato");
        JTextField tipoFieldpes = new JTextField(20);
        painelCadastro.add(tipoLabel2);
        painelCadastro.add(tipoFieldpes);
        
        JLabel tipoLabel3 = new JLabel("CEP");
        JTextField tipoFieldCEP = new JTextField(10);
        painelCadastro.add(tipoLabel3);
        painelCadastro.add(tipoFieldCEP);
        
        JLabel tipoLabel4 = new JLabel("Endereço");
        JTextField tipoFieldEND = new JTextField(40);
        painelCadastro.add(tipoLabel4);
        painelCadastro.add(tipoFieldEND);
        
        JLabel garantiaLabel5 = new JLabel("Numero");
        JTextField tipoFieldnum = new JTextField(10);
        painelCadastro.add(garantiaLabel5);
        painelCadastro.add(tipoFieldnum);
        
        JLabel tipoLabel8 = new JLabel("Complemento");
        JTextField tipoFieldComp = new JTextField(20);
        painelCadastro.add(tipoLabel8);
        painelCadastro.add(tipoFieldComp);
        
        JLabel tipoLabel6 = new JLabel("Bairro");
        JTextField tipoFieldBai = new JTextField(20);
        painelCadastro.add(tipoLabel6);
        painelCadastro.add(tipoFieldBai);
        
        JLabel tipoLabel7 = new JLabel("Cidade");
        JTextField tipoFieldCid = new JTextField(20);
        painelCadastro.add(tipoLabel7);
        painelCadastro.add(tipoFieldCid);
        
        JLabel tipoLabel9 = new JLabel("Estado");
        JTextField tipoFieldEst = new JTextField(10);
        painelCadastro.add(tipoLabel9);
        painelCadastro.add(tipoFieldEst);
        
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

				String forn = nomeFieldfor.getText();
				System.out.println(forn);

				String email = tipoFieldemail.getText();
				System.out.println(email);

				String documento  =tipoFielddocumento  .getText();
				System.out.println(documento);

				String RGe  = tipoFieldRGe .getText();
				System.out.println(RGe);

				String cel   = tipoFieldcel .getText();
				System.out.println(cel);

				String telf   = tipoFieldtelf .getText();
				System.out.println(telf);

				String pes   = tipoFieldpes.getText();
				System.out.println(pes);

				String CEP   = tipoFieldCEP .getText();
				System.out.println(CEP);

				String  END  = tipoFieldEND .getText();
				System.out.println(END);

				String num  = tipoFieldnum .getText();
				System.out.println(num);

				String Bai =tipoFieldBai .getText();
				System.out.println(Bai);

				String Cid   =tipoFieldCid .getText();
				System.out.println(Cid);

				String Comp = tipoFieldComp .getText();
				System.out.println(Comp);

				String Est = tipoFieldEst .getText();
				System.out.println(Est);
			
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

