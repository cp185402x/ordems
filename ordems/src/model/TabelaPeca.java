package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.PecaDAO;

public class TabelaPeca {
	
	
	private ArrayList<Peca> listaPeca = new ArrayList<Peca>();
	private String [] colunas = {
			
			"Nm_peca", "vl_custo", "vl_venda"
	};

	
	///construtor
	public TabelaPeca() {
		addTodos();
	}

	public String getColumnNn_usuario(int column) {

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
			case 0: return listaPeca.get(rowIndex).getNm_peca();
			case 1: return listaPeca.get(rowIndex).getVl_custo();
			case 2: return listaPeca.get(rowIndex).getVl_venda();
		
		
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

}
