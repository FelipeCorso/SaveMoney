package br.furb.bcc.ps2.utils;

public class Oferta {
	private ECategoria categoria;
	private String titulo;
	private double preco;
	private int likes;
	private int deslikes;

	public ECategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(ECategoria categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDeslikes() {
		return deslikes;
	}

	public void setDeslikes(int deslikes) {
		this.deslikes = deslikes;
	}

}
