package com.thi.notes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import com.mysql.jdbc.Statement;
public class DbHelper {
	
	public static Statement stmt;
	public static Connection con;
	/**
	 * URL de connection
	 */
	private final static String URL = "jdbc:mysql://localhost:3306/notes_eleves";

	/**
	 * Nom du user
	 */
	private final static String LOGIN = "dvp";

	/**
	 * Mot de passe du user
	 */
	private final static String PASSWORD = "hello";

	public static ResultSet executeRequete(String query) {
		ResultSet rset = null;
		
		try {
		con = getConnexion();
		stmt= con.createStatement();
		rset = stmt.executeQuery(query);
		}
		catch (Exception e) {
			e.printStackTrace();
			}
		return rset;
		}
	
	static Connection getConnexion() throws SQLException {
		con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
		return con;
	}

	public static void closedConnexion() {
		
		if (stmt != null) {
			try {
				// Le stmt.close ferme automatiquement le rset
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
