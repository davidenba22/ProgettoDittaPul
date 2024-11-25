<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Operaio"
    import="it.rf.gestpulizie.model.Squadra"
    import="java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifica Squadra - Easy Clean</title>
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
	<form action=modificaSquadra method=post>
		<table border=1 align=center style="margin-top:5%;">
			<tr align=center>
				<th><h3>Modifica una squadra</h3></th>
			</tr>
			<tr align=center>
				<td>Inserisci il nome della squadra da modificare e la data dell'intervento inerente</td>
			</tr>
			<tr align=center>
				<td><input type=text name=nomeSquadra placeholder="Nome Squadra" required></td>
			</tr>
			<tr align=center>
				<td><input type=date name=dataOperativita required></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Cerca" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	
	<%
	Boolean esito=(Boolean)request.getAttribute("esito");
	List<Operaio> elencoDisp=(List<Operaio>) request.getAttribute("elencoDisp");
	Long idSquadraDaMod=(Long) request.getAttribute("idSquadraDaMod");
	if(esito != null){
	%>
		<% 
			if(elencoDisp.size() == 0){
			%>
			<div id="flag" align=center style="margin-top: 20px; margin-bottom:20px;">${MessaggioErrore}</div>
		<% 
			}	
			else{	
		%>
		<form action=updateSquadra method=Post>
			<table border=1 align=center style="margin-top:10px;">
				<tr align=center>
					<th><h3>Operai Disponibili</h3></th>
				</tr>
				<tr align=center>
					<td><% 
							int i;
							for(i=0;i<elencoDisp.size();i++){ 
						%>
							<input type=checkbox name=cfOperaio[] value=<%= elencoDisp.get(i).getCfOperaio() %>><%= elencoDisp.get(i).getCfOperaio() %> - <%= elencoDisp.get(i).getNomeOperaio() %> <%= elencoDisp.get(i).getCognomeOperaio() %><br>
							
						<% 
							}
						%>
					</td>
					<tr align=center>
						<td><input type=hidden name=squadraDaMod value=<%= idSquadraDaMod %>>
						<input type=Submit value="Aggiungi" style="margin-top: 20px; margin-bottom:20px;"></td>
					</tr>
				</tr>
			</table>
		</form>
		<%
				}
		%>
			
		<% 
			}
			else{
		%>
			<div id="flag" align=center style="margin-top: 20px; margin-bottom:20px;">${Messaggio}</div>
		<%
			}
		%>
		<div id="flag-ins" align=center style="margin-top: 20px; margin-bottom:20px;">${MessaggioIns}</div>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>