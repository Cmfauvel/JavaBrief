package com.banque.model;

public class Compte {
	private int numeroCompte;
	private String codeTypeCompte;
	private int codeTitulaire;
	private float soldeCompte;
	public Compte() {
		super();
	}
	@Override
	public String toString() {
		return "Compte n° : " + numeroCompte + " | " + codeTypeCompte + " | "
				+ codeTitulaire + " | Solde : " + soldeCompte;
	}
	public Compte(int numeroCompte, String codeTypeCompte, int codeTitulaire, float soldeCompte) {
		super();
		this.numeroCompte = numeroCompte;
		this.codeTypeCompte = codeTypeCompte;
		this.codeTitulaire = codeTitulaire;
		this.soldeCompte = soldeCompte;
	}
	public int getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	public String getCodeTypeCompte() {
		return codeTypeCompte;
	}
	public void setCodeTypeCompte(String codeTypeCompte) {
		this.codeTypeCompte = codeTypeCompte;
	}
	public int getCodeTitulaire() {
		return codeTitulaire;
	}
	public void setCodeTitulaire(int codeTitulaire) {
		this.codeTitulaire = codeTitulaire;
	}
	public float getSoldeCompte() {
		return soldeCompte;
	}
	public void setSoldeCompte(float soldeCompte) {
		this.soldeCompte = soldeCompte;
	}
}
