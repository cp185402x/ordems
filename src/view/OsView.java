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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
//Declarando a classe na janela
public class OsView extends JFrame implements ActionListener{
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JLabel titulo;
    JLabel clienteidLabel;
    JTextField cilenteidField;
    JLabel clientenomeLabel;
    JTextField cilentenomeField;
    JLabel usuarioLabel;
    JTextField usuarioField;
    JLabel dataprevisaoLabel;
    JTextField dataprevisaoField;
    JLabel dataprontoLabel;
    JTextField dataprontoField;
    JLabel dataentregaLabel;
    JTextField dataentregaField;
    JLabel tipoLabel;
    JTextField tipoField;
    JLabel modeloLabel;
    JTextField modeloField;
    JLabel marcaLabel;
    JTextField marcaField;
    JLabel corLabel;
    JTextField corField;
    JLabel serieLabel;
    JTextField serieField;
    JLabel garantiaLabel;
    JTextField garantiaField;
    JLabel infoclienteLabel;
    JTextArea infoclienteArea;
    JLabel infotecnicoLabel;
    JTextArea infotecnicoArea;
    JLabel infoentregaLabel;
    JTextArea infoentregaArea;
    JLabel infointernaLabel;
    JTextArea infointernaArea;
    
    //Inicia o painel dos botoes
    JPanel painelBotoes;
    JButton botaoSalvar;
    JButton botaoCancelar;

    
    public OsView() { 
    	// construtor da view Ordem.
        super("Cadastro de Ordens de Serviços");
        
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
        
        titulo = new JLabel("Cadastro de Ordens de Serviços");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
        //Inicia o painel dos campos digitáveis        
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new FlowLayout());
        
        clienteidLabel = new JLabel("ID Cliente");
        cilenteidField = new JTextField(6);
        painelCadastro.add(clienteidLabel);
        painelCadastro.add(cilenteidField);
        
        clientenomeLabel = new JLabel("Nome Cliente");
        cilentenomeField = new JTextField(40);
        painelCadastro.add(clientenomeLabel);
        painelCadastro.add(cilentenomeField);
        
        usuarioLabel = new JLabel("Id Usuário");
        usuarioField = new JTextField(6);
        painelCadastro.add(usuarioLabel);
        painelCadastro.add(usuarioField);
        
        dataprevisaoLabel = new JLabel("Data Prevista");
        dataprevisaoField = new JTextField(10);
        painelCadastro.add(dataprevisaoLabel);
        painelCadastro.add(dataprevisaoField);
        
        dataprontoLabel = new JLabel("Data Pronto");
        dataprontoField = new JTextField(10);
        painelCadastro.add(dataprontoLabel);
        painelCadastro.add(dataprontoField);
        
        dataentregaLabel = new JLabel("Data Entrega");
        dataentregaField = new JTextField(10);
        painelCadastro.add(dataentregaLabel);
        painelCadastro.add(dataentregaField);
        
        tipoLabel = new JLabel("Tipo Equipamento");
        tipoField = new JTextField(20);
        painelCadastro.add(tipoLabel);
        painelCadastro.add(tipoField);
        
        modeloLabel = new JLabel("Modelo");
        modeloField = new JTextField(20);
        painelCadastro.add(modeloLabel);
        painelCadastro.add(modeloField);
        
        marcaLabel = new JLabel("Marca");
        marcaField = new JTextField(20);
        painelCadastro.add(marcaLabel);
        painelCadastro.add(marcaField);
        
        corLabel = new JLabel("Cor");
        corField = new JTextField(10);
        painelCadastro.add(corLabel);
        painelCadastro.add(corField);
        
        serieLabel = new JLabel("N/S");
        serieField = new JTextField(10);
        painelCadastro.add(serieLabel);
        painelCadastro.add(serieField);
        
        garantiaLabel = new JLabel("Garantia");
        garantiaField = new JTextField(4);
        painelCadastro.add(garantiaLabel);
        painelCadastro.add(garantiaField);
        
        infoclienteLabel = new JLabel("Informações do cliente");
        infoclienteArea = new JTextArea(4, 40);
        //infoclienteField = new JTextField(4);
        painelCadastro.add(infoclienteLabel);
        painelCadastro.add(infoclienteArea);
        
        infotecnicoLabel = new JLabel("Informações do técnico");
        infotecnicoArea = new JTextArea(4, 40);
        painelCadastro.add(infotecnicoLabel);
        painelCadastro.add(infotecnicoArea);
        
        infoentregaLabel = new JLabel("Informações da entrega");
        infoentregaArea = new JTextArea(4, 40);
        painelCadastro.add(infoentregaLabel);
        painelCadastro.add(infoentregaArea);
        
        infointernaLabel = new JLabel("Informações interna");
        infointernaArea = new JTextArea(4, 40);
        painelCadastro.add(infointernaLabel);
        painelCadastro.add(infointernaArea);
        
        
        
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
/*
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
*/
			
			}
        	
        });
        
        botaoCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("cliquei no botao cancelar");
			}
        	
        });
        //Adicionando os paineis em suas respectivas posições        
        add(painelTitulo, BorderLayout.NORTH);
        add(painelCadastro, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
        
    }
    

}
