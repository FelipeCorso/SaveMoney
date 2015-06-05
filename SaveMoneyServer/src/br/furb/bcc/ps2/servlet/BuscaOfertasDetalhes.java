package br.furb.bcc.ps2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.furb.bcc.ps2.provider.ContentProviderFactory;
import br.furb.bcc.ps2.utils.OfertaDetalhada;
import br.furb.bcc.ps2.utils.constants.Constant;

/**
 * Servlet implementation class BuscaOfertasDetalhes
 */
@WebServlet(name = "buscaDetalhes", urlPatterns = { "/buscaDetalhes" })
public class BuscaOfertasDetalhes extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String idOfertaDetalhes = request.getParameter(Constant.ID_OFERTA_DETALHADA);
	OfertaDetalhada ofertaDetalhada = ContentProviderFactory.getInstance().getContentProvider().buscaDetalhesOferta(Integer.valueOf(idOfertaDetalhes));

	request.setAttribute(Constant.OFERTA_DETALHADA, ofertaDetalhada);
    }

}
