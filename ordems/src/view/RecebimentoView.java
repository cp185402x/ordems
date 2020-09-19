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
import javax.swing.JComboBox;
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

import controller.FornecedorController;
import model.Fornecedor;
import model.TabelaFornecedor;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

//Declarando a classe na janela
public class RecebimentoView extends JFrame implements ActionListener{
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel cadastroPanel;
	JPanel fornecedorPainel;
	JLabel titulo;
	ButtonGroup tipoGrupo;
    
    JLabel fone_reLabel;
    
    JLabel estadoLabel;
    JComboBox FormaPagamento;
    
    
    //Inicia o painel dos botoes
    JPanel painelBotoes;
    JButton botaoFinalizar;
    JButton botaoCancelar;
    JButton botaoCancelarItem;
    JButton botaoCancelarVenda;
    TabelaFornecedor tabelaFornecedor;
	private int id;
	private JTextField idClienteField;
	private JTextField nmClienteField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField descontoField;
	private JTextField totalField;
	private JTextField textField_6;
	private JTextField textField_4;
	private JTextField textField_5;

	public RecebimentoView() { // construtor da view Fornecedor.
        super("Cadastro de Fornecedor");
        setTitle("Recebimentos e Vendas");
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
        
        titulo = new JLabel("Cadastro de Fornecedor");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
        //Inicia o painel dos campos digitáveis        
        cadastroPanel = new JPanel();
        
        //Inicia o painel dos botoes
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        
        getContentPane().add(cadastroPanel, BorderLayout.WEST);
        
        JPanel clientePanel = new JPanel();
        clientePanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        clientePanel.setLayout(null);
        tipoGrupo = new ButtonGroup();
        
        JPanel pagamentoPanel = new JPanel();
        pagamentoPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        pagamentoPanel.setLayout(null);
        estadoLabel = new JLabel("Estado");
        estadoLabel.setBounds(554, 56, 65, 14);
        
        JPanel panelItem = new JPanel();
        panelItem.setLayout(null);
        panelItem.setBorder(new LineBorder(Color.LIGHT_GRAY));
        
        JPanel panelListaItens = new JPanel();
        panelListaItens.setLayout(null);
        panelListaItens.setBorder(new LineBorder(null));
        
        JPanel panelValores = new JPanel();
        panelValores.setLayout(null);
        panelValores.setBorder(new LineBorder(Color.LIGHT_GRAY));
        
        descontoField = new JTextField();
        descontoField.setHorizontalAlignment(SwingConstants.RIGHT);
        descontoField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        descontoField.setColumns(10);
        descontoField.setBounds(130, 116, 85, 25);
        panelValores.add(descontoField);
        
        JLabel lblDesconto = new JLabel("Desconto %");
        lblDesconto.setHorizontalAlignment(SwingConstants.LEFT);
        lblDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDesconto.setBounds(10, 116, 117, 25);
        panelValores.add(lblDesconto);
        
        JLabel lblTotal = new JLabel("TOTAL");
        lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTotal.setBounds(10, 80, 117, 25);
        panelValores.add(lblTotal);
        
        totalField = new JTextField();
        totalField.setHorizontalAlignment(SwingConstants.RIGHT);
        totalField.setFont(new Font("Tahoma", Font.BOLD, 12));
        totalField.setColumns(10);
        totalField.setBounds(130, 80, 85, 25);
        panelValores.add(totalField);
        
        JLabel lblValorRecebido = new JLabel("Valor Recebido");
        lblValorRecebido.setHorizontalAlignment(SwingConstants.LEFT);
        lblValorRecebido.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblValorRecebido.setBounds(10, 188, 117, 25);
        panelValores.add(lblValorRecebido);
        
        textField_6 = new JTextField();
        textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_6.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField_6.setColumns(10);
        textField_6.setBounds(130, 188, 85, 25);
        panelValores.add(textField_6);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        
        GroupLayout gl_cadastroPanel = new GroupLayout(cadastroPanel);
        gl_cadastroPanel.setHorizontalGroup(
        	gl_cadastroPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_cadastroPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_cadastroPanel.createSequentialGroup()
        					.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(panelListaItens, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        						.addComponent(panelItem, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        						.addComponent(clientePanel, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(panelValores, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
        						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(pagamentoPanel, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE))
        			.addGap(520))
        );
        gl_cadastroPanel.setVerticalGroup(
        	gl_cadastroPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_cadastroPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_cadastroPanel.createSequentialGroup()
        					.addComponent(clientePanel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(panelItem, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(18)
        			.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(panelListaItens, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(panelValores, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
        			.addComponent(pagamentoPanel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        
        JLabel lblTotalAPagar = new JLabel("Total a Pagar");
        lblTotalAPagar.setHorizontalAlignment(SwingConstants.LEFT);
        lblTotalAPagar.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTotalAPagar.setBounds(10, 152, 117, 25);
        panelValores.add(lblTotalAPagar);
        
        textField_4 = new JTextField();
        textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField_4.setColumns(10);
        textField_4.setBounds(130, 152, 85, 25);
        panelValores.add(textField_4);
        
        JLabel lblTroco = new JLabel("Troco");
        lblTroco.setHorizontalAlignment(SwingConstants.LEFT);
        lblTroco.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTroco.setBounds(10, 227, 117, 22);
        panelValores.add(lblTroco);
        
        textField_5 = new JTextField();
        textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textField_5.setColumns(10);
        textField_5.setBounds(130, 224, 85, 25);
        panelValores.add(textField_5);
        
                FormaPagamento = new JComboBox();
                FormaPagamento.setFont(new Font("Tahoma", Font.BOLD, 12));
                FormaPagamento.setBounds(10, 44, 206, 25);
                panelValores.add(FormaPagamento);
                
                FormaPagamento.setModel(new DefaultComboBoxModel(new String[] {"Dinheiro", "Cart\u00E3o D\u00E9bito", "Cart\u00E3o Cr\u00E9dito", "Promiss\u00F3ria"}));
                
                JLabel lblFormaDePagamentos = new JLabel("FORMA DE PAGAMENTOS");
                lblFormaDePagamentos.setFont(new Font("Tahoma", Font.BOLD, 12));
                lblFormaDePagamentos.setHorizontalAlignment(SwingConstants.CENTER);
                lblFormaDePagamentos.setBounds(10, 11, 206, 22);
                panelValores.add(lblFormaDePagamentos);
        
        botaoFinalizar = new JButton("Finalizar Venda");
        botaoFinalizar.setBounds(5, 11, 150, 23);
        pagamentoPanel.add(botaoFinalizar);
        
        botaoFinalizar.addActionListener(this);
        botaoFinalizar.setActionCommand("salvar");
        botaoCancelarItem = new JButton("Cancelar Item");
        botaoCancelarItem.setBounds(325, 11, 150, 23);
        pagamentoPanel.add(botaoCancelarItem);
        
        botaoCancelarItem.addActionListener(this);
        botaoCancelarItem.setActionCommand("editar");
        botaoCancelarVenda = new JButton("Cancelar Vanda");
        botaoCancelarVenda.setBounds(485, 11, 150, 23);
        pagamentoPanel.add(botaoCancelarVenda);
        
        botaoCancelarVenda.addActionListener(this);
        botaoCancelarVenda.setActionCommand("excluir");
        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(10, 146, 75, 23);
        pagamentoPanel.add(botaoCancelar);
        
        botaoCancelar.addActionListener(this);
        botaoCancelar.setActionCommand("cancelar");
        
        JButton btnImprimirVenda = new JButton("Imprimir Venda");
        btnImprimirVenda.setActionCommand("salvar");
        btnImprimirVenda.setBounds(165, 11, 150, 23);
        pagamentoPanel.add(btnImprimirVenda);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(Color.LIGHT_GRAY));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 11, 393, 241);
        panelListaItens.add(scrollPane);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(10, 44, 60, 20);
        panelItem.add(textField);
        
        JLabel label = new JLabel("C\u00F3digo");
        label.setBounds(10, 27, 60, 14);
        panelItem.add(label);
        
        JLabel label_1 = new JLabel("Nome");
        label_1.setBounds(80, 27, 46, 14);
        panelItem.add(label_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(80, 44, 158, 20);
        panelItem.add(textField_1);
        
        JLabel label_2 = new JLabel("QTD");
        label_2.setBounds(248, 27, 40, 14);
        panelItem.add(label_2);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(248, 44, 40, 20);
        panelItem.add(textField_2);
        
        JLabel label_3 = new JLabel("Pre\u00E7o");
        label_3.setBounds(298, 27, 46, 14);
        panelItem.add(label_3);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(298, 44, 46, 20);
        panelItem.add(textField_3);
        
        JButton button_1 = new JButton("+");
        button_1.setToolTipText("Adicionar item");
        button_1.setBounds(354, 43, 49, 23);
        panelItem.add(button_1);
        
        idClienteField = new JTextField();
        idClienteField.setBounds(10, 25, 60, 20);
        clientePanel.add(idClienteField);
        idClienteField.setColumns(10);
        
        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setBounds(10, 11, 46, 14);
        clientePanel.add(lblCliente);
        
        nmClienteField = new JTextField();
        nmClienteField.setBounds(80, 25, 264, 20);
        clientePanel.add(nmClienteField);
        nmClienteField.setColumns(10);
        
        JButton botaoPesqCliente = new JButton("?");
        botaoPesqCliente.setForeground(Color.BLACK);
        botaoPesqCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
        botaoPesqCliente.setToolTipText("Pesquisar Cliente");
        botaoPesqCliente.setBounds(354, 24, 49, 23);
        clientePanel.add(botaoPesqCliente);

        
        tabelaFornecedor = new TabelaFornecedor();
        
        cadastroPanel.setLayout(gl_cadastroPanel);
        
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
        
        JLabel label_4 = new JLabel("20/09/2020 19:30:45");
        label_4.setForeground(Color.GRAY);
        painelBotoes.add(label_4);
        
        JLabel lblStatusServidor = new JLabel("Status: ");
        lblStatusServidor.setForeground(Color.GRAY);
        painelBotoes.add(lblStatusServidor);
        
        JLabel lblOnLine = new JLabel("ON LINE");
        lblOnLine.setForeground(Color.GRAY);
        painelBotoes.add(lblOnLine);
        
        JLabel lblVerso = new JLabel("(c) Copyright VEC System.  All rights reserved.");
        lblVerso.setForeground(Color.GRAY);
        painelBotoes.add(lblVerso);

    }
    
    //método para limpar tela
    private void limpaCampos() {

		nm_fornecedorField.setText("");
		docField.setText("");
		rgieField.setText("");
		fone_reField.setText("");			
		celularField.setText("");
		emailField.setText("");
		pes_contatoField.setText("");
		TCEP.setText("");
		TRUA.setText("");
		numeroField.setText("");
		complementoField.setText("");
		TBAIRRO.setText("");
		TCIDADE.setText("");
		FormaPagamento.setToolTipText("");
    	
		this.cadastroPanel.repaint();
		this.fornecedorPainel.repaint();
    }
   
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("salvar")) {
			
			Fornecedor f = new Fornecedor();
			
			//Tratar a ação de salvar o cliente
			
			//Trata o radio do tipo de cliente
			if(cpfRadio.isSelected()) {
				f.setTipo(0);
			}
			else {
				f.setTipo(1);
			}
			//Tipo
			System.out.println("Tipo: " +f.getTipo());
			//nome
			f.setNm_fornecedor(nm_fornecedorField.getText());			
			//documento
			f.setDoc_num(docField.getText());			
			//RGIE
			f.setRg_ie(rgieField.getText());
			//fone fixo
			f.setFone_re(fone_reField.getText());
			//celular
			f.setCelular(celularField.getText());
			//email
			f.setEmail(emailField.getText());
			//pessoa contato
			f.setPes_contato(pes_contatoField.getText());
			//Logradouro
			f.getEndereco().setTCEP(TCEP.getText());
			//Logradouro
			f.getEndereco().setTRUA(TRUA.getText());
			//numero
			f.getEndereco().setNumero(numeroField.getText());
			//complemento
			f.getEndereco().setComplemento(complementoField.getText());
			//bairro
			f.getEndereco().setTBAIRRO(TBAIRRO.getText());
			//cidade
			f.getEndereco().setTCIDADE(TCIDADE.getText());
			//estado
			f.getEndereco().setCESTADO(FormaPagamento.getToolTipText());
			
			Object[] opcoes = {"Salvar como novo cadastro", "Atualizar", "Limpar todos campos"};
	
			
			int op = JOptionPane.showOptionDialog(null, "Escolha uma opção para continuar", "Aviso",
			          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			              null, opcoes, opcoes[0]);
				
				if(op == 0) { //salvar um novo cliente
					FornecedorController controleCliente = new FornecedorController();
					try {
						if(controleCliente.cadastrarFornecedor(f) == true) {
							JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
							tabelaFornecedor.addTodos();
							limpaCampos();
							this.repaint();
						}
						}
					 catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ops, houve um erro ao efetuar o cadastro!");
					}
				}
				else if(op == 1) { //ATUALIZAR
					f.setId(this.id);
					FornecedorController controleFornecedor = new FornecedorController();
					try {
						if(controleFornecedor.atualizarFornecedor(f) == true) {
							JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
							tabelaFornecedor.addTodos();
							limpaCampos();
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
								
					nm_fornecedorField.setText("");
					docField.setText("");
					rgieField.setText("");
					fone_reField.setText("");			
					celularField.setText("");
					emailField.setText("");
					pes_contatoField.setText("");
					TCEP.setText("");
					TRUA.setText("");
					numeroField.setText("");
					complementoField.setText("");
					TBAIRRO.setText("");
					TCIDADE.setText("");
					FormaPagamento.setToolTipText("");
					
				}
		
		}
		else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
		
				dispose();
		}
		else if(e.getActionCommand().equals("excluir")) {
			//tratar a exclusão
			int linha = fornecedorTable.getSelectedRow();
			Fornecedor f = tabelaFornecedor.getFornecedor(linha);
			
			FornecedorController controleFornecedor = new FornecedorController();
			try {
				controleFornecedor.removerFornecedor(f.getId());
				JOptionPane.showMessageDialog(null, " Cadastro excluído com sucesso!");
				tabelaFornecedor.addTodos();
				this.repaint();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclusão");
			}
			
			
		}
		else if(e.getActionCommand().equals("editar")) {
			JOptionPane.showMessageDialog(null, "Deseja realmente editar o cadastro?");
			int linha = fornecedorTable.getSelectedRow();
			Fornecedor f = tabelaFornecedor.getFornecedor(linha);
			
			//preencher os campos com os dados do cliente selecionado
			if(f.getTipo() == 0) cpfRadio.setEnabled(true);
			else cnpjRadio.setEnabled(true);
			
			this.id =f.getId(); 
			nm_fornecedorField.setText(f.getNm_fornecedor());
			docField.setText(f.getDoc_num());
			rgieField.setText(f.getRg_ie());
			fone_reField.setText(f.getFone_re());			
			celularField.setText(f.getCelular());
			emailField.setText(f.getEmail());
			pes_contatoField.setText(f.getPes_contato());
			TCEP.setText(f.getEndereco().getTCEP());
			TRUA.setText(f.getEndereco().getTRUA());
			numeroField.setText(f.getEndereco().getNumero());
			complementoField.setText(f.getEndereco().getComplemento());
			TBAIRRO.setText(f.getEndereco().getTBAIRRO());
			TCIDADE.setText(f.getEndereco().getTCIDADE());
			FormaPagamento.setToolTipText(f.getEndereco().getCESTADO());
			
			
		}
			
		}
	}

