<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Operaio"
    import="java.util.Optional"
    import="it.rf.gestpulizie.model.CategoriaOperaio"
    import="java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifica Operaio - Easy Clean</title>
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
	 <form action="modificaOperaio" method="post">
	 	<table border=1 align=center style="margin-top: 20px;">
	 		<tr align=center>
	 			<th>Inserisci CF dell'operaio da modificare</th>
	 		</tr>
	 		<tr align=center>
	 			<td><input type="text" name="cfOperaio" placeholder="Codice fiscale" required></td>
	 		</tr>
	 		<tr align=center>
	 			<td><input type="submit" value="Cerca" style="margin-top: 10px; margin-bottom: 10px;"></td>
	 		</tr>
	 	</table>
    </form>
    
    <% 
        Operaio operaioDaModificare = (Operaio) request.getAttribute("operaioDaModificare");
        if (operaioDaModificare != null) { 
    %>
    <br><br>
        <form action="updateOperaio" method="Post">
        <table border=1 align=center id="tab-mod-op" style="margin-bottom: 30px;">
        	<tr align=center>
        		<th><h3>Dettagli Operatore</h3></th>
        	</tr>
        	<tr align=center>
				<td>Nome: <input type="text" name="nomeOperaio" value="<%= operaioDaModificare.getNomeOperaio() %>" placeholder="Nome"></td>
			</tr>
			<tr align=center>
				<td>Cognome: <input type="text" name="cognomeOperaio" value="<%= operaioDaModificare.getCognomeOperaio() %>" placeholder="Cognome"></td>
			</tr>
			<tr align=center>
				<td>Codice Fiscale: <input type="text" name="cfOperaio" value="<%= operaioDaModificare.getCfOperaio() %>" readonly></td>
			</tr>
			<tr align=center>
				<td>Username: <input type=text name=userOperaio value="<%= operaioDaModificare.getUserOperaio() %>" placeholder="Username"></td>
			</tr>
			<tr align=center>
				<td>Password: <input type=text name=pwdOperaio value="<%= operaioDaModificare.getPwdOperaio() %>" placeholder="Password"></td>
			</tr>
			<tr align=center>
				<td><select name=idCategoria>
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
				<td>Ancora Operativo? <input type=checkbox name=statoOperativita value='1'></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Aggiorna" style="margin-top: 10px; margin-bottom: 10px;"></form></td>
			</tr>
			<tr align=center>
				<td><form action=deleteOperaio method=Post>
		        	<input type="hidden" name="cfOperaio" id="cfOperaio" value="<%= operaioDaModificare.getCfOperaio() %>">
		        	<input type=submit value="Elimina" style="margin-bottom: 20px;">
		        	</form>
        		</td>
			</tr>
		</table>
    <% 
        } 
        if (request.getAttribute("messaggioErrore") != null) { 
    %>
        <div id="flag" align=center style="margin-top: 10px;"><%= request.getAttribute("messaggioErrore") %></div>
    <% 
        } 
        if(request.getAttribute("messaggioDelete") != null){
    %>
    	<div id="flag-ins" align=center style="margin-top: 10px;"><%= request.getAttribute("messaggioDelete") %></div>
    <%
        }
        if(request.getAttribute("opSalvato") != null){
    %>
    	<div id="flag-ins" align=center style="margin-top: 10px;"><%= request.getAttribute("opSalvato") %></div>
    <%
        }
    %>

    <div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>