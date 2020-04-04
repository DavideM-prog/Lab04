package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		System.out.println(model.getTuttiICorsi());
		System.out.println(model.getStudentiByNomeCorso("Economia aziendale"));
		System.out.println(model.getNomeByMatricola(146101));
		System.out.println(model.getCognomeByMatricola(146101));
		System.out.println(model.getCorsiStudenteByMatricola(146101));
	}

}
