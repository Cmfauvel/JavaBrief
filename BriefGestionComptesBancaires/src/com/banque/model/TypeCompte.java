package com.banque.model;

public class TypeCompte {
	private String codeTypeCompte;
	private String intituleCompte;
	@Override
	public String toString() {
		return "Type de Compte : " + codeTypeCompte + " Intitulé : " + intituleCompte;
	}
	public TypeCompte() {
		super();
	}
	public String getCodeTypeCompte() {
		return codeTypeCompte;
	}
	public void setCodeTypeCompte(String codeTypeCompte) {
		this.codeTypeCompte = codeTypeCompte;
	}
	public String getIntituleCompte() {
		return intituleCompte;
	}
	public void setIntituleCompte(String intituleCompte) {
		this.intituleCompte = intituleCompte;
	}
	public TypeCompte(String codeTypeCompte, String intituleCompte) {
		super();
		this.codeTypeCompte = codeTypeCompte;
		this.intituleCompte = intituleCompte;
	}
}
