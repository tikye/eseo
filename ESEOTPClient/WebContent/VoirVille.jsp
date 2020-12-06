<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="principal.Ville"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voir Ville</title>
</head>
<body>

<a href="Connexion"> Afficher l'accueil </a>
<br><br>

	<nav aria-label="Page navigation example">
			<a class="page-link" href="VoirVille?page=
			<%Integer pages = (Integer) request.getAttribute("numPage");
			if (pages <= 1) { pages = 2;}%>
			<%=pages - 1%>">Previous</a>
			<a class="page-link" href="VoirVille?page=1">1</a>
			<a class="page-link" href="VoirVille?page=2">2</a>
			<a class="page-link" href="VoirVille?page=3">3</a>
			<a class="page-link" href="VoirVille?page=<%Integer pagesS = (Integer) request.getAttribute("numPage");%>
			<%=pagesS + 1%>">Next</a>
	</nav>
	
	<h1 class="font-weight-light">Liste des villes :</h1>
	<br>
		<FORM method="post" action="modification">
			<% ArrayList<Ville> liste2 = (ArrayList) request.getAttribute("villesPage");
			for (Ville ville : liste2) {
			%>
			<li><%=ville.getNomCommune()%></li>
			<a href="Modif?ville=<%=ville.getNomCommune()%>">Modifier</a>
			<a href="Supp?ville=<%=ville.getNomCommune()%>">Supprimer</a><br>
			<br>
			<%}%>
		</FORM>


</body>

</html>