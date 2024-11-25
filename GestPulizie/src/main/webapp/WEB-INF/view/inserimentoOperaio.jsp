<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.CategoriaOperaio"
    import="java.util.List"
    import="java.util.ArrayList"
    import="java.util.Optional"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inserimento Operaio - Easy Clean</title>
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
	<form action=inserimentoOperaio method=Post>
	<table border=1 align=center style="margin-top: 2%;">
		<tr align=center>
			<th><h3>Nuovo Operaio</h3></th>
		</tr>
		<tr align=center>
			<td>Inserisci i dati dell'operaio da inserire</td>
		</tr>
		<tr align=center>
			<td><input type=text name=nomeOperaio placeholder="Nome" required></td>
		</tr>
		<tr align=center>
			<td><input type=text name=cognomeOperaio placeholder="Cognome" required></td>
		</tr>
		<tr align=center>
			<td><input type=text name=cfOperaio placeholder="Codice Fiscale" required></td>
		</tr>
		<tr align=center>
			<td><input type=text name=userOperaio placeholder="Username" required></td>
		</tr>
		<tr align=center>
			<td><input type=password name=pwdOperaio placeholder="Password" required></td>
		</tr>
		<tr align=center>
			<td><select name=idCategoria style="margin-top: 20px;">
			<option value="">--Scegli una categoria--</option>
				<%
					List<CategoriaOperaio> elencoCategorie=(List<CategoriaOperaio>)request.getAttribute("elenco");
					int i;
					if(elencoCategorie != null){
						for(i=0;i<elencoCategorie.size();i++){
				%>
					<option value="<%= elencoCategorie.get(i).getIdCategoria() %>"><%= elencoCategorie.get(i).getNomeCategoria() %></option>
				<%
						}
					}
					
				%>
			</select></td>
		</tr>
		<tr align=center>
			<td>Operativo? <input type=checkbox name=statoOperativita value='1' style="margin-top: 20px;"></td>
		</tr>
		<tr align=center>
			<td><input type=submit value="Inserisci" style="margin-top: 20px; margin-bottom: 20px;"></td>
		</tr>
	</table>
	</form>
	<br>
	<div id="flag-ins" align=center>${Messaggio}</div>
	<div id="flag" align=center>${erroreCf}</div>
	<div id="flag" align=center>${erroreUsername}</div>
	<div id="flag" align=center>${errorePassword}</div>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>