<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    import="it.rf.gestpulizie.model.Sede"
    import="it.rf.gestpulizie.model.Servizio"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Prenota un intervento - Easy Clean</title>
	<link rel="stylesheet" href="CSS/styleAmministratore.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar" style="background-color: #afeeff;">
		<img src="Logo_ditta.png" height=250px width=250px>
		<a href="sezioneCliente">Home</a>
		<a href="prenCl">Prenota un intervento</a>
		<a href="Login"><img src="Logout_logo.png" height=20px width=20px name="Logout"> Logout</a>
		<p></p>
	</nav>
	<form action=prenotazioneCliente method=Post>
		<table border=1 align=center style="margin-top:5%;">
			<tr align=center>
				<th><h3>Prenotazione</h3></th>
			</tr>
			<tr align=center>
				<td>Scegli la data dell'intervento: <input type=date name=dataEsecuzione required></td>
			</tr>
			<tr align=center>
				<td><br>Eventuali note per l'intervento: <input type=text name=descrizioneLavorazione placeholder="Note..."></td>
			</tr>
			<tr align=center>
				<td><input type=submit value="Avanti" style="margin-top: 20px; margin-bottom:20px;"></td>
			</tr>
		</table>
	</form>
	<br><div id="flag-ins" align=center>${confermaPrenotazione}</div>
	<%
		List<Sede> elencoSediCliente=(List<Sede>) request.getAttribute("elencoSediCliente");
		List<Servizio> elencoServizi=(List<Servizio>) request.getAttribute("elencoServizi");
		Long idLav=(Long) request.getAttribute("idLavCliente");
	
		if(elencoSediCliente != null){
	%>
		<form action=insSedeServ method=Post>
			<table border=1 align=center style="margin-top:5%; margin-bottom: 5%; width: 600px">
			<tr align=center>
				<th>ID LAVORAZIONE <input type=text name=idLavCliente value=<%= idLav %> style="width: 100px;"></th>
			</tr>
			<tr align=center>
				<td><h3>Servizi Disponibili</h3></td>
			</tr>
			<tr align=center>
				<td><%
					int i;
					for(i=0;i<elencoServizi.size();i++){
					%>
						<input type=checkbox name=servScelti value=<%= elencoServizi.get(i).getIdServizio() %>> <%= elencoServizi.get(i).getNomeServizio() %> ----- Durata: | <%= elencoServizi.get(i).getDurataServizio() %> | min - Note: <input type=text name=noteServ placeholder="Note..." style="width: 150px;"><br>
					<%
						}
					%>
					<script>
					    // Aggiunge un event listener al form per eseguire una funzione quando viene inviato
					    document.querySelector('form[action="insSedeServ"]').addEventListener('submit', function (e) {
					        // Seleziona tutti gli input checkbox con la classe "servizio-checkbox"
					        const checkboxes = document.querySelectorAll('input[name="servScelti"]');
					        
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
					</script></td>
				</tr>
				<tr align=center>
					<td><br>Scegli la sede dell'intervento<br>
					<select name=sedeScelta required>
						<option value="">--Scegli una sede--</option>
						<%
							for(i=0;i<elencoSediCliente.size();i++){
						%>
							<option value=<%= elencoSediCliente.get(i).getIdSede() %>><%= elencoSediCliente.get(i).getNomeSede() %>, <%= elencoSediCliente.get(i).getCittaSede() %>, <%= elencoSediCliente.get(i).getViaSede() %>, Piano: <%= elencoSediCliente.get(i).getPianoSede() %></option>
						<%
							}
						%>
					</select></td>
				</tr>
				<tr align=center>
					<td><br>Acconto: <input type=text name=acconto placeholder="Acconto" required></td>
				</tr>
				<tr align=center>
					<td><input type=submit value="Prenota" style="margin-top: 20px; margin-bottom:20px;"></td>
				</tr>
			</table>
		</form>
	<%
		}
	%>
	<div class="footer">
		<div id="item-footer">Copyright © 2024 - ️Easy Clean. All Rights Reserved</div>
		<div id="item-footer">P.IVA 48290561743</div>
	</div>
</body>
</html>