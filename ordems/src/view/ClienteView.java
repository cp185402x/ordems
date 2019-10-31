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
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

import controller.ClienteController;
import model.Cliente;

//Declarando a classe na janela
public class ClienteView extends JFrame implements ActionListener{
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JLabel titulo;
	
    JLabel nm_clienteLabel;
    JTextField nm_clienteField;
    
    JLabel dataNascLabel;
    JTextField dataNascField;
    
    JTextField docField;
    
    JLabel rgieLabel;
    JTextField rgieField;

    JLabel celularLabel;
    JTextField celularField;
    
    JLabel fone_reLabel;
    JTextField fone_reField;
        
    JLabel emailLabel;
    JTextField emailField;
    
    JLabel pes_contatoLabel;
    JTextField pes_contatoField;
    
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
    
    private JTable clienteTable;
    private JTextField buscarField;

	public ClienteView() { // construtor da view Cliente.
        super("Cadastro de Clientes");
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
        painelTitulo = new JPanel();
        painelTitulo.setLayout(new FlowLayout());
        
        titulo = new JLabel("Cadastro de Cliente");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
        //Inicia o painel dos campos digitáveis        
        painelCadastro = new JPanel();
        
        //Inicia o painel dos botoes
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        
        botaoSalvar = new JButton("Salvar");
        botaoCancelar = new JButton("Cancelar");
        
        getContentPane().add(painelCadastro, BorderLayout.WEST);
        
        JPanel clientePainel = new JPanel();
        clientePainel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        clientePainel.setLayout(null);
        
        pes_contatoField = new JTextField(20);
        pes_contatoField.setBounds(368, 138, 186, 20);
        clientePainel.add(pes_contatoField);        
        pes_contatoLabel = new JLabel("Pessoa de Contato");
        pes_contatoLabel.setBounds(368, 126, 166, 14);
        clientePainel.add(pes_contatoLabel);
        
        emailField = new JTextField(40);
        emailField.setBounds(10, 138, 338, 20);
        clientePainel.add(emailField);        
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 126, 368, 14);
        clientePainel.add(emailLabel);
        
        JRadioButton cpfRadio = new JRadioButton("CPF");
        cpfRadio.setHorizontalAlignment(SwingConstants.RIGHT);
        cpfRadio.setBounds(6, 7, 50, 23);
        clientePainel.add(cpfRadio);
        
        JRadioButton cnpjRadio = new JRadioButton("CNPJ");
        cnpjRadio.setHorizontalAlignment(SwingConstants.RIGHT);
        cnpjRadio.setBounds(58, 7, 56, 23);
        clientePainel.add(cnpjRadio);
        
        docField = new JTextField(20);
        docField.setBounds(114, 8, 199, 20);
        clientePainel.add(docField);
        
        rgieLabel = new JLabel("RG/IE");
        rgieLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        rgieLabel.setBounds(318, 11, 50, 14);
        clientePainel.add(rgieLabel);
        rgieField = new JTextField(20);
        rgieField.setBounds(368, 8, 186, 20);
        clientePainel.add(rgieField);
        
        nm_clienteLabel = new JLabel("Nome");
        nm_clienteLabel.setBounds(10, 37, 338, 14);
        clientePainel.add(nm_clienteLabel);
        nm_clienteField = new JTextField(40);
        nm_clienteField.setBounds(10, 51, 338, 20);
        clientePainel.add(nm_clienteField);
        
        dataNascField = new JTextField(20);
        dataNascField.setBounds(368, 51, 186, 20);
        clientePainel.add(dataNascField);        
        dataNascLabel = new JLabel("Data Nascimento");
        dataNascLabel.setBounds(368, 36, 156, 14);
        clientePainel.add(dataNascLabel);
               
        fone_reField = new JTextField(20);
        fone_reField.setBounds(10, 95, 166, 20);
        clientePainel.add(fone_reField);        
        JLabel fone_reLabel = new JLabel("Fone Fixo");
        fone_reLabel.setBounds(10, 82, 166, 14);
        clientePainel.add(fone_reLabel);
        
        celularField = new JTextField(20);
        celularField.setBounds(186, 95, 162, 20);
        clientePainel.add(celularField);        
        celularLabel = new JLabel("Celular");
        celularLabel.setBounds(186, 82, 162, 14);
        clientePainel.add(celularLabel);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel.setLayout(null); 
        
        cepField = new JTextField(10);
        cepField.setBounds(10, 25, 86, 20);
        panel.add(cepField);        
        cepLabel = new JLabel("CEP");
        cepLabel.setBounds(10, 11, 86, 14);
        panel.add(cepLabel);
        
