package com.thi.notes.domain;

public class NoteEleve {

	private Eleve eleve;

	private Double note;

	public NoteEleve(Eleve eleve, Double note) {
		super();
		this.eleve = eleve;
		this.note = note;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

}
