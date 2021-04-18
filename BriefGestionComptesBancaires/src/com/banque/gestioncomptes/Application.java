package com.banque.gestioncomptes;

import java.sql.SQLException;

import com.banque.model.Compte;
import com.banque.model.Operation;
import com.banque.model.Titulaire;
import com.banque.model.TypeCompte;
import com.banque.sql.Requete;


import java.text.SimpleDateFormat;

public class Application {
	
	SimpleDateFormat formater = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("TITULAIRES");
			System.out.println("--------------------------------------------------------------------------------------------");
			
//			   Titulaire deleteTitulaire = Requete.getTitulaireByCode(5);
//	            if (deleteTitulaire!=null) {
//	                
//	                System.out.println(deleteTitulaire);                
//	            }
//	            Requete.deleteTitulaire(deleteTitulaire);
//	            
//	            Titulaire createTitulaire = new Titulaire();
//	                createTitulaire.setCodeTitulaire(0);
//	                createTitulaire.setPrenomTitulaire("Gérard");
//	                createTitulaire.setNomTitulaire("bidule");
//	                createTitulaire.setAdresseTitulaire("425 chemin des pepinieres");
//	                createTitulaire.setCodePostalTitulaire("26160");
//	                Requete.createTitulaire(createTitulaire);
//
//	            Titulaire titulaireUpdate = Requete.getTitulaireByCode(12);
//	                titulaireUpdate.setPrenomTitulaire("Victor");
//	                Requete.titulaireUpdate(titulaireUpdate);                 
	            
	            
	            
			for(Titulaire t : Requete.getAllTitulaires()) {
				System.out.println(t);
			}
			
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("OPERATIONS");
			System.out.println("--------------------------------------------------------------------------------------------");
//			
//			//Je calcule le nombre d'opérations
//			Requete.getNombreOperation();
//			
//			//J'ajoute une opération à la suite des autres
//			Operation operation = new Operation(0, 3, "2021-04-11", "Jean", -50, "d");
//			
//			Requete.ajouterOperation(operation);			
//		
//			//Je modifie une opération
//			Requete.modifierOperation(operation);
//			
//			Operation monOp = Requete.getOperationByCode(3);
//			monOp.setMontant(122);
//			Requete.modifierOperation(monOp);
			
			//J'affiche toutes mes opérations après changement
			for(Operation op : Requete.getAllOperations()) {
				System.out.println(op);
			}
			
			//Je supprime une opération
//			Operation monOp1 = Requete.getOperationByCode(10);
//			if (monOp1!=null)
//			{
//				System.out.println(monOp1);	
//			}
//			Requete.supprimerOperation(operation);
			
			
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("COMPTES");
			System.out.println("--------------------------------------------------------------------------------------------");
			
			// INSERT INTO //

            // Compte newCompte = new Compte(11, "a", 7, (float) 9.97);
            // Compte updateSolde = new Compte(10, "b", 14, (float) 6.03);
//            Requete.ajouterCompte(newCompte);

            // DELETE //

            // Requete.deleteCompte(newCompte);

            // UPDATE //

            // Requete.updateCompte(updateSolde);

            // READ //
           
            for (Compte c : Requete.getAllCompte()) {

                System.out.println(c);
            }
            
            System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("TYPES DE COMPTE");
			System.out.println("--------------------------------------------------------------------------------------------");
			
			// INSERT INTO //

            // TypeCompte newTypeCompte = new TypeCompte("d", "");
//            Requete.ajouterCompte(newTypeCompte);

            // DELETE //

            // Requete.deleteType(newTypeCompte);

            // UPDATE //

            // Requete.updateType(updateType);

            // READ //
           
            for (TypeCompte tc : Requete.getAllTypeCompte()) {

                System.out.println(tc);
            }
            
  
           
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		
	}
	
	

}
