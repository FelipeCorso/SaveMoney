package br.furb.bcc.ps2.utils.db.tabelas;

public class Estabelecimento {

    private int id;
    private String nome;
    private int numero;
    private int cep;
    private String complemento;
    private Endereco endereco;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public int getNumero() {
	return numero;
    }

    public void setNumero(int numero) {
	this.numero = numero;
    }

    public int getCep() {
	return cep;
    }

    public void setCep(int cep) {
	this.cep = cep;
    }

    public String getComplemento() {
	return complemento;
    }

    public void setComplemento(String complemento) {
	this.complemento = complemento;
    }

    public Endereco getEndereco() {
	return endereco;
    }

    public void setEndereco(Endereco endereco) {
	this.endereco = endereco;
    }

}
