package org.generation.blogPessoal.model;

public class UserLogin {
	
	
	private long id;
	
	private String nome;
	
	private String senha;
	
	private String token;
	
	private String usuario;
	
	private String foto;
	
	private String tipo;
	
	private String email;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
