package view;

//Importando os componentes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import controller.UsuarioController;
import model.TabelaUsuario;
import model.Usuario;

//Declarando a classe na janela
public class UsuarioView extends JFrame implements ActionListener{
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
	private int id;
    
    public UsuarioView() { // construtor da view OS.
        super("Cadastro de Usuario");
        setTitle("Cadastro de Usi\u00E1rios");
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
        
        titulo = new JLabel("Cadastro de Usuario");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
        //Inicia o painel dos campos digitáveis        
        painelCadastro = new JPanel();
        
        //Inicia o painel dos botoes
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        
        botaoSalvar = new JButton("Salvar");		
        botaoEditar = new JButton("Editar");
        botaoExcluir = new JButton("Excluir");
        botaoCancelar = new JButton("Cancelar");
        
        getContentPane().add(painelCadastro, BorderLayout.WEST);
        
        JPanel usuarioPainel = new JPanel();
        usuarioPainel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        usuarioPainel.setLayout(null);
		
		
        
        JLabel label = new JLabel("Nome do usuário");
        label.setBounds(10, 11, 338, 14);
        usuarioPainel.add(label);        
        nm_usuarioField = new JTextField(50);
        nm_usuarioField.setBounds(10, 25, 529, 20);
        usuarioPainel.add(nm_usuarioField);
        
        cargoField = new JTextField(20);
        cargoField.setBounds(10, 69, 186, 20);
        usuarioPainel.add(cargoField);        
        JLabel label_1 = new JLabel("Cargo");
        label_1.setBounds(10, 56, 166, 14);
        usuarioPainel.add(label_1);
        
        JLabel label_2 = new JLabel("Departamento");
        label_2.setBounds(206, 56, 162, 14);
        usuarioPainel.add(label_2);        
        departamentoField = new JTextField(20);
        departamentoField.setBounds(206, 69, 186, 20);
        usuarioPainel.add(departamentoField);
        
        JLabel label_3 = new JLabel("Status");
        label_3.setBounds(402, 56, 137, 14);
        usuarioPainel.add(label_3);        
        statusField = new JTextField(20);
        statusField.setBounds(402, 69, 137, 20);
        usuarioPainel.add(statusField);
        
        JLabel label_4 = new JLabel("Senha");
        label_4.setBounds(402, 97, 137, 14);
        usuarioPainel.add(label_4);        
        senhaField = new JTextField(10);
        senhaField.setBounds(402, 111, 137, 20);
        usuarioPainel.add(senhaField);
        
        loginField = new JTextField(20);
        loginField.setBounds(206, 111, 186, 20);
        usuarioPainel.add(loginField);        
        JLabel label_5 = new JLabel("Login");
        label_5.setBounds(206, 99, 166, 14);
        usuarioPainel.add(label_5);
        
        JLabel label_6 = new JLabel("Matricula");
        label_6.setBounds(10, 100, 368, 14);
        usuarioPainel.add(label_6);        
        matriculaField = new JTextField(20);
        matriculaField.setBounds(10, 112, 186, 20);
        usuarioPainel.add(matriculaField);		
		
        //Criando a Tabela com os dados do banco        
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(new Color(192, 192, 192)));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        
        GroupLayout gl_painelCadastro = new GroupLayout(painelCadastro);
        gl_painelCadastro.setHorizontalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        				.addComponent(scrollPane, Alignment.LEADING)
        				.addComponent(usuarioPainel, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        gl_painelCadastro.setVerticalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(usuarioPainel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );
      
		//fazendo a ligação do modelo de tabela com o componente visual de janela
        tabelaUsuario = new TabelaUsuario();
        usuarioTable = new JTable(tabelaUsuario);
             
        scrollPane.setViewportView(usuarioTable);
        
        painelCadastro.setLayout(gl_painelCadastro);
        
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
		
        painelBotoes.add(botaoSalvar);        
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);
        painelBotoes.add(botaoCancelar);
		        
        botaoSalvar.addActionListener(this);
        botaoSalvar.setActionCommand("salvar");
		
        botaoEditar.addActionListener(this);
        botaoEditar.setActionCommand("editar");
		
        botaoExcluir.addActionListener(this);
        botaoExcluir.setActionCommand("excluir");
		
        botaoCancelar.addActionListener(this);
        botaoCancelar.setActionCommand("cancelar");
        

    }

    
	public void actionPerformed(ActionEvent e) {
		
			if(e.getActionCommand().equalsIgnoreCase("salvar")) {
				
				Usuario u = new Usuario();
				
				//Tratar a ação de salvar

				//nome
				u.setNm_usuario(nm_usuarioField.getText());			
				//Cargo
				u.setCargo(cargoField.getText());			
				//Depatamento
				u.setDepartamento(departamentoField.getText());
				//Matricula
				u.setMatricula(matriculaField.getText());
				//Login (email)
				u.setLogin(loginField.getText());
				//Senha
				u.setSenha(senhaField.getText());
				//Status(ativo ou inativo)
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
				
				else if(op == 1) { //Atualizar
					u.setId(this.id);
					UsuarioController controleUsuario = new UsuarioController();
					try {
						if(controleUsuario.atualizarUsuario(u) == true) {
							JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
							tabelaUsuario.addTodos();
							this.repaint();
						}
					} catch (HeadlessException | SQLException e1) {
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
			//Excluir
			int linha = usuarioTable.getSelectedRow();
			Usuario u = tabelaUsuario.getUsuario(linha);
			
			UsuarioController controleUsuario = new UsuarioController();
			try {
				controleUsuario.removerUsuario(u.getId());
				JOptionPane.showMessageDialog(null, " Cadastro excluído com sucesso!");
				tabelaUsuario.addTodos();
				this.repaint();
			} catch (SQLException e1) {
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
