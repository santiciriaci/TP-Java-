<%@page import="Entidades.Usuario"%>
<%@page import="Entidades.Ticket"%>
<%@page import="Entidades.Auto"%>
<%@page import="Logica.AutoLogic"%>
<%@page import="Logica.TicketLogic"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Tickets Cliente</title>
	<!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/start.css" rel="stylesheet">
    
    <link href="style/tabla.css" rel="stylesheet">

<%	
		Usuario u = (Usuario)session.getAttribute("usuario");	
		
    	
	    	int dni = (int)request.getAttribute("dni");
    		int mesIni = (int)request.getAttribute("mesIni");
    		int anoIni = (int)request.getAttribute("anoIni");
    		AutoLogic auLog=new AutoLogic();
    		TicketLogic ticLog = new TicketLogic();
    		LinkedList<Ticket> tickets = null;
    		
    		LinkedList<Auto> autos  = auLog.getAutosCte(dni);
    		
    		double impTotal = 0;
    		
	%>

</head>
<body class="bg-warning">
<div id="div4" style="position:relative;left:300px;top:50px;z-index:2;">
  		<H3 align="center">TICKETS</H3>
             <table  >
             
             <thead>
                   <tr>
                    <th>N° Ticket</th>
                    <th>Fecha servicio</th>
                     <th>Patente</th>
                     <th>Importe</th>
                  </tr>
             </thead>
             <tbody>
                  <% for (Auto au : autos) {
                	  tickets = ticLog.getTicketsPatente(au.getPatente(),mesIni,anoIni);
                	  for (Ticket ti : tickets){%>
                    <tr>
                    	<td><%=ti.getId() %></td>
                    	<td><%=ti.getFecha_horaIni()%></td>
                    	
                    	<td><%=ti.getNumpat()%></td>
                    	<td><%=ti.getImporte()%></td>
                    	
                    	
                    </tr>
                  <%  impTotal = impTotal + ti.getImporte();}
                	  }
                  System.out.println(impTotal);%>
                  
             </tbody>
             </table>  
             <h3 style="position:relative;left:170px;top:25px;z-index:2;">IMPORTE TOTAL $<%=impTotal%> </h3> 
             
             <form action="VolverServlet" method="post">
                <button id="btnVolver" name="btnVolver" class="btn btn-sm btn-default" type="submit">Volver
                </button>
                </form>
     </div>
</body>
</html>