package br.furb.bcc.ps2.utils.db.tabelas;

public enum Categoria {
    DESCONHECIDO(0, "Desconhecido"), ALIMENTO(1, "Alimento"), BEBIDA(2, "Bebida"), UTENSILIO(3, "Utensilio");

    private int id;
    private String descricao;

    private Categoria(int id, String descricao) {
	this.descricao = descricao;
    }

    public int getId() {
	return id;
    }

    @Override
    public String toString() {
	return descricao;
    }

    public static Categoria getFromValue(int id) {
	switch (id) {
	case 1:
	    return ALIMENTO;
	case 2:
	    return BEBIDA;
	case 3:
	    return UTENSILIO;
	default:
	    return DESCONHECIDO;
	}
    }
}
