package com.thi.notes.domain;

public enum Sexe {

	/**
	 * Homme
	 */
	HOMME("Garçon"),

	/**
	 * Femme
	 */
	FEMME("Fille");

	private final String label;

	Sexe(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
