package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;


@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;

	private Ville ville1;
	
	public ArrayList<Ville> getInfoVille(String codePostal) {
		ArrayList<Ville> ville = null;
		if (codePostal != null) {
			ville = villeDAO.getInfoVilles(codePostal);
		} else {
			ville = villeDAO.getInfoVille();
		}
		return ville;
	}
	
	public void creationVille(Ville ville) {
		villeDAO.setVille(ville);
	}

	public void miseAJour(Ville ville) {
		villeDAO.miseAJour(ville);
	}

	public void suppressionLigne(String code_commune_INSEE) {
		villeDAO.suppressionLigne(code_commune_INSEE);
	}
}
