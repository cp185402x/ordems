package view;

//Importando os componentes
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import javax.swing.border.LineBorder;

import controller.PecaController;
import model.Peca;
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

 
        //Inicia o painel dos botoes
	    JPanel painelBotoes = new JPanel();
	    painelBotoes.setLayout(new FlowLayout());
	    
	    JButton botaoSalvar = new JButton("Salvar");
	    JButton botaoCancelar = new JButton("Cancelar");
	    
        
        //Inicia o painel dos campos digitáveis        
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(null);
        

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
        buscaField.setBounds(10, 151, 285, 26);
        buscaField.setForeground(SystemColor.info);
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
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel.setBounds(10, 11, 594, 130);
        painelCadastro.add(panel);
        panel.setLayout(null);
        JTextField vl_custoField_1 = new JTextField(10);
        vl_custoField_1.setBounds(120, 96, 100, 20);
        panel.add(vl_custoField_1);
        
        JLabel vl_custoLabel_1 = new JLabel("Valor de Custo");
        vl_custoLabel_1.setBounds(10, 98, 100, 17);
        panel.add(vl_custoLabel_1);
        vl_custoLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JLabel vl_vendaLabel_1 = new JLabel("Valor de Venda");
        vl_vendaLabel_1.setBounds(230, 98, 106, 17);
        panel.add(vl_vendaLabel_1);
        vl_vendaLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField vl_vendaField_1= new JTextField(10);
        vl_vendaField_1.setBounds(346, 96, 100, 20);
        panel.add(vl_vendaField_1);
        
        JCheckBox skuCheckBox = new JCheckBox("Produto controlado");
        skuCheckBox.setBounds(292, 53, 154, 23);
        panel.add(skuCheckBox);
        
        skuField = new JTextField();
        skuField.setBounds(120, 54, 162, 20);
        panel.add(skuField);
        skuField.setColumns(10);
        
        JLabel skuLabel_1 = new JLabel("SKU");
        skuLabel_1.setBounds(32, 56, 78, 17);
        panel.add(skuLabel_1);
        skuLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JLabel nm_pecaLabel = new JLabel("Nome da Peça");
        nm_pecaLabel.setBounds(10, 14, 100, 17);
        panel.add(nm_pecaLabel);
        nm_pecaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField nm_pecaField_1 = new JTextField(40);
        nm_pecaField_1.setBounds(120, 11, 421, 20);
        panel.add(nm_pecaField_1);
        
       
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
