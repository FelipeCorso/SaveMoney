package br.furb.bcc.ps2.provider;

import java.util.List;

import br.furb.bcc.ps2.utils.Oferta;
import br.furb.bcc.ps2.utils.OfertaDetalhada;

public interface IContentProvider {

	public List<Oferta> buscaInicial();

	public List<Oferta> buscaInicial(int idUltOferta);

	public List<Oferta> buscaInicial(String filtro, int idUltOferta);

	public OfertaDetalhada buscaDetalhesOferta(String filtro, int idUltOferta);

}
