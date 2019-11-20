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
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

import controller.UsuarioController;
import model.TabelaUsuario;
import model.Usuario;

//Declarando a classe na janela
public class UsuarioView extends JFrame implements ActionListener{
	private static final TableModel TabelaUsuario = null;
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JLabel titulo;
	
	JRadioButton cnpjRadio;
	JRadioButton cpfRadio;
	ButtonGroup tipoGrupo;
	
    JLabel nm_usuarioLabel;
    JTextField nm_usuarioField;
    
    JLabel cargoLabel;
    JTextField cargoField;
    
    JLabel matriculaLabel;
    JTextField matriculaField;
    
    JLabel departamentoLabel;
    JTextField departamentoField;

    JLabel loginLabel;
    JTextField loginField;
    
    JLabel senhaLabel;
    JTextField senhaField;
        
    
    
    //Inicia o painel dos botoes
    JPanel painelBotoes;
    JButton botaoSalvar;
    JButton botaoCancelar;
    
    private JTable usuarioTable;
    TabelaUsuario tabelaUsuario;
    
    private JTextField buscarField;
	private JTable usuarioTable;
	private TabelaUsuario tabelaUsuario;

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
        
        titulo = new JLabel("Cadastro de Usuario");
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
        
        nm_usuarioField = new JTextField(20);
        nm_usuarioField.setBounds(447, 137, 186, 20);
        usuarioPainel.add(nm_usuarioField);        
        nm_usuarioLabel = new JLabel("Nome Usuario");
        nm_usuarioLabel.setBounds(447, 125, 166, 14);
        usuarioPainel.add(nm_usuarioLabel);
        
        cargoField = new JTextField(40);
        cargoField.setBounds(10, 138, 427, 20);
        usuarioPainel.add(cargoField);        
        cargoLabel = new JLabel("cargo");
        cargoLabel.setBounds(10, 126, 368, 14);
        usuarioPainel.add(cargoLabel);
        
        
       
        departamentoLabel = new JLabel("departamento");
        departamentoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        departamentoLabel.setBounds(323, 10, 50, 14);
        usuarioPainel.add(departamentoLabel);
        departamentoField = new JTextField(20);
        departamentoField.setBounds(373, 7, 186, 20);
        usuarioPainel.add(departamentoField);
        
        loginLabel = new JLabel("login");
        loginLabel.setBounds(10, 37, 338, 14);
        usuarioPainel.add(loginLabel);
        loginField = new JTextField(40);
        loginField.setBounds(10, 51, 427, 20);
        usuarioPainel.add(loginField);
        
        senhaField = new JTextField(20);
        senhaField.setBounds(447, 50, 186, 20);
        usuarioPainel.add(senhaField);        
        senhaLabel = new JLabel("senha");
        senhaLabel.setBounds(447, 35, 156, 14);
        usuarioPainel.add(senhaLabel);
        
        matriculaField = new JTextField(20);
        matriculaField.setBounds(447, 50, 186, 20);
        usuarioPainel.add(matriculaField);        
        matriculaLabel = new JLabel("Matricula");
        matriculaLabel.setBounds(447, 35, 156, 14);
        usuarioPainel.add(matriculaLabel);
               
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel.setLayout(null); 
        
        
        
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
        usuarioTable = new JTable(TabelaUsuario);
        
             
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
    
    
	public void actionPerformed(ActionEvent e, Usuario u) {
		
		if(e.getActionCommand().equalsIgnoreCase("salvar")) {
			
			Usuario u = new Usuario();
			
			//Tratar a ação de salvar o cliente
			
			//Trata o radio do tipo de cliente
			
			}
			//nome
			u.setNm_usuario(nm_usuarioField.getText());			
			//documento
			u.setCargo(cargoField.getText());			
			//RGIE
			u.setDepartamento(departamentoField.getText());
			//fone fixo
			
			u.setDepartamento(matriculaField.getText());
			
			u.setLogin(loginField.getText());
			//celular
			u.setSenha(senhaField.getText());
			
			
			
			
			UsuarioController controleUsuario = new UsuarioController();
			try {
				if(controleUsuario.cadastrarUsuario(u) == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
					tabelaCliente.addTodos();
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
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
}

//

