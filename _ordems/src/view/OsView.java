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
import javax.swing.JTextField;

//Declarando a classe na janela
public class OsView extends JFrame{
	
	public OsView() { // construtor da view OS.
		super("OrdemS : Cadastro de Ordens de Serviços");
		
		criaFormulario();
	}
	
	private void criaFormulario() {
		
		setLayout(new BorderLayout());
		
//Inicia o painel de título		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setLayout(new FlowLayout());
		
		JLabel titulo = new JLabel("Cadastrar nova O.S.");
		titulo.setFont(new Font("Arial", Font.BOLD, 14));
		
		painelTitulo.add(titulo);
		
//Inicia o painel dos campos digitáveis		
		JPanel painelCadastro = new JPanel();
		painelCadastro.setLayout(new FlowLayout());
		
		JLabel documentoLabel = new JLabel("Ducumento");
		JTextField documentoField = new JTextField(24);
		painelCadastro.add(documentoLabel);
		painelCadastro.add(documentoField);
		
		JLabel nomeLabel = new JLabel("Cliente");
		JTextField nomeField = new JTextField(20);
		painelCadastro.add(nomeLabel);
		painelCadastro.add(nomeField);
		
		JLabel usuarioLabel = new JLabel("Usuario/Técnico");
		JTextField usuarioField = new JTextField(20);
		painelCadastro.add(usuarioLabel);
		painelCadastro.add(usuarioField);
		
		JLabel statuaLabel = new JLabel("Status");
		JTextField statusField = new JTextField(20);
		painelCadastro.add(statuaLabel);
		painelCadastro.add(statusField);
		
		JLabel dataPrevisaoLabel = new JLabel("Data previsão");
		JTextField dataPrevisaoField = new JTextField(20);
		painelCadastro.add(dataPrevisaoField);
		painelCadastro.add(dataPrevisaoField);
		
		JLabel dataProntoLabel = new JLabel("Data finalização");
		JTextField dataProntoField = new JTextField(20);
		painelCadastro.add(dataProntoLabel);
		painelCadastro.add(dataProntoField);
		
		JLabel dataRetiradaLabel = new JLabel("Data da retirada");
		JTextField dataRetiradaField = new JTextField(20);
		painelCadastro.add(dataRetiradaLabel);
		painelCadastro.add(dataRetiradaField);
		
		JLabel garantiaLabel = new JLabel("Garantia");
		JTextField garantiaField = new JTextField(20);
		painelCadastro.add(garantiaLabel);
		painelCadastro.add(garantiaField);
		
		JLabel tipoLabel = new JLabel("Tipo");
		JTextField tipoField = new JTextField(20);
		painelCadastro.add(tipoLabel);
		painelCadastro.add(tipoField);

//Dados do equipamento
		JLabel modeloLabel = new JLabel("Modelo");
		JTextField modeloField = new JTextField(20);
		painelCadastro.add(modeloLabel);
		painelCadastro.add(modeloField);
		
		JLabel marcaLabel = new JLabel("Marca");
		JTextField marcaField = new JTextField(20);
		painelCadastro.add(marcaLabel);
		painelCadastro.add(marcaField);
		
		JLabel corLabel = new JLabel("Cor");
		JTextField corField = new JTextField(20);
		painelCadastro.add(corLabel);
		painelCadastro.add(corField);
		
		JLabel serieLabel = new JLabel("Num. Serie");
		JTextField serieField = new JTextField(20);
		painelCadastro.add(serieLabel);
		painelCadastro.add(serieField);
		
// Inicia o painel dos botoes
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());
		
		JButton botaoSalvar = new JButton("Salvar");
		JButton botaoCancelar = new JButton("Cancelar");
		
		painelBotoes.add(botaoSalvar);
		painelBotoes.add(botaoCancelar);
		
		
		  botaoSalvar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("cliquei no botao salvar");
					//Documento
					String doc = documentoField.getText();
					System.out.println(doc);
					//Cliente
					String nomec = nomeField.getText();
					System.out.println(nomec);
					//usuario
					String usuario =usuarioField  .getText();
					System.out.println(usuario);
					//status
					String stats  = statusField .getText();
					System.out.println(stats);
					//datap
					String data   = dataPrevisaoField .getText();
					System.out.println(data);
					//datar
					String datar   = dataRetiradaField .getText();
					System.out.println(datar);
					//garantia
					String garantia   = garantiaField.getText();
					System.out.println(garantia);
					//tipo
					String tipo = tipoField .getText();
					System.out.println(tipo);
					//Modelo
					String  modelo = modeloField .getText();
					System.out.println(modelo);
					//marca
					String marca  = marcaField .getText();
					System.out.println(marca);
					//cor
					String cor =corField .getText();
					System.out.println(cor);
					//serie
					String serie   =serieField .getText();
					System.out.println(serie);
					
				
				}
	        	
	        });
		
//Adicionando os paineis em suas respectivas posições		
		add(painelTitulo, BorderLayout.NORTH);
		add(painelCadastro, BorderLayout.CENTER);
		add(painelBotoes, BorderLayout.SOUTH);
		
	}
	

}
