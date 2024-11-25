<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.CategoriaOperaio"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifica Categoria - Easy Clean</title>
	<link rel="stylesheet" href="CSS/styleAmministratore.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar" style="background-color: #afeeff;">
		<img src="Logo_ditta.png" height=250px width=250px>
		<a href="Admin">Home</a>
		<a href="Operai">Operai</a>
		<a href="Categoria">Categoria</a>
		<a href="Prenotazioni">Gestisci prenotazioni</a>
		<a href="Servizi">Servizi</a>
		<a href="Squadra">Squadra</a>
		<a href="Cliente">Cliente</a>
		<a href="Sede">Sede</a>
		<a href="Login"><img src="Logout_logo.png" height=20px width=20px name="Logout"> Logout</a>
		<p></p>
	</nav>
	<form action=modificaCategoria method=post>
		<table border=1 align=center style="margin-top:7%;">
			<tr align=center>
				<th><h3>Modifica una categoria</h3></th>
			</tr>
			<tr align=center>
				<td><input type=text name=nomeCategoria placeholder="Nome Categoria"></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Cerca" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	
	<% 
        CategoriaOperaio categoriaDaMod = (CategoriaOperaio) request.getAttribute("categoriaDaMod");
        if (categoriaDaMod != null) { 
    %>
        <form action="updateCategoria" method="Post">
        	<table border=1 align=center style="margin-top:3%; margin-bottom:3%;" >
				<tr align=center>
					<th><h3>Dettagli Categoria</h3></th>
				</tr>
				<tr align=center>
					<td>Nome Categoria: <input type=text name="nomeCategoria" value="<%= categoriaDaMod.getNomeCategoria() %>" placeholder="Nome Categoria"></td>
				</tr>
				<tr align=center>
					<td>Stipendio: <input type=text name=stipendio value="<%= categoriaDaMod.getStipendio() %>" placeholder="Stipendio">€</td>
				</tr>
				<tr align=center>
					<td><input type=submit value="Aggiorna" style="margin-top: 20px; margin-bottom:20px;"></td>
				</tr>
			</table>
            <input type=hidden name="idCategoria" id="idCategoria" value="<% categoriaDaMod.getIdCategoria(); %>">
        </form>
    <% 
        } 
        if (request.getAttribute("salvato") != null) { 
    %>
        <div id="flag-ins" align=center><%= request.getAttribute("salvato") %></div>
    <% 
        } else if (request.getAttribute("messaggioErrore") != null) { 
    %>
        <div id="flag" align=center style="margin-top: 10px;"><%= request.getAttribute("messaggioErrore") %></div>
    <% } %>
    <div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>