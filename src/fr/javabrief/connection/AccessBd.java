package fr.javabrief.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessBd {

	private static Connection connection = null;
	private static String user = "root";
	private static String mdp = "root";
	private static String pilote = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/banque";

	public synchronized static Connection getConnection() {
		try {
			Class.forName(pilote);
			connection = DriverManager.getConnection(url, user, mdp);
			System.out.println("connecté");

		} catch (Exception e) {
			System.out.println("Zut, la connexion a échoué");
			e.printStackTrace();
		}
		return connection;
	}

	public static ResultSet executerQuery(String requete) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Statement statement = null;
		ResultSet resultat = null;
		try {
			int type = ResultSet.TYPE_SCROLL_SENSITIVE;
			int mode = ResultSet.CONCUR_UPDATABLE;

			statement = getConnection().createStatement(type, mode);
			resultat = statement.executeQuery(requete);
		}

		catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return resultat;
	}

}
