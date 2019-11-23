package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.ClienteDAO;

public class TabelaCliente extends AbstractTableModel{

	private ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	private String [] colunas = {
			
			"Cod", "Nome", "Documento", "Celular", "E-Mail"
	};
	
	
	///construtor
	public TabelaCliente() {
		addTodos();
	}

	public String getColumnName(int column) {

		return colunas[column];
	}
	
	public int getColumnCount() {

		return colunas.length;
	}

	public int getRowCount() {
		
		return listaCliente.size();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0: return listaCliente.get(rowIndex).getId();
			case 1: return listaCliente.get(rowIndex).getNm_cliente();
			case 2: return listaCliente.get(rowIndex).getDoc_num();
			case 3: return listaCliente.get(rowIndex).getCelular();
			case 4: return listaCliente.get(rowIndex).getEmail();
		
		}
		return null;
	}
	
	
	public void addTodos() {
		this.listaCliente.clear();
		ClienteDAO cd = new ClienteDAO();
		try {
			this.listaCliente.addAll(cd.consultar());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Tam" + listaCliente.size());
		
	}
	
	public Cliente getCliente(int linha) {
		return this.listaCliente.get(linha);
	}

}

//
