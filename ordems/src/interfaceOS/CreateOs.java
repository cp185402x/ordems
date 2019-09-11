package com.ordems.os.gui;

import javax.swing.JFrame;

public class CreateOs {
	
	public static void main(String[] args) {
		ViewOs ViewOs = new ViewOs();
		
		ViewOs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ViewOs.setSize(1024, 500);
		ViewOs.setVisible(true);
		ViewOs.setLocationRelativeTo(null);
	}

}
