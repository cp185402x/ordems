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
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

import controller.OsController;
import model.Os;

//Declarando a classe na janela
public class OsView extends JFrame implements ActionListener{
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JLabel titulo;
    
    JLabel 		cliente_idLabel;
    JTextField 	cilente_idField;
    
    JLabel 		nm_clienteLabel;
    JTextField 	nm_cilenteField;
    
    JLabel 		usuario_idLabel;
    JTextField 	usuario_idField;
    
    JLabel 		data_previsaoLabel;
    JTextField 	data_previsaoField;
    
    JLabel 		data_prontoLabel;
    JTextField 	data_prontoField;
    
    JLabel 		data_entregaLabel;
    JTextField 	data_entregaField;
    
    JLabel 		garantiaLabel;
    JTextField 	garantiaField;
    
    JLabel 		tipoLabel;
    JTextField 	tipoField;
    
    JLabel 		modeloLabel;
    JTextField 	modeloField;
    
    JLabel 		marcaLabel;
    JTextField 	marcaField;
    
    JLabel 		corLabel;
    JTextField 	corField;
    
    JLabel 		serieLabel;
    JTextField 	serieField;
    
    JLabel 		info_clienteLabel;
    JTextArea 	info_clienteTA;
    
    JLabel 		info_tecnicoLabel;
    JTextArea 	info_tecnicoTA;
    
    JLabel 		info_entregaLabel;
    JTextArea 	info_entregaTA;
    
    JLabel 		info_internaLabel;
    JTextArea 	info_internaTA;
    
    //Inicia o painel dos botoes
    JPanel painelBotoes;
    JButton botaoSalvar;
    JButton botaoCancelar;
    
    private JTable osTable;    
    private JTextField buscarField;

