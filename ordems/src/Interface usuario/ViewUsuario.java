package com.ordems.usuario.gui;

//Importando os componentes
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Declarando a classe na janela
public class ViewUsuario extends JFrame{
  
  public ViewUsuario() { // construtor da view OS.
      super("OrdemS : Cadastro de Orden de Serviço");
      
      criaFormulario();
  }
  
  private void criaFormulario() {
      
      setLayout(new BorderLayout());
      
//Inicia o painel de título        
      JPanel painelTitulo = new JPanel();
      painelTitulo.setLayout(new FlowLayout());
      
      JLabel titulo = new JLabel("Cadstro de Usuário.");
      titulo.setFont(new Font("Arial", Font.BOLD, 14));
      
      painelTitulo.add(titulo);
      
//Inicia o painel dos campos digitáveis        
      JPanel painelCadastro = new JPanel();
      painelCadastro.setLayout(new FlowLayout());
      
                  
      JLabel statuaLabel = new JLabel("Usuario");
      JTextField statusField = new JTextField(20);
      painelCadastro.add(statuaLabel);
      painelCadastro.add(statusField);
      
      JLabel dataIniLabel = new JLabel("Cargo");
      JTextField dataIniField = new JTextField(20);
      painelCadastro.add(dataIniLabel);
      painelCadastro.add(dataIniField);
      
      JLabel dataFinLabel = new JLabel("Departamento");
      JTextField dataFinField = new JTextField(20);
      painelCadastro.add(dataFinLabel);
      painelCadastro.add(dataFinField);
      
      JLabel garantiaLabel = new JLabel("Matricula");
      JTextField garantiaField = new JTextField(20);
      painelCadastro.add(garantiaLabel);
      painelCadastro.add(garantiaField);
      
      JLabel tipoLabel = new JLabel("Login");
      JTextField tipoField = new JTextField(20);
      painelCadastro.add(tipoLabel);
      painelCadastro.add(tipoField);
      
      JLabel senhaLabel = new JLabel("Senha");
      JPasswordField senhaField = new JPasswordField(20);
      painelCadastro.add(senhaLabel);
      painelCadastro.add(senhaField);
      
      
      
                  
      
//Inicia o painel dos botoes
      JPanel painelBotoes = new JPanel();
      painelBotoes.setLayout(new FlowLayout());
      
      JButton botaoSalvar = new JButton("Salvar");
      JButton botaoCancelar = new JButton("Cancelar");
      
      painelBotoes.add(botaoSalvar);
      painelBotoes.add(botaoCancelar);
      
//Adicionando os paineis em suas respectivas posições        
      add(painelTitulo, BorderLayout.NORTH);
      add(painelCadastro, BorderLayout.CENTER);
      add(painelBotoes, BorderLayout.SOUTH);
      
  }
  

}


