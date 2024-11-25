<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.rf.gestpulizie.model.Servizio"
    import="it.rf.gestpulizie.model.Comprende"
    import="it.rf.gestpulizie.model.Squadra"
    import="java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gestisci Prenotazione - Easy Clean</title>
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
	<br><br>
	<table border=1 align=center>
		<tr align=center>
			<th>Servizi Disponibili</th>
		</tr>
		<tr>
			<td align=center>
			<form action=addServizi method=Post>
				<%
					List<Servizio> elencoServiziDisponibili=(List<Servizio>) request.getAttribute("elencoServiziNonScelti");
					
					if(elencoServiziDisponibili != null){
						int i;
						for(i=0;i<elencoServiziDisponibili.size();i++){
						%>
						<input type=checkbox name=serviziScelti value=<%= elencoServiziDisponibili.get(i).getIdServizio() %>> <%= elencoServiziDisponibili.get(i).getNomeServizio() %> ----- Durata: | <%= elencoServiziDisponibili.get(i).getDurataServizio() %> | min<br>
						<%
						}
					}
				%>
				<script>
				    // Aggiunge un event listener al form per eseguire una funzione quando viene inviato
				    document.querySelector('form').addEventListener('submit', function (e) {
				        // Seleziona tutti gli input checkbox con la classe "servizio-checkbox"
				        const checkboxes = document.querySelectorAll('input[name="serviziScelti"]');
				        
				        // Variabile per controllare se almeno una checkbox è selezionata
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
				</script>
				<br>Note: <input type=text name=nomeServizio placeholder="Note servizi"><br>
				<br><br>
				<input type=submit value="Aggiungi"></form><br>
			</td>
	</table>
	<br><br>
	<table border=1 align=center width=300px>
		<tr align=center>
			<th>Servizi dell'intervento</th>
		</tr>
		<tr align=center>
			<td>
				<%
					List<Comprende> serviziSceltiPerIntervento=(List<Comprende>) request.getAttribute("serviziSceltiPerIntervento");
					if(serviziSceltiPerIntervento != null){
						int j;
						for(j=0;j<serviziSceltiPerIntervento.size();j++){
						%>
							<form action=removeServizio method=Post>
							<input type=hidden name=durataServizio value=<%= serviziSceltiPerIntervento.get(j).getServComprende().getDurataServizio() %>>
							<input type=hidden name=servScelto value=<%= serviziSceltiPerIntervento.get(j).getServComprende().getIdServizio() %>> <%= serviziSceltiPerIntervento.get(j).getServComprende().getNomeServizio() %> <input type=submit value="Rimuovi"></form>
						<%
						}
					}
				%>
			</td>
		</tr>
	</table>
	<a href="modPren" align=center style="margin-top: 20px; margin-bottom: 20px;"><input type=button value="Indietro"></a>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>