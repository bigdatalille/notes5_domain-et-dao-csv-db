package com.thi.notes.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static com.thi.notes.dao.DbHelper.closedConnexion;


public class DbNoteDao implements NoteDao {



	/**
	 * SQL de recherche de la liste des eleves.
	 */
	private final static String QUERY_FIND_NOTES = "SELECT * FROM notes ";

	/**
	 * SQL de recherche de la liste des eleves par classe.
	 *///private final static String QUERY_FIND_NOTES_DERNIER_EXAM = "SELECT * FROM notes WHERE classe = ? ";


	public Map<String, Double> findNotesDernierExam() {
		
		Map<String, Double>  notes = new HashMap<String, Double>();
		
		
		try {
			// correction :
			ResultSet rset = DbHelper.executeRequete(QUERY_FIND_NOTES);
	
			while (rset.next()) {
				notes.put(rset.getString("nom"), rset.getDouble("note")) ;
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closedConnexion();
	

		return notes;
	}
	
	
	
	
}
