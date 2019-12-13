package com.Noyau;

import java.util.ArrayList;
import java.util.Scanner;

public class Notion {
    protected String notion;
    public ArrayList<Question> question = new ArrayList<Question>();

    protected Notion (String notion) {
        this.notion = notion;
    }

    public void afficherNotion() {
        System.out.println("Notion : " + this.notion);
    }

    public void ajouterQuestion (String question , String type,String reponse1,String reponse2,String reponse3,String reponse4) {
        switch (type) {
            case "Qcm":
                Qcm qcm =new Qcm(question,reponse1,reponse2,reponse3,reponse4);
                this.question.add(qcm);
                break;
            case "QO":
                this.question.add(new Qo(question,reponse1));
                
                break;
            case "QCU":
                this.question.add(new Qcu(question,reponse1,reponse2,reponse3,reponse4));
                break;
            default:
                break;
        }
    }
    protected void changerQuestion () {
    }

    protected void supprimerQuestion () {
    }
}
