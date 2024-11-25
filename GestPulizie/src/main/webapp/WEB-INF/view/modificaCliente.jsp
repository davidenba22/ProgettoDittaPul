<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Cliente"
    import="java.util.Optional"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifica Cliente - Easy Clean</title>
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
	<form action=modificaCliente method=Post>
		<table border=1 align=center style="margin-top:5%;">
			<tr align=center>
				<th><h3>Modifica Cliente</h3></th>
			</tr>
			<tr align=center>
				<td>Ricerca per CODICE FISCALE</td>
			</tr>
			<tr align=center>
				<td><input type=text name=cfCliente placeholder="Codice Fiscale"></td>
			</tr>
			<tr align=center>
				<td>oppure per NOME e COGNOME</td>
			</tr>
			<tr align=center>
				<td><input type=text name=nomeCliente placeholder="Nome"></td>
			</tr>
			<tr align=center>
				<td><input type=text name=cognomeCliente placeholder="Cognome"></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Ricerca" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	<br><div id="flag" align=center>${Messaggio}</div>
	<div id="flag-ins" align=center>${MessaggioUpdate}</div>
	<%
		Cliente clienteTrv=(Cliente) request.getAttribute("clienteTrovato");
		
		if(clienteTrv != null){
	%>
		<form action=updateCliente method=Post>
			<table border=1 align=center style="margin-top:2%; margin-bottom: 2%">
				<tr align=center>
					<th><h3>Dettagli cliente</h3></th>
				</tr>
				<tr align=center>
					<td>Nome cliente: <input type=text name=nomeCliente value="<%= clienteTrv.getNomeCliente() %>" placeholder="Nome cliente"></td>
				</tr>
				<tr align=center>
					<td>Cognome cliente: <input type=text name=cognomeCliente value="<%= clienteTrv.getCognomeCliente() %>" placeholder="Cognome cliente"></td>
				</tr>
				<tr align=center>
					<td>Codice fiscale cliente: <input type=text name=cfCliente value="<%= clienteTrv.getCfCliente() %>" placeholder="Codice Fiscale cliente"></td>
				</tr>
				<tr align=center>
					<td>Username cliente: <input type=text name=userCliente value="<%= clienteTrv.getUserCliente() %>" placeholder="Username cliente"></td>
				</tr>
				<tr align=center>
					<td>Password cliente: <input type=text name=pwdCliente value="<%= clienteTrv.getPwdCliente() %>" placeholder="Password cliente"></td>
				</tr>
				<tr align=center>
					<td><input type=submit value="Aggiorna" style="margin-top: 20px; margin-bottom:20px;"></form></td>
				</tr>
			</table>
	<%
		}
	%>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>