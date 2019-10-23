package model;

public class Cliente {
	
	//Atributos
    private String nome;
    private String documento;
    private String telefonecel;
    private String telefoneres;
    private String pessoa;
    private String rgie;
    private String email;
    private int dataNascimento;
    private Endereco endereco;
    private int tipo;
    private int id;
    
    //Construtor
    public Cliente(){
        this.endereco = new Endereco();
    
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefonecel() {
		return telefonecel;
	}

	public void setTelefonecel(String telefonecel) {
		this.telefonecel = telefonecel;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public String getRgie() {
		return rgie;
	}

	public void setRgie(String rgie) {
		this.rgie = rgie;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(int dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTelefoneres() {
		return telefoneres;
	}

	public void setTelefoneres(String telefoneres) {
		this.telefoneres = telefoneres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void add(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}
	
	
	
    
}


