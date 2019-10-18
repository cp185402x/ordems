package teste;

import javax.swing.JFrame;

import view.OsView;

public class TesteCreateOs {
	
	public static void main(String[] args) {
		OsView OsView = new OsView();
		
		OsView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OsView.setSize(1024, 500);
		OsView.setVisible(true);
		OsView.setLocationRelativeTo(null);
	}

}
