package br.furb.bcc.ps2.utils.db.tabelas;


public class Oferta {

    private int id;
    private Categoria categoria;
    private String titulo;
    private double valor;
    private int likes;
    private int dislikes;

    public Categoria getCategoria() {
	return categoria;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
    }

    public String getTitulo() {
	return titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public double getValor() {
	return valor;
    }

    public void setValor(double valor) {
	this.valor = valor;
    }

    public int getLikes() {
	return likes;
    }

    public void setLikes(int likes) {
	this.likes = likes;
    }

    public int getDislikes() {
	return dislikes;
    }

    public void setDislikes(int dislikes) {
	this.dislikes = dislikes;
    }

}
