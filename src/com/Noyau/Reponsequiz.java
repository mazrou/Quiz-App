package com.Noyau;

import java.util.ArrayList;

public class Reponsequiz {
	
    protected ArrayList<Reponse> reponseList = new ArrayList<Reponse>();
    protected int idReponseQuiz;
    protected double tauxAccomplissement;
    protected double tauxReussite;
    protected boolean valideEvaluer;
    protected boolean accompli;

    public Reponsequiz () {
        this.tauxAccomplissement = 0;
        this.tauxReussite = 0;
        this.valideEvaluer = false;
        this.accompli = false;
    }
}
