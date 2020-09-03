package model;



//Classe apenas do endereço
public class Endereco {

	private String TRUA;
	private String TBAIRRO;
	private String TCIDADE;
	private String CESTADO;
	private String complemento;
	private String TCEP;
	private String numero;

	
	public String getTRUA() {
		return TRUA;
	}

	public void setTRUA(String tRUA) {
		TRUA = tRUA;
	}

	public String getTBAIRRO() {
		return TBAIRRO;
	}

	public void setTBAIRRO(String tBAIRRO) {
		TBAIRRO = tBAIRRO;
	}

	public String getTCIDADE() {
		return TCIDADE;
	}

	public void setTCIDADE(String tCIDADE) {
		TCIDADE = tCIDADE;
	}

	public String getCESTADO() {
		return CESTADO;
	}

	public void setCESTADO(String cESTADO) {
		CESTADO = cESTADO;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTCEP() {
		return TCEP;
	}

	public void setTCEP(String tCEP) {
		TCEP = tCEP;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


}


