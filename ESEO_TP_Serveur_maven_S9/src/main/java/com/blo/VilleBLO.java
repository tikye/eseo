package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {

	public ArrayList<Ville> getInfoVille(String monParam);
	
	public void creationVille(Ville ville);

	public void miseAJour(Ville ville);

	public void suppressionLigne(String code_commune_INSEE);

}
