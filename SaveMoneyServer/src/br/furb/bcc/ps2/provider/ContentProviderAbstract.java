package br.furb.bcc.ps2.provider;

import java.util.List;

import br.furb.bcc.ps2.utils.db.tabelas.Oferta;
import br.furb.bcc.ps2.utils.db.tabelas.OfertaDetalhada;

public abstract class ContentProviderAbstract {

    private ETypeContentProvider typeContentProvider;

    public ContentProviderAbstract(ETypeContentProvider typeContentProvider) {
	this.typeContentProvider = typeContentProvider;
    }

    public abstract List<Oferta> buscaInicial();

    public abstract List<Oferta> busca(int idUltOferta);

    public abstract List<Oferta> buscaFiltro(String filtro, int idUltOferta);

    public abstract OfertaDetalhada buscaDetalhesOferta(int idOferta);

    public abstract void inserirOferta(OfertaDetalhada ofertaDetalhada);

    public ETypeContentProvider getTypeContentProvider() {
	return typeContentProvider;
    }

    public void setTypeContentProvider(ETypeContentProvider typeContentProvider) {
	this.typeContentProvider = typeContentProvider;
    }

}
