<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    import="it.rf.gestpulizie.model.Sede"
    import="it.rf.gestpulizie.model.Cliente"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Crea Contratto - Easy Clean</title>
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
	<form action=creaContratto method=Post>
		<table border=1 align=center style="margin-top:5%;">
			<tr align=center>
				<th><h3>Crea nuovo contratto</h3></th>
			</tr>
			<tr align=center>
				<td>Ricerca il cliente interessato <br> con NOME e COGNOME</td>
			</tr>
			<tr align=center>
				<td><input type=text name=nomeCliente placeholder="Nome Cliente"></td>
			</tr>
			<tr align=center>
				<td><input type=text name=cognomeCliente placeholder="Cognome Cliente"></td>
			</tr>
			<tr align=center>
				<td>Oppure con CODICE FISCALE</td>
			</tr>
			<tr align=center>
				<td><input type=text name=cfCliente placeholder="Codice Fiscale Cliente"></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Cerca" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	<br><div id="flag" align=center>${MessaggioErrore}</div>
	<%
		Cliente clienteTrovato=(Cliente) request.getAttribute("clienteTrovato");
		List<Sede> sediClienteTrovato=(List<Sede>) request.getAttribute("elencoSedi");	
	
		if(clienteTrovato != null){
	%>
		<form action=addContratto method=Post>
			<table border=1 align=center style="margin-top:2%; margin-bottom: 2%">
				<tr align=center>
					<th>CLIENTE TROVATO<input type=text name=clienteTrv value=<%= clienteTrovato.getCfCliente() %>></th>
				</tr>
				<tr align=center>
					<td><br>Scegli la sede
					<br><select name=sedeScelta required>
						<option value="">--Scegli una sede--</option>
						<%
							int i;
							for(i=0;i<sediClienteTrovato.size();i++){
						%>
							<option value=<%= sediClienteTrovato.get(i).getIdSede() %>><%= sediClienteTrovato.get(i).getNomeSede() %>, <%= sediClienteTrovato.get(i).getCittaSede() %>, <%= sediClienteTrovato.get(i).getViaSede() %>, Piano <%= sediClienteTrovato.get(i).getPianoSede() %></option>
						<%
							}
						%>
					</select></td>
				</tr>
				<tr align=center>
					<td><br>Data del contratto: <input type=date name=dataContratto required></td>
				</tr>
				<tr align=center>
					<td><input type=submit value="Crea contratto" style="margin-top: 20px; margin-bottom:20px;"></td>
				</tr>
			</table>
		</form>
	<%
		}
	%>
	<br><div id="flag-ins" align=center>${Messaggio}</div>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>