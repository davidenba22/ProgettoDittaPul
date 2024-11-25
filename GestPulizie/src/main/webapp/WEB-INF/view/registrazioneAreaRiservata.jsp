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
		<form action=registrazioneAreaRiservata method=Post>
			<table border=1 align=center id="tab-reg-op">
				<tr align=center>
					<th><h3 style="margin-top: 10px;">Registrazione Area Riservata</h3></th>
				</tr>
				<tr align=center>
					<td><input type=text name=nomeOperaio placeholder="Nome"></td>
				</tr>
				<tr align=center>
					<td><input type=text name=cognomeOperaio placeholder="Cognome"></td>
				</tr>
				<tr align=center>
					<td><input type=text name=cfOperaio placeholder="Codice Fiscale"></td>
				</tr>
				<tr align=center>
					<td><input type=text name=userOperaio placeholder="Username"></td>
				</tr>
				<tr align=center>
					<td><input type=password name=pwdOperaio placeholder="Password"></td>
				</tr>
				<tr align=center>
					<td><input type=submit value="Registrati" style="margin-top: 20px;"></td>
				</tr>
				<tr>
					<td><a href="areaPrivata">< Indietro</a></td>
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