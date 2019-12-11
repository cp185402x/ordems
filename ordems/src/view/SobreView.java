package view;

//Importando os componentes
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.LabelView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

//Declarando a classe na janela
public class SobreView extends JFrame implements ActionListener{
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelSobre;
	JLabel titulo;
	
    //Inicia o painel dos botoes
    JPanel 	painelBotoes;
    JButton botaoOk;
    
    public SobreView() { // construtor da view OS.
        super("Sobre o Projeto");
        setType(Type.UTILITY);
        
        criaFormulario();
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(530, 360);
    	this.setVisible(true);
    	this.setLocationRelativeTo(null);

    }
    
    private void criaFormulario() {
        
        getContentPane().setLayout(new BorderLayout());
        
        //Inicia o painel de título        
        JPanel painelTitulo = new JPanel();
        painelTitulo.setBorder(new LineBorder(Color.WHITE, 2));
        painelTitulo.setLayout(new FlowLayout());

 
        //Inicia o painel dos botoes
	    JPanel painelBotoes = new JPanel();
	    painelBotoes.setBorder(new LineBorder(Color.WHITE, 2));
	    painelBotoes.setLayout(new FlowLayout());
	    JButton botaoOk = new JButton("Ok");
	    
        
        //Inicia o painel dos campos digitáveis        
        JPanel painelSobre = new JPanel();
        painelSobre.setBackground(Color.WHITE);
        painelSobre.setBorder(new LineBorder(Color.WHITE, 2));
        

        //Adicionando os paineis em suas respectivas posições        
        getContentPane().add(painelTitulo, BorderLayout.NORTH);
        
        JLabel labelTitulo = new JLabel("Projeto Ordem-S");
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        painelTitulo.add(labelTitulo);
        getContentPane().add(painelSobre, BorderLayout.CENTER);
        painelSobre.setLayout(null);
        
        JLabel lblSistemaParaGerenciamento = new JLabel("Sistema para Gerenciamento de Ordens de Serviços");
        lblSistemaParaGerenciamento.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblSistemaParaGerenciamento.setBounds(214, 34, 290, 41);
        painelSobre.add(lblSistemaParaGerenciamento);
        
        JLabel lblVerso = new JLabel("Versão 1.3 ( Build id:  117)");
        lblVerso.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblVerso.setBounds(214, 101, 290, 41);
        painelSobre.add(lblVerso);
        
        JLabel label_2 = new JLabel("Copyright (C) 2019 VEC System. Todos o direitos reservados.");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_2.setBounds(10, 157, 494, 41);
        painelSobre.add(label_2);
        
        JLabel label_3 = new JLabel("O projeto é uma criação dos alunos do curso TDS (Técnico em Desenvolvimento de Sistemas)");
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_3.setBounds(10, 183, 494, 41);
        painelSobre.add(label_3);
        
        JLabel label_4 = new JLabel("em conjunto com o time de docentes da instituição de ensino IFSP Campus Campinas Amarais.");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_4.setBounds(10, 209, 494, 41);
        painelSobre.add(label_4);
        
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.WHITE);
        panelLogo.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelLogo.setBounds(10, 11, 190, 140);
        painelSobre.add(panelLogo);
        
       
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
        painelBotoes.add(botaoOk);
        botaoOk.addActionListener(this);
        botaoOk.setActionCommand("ok");
    }
       
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("ok")) {
 
			dispose();
		} 
	 }
}
