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

public class SobreView extends JFrame implements ActionListener{
	//atributos globais da classe
		JPanel painelTitulo;
		JPanel painelSobre;
		JLabel titulo;		
	    JLabel ordemsLabel;
	    
	  //Inicia o painel dos botoes
	    JPanel painelBotoes;
	    JButton botaoOk;

	    public SobreView() { // construtor da view Usuario.
			super("Sobre o Sistema");
			setAlwaysOnTop(true);
			setTitle("Sobre o Sistema");
			setResizable(false);
					                
	        criaFormulario();
	    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	this.setSize(512, 350);
	    	this.setLocationRelativeTo(null);
     
	    }
  
  private void criaFormulario() {
      
      getContentPane().setLayout(new BorderLayout());
      
//Inicia o painel de título        
      painelTitulo = new JPanel();
      painelTitulo.setLayout(new FlowLayout());
      
      titulo = new JLabel("Ordem-S");
      titulo.setFont(new Font("Arial", Font.BOLD, 14));
      painelTitulo.add(titulo);
      
//Inicia o painel com os dados       
      JPanel painelSobre = new JPanel();
      painelSobre.setLayout(new FlowLayout());
                        
      painelSobre = new JPanel();
      painelSobre.setLayout(null);
      
      ordemsLabel = new JLabel("Ordem-S Sistema de Gerenciamento de ordens de servi\u00E7os");
      ordemsLabel.setBounds(49, 35, 504, 41);
      painelSobre.add(ordemsLabel);                  
      
//Inicia o painel dos botoes
      painelBotoes = new JPanel();
      painelBotoes.setLayout(new FlowLayout());
      botaoOk = new JButton("Ok");
      painelBotoes.add(botaoOk);
      botaoOk.addActionListener(this);
      botaoOk.setActionCommand("ok");
      
      getContentPane().add(painelTitulo, BorderLayout.NORTH);
      getContentPane().add(painelSobre, BorderLayout.CENTER);
      
      JLabel VersaoLabel = new JLabel("Vers\u00E3o 1.3 ( Compila\u00E7\u00E3o 62)");
      VersaoLabel.setBounds(49, 87, 504, 41);
      painelSobre.add(VersaoLabel);
      
      JLabel copyrightLabel = new JLabel("Copyright (C) 2019 VEC System. Todos o direitos reservados.");
      copyrightLabel.setBounds(49, 139, 504, 41);
      painelSobre.add(copyrightLabel);
      
      JLabel projetoLabel = new JLabel("O projeto \u00E9 uma cria\u00E7\u00E3o dos alunos do curso TDS (T\u00E9cnico em Desenvolvimento de Sistemas)");
      projetoLabel.setBounds(49, 180, 504, 41);
      painelSobre.add(projetoLabel);
      
      JLabel ifspLabel = new JLabel("em conjunto com o time de docentes da institui\u00E7\u00E3o de ensino IFSP campus Campinas Amarais.");
      ifspLabel.setBounds(49, 207, 504, 41);
      painelSobre.add(ifspLabel);
      
      JLabel licencaLabel = new JLabel("Este projeto ainda n\u00E3o tem definido um termo de licen\u00E7a.");
      licencaLabel.setBounds(49, 297, 504, 41);
      painelSobre.add(licencaLabel);
      
      getContentPane().add(painelBotoes, BorderLayout.SOUTH);
  }

public void actionPerformed(ActionEvent e) {
	
	
}


}




