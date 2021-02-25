<%@page import="Entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">

    <title>Registro de Usuario</title>

    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/signin.css" rel="stylesheet">
</head>
<body class="bg-warning">
	<%	Usuario u = null;
		String vacio="";
		if((Usuario)request.getAttribute("datosPersona") !=null){
			u = (Usuario)request.getAttribute("datosPersona");
		}
		 %>	
		 
		 <% if (u != null){%>		
		 
		 <script type="text/javascript" src="msjError.js">
  	
		</script>
		 <% } %> 
		 <!-- position:relative;right:400px;top:10px; -->
	<div class="container">
	<div class="justify-content-center">
		<b>DATOS REQUERIDOS PARA EL REGISTRO:</b>
		<form class=""  method="post" action="NuevoUsuario">
	        <div class="form-signin">
	      <label for="inputUsr" class="sr-only">Usuario:</label>
	      <input id="inputUsr" name="usuario" class="form-control" placeholder="Usuario" type="text" size="20" required>
		</div>
		<div class="form-signin">
	      <label for="inputContraseña" class="sr-only">Contraseña:</label>
	      <input id="inputContraseña" name="contraseña" class="form-control" placeholder="Contraseña" type="password" required>
	 </div>
	 <div class="form-signin">
	      <label for="inputNombre" class="sr-only">Nombre:</label>
	      <input id="inputNombre" name="nombre" class="form-control" value="<%=(u==null)?vacio:u.getNombre()%>" placeholder="Nombre" type="text" required>
	</div>
	<div class="form-signin">
	      <label for="inputApellido" class="sr-only">Apellido:</label>
	      <input id="inputApellido" name="apellido" class="form-control" value="<%=(u==null)?vacio:u.getApellido()%>" placeholder="Apellido" type="text" required>
</div>
<div class="form-signin">	
	      <label for="inputNumDoc" class="sr-only">DNI:</label>
	      <input id="inputNumDoc" name="dni" class="form-control" value="<%=(u==null)?vacio:u.getDni()%>" placeholder="DNI" type="text" required>
</div>
<div class="form-signin">
	      <label for="inputTel" class="sr-only">Telefono:</label>
	      <input id="inputTel" name="telefono" class="form-control" value="<%=(u==null)?vacio:u.getTel()%>" placeholder="Telefono" type="text" size="30" required>
	</div>
	<div class="form-signin ">
	      <label for="inputMail" class="sr-only">Mail:</label>
	      <input id="inputMail" name="mail" class="form-control" value="<%=(u==null)?vacio:u.getMail()%>" placeholder="Mail" type="email" size="30" required>
  </div>
  <div class="form-signin">
	      <label for="inputDirecc" class="sr-only">Dirección:</label>
	      <input id="inputDirecc" name="direccion" class="form-control" value="<%=(u==null)?vacio:u.getDireccion()%>" placeholder="Localidad" type="text" required>
	      </div>
	      <div class="form-signin">
	      <button class="btn btn-sm btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i>Registrarme</button>
	      </div>
	   
	    </form>
	    <form class=""  method="post" action="VolverServlet">
	    <div class="form-signin">
	      <button class="btn btn-sm btn-secondary" type="submit"><i class="fas fa-sign-in-alt"></i>Volver</button>
	      </div>
	      </form>
	  </div>
	  </div>
</body>
</html>