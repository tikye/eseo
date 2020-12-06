<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="principal.Ville"%>

<!DOCTYPE html>
<html>

<head>
<title>Calcul de la distance</title>
<meta charset="ISO-8859-1">
</head>


<body>
	<h1 class="font-weight-light">Calculer la distance entre les villes</h1>
	<h2 class="panel-title">Villes choisies :</h2>
	<FORM method="post" action="Distance">
	<div class="form-group">

	<SELECT name="ville1" size="1">
	<%
		ArrayList<Ville> liste1 = (ArrayList) session.getAttribute("villes");
	for (Ville ville : liste1) {
	%>
	<OPTION>
		<%=ville.getNomCommune()%>
		<%}%>
	</SELECT>
	<br>
	<SELECT name="ville2" size="1">
	<%
		ArrayList<Ville> liste2 = (ArrayList) session.getAttribute("villes");
	for (Ville ville : liste2) {
	%>
	<OPTION>
	<%=ville.getNomCommune()%>
	<%}%>												
	</SELECT> <br> <br> <input
		class="btn btn-lg btn-primary btn-block" type="submit"
		value="Calcul de la distance" name="action">
	</div>
	</FORM>
	<br>
	<a href="VoirVille"> Afficher les villes </a><br>


</body>
</html>