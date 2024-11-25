<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Area Riservata - Easy Clean</title>
	<link rel="stylesheet" href="CSS/styleLogin.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	<span>
	<p align=center><img src="Logo_ditta.png" width=250px height=250px></p>
		<form action=areaRiservata method=Post>
			<table border=1 align=center id="tab-login-op" style="margin-top: 7%;">
				<tr align=center>
					<th><h3 style="margin-top: 10px;">Login Area Riservata</h3></th>
				</tr>
				<tr align=center>
					<td><input type=text name=username placeholder="Username" required></td>
				</tr>
				<tr align=center>
					<td><input type=password name=password placeholder="Password" required></td>
				</tr>
				<tr align=center>
					<td><input type=submit value="Accedi" style="margin-top: 20px;"></td>
				</tr>
				<tr>
					<td><a href="Login">< Indietro</a> </td>
				</tr>
			</table>
		</form>
		<br><p align=center>Primo accesso? <a href="registrazioneAreaRiservata">Registrati</a></p>
		<div id="flag" align=center>${credenzialiErrate}</div>
		
	</span>
</body>
</html>