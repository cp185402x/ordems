package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.UsuarioDAO;

public class TabelaUsuario extends AbstractTableModel {
	
	
	private ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	private String [] colunas = {
			
			"Nome", "Matrícula", "Cargo","Login", "Status"
			};
	
	
	///construtor
	public TabelaUsuario() {
		addTodos();
	}

	public String getColumnName(int column) {

		return colunas[column];
	}
	
	public int getColumnCount() {

		return colunas.length;
	}

	public int getRowCount() {
		
		return listaUsuario.size();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0: return listaUsuario.get(rowIndex).getNm_usuario();
			case 1: return listaUsuario.get(rowIndex).getMatricula();
			case 2: return listaUsuario.get(rowIndex).getCargo();
			case 4: return listaUsuario.get(rowIndex).getLogin();
			case 3: return listaUsuario.get(rowIndex).getStatus();
			
		
		}
		return null;
	}
	
	
	public void addTodos() {
		this.listaUsuario.clear();
		UsuarioDAO cd = new UsuarioDAO();
		try {
			this.listaUsuario.addAll(cd.consultar());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Tam" + listaUsuario.size());
		
	}

}

//
	
	
	
	
	


