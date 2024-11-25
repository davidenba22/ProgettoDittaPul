<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.DTO.serviziDiLavDTO"
    import="it.rf.gestpulizie.model.Lavorazione"
    import="it.rf.gestpulizie.model.Esegue"
    import="it.rf.gestpulizie.model.eFormata"
    import="java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lavorazione Singola - Easy Clean</title>
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
		<a href="Login"><img src="Logout_logo.png" height=20px width=20px name="Logout"> Logout</a>
	</nav>
	<table border=2 align=center id="tab-spunta-serv" style="margin-top: 7%; width: 600px">
		<%
			List<serviziDiLavDTO> LavorazioneSingola=(List<serviziDiLavDTO>) request.getAttribute("elencoServiziSingolaLav");
			Lavorazione LavorazioneOttenuta=(Lavorazione) session.getAttribute("LavOttenuto");	
			eFormata opEformata=(eFormata) request.getAttribute("opEformata");
			
			if(LavorazioneSingola.size()>0){
		%>
			
			<tr>
				<th>ID Comprende</th>
				<th>Servizi da eseguire</th>
			</tr>
			<tr>
				<td>
				<%
				int i;
				for(i=0;i<LavorazioneSingola.size();i++){
				%>
					<input type=text value="<%= LavorazioneSingola.get(i).getIdComprende() %>"><br>
				<%
					}
				%>
				</td>
				<td>
				<%
				int j;
				for(j=0;j<LavorazioneSingola.size();j++){
				%>
				<form action=spuntaServiziOperaio method=Post>
					<input type=hidden name=idComprende value="<%= LavorazioneSingola.get(j).getIdComprende() %>">
					<input type=text name=nomeServizio value="<%= LavorazioneSingola.get(j).getNomeServizio() %>"><input type=submit value="Completato"><br>
				</form>
				<%
					}
				%>
				</td>
			</tr>
	</table>
	<%
		}
		else{
			if(opEformata.getResponsabileSquadra().equals(true)){
	%>
	<form action=spuntaLavoroTerminato method=Post>
		<table border=2 align=center>
			<tr align=center>
				<th>Lavoro Terminato</th>
			</tr>
			<tr>
			<input type=hidden name=idLavorazioneOttenuto value=<%= LavorazioneOttenuta.getIdLavorazione() %>>
				<br><td align=center><input type="submit" name=completato value='Completato'></td>

			</tr>
		</table>
	</form>
	<%
			}
			else{	
	%>
			<table border=2 align=center style="margin: -5% 0 0 40%;">
				<tr align=center>
					<th>Lavoro Terminato</th>
				</tr>
				<tr>
					<td align=center>Solo il responsabile può contrassegnare la fine dei lavori</td>
				</tr>
			</table>
	<%
			}
		}
	%>
	<a href="interventiOp" style="margin: 11% 0 3% 48%;"><input type=button value="Indietro"></a>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>