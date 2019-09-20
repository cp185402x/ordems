package teste;

import javax.swing.JFrame;

import view.OsView;

public class TesteCreateOs {
	
	public static void main(String[] args) {
		OsView ViewOs = new OsView();
		
		ViewOs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ViewOs.setSize(1024, 500);
		ViewOs.setVisible(true);
		ViewOs.setLocationRelativeTo(null);
	}

}
