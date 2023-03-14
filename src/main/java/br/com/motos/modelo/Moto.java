package br.com.motos.modelo;

public class Moto {
	
	private Integer id;
	private String marca;
	private String modelo;
	private Integer ano;
	
	public Moto(Integer id, String marca, String modelo, Integer ano) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}
	
	public Moto(String marca, String modelo, Integer ano) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}
	
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Integer getAno() {
		return ano;
	}

	@Override
	public String toString() {
		return "id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + " | ";
	}

	
	
}
