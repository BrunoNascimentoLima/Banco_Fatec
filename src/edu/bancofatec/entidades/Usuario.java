package edu.bancofatec.entidades;

public class Usuario {

	private Long id;
	private String usuario,nome,email,telefone,senha,perfil;
	
	
    public Usuario(){}	
	
	public Usuario(Long id, String usuario, String nome, String email,
			String telefone, String senha, String perfil) {
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.perfil = perfil;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getUsuario() {
		return usuario;
	}




	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getTelefone() {
		return telefone;
	}




	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	public String getPerfil() {
		return perfil;
	}




	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	

}
