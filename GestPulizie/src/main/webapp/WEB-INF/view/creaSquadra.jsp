<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Squadra"
    import="it.rf.gestpulizie.model.Operaio"
    import="java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Crea Squadra - Easy Clean</title>
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
	<form action=creaSquadra method=Post>
		<table border=1 align=center style="margin-top:5%;">
			<tr align=center>
				<th><h2>Crea una Squadra</h2></th>
			</tr>
			<tr align=center>
				<td><input type=text name=nomeSquadra placeholder="Nome Squadra" required></td>
			</tr>
			<tr align=center>
				<td><input type=text name=descrizioneSquadra placeholder="Descrizione"></td>
			</tr>
			<tr align=center>
				<td>Data operatività della squadra: <input type=date name=dataOperativita required></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Inserisci" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	<div id="flag" align=center style="margin-top: 20px; margin-bottom:20px;">${Messaggio}</div>
	<% 
		Boolean esito=(Boolean)request.getAttribute("esito");
		if(esito != null){
	%>
	<form action=associaSquadra method=Post>
		<table border=1 align=center style="margin-top:10px;">
			<tr align=center>
				<th>Disponibilità</th>
			</tr>
			<tr align=center>
				<td>Operai</td>
			</tr>
			<tr align=center>
				<td><% 
			List<Operaio> elencoDisp=(List<Operaio>) request.getAttribute("elencoDisponibili");
			//Long idAttuale=(Long) request.getAttribute("idScelto");
			//if(elencoDisp instanceof Operaio){
				int i;
				for(i=0;i<elencoDisp.size();i++){ 
			%>
			<input type=checkbox name=cfOperaio[] value=<%= elencoDisp.get(i).getCfOperaio() %>><%= elencoDisp.get(i).getCfOperaio() %> - <%= elencoDisp.get(i).getNomeOperaio() %> <%= elencoDisp.get(i).getCognomeOperaio() %><br>
			<% 
				} 
			%>
			<br>Responsabile: <select name=setResp>
			<option value="">--Scegli un responsabile--</option>
			
			<% 
				int j;
				for(j=0;j<elencoDisp.size();j++){
			%>
				<option value=<%= elencoDisp.get(j).getCfOperaio() %>><%= elencoDisp.get(j).getCfOperaio() %> - <%= elencoDisp.get(j).getNomeOperaio() %> <%= elencoDisp.get(j).getCognomeOperaio() %></option>
			<%
				}
			%>
			</select></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Crea" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	<%
		}
		else{
	%>
	
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