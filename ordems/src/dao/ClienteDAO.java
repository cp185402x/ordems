package dao;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.ClienteController;
import model.Cliente;
import dao.Conexao;

public class ClienteDAO {
	//metodo inserir
	//metodo consultar
	//deletar 
	//atualizar
	//metodos sempre recebem objeto
	Connection conn = null;
	PreparedStatement st = null;
	
	
	public void inserir(Cliente cliente) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO cliente"
					+ "(usuario_id, nm_cliente, tipo_cliente, doc_num, rg_ie, celular, fone_re, email, pes_contato, cep, endereco, numero, complemento, bairro, cidade, estado) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do usuário		
		st.setString(2, cliente.getNm_cliente());
		st.setInt(3, cliente.getTipo());
		st.setString(4, cliente.getDoc_num());
		st.setString(5, cliente.getRg_ie());
		st.setString(6, cliente.getCelular());
		st.setString(7, cliente.getFone_re());
		st.setString(8, cliente.getEmail());
		st.setString(9, cliente.getPes_contato());
		st.setString(10, cliente.getEndereco().getCep());
		st.setString(11, cliente.getEndereco().getLogradouro());
		st.setString(12, cliente.getEndereco().getNumero());
		st.setString(13, cliente.getEndereco().getComplemento());
		st.setString(14, cliente.getEndereco().getBairro());
		st.setString(15, cliente.getEndereco().getCidade());
		st.setString(16, cliente.getEndereco().getEstado());
		
		st.execute();
		
		conn.close();
	//----------------	
		
	}
	
	
	public void consultar() throws SQLException {
		
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"SELECT * FROM cliente");
		}
		

		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
            Cliente cliente = new Cliente();
            System.out.println(rs.getInt("id_cliente"));
            System.out.println(rs.getString("nm_cliente"));

           /* cliente.setId(rs.getInt("id_cliente"));
            cliente.setNome(rs.getString("nm_cliente"));
            cliente.setCelular(rs.getString("celular"));
            cliente.setEmail(rs.getString("email"));
            cliente.add(cliente);
           */
        }
		
		System.out.println("Resultado da consulta" + rs);
		
		conn.close();
	//----------------	
		
	}
	//metodo consultar
	/*
	public List<Cliente> getCliente() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
 
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nm_cliente"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
                cliente.add(cliente);
            }
            Conexao.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Cliente" + e.getMessage());
        }
        return cliente;
    }
	
	
 
    public Cliente getClienteById(int id_cliente) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id_cliente);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nm_cliente"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
            }
            Conexao.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar cliente" + e.getMessage());
        }
        return cliente;
    }
    
*/
}



