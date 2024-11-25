<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Cliente"
    import="it.rf.gestpulizie.model.Servizio"
    import="it.rf.gestpulizie.model.Sede"
    import="it.rf.gestpulizie.model.Lavorazione"
    import="java.util.Optional"
    import="java.util.List"
    import="java.sql.Date"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Aggiungi Prenotazione - Easy Clean</title>
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
	<form action=aggiungiPrenotazione method=Post>
		<table border=1 align=center style="margin-top:4%;">
			<tr align=center>
				<th><h3>Aggiungi una prenotazione</h3></th>
			</tr>
			<tr align=center>
				<td>Inserisci dati del cliente interessato</td>
			</tr>
			<tr align=center>
				<td><input type=text name=nomeCliente placeholder="Nome Cliente"></td>
			</tr>
			<tr align=center>
				<td><input type=text name=cognomeCliente placeholder="Cognome Cliente"></td>
			</tr>
			<tr align=center>
				<td>Oppure inserisci solamente il CODICE FISCALE</td>
			</tr>
			<tr align=center>
				<td><input type=text name=cfCliente placeholder="Codice Fiscale Cliente"></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Avanti" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	<br>
	<div id="flag" align=center>${messaggioDisponibilitaSq}</div>
	<div id="flag" align=center>${messaggioDisponibilitaSq2}</div>
	<div id="flag" align=center>${squadreNonDisponibili}</div>
	<div id="flag" align=center>${nessunaSedeClienteScelto}</div>
	<div id="flag" align=center>${nessunClienteTrovato}</div>
	<div id="flag-ins" align=center>${messaggioPren}</div>
	<% 
		Cliente clienteTrovato=(Cliente) request.getAttribute("clienteTrv");
		List<Sede> sediClienteTrovato=(List<Sede>) request.getAttribute("elencoSediCliente");	
	
		if(clienteTrovato != null){
	%>
		<form action=sedePrenotazione method=Post>
			<table border=1 align=center style="margin-top:10px; margin-bottom: 20px;">
				<tr align=center>
					<th><h3>Scegli la sede e la data interessata</h3></th>
				</tr>
				<tr align=center>
					<td><select name=sedeCliente required>
					<option value="">--Scegli una sede--</option>
					<%
						int i;
						for(i=0;i<sediClienteTrovato.size();i++){
					%>
						<option value=<%= sediClienteTrovato.get(i).getIdSede() %>><%= sediClienteTrovato.get(i).getIdSede() %> - <%= sediClienteTrovato.get(i).getNomeSede() %>, <%= sediClienteTrovato.get(i).getCittaSede() %></option>
					<%
						}
					%>
				</select></td>
				</tr>
				<tr align=center>
					<td><br>Data dell'intervento: <input type=date name=dataPrenotazione required></td>
				</tr>
				<tr align=center>
					<td><br>Eventuali note per l'intervento: <input type=text name=noteEsecuzione placeholder="Note Intervento"></td>
				</tr>
				<tr align=center>
					<td><input type=submit value="Avanti" style="margin-top: 20px; margin-bottom:20px;"></td>
				</tr>
			</table>
		</form>
	<% 
		}
	%>
	
	<%
		Long idSedeTrv=(Long)request.getAttribute("sedeTrv");
		Date dataEsecuzione=(Date) request.getAttribute("dataEsecuzione");
		Long idLav=(Long) request.getAttribute("idLavorazione");
		String nomeClienteTrv=(String)request.getAttribute("nomeClienteTrv");
		String cognomeClienteTrv=(String)request.getAttribute("cognomeClienteTrv");
	
		if(idLav != null){
	%>
	<table border=1 align=center id="tab-sede-pren" style="margin-bottom: 2%">
		<tr align=center>
			<th> Nome Cliente </th>
			<th> Cognome Cliente </th>
			<th> ID Sede </th>
			<th> ID Lavorazione </th>
			<th> Data Intervento </th>
			<th> Servizi e Squadra</th>
		</tr>
		<tr align=center>
		<form action=addServiziPrenotazione method=Post>
			<td><input type=text name=nomeClienteAppSede value=<%= nomeClienteTrv %> readonly></td>
			<td><input type=text name=cognomeClienteAppSede value=<%= cognomeClienteTrv %> readonly></td>
			<td><input type=text name=idSedeScelto value=<%= idSedeTrv %> readonly></td>
			<td><input type=text name=idLavScelto value=<%= idLav %> readonly></td>
			<td><input type=text name=dataEsecuzioneScelta value=<%= dataEsecuzione %> readonly></td>
			<td align=center><input type=submit value="Associa Servizi e Squadra"></form></td>
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