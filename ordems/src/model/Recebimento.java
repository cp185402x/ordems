package model;

public class Recebimento {
	
	///Atributos
	private int id_recebimento;
	private Cliente cliente;
	private Usuario usuario;
    private Os os;
    private Peca peca;
    private String iformaPagamento;
    private String valorRecebimento;
    private String statusRecebimento;
    
    //Relaciona com o id_cliente
    public Recebimento() {
    	this.recebimento = new Recebimento();
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

	public String getStatusRecebimento() {
		return statusRecebimento;
	}
	public void setStatusRecebimento(String statusRecebimento) {
		this.statusRecebimento = statusRecebimento;
	}
	
	public int getId() {
		return id_recebimento;
	}


	public void setId(int id_recebimento) {
		this.id_recebimento = id_recebimento;
	}


	@Override
	public String toString() {
		return "Recebimento [id=" + id_recebimento + ", cliente=" + cliente + ", usuario=" + usuario + ", cliente_id=" + cliente.getId()
				+ ", data_os=" + data_os + ", data_previsao=" + data_previsao + ", data_pronto=" + data_pronto
				+ ", data_entrega=" + data_entrega + ", tipo=" + tipo + ", modelo=" + modelo + ", marca=" + marca
				+ ", cor=" + cor + ", serie=" + serie + ", garantia=" + garantia + ", info_cliente=" + info_cliente
				+ ", info_tecnico=" + info_tecnico + ", info_entrega=" + info_entrega + ", info_interna=" + info_interna
				+ ", status_id=" + status_id + "]";
	}

	
	
    
    }