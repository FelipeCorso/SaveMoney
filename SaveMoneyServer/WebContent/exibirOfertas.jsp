<%@page import="br.furb.bcc.ps2.utils.db.tabelas.Oferta"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
		     <%
				List<Oferta> listOferta = (List<Oferta>) request.getAttribute("listaOfertas");
	 		     for (Oferta oferta : listOferta ) {
		     %>
		       <tr>
		         <td><%=oferta.getTitulo() %></td> 
		         <td><%=oferta.getValor() %></td>
		       </tr>
		     <%
	 		     }
		     %>
	   	</table>
	</body>
</html>