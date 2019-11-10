package view;

//Importando os componentes
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import controller.PecaController;
import model.Cliente;
import model.Peca;

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
	
	JLabel		nm_pecaJLabel;
	JTextField 	nm_pecaField;
	
	JLabel		vl_custoLabel;
	JTextField 	vl_custoField;
	
	JLabel		vl_vendaLabel;
	JTextField 	vl_vendaField;
	
	
    //Inicia o painel dos botoes
    JPanel 	painelBotoes;
    JButton botaoSalvar;
    JButton botaoCancelar;
    private JTable pecaTable;
    private JTextField buscarField;
    
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
        
        //Inicia o painel de título        
        JPanel painelTitulo = new JPanel();
        painelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel("Cadastro de peça");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);

 
        //Inicia o painel dos botoes
	    JPanel painelBotoes = new JPanel();
	    painelBotoes.setLayout(new FlowLayout());
	    
	    JButton botaoSalvar = new JButton("Salvar");
	    JButton botaoCancelar = new JButton("Cancelar");
	    
        
        //Inicia o painel dos campos digitáveis        
        JPanel painelCadastro = new JPanel();
        
        JLabel nm_pecaLabel = new JLabel("Nome da Peça");
        nm_pecaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        nm_pecaLabel.setBounds(23, 14, 100, 17);
        JTextField nm_pecaField = new JTextField(40);
        nm_pecaField.setBounds(133, 11, 421, 20);
        painelCadastro.setLayout(null);
        painelCadastro.add(nm_pecaLabel);
        painelCadastro.add(nm_pecaField);
        
        JLabel vl_custoLabel = new JLabel("Valor de Custo");
        vl_custoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        vl_custoLabel.setBounds(23, 98, 100, 17);
        JTextField vl_custoField = new JTextField(10);
        vl_custoField.setBounds(133, 96, 100, 20);
        painelCadastro.add(vl_custoLabel);
        painelCadastro.add(vl_custoField);
        
        JLabel vl_vendaLabel = new JLabel("Valor de Venda");
        vl_vendaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        vl_vendaLabel.setBounds(243, 98, 106, 17);
        JTextField vl_vendaField= new JTextField(10);
        vl_vendaField.setBounds(359, 96, 100, 20);
        painelCadastro.add(vl_vendaLabel);
        painelCadastro.add(vl_vendaField);
        

        //Adicionando os paineis em suas respectivas posições        
        getContentPane().add(painelTitulo, BorderLayout.NORTH);
        getContentPane().add(painelCadastro, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 188, 594, 302);
        painelCadastro.add(scrollPane);
        
        pecaTable = new JTable();
        pecaTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Cod", "Nome Peca", "Qtd", "Custo", "Venda"
        	}
        ));
        pecaTable.getColumnModel().getColumn(1).setPreferredWidth(247);
        pecaTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        pecaTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        pecaTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        scrollPane.setViewportView(pecaTable);
        
        buscaField = new JTextField();
        buscaField.setForeground(SystemColor.info);
        buscaField.setBounds(10, 151, 285, 26);
        painelCadastro.add(buscaField);
        buscaField.setColumns(10);
        
        JButton buscarBtn = new JButton("Buscar");
        buscarBtn.setBounds(305, 152, 90, 25);
        painelCadastro.add(buscarBtn);
        
        JButton editarBtn = new JButton("Editar");
        editarBtn.setBounds(414, 152, 90, 25);
        painelCadastro.add(editarBtn);
        
        JButton excluirBnt = new JButton("Excluir");
        excluirBnt.setBounds(514, 152, 90, 25);
        painelCadastro.add(excluirBnt);
        
        skuField = new JTextField();
        skuField.setBounds(133, 54, 162, 20);
        painelCadastro.add(skuField);
        skuField.setColumns(10);
        
        JLabel skuLabel = new JLabel("SKU");
        skuLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        skuLabel.setBounds(45, 56, 78, 17);
        painelCadastro.add(skuLabel);
        
        JCheckBox skuCheckBox = new JCheckBox("Produto controlado");
        skuCheckBox.setBounds(305, 53, 154, 23);
        painelCadastro.add(skuCheckBox);
        
       
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
			Peca p = new Peca();
			
			//Nome da peça
			p.setNm_peca(nm_pecaField.getText());			
			//Valor de custo
			p.setVl_custo(vl_custoField.getText());			
			//Valor de venda
			p.setVl_venda(vl_vendaField .getText());

			
			PecaController controlePeca = new PecaController();
			try {
				if(controlePeca.cadastrarPeca(p) == true) {
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
