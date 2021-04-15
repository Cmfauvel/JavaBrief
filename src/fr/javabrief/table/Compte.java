package fr.javabrief.table;

public class Compte {
	private int numeroCompte;
	private String codeTypeCompte;
	private int codeTitulaire;
	private float soldeCompte;

	public Compte(int numeroCompte, String codeTypeCompte, int codeTitulaire, float soldeCompte) {

		this.numeroCompte = numeroCompte;
		this.codeTypeCompte = codeTypeCompte;
		this.codeTitulaire = codeTitulaire;
		this.soldeCompte = soldeCompte;
	}

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "n°Compte : " + numeroCompte + "\t codeTypeCompte : " + codeTypeCompte + "\t codeTitulaire : "
				+ codeTitulaire + "\t soldeCompte : " + soldeCompte;
	}

}
