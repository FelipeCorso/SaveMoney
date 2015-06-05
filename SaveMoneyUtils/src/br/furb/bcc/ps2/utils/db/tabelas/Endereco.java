package br.furb.bcc.ps2.utils.db.tabelas;

public class Endereco {

    private int id;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getRua() {
	return rua;
    }

    public void setRua(String rua) {
	this.rua = rua;
    }

    public String getBairro() {
	return bairro;
    }

    public void setBairro(String bairro) {
	this.bairro = bairro;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }

    public String getPais() {
	return pais;
    }

    public void setPais(String pais) {
	this.pais = pais;
    }

}
