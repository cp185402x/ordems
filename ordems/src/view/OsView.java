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
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
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
    private JTable table;
    private JTextField textField;

    
    public OsView() { 
    	// construtor da view Ordem.
        super("Cadastro de Ordens de Serviços");
        setResizable(false);
        setType(Type.UTILITY);
        
        criaFormulario();
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(680, 600);
    	this.setVisible(true);
    	this.setLocationRelativeTo(null);

    }
    
    private void criaFormulario() {
        
        getContentPane().setLayout(new BorderLayout());
        
        //Inicia o painel de título        
        JPanel painelTitulo = new JPanel();
        painelTitulo.setLayout(new FlowLayout());
        
        titulo = new JLabel("Ordens de Servi\u00E7os");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
        //Inicia o painel dos campos digitáveis        
        JPanel painelCadastro = new JPanel();
        
        clienteidLabel = new JLabel("ID Cliente");
        cilenteidField = new JTextField(6);
        
        clientenomeLabel = new JLabel("Nome do Cliente");
        cilentenomeField = new JTextField(40);
        
        usuarioLabel = new JLabel("Usu\u00E1rio");
        usuarioField = new JTextField(6);
        
        dataprevisaoLabel = new JLabel("Data Prevista");
        dataprevisaoField = new JTextField(10);
        
        dataprontoLabel = new JLabel("Data Pronto");
        dataprontoField = new JTextField(10);
        
        dataentregaLabel = new JLabel("Data Entrega");
        dataentregaField = new JTextField(10);
        
        tipoLabel = new JLabel("Tipo Equipamento");
        tipoField = new JTextField(20);
        
        modeloLabel = new JLabel("Modelo");
        modeloField = new JTextField(20);
        
        marcaLabel = new JLabel("Marca");
        marcaField = new JTextField(20);
        
        corLabel = new JLabel("Cor");
        corField = new JTextField(10);
        
        serieLabel = new JLabel("N/S");
        serieField = new JTextField(10);
        
        garantiaLabel = new JLabel("Garantia");
        garantiaField = new JTextField(4);
        
        infoclienteLabel = new JLabel("Informações do cliente");
        infoclienteArea = new JTextArea(4, 40);
        infoclienteArea.setEditable(false);
        
        infotecnicoLabel = new JLabel("Informações do técnico");
        infotecnicoArea = new JTextArea(4, 40);
        infotecnicoArea.setEditable(false);
        
        infoentregaLabel = new JLabel("Informações da entrega");
        infoentregaArea = new JTextArea(4, 40);
        infoentregaArea.setEditable(false);
        
        infointernaLabel = new JLabel("Informações interna");
        infointernaArea = new JTextArea(4, 40);
        infointernaArea.setEditable(false);
        
        
        
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
				
				dispose();
			}
        	
        });
        //Adicionando os paineis em suas respectivas posições        
        getContentPane().add(painelTitulo, BorderLayout.NORTH);
        getContentPane().add(painelCadastro, BorderLayout.EAST);
        
        JScrollPane scrollPane = new JScrollPane();
        
        JButton button = new JButton("Excluir");
        
        JButton button_1 = new JButton("Editar");
        
        JButton btnBuscar = new JButton("Buscar");
        
        textField = new JTextField();
        textField.setForeground(SystemColor.info);
        textField.setColumns(10);
        GroupLayout gl_painelCadastro = new GroupLayout(painelCadastro);
        gl_painelCadastro.setHorizontalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        				.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        					.addGap(23)
        					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        						.addComponent(cilenteidField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(clienteidLabel))
        					.addGap(20)
        					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        						.addComponent(clientenomeLabel, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
        						.addComponent(cilentenomeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(10)
        					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        						.addComponent(usuarioField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(usuarioLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        					.addGap(23)
        					.addComponent(tipoLabel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
        					.addGap(15)
        					.addComponent(modeloLabel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
        					.addGap(10)
        					.addComponent(marcaLabel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
        					.addGap(11)
        					.addComponent(corLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
        				.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        					.addGap(23)
        					.addComponent(tipoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(13)
        					.addComponent(modeloField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(10)
        					.addComponent(marcaField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
        					.addGap(47)
        					.addComponent(corField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        					.addGap(23)
        					.addComponent(dataprevisaoLabel)
        					.addGap(31)
        					.addComponent(dataprontoLabel)
        					.addGap(38)
        					.addComponent(dataentregaLabel)
        					.addGap(32)
        					.addComponent(serieLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
        					.addGap(7)
        					.addComponent(garantiaLabel))
        				.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        					.addGap(23)
        					.addComponent(dataprevisaoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(10)
        					.addComponent(dataprontoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(10)
        					.addComponent(dataentregaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(10)
        					.addComponent(serieField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(10)
        					.addComponent(garantiaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        					.addGap(10)
        					.addComponent(infoclienteLabel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
        					.addGap(19)
        					.addComponent(infotecnicoLabel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
        				.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        					.addGap(10)
        					.addComponent(infoclienteArea, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
        					.addComponent(infotecnicoArea, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
        				.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_painelCadastro.createSequentialGroup()
        							.addContainerGap()
        							.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        								.addComponent(infointernaArea, 0, 0, Short.MAX_VALUE)))
        						.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        							.addGap(10)
        							.addComponent(infointernaLabel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)))
        					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_painelCadastro.createSequentialGroup()
        							.addGap(19)
        							.addComponent(infoentregaLabel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
        						.addGroup(Alignment.TRAILING, gl_painelCadastro.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
        							.addComponent(btnBuscar)
        							.addGap(18)
        							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(button, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
        							.addGap(80))
        						.addGroup(gl_painelCadastro.createSequentialGroup()
        							.addGap(18)
        							.addComponent(infoentregaArea, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 625, GroupLayout.PREFERRED_SIZE)))
        			.addGap(25))
        );
        gl_painelCadastro.setVerticalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addGap(8)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_painelCadastro.createSequentialGroup()
        					.addGap(13)
        					.addComponent(cilenteidField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(clienteidLabel)
        				.addComponent(clientenomeLabel)
        				.addGroup(gl_painelCadastro.createSequentialGroup()
        					.addGap(13)
        					.addComponent(cilentenomeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_painelCadastro.createSequentialGroup()
        					.addGap(13)
        					.addComponent(usuarioField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(usuarioLabel))
        			.addGap(11)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addComponent(tipoLabel)
        				.addComponent(modeloLabel)
        				.addComponent(marcaLabel)
        				.addComponent(corLabel))
        			.addGap(1)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_painelCadastro.createSequentialGroup()
        					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        						.addComponent(tipoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(modeloField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(marcaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(11)
        					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        						.addComponent(dataprevisaoLabel)
        						.addComponent(dataprontoLabel)
        						.addComponent(dataentregaLabel)
        						.addComponent(serieLabel)
        						.addComponent(garantiaLabel))
        					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        						.addComponent(dataprevisaoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(dataprontoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(dataentregaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(serieField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(garantiaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(corField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(11)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addComponent(infoclienteLabel)
        				.addComponent(infotecnicoLabel))
        			.addGap(3)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addComponent(infotecnicoArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(infoclienteArea))
        			.addGap(11)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addComponent(infointernaLabel)
        				.addComponent(infoentregaLabel))
        			.addGap(3)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.BASELINE)
        				.addComponent(infointernaArea)
        				.addComponent(infoentregaArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18, 18, Short.MAX_VALUE)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, gl_painelCadastro.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btnBuscar)
        					.addComponent(button_1)
        					.addComponent(button))
        				.addComponent(textField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(6)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        			.addGap(9))
        );
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, "", "", "Info Tecnico"},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"ID OS", "Data Entrada", "Cliente", "Modelo", "Info Cliente", "Info Tecnico"
        	}
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(47);
        table.getColumnModel().getColumn(2).setPreferredWidth(216);
        table.getColumnModel().getColumn(4).setPreferredWidth(235);
        table.getColumnModel().getColumn(5).setPreferredWidth(211);
        scrollPane.setViewportView(table);
        painelCadastro.setLayout(gl_painelCadastro);
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
        
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
