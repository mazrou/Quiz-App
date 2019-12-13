package com.Noyau;

import java.util.ArrayList;
import java.util.Date;

public class Quiz {
    protected String nom;
    protected String dateouverture;
    protected String dateexpiration;
    public static ArrayList<Notion> notionQuiz = new ArrayList<Notion>();
    public static ArrayList<Question> questionQuiz = new ArrayList<Question>();
    protected String etat;
    protected int idQuiz;
    public static int nombrequiz;

    protected Quiz (String nom, String dateouverture, String dateexpiration, String etat) {
        this.nom = nom;
        this.dateouverture = dateouverture;
        this.dateexpiration = dateexpiration;
        this.etat = etat;
        this.idQuiz = nombrequiz;
        nombrequiz++;
    }

    public void afficherQuiz () {
        System.out.println("Quiz : " + this.nom + ", ouvre le : " + this.dateouverture + ", termine le : " + this.dateexpiration + ". Etat : " + this.etat );
    }

    protected void etatQuiz () {

    }

    protected void reussiteQuiz () {

    }
}
