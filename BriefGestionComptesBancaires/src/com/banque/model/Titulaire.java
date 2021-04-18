package com.banque.model;

public class Titulaire {
	private int codeTitulaire;
	private String prenomTitulaire;
	private String nomTitulaire;
	private String adresseTitulaire;
	private String codePostalTitulaire;
	
	public Titulaire() {
		super();
	}
	@Override
	public String toString() {
		return codeTitulaire + " " + prenomTitulaire + " "
				+ nomTitulaire + " " + adresseTitulaire + " "
				+ codePostalTitulaire + " ";
	}
	public Titulaire(int codeTitulaire, String prenomTitulaire, String nomTitulaire, String adresseTitulaire,
			String codePostalTitulaire) {
		super();
		this.codeTitulaire = codeTitulaire;
		this.prenomTitulaire = prenomTitulaire;
		this.nomTitulaire = nomTitulaire;
		this.adresseTitulaire = adresseTitulaire;
		this.codePostalTitulaire = codePostalTitulaire;
	}
	public int getCodeTitulaire() {
		return codeTitulaire;
	}
	public void setCodeTitulaire(int codeTitulaire) {
		this.codeTitulaire = codeTitulaire;
	}
	public String getPrenomTitulaire() {
		return prenomTitulaire;
	}
	public void setPrenomTitulaire(String prenomTitulaire) {
		this.prenomTitulaire = prenomTitulaire;
	}
	public String getNomTitulaire() {
		return nomTitulaire;
	}
	public void setNomTitulaire(String nomTitulaire) {
		this.nomTitulaire = nomTitulaire;
	}
	public String getAdresseTitulaire() {
		return adresseTitulaire;
	}
	public void setAdresseTitulaire(String adresseTitulaire) {
		this.adresseTitulaire = adresseTitulaire;
	}
	public String getCodePostalTitulaire() {
		return codePostalTitulaire;
	}
	public void setCodePostalTitulaire(String codePostalTitulaire) {
		this.codePostalTitulaire = codePostalTitulaire;
	}
}
