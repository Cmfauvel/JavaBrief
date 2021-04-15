package fr.javabrief.requetesql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.javabrief.connection.AccessBd;
import fr.javabrief.table.Compte;
import fr.javabrief.table.Titulaire;

public class Requete {

	public static ArrayList<Titulaire> getAllTitulaire() throws SQLException, ClassNotFoundException {
		ArrayList<Titulaire> titulaires = new ArrayList<Titulaire>();
		String requete = "SELECT * FROM titulaire";
		ResultSet resultat = AccessBd.executerQuery(requete);

		while (resultat.next()) {
			Titulaire titulaire = new Titulaire();
			titulaire.setCodeTitulaire(resultat.getInt("CODETITULAIRE"));
			titulaire.setPrenomTitulaire(resultat.getString("PRENOMTITULAIRE"));
			titulaire.setNomTitulaire(resultat.getString("NOMTITULAIRE"));
			titulaire.setAdresseTitulaire(resultat.getString("ADRESSETITULAIRE"));
			titulaire.setCodePostalTitulaire(resultat.getString("CODEPOSTALTITULAIRE"));
			titulaires.add(titulaire);
		}
		return titulaires;
	}

	public static ArrayList<Compte> getAllCompte() throws SQLException, ClassNotFoundException {
		ArrayList<Compte> comptes = new ArrayList<Compte>();
		String compteSelect = "SELECT * FROM compte";
		ResultSet resultatCompte = AccessBd.executerQuery(compteSelect);

		while (resultatCompte.next()) {
			Compte compte = new Compte();
			compte.setNumeroCompte(resultatCompte.getInt("NUMEROCOMPTE"));
			compte.setCodeTypeCompte(resultatCompte.getString("CODETYPECOMPTE"));
			compte.setCodeTitulaire(resultatCompte.getInt("CODETITULAIRE"));
			compte.setSoldeCompte(resultatCompte.getFloat("SOLDECOMPTE"));
			comptes.add(compte);
		}
		return comptes;
	}

	public static void ajouterCompte(Compte compte) throws SQLException {

		String sqlInsert = "INSERT INTO compte (NUMEROCOMPTE, CODETYPECOMPTE, CODETITULAIRE, SOLDECOMPTE) VALUES (?, ?, ?, ?)";
		PreparedStatement preparedStatement = AccessBd.getConnection().prepareStatement(sqlInsert);
		preparedStatement.setInt(1, compte.getNumeroCompte());
		preparedStatement.setString(2, compte.getCodeTypeCompte());
		preparedStatement.setInt(3, compte.getCodeTitulaire());
		preparedStatement.setFloat(4, compte.getSoldeCompte());
		preparedStatement.executeUpdate();
	}

	public static void deleteCompte(Compte compte) throws SQLException {
		String sqlDelete = "DELETE FROM compte WHERE NUMEROCOMPTE = ?";
		PreparedStatement preparedStatement = AccessBd.getConnection().prepareStatement(sqlDelete);
		preparedStatement.setInt(1, compte.getNumeroCompte());
		preparedStatement.executeUpdate();
	}

	public static void updateCompte(Compte compte) throws SQLException {
		String sqlUpdate = "UPDATE compte SET CODETYPECOMPTE = ?, CODETITULAIRE = ?, SOLDECOMPTE = ? WHERE NUMEROCOMPTE = ?";
		PreparedStatement preparedStatement = AccessBd.getConnection().prepareStatement(sqlUpdate);
		preparedStatement.setInt(4, compte.getNumeroCompte());
		preparedStatement.setString(1, compte.getCodeTypeCompte());
		preparedStatement.setInt(2, compte.getCodeTitulaire());
		preparedStatement.setFloat(3, compte.getSoldeCompte());
		preparedStatement.executeUpdate();
	}

}
