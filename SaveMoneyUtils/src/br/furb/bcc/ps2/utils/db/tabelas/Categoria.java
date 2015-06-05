package br.furb.bcc.ps2.utils.db.tabelas;

public enum Categoria {
    ALIMENTOS("Alimentos"), BEBIDAS("Bebidas"), UTENSILIOS("Utensilios");

    private int id;
    private String descricao;

    private Categoria(String descricao) {
	this.descricao = descricao;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }
}
