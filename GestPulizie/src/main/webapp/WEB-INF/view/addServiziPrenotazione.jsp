<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    import="java.sql.Date"
    import="it.rf.gestpulizie.model.Servizio"
    import="it.rf.gestpulizie.model.Squadra"
    import="it.rf.gestpulizie.model.Lavorazione"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inserisci Servizietti</title>
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
		<a href="Logout"><img src="Logout_logo.png" height=20px width=20px name="Logout"> Logout</a>
		<p></p>
	</nav>
	
	<%
		//Scelta dei servizi
		List<Servizio> elencoServizi=(List<Servizio>) request.getAttribute("elencoServizi");
		Date dataEsec=(Date) request.getAttribute("dataEsec");
		List<Squadra> elencoSqDisp=(List<Squadra>) request.getAttribute("elencoSqDisp");
		String idLavScelto=(String) request.getAttribute("idLavScelto");
		
		if(elencoServizi != null){
	%>
	<form method=Post action=serviziScelti>
		<table border=1 id="tab-serv" align=center style="margin-top:20px; margin-bottom: 20px;">
			<tr align=center>
				<th>ID Lavorazione: <input type=text name=idLavScelto value=<%= idLavScelto %> readonly></th>
			</tr>
			<tr align=center>
				<td><h3>Servizi Disponibili</h3></td>
			</tr>
			<tr align=center>
				<td>
				<%
					int i;
					for(i=0;i<elencoServizi.size();i++){
				%>
				<input type=checkbox name=servScelti value=<%= elencoServizi.get(i).getIdServizio() %>> <%= elencoServizi.get(i).getNomeServizio() %> ----- Durata: | <%= elencoServizi.get(i).getDurataServizio() %> | min<br>
				<%
					}
				%>
				<script>
				    //Aggiunge un event listener al form per eseguire una funzione quando viene inviato
				    document.querySelector('form').addEventListener('submit', function (e) {
				        //Seleziona tutti gli input checkbox con la classe "servizio-checkbox"
				        const checkboxes = document.querySelectorAll('input[name="servScelti"]');
				        
				        //Variabile per controllare se almeno una checkbox è selezionata
				        let isChecked = false;
				
				        // Ciclo attraverso tutte le checkbox per verificare se almeno una è selezionata
				        checkboxes.forEach(checkbox => {
				            if (checkbox.checked) { // Se la checkbox è selezionata
				                isChecked = true;   // Imposta la variabile isChecked su true
				            }
				        });
				
				        // Se nessuna checkbox è selezionata, impedisce l'invio del form e mostra un avviso
				        if (!isChecked) {
				            e.preventDefault(); // Previene l'azione predefinita, cioè l'invio del form
				            alert('Seleziona almeno un servizio!'); // Mostra un messaggio di avviso all'utente
				        }
				    });
				</script></td>
			</tr>
			<tr align=center>
				<td><br>Note: <input type=text name=noteComprende placeholder="Note Servizio"></td>
			</tr>
			<tr align=center>
				<td>Elenco Squadre
				<select name=squadraScelta>
				<% 
					int j;
					for(j=0;j<elencoSqDisp.size();j++){
				%>
					<option value=<%= elencoSqDisp.get(j).getIdSquadra() %>>
						<%= elencoSqDisp.get(j).getNomeSquadra() %>
					</option>
				<%
					}
				%>
				</select></td>
			</tr>
			<tr align=center>
				<td>Acconto: <input type=text name=acconto placeholder="Acconto" required></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Inserisci" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>			
		<%	
			}
		%>
	</form>
	<a align=center>*Per ogni intervento, la squadra impiegherà circa 30 minuti
		per potersi spostare tra un luogo e un altro</a>
	<div id="flag" align=center>${MessaggioErroreServizio}</div>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>