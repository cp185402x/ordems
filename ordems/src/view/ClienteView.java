package view;

//Importando os componentes
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

import controller.ClienteController;
import model.Cliente;
import model.TabelaCliente;

//Declarando a classe na janela
public class ClienteView extends JFrame implements ActionListener{
	//atributo para controle
	private int id;
	
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JLabel titulo;
	
	JRadioButton cnpjRadio;
	JRadioButton cpfRadio;
	ButtonGroup tipoGrupo;
	
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
    JButton botaoEditar;
    JButton botaoExcluir;
    
    private JTable clienteTable;
    private TabelaCliente tabelaCliente;
    
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
        pes_contatoField.setBounds(447, 137, 186, 20);
        clientePainel.add(pes_contatoField);        
        pes_contatoLabel = new JLabel("Pessoa de Contato");
        pes_contatoLabel.setBounds(447, 125, 166, 14);
        clientePainel.add(pes_contatoLabel);
        
        emailField = new JTextField(40);
        emailField.setBounds(10, 138, 427, 20);
        clientePainel.add(emailField);        
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 126, 368, 14);
        clientePainel.add(emailLabel);
        
        cpfRadio = new JRadioButton("CPF");
        cpfRadio.setSelected(true);
        cpfRadio.setHorizontalAlignment(SwingConstants.RIGHT);
        cpfRadio.setBounds(6, 7, 50, 23);
        clientePainel.add(cpfRadio);        
        cnpjRadio = new JRadioButton("CNPJ");
        cnpjRadio.setHorizontalAlignment(SwingConstants.RIGHT);
        cnpjRadio.setBounds(58, 7, 56, 23);
        clientePainel.add(cnpjRadio);
        tipoGrupo = new ButtonGroup();
        
        tipoGrupo.add(cpfRadio);
        tipoGrupo.add(cnpjRadio);
        
        
        docField = new JTextField(20);
        docField.setBounds(114, 8, 199, 20);
        clientePainel.add(docField);
        
        rgieLabel = new JLabel("RG/IE");
        rgieLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        rgieLabel.setBounds(323, 10, 50, 14);
        clientePainel.add(rgieLabel);
        rgieField = new JTextField(20);
        rgieField.setBounds(373, 7, 186, 20);
        clientePainel.add(rgieField);
        
        nm_clienteLabel = new JLabel("Nome");
        nm_clienteLabel.setBounds(10, 37, 338, 14);
        clientePainel.add(nm_clienteLabel);
        nm_clienteField = new JTextField(40);
        nm_clienteField.setBounds(10, 51, 427, 20);
        clientePainel.add(nm_clienteField);
        
        dataNascField = new JTextField(20);
        dataNascField.setBounds(447, 50, 186, 20);
        clientePainel.add(dataNascField);        
        dataNascLabel = new JLabel("Data Nascimento");
        dataNascLabel.setBounds(447, 35, 156, 14);
        clientePainel.add(dataNascLabel);
               
        fone_reField = new JTextField(20);
        fone_reField.setBounds(10, 95, 186, 20);
        clientePainel.add(fone_reField);        
        JLabel fone_reLabel = new JLabel("Fone Fixo");
        fone_reLabel.setBounds(10, 82, 166, 14);
        clientePainel.add(fone_reLabel);
        
        celularField = new JTextField(20);
        celularField.setBounds(206, 95, 186, 20);
        clientePainel.add(celularField);        
        celularLabel = new JLabel("Celular");
        celularLabel.setBounds(206, 82, 162, 14);
        clientePainel.add(celularLabel);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel.setLayout(null); 
        
        cepField = new JTextField(10);
        cepField.setBounds(10, 25, 155, 20);
        panel.add(cepField);        
        cepLabel = new JLabel("CEP");
        cepLabel.setBounds(10, 11, 86, 14);
        panel.add(cepLabel);
        
        enderecoField = new JTextField(40);
        enderecoField.setBounds(175, 25, 369, 20);
        panel.add(enderecoField);        
        enderecoLabel = new JLabel("Endereço");
        enderecoLabel.setBounds(175, 11, 369, 14);
        panel.add(enderecoLabel);
        
        numeroField = new JTextField(10);
        numeroField.setBounds(554, 25, 79, 20);
        panel.add(numeroField);        
        numeroLabel = new JLabel("Número");
        numeroLabel.setBounds(554, 11, 65, 14);
        panel.add(numeroLabel);
        
        complementoField = new JTextField(20);
        complementoField.setBounds(10, 69, 155, 20);
        panel.add(complementoField);        
        complementoLabel = new JLabel("Complemento");
        complementoLabel.setBounds(10, 56, 127, 14);
        panel.add(complementoLabel);
        
        bairroField = new JTextField(20);
        bairroField.setBounds(175, 69, 180, 20);
        panel.add(bairroField);               
        bairroLabel = new JLabel("Bairro");
        bairroLabel.setBounds(175, 56, 166, 14);
        panel.add(bairroLabel);
        
        cidadeField = new JTextField(20);
        cidadeField.setBounds(365, 69, 179, 20);
        panel.add(cidadeField);        
        cidadeLabel = new JLabel("Cidade");
        cidadeLabel.setBounds(365, 56, 166, 14);
        panel.add(cidadeLabel);
        
        estadoLabel = new JLabel("Estado");
        estadoLabel.setBounds(554, 56, 65, 14);
        panel.add(estadoLabel);
        estadoField = new JTextField(10);
        estadoField.setBounds(554, 69, 79, 20);
        panel.add(estadoField);
        
        //Criando a Tabela com os dados do banco
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(Color.LIGHT_GRAY));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        
        botaoEditar = new JButton("Editar");
        
        botaoExcluir = new JButton("Excluir");
        
        
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
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        				.addGroup(Alignment.TRAILING, gl_painelCadastro.createSequentialGroup()
        					.addComponent(buscarField, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
        					.addGap(18)
        					.addComponent(buscarBtn)
        					.addGap(18)
        					.addComponent(botaoEditar)
        					.addGap(18)
        					.addComponent(botaoExcluir))
        				.addComponent(clientePainel, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE))
        			.addGap(18))
        );
        gl_painelCadastro.setVerticalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(clientePainel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.BASELINE)
        				.addComponent(buscarField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(botaoExcluir)
        				.addComponent(botaoEditar)
        				.addComponent(buscarBtn))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );

        //fazendo a ligação do modelo de tabela com o componente visual de janela
        tabelaCliente = new TabelaCliente();
        clienteTable = new JTable(tabelaCliente);
        
             
        scrollPane.setViewportView(clienteTable);
        
        painelCadastro.setLayout(gl_painelCadastro);
        
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
        
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);
        
        botaoSalvar.addActionListener(this);
        botaoSalvar.setActionCommand("salvar");
        botaoCancelar.addActionListener(this);
        botaoCancelar.setActionCommand("cancelar");
        botaoExcluir.addActionListener(this);
        botaoExcluir.setActionCommand("excluir");
        botaoEditar.addActionListener(this);
        botaoEditar.setActionCommand("editar");
        

    }
    
    
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("salvar")) {
			
			Cliente c = new Cliente();
			
			//Tratar a ação de salvar o cliente
			
			//Trata o radio do tipo de cliente
			if(cpfRadio.isSelected()) {
				c.setTipo(0);
			}
			else {
				c.setTipo(1);
			}
			//Tipo
			System.out.println("Tipo: " +c.getTipo());
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
			//Logradouro
			c.getEndereco().setCep(cepField.getText());
			//Logradouro
			c.getEndereco().setLogradouro(enderecoField.getText());
			//numero
			c.getEndereco().setNumero(numeroField.getText());
			//complemento
			c.getEndereco().setComplemento(complementoField.getText());
			//bairro
			c.getEndereco().setBairro(bairroField.getText());
			//cidade
			c.getEndereco().setCidade(cidadeField.getText());
			//estado
			c.getEndereco().setEstado(estadoField.getText());
			
			Object[] opcoes = {"Salvar como novo cadastro", "Atualizar", "Limpar todos campos"};
			
			int op = JOptionPane.showOptionDialog(null, "Escolha uma opção para continuar", "Aviso",
		          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		              null, opcoes, opcoes[0]);
			
			if(op == 0) { //salvar um novo cliente
				ClienteController controleCliente = new ClienteController();
				try {
					if(controleCliente.cadastrarCliente(c) == true) {
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
						tabelaCliente.addTodos();
						this.repaint();
					}
					}
				 catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ops, houve um erro ao efetuar o cadastro!");
				}
			}
			else if(op == 1) { //ATUALIZAR O CLIENTE
				c.setId(this.id);
				ClienteController controleCliente = new ClienteController();
				try {
					if(controleCliente.atualizarCliente(c) == true) {
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
						tabelaCliente.addTodos();
						this.repaint();
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ops, houve um ao efetuar o cadastro!");
				}				
				
			}
			else {
				cpfRadio.setEnabled(true);
				
				
				nm_clienteField.setText("");
				docField.setText("");
				rgieField.setText("");
				fone_reField.setText("");			
				celularField.setText("");
				emailField.setText("");
				pes_contatoField.setText("");
				cepField.setText("");
				enderecoField.setText("");
				numeroField.setText("");
				complementoField.setText("");
				bairroField.setText("");
				cidadeField.setText("");
				estadoField.setText("");
				
			}
	
	}
	else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
	
			dispose();
	}
	else if(e.getActionCommand().equals("excluir")) {
		//tratar a exclusão
		int linha = clienteTable.getSelectedRow();
		Cliente c = tabelaCliente.getCliente(linha);
		
		ClienteController controleCliente = new ClienteController();
		try {
			controleCliente.removerCliente(c.getId());
			JOptionPane.showMessageDialog(null, " Cadastro excluído com sucesso!");
			tabelaCliente.addTodos();
			this.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclusão");
		}
		
		
	}
	else if(e.getActionCommand().equals("editar")) {
		JOptionPane.showMessageDialog(null, "Deseja realmente editar o cadastro?");
		int linha = clienteTable.getSelectedRow();
		Cliente c = tabelaCliente.getCliente(linha);
		
		//preencher os campos com os dados do cliente selecionado
		if(c.getTipo() == 0) cpfRadio.setEnabled(true);
		else cnpjRadio.setEnabled(true);
		
		this.id =c.getId(); 
		nm_clienteField.setText(c.getNm_cliente());
		docField.setText(c.getDoc_num());
		rgieField.setText(c.getRg_ie());
		fone_reField.setText(c.getFone_re());			
		celularField.setText(c.getCelular());
		emailField.setText(c.getEmail());
		pes_contatoField.setText(c.getPes_contato());
		cepField.setText(c.getEndereco().getCep());
		enderecoField.setText(c.getEndereco().getLogradouro());
		numeroField.setText(c.getEndereco().getNumero());
		complementoField.setText(c.getEndereco().getComplemento());
		bairroField.setText(c.getEndereco().getBairro());
		cidadeField.setText(c.getEndereco().getCidade());
		estadoField.setText(c.getEndereco().getEstado());
		
		
	
		
	}
		
	}
}
//