	public OsView() { // construtor da view Cliente.
        super("Cadastro de Ordens de Serviços");
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
        
        titulo = new JLabel("Cadastro de O.S");
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
        
        JPanel equipamentoPanel = new JPanel();
        equipamentoPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        equipamentoPanel.setLayout(null);
        
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
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_painelCadastro.createSequentialGroup()
        					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_painelCadastro.createSequentialGroup()
        							.addComponent(buscarField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(buscarBtn, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
        							.addComponent(editarBtn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(excluirBtn, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
        						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        						.addComponent(clientePainel, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))
        					.addGap(20))
        				.addGroup(gl_painelCadastro.createSequentialGroup()
        					.addComponent(equipamentoPanel, GroupLayout.PREFERRED_SIZE, 641, GroupLayout.PREFERRED_SIZE)
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
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.BASELINE)
        				.addComponent(buscarField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(buscarBtn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(excluirBtn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(editarBtn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        			.addContainerGap())
        );
        
        cliente_idLabel = new JLabel("ID Cliente");
        cliente_idLabel.setBounds(10, 11, 47, 14);        
        cilente_idField = new JTextField(6);
        clientePainel.add(cliente_idLabel);
        cilente_idField.setBounds(10, 24, 54, 20);
        clientePainel.add(cilente_idField);
        
        nm_clienteLabel = new JLabel("Nome do Cliente");
        nm_clienteLabel.setBounds(84, 11, 326, 14);        
        nm_cilenteField = new JTextField(40);
        clientePainel.add(nm_clienteLabel);
        nm_cilenteField.setBounds(84, 24, 326, 20);
        clientePainel.add(nm_cilenteField);
        
        usuario_idLabel = new JLabel("Usuário");
        usuario_idLabel.setBounds(420, 11, 49, 14);        
        usuario_idField = new JTextField(6);
        clientePainel.add(usuario_idLabel);
        usuario_idField.setBounds(420, 24, 54, 20);
        clientePainel.add(usuario_idField);
        
        data_previsaoLabel = new JLabel("Data Prevista");
        data_previsaoLabel.setBounds(10, 55, 85, 15);        
        data_previsaoField = new JTextField(10);
        clientePainel.add(data_previsaoLabel);
        data_previsaoField.setBounds(10, 70, 85, 20);
        clientePainel.add(data_previsaoField);
       
        data_prontoLabel = new JLabel("Data Pronto");
        data_prontoLabel.setBounds(110, 55, 85, 15);
        clientePainel.add(data_prontoLabel);
        data_prontoField = new JTextField(10);
        data_prontoField.setSize(85, 20);
        data_prontoField.setLocation(110, 70);
        data_prontoField.setBounds(106, 69, 86, 20);
        clientePainel.add(data_prontoField);
       
        data_entregaLabel = new JLabel("Data Entrega");
        data_entregaLabel.setBounds(210, 55, 85, 15);
        clientePainel.add(data_entregaLabel);
        data_entregaField = new JTextField(10);
        data_entregaField.setSize(85, 20);
        data_entregaField.setLocation(210, 70);
        data_entregaField.setBounds(202, 69, 86, 20);
        clientePainel.add(data_entregaField);
        
        garantiaLabel = new JLabel("Garantia");
        garantiaLabel.setBounds(310, 55, 85, 15);
        clientePainel.add(garantiaLabel);
        garantiaField = new JTextField(4);
        garantiaField.setSize(85, 20);
        garantiaField.setLocation(310, 70);
        garantiaField.setBounds(301, 69, 38, 20);
        clientePainel.add(garantiaField);
        
        tipoLabel = new JLabel("Tipo Equipamento");
        tipoLabel.setBounds(11, 0, 164, 14);        
        tipoField = new JTextField(20);
        equipamentoPanel.add(tipoLabel);
        tipoField.setBounds(11, 15, 166, 20);
        equipamentoPanel.add(tipoField);
        
        modeloLabel = new JLabel("Modelo");
        modeloLabel.setBounds(190, 0, 166, 14);        
        modeloField = new JTextField(20);
        equipamentoPanel.add(modeloLabel);
        modeloField.setBounds(190, 15, 100, 20);
        equipamentoPanel.add(modeloField);
        
        marcaLabel = new JLabel("Marca");
        marcaLabel.setBounds(300, 0, 129, 14);        
        marcaField = new JTextField(20);
        equipamentoPanel.add(marcaLabel);
        marcaField.setBounds(300, 15, 129, 20);
        equipamentoPanel.add(marcaField);
        
        corLabel = new JLabel("Cor");
        corLabel.setBounds(440, 0, 86, 14);        
        corField = new JTextField(10);
        equipamentoPanel.add(corLabel);
        corField.setBounds(439, 15, 86, 20);
        equipamentoPanel.add(corField);
        
        serieLabel = new JLabel("N/S");
        serieLabel.setBounds(536, 1, 86, 14);        
        serieField = new JTextField(10);
        equipamentoPanel.add(serieLabel);
        serieField.setBounds(536, 15, 86, 20);
        equipamentoPanel.add(serieField);
        
        info_clienteLabel = new JLabel("Informações do cliente");
        info_clienteLabel.setBounds(10, 45, 300, 14);
        equipamentoPanel.add(info_clienteLabel);        
        JTextArea info_clienteTA = new JTextArea(3, 200);
        info_clienteTA.setForeground(SystemColor.info);
        info_clienteTA.setEditable(true);
        info_clienteTA.setBounds(10, 60, 300, 60);
        equipamentoPanel.add(info_clienteTA);
        
        info_tecnicoLabel = new JLabel("Informações do técnico");
        info_tecnicoLabel.setBounds(322, 45, 302, 14);
        equipamentoPanel.add(info_tecnicoLabel);        
        JTextArea info_tecnicoTA = new JTextArea(3, 200);
        info_tecnicoTA.setForeground(SystemColor.info);
        info_tecnicoTA.setEditable(true);
        info_tecnicoTA.setBounds(322, 60, 300, 60);
        equipamentoPanel.add(info_tecnicoTA);
        
        info_entregaLabel = new JLabel("Informações interna");
        info_entregaLabel.setBounds(10, 134, 310, 14);
        equipamentoPanel.add(info_entregaLabel);        
        JTextArea info_entregaTA = new JTextArea(3, 200);
        info_entregaTA.setEditable(true);
        info_entregaTA.setBounds(10, 150, 300, 60);
        equipamentoPanel.add(info_entregaTA);
        
        info_internaLabel = new JLabel("Informações da entrega");
        info_internaLabel.setBounds(322, 134, 300, 14);
        equipamentoPanel.add(info_internaLabel);        
        JTextArea info_internaTA = new JTextArea(3, 200);
        info_internaTA.setEditable(true);
        info_internaTA.setBounds(322, 150, 300, 60);
        equipamentoPanel.add(info_internaTA);
        
        osTable = new JTable();
        osTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Cod", "Cliente", "Modelo", "Informação cliente", "Informação técnico"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		Integer.class, String.class, String.class, String.class, Object.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        osTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        osTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        osTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        osTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        osTable.getColumnModel().getColumn(4).setPreferredWidth(200);
        scrollPane.setViewportView(osTable);
        
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
			Os o = new Os();
			
			//Tratar a ação de salvar OS
			
			//tipo
			o.setTipo(tipoField.getText());			
			//modelo
			o.setModelo(modeloField.getText());			
			//marca
			o.setMarca(marcaField.getText());
			//cor
			o.setCor(corField.getText());
			//serie
			o.setSerie(serieField.getText());

			
			
			OsController controleOs = new OsController();
			try {
				if(controleOs.cadastrarOs(o) == true) {
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

