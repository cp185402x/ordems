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
    JButton botaoEditar;
    JButton botaoExcluir;
    
    
    private JTable pecaTable;
    private JTextField buscarField;
	private TabelaPeca tabelaPeca;
	private int id;
    
    public PecaView() { // construtor da view OS.
        super("Cadastro de peça");
        setType(Type.UTILITY);
        
        criaFormulario();
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(630, 600);
    	this.setVisible(true);
    	this.setLocationRelativeTo(null);

    }
    
    private void criaFormulario() {
        
        getContentPane().setLayout(new BorderLayout());
        
        painelTitulo = new JPanel();
        painelTitulo.setLayout(new FlowLayout());
        
        titulo = new JLabel("Cadastro de Peca");
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
        
        JPanel pecaPainel = new JPanel();
        pecaPainel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        pecaPainel.setLayout(null);
        

        skuField = new JTextField(20);
        skuField.setBounds(447, 137, 186, 20);
        pecaPainel.add(skuField);        
        skuLabel = new JLabel("SKU");
        skuLabel.setBounds(447, 125, 166, 14);
        pecaPainel.add(skuLabel);
        
        nm_pecaField = new JTextField(40);
        nm_pecaField.setBounds(10, 138, 427, 20);
        pecaPainel.add(nm_pecaField);        
        nm_pecaLabel = new JLabel("Nome da Peca");
        nm_pecaLabel.setBounds(10, 126, 368, 14);
        pecaPainel.add(nm_pecaLabel);
       
        
        vl_custoLabel = new JLabel("valor de custo");
        vl_custoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        vl_custoLabel.setBounds(323, 10, 50, 14);
        pecaPainel.add(vl_custoLabel);
        vl_custoField = new JTextField(20);
        vl_custoField.setBounds(373, 7, 186, 20);
        pecaPainel.add(vl_custoField);
        
        vl_vendaLabel = new JLabel("Valor de venda");
        vl_vendaLabel.setBounds(10, 37, 338, 14);
        pecaPainel.add(vl_vendaLabel);
        vl_vendaField = new JTextField(40);
        vl_vendaField.setBounds(10, 51, 427, 20);
        pecaPainel.add(vl_vendaField);
        
       
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel.setLayout(null); 
        
       
        
        //Criando a Tabela com os dados do banco
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(Color.LIGHT_GRAY));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        
        botaoEditar = new JButton("Editar");
        
        botaoExcluir = new JButton("Excluir");
        
        
        buscarField = new JTextField();
        buscarField.setBackground(new Color(200, 250, 210));
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
        				.addComponent(pecaPainel, GroupLayout.PREFERRED_SIZE, 673, GroupLayout.PREFERRED_SIZE))
        			.addGap(18))
        );
        gl_painelCadastro.setVerticalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(pecaPainel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.BASELINE)
        				.addComponent(buscarField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(botaoExcluir)
        				.addComponent(botaoEditar)
        				.addComponent(buscarBtn))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
      //fazendo a ligação do modelo de tabela com o componente visual de janela
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
    
       
//	public void actionPerformed(ActionEvent e) {
//		
//		if(e.getActionCommand().equalsIgnoreCase("salvar")) {
//			Peca p = new Peca();
//			
//			//Nome da peça
//			p.setNm_peca(nm_pecaField.getText());			
//			//Valor de custo
//			p.setVl_custo(vl_custoField.getText());			
//			//Valor de venda
//			p.setVl_venda(vl_vendaField .getText());
//
//			
//			PecaController controlePeca = new PecaController();
//			try {
//				if(controlePeca.cadastrarPeca(p) == true) {
//					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
//				}
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//				JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro!");
//			}
//		}
//		else if(e.getActionCommand().equalsIgnoreCase("cancelar")) {
// 
//			dispose();
    
    	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("salvar")) {
			
			Peca p = new Peca();
			
			//Tratar a ação de salvar o peca
			
			//Tipo
			
			//nome
			p.setNm_peca(nm_pecaField.getText());			
			//documento
			p.setVl_venda(vl_vendaField.getText());			
			//RGIE
			p.setVl_custo(vl_custoField.getText());
			
			
			Object[] opcoes = {"Salvar como novo cadastro", "Atualizar", "Limpar todos campos"};
			
			int op = JOptionPane.showOptionDialog(null, "Escolha uma opção para continuar", "Aviso",
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
			{ //ATUALIZAR O Peca
				p.setId(this.id);
				PecaController controlePeca = new PecaController();
				try {
					if(controlePeca.atualizarPeca(p) == true) {
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
						tabelaPeca.addTodos();
						this.repaint();
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
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
		//tratar a exclusão
		int linha = pecaTable.getSelectedRow();
		Peca c = tabelaPeca.getPeca(linha);
		
		PecaController controlePeca = new PecaController();
		try {
			controlePeca.removerPeca(c.getId());
			JOptionPane.showMessageDialog(null, " Cadastro excluído com sucesso!");
			tabelaPeca.addTodos();
			this.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclusão");
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
	 

