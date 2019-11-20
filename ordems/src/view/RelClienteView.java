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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.ScrollPaneConstants;

import model.TabelaCliente;
import javax.swing.SwingConstants;

//Declarando a classe na janela
public class RelClienteView extends JFrame implements ActionListener{
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JLabel titulo;
    
    
    //Inicia o painel dos botoes
    JPanel painelBotoes;
    JButton botaoImprimir;
    JButton botaoCancelar;
    
    private JTable clienteTable;
    TabelaCliente tabelaCliente;

	public RelClienteView() { // construtor da view Cliente.
        super("Relatório de Clientes");
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
        
        titulo = new JLabel("Relatório de Clientes");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
        //Inicia o painel dos campos digitáveis        
        painelCadastro = new JPanel();
        
        //Inicia o painel dos botoes
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        
        botaoImprimir = new JButton("Imprimir");
        botaoCancelar = new JButton("Cancelar");
        
        getContentPane().add(painelCadastro, BorderLayout.WEST);
        
        //Criando a Tabela com os dados do banco
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(Color.LIGHT_GRAY));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        JPanel panelTitulo = new JPanel();
        
        GroupLayout gl_painelCadastro = new GroupLayout(painelCadastro);
        gl_painelCadastro.setHorizontalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_painelCadastro.createSequentialGroup()
        					.addGap(10)
        					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE))
        				.addComponent(panelTitulo, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
        			.addGap(18))
        );
        gl_painelCadastro.setVerticalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        			.addComponent(panelTitulo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        			.addContainerGap())
        );
        panelTitulo.setLayout(null);
        
        JLabel lblRelatrrioDeClientes = new JLabel("Relatório de Clientes Cadastrados");
        lblRelatrrioDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
        lblRelatrrioDeClientes.setBounds(0, 0, 666, 33);
        lblRelatrrioDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panelTitulo.add(lblRelatrrioDeClientes);
        
        tabelaCliente = new TabelaCliente();
        clienteTable = new JTable(tabelaCliente);
             
        scrollPane.setViewportView(clienteTable);
        
        painelCadastro.setLayout(gl_painelCadastro);
        
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
        
        painelBotoes.add(botaoImprimir);
        painelBotoes.add(botaoCancelar);
        
        botaoImprimir.addActionListener(this);
        botaoImprimir.setActionCommand("salvar");
        botaoCancelar.addActionListener(this);
        botaoCancelar.setActionCommand("cancelar");

    }
    
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
	
			dispose();
		}
	}
}

