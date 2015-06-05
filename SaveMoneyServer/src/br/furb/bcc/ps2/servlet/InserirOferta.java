package br.furb.bcc.ps2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.furb.bcc.ps2.provider.ContentProviderFactory;
import br.furb.bcc.ps2.utils.db.tabelas.OfertaDetalhada;

/**
 * Servlet implementation class InserirOferta
 */
@WebServlet(name = "inserirOferta", urlPatterns = { "/inserirOferta" })
public class InserirOferta extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	OfertaDetalhada ofertaDetalhada = new OfertaDetalhada();

	ContentProviderFactory.getInstance().getContentProvider().inserirOferta(ofertaDetalhada);
    }

}
