<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Operaio"
    import="it.rf.gestpulizie.model.Sede"
    import="it.rf.gestpulizie.model.Squadra"
    import="it.rf.gestpulizie.model.Servizio"
    import="it.rf.gestpulizie.DTO.datiLavDTO"
    import="java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifica Prenotazione - Easy Clean</title>
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
	<form action=modificaPrenotazione method=Post>
		<table border=1 align=center style="margin-top:7%;">
			<tr align=center>
				<th><h3>Modifica una Prenotazione</h3></th>
			</tr>
			<tr align=center>
				<td>Inserisci la data dell'intervento</td>
			</tr>
			<tr align=center>
				<td><input type=date name=dataDaRic required></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Ricerca" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
		
		<br>
		<br>
		
	</form>
	<br>${NessunaPrenotazione}
	${servizioRimosso}
	${prenotazioneAggiornata}
	${limiteOrarioSuperato}
	<%
		List<datiLavDTO> elencoInterventiVarieSedi=(List<datiLavDTO>) request.getAttribute("elencoInterventiVarieSedi");
		
		if(elencoInterventiVarieSedi != null){
	%>
	
	<a align=center>*Selezionando una squadra e premendo su "Gestisci", verrà aggiornata la squadra</a><br><br>
	<%
		int i;
		for(i=0;i<elencoInterventiVarieSedi.size();i++){
	%>
	<table border=1 align=center id="gest-tab-pren">
	<form action=gestisciPrenotazione method=Post>
		<tr align=center>
			<th align=center><h3>Prenotazioni trovate</h3></th>
		</tr>
		<tr>
			<td>ID Lavorazione: <input type=text name=idLavorazione value=<%= elencoInterventiVarieSedi.get(i).getIdLavorazione() %> readonly></td>
		</tr>
		<tr align=center>
			<td><input type=text name=cittaSede value="<%= elencoInterventiVarieSedi.get(i).getCittaSede() %>" readonly>
		</tr>
		<tr align=center>
			<td><input type=text name=viaSede value="<%= elencoInterventiVarieSedi.get(i).getViaSede() %>" readonly></td>
		</tr>
		<tr align=center>
			<td><input type=text name=pianoSede value="<%= elencoInterventiVarieSedi.get(i).getPianoSede() %>" readonly></td>
		</tr>
		<tr align=center>
			<td>
				<select name=squadraScelta required>
				<option value="">--Scegli una squadra--</option>
					<%
					List<Squadra> elencoSqDisp=(List<Squadra>) request.getAttribute("elencoSqDisp");
						int j;
						for(j=0;j<elencoSqDisp.size();j++){
					%>
						<option value="<%= elencoSqDisp.get(j).getIdSquadra() %>"><%= elencoSqDisp.get(j).getNomeSquadra() %> - Disponbile ancora per: <%= (elencoSqDisp.get(j).getTotMinutiSquadra()-elencoSqDisp.get(j).getMinutiSquadraAccumulati()) %> min.
					<%
						}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td><input type=submit value="Gestisci" style="margin-left: 20px; margin-top: 20px; margin-bottom: 20px;"></form></td>
			<td><form action=deletePrenotazione method=Post><input type=submit value="Elimina" style="margin-top: 20px; margin-bottom: 20px;"></form></td>
		</tr>
	</table><br>
	<%
			}
		}
	%>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>