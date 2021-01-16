package Pack;

import java.util.ArrayList;

public class Professeur 
{
	String nom,specialite;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	public Professeur(String nom, String specialite) {
		super();
		this.nom = nom;
		this.specialite = specialite;
	}
	
	

}
