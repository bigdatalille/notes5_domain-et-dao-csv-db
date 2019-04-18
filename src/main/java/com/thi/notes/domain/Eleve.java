package com.thi.notes.domain;

import java.util.Date;

public class Eleve {

	private Integer id;
	private String nom;
	private String prenom;
	private Integer annee;
	private Sexe sexe;
	private Date dateNaissance;
	private String adresse;

	public Eleve(String nom, String prenom, Integer annee, Sexe sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.annee = annee;
		this.sexe = sexe;
	}

	
	
	public Eleve(String nom, String prenom, Integer annee, Sexe sexe, Date dateNaissance, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.annee = annee;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}

	
	public Eleve(Integer id, String nom, String prenom, Integer annee, Sexe sexe, Date dateNaissance, String adresse) {
		this(nom, prenom, annee, sexe, dateNaissance, adresse);
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Eleve [nom=" + nom + ", prenom=" + prenom + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eleve other = (Eleve) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
}
