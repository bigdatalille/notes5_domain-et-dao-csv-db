package com.thi.notes.dao;

import static com.thi.notes.dao.CsvFileHelper.readCsvFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvNoteDao implements NoteDao {

	private final static char SEPARATOR = ';';
	private final static String RESOURCES_PATH = "src/main/resources/";
	private final static String ELEVES_FILE_NAME = "notes-dernier-exam.csv";


	public Map<String, Double> findNotesDernierExam() {

		final List<String[]> data = readCsvFile(RESOURCES_PATH + ELEVES_FILE_NAME, SEPARATOR);

		final Map<String, Double> map = dataToMap(data);

		return map;
	}

	private Map<String, Double> dataToMap(List<String[]> data) {
		final Map<String, Double> map = new HashMap<String, Double>();

		for (String[] oneData : data) {

			final String nom = oneData[0];
			final String prenom = oneData[1];

			final String noteStr = oneData[2];
			final Double note = new Double(noteStr.replace(",", "."));

			map.put(nom + " " + prenom, note);
		}

		return map;
	}

}
