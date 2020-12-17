<%@page import="Entidades.Usuario"%>
<%@page import="Entidades.Lugar"%>
<%@page import="Entidades.Tarifa"%>
<%@page import="Logica.LugarLogic"%>
<%@page import="Logica.TarifaLogic"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">
	<title>Java Web Intro</title>
	
	
	
	<!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/start.css" rel="stylesheet">
    
    <link href="style/tabla.css" rel="stylesheet">
	
	<%	
		Usuario u = (Usuario)session.getAttribute("usuario");	
		if (!(u.getTipoUs()) ){
			request.getRequestDispatcher("index.html").forward(request, response);
		}
    		LugarLogic lugLogic = new LugarLogic();
	    	LinkedList<Lugar> lug = lugLogic.getAll();
	    	
	    TarifaLogic tarLog = new TarifaLogic();
	    Tarifa tar = tarLog.getActual();
	%>
	
</head>
<body class="bg-warning">
      <h3 style="text-align:center">Administrador: <%=u.getUsuario() %></h3>
      <div style="position:absolute;top:0px;left:90%;background-color: #ff9;">
      <form action="LogOut" method="post">
                <button id="btnVolver" name="btnVolver" class="btn btn-sm btn-danger" type="submit">Cerrar Sesión
                </button>
                </form>
                </div>
      		<div id="recuadro" style="position:absolute;left:100px;top:75px;z-index:2;background-color: #ff9;text-align:center;">	
      			<form action="ComienzoServicio"  method="post">
  				<b>Nuevo Servicio</b>
  				<div><input id="lugar" name="lugar" class="form-control" placeholder="Lugar" type="text"><br></div>
  				<div><input id="patente" name="patente" class="form-control" placeholder="Patente" type="text"><br></div>
  				<button class="btn btn-sm btn-success" type="submit">Registrar</button> 
  				</form>
  			</div>
          
          
           <div id="div2" style="position:absolute;right:100px;top:50px;z-index:2;">
  				<H3 align="center">LUGARES</H3>
             <table border="1" >
             <thead>
                   <tr>
                    <th>Lugar</th>
                  	<th>Patente</th></tr>
             </thead>
             <tbody>
                  <% for (Lugar lugar : lug) { %>
                    <tr>
                    	<%if (lugar.getEstado()=='D') {%>
                    		<th style="background-color: green;"><%=lugar.getCodLugar()%></th>
                    		<th>-</th>
                    	<% }else{ %>
                    		<th style="background-color: red;"><%=lugar.getCodLugar()%></th>
                    		<th ><%=lugar.getNumpat() %></th><% } %>
                    </tr>
                  			<% } %>	
             </tbody>
             </table>          
     </div>
     <div style="position:absolute;right:220px;top:510px;z-index:2;">
     <form action="VolverServlet" method="post">
                <button id="btnActualizar" name="btnActualizar" class="btn btn-lg btn-success" type="submit">Actualizar
                </button>
             	</form>
     </div>
      <div id="recuadro" style="position:absolute;left:100px;top:275px;z-index:2;background-color: #ff9;text-align:center;">
          <form action="FinServicio" method="post">
  				<b>Fin Servicio</b>
  				<input id="patente" name="patente" class="form-control" placeholder="Patente" type="text"><br>
  				<label><input id="benefUsr" name="benefUsr" class="form-control"  value="true" type="checkbox">Beneficio Usuario</label><br>
  				<label><input id="benefDia" name="benefDia" class="form-control"   value="true" type="checkbox">Beneficio Día</label><br>
  				<button class="btn btn-sm btn-success" type="submit">Cobrar</button> 
  				</form>
       </div >
       
       <div id="recuadro" style="position:absolute;right:200px;top:600px;z-index:2;background-color: #ff9;text-align:center"> 
       		<form action="ActualizarTarifa" method="post"  >
       		
       		<b style="text-align:center">Tarifas</b>
       		
       		<div class="form-group"><input id="mediahora" name="mediahora" class="form-control" size="12" placeholder="$ 1/2 hora" type="text" required>
       		<b>$<%=tar.getMediaHora() %></b></div>
       		
       		<div class="form-group"><input id="hora" name="hora" class="form-control" size="12" placeholder="$ hora" type="text" required>
       		<b>$<%=tar.getHora() %></b></div>
       		
       		<div class="form-group"><input id="mediaest" name="mediaest" class="form-control" size="12" placeholder="$ 1/2 estadía" type="text" required>
       		<b>$<%=tar.getMediaEstadia() %></b></div>
       		
       		<div class="form-group"><input id="estadia" name="estadia" class="form-control" size="12" placeholder="$ estadía" type="text" required>
       		<b>$<%=tar.getEstadiaCompleta() %></b></div>
       		
       		<div class="form-group"><input id="semanal" name="semanal" class="form-control" size="12" placeholder="$ semanal" type="text" required>
       		<b>$<%=tar.getSemanal() %></b></div>
       		
       		<div class="form-group"><input id="mensual" name="mensual" class="form-control" size="12" placeholder="$ mensual" type="text" required>
       		<b>$<%=tar.getMensual() %></b></div>
       		<button class="btn btn-sm btn-success" type="submit">Actualizar</button> 
       		</form>
       </div>
       
       
       <div id="recuadro" style="position:absolute;left:100px;top:600px;z-index:2;background-color: #ff9;text-align:center;">
          <form action="FacturacionCliente" method="post">
  				<b>Facturación mensual cliente</b>
  				<input id="dni" name="dni" class="form-control" placeholder="Dni" type="text"><br>
  				<input id="mesIni" name="mesIni" class="form-control" placeholder="Mes" type="text"><br>
  				<input id="anoIni" name="anoIni" class="form-control" placeholder="Año" type="text"><br>
  				<button class="btn btn-sm btn-success" type="submit">Buscar</button>
  				</form>
       </div >
       
        <div id="recuadro" style="position:absolute;left:100px;top:850px;z-index:2;background-color: #ff9;text-align:center;">
          <form action="AsistenciaMensual" method="post">
  				<b>Asistencia mensual de clientes</b>
  				<input id="mesIni" name="mesIni" class="form-control" placeholder="Mes" type="text"><br>
  				<input id="anoIni" name="anoIni" class="form-control" placeholder="Año" type="text"><br>
  				<button class="btn btn-sm btn-success" type="submit">Buscar</button>
  				</form>
       </div >
       
</body>
</html>