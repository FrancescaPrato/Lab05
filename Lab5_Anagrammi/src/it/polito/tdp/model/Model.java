package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.DAO.paroleDAO;

public class Model {

	private List <String> anagrammi;
	
	private paroleDAO paroledao =new paroleDAO();
	

	
	public Model() {
		// TODO Auto-generated constructor stub
		anagrammi = new ArrayList<String>();
	}

	

	//provo a creare un algoritmo, uso una parola inserita da tastiera
	// come livello uso il numero di lettere
	
	// passo la parola il livello e l'anagramma in composizione
	// tipo ricorsiva (eat, 1, "")
	public  void ricorsiva(String parola, String daTogliere, int level, String anagramma) {
		
		
		
		if (level == parola.length()) {
					this.aggiungiAnagramma(anagramma);
					return ;
		}
		
		for(int lettera=0; lettera<daTogliere.length()  ; lettera++) {
			StringBuilder sb = new StringBuilder(daTogliere);
			sb.deleteCharAt(lettera);
			ricorsiva(parola,sb.toString(),level+1,anagramma+daTogliere.charAt(lettera));
		}
		
		
		
		return ;
	}
	

	public void aggiungiAnagramma( String s) {
		
		if(anagrammi.contains(s))
			return;
		
		anagrammi.add(s);
		
		return;
		
	}

	public List<String> getAnagrammi() {
		return anagrammi;
	}

	public List<String> getAnagrammiCorretti(  List<String>  lista) {
		
		List<String> corrette = new LinkedList<String>();
		
		for(String s :lista)
			if(paroledao.cercaParola(s))
				corrette.add(s);
		
		return corrette;
				
	}
	
public List<String> getAnagrammiErrati(  List<String>  lista) {
		
		List<String> errate = new LinkedList<String>();
		
		for(String s :lista)
			if(!paroledao.cercaParola(s))
				errate.add(s);
		
		return errate;
				
	}

	
	
	

	
	

}
