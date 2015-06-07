package br.furb.bcc.ps2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.furb.bcc.ps2.utils.constants.Constant;
import br.furb.bcc.ps2.utils.db.tabelas.Oferta;

/**
 * Servlet implementation class SaveMoneyServlet
 */
@WebServlet("/SaveMoney")
public class SaveMoneyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // /**
    // * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    // */
    // // processa solicitaÁıes "get" dos clientes
    // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // response.setContentType("text/html");
    // PrintWriter out = response.getWriter();
    //
    // // envia p·gina de XHTML para o cliente
    //
    // // inicia o documento XHTML
    // out.println("<?xml version = \"1.0\"?>");
    //
    // out.printf("%s%s%s", "<!DOCTYPE html PUBLIC", " \"-//W3C//DTD XHTML 1.0 Strict//EN\"", " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
    //
    // out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");
    //
    // // cabe√ßalho do documento
    // out.println("<head>");
    // out.println("<title>Um exemplo simples com Servlet</title>");
    // out.println("</head>");
    //
    // // se√ß√£o do corpo do documento
    // out.println("<body>");
    // out.println("<h1>Servlet funcionando!</h1>");
    // out.println("</body>");
    //
    // // fim do documento XHTML
    // out.println("</html>");
    // out.close(); // fecha o fluxo para completar a p√°gina
    // } // fim do m√©todo doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// String nome = request.getParameter("nome");
	// String sobrenome = request.getParameter("sobrenome");
	// response.setContentType("text/html");
	// PrintWriter out = response.getWriter();
	// out.println("Bem Vindo<h3>" + nome + " " + sobrenome + "</h3>");
	// out.close();

	List<Oferta> listOfertas = null;

	String idUltOferta = request.getParameter(Constant.ID_ULTIMA_OFERTA);
	if (idUltOferta == null) {
	    // listOfertas = ContentProviderFactory.getInstance().getContentProvider().buscaInicial();
	} else {
	    // String idUltOferta = request.getParameter(Constant.ID_ULTIMA_OFERTA);
	    // if() {
	    //
	    // }
	}

	/*
	 */
	listOfertas = new ArrayList<Oferta>();
	Oferta oferta1 = new Oferta();
	oferta1.setTitulo("Oferta1");
	oferta1.setValor(100);

	Oferta oferta2 = new Oferta();
	oferta2.setTitulo("Oferta2");
	oferta2.setValor(150);

	listOfertas.add(oferta1);
	listOfertas.add(oferta2);

	request.setAttribute(Constant.LISTA_OFERTAS, listOfertas);

	/*
	 * Aqui deve ser montado algo como um JSON para retornar para o app
	 */
	response.setContentType("text/html");
	response.getWriter().write("oioioi");

	/* EXIBIR OFERTAS */
	// RequestDispatcher dispatcher = request.getRequestDispatcher("/exibirOfertas.jsp");
	// if (dispatcher != null) {
	// dispatcher.forward(request, response);
	// }

    }
}
