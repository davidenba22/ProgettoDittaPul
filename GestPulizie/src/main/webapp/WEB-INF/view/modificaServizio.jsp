<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Servizio"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifica Servizio - Easy Clean</title>
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
	<form action=modificaServizio method=post>
		<table border=1 align=center style="margin-top:4%;">
			<tr align=center>
				<th><h3>Modifica un servizio</h3></th>
			</tr>
			<tr align=center>
				<td><input type=text name=nomeServizio placeholder="Nome servizio"></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Cerca" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	
	<%
		Servizio servizioDaMod = (Servizio) request.getAttribute("servizioDaMod");
    	if (servizioDaMod != null) {
	%>
        <form action="updateServizio" method="Post">
        	<table border=1 align=center id="tab-mod-serv" style="margin-top:50px; margin-bottom: 30px;">
				<tr align=center>
					<th colspan=2><h3>Dettagli Categoria</h3></th>
				</tr>
				<tr align=center>
					<td colspan=2>Nome Servizio:<input type=text name="nomeServizio" value="<%= servizioDaMod.getNomeServizio() %>" placeholder="Nome Categoria"></td>
				</tr>
				<tr align=center>
					<td colspan=2>Descrizione Servizio: <input type=text name="descrizioneServizio" value="<%= servizioDaMod.getDescrizioneServizio() %>" placeholder="Descrizione"></td>
				</tr>
				<tr align=center>
					<td colspan=2>Prezzo: <input type=text name="prezzoServizio" value="<%= servizioDaMod.getPrezzoServizio() %>" placeholder="Prezzo"></td>
				</tr>
				<tr align=center>
					<td colspan=2>Durata servizio in minuti: <input type=text name="durataServizio" value="<%= servizioDaMod.getDurataServizio() %>" placeholder="Durata Servizio (min)"></td>
				</tr>
				<tr align=center>
					<td><input type=submit value="Aggiorna" style="margin-top: 20px; margin-bottom:20px;"></form></td>
					<td><form action=deleteServizio method=Post>
			        	<input type="hidden" name="idServizio" id="idServizio" value="<%= servizioDaMod.getIdServizio() %>">
			        	<input type=submit value="Elimina" style="margin-top: 20px; margin-bottom:20px;">
			        </form></td>
				</tr>
			</table>
	<% 
        }
    	else{
	%>
		<div id="flag" align=center>${MessaggioErrore}</div>
	<%
    	}
	%>
	<div id="flag-ins" align=center>${MessaggioUpdate}</div><br>
	<div id="flag-ins" align=center>${MessaggioDelete}</div>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>