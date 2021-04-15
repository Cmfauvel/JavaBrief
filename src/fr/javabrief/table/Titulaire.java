package fr.javabrief.table;

public class Titulaire {

	private int codeTitulaire;
	private String prenomTitulaire;
	private String nomTitulaire;
	private String adresseTitulaire;
	private String codePostalTitulaire;

	public Titulaire(int codeTitulaire, String prenomTitulaire, String nomTitulaire, String adresseTitulaire,
			String codePostalTitulaire) {
		this.codeTitulaire = codeTitulaire;
		this.prenomTitulaire = prenomTitulaire;
		this.nomTitulaire = nomTitulaire;
		this.adresseTitulaire = adresseTitulaire;
		this.codePostalTitulaire = codePostalTitulaire;
	}

	public Titulaire() {
		super();
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

	@Override
	public String toString() {
		return codeTitulaire + "\t | " + prenomTitulaire + "\t | " + nomTitulaire + "\t | " + adresseTitulaire + "\t | "
				+ codePostalTitulaire;
	}

}
