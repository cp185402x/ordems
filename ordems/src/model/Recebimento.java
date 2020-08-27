package model;

public class Recebimento {
	
	///Atributos

	private int id;
	private Cliente cliente;
	private Usuario usuario;
    private Os os;
    private Peca peca;
    private String iformaPagamento;
    private String valorRecebimento;
    private String statusRecebimento;
	
    public Recebimento() {
    	this.cliente = new Cliente();
       	this.os = new Os();
    	this.peca = new Peca();
    }
    
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Os getOs() {
		return os;
	}


	public void setOs(Os os) {
		this.os = os;
	}


	public Peca getPeca() {
		return peca;
	}


	public void setPeca(Peca peca) {
		this.peca = peca;
	}


	public String getIformaPagamento() {
		return iformaPagamento;
	}


	public void setIformaPagamento(String iformaPagamento) {
		this.iformaPagamento = iformaPagamento;
	}


	public String getValorRecebimento() {
		return valorRecebimento;
	}


	public void setValorRecebimento(String valorRecebimento) {
		this.valorRecebimento = valorRecebimento;
	}


	public String getStatusRecebimento() {
		return statusRecebimento;
	}


	public void setStatusRecebimento(String statusRecebimento) {
		this.statusRecebimento = statusRecebimento;
	}

    
	@Override
	public String toString() {
		return "Recebimento [id=" + id + ", cliente=" + cliente + ", usuario=" + usuario + ", cliente_id=" + cliente.getId()
				+ ", os=" + os + ", id=" + os.getId() + ", peca=" + peca + ", id=" + peca.getId() + ", iformaPagamento=" + iformaPagamento
				+ ", valorRecebimento=" + valorRecebimento +", statusRecebimento=" + statusRecebimento + "]";
	}

	
	
    
    }