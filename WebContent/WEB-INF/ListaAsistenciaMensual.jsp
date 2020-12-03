<%@page import="Entidades.Usuario"%>
<%@page import="Logica.UsuarioLogic"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Asistencia mensual de clientes</title>
<!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/start.css" rel="stylesheet">
    
    <link href="style/tabla.css" rel="stylesheet">
    
    <%
    Usuario u = (Usuario)session.getAttribute("usuario");
    		int mesIni = (int)request.getAttribute("mesIni");
    		int anoIni = (int)request.getAttribute("anoIni");
    		UsuarioLogic usuLog = new UsuarioLogic();
    		LinkedList<Usuario> clientes = usuLog.clientesMensuales(mesIni,anoIni);
    		System.out.println(clientes);
    		
    		
    %>
</head>
<body class="bg-warning">
<div id="div4" style="position:relative;left:300px;top:50px;z-index:2;">
  		<H3 align="center">TICKETS</H3>
             <table  >
             
             <thead>
                   <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                     <th>Mail</th>
                     <th>Telefono</th>
                     <th>Cantidad</th>
                  </tr>
             </thead>
             <tbody>
                  <% for (Usuario us:clientes) { %>
                	 
                      <tr>
                    	<td><%=us.getNombre() %></td>
                    	<td><%=us.getApellido() %></td>
                    	<td><%=us.getMail() %></td>
                    	<td><%=us.getTel() %></td>
                    	<td><%=us.getVisitasMes() %></td>
                    	
                    	
                    	
                    </tr>
                 
                  <% } %>
             </tbody>
             </table>  
             
     </div>
</body>
</html>