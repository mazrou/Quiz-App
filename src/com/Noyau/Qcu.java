package com.Noyau;

import java.util.ArrayList;

public class Qcu extends Question {
	
    protected ArrayList<String> proposition = new ArrayList<String>();
    protected String reponse;


    public Qcu (String question) {
    	
    	this.question = question;
    }
    public Qcu(String question, String reponse1, String reponse2, String reponse3, String reponse4) {
    	this.question = question;
        this.proposition.add(reponse1);
        this.proposition.add(reponse2);         this.proposition.add(reponse4);
        this.proposition.add(reponse3);	}

	public void afficherquestion() {
        System.out.println("- " + this.question);
        int i = 0;
        while (i < this.proposition.size()) {
            System.out.println(i + "- " + this.proposition.get(i));
            i++;
        }
    }

    protected boolean evaluerQuestion (String reponseEtudiant) {
        int i = 0;
        boolean trouve = false;
        while (i < this.proposition.size() && !trouve) {
            if (reponseEtudiant.equals(this.reponse)) {trouve = true;} else {i++;}
        }
        if (trouve) {return true;} else {return false;}
    }
}
