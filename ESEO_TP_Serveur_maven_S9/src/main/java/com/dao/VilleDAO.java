package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> findAllVilles();
	
	public ArrayList<Ville> getInfoVille();
	
	public ArrayList<Ville> getInfoVilles(String codePostal);

	public void setVille(Ville ville);

	public void miseAJour(Ville ville);

	public void suppressionLigne(String code_commune_INSEE);
}
