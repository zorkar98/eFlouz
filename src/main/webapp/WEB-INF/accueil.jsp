<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil eFlouz</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/CSSAccueil/style.css">
</head>
<body>


	<div class="header">
		<h1>eFlouz</h1>
		<a href="./SeConnecterServlet">S'inscrire/Se connecter</a>
	</div>
		<div class="sub_header">
			<h1>Liste des enchères</h1>
		</div>
		<p>Filtres</p>
		<div class="container">
			<form action="${pageContext.request.contextPath}/home" method="get">
				<div class="search">
					<input type="search" placeholder="Le nom de l'article contient" name="rechercher">
				</div>
				<div class="submit">
					<input type="submit" value="Rechercher">
				</div>
			</form>
		</div>
		<div class="container_enchere">
			<div class="list_enchere">
				<img alt="" src="">
				<a>Nom de l'article :</a>
				<p>Prix :</p>
				<p>Fin de l'enchère :</p>
				<p>Vendeur :</p>
			</div>
			<div class="mes_enchere">
				<img alt="" src="">
				<a>Nom de l'article :</a>
				<p>Prix :</p>
				<p>Fin de l'enchère :</p>
				<p>Vendeur :</p>
			</div>
		</div>
</body>
</html>