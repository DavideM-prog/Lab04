package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;


public class StudenteDAO {
	public List<Studente> getStudentiByNomeCorso(String nomeCorso){
		
		String sql = "SELECT studente.matricola,studente.nome,cognome,CDS FROM studente,corso,iscrizione "
				+ "WHERE corso.nome= ? "
				+ " AND corso.codins=iscrizione.codins "
				+ " AND iscrizione.matricola=studente.matricola ";
		List<Studente> studenti = new ArrayList<Studente>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,nomeCorso );
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Studente s = new Studente(rs.getInt("matricola"), rs.getString("nome"), rs.getString("cognome"), rs.getString("CDS"));
				studenti.add(s);
			}
			
			conn.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return studenti;
		
	}
	
	
	//trovare il nome data la matricola
	public String getNomeByMatricola(Integer matricolaStudente) {
		String sql= "SELECT * FROM studente WHERE matricola= ? ";
		Studente sTemp=new Studente(0, null, null, null);
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,matricolaStudente);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				sTemp = new Studente(rs.getInt("matricola"), rs.getString("nome"), rs.getString("cognome"), rs.getString("CDS"));
			}
			
			conn.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return sTemp.getNome();
	}
	
	//trovare il cognome data la matricola
	public String getCognomeByMatricola(Integer matricolaStudente) {
		String sql= "SELECT * FROM studente WHERE matricola= ? ";
		Studente sTemp=new Studente(0, null, null, null);
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,matricolaStudente);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				sTemp = new Studente(rs.getInt("matricola"), rs.getString("nome"), rs.getString("cognome"), rs.getString("CDS"));
			}
			
			conn.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return sTemp.getCognome();
	}
	
	public Studente getInserisciStudente(Integer matricola,String cognome,String nome) {
		String sql="INSERT INTO studente (matricola,cognome,nome,CDs) "
				+ "VALUES ('?','?','?','')";
		Studente sTemp=new Studente(0, null, null, "");
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,matricola);
			st.setString(2, cognome);
			st.setString(3, nome);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				sTemp = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"), "");
			}
			
			conn.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return sTemp;
	}
	

}
