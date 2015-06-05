package br.furb.bcc.ps2.provider.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.furb.bcc.ps2.provider.ContentProviderAbstract;
import br.furb.bcc.ps2.provider.ETypeContentProvider;
import br.furb.bcc.ps2.utils.Oferta;
import br.furb.bcc.ps2.utils.OfertaDetalhada;

public class DBProvider extends ContentProviderAbstract {

    private static final String STR_SQL_BUSCA = "SQL_BUSCA";
    private static final String SQL_BUSCA = "";
    private static final String STR_SQL_BUSCA_INICIAL = "SQL_BUSCA_INICIAL";
    private static final String SQL_BUSCA_INICIAL = "teste";
    private static final String STR_SQL_BUSCA_DETALHES = "SQL_BUSCA_DETALHES";
    private static final String SQL_BUSCA_DETALHES = "";
    private Map<String, String> queris = new HashMap<String, String>(3);;
    private static final DBProvider dbProvider = new DBProvider(ETypeContentProvider.DB);

    public DBProvider(ETypeContentProvider typeContentProvider) {
	super(typeContentProvider);
    }

    public static DBProvider getInstance() {
	return dbProvider;
    }

    /**
     * A ideia � que as queris, sejam escritas em arquivos SQL.<br>
     * O arquivo faz a carga das queris.
     */
    private void carregarQueris() {
	queris.put(STR_SQL_BUSCA, SQL_BUSCA);
	queris.put(STR_SQL_BUSCA_INICIAL, SQL_BUSCA_INICIAL);
	queris.put(STR_SQL_BUSCA_DETALHES, SQL_BUSCA_DETALHES);
    }

    /**
     * A ideia � que as queris, sejam escritas em arquivos SQL.<br>
     * Assim, esse m�todo for�a a recarrega das queris dos arquivos.
     */
    public void recarregarQueris() {
	queris.clear();
	carregarQueris();
    }

    public Map<String, String> getQueris() {
	return queris;
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

    public OfertaDetalhada buscaDetalhesOferta(String filtro, int idUltOferta) {
	return null;
    }

}
