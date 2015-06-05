package br.furb.bcc.ps2.provider;

import java.util.List;

import br.furb.bcc.ps2.utils.Oferta;
import br.furb.bcc.ps2.utils.OfertaDetalhada;

public abstract class ContentProviderAbstract {

    private ETypeContentProvider typeContentProvider;

    public ContentProviderAbstract(ETypeContentProvider typeContentProvider) {
	this.typeContentProvider = typeContentProvider;
    }

    public abstract List<Oferta> buscaInicial();

    public abstract List<Oferta> buscaInicial(int idUltOferta);

    public abstract List<Oferta> buscaInicial(String filtro, int idUltOferta);

    public abstract OfertaDetalhada buscaDetalhesOferta(String filtro, int idUltOferta);

    public ETypeContentProvider getTypeContentProvider() {
	return typeContentProvider;
    }

    public void setTypeContentProvider(ETypeContentProvider typeContentProvider) {
	this.typeContentProvider = typeContentProvider;
    }

}
