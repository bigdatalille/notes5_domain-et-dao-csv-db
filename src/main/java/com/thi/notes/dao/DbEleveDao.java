package com.thi.notes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static com.thi.notes.dao.DbHelper.closedConnexion;
import com.thi.notes.domain.Eleve;
import com.thi.notes.domain.Sexe;


public class DbEleveDao implements EleveDao {



	/**
	 * SQL de recherche de la liste des eleves.
	 */
	private final static String QUERY_FIND_ELEVES = "SELECT * FROM eleve ";

	/**
	 * SQL de recherche de la liste des eleves par classe.
	 */
	private final static String QUERY_FIND_ELEVES_BY_CLASSE = "SELECT * FROM eleve WHERE classe = ? ";


	public List<Eleve> findEleves() {

		List<Eleve> eleves = new ArrayList<Eleve>();

		try {
			// correction :
			ResultSet rset = DbHelper.executeRequete(QUERY_FIND_ELEVES);
			
		//	Eleve eleve;
			while (rset.next()) {
		//		eleve = rsetToEleve(rset);
		//		eleves.add(eleve);
				eleves.add(rsetToEleve(rset));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closedConnexion();
		return eleves;
	}

/*
	public List<Eleve> findElevesByClasse(Integer classe) {
		List<Eleve> eleves = new ArrayList<Eleve>();

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DbHelper.getConnexion();
			stmt = con.prepareStatement(QUERY_FIND_ELEVES_BY_CLASSE);
			stmt.setInt(1, classe);

			final ResultSet rset = stmt.executeQuery();
			while (rset.next()) {
				final Eleve eleve = rsetToEleve(rset);
				eleves.add(eleve);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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
		return eleves;

	}*/

	private Eleve rsetToEleve(final ResultSet rset) throws SQLException {
		final Integer id = rset.getInt("id");
		final String nom = rset.getString("nom");
		final String prenom = rset.getString("prenom");
		final Integer annee = rset.getInt("classe");
		final Date dateNaissance = rset.getDate("date_naissance");
		final String adresse = rset.getString("adresse");
		final String sexeStr = rset.getString("sexe");
		final Sexe sexe = Sexe.valueOf(sexeStr);

		final Eleve eleve = new Eleve(id, nom, prenom, annee, sexe, dateNaissance, adresse);
		return eleve;

	}

}
