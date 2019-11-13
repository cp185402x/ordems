package model;

public class Fornecedor {
	
	//Atributos
	private int id;
    private String nm_fornecedor;
    private String doc_num;
	private String rg_ie;
    private String celular;
    private String fone_re;
    private String email;
    private String pes_contato;
    private Endereco endereco;
    private int tipo_fornecedor;
    
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


    
    public String getNm_fornecedor() {
		return nm_fornecedor;
	}


	public void setNm_fornecedor(String nm_fornecedor) {
		this.nm_fornecedor = nm_fornecedor;
	}


	public String getDoc_num() {
		return doc_num;
	}


	public void setDoc_num(String doc_num) {
		this.doc_num = doc_num;
	}


	public String getRg_ie() {
		return rg_ie;
	}


	public void setRg_ie(String rg_ie) {
		this.rg_ie = rg_ie;
	}


	public String getFone_re() {
		return fone_re;
	}


	public void setFone_re(String fone_re) {
		this.fone_re = fone_re;
	}
	
	
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	
	public String getPes_contato() {
		return pes_contato;
	}

	public void setPes_contato(String pes_contato) {
		this.pes_contato = pes_contato;

	}
	public Fornecedor(Endereco endereco) {
		this.endereco = endereco;
	}

	
    //Construtor
	 public Fornecedor(){
	        this.endereco = new Endereco();
	    
	    }
		
		public int getTipo_fornecedor() {
		return tipo_fornecedor;
	}


	public void setTipo_fornecedor(int tipo_fornecedor) {
		this.tipo_fornecedor = tipo_fornecedor;
	}


		public int getTipo() {
			return tipo_fornecedor;
		}

		public void setTipo(int tipo) {
			this.tipo_fornecedor = tipo;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

	public String toString() {
		
		return "Cliente [id=" + id + ", nm_fornecedor=" + nm_fornecedor + ", doc_num=" + doc_num + ", rg_ie=" + rg_ie
				+ ", celular=" + celular + ", fone_re=" + fone_re + ", email=" + email + ", pes_contato=" + pes_contato
				+ ", endereco=" + endereco + ", tipo_fornecedor=" + tipo_fornecedor + "]";
	}





	
	
	 
		
	

	}
	