        enderecoField = new JTextField(40);
        enderecoField.setBounds(106, 25, 369, 20);
        panel.add(enderecoField);        
        enderecoLabel = new JLabel("Endereço");
        enderecoLabel.setBounds(106, 11, 369, 14);
        panel.add(enderecoLabel);
        
        numeroField = new JTextField(10);
        numeroField.setBounds(485, 25, 65, 20);
        panel.add(numeroField);        
        numeroLabel = new JLabel("Número");
        numeroLabel.setBounds(485, 11, 45, 14);
        panel.add(numeroLabel);
        
        complementoField = new JTextField(20);
        complementoField.setBounds(10, 69, 127, 20);
        panel.add(complementoField);        
        complementoLabel = new JLabel("Complemento");
        complementoLabel.setBounds(10, 56, 127, 14);
        panel.add(complementoLabel);
        
        bairroField = new JTextField(20);
        bairroField.setBounds(147, 69, 166, 20);
        panel.add(bairroField);               
        bairroLabel = new JLabel("Bairro");
        bairroLabel.setBounds(147, 56, 166, 14);
        panel.add(bairroLabel);
        
        cidadeField = new JTextField(20);
        cidadeField.setBounds(323, 69, 152, 20);
        panel.add(cidadeField);        
        cidadeLabel = new JLabel("Cidade");
        cidadeLabel.setBounds(323, 56, 166, 14);
        panel.add(cidadeLabel);
        
        estadoLabel = new JLabel("Estado");
        estadoLabel.setBounds(485, 56, 45, 14);
        panel.add(estadoLabel);
        estadoField = new JTextField(10);
        estadoField.setBounds(485, 69, 65, 20);
        panel.add(estadoField);
        
        //Criando a Tabela com os dados do banco
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(Color.LIGHT_GRAY));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        JButton editarBtn = new JButton("Editar");
        
        JButton excluirBtn = new JButton("Excluir");
        
        buscarField = new JTextField();
        buscarField.setBackground(new Color(250, 250, 210));
        buscarField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buscarField.setColumns(10);
        
        JButton buscarBtn = new JButton("Buscar");
        
        GroupLayout gl_painelCadastro = new GroupLayout(painelCadastro);
        
        gl_painelCadastro.setHorizontalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        				.addComponent(clientePainel, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        						.addGroup(Alignment.TRAILING, gl_painelCadastro.createSequentialGroup()
        							.addComponent(buscarField, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
        							.addGap(18)
        							.addComponent(buscarBtn)
        							.addGap(18)
        							.addComponent(editarBtn)
        							.addGap(18)
        							.addComponent(excluirBtn)))))
        			.addGap(97))
        );
        gl_painelCadastro.setVerticalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(clientePainel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.BASELINE)
        				.addComponent(buscarField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(excluirBtn)
        				.addComponent(editarBtn)
        				.addComponent(buscarBtn))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        
        clienteTable = new JTable();
        clienteTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Cod", "Nome", "Documento", "Celular", "E-Mail"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		Integer.class, String.class, String.class, String.class, Object.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        clienteTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        clienteTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        clienteTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        clienteTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        clienteTable.getColumnModel().getColumn(4).setPreferredWidth(200);
        scrollPane.setViewportView(clienteTable);
        
        painelCadastro.setLayout(gl_painelCadastro);
        
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
        
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);
        
        botaoSalvar.addActionListener(this);
        botaoSalvar.setActionCommand("salvar");
        botaoCancelar.addActionListener(this);
        botaoCancelar.setActionCommand("cancelar");

    }
    
    
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("salvar")) {
			Cliente c = new Cliente();
			
			//Tratar a ação de salvar o cliente
			
			//nome
			c.setNm_cliente(nm_clienteField.getText());			
			//documento
			c.setDoc_num(docField.getText());			
			//RGIE
			c.setRg_ie(rgieField.getText());
			//fone fixo
			c.setFone_re(fone_reField.getText());
			//celular
			c.setCelular(celularField.getText());
			//email
			c.setEmail(emailField.getText());
			//pessoa contato
			c.setPes_contato(pes_contatoField.getText());
			//endereço
			//c.setEndereco(enderecoField .getText());
			//numero
			//c.setNumero(numeroField .getText());
			//complemento
			//c.setComplemento(complementoField .getText());
			//bairro
			//c.setBairro(bairroField .getText());
			//cidade
			//c.setCidade(cidadeField .getText());
			//estado
			//c.setEstado(estadoField .getText());
			
			
			ClienteController controleCliente = new ClienteController();
			try {
				if(controleCliente.cadastrarCliente(c) == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro!");
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("cancelar")) {
 
			dispose();
		}
	}
}

