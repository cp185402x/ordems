package view;

//Importando os componentes
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


import javax.swing.GroupLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.border.LineBorder;

import controller.PecaController;
import model.Peca;
import model.TabelaPeca;

import java.awt.Color;
import javax.swing.table.DefaultTableModel;

//Declarando a classe na janela
public class PecaView extends JFrame implements ActionListener{
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JLabel titulo;
	
	JLabel		buscaLabel;
	JTextField 	buscaField;
	
	JLabel		skuLabel;
	JTextField  skuField;
	
	JLabel		nm_pecaLabel;
	JTextField 	nm_pecaField;
	
	JLabel		vl_custoLabel;
	JTextField 	vl_custoField;
	
	JLabel		vl_vendaLabel;
	JTextField 	vl_vendaField;	
	
    //Inicia o painel dos botoes
    JPanel 	painelBotoes;
    JButton botaoSalvar;
    JButton botaoCancelar;
    JButton botaoBuscar;
    JButton botaoEditar;
    JButton botaoExcluir;
    
    
    private JTable pecaTable;
	private TabelaPeca tabelaPeca;
	private int id;
	private JTextField textField;
    
    public PecaView() { // construtor da view OS.
        super("Cadastro de pe�a");
        setType(Type.UTILITY);
        
        criaFormulario();
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(640, 600);
    	this.setVisible(true);
    	this.setLocationRelativeTo(null);

    }
    
    private void criaFormulario() {
        
        getContentPane().setLayout(new BorderLayout());
        
        painelTitulo = new JPanel();
        painelTitulo.setLayout(new FlowLayout());
        
        titulo = new JLabel("Cadastro de Pea");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
        //Inicia o painel dos campos digit�veis        
        painelCadastro = new JPanel();
        
        //Inicia o painel dos botoes
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        
        botaoSalvar = new JButton("Salvar");
        botaoCancelar = new JButton("Cancelar");
        
        getContentPane().add(painelCadastro, BorderLayout.WEST);
        
        JPanel pecaPainel = new JPanel();
        pecaPainel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        pecaPainel.setLayout(null);
        

        skuField = new JTextField(20);
        skuField.setBounds(251, 64, 186, 20);
        pecaPainel.add(skuField);        
        skuLabel = new JLabel("SKU");
        skuLabel.setBounds(252, 49, 166, 14);
        pecaPainel.add(skuLabel);
        
        nm_pecaField = new JTextField(40);
        nm_pecaField.setBounds(10, 13, 427, 20);
        pecaPainel.add(nm_pecaField);        
        nm_pecaLabel = new JLabel("Nome da Peca");
        nm_pecaLabel.setBounds(10, 0, 368, 14);
        pecaPainel.add(nm_pecaLabel);
       
        
        vl_custoLabel = new JLabel("Valor de custo");
        vl_custoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        vl_custoLabel.setBounds(10, 49, 80, 14);
        pecaPainel.add(vl_custoLabel);
        vl_custoField = new JTextField(20);
        vl_custoField.setBounds(10, 64, 186, 20);
        pecaPainel.add(vl_custoField);
        
        vl_vendaLabel = new JLabel("Valor de venda");
        vl_vendaLabel.setBounds(10, 105, 338, 14);
        pecaPainel.add(vl_vendaLabel);
        vl_vendaField = new JTextField(40);
        vl_vendaField.setBounds(10, 119, 186, 20);
        pecaPainel.add(vl_vendaField);
        
       
        
        //Criando a Tabela com os dados do banco
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(new Color(192, 192, 192)));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        botaoBuscar = new JButton("Buscar");        
        botaoEditar = new JButton("Editar");        
        botaoExcluir = new JButton("Excluir");
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textField.setColumns(10);
        textField.setBackground(new Color(250, 250, 210));
        
        GroupLayout gl_painelCadastro = new GroupLayout(painelCadastro);
        gl_painelCadastro.setHorizontalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(scrollPane, Alignment.LEADING)
        				.addGroup(Alignment.LEADING, gl_painelCadastro.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(pecaPainel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(botaoBuscar, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(botaoEditar)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(botaoExcluir))))
        			.addGap(18))
        );
        gl_painelCadastro.setVerticalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(pecaPainel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(botaoBuscar)
        				.addComponent(botaoEditar)
        				.addComponent(botaoExcluir))
        			.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
      //fazendo a liga��o do modelo de tabela com o componente visual de janela
        tabelaPeca = new TabelaPeca();
        pecaTable = new JTable(tabelaPeca);
             
        scrollPane.setViewportView(pecaTable);
        
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
			
			Peca p = new Peca();
			
			//Tratar a a��o de salvar o peca
			
			//nome
			p.setNm_peca(nm_pecaField.getText());			
			//documento
			p.setVl_venda(vl_vendaField.getText());			
			//RGIE
			p.setVl_custo(vl_custoField.getText());
			
			
			Object[] opcoes = {"Salvar como novo cadastro", "Atualizar", "Limpar todos campos"};
			
			int op = JOptionPane.showOptionDialog(null, "Escolha uma op��o para continuar", "Aviso",
		          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		              null, opcoes, opcoes[0]);
			
			if(op == 0) { //salvar um novo peca
				PecaController controlePeca = new PecaController();
				try {
					if(controlePeca.cadastrarPeca(p) == true) {
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
						tabelaPeca.addTodos();
						this.repaint();
					}
					}
				 catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ops, houve um erro ao efetuar o cadastro!");
				}
			}
			else if(op == 1)
			{ //Atualizar pe�a
				p.setId(this.id);
				PecaController controlePeca = new PecaController();
				try {
					if(controlePeca.atualizarPeca(p) == true) {
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
						tabelaPeca.addTodos();
						this.repaint();
					}
				} catch (HeadlessException | SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ops, houve um ao efetuar o cadastro!");
				}				
				
			}
			else {
				
				
				nm_pecaField.setText("");
				vl_vendaField.setText("");
				vl_custoField.setText("");
				
				
			}
	
	}
	else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
	
			dispose();
	}
	else if(e.getActionCommand().equals("excluir")) {
		//tratar a exclus�o
		int linha = pecaTable.getSelectedRow();
		Peca c = tabelaPeca.getPeca(linha);
		
		PecaController controlePeca = new PecaController();
		try {
			controlePeca.removerPeca(c.getId());
			JOptionPane.showMessageDialog(null, " Cadastro exclu�do com sucesso!");
			tabelaPeca.addTodos();
			this.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclus�o");
		}
		
		
	}
	else if(e.getActionCommand().equals("editar")) {
		JOptionPane.showMessageDialog(null, "Deseja realmente editar o cadastro?");
		int linha = pecaTable.getSelectedRow();
		Peca p = tabelaPeca.getPeca(linha);
		
		//preencher os campos com os dados do peca selecionado
		this.id =p.getId(); 
		nm_pecaField.setText(p.getNm_peca());
		vl_vendaField.setText(p.getVl_venda());
		vl_custoField.setText(p.getVl_custo());

		}
		
    }
}
	 

