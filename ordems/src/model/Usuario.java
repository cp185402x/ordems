package model;

public class Usuario {
	
	///Atributos
    private String nm_usuario;
	private String cargo;
    private String departamento;
    private String matricula;
    private String login;
    private String senha;
    private int status;
		
	
	public String getNm_usuario() {
		return nm_usuario;
	}
	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getMatricula() {
		return matricula;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void setStatus(String text) {
		
	}
	
}
    