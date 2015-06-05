package br.furb.bcc.ps2.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.furb.bcc.ps2.provider.ContentProviderFactory;
import br.furb.bcc.ps2.utils.constants.Constant;
import br.furb.bcc.ps2.utils.db.tabelas.Oferta;

/**
 * Servlet implementation class BuscaOfertasFiltro
 */
@WebServlet(name = "buscaFiltro", urlPatterns = { "/buscaFiltro" })
public class BuscaOfertasFiltro extends HttpServlet {
    private static final String PRIMEIRA_BUSCA = "0";
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	List<Oferta> listOfertas = null;

	String filtroOferta = request.getParameter(Constant.FILTRO_OFERTA);
	String idUltOferta = request.getParameter(Constant.ID_ULTIMA_OFERTA);

	if (idUltOferta == null) {
	    idUltOferta = PRIMEIRA_BUSCA;
	}

	listOfertas = ContentProviderFactory.getInstance().getContentProvider().buscaFiltro(filtroOferta, Integer.valueOf(filtroOferta));

	request.setAttribute(Constant.LISTA_OFERTAS, listOfertas);
    }

}
