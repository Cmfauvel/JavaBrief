package fr.javabrief.application;

import java.sql.SQLException;

import fr.javabrief.requetesql.Requete;
import fr.javabrief.table.Compte;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// INSERT INTO //

			// Compte newCompte = new Compte(11, "a", 7, (float) 9.97);
			// Compte updateSolde = new Compte(10, "b", 14, (float) 6.03);
//			Requete.ajouterCompte(newCompte);

			// DELETE //

			// Requete.deleteCompte(newCompte);

			// UPDATE //

			// Requete.updateCompte(updateSolde);

			// READ //
			/*
			 * for (Compte c : Requete.getAllCompte()) { c.setSoldeCompte(10000000);
			 * Requete.updateCompte(c); }
			 */
			for (Compte c : Requete.getAllCompte()) {

				System.out.println(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("error");
		}
	}

}
