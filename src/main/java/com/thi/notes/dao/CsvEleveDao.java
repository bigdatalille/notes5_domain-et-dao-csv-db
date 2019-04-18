package com.thi.notes.dao;

import static com.thi.notes.dao.CsvFileHelper.readCsvFile;
import static com.thi.notes.domain.Sexe.FEMME;
import static com.thi.notes.domain.Sexe.HOMME;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thi.notes.domain.Eleve;
import com.thi.notes.domain.Sexe;

public class CsvEleveDao implements EleveDao {

	private final static char SEPARATOR = ';';
	private final static String RESOURCES_PATH = "src/main/resources/";
	private final static String ELEVES_FILE_NAME = "eleves.csv";

	
	public List<Eleve> findEleves() {

		final List<String[]> data = readCsvFile(RESOURCES_PATH + ELEVES_FILE_NAME, SEPARATOR);

		final List<Eleve> eleves = dataToEleves(data);

		return eleves;
	}

	private List<Eleve> dataToEleves(List<String[]> data) {
		final List<Eleve> eleves = new ArrayList<Eleve>();

		try {
			final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			for (String[] oneData : data) {
				final String nom = oneData[0];
				final String prenom = oneData[1];
				final String classeStr = oneData[2];
				final String sexeStr = oneData[3];
				final String dateNaissanceStr = oneData[4];
				final String adresse = oneData[5];

				final Integer classe = Integer.parseInt(classeStr);
				final Sexe sexe = (sexeStr.equalsIgnoreCase("F")) ? FEMME : HOMME;
				final Date dateNaissance = dateFormat.parse(dateNaissanceStr);

				final Eleve eleve = new Eleve(nom, prenom, classe, sexe, dateNaissance, adresse);
				eleves.add(eleve);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return eleves;
	}


	public List<Eleve> findElevesByClasse(Integer classe) {
		throw new UnsupportedOperationException("Ce fonction n'est pas disponible dans le DAO des fichiers CSV.");
	}

}
