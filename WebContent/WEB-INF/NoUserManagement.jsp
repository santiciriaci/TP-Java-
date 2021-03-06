<%@page import="Entidades.Usuario"%>
<%@page import="Entidades.Auto"%>
<%@page import="Logica.AutoLogic"%>
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
    		request.setAttribute("usuario",u);
    		AutoLogic autolog = new AutoLogic();
	    	LinkedList<Auto> au = autolog.getAutosCte(u.getDni());
    %>
</head>
<body class="bg-warning">
	<h2 style="text-align:center;font-size:40px">Bienvenido usuario: <%=u.getUsuario() %></h2>
	<div style="position:absolute;top:0px;left:90%;background-color: #ff9;">
      <form action="LogOut" method="post">
                <button id="btnVolver" name="btnVolver" class="btn btn-lg btn-danger" type="submit">Cerrar Sesión
                </button>
                </form>
                </div>
	<div id="recuadro" style="top:150px">
	<form  action="EnviarMail" method="post">
	<div style="text-align:center">
	<a> INGRESE LA PATENTE DE SU VEHÍCULO Y ...<br>
	CLICK AL BOTÓN PARA OBTENER UN 20% DE DESCUENTO</a>
	</div>
	<div>
<div class="form-group">
	<input id="inputPatenteBen" name="patenteBeneficio" style="width : 200px; heigth : 1px" class="form-control" placeholder="Patente" type="text">
	</div>
	<input type="hidden" name="dni" value="<%=u.getDni() %>">
	<input type="hidden" name="nom" value="<%=u.getNombre() %>">
	<input type="hidden" name="ape" value="<%=u.getApellido() %>">
	<button class="btn btn-success">Solicitar beneficio</button>
	</div>
	</form>
	</div>
  	
  	<div id="div1" style="position:relative;left:475px;top:100px;z-index:2;">
  		<H3 align="center">Mis vehículos</H3>
             <table border="2" >
             
             <thead>
                   <tr>
                    <th>Patente</th>
                    <th>Modelo</th>
                  </tr>
             </thead>
             <tbody>
                  <% for (Auto auto : au) { %>
                    <tr>
                    	<td><%=auto.getPatente()%></td>
                    	<td><%=auto.getModelo()%></td>
                    </tr>
                  <% } %>
             </tbody>
             </table>    
     </div>
     		
			
     <div style="position:absolute;left:525px;top:500px;z-index:2;">
     	<form class="form-newAuto bg-warning text-white" action="AgregarAuto" method="post">
     		<input id="inputPatente" name="patente" class="form-control" placeholder="Patente" type="text">
		    <input id="inputModelo" name="modelo" class="form-control" placeholder="Modelo" type="text">
		    <input type="hidden" name="dni" value="<%=u.getDni() %>">
		    <Button class="btn btn-lg btn-success" type="submit">Registrar nuevo vehículo</Button>
		 </form>
     </div>
     <div style="position:absolute;left:45%;top:38%;z-index:2;">
     <form class="form-group" action="EliminarAuto" method="post">
     
     <input id="inputPatente" name="patente1" class="form-control" placeholder="Patente" type="text">
     
     <Button class="btn btn-sm btn-danger" type="submit">Eliminar Vehículo</Button>
     
     </form>
     
     
     </div>
	<div style="position: absolute; background-color: #ff9; left:0px;top:90%;height:10%; width: 100%; font-size:20px">
		<a>Ciudad: Rosario        <a><br>
		<a>Dirección: Zeballos 1341<a><br>
		<a>Telefono: 0303-456</a>
		</div>
</body>
</html>