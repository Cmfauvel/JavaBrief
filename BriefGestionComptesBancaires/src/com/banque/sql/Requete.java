package com.banque.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.banque.model.*;


import com.banque.connexion.*;

public class Requete {
	
	/**************************************************************************************************************/
	/*                                           TITULAIRE                                                        */
	/**************************************************************************************************************/
	
	
	public static ArrayList<Titulaire> getAllTitulaires() throws ClassNotFoundException, SQLException

	{
		ArrayList<Titulaire>  titulaires = new ArrayList<Titulaire>();
		String requete	= "SELECT * FROM titulaire ORDER BY nom_titulaire";
		ResultSet resultat = AccesBD.executerQuery(requete);
		while(resultat.next())
		{
			Titulaire titulaire = new Titulaire();
			titulaire.setCodeTitulaire(resultat.getInt("code_titulaire"));
			titulaire.setNomTitulaire(resultat.getString("nom_titulaire"));
			titulaire.setPrenomTitulaire(resultat.getString("prenom_titulaire"));
			titulaire.setAdresseTitulaire(resultat.getString("adresse_titulaire"));
			titulaire.setCodePostalTitulaire(resultat.getString("code_postal_titulaire"));
			titulaires.add(titulaire);
			
		}
		return titulaires;
	}
	
	public static Titulaire getTitulaireByCode(int code_titulaire) throws ClassNotFoundException, SQLException{
        String requete = "SELECT * FROM titulaire WHERE CODETITULAIRE=?";
        PreparedStatement preparedStatement = AccesBD.getConnexion().prepareStatement(requete);
        preparedStatement.setInt(1, code_titulaire);
        ResultSet resultat = preparedStatement.executeQuery();
            resultat.next();
            Titulaire titulaire = new Titulaire();
            
            titulaire.setPrenomTitulaire(resultat.getString("PRENOMTITULAIRE"));
            titulaire.setNomTitulaire(resultat.getString("NOMTITULAIRE"));
            titulaire.setAdresseTitulaire(resultat.getString("ADRESSETITULAIRE"));
            titulaire.setCodePostalTitulaire(resultat.getString("CODEPOSTALETITULAIRE"));
            titulaire.setCodeTitulaire(resultat.getInt("CODETITULAIRE"));
            
        return titulaire;
    }
    
                
    public static  void titulaireUpdate(Titulaire titulaire) throws SQLException{
        PreparedStatement preparedStatement = AccesBD.getConnexion().prepareStatement("UPDATE Titulaire SET PRENOMTITULAIRE=?, NOMTITULAIRE=?, ADRESSETITULAIRE=?, CODEPOSTALETITULAIRE=? WHERE CODETITULAIRE=?");
                        
                preparedStatement.setString(1,titulaire.getPrenomTitulaire());
                preparedStatement.setString(2,titulaire.getNomTitulaire());
                preparedStatement.setString(3,titulaire.getAdresseTitulaire());
                preparedStatement.setString(4,titulaire.getCodePostalTitulaire());
                preparedStatement.setInt(5,titulaire.getCodeTitulaire());
                preparedStatement.executeUpdate();
    }
public static int getNombreTitulaire() throws SQLException
    {
         ResultSet resultat = AccesBD.getConnexion().createStatement().executeQuery("SELECT count(*) FROM titulaire");
         resultat.next();
         return resultat.getInt(1);
    }
    
    public static  void createTitulaire(Titulaire titulaire) throws SQLException{
        PreparedStatement preparedStatement = AccesBD.getConnexion().prepareStatement("INSERT INTO Titulaire VALUES (null, ?, ?, ?, ?)");
            
//                preparedStatement.setInt(1,titulaire.getCode_titulaire());
                preparedStatement.setString(1,titulaire.getPrenomTitulaire());
                preparedStatement.setString(2,titulaire.getNomTitulaire());
                preparedStatement.setString(3,titulaire.getAdresseTitulaire());
                preparedStatement.setString(4,titulaire.getCodePostalTitulaire());
                preparedStatement.executeUpdate();
            }
    
    
    public static void deleteTitulaire(Titulaire titulaire) throws SQLException{
        Statement statement = null;
        
            String sql = "DELETE FROM titulaire WHERE CODETITULAIRE="+titulaire.getCodeTitulaire();
            statement = AccesBD.getConnexion().prepareStatement(sql);

            statement.executeUpdate(sql);
            System.out.println("Suppression du titulaire "+ titulaire+ " effectuée");
        }
    
    

	
	/**************************************************************************************************************/
	/*                                           COMPTE                                                           */
	/**************************************************************************************************************/
	
