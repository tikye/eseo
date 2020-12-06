package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.blo.VilleBLO;
import com.dto.Ville;

//http://127.0.0.1:8181/ville

@RestController
public class VilleControler {
	
	@Autowired
	VilleBLO villeService;

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(value = "codePostal",required = false) String codePostal) {
		System.out.println("GET");
		ArrayList<Ville> ville = villeService.getInfoVille(codePostal);
		return ville;
	}
	
	// Methode POST
	@RequestMapping(value = "/ville/post", method = RequestMethod.POST)
	@ResponseBody
	public String appelPost(@RequestBody Ville ville) throws ClassNotFoundException, SQLException {
		System.out.println("POST");
		villeService.creationVille(ville);
		return "Requete post executé";
	}

	// Methode PUT
	@RequestMapping(value = "/ville/put", method = RequestMethod.PUT)
	@ResponseBody
	public String appelPut(@RequestBody Ville ville) throws ClassNotFoundException, SQLException {
		System.out.println("PUT");
		villeService.miseAJour(ville);
		return "Requete put executé";
	}

	// Methode DELETE
	@RequestMapping(value = "/ville/delete", method = RequestMethod.DELETE)
	public String deleteEmployeeById(@RequestParam(value = "Code_commune_INSEE")String Code_commune_INSEE) throws Exception {
		System.out.println("DELETE");
		villeService.suppressionLigne(Code_commune_INSEE);
		return "Requete delete executé";
	}
}
