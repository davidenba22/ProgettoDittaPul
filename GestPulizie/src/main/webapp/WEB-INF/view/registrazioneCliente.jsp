<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registrazione - Easy Clean</title>
	<link rel="stylesheet" href="CSS/styleLogin.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	<span>
	<p align=center><img src="Logo_ditta.png" width=250px height=250px></p>
		<form action=registrazioneCliente method=Post>
			<table border=1 align=center id="tab-reg-cl">
				<tr align=center>
					<th><h3>Registrazione Cliente</h3></th>
				</tr>
				<tr align=center>
					<td><p style="margin-top: 20px;">Inserisci i tuoi dati</p></td>
				</tr>
				<tr align=center>
					<td><input type=text name=nomeCliente placeholder="Nome"></td>
				</tr>
				<tr align=center>
					<td><input type=text name=cognomeCliente placeholder="Cognome"></td>
				</tr>
				<tr align=center>
					<td><input type=text name=cfCliente placeholder="Codice Fiscale"></td>
				</tr>
				<tr align=center>
					<td><input type=text name=userCliente placeholder="Username"></td>
				</tr>
				<tr align=center>
					<td><input type=password name=pwdCliente placeholder="Password"></td>
				</tr>
				<tr align=center>
					<td><p style="margin-top: 20px;">Inserisci i dati della tua sede</p></td>
				</tr>
				<tr align=center>
					<td><input type=text name=nomeSede placeholder="Nome Sede" required></td>
				</tr>
				<tr align=center>
					<td><input type=text name=cittaSede placeholder="Città" required></td>
				</tr>
				<tr align=center>
					<td><input type=text name=viaSede placeholder="Via/Corso" required></td>
				</tr>
				<tr align=center>
					<td><input type=text name=pianoSede placeholder="Piano (Terra=T)" required></td>
				</tr>
				<tr align=center>
					<td><input type=submit value="Registrati" style="margin-top: 20px;"></td>
				</tr>
				<tr>
					<td><a href="areaUser">< Indietro</a></td>
				</tr>
			</table>
		</form>
		<br>
		<div id="flag-ins" align=center>${MessaggioIns}</div>
		<div id="flag" align=center>${erroreCf}</div>
		<div id="flag" align=center>${erroreUsername}</div>
		<div id="flag" align=center>${errorePassword}</div>
	</span>
</body>
</html>