package com.Noyau;


public class Qo extends Question {
 
	protected String proposition ;

    public Qo (String question,String reponse) {
        this.question = question;
        this.proposition=reponse;
      //  this.proposition[1] = "interfaces";
    }

    public void afficherquestion() {
        System.out.println("- " + this.question);
    }

    protected boolean evaluerQuestion (String reponseEtudiant) {
        int i = 0;
        boolean trouve = false;
        
      //  while (i < this.proposition.length && !trouve) {
            if (this.proposition.equals(reponseEtudiant)) {trouve = true;} 
      ///  }
        if (trouve) {return true;} else {return false;}
    }
}
