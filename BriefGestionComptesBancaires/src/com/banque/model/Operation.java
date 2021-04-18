package com.banque.model;



public class Operation {
	private int codeOperation;
	private int numeroCompte;
	private String dateOperation;
	private String libelleOperation;
	private float montant;
	private String typeOperation;
	
	
	@Override
	public String toString() {
		return "Operation : " + codeOperation + " | " + numeroCompte + " | "
				+ dateOperation + " | " + libelleOperation + " | " + montant
				+ " | Débit(d) ou crédit(c) : " +typeOperation;
	}
	public Operation() {
		super();
	}
	public Operation(int codeOperation, int numeroCompte, String dateOperation, String libelleOperation, float montant,
			String typeOperation) {
		super();
		this.codeOperation = codeOperation;
		this.numeroCompte = numeroCompte;
		this.dateOperation = dateOperation;
		this.libelleOperation = libelleOperation;
		this.montant = montant;
		this.typeOperation = typeOperation;
	}
	public int getCodeOperation() {
		return codeOperation;
	}
	public void setCodeOperation(int codeOperation) {
		this.codeOperation = codeOperation;
	}
	public int getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	
	public String getLibelleOperation() {
		return libelleOperation;
	}
	public void setLibelleOperation(String libelleOperation) {
		this.libelleOperation = libelleOperation;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}
	public String getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}
	
	
}
