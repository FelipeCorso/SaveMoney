package br.furb.bcc.ps2.provider;

import java.util.List;

import br.furb.bcc.ps2.utils.Oferta;

public class ContentProvider {
	private static ContentProvider contentProvider;

	private ContentProvider() {
	}

	public static ContentProvider getInstance() {
		if (contentProvider == null) {
			contentProvider = new ContentProvider();
		}
		return contentProvider;
	}

	public List<Oferta> buscaInicial() {
		return null;
	}

	public List<Oferta> buscaInicial(int idUltOferta) {
		return null;
	}

	public List<Oferta> buscaInicial(String filtro, int idUltOferta) {
		return null;
	}

	public Oferta buscaDetalhesOferta(String filtro, int idUltOferta) {
		return null;
	}

}
