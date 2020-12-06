package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;


@Repository
public class VilleDAOImpl implements VilleDAO {
	
	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		return listVille;
	}
	
	public ArrayList<Ville> getInfoVille() {
		Ville ville = null;
		ArrayList<Ville> villes = new ArrayList<Ville>();
		
		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ville_france");
			while (rs.next()) {
				ville = new Ville();
				ville.setCodeCommune(rs.getString(1));
				ville.setCodePostal(rs.getString(3));
				ville.setNomCommune(rs.getString(2));
				ville.setLibelleAcheminement(rs.getString(4));
				ville.setLigne(rs.getString(5));
				ville.setLatitude(rs.getString(6));
				ville.setLongitude(rs.getString(7));
				villes.add(ville);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("erreur getInfoVille");
		}
		return villes;
	}

	public ArrayList<Ville> getInfoVilles(String codePostal) {
		ArrayList<Ville> villes = new ArrayList<Ville>();
		Ville ville = null;

		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ville_france WHERE code_postal = " + codePostal);
			while (rs.next()) {
				ville = new Ville();
				ville.setCodeCommune(rs.getString(1));
				ville.setCodePostal(rs.getString(3));
				ville.setNomCommune(rs.getString(2));
				ville.setLibelleAcheminement(rs.getString(4));
				ville.setLigne(rs.getString(5));
				ville.setLatitude(rs.getString(6));
				ville.setLongitude(rs.getString(7));
				//System.out.println("ville : " + ville.getLatitude());
				villes.add(ville);
			}
			rs.close();
			stmt.close();
			return villes;
		} catch (SQLException e) {
			System.out.println("erreur getInfoVilles");
			return null;
		}
	}
	
	public void setVille(Ville ville) {
		/*ville.setCodeCommune("'01000'");
		ville.setNomCommune("Thorigny-sur-Marne");
		ville.setCodePostal("77400");
		ville.setLibelleAcheminement("' '");
		ville.setLigne("' '");
		ville.setLongitude("'46.0'");
		ville.setLatitude("'40.0'");*/
		try {
			Connection con = JDBCConfiguration.getConnection();
			String requete ="Insert into ville_france(Code_commune_INSEE,Nom_commune,Code_postal,Libelle_acheminement,Ligne_5,Latitude,Longitude)"
					+ " values(" + ville.getCodeCommune() + ",'" + ville.getNomCommune() + "','"
					+ ville.getCodePostal() + "','" + ville.getLibelleAcheminement() + "'," + ville.getLigne()
					+ "," + ville.getLatitude() + "," + ville.getLongitude() + ")";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			System.out.println("erreur setVille");
		}
	}

	public void miseAJour(Ville ville) {
		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			String requete ="UPDATE ville_france SET Nom_commune=' " + ville.getNomCommune() + "', Code_postal='"
					+ ville.getCodePostal() + "', Libelle_acheminement='" + ville.getLibelleAcheminement()
					+ "', Ligne_5 = '" + ville.getLigne() + "', Latitude='" + ville.getLatitude() + "', Longitude='"
					+ ville.getLongitude() + "'  WHERE Code_commune_INSEE=' " + ville.getCodeCommune() + "'";
			
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			System.out.println("erreur miseAJour");
		}
	}

	@Override
	public void suppressionLigne(String code_commune_INSEE) {
		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			String requete ="DELETE FROM ville_france WHERE Code_commune_INSEE = '" + code_commune_INSEE + "'";
			System.out.println(requete);
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			System.out.println("erreur suppressionLigne");
		}
	}
}