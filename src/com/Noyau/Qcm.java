package com.Noyau;

import java.util.ArrayList;

public class Qcm extends Question implements Qcmevaluer {
    
	ArrayList<String> proposition = new ArrayList<String>();
    ArrayList<String> reponse = new ArrayList<String>();
    


    public Qcm(String question,String reponse1, String reponse2, String reponse3, String reponse4) {
        this.question = question;
        this.proposition.add(reponse1);   			  // this.reponse.add("Interface");
        this.proposition.add(reponse2);
        this.proposition.add(reponse3);              //  this.reponse.add("Experience utilisateur");
        this.proposition.add(reponse4);
    }

    public ArrayList<String> getProposition() {
		return proposition;
	}

	public void setProposition(ArrayList<String> proposition) {
		this.proposition = proposition;
	}

	public ArrayList<String> getReponse() {
		return reponse;
	}

	public void setReponse(ArrayList<String> reponse) {
		this.reponse = reponse;
	}

	public void afficherquestion () {
        System.out.println("- " + this.question);
        int i = 0;
        while (i < this.proposition.size()) {
            System.out.println(i + "- " + this.proposition.get(i));
            i++;
        }
    	
    /*    int i=0,j=0;
    	int indice = Quiz.nombrequiz - 1;
    	
    	 while (i <Formateur.formation.notion.size()) {
    		// Formateur.formation.notion.get(i);	
    	   Formateur.formation.notion.get(i).afficherNotion();
    	   i++;
    	 }
    	 i=0;
         while (i <Formateur.formation.quiz.get(indice).notionQuiz.size()) {
             j = 0;
             while (j <Formateur.formation.quiz.get(indice).notionQuiz.get(i).question.size()) {
             	
            //	 Formateur.formation.quiz.get(indice).notionQuiz.get(i).question.get(j).afficherquestion(quiz);
            	System.out.println(Formateur.formation.quiz.get(indice).notionQuiz.get(i).question.get(j));  
                 j++;
             }
             i++;
         }
        int  etudiant = 0;
        i=0;
         while (etudiant < Formateur.apprenant.size()) {
        	 while (i< Formateur.apprenant.get(etudiant).reponsequiz.get(i).reponseList.size()) {
        		 //Formateur.apprenant.get(etudiant).reponsequiz.get(0).reponseList.get(i);
        		 System.out.println(Formateur.apprenant.get(etudiant).reponsequiz.get(0).reponseList.get(i));
				
        		 i++;
			}
             etudiant++;
         }*/
    }

    public double evaluerQuestionQcm(Reponse Reponse) {
        int i = 0;
        int j,k,l;
        double cpt = 0;
        int point = 0;
        boolean correcte;
        boolean trouve;
        while (i < this.proposition.size()) {
            j = 0;
            trouve = false;
            while (j < this.reponse.size() && !trouve) {
                if (this.proposition.get(i).equals(this.reponse.get(j))) {trouve = true;} else {j++;}
            }
            if (trouve) {
                k = 0;
                correcte = false;
                while (k < Reponse.reponse.size() && !correcte) {
                    if (this.proposition.get(i).equals(Reponse.reponse.get(k))) {correcte = true;} else {k++;}
                }
                if (correcte) {cpt++;} else {cpt--;}
            } else {
                l= 0;
                correcte = false;
                while (l < Reponse.reponse.size() && !correcte) {
                    if (Reponse.reponse.get(l).equals(this.proposition.get(i))) {correcte = true;} else {l++;}
                }
                if (correcte) {cpt--;} else {cpt++;}
            }
            i++;
        }
        if (cpt < 0) {
            return 0;
        } else {
            return cpt/this.proposition.size();
        }
    }

    protected boolean evaluerQuestion (String reponseEtudiant) {
        return false;
    }
}
