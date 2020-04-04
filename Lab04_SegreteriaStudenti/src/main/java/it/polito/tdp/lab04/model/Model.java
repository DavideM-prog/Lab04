package it.polito.tdp.lab04.model;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	private StudenteDAO dao;
	private CorsoDAO daoC;
	
	public Model() {
		dao = new StudenteDAO();
		daoC = new CorsoDAO();
	}
	public List<String> getTuttiICorsi() {
		return daoC.getTuttiICorsi();
	}
	public List<Studente> getStudentiByNomeCorso(String nomeCorso){
		return dao.getStudentiByNomeCorso(nomeCorso);
	}
	public String getNomeByMatricola(int matricolaStudente) {
		return dao.getNomeByMatricola(matricolaStudente);
	}
	
	public String getCognomeByMatricola(int matricolaStudente) {
		return dao.getCognomeByMatricola(matricolaStudente);
	}
	public List<Corso> getCorsiStudenteByMatricola(int matricolaStudente){
		return daoC.getCorsiStudenteByMatricola(matricolaStudente);
	}
	public Studente getInserisciStudente(Integer matricola,String nome,String cognome) {
		return dao.getInserisciStudente(matricola, nome, cognome);
	}
}
