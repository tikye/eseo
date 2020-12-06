<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="principal.Ville"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Test</title>
    </head>

    <body>
        <p>Ceci est une page générée depuis une JSP.</p>
        <p>
            <% 
            ArrayList<Ville> villes = (ArrayList<Ville>) request.getAttribute("villes");
            out.println( villes );
            %>
        </p>
    </body>
</html>