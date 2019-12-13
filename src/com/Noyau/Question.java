package com.Noyau;

public abstract class Question {
    
	protected String question;

    abstract void afficherquestion();
    abstract boolean evaluerQuestion(String reponseEtudiant);
}
