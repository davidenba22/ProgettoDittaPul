<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    import="it.rf.gestpulizie.model.Lavorazione"
    import="it.rf.gestpulizie.model.Esegue"
    import="it.rf.gestpulizie.model.Servizio"
    import="it.rf.gestpulizie.model.Comprende"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ricerca Prenotazione - Easy Clean</title>
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
	<form action="ricercaPrenotazione" method=Post>
		<table border=1 align=center style="margin-top: 7%;">
			<tr align=center>
				<th><h3>Ricerca una prenotazione</h3></th>
			</tr>
			<tr align=center>
				<td>Inserisci la data della prenotazione</td>
			</tr>
			<tr align=center>
				<td><input type=date name=dataPrevistaEsecuzione></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Ricerca" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	<%
    List<Lavorazione> lavTrv = (List<Lavorazione>) request.getAttribute("lavorazioneTrovata");
    if (lavTrv != null) {
    	int i;
        for (i=0;i<lavTrv.size();i++) {
            Lavorazione lavorazione=lavTrv.get(i);
            
            List<Esegue> elencoEsegue=lavorazione.getElencoEsegue();
            if (elencoEsegue != null && !elencoEsegue.isEmpty()) {
            	
            	int j;
                for (j=0;j<elencoEsegue.size();j++) {
    %>
    <table border=1 align=center style="margin-top: 30px;" id="tab-pren-ric">
        <tr>
        	<th width=120px height=50px>ID Lavorazione</th>
            <th width=120px height=50px>Sede</th>
            <th width=150px height=50px align=center>Data esecuzione</th>
            <th width=200px height=50px align=center>Eventuale descrizione</th>
            <th width=200px height=50px align=center>Servizi</th>
            <th width=150px height=50px align=center>Prezzo Totale</th>
        </tr>
        <tr align=center height=100px>
        	<td><%= lavTrv.get(i).getIdLavorazione() %></td>
            <td><%= elencoEsegue.get(j).getSedeEsegue().getIdSede() %></td>
            <td><%= lavorazione.getDataPrevistaEsecuzione() %></td>
            <td><%= lavorazione.getDescrizioneLavorazione() %></td>
            <td>
            	<% 
            		List<Servizio> elencoServTrv=(List<Servizio>) request.getAttribute("elencoServTrv");
            		
            		int k;
            		for(k=0;k<elencoServTrv.size();k++){
            	%>
            		<%= elencoServTrv.get(k).getNomeServizio() %><br>
            	<%
            		}
            	%>
            </td>
            <td><%= lavorazione.getPrezzoTotale() %></td>
        </tr>
    </table><br><br>
    <%
                }
            }
        }
    }
   	else{
	%>	
		${NoMatch}
	<%
    	}
	%>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>