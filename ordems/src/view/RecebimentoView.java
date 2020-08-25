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
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

import controller.OsController;
import model.Cliente;
import model.Os;
import model.Recebimento;
import model.TabelaCliente;
import model.TabelaOs;

//Declarando a classe na janela
public class RecebimentoView extends JFrame implements ActionListener{
	
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JPanel equipamentoPanel;
	JPanel clientePainel;
	JLabel titulo;
    
    JLabel 		cliente_idLabel;
    JTextField 	cilente_idField;
    
    JLabel 		nm_clienteLabel;
    JTextField 	nm_cilenteField;
    
    JLabel 		usuario_idLabel;
    JTextField 	usuario_idField;

    //Inicia o painel dos botoes
    JPanel painelBotoes;
    JButton botaoSalvar;
    JButton botaoCancelar;
    JButton botaoEditar;
    JButton botaoExcluir;
    
    private Recebimento recebimento;
	private Cliente cliente;
	
	public RecebimentoView(Cliente c) { // construtor da view OS.
		super("Recebimentos");
        setType(Type.UTILITY);
        
        this.cliente = c;
        
        criaFormulario();
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(780, 600);
    	this.setVisible(true);
    	this.setLocationRelativeTo(null);
    }
    
    public RecebimentoView() {
		// TODO Auto-generated constructor stub
	}

