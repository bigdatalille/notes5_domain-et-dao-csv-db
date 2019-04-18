package com.thi.notes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.thi.notes.dao.CsvEleveDao;
import com.thi.notes.dao.CsvNoteDao;
import com.thi.notes.dao.DbEleveDao;
import com.thi.notes.dao.DbNoteDao;
import com.thi.notes.dao.EleveDao;
import com.thi.notes.dao.NoteDao;
import com.thi.notes.domain.Eleve;

public class DaoLauncher {

	public static void main(String[] args) {

		final EleveDao eleveDao = new CsvEleveDao();
		final List<Eleve> eleves = eleveDao.findEleves();

		System.out.println("Liste des eleves");
		for (Eleve eleve : eleves) {
			System.out.println(eleve);
		}

		final NoteDao noteDao = new CsvNoteDao();
		final Map<String, Double> notes = noteDao.findNotesDernierExam();
		System.out.println();
		System.out.println("Notes des eleves");
		for (String key : notes.keySet()) {
			final Double note = notes.get(key);
			System.out.println(key + " : " + note);
		}

		final EleveDao eleveDao2 = new DbEleveDao();
		final List<Eleve> eleves2 = eleveDao2.findEleves();
		System.out.println();
		System.out.println("Liste des eleves en base");
		for (Eleve eleve : eleves2) {
			System.out.println(eleve);
		}
		
		final NoteDao noteDao2 = new DbNoteDao();
		final Map<String, Double> notes2 = noteDao2.findNotesDernierExam() ;
		System.out.println();
		System.out.println("Liste des notes pour le dernier exam en base");
	
		Iterator<Map.Entry<String, Double>> itr = notes2.entrySet().iterator();
		while(itr.hasNext()) {
		  Map.Entry<String, Double> entry = itr.next();
		  String key = entry.getKey();
		  Double value = entry.getValue();
		 System.out.println("L'eleve : "+key+" a obtenu " +value+"  au dernier Exam");
		 
		
		}

		
		
	}

}
