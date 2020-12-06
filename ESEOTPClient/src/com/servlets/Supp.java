package com.servlets;

import principal.Ville;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


/**
 * Servlet implementation class Supp
 */
@WebServlet("/Supp")
public class Supp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supp() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String villeSup = request.getParameter("ville");
		ArrayList<Ville> villes = (ArrayList<Ville>) session.getAttribute("villes");
		String codeVille = null;
		for (Ville ville : villes) {
			if (ville.getNomCommune().equals(villeSup)) {
				codeVille = ville.getCodeCommune();
			}
		}
		String url = "http://localhost:8181/ville/delete";
		try {
			HttpResponse<JsonNode> reponse = Unirest.delete(url).queryString("Code_commune_INSEE", codeVille).asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		RequestDispatcher req = request.getRequestDispatcher("SupOk.jsp");
		req.forward(request, response);
	}

}
