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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

import controller.ClienteController;
import controller.UsuarioController;
import model.Usuario;
import model.TabelaUsuario;

//Declarando a classe na janela
public class UsuarioView extends JFrame implements ActionListener{
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JLabel titulo;
	
	//JRadioButton cnpjRadio;
	//JRadioButton cpfRadio;
	//ButtonGroup tipoGrupo;
	
    JLabel nm_usuarioLabel;
    JTextField nm_usuarioField;
    
    //JLabel dataNascLabel;
    //JTextField dataNascField;
    
    //JTextField docField;
    
    //JLabel rgieLabel;
    //JTextField rgieField;

    JLabel departamentoLabel;
    JTextField departamentoField;
    
    JLabel cargoLabel;
    JTextField cargoField;
        
    JLabel matriculaLabel;
    JTextField matriculaField;
    
    JLabel loginLabel;
    JTextField loginField;
    
    JLabel senhaLabel;
    JTextField senhaField;
    
    //JLabel enderecoLabel;
    //JTextField enderecoField;
    
    //JLabel numeroLabel;
    //JTextField numeroField;
    
    JLabel statusLabel;
    JTextField statusField;
    
    //JLabel bairroLabel;
    //JTextField bairroField;
    
    //JLabel cidadeLabel;
    //JTextField cidadeField;
    
    //JLabel estadoLabel;
    //JTextField estadoField;
    
    //Inicia o painel dos botoes
    JPanel painelBotoes;
    JButton botaoSalvar;
    JButton botaoCancelar;
    
    private JTable usuarioTable;
    TabelaUsuario tabelaUsuario;
    
    private JTextField buscarField;

	public UsuarioView() { // construtor da view Usuario.
        super("Cadastro de Usuario");
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
        
        titulo = new JLabel("Cadastro de Uusuario");
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
        
        JPanel usuarioPainel = new JPanel();
        usuarioPainel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        usuarioPainel.setLayout(null);
        
        loginField = new JTextField(20);
        loginField.setBounds(206, 137, 186, 20);
        usuarioPainel.add(loginField);        
        loginLabel = new JLabel("Login");
        loginLabel.setBounds(206, 125, 166, 14);
        usuarioPainel.add(loginLabel);
        
        matriculaField = new JTextField(20);
        matriculaField.setBounds(10, 138, 186, 20);
        usuarioPainel.add(matriculaField);        
        matriculaLabel = new JLabel("Matricula");
        matriculaLabel.setBounds(10, 126, 368, 14);
        usuarioPainel.add(matriculaLabel);
        
               
        nm_usuarioLabel = new JLabel("Usuário");
        nm_usuarioLabel.setBounds(10, 37, 338, 14);
        usuarioPainel.add(nm_usuarioLabel);
        nm_usuarioField = new JTextField(50);
        nm_usuarioField.setBounds(10, 51, 427, 20);
        usuarioPainel.add(nm_usuarioField);
        
                      
        cargoField = new JTextField(20);
        cargoField.setBounds(10, 95, 186, 20);
        usuarioPainel.add(cargoField);        
        JLabel cargoLabel = new JLabel("Cargo");
        cargoLabel.setBounds(10, 82, 166, 14);
        usuarioPainel.add(cargoLabel);
        
        departamentoField = new JTextField(20);
        departamentoField.setBounds(206, 95, 186, 20);
        usuarioPainel.add(departamentoField);        
        departamentoLabel = new JLabel("Departamento");
        departamentoLabel.setBounds(206, 82, 162, 14);
        usuarioPainel.add(departamentoLabel);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel.setLayout(null); 
        
        senhaField = new JTextField(10);
        senhaField.setBounds(10, 25, 186, 20);
        panel.add(senhaField);        
        senhaLabel = new JLabel("Senha");
        senhaLabel.setBounds(10, 11, 86, 14);
        panel.add(senhaLabel);
        
        /*
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
        */
        statusField = new JTextField(20);
        statusField.setBounds(10, 69, 186, 20);
        panel.add(statusField);        
        statusLabel = new JLabel("Status");
        statusLabel.setBounds(10, 56, 127, 14);
        panel.add(statusLabel);
        
        /*
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
        */
        
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
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        				.addGroup(Alignment.TRAILING, gl_painelCadastro.createSequentialGroup()
        					.addComponent(buscarField, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
        					.addGap(18)
        					.addComponent(buscarBtn)
        					.addGap(18)
        					.addComponent(editarBtn)
        					.addGap(18)
        					.addComponent(excluirBtn))
        				.addComponent(usuarioPainel, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE))
        			.addGap(18))
        );
        gl_painelCadastro.setVerticalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(usuarioPainel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.BASELINE)
        				.addComponent(buscarField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(excluirBtn)
        				.addComponent(editarBtn)
        				.addComponent(buscarBtn))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );

        
        tabelaUsuario = new TabelaUsuario();
        usuarioTable = new JTable(tabelaUsuario);
        
             
        scrollPane.setViewportView(usuarioTable);
        
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
			
			Usuario u = new Usuario();
			
			//Tratar a ação de salvar o cliente
			
			//Tipo
			//System.out.println("cargo: " +u.getCargo());
			//nome
			u.setNm_usuario(nm_usuarioField.getText());			
			//documento
			u.setCargo(cargoField.getText());			
			//RGIE
			u.setDepartamento(departamentoField.getText());
			//fone fixo
			u.setMatricula(matriculaField.getText());
			//celular
			u.setLogin(loginField.getText());
			//email
			u.setSenha(senhaField.getText());
			//pessoa contato
			u.setStatus(statusField.getText());
			
			
			
				
			
			UsuarioController controleUsuario = new UsuarioController();
			try {
				if(controleUsuario.cadastrarUsuario(u) == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
					tabelaUsuario.addTodos();
					this.repaint();
				}
			}
			 catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro!");
			}
	
		}
		else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
		
				dispose();
		}
	}
}
//

