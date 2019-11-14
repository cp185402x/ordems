package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.FornecedorDAO;

public class TabelaFornecedor extends AbstractTableModel{

	private ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
	private String [] colunas = {
			
			"Cod", "Nome", "Documento", "Celular", "E-Mail"
	};
	
	
	///construtor
	public TabelaFornecedor() {
		addTodos();
	}

	public String getColumnName(int column) {

		return colunas[column];
	}
	
	public int getColumnCount() {

		return colunas.length;
	}

	public int getRowCount() {
		
		return listaFornecedor.size();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0: return listaFornecedor.get(rowIndex).getId();
			case 1: return listaFornecedor.get(rowIndex).getNm_fornecedor();
			case 2: return listaFornecedor.get(rowIndex).getDoc_num();
			case 3: return listaFornecedor.get(rowIndex).getCelular();
			case 4: return listaFornecedor.get(rowIndex).getEmail();
		
		}
		return null;
	}
	
	
	public void addTodos() {
		this.listaFornecedor.clear();
		FornecedorDAO cd = new FornecedorDAO();
		try {
			this.listaFornecedor.addAll(cd.consultar());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Tam" + listaFornecedor.size());
		
	}

}

//
