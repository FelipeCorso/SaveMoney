package br.furb.bcc.ps2.utils.db.tabelas;

import java.util.List;

public class OfertaDetalhada extends Oferta {

    private String detalhes;
    private String urlImagem;
    private String dataCadastro;
    private Estabelecimento estabelecimento;
    private List<Comentario> listaComentario;

    public String getDetalhes() {
	return detalhes;
    }

    public void setDetalhes(String detalhes) {
	this.detalhes = detalhes;
    }

    public String getUrlImagem() {
	return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
	this.urlImagem = urlImagem;
    }

    public String getDataCadastro() {
	return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
	this.dataCadastro = dataCadastro;
    }

    public Estabelecimento getEstabelecimento() {
	return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
	this.estabelecimento = estabelecimento;
    }

    public List<Comentario> getListaComentario() {
	return listaComentario;
    }

    public void setListaComentario(List<Comentario> listaComentario) {
	this.listaComentario = listaComentario;
    }

}
