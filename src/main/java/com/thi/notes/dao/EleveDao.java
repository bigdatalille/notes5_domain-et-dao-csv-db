package com.thi.notes.dao;

import java.util.List;

import com.thi.notes.domain.Eleve;

public interface EleveDao {

	List<Eleve> findEleves();
	
//	List<Eleve> findElevesByClasse(Integer classe);
}
