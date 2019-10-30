package dao;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.FornecedorController;
import model.Fornecedor;
import dao.Conexao;

public class FornecedorDAO {
	//metodo inserir
	//metodo consultar
	//deletar 
	//atualizar
	//metodos sempre recebem objeto
	Connection conn = null;
	PreparedStatement st = null;
	
	
	public void inserir(Fornecedor fornecedor) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO fornecedor"
					+ "(usuario_id, nm_fornecedor, tipo_fornecedor, doc_num, rg_ie, celular, fone_re, email, pes_contato, cep, endereco, numero, complemento, bairro, cidade, estado) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do us		
		st.setString(2, fornecedor.getNm_fornecedor());
		st.setInt(3, fornecedor.getTipo());
		st.setString(4, fornecedor.getDoc_num());
		st.setString(5, fornecedor.getRg_ie());
		st.setString(6, fornecedor.getCelular());
		st.setString(7, fornecedor.getFone_re());
		st.setString(8, fornecedor.getEmail());
		st.setString(9, fornecedor.getPes_contato());
		st.setString(10, fornecedor.getEndereco().getCep());
		st.setString(11, fornecedor.getEndereco().getLogradouro());
		st.setString(12, fornecedor.getEndereco().getNumero());
		st.setString(13, fornecedor.getEndereco().getComplemento());
		st.setString(14, fornecedor.getEndereco().getBairro());
		st.setString(15, fornecedor.getEndereco().getCidade());
		st.setString(16, fornecedor.getEndereco().getEstado());
		
		st.execute();
		
		conn.close();
	}
	
	
	//----------------
	//Consulta Fornecedor
	
		public void consultar() throws SQLException {
			
			conn = (Connection) Conexao.getConexao();
			
			if(conn != null) {
				st = (PreparedStatement) conn.prepareStatement(
						"SELECT * FROM fornecedor");
			}
			

			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
	            Fornecedor fornecedor = new Fornecedor();

	            
	           System.out.println(rs.getInt("id_fornecedor"));
	           System.out.println(rs.getString("nm_fornecedor"));
	           System.out.println(rs.getString("email"));
	           System.out.println(rs.getString("celular"));
	           System.out.println(rs.getString("fone_re"));
	           System.out.println(rs.getString("doc_num"));
	           System.out.println(rs.getString("rg_ie"));
	           System.out.println(rs.getString("pes_contato"));

	           
	        }
			
			System.out.println("Resultado da consulta" + rs);
			
			conn.close();
			
			
		//----------------	
			
		}
		
		
		//metodo consultar
		
		public ArrayList<Fornecedor> getFornecedor() {
	        Connection conn = null;
	        PreparedStatement st = null;
	        ResultSet rs = null;
	        ArrayList<Fornecedor> listafornecedor = new ArrayList<Fornecedor>();
	        try {
	            conn = (Connection) Conexao.getConexao();
	            
	            if(conn != null) {
	    			st = (PreparedStatement) conn.prepareStatement(
	    					"SELECT * FROM fornecedor");
	    			
	    			rs = st.executeQuery();
	                while (rs.next()) {
	                    Fornecedor fornecedor = new Fornecedor();
	     
	                    //Fornecedor.setId(rs.getInt("id_Fornecedor"));
	                    fornecedor.setNm_fornecedor(rs.getString("nm_Fornecedor"));
	                    fornecedor.setCelular(rs.getString("celular"));
	                    fornecedor.setEmail(rs.getString("email"));
	                    
	                    listafornecedor.add(fornecedor);
	                }
	                conn.close();
	    		}
	            else {
	            	System.out.println("Conexão falhou!");
	            }
	            
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Erro ao listar fornecedor" + e.getMessage());
	        }
	        return listafornecedor;
	    }
		
	    }
	    

	 
	


