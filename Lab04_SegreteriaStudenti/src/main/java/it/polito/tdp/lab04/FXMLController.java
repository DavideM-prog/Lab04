/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javax.management.modelmbean.ModelMBean;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController{

	private Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxCorso;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnMostraStudente;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsiStudente;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnReset;

    @FXML
    void doActivation(ActionEvent event) {
    	
    	if(boxCorso.getValue()!=null) {
    		txtRisultato.setDisable(false);
        	txtNome.setDisable(false);
        	txtCognome.setDisable(false);
    	}
    	else {
    		txtRisultato.setDisable(true);
        	txtNome.setDisable(true);
        	txtCognome.setDisable(true);
    	}
    }

    @FXML
    void doCercaCorsiStudente(ActionEvent event) {
    	txtRisultato.clear();
    	int matricolaStudente=Integer.parseInt(txtMatricola.getText());
    	List<Corso>cTemp=this.model.getCorsiStudenteByMatricola(matricolaStudente);
    	if(cTemp.size()!=0) {
	    	for(Corso c: cTemp) {
	    		txtRisultato.appendText(c.toString()+"\n");
	    	}
    	}
    	else
    		txtRisultato.appendText("Hai inserito una matricola errata\n");
    	
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	txtRisultato.clear();
    	String nomeCorso=boxCorso.getValue();
    	List<Studente> sTemp=this.model.getStudentiByNomeCorso(nomeCorso);
    	for(Studente s: sTemp) {
    		txtRisultato.appendText(s.toString()+"\n");
    	}
    }

    @FXML
    void doIscriviStudente(ActionEvent event) {
    	int matricolaStudente=Integer.parseInt(txtMatricola.getText());
    	String nome=txtNome.getText();
    	String cognome=txtCognome.getText();
    	Studente sTemp=this.model.getInserisciStudente(matricolaStudente, cognome, nome);
    	txtRisultato.appendText("E' stato iscritto un nuovo studente, il quale si chiama: "+sTemp.getNome()+sTemp.getCognome());
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtRisultato.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtMatricola.clear();
    }

    @FXML
    void mostraStudente(ActionEvent event) {
    	int matricolaStudente=Integer.parseInt(txtMatricola.getText());
    	String nome=this.model.getNomeByMatricola(matricolaStudente);
    	String cognome=this.model.getCognomeByMatricola(matricolaStudente);
    	txtNome.appendText(nome);
    	txtCognome.appendText(cognome);
    }

    @FXML
    void initialize() {
        assert boxCorso != null : "fx:id=\"boxCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnMostraStudente != null : "fx:id=\"btnMostraStudente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsiStudente != null : "fx:id=\"btnCercaCorsiStudente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	List <String> nomeCorsi=model.getTuttiICorsi();
    	txtRisultato.setDisable(true);
    	boxCorso.getItems().addAll(nomeCorsi);
    	this.model=model;
    }
 
}