	private void criaFormulario() {
    	
        getContentPane().setLayout(new BorderLayout());
        
        //Inicia o painel de título    
        painelTitulo = new JPanel();
        painelTitulo.setLayout(new FlowLayout());
        
        titulo = new JLabel("Cadastro de Recebimentos");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
        //Inicia o painel dos campos digitáveis        
        painelCadastro = new JPanel();
        
        //Inicia o painel dos botoes
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        
        botaoSalvar = new JButton("Salvar");
        botaoCancelar = new JButton("Cancelar");
        botaoExcluir = new JButton("Excluir");
        botaoEditar = new JButton("Editar");
        
        getContentPane().add(painelCadastro, BorderLayout.WEST);
        
        clientePainel = new JPanel();
        clientePainel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        clientePainel.setLayout(null);
        
        equipamentoPanel = new JPanel();
        equipamentoPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        equipamentoPanel.setLayout(null);
        
        
        cliente_idLabel = new JLabel("ID Cliente");
        cliente_idLabel.setBounds(10, 11, 47, 14);        
        cilente_idField = new JTextField(6);
        clientePainel.add(cliente_idLabel);
        cilente_idField.setBounds(10, 24, 64, 20);
        
        clientePainel.add(cilente_idField);
        
        nm_clienteLabel = new JLabel("Nome do Cliente");
        nm_clienteLabel.setBounds(84, 11, 326, 14);        
        nm_cilenteField = new JTextField(40);
        clientePainel.add(nm_clienteLabel);
        nm_cilenteField.setBounds(84, 24, 326, 20);
        clientePainel.add(nm_cilenteField);
        
        //Verifica se existe cliente cadastrado
        if(this.cliente != null) {
			cilente_idField.setText(""+cliente.getId());
			nm_cilenteField.setText(cliente.getNm_cliente());
		}
        
        usuario_idLabel = new JLabel("Usuário");
        usuario_idLabel.setBounds(504, 11, 99, 14);        
        usuario_idField = new JTextField(6);
        clientePainel.add(usuario_idLabel);
        usuario_idField.setBounds(504, 24, 99, 20);
        clientePainel.add(usuario_idField);
        
        //Criando a Tabela com os dados do banco
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(Color.LIGHT_GRAY));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        GroupLayout gl_painelCadastro = new GroupLayout(painelCadastro);
        gl_painelCadastro.setHorizontalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        				.addGroup(gl_painelCadastro.createSequentialGroup()
        					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_painelCadastro.createSequentialGroup()
        							.addComponent(clientePainel, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        							.addGap(80))
        						.addComponent(equipamentoPanel, GroupLayout.PREFERRED_SIZE, 641, GroupLayout.PREFERRED_SIZE))
        					.addContainerGap(20, Short.MAX_VALUE))))
        );
        gl_painelCadastro.setVerticalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(clientePainel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(equipamentoPanel, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        			.addContainerGap())
        );
        
        

       
        //fazendo a ligação do modelo de tabela com o componente visual de janela
        tabelaOs = new TabelaOs();
        osTable = new JTable(tabelaOs);
        
             
        scrollPane.setViewportView(osTable);
        
        painelCadastro.setLayout(gl_painelCadastro);
        
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
        
        painelBotoes.add(botaoSalvar);        
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);
        painelBotoes.add(botaoCancelar);
        
        //adicionando as ações
        botaoSalvar.addActionListener(this);
        botaoSalvar.setActionCommand("salvar");
		
        botaoEditar.addActionListener(this);
        botaoEditar.setActionCommand("editar");
		
        botaoExcluir.addActionListener(this);
        botaoExcluir.setActionCommand("excluir");
		
        botaoCancelar.addActionListener(this);
        botaoCancelar.setActionCommand("cancelar");
    }
    
    //método para limpar tela
    private void limpaCampos() {
    	cilente_idField.setText("");
		nm_cilenteField.setText("");
		usuario_idField.setText("");
		
		this.painelCadastro.repaint();
		this.equipamentoPanel.repaint();
    }

    //tratando as ações
	public void actionPerformed(ActionEvent e) {		 
			
		 if(e.getActionCommand().equalsIgnoreCase("salvar")) {
			 
				Os o = new Os();
				
				//Tipo de equipamento
				o.setTipo(tipoField.getText());			
				//modelo
				o.setModelo(modeloField.getText());			
				//marca
				o.setMarca(marcaField.getText());
				o.setCliente(cliente);
				
				
				Object[] opcoes = {"Salvar como novo cadastro", "Atualizar", "Limpar todos campos"};
				
				int op = JOptionPane.showOptionDialog(null, "Escolha uma opção para continuar", "Aviso",
			          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			              null, opcoes, opcoes[0]);
				
				if(op == 0) { //Salvar nova OS
					
					OsController controleOs = new OsController();
					try {
						if(controleOs.cadastrarOs(o) == true) {
							tabelaOs.addTodos();
							limpaCampos();
						}
						}
					 catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ops, houve um erro ao efetuar o cadastro!");
					}
					
				}
				else if(op == 1) { //Atualizar OS
				
				}
				else {
					
					limpaCampos();
				}
				
		
		}
		 //ação cancelar
		else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
		
				dispose();
		}
		//ação excluir
		else if(e.getActionCommand().equals("excluir")) {
			//tratar a exclusão
			int linha = osTable.getSelectedRow();
			Os o = tabelaOs.getOs(linha);
			
			//JOptionPane.showMessageDialog(null, o.getId());
			JOptionPane.showMessageDialog(null, "Deseja realmente excluir a O.S. selecionada?");
				
			OsController controleOs = new OsController();
			try {
				System.out.println(o);
				controleOs.removerOs(o.getId());
				JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
				tabelaOs.addTodos();
				this.repaint();
			}catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclusão");
				}
			
		}
		else if(e.getActionCommand().equals("editar")) {
			JOptionPane.showMessageDialog(null, "Deseja realmente editar o cadastro?");
			int linha = osTable.getSelectedRow();
			Os o = tabelaOs.getOs(linha);
			
			System.out.println(o);
			
			//this.id = o.getId(); 
			data_previsaoField.setText(o.getData_previsao());
			data_prontoField.setText(o.getData_pronto());
			data_entregaField.setText(o.getData_entrega());
			if(o.getGarantia() == 1) {
				garantiaCkBox.setSelected(true);
			}
			
			
		}
		else if(e.getActionCommand().equals("listar")) {
			RelClienteView rc = new RelClienteView("Selecionar");
			this.setVisible(false);
			rc.setVisible(true);
			
			
		}
		 
			
	}
}