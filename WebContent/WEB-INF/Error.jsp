<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Inesperado</title>
<link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/start.css" rel="stylesheet">
    
    <link href="style/tabla.css" rel="stylesheet">
</head>
<body>
   
                <h1>
                	<%=request.getAttribute("mensaje")%>
                </h1>
                <form action="Signin" method="post">
                <button id="btnVolver" name="btnVolver" class="btn btn-sm btn-success" type="submit">Volver
                </button>
                
                </form>            


</body>
</html>