	public static ArrayList<Compte> getAllCompte() throws SQLException, ClassNotFoundException {
		ArrayList<Compte> comptes = new ArrayList<Compte>();
		String compteSelect = "SELECT * FROM compte";
		ResultSet resultatCompte = AccesBD.executerQuery(compteSelect);

		while (resultatCompte.next()) {
			Compte compte = new Compte();
			compte.setNumeroCompte(resultatCompte.getInt("NUMERO_COMPTE"));
			compte.setCodeTypeCompte(resultatCompte.getString("CODE_TYPE_COMPTE"));
			compte.setCodeTitulaire(resultatCompte.getInt("CODE_TITULAIRE"));
			compte.setSoldeCompte(resultatCompte.getFloat("SOLDE_COMPTE"));
			comptes.add(compte);
		}
		return comptes;
	}

	public static void ajouterCompte(Compte compte) throws SQLException {

		String sqlInsert = "INSERT INTO compte (NUMERO_COMPTE, CODE_TYPE_COMPTE, CODE_TITULAIRE, SOLDE_COMPTE) VALUES (?, ?, ?, ?)";
		PreparedStatement preparedStatement = AccesBD.getConnexion().prepareStatement(sqlInsert);
		preparedStatement.setInt(1, compte.getNumeroCompte());
		preparedStatement.setString(2, compte.getCodeTypeCompte());
		preparedStatement.setInt(3, compte.getCodeTitulaire());
		preparedStatement.setFloat(4, compte.getSoldeCompte());
		preparedStatement.executeUpdate();
	}

	public static void deleteCompte(Compte compte) throws SQLException {
		String sqlDelete = "DELETE FROM compte WHERE NUMERO_COMPTE = ?";
		PreparedStatement preparedStatement = AccesBD.getConnexion().prepareStatement(sqlDelete);
		preparedStatement.setInt(1, compte.getNumeroCompte());
		preparedStatement.executeUpdate();
	}

	public static void updateCompte(Compte compte) throws SQLException {
		String sqlUpdate = "UPDATE compte SET CODE_TYPE_COMPTE = ?, CODE_TITULAIRE = ?, SOLDE_COMPTE = ? WHERE NUMERO_COMPTE = ?";
		PreparedStatement preparedStatement = AccesBD.getConnexion().prepareStatement(sqlUpdate);
		preparedStatement.setInt(4, compte.getNumeroCompte());
		preparedStatement.setString(1, compte.getCodeTypeCompte());
		preparedStatement.setInt(2, compte.getCodeTitulaire());
		preparedStatement.setFloat(3, compte.getSoldeCompte());
		preparedStatement.executeUpdate();
	}
	
	/**************************************************************************************************************/
	/*                                           OPERATION                                                        */
	/**************************************************************************************************************/
	
	public static ArrayList<Operation> getAllOperations() throws ClassNotFoundException, SQLException

	{
		ArrayList<Operation>  operations = new ArrayList<Operation>();
		String requete	= "SELECT * FROM operations ORDER BY numero_operation";
		ResultSet resultat = AccesBD.executerQuery(requete);
		while(resultat.next())
		{
			Operation operation = new Operation();
			operation.setCodeOperation(resultat.getInt("numero_operation"));
			operation.setNumeroCompte(resultat.getInt("numero_compte"));
			operation.setDateOperation(resultat.getString("date_operation"));
			operation.setLibelleOperation(resultat.getString("libelle_operation"));
			operation.setMontant(resultat.getInt("montant"));
			operation.setTypeOperation(resultat.getString("type_operation"));
			operations.add(operation);
			
		}
		return operations;
	}
	
	public static void ajouterOperation(Operation operation) throws SQLException
	{
		PreparedStatement prepareStatement = AccesBD.getConnexion().prepareStatement("INSERT INTO `operations` VALUES( null , ? , ?, ?, ?, ? )");
//		prepareStatement.setInt(1,operation.getCodeOperation());
		prepareStatement.setInt(1,operation.getNumeroCompte());
		prepareStatement.setString(2,operation.getDateOperation());
		prepareStatement.setString(3,operation.getLibelleOperation());
		prepareStatement.setFloat(4,operation.getMontant());
		prepareStatement.setString(5,operation.getTypeOperation());
		prepareStatement.executeUpdate();
		
	}
	
