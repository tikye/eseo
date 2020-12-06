<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="principal.Ville"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification</title>
</head>
<body>
<br>
<h1 class="font-weight-light">Modification de la ville</h1>
<p class="lead">Veuillez renseigner les informations suivantes:</p>
		
<form accept-charset="UTF-8" role="form" method="post"
	action="ModifOk">
		<div class="form-group">
			<br> <br> <SELECT name="codeCommune" size="1">
				<% ArrayList<Ville> liste = (ArrayList) session.getAttribute("villes");
			for (Ville ville : liste) { %>
			<OPTION>
				<%=ville.getCodeCommune()%>
				<%}%>
			</SELECT> <br> <br>
			<div class="form-group">
				<input class="form-control" placeholder="Nom de la Commune"
					required name="nomCommune" type="text" value="">
			</div>
			<div class="form-group">
				<input class="form-control" placeholder="Code Postal"
					required name="codePostal" type="text" value="">
			</div>
			<div class="form-group">
				<input class="form-control"
					placeholder="Libelle Acheminement" required
					name="libelleAcheminement" type="text" value="">
			</div>
			<div class="form-group">
				<input class="form-control" placeholder="Ligne" type="text"
					value="">
			</div>
			<div class="form-group">
				<input class="form-control" placeholder="Longitude"
					required name="longitude" type="text" value="">
			</div>
			<div class="form-group">
				<input class="form-control" placeholder="Latitude" required
					name="latitude" type="text" value="">
			</div>
			<br><br>
			<input class="btn btn-lg btn-primary btn-block"
				type="submit" value="Envoyer">
		</div>
</form>
<br>
Si vous voulez revenir à la page pour <a href="VoirVille"> voir les villes.</a> <br>

				
</body>

</html>