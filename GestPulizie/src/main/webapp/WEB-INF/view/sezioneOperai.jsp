<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Operaio"
    import="java.util.Optional"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Benvenuto - Easy Clean</title>
	<link rel="stylesheet" href="CSS/styleAmministratore.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	<% 
		Optional<Operaio> cfOp=(Optional<Operaio>) session.getAttribute("OperaioLoggato");
	
		if(cfOp != null){
	%>
	<nav class="navbar" style="background-color: #afeeff;">
		<img src="Logo_ditta.png" height=250px width=250px>
		<a href="sezioneOperai">Home</a>
		<a href="interventiOp">Interventi del giorno</a>
		<a href="ricIntervOp">Ricerca interventi</a>
		<a href="Logout"><img src="Logout_logo.png" height=20px width=20px name="Logout"> Logout</a>
	</nav>
	
	<p align=center style="font-size: 28px;">Benvenuto, <%= cfOp.get().getNomeOperaio() %> <%= cfOp.get().getCognomeOperaio() %></p>
	<%
		}
	%>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>