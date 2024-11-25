<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Operaio"
    import="it.rf.gestpulizie.model.Sede"
    import="it.rf.gestpulizie.model.Servizio"
    import="it.rf.gestpulizie.DTO.datiLavDTO"
    import="java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Interventi del giorno - Easy Clean</title>
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
	<form action=interventiOperaio method=Post>
		<table border=1 align=center style="margin-top:5%;">
			<tr align=center>
				<th><h3>Interventi</h3></th>
			</tr>
			<tr align=center>
				<td>Inserisci una data per visualizzare gli interventi inerenti</td>
			</tr>
			<tr align=center>
				<td><input type=date name=dataDaRic required></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Ricerca" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	<br><div id="flag" align=center>${noMatch}</div>
	<%
		List<datiLavDTO> elencoInterventiVarieSedi=(List<datiLavDTO>) request.getAttribute("elencoInterventiVarieSedi");
		
		if(elencoInterventiVarieSedi != null){
		
		int i;
		for(i=0;i<elencoInterventiVarieSedi.size();i++){
	%>
	<br><table border=1 align=center style="width: 1200px;">
	<form action=gestisciInterventiLavorazione method=Post>
		<tr>
			<td style="width: 150px;">ID Lavorazione: <input type=text name=idLavorazione value=<%= elencoInterventiVarieSedi.get(i).getIdLavorazione() %> readonly></td>
			<td style="width: 300px;"><input type=text name=nomeSede value="<%= elencoInterventiVarieSedi.get(i).getNomeSede() %>"></td>
			<td style="width: 300px;"><input type=text name=cittaSede value="<%= elencoInterventiVarieSedi.get(i).getCittaSede() %>"></td>
			<td style="width: 450px;"><input type=text name=viaSede value="<%= elencoInterventiVarieSedi.get(i).getViaSede() %>"></td>
			<td style="width: 150px;"><input type=text name=pianoSede value="<%= elencoInterventiVarieSedi.get(i).getPianoSede() %>"></td>
			<td><input type=submit value="Gestisci"></form></td>
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