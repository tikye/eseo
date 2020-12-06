package com.servlets;

import principal.Ville;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class afficheVille
 */
@WebServlet("/VoirVille")
public class VoirVille extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoirVille() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String numero = request.getParameter("page");
		int page = numero != null ? Integer.parseInt(numero) : 1;

		ArrayList<Ville> villes = (ArrayList<Ville>) session.getAttribute("villes");
		villes = elements((page-1), villes);
		request.setAttribute("villesPage", villes);
		request.setAttribute("numPage", page);
		request.getRequestDispatcher("VoirVille.jsp").forward(request, response);
	}

	private ArrayList<Ville> elements(int start, ArrayList<Ville> list) {
		ArrayList<Ville> myList = new ArrayList<Ville>();
		for (int i = start; i < start + 50; i++) {
			if (i >= list.size()) {
				break;
			}
			myList.add((Ville) list.get(i));
		}
		return myList;
	}
}