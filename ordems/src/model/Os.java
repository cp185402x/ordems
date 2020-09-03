package model;

import com.mysql.jdbc.StatementImpl;

public class Os {
	
	///Atributos
	private int id;
	private Cliente cliente;
	private Usuario usuario;
    private String data_os;
    private String data_previsao;
    private String data_pronto;
    private String data_entrega;
    private String tipo;
    private String modelo;
    private String marca;
    private String cor;
    private String serie;
    private int garantia;
    private String info_cliente;
    private String info_tecnico;
    private String info_entrega;
    private String info_interna;
    private String status_id;

    
    public Os() {
    	this.cliente = new Cliente();
    	this.usuario = new Usuario();
    }
   
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente_id) {
		this.cliente = cliente_id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario_id) {
		this.usuario = usuario_id;
	}
	public String getData_os() {
		return data_os;
	}
	public void setData_os(String data_os) {
		this.data_os = data_os;
	}
	public String getData_previsao() {
		return data_previsao;
	}
	public void setData_previsao(String data_previsao) {
		this.data_previsao = data_previsao;
	}
	public String getData_pronto() {
		return data_pronto;
	}
	public void setData_pronto(String data_pronto) {
		this.data_pronto = data_pronto;
	}
	public String getData_entrega() {
		return data_entrega;
	}
	public void setData_entrega(String data_entrega) {
		this.data_entrega = data_entrega;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public int getGarantia() {
		return garantia;
	}
	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}
	public String getInfo_cliente() {
		return info_cliente;
	}
	public void setInfo_cliente(String info_cliente) {
		this.info_cliente = info_cliente;
	}
	public String getInfo_tecnico() {
		return info_tecnico;
	}
	public void setInfo_tecnico(String info_tecnico) {
		this.info_tecnico = info_tecnico;
	}
	public String getInfo_entrega() {
		return info_entrega;
	}
	public void setInfo_entrega(String info_entrega) {
		this.info_entrega = info_entrega;
	}
	public String getInfo_interna() {
		return info_interna;
	}
	public void setInfo_interna(String info_interna) {
		this.info_interna = info_interna;
	}
	public String getStatus_id() {
		return status_id;
	}
	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Os [id=" + id + ", cliente=" + cliente + ", usuario_id=" + usuario.getId() + ", cliente_id=" + cliente.getId()
				+ ", data_os=" + data_os + ", data_previsao=" + data_previsao + ", data_pronto=" + data_pronto
				+ ", data_entrega=" + data_entrega + ", tipo=" + tipo + ", modelo=" + modelo + ", marca=" + marca
				+ ", cor=" + cor + ", serie=" + serie + ", garantia=" + garantia + ", info_cliente=" + info_cliente
				+ ", info_tecnico=" + info_tecnico + ", info_entrega=" + info_entrega + ", info_interna=" + info_interna
				+ ", status_id=" + status_id + "]";
	}


	
	
    
    }