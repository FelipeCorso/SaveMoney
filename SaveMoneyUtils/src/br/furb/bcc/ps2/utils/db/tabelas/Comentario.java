package br.furb.bcc.ps2.utils.db.tabelas;

public class Comentario {

    private int id;
    private String data;
    private Usuario usuario;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getData() {
	return data;
    }

    public void setData(String data) {
	this.data = data;
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

}
