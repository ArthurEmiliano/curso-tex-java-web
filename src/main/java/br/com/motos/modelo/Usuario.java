package br.com.motos.modelo;

public class Usuario {

	private Integer id;
	private String nome;
	private String login;
	private String senha;
	
	public Usuario(int id, String nome, String login) {
		this.id = id;
		this.nome = nome;
		this.login = login;
	}
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}
	
}
