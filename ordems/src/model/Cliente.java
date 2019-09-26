package model;

public class Cliente {
	
	//Atributos
    private String nome;
    private String documento;
    private String telefonecel;
    private String pessoa;
    private String rgie;
    private String email;
    private int dataNascimento;
    private Endereco endereco;
    
    //Construtor
    public Cliente(){
        this.endereco = new Endereco();
    
    }

	private String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	private String getDocumento() {
		return documento;
	}

	private void setDocumento(String documento) {
		this.documento = documento;
	}

	private String getTelefonecel() {
		return telefonecel;
	}

	private void setTelefonecel(String telefonecel) {
		this.telefonecel = telefonecel;
	}

	private String getPessoa() {
		return pessoa;
	}

	private void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	private String getRgie() {
		return rgie;
	}

	private void setRgie(String rgie) {
		this.rgie = rgie;
	}

	private String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private int getDataNascimento() {
		return dataNascimento;
	}

	private void setDataNascimento(int dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
    
}


