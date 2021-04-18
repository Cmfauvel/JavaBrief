package com.banque.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class AccesBD {
	private static Connection connexion=null;
	private static String utilisateur="root";
	private static String motDePasse="";
	private static String pilote = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/gestion_comptes_bancaires?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	
	public synchronized static Connection getConnexion() {
		try {
			Class.forName(pilote);
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			System.out.println("Connecté !");
		} 
		catch(Exception e) {
			System.out.println("Non connecté : " + e);
			e.printStackTrace();
		} return connexion;
	}
	

	
	public static ResultSet executerQuery(String requete) throws ClassNotFoundException, SQLException

	{
		
		Statement statement = null;
		ResultSet resultat = null;


		try {

			int type = ResultSet.TYPE_SCROLL_SENSITIVE;
			int mode = ResultSet.CONCUR_UPDATABLE;

			statement = getConnexion().createStatement(type,mode);
	

			resultat = statement.executeQuery(requete);

		}

		catch(SQLException e)
		{

			e.printStackTrace();
			System.exit(-1);
		
		
		}
		return resultat;	


	}
	
}