	public static void modifierOperation(Operation operation) throws SQLException
	{
		try {
			PreparedStatement prepareStatement = AccesBD.getConnexion().prepareStatement("UPDATE operations SET montant = ? , type_operation = ?, numero_compte = ? , type_operation = ?, libelle_operation = ? WHERE numero_operation = ? ");
			prepareStatement.setInt(6,operation.getCodeOperation());
			prepareStatement.setInt(3,operation.getNumeroCompte());
			prepareStatement.setString(4,operation.getDateOperation());
			prepareStatement.setString(5,operation.getLibelleOperation());
			prepareStatement.setFloat(1,operation.getMontant());
			prepareStatement.setString(2,operation.getTypeOperation());
			prepareStatement.executeUpdate();
			System.out.println("Modification effectuée pour l'opération : "+ operation);

		}
		catch(SQLException e){
			System.out.println("Erreur lors de la modification !");
		}
	}
	
	public static void supprimerOperation(Operation operation) throws SQLException
	{
		Statement statement = null;

		try {
			statement = AccesBD.getConnexion().createStatement();
			String sql = "DELETE FROM operations WHERE numero_operation="+operation.getCodeOperation();
			statement.executeUpdate(sql);
			System.out.println("Suppression du opération "+ operation + " effectuée");
		}
		catch(SQLException e){
			System.out.println("Erreur lors de la suppression du operation !");
		}
	}
	
	public static Operation getOperationByCode(int codeOperation) throws ClassNotFoundException, SQLException

	{
		Operation operation = new Operation();
		String requete	= "SELECT * FROM operations WHERE numero_operation=?";
		PreparedStatement preparedStatement = AccesBD.getConnexion().prepareStatement(requete);
		preparedStatement.setInt(1, codeOperation);
		ResultSet resultat = preparedStatement.executeQuery();
		resultat.next();
		operation.setCodeOperation(resultat.getInt("numero_operation"));
		operation.setNumeroCompte(resultat.getInt("numero_compte"));
		operation.setDateOperation(resultat.getString("date_operation"));
		operation.setLibelleOperation(resultat.getString("libelle_operation"));
		operation.setMontant(resultat.getInt("montant"));
		operation.setTypeOperation(resultat.getString("type_operation"));
		return operation;
			
		}
	
	public static int getNombreOperation() throws SQLException
	{
		 ResultSet resultat = AccesBD.getConnexion().createStatement().executeQuery("SELECT count(*) FROM operations");
		 resultat.next();
		 return resultat.getInt(1);
	}
	
	
	
	/**************************************************************************************************************/
	/*                                           TYPE COMPTE                                                      */
	/**************************************************************************************************************/
	
	public static ArrayList<TypeCompte> getAllTypeCompte() throws SQLException, ClassNotFoundException {
		ArrayList<TypeCompte> typesCompte = new ArrayList<TypeCompte>();
		String typeCompteSelect = "SELECT * FROM typecompte";
		ResultSet resultatTypeCompte = AccesBD.executerQuery(typeCompteSelect);

		while (resultatTypeCompte.next()) {
			TypeCompte typeCompte = new TypeCompte();
			typeCompte.setIntituleCompte(resultatTypeCompte.getString("intitule_compte"));
			typeCompte.setCodeTypeCompte(resultatTypeCompte.getString("CODE_TYPE_COMPTE"));
			typesCompte.add(typeCompte);
		}
		return typesCompte;
	}

	public static void ajouterType(TypeCompte typeCompte) throws SQLException {

		String sqlInsert = "INSERT INTO typecompte (CODE_TYPE_COMPTE, intitule_compte) VALUES (?, ?, ?, ?)";
		PreparedStatement preparedStatement = AccesBD.getConnexion().prepareStatement(sqlInsert);
		preparedStatement.setString(1, typeCompte.getIntituleCompte());
		preparedStatement.setString(2, typeCompte.getCodeTypeCompte());
		preparedStatement.executeUpdate();
	}

	public static void deleteType(TypeCompte typeCompte) throws SQLException {

		String sqlDelete = "DELETE FROM typecompte WHERE code_type_COMPTE = ?";
		PreparedStatement preparedStatement = AccesBD.getConnexion().prepareStatement(sqlDelete);
		preparedStatement.setString(1, typeCompte.getIntituleCompte());
		preparedStatement.setString(2, typeCompte.getCodeTypeCompte());
		preparedStatement.executeUpdate();
	}


	public static void updateType(TypeCompte typeCompte) throws SQLException {
		String sqlUpdate = "UPDATE typecompte SET intitule_compte = ?, CODE_TYPE_COMPTE = ?";
		PreparedStatement preparedStatement = AccesBD.getConnexion().prepareStatement(sqlUpdate);
		preparedStatement.setString(1, typeCompte.getIntituleCompte());
		preparedStatement.setString(2, typeCompte.getCodeTypeCompte());
		preparedStatement.executeUpdate();
	}

	
}
