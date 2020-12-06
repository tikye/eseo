<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Distance entre les villes</title>
</head>
<body>
	
	<h1 class="font-weight-light">Résultat du calcul</h1>

		La distance entre <%=session.getAttribute("ville1")%> et <%=session.getAttribute("ville2")%>
		est de <%=session.getAttribute("distance")%> km.
		<br><br>
		Si vous voulez <a href=Affichage.jsp>lancer un nouveau calcul.</a><br>

</body>
</html>