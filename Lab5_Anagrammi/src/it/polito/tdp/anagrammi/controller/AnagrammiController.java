package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	private Model model;

	public void setModel(Model model) {
		// TODO Auto-generated method stub
		this.model =model;
	}	
	

	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField parola;

    @FXML
    private Button calcolaAnagrammi;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;
    
    @FXML
    private Button reset;

    @FXML 
    void doReset(ActionEvent event) {
  
    	textArea1.setText(""); 
    	textArea2.setText("");
    	parola.setText("");
    	
    }
    
    
    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	
    	String word=parola.getText();
    	model.ricorsiva(word,word,0,"");
    	
    	
    	/*for( String s:model.getAnagrammi())
    		System.out.println(s);*/
    	word="";
    	for(String s : model.getAnagrammiCorretti(model.getAnagrammi()))
    		word+= s+"\n";
    	textArea1.setText(word);
    	
    	word="";
    	for(String s : model.getAnagrammiErrati(model.getAnagrammi()))
    		word+= s+"\n";
    	textArea2.setText(word);
    	
    	
    	

    }

    @FXML
    void initialize() {
        assert parola != null : "fx:id=\"parola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert calcolaAnagrammi != null : "fx:id=\"calcolaAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert textArea1 != null : "fx:id=\"textArea1\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert textArea2 != null : "fx:id=\"textArea2\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert reset != null : "fx:id=\"reset\" was not injected: check your FXML file 'Anagrammi.fxml'.";
    }


}

