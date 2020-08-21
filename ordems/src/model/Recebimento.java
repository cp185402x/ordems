package model;

public class Recebimento {
	
	///Atributos
	private int id;
	private Cliente cliente;
	private int usuario_id;
    private String data_os;
    private String info_cliente;
    private String info_tecnico;
    private String info_entrega;
    private String info_interna;
    private String status_id;

    
    public Recebimento() {
    	this.cliente = new Cliente();
    }
   
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente_id) {
		this.cliente = cliente_id;
	}
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getData_os() {
		return data_os;
	}
	public void setData_os(String data_os) {
		this.data_os = data_os;
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
		return "Recebimento [id=" + id + ", cliente=" + cliente + ", usuario_id=" + usuario_id + ", cliente_id=" + cliente.getId()
				+ ", data_os=" + data_os + ", data_previsao=" + data_previsao + ", data_pronto=" + data_pronto
				+ ", data_entrega=" + data_entrega + ", tipo=" + tipo + ", modelo=" + modelo + ", marca=" + marca
				+ ", cor=" + cor + ", serie=" + serie + ", garantia=" + garantia + ", info_cliente=" + info_cliente
				+ ", info_tecnico=" + info_tecnico + ", info_entrega=" + info_entrega + ", info_interna=" + info_interna
				+ ", status_id=" + status_id + "]";
	}

	
	
    
    }