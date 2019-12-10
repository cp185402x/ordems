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

import controller.ClienteController;
import controller.UsuarioController;
import model.Usuario;
import model.Cliente;
import model.TabelaUsuario;

//Declarando a classe na janela
public class UsuarioView extends JFrame implements ActionListener{
	private int id;
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JLabel titulo;
	
    JLabel nm_usuarioLabel;
    JTextField nm_usuarioField;

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
    
    JLabel statusLabel;
    JTextField statusField;
    
    //Inicia o painel dos botoes
    JPanel painelBotoes;
    JButton botaoBuscar;
    JButton botaoEditar;
    JButton botaoExcluir;
    JButton botaoSalvar;
    JButton botaoCancelar;
    
    private JTable usuarioTable;
    private TabelaUsuario tabelaUsuario;
    
    private JTextField buscarField;

	public UsuarioView() { // construtor da view Usuario.
        super("Cadastro de Usuário");
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
        
        titulo = new JLabel("Cadastro de Usuário");
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
        
        statusField = new JTextField(20);
        statusField.setBounds(402, 95, 186, 20);
        usuarioPainel.add(statusField);
        statusLabel = new JLabel("Status");
        statusLabel.setBounds(402, 82, 186, 14);
        usuarioPainel.add(statusLabel);
        
        senhaField = new JTextField(10);
        senhaField.setBounds(402, 137, 188, 20);
        usuarioPainel.add(senhaField);
        senhaLabel = new JLabel("Senha");
        senhaLabel.setBounds(402, 123, 188, 14);
        usuarioPainel.add(senhaLabel);

        //Criando a Tabela com os dados do banco
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(Color.LIGHT_GRAY));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        
        botaoBuscar = new JButton("Buscar");        
        botaoEditar = new JButton("Editar");
        botaoExcluir = new JButton("Excluir");
        
        buscarField = new JTextField();
        buscarField.setBackground(new Color(250, 250, 210));
        buscarField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buscarField.setColumns(10);

        
        GroupLayout gl_painelCadastro = new GroupLayout(painelCadastro);
        gl_painelCadastro.setHorizontalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        				.addComponent(usuarioPainel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_painelCadastro.createSequentialGroup()
        					.addComponent(buscarField, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        					.addGap(18)
        					.addComponent(botaoBuscar)
        					.addGap(18)
        					.addComponent(botaoEditar)
        					.addGap(18)
        					.addComponent(botaoExcluir)))
        			.addGap(18))
        );
        gl_painelCadastro.setVerticalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(usuarioPainel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.BASELINE)
        				.addComponent(buscarField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(botaoExcluir)
        				.addComponent(botaoEditar)
        				.addComponent(botaoBuscar))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
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
        botaoExcluir.addActionListener(this);
        botaoExcluir.setActionCommand("excluir");
        botaoEditar.addActionListener(this);
        botaoEditar.setActionCommand("editar");

    }
    
    
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("salvar")) {
			
			Usuario u = new Usuario();
			
			//Tratar a ação de salvar o cliente

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
			
			Object[] opcoes = {"Salvar como novo cadastro", "Atualizar", "Limpar todos campos"};
			
			int op = JOptionPane.showOptionDialog(null, "Escolha uma opção para continuar", "Aviso",
		          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		              null, opcoes, opcoes[0]);
			
			if(op == 0) { //salvar um novo cliente
				UsuarioController controleUsuario = new UsuarioController();
				try {
					if(controleUsuario.cadastrarUsuario(u) == true) {
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
						tabelaUsuario.addTodos();
						this.repaint();
					}
					}
				 catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ops, houve um erro ao efetuar o cadastro!");
				}
			}
			
			else if(op == 1) { //ATUALIZAR O CLIENTE
				u.setId(this.id);
				UsuarioController controleUsuario = new UsuarioController();
				try {
					if(controleUsuario.atualizarUsuario(u) == true) {
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
						tabelaUsuario.addTodos();
						this.repaint();
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ops, houve um ao efetuar o cadastro!");
				}				
				
			}
			else {
				
				
				nm_usuarioField.setText("");
				departamentoField.setText("");
				cargoField.setText("");
				matriculaField.setText("");			
				loginField.setText("");
				senhaField.setText("");
				statusField.setText("");
				
				
			}
	
	}
	
		
		else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
			
			dispose();
	}
		else if(e.getActionCommand().equals("excluir")) {
		//tratar a exclusão
		int linha = usuarioTable.getSelectedRow();
		Usuario u = tabelaUsuario.getUsuario(linha);
		
		UsuarioController controleUsuario = new UsuarioController();
		try {
			controleUsuario.removerUsuario(u.getId());
			JOptionPane.showMessageDialog(null, " Cadastro excluído com sucesso!");
			tabelaUsuario.addTodos();
			this.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclusão");
		}
		
		
	}
		else if(e.getActionCommand().equals("editar")) {
		JOptionPane.showMessageDialog(null, "Deseja realmente editar o cadastro?");
		int linha = usuarioTable.getSelectedRow();
		Usuario u = tabelaUsuario.getUsuario(linha);
		
		//preencher os campos com os dados do cliente selecionado
		
		
		this.id =u.getId(); 
		nm_usuarioField.setText(u.getNm_usuario());
		departamentoField.setText(u.getDepartamento());
		cargoField.setText(u.getCargo());
		matriculaField.setText(u.getMatricula());			
		loginField.setText(u.getLogin());
		senhaField.setText(u.getSenha());
		
		
		
		
	
		
	}
		}
}
