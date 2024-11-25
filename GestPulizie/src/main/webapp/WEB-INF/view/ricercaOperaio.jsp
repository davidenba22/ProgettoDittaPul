<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Operaio"
    import="java.util.Optional"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ricerca Operaio - Easy Clean</title>
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
	<form action=ricercaOperaio method=Post>
	<table border=1 align=center style="margin-top: 5%;">
		<thead>
			<tr align=center>
				<th><h3>Ricerca Operaio</h3></th>
			</tr>
		</thead>
		<tbody>
			<tr align=center>
				<td>Ricerca per CODICE FISCALE</td>
			</tr>
			<tr align=center>
				<td><input type=text name=cfOperaio placeholder="Codice Fiscale"></td>
			</tr>
			<tr align=center>
				<td>oppure per NOME e COGNOME</td>
			</tr>
			<tr align=center>
				<td><input type=text name=nomeOperaio placeholder="Nome"></td>
			</tr>
			<tr align=center>
				<td><input type=text name=cognomeOperaio placeholder="Cognome"></td>
			</tr>
			<tr align=center>
				<td><input type=submit value=Ricerca style="margin-top: 20px; margin-bottom: 20px;"></td>
			</tr>
		</tbody>	
	</table>
	</form>
	
	<% 
		Operaio trv=(Operaio) request.getAttribute("operaioTrovato");
	
		if(trv != null){
	%>
	<table border=1 align=center style="margin-top: 3%; margin-bottom: 3%;">
		<tr align=center>
			<th>Operaio Trovato</th>
		</tr>
		<tr align=center>
			<td>Nome: <%=trv.getNomeOperaio()%></td>
		</tr>
		<tr align=center>
			<td>Cognome: <%=trv.getCognomeOperaio()%></td>
		</tr>
		<tr align=center>
			<td>Codice Fiscale: <%= trv.getCfOperaio() %></td>
		</tr>
		<tr align=center>
			<td>Username: <%=trv.getUserOperaio()%></td>
		</tr>
		<tr align=center>
			<td>Password: <%=trv.getPwdOperaio()%></td>
		</tr>
		<tr align=center>
			<td>Categoria: <%=trv.getOpCat().getNomeCategoria()%></td>
		</tr>
		<tr align=center>
			<td>Operativo: <% if(trv.getStatoOperativita().equals(true)){%>Si<%}else{%>No<%} %></td>
		</tr>
	</table>
	<%
		}
		else{
	%>
		<div id="flag" align=center style="margin-top: 10px;">${Messaggio}</div>
	<%
		}
	%>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>