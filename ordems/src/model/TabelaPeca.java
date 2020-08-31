package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.PecaDAO;

public class TabelaPeca extends AbstractTableModel{
	
	private ArrayList<Peca> listaPeca = new ArrayList<Peca>();
	private String [] colunas = {
			
			"Cod", "None", "Custo", "Venda"
	};

	
	///construtor
	public TabelaPeca() {
		addTodos();
	}

	public String getColumnName(int column) {

		return colunas[column];
	}
	
	public int getColumnCount() {

		return colunas.length;
	}

	public int getRowCount() {
		
		return listaPeca.size();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0: return listaPeca.get(rowIndex).getId();
			case 1: return listaPeca.get(rowIndex).getNm_peca();
			case 2: return listaPeca.get(rowIndex).getVl_custo();
			case 3: return listaPeca.get(rowIndex).getVl_venda();
		
		}
		return null;
	}
	
	
	public void addTodos() {
		this.listaPeca.clear();
		PecaDAO pd = new PecaDAO();
		try {
			this.listaPeca.addAll(pd.consultar());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Tam" + listaPeca.size());
		
	}
	public Peca getPeca(int linha) {
		return this.listaPeca.get(linha);
	}

}
