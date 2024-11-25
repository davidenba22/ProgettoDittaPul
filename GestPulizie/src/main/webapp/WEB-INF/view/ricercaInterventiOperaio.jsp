<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    import="it.rf.gestpulizie.DTO.datiLavDTO"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ricerca Interventi - Easy Clean</title>
	<link rel="stylesheet" href="CSS/styleAmministratore.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar" style="background-color: #afeeff;">
		<img src="Logo_ditta.png" height=250px width=250px>
		<a href="sezioneOperai">Home</a>
		<a href="interventiOp">Interventi del giorno</a>
		<a href="ricIntervOp">Ricerca interventi</a>
		<a href="Logout"><img src="Logout_logo.png" height=20px width=20px name="Logout"> Logout</a>
	</nav>
	<form action=ricercaInterventiOperaio method=Post>
		<table border=1 align=center style="margin-top:5%;">
			<tr align=center>
				<th><h3>Ricerca Interventi</h3></th>
			</tr>
			<tr align=center>
				<td>Inserisci un periodo</td>
			</tr>
			<tr align=center>
				<td><br>Data Inizio Periodo: <input type=date name=dataInizioPeriodo required></td>
			</tr>
			<tr align=center>
				<td>Data Fine Periodo: <input type=date name=dataFinePeriodo required></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Ricerca" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	<br><div id="flag" align=center>${elencoVuoto}</div>
	
	<%
		List<datiLavDTO> elencoIntervTrovati=(List<datiLavDTO>) request.getAttribute("elencoLavPeriodoScelto");
	
		if(elencoIntervTrovati != null){
	%>
		<h3 align=center>Interventi Terminati</h3>
	<%
			int i;
			for(i=0;i<elencoIntervTrovati.size();i++){
	%>
		<br><table border=1 align=center style="width: 1200px;">
		<form action=servIntervTrovato method=Post>
		<tr>
			<td style="width: 150px;">ID Lavorazione: <input type=text name=idLavorazione value=<%= elencoIntervTrovati.get(i).getIdLavorazione() %> readonly></td>
			<td style="width: 300px;"><input type=text name=nomeSede value="<%= elencoIntervTrovati.get(i).getNomeSede() %>" readonly></td>
			<td style="width: 300px;"><input type=text name=cittaSede value="<%= elencoIntervTrovati.get(i).getCittaSede() %>" readonly></td>
			<td style="width: 450px;"><input type=text name=viaSede value="<%= elencoIntervTrovati.get(i).getViaSede() %>" readonly></td>
			<td style="width: 150px;"><input type=text name=pianoSede value="<%= elencoIntervTrovati.get(i).getPianoSede() %>" readonly></td>
			<td style="width: 250px;"><input type=text name=dataPrevistaEsecuzione value="<%= elencoIntervTrovati.get(i).getDataPrevistaEsecuzione() %>" readonly></td>
			<td><input type=submit value="Mostra Servizi"></form></td>
		</tr>
	</table>
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