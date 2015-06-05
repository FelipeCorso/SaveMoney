package br.furb.bcc.ps2.provider.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import br.furb.bcc.ps2.provider.ContentProviderAbstract;
import br.furb.bcc.ps2.provider.ETypeContentProvider;
import br.furb.bcc.ps2.utils.ECategoria;
import br.furb.bcc.ps2.utils.Endereco;
import br.furb.bcc.ps2.utils.Estabelecimento;
import br.furb.bcc.ps2.utils.Oferta;
import br.furb.bcc.ps2.utils.OfertaDetalhada;
import br.furb.bcc.ps2.utils.colunas.ColunasEndereco;
import br.furb.bcc.ps2.utils.colunas.ColunasEstabelecimento;
import br.furb.bcc.ps2.utils.colunas.ColunasOferta;
import br.furb.bcc.ps2.utils.constants.Constant;

public class DBProvider extends ContentProviderAbstract {

    /**
     * Arquivo que contém as queries SQL.
     */
    private static final String SQL_RESOURCE_FILE = "br.furb.bcc.ps2.queries.queries";
    private static final String SQL_BUSCA = "SQL_BUSCA";
    private static final String SQL_BUSCA_DETALHADA = "SQL_BUSCA_DETALHADA";
    private static final String SQL_BUSCA_FILTRO = "SQL_BUSCA_FILTRO";
    private Map<String, String> queris = new HashMap<String, String>(3);;
    private static final DBProvider dbProvider = new DBProvider(ETypeContentProvider.DB);

    public DBProvider(ETypeContentProvider typeContentProvider) {
	super(typeContentProvider);
	carregarQueris();
    }

    public static DBProvider getInstance() {
	return dbProvider;
    }

    /**
     * A ideia é que as queris, sejam escritas em arquivos SQL.<br>
     * O arquivo faz a carga das queris.
     */
    private void carregarQueris() {

	ResourceBundle bundle = ResourceBundle.getBundle(SQL_RESOURCE_FILE);

	queris.put(SQL_BUSCA, bundle.getString(SQL_BUSCA));
	queris.put(SQL_BUSCA_DETALHADA, bundle.getString(SQL_BUSCA_DETALHADA));
	queris.put(SQL_BUSCA_FILTRO, bundle.getString(SQL_BUSCA_FILTRO));
    }

    /**
     * A ideia é que as queris, sejam escritas em arquivos SQL.<br>
     * Assim, esse método força a recarrega das queris dos arquivos.
     */
    public void recarregarQueris() {
	queris.clear();
	carregarQueris();
    }

    public List<Oferta> buscaInicial() {
	return busca(0);

    }

    public List<Oferta> busca(int idUltOferta) {
	return buscaFiltro(Constant.FILTRO_EMPTY, idUltOferta);
    }

    public List<Oferta> buscaFiltro(String filtro, int idUltOferta) {
	try {
	    Connection connection = ConnectionFactory.getConnection();
	    List<Oferta> ofertas = new ArrayList<Oferta>();
	    String sql = MessageFormat.format(getQueris().get(SQL_BUSCA), idUltOferta, Constant.AND.concat(filtro));
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		// criando o objeto Oferta
		Oferta oferta = new Oferta();
		oferta.setId(rs.getInt(ColunasOferta.ID_OFERTA));
		oferta.setCategoria(ECategoria.valueOf(rs.getString(ColunasOferta.ID_CATEGORIA)));
		oferta.setTitulo(rs.getString(ColunasOferta.TITULO));
		oferta.setValor(rs.getDouble(ColunasOferta.VALOR));
		oferta.setLikes(rs.getInt(ColunasOferta.LIKES));
		oferta.setDislikes(rs.getInt(ColunasOferta.DISLIKES));

		// adicionando o objeto à lista
		ofertas.add(oferta);
	    }
	    rs.close();
	    stmt.close();
	    return ofertas;
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public OfertaDetalhada buscaDetalhesOferta(int idOferta) {
	try {
	    OfertaDetalhada ofertaDetalhada = new OfertaDetalhada();

	    Connection connection = ConnectionFactory.getConnection();
	    String sql = MessageFormat.format(getQueris().get(SQL_BUSCA_DETALHADA), idOferta);
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		ofertaDetalhada.setId(rs.getInt(ColunasOferta.ID_OFERTA));
		ofertaDetalhada.setCategoria(ECategoria.valueOf(rs.getString(ColunasOferta.ID_CATEGORIA)));
		ofertaDetalhada.setTitulo(rs.getString(ColunasOferta.TITULO));
		ofertaDetalhada.setValor(rs.getDouble(ColunasOferta.VALOR));
		ofertaDetalhada.setLikes(rs.getInt(ColunasOferta.LIKES));
		ofertaDetalhada.setDislikes(rs.getInt(ColunasOferta.DISLIKES));
		ofertaDetalhada.setUrlImagem(rs.getString(ColunasOferta.URL_IMG));
		ofertaDetalhada.setDetalhes(rs.getString(ColunasOferta.DETALHES));
		ofertaDetalhada.setDataCadastro(rs.getString(ColunasOferta.DATA_CADASTRO));

		Endereco endereco = new Endereco();
		endereco.setId(rs.getInt(ColunasEndereco.ID_ENDERECO));
		endereco.setRua(rs.getString(ColunasEndereco.RUA));
		endereco.setBairro(rs.getString(ColunasEndereco.BAIRRO));
		endereco.setCidade(rs.getString(ColunasEndereco.CIDADE));
		endereco.setEstado(rs.getString(ColunasEndereco.ESTADO));
		endereco.setPais(rs.getString(ColunasEndereco.PAIS));

		Estabelecimento estab = new Estabelecimento();
		estab.setId(rs.getInt(ColunasEstabelecimento.ID_ESTABELECIMENTO));
		estab.setEndereco(endereco);
		estab.setNome(rs.getString(ColunasEstabelecimento.NOME));
		estab.setNumero(rs.getInt(ColunasEstabelecimento.NUMERO));
		estab.setCep(rs.getInt(ColunasEstabelecimento.CEP));
		estab.setComplemento(rs.getString(ColunasEstabelecimento.COMPLEMENTO));

		ofertaDetalhada.setEstabelecimento(estab);

	    }
	    rs.close();
	    stmt.close();
	    return ofertaDetalhada;
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public Map<String, String> getQueris() {
	return queris;
    }

}
