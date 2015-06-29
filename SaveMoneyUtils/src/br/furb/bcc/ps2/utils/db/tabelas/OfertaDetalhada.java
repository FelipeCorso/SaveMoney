package br.furb.bcc.ps2.utils.db.tabelas;

import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

public class OfertaDetalhada extends Oferta {

    private Categoria categoria;
    private String detalhes;
    private ImageIO imagem;
    private Date dataCadastro;
    private Date dataValidade;
    private String estabelecimento;
    private List<Comentario> listaComentario;

    public Categoria getCategoria() {
	return categoria;
    }

    public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
    }

    public String getDetalhes() {
	return detalhes;
    }

    public void setDetalhes(String detalhes) {
	this.detalhes = detalhes;
    }

    public ImageIO getImagem() {
	return imagem;
    }

    public void setImagem(ImageIO imagem) {
	this.imagem = imagem;
    }

    public Date getDataCadastro() {
	return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
	this.dataCadastro = dataCadastro;
    }

    public String getEstabelecimento() {
	return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
	this.estabelecimento = estabelecimento;
    }

    public List<Comentario> getListaComentario() {
	return listaComentario;
    }

    public void setListaComentario(List<Comentario> listaComentario) {
	this.listaComentario = listaComentario;
    }

    public void addComentario(Comentario comentario) {
	listaComentario.add(comentario);
    }

    public Date getDataValidade() {
	return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
	this.dataValidade = dataValidade;
    }

}
