package com.Noyau;

//import java.lang.invoke.ConstantBootstraps;
import java.util.*;

import javafx.util.converter.DateStringConverter;

public class Formateur extends Authentification {
    public  Formation formation;
    public static ArrayList<Apprenant> apprenant = new ArrayList<Apprenant>();
    public String nom;
    public String prenom;
   

    Scanner sc = new Scanner(System.in);

    public Formateur (String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void creerCompte () {

    }

    public void seConnecter () {

    }

    public void afficherFormateur () {
        System.out.println("le formateur est : " + this.nom + " " + this.prenom);
        this.formation.afficherFormation();
    }

    public void creerFormation (String nom, String description, String datedebut, String datefin) {
        this.formation = new Formation(nom, description, datedebut, datefin);
    }

    public void creerCompteApprenant (String nom, String prenom, String datenaissance, String adresse) {
        this.apprenant.add(new Apprenant (nom, prenom, datenaissance, adresse));
    }

    public void modifierCompteApprenant (int id) {
        int i = 1;
        if (id < Apprenant.nombreapprenant) {
            while (i != 0) {
                this.apprenant.get(id).afficherApprenant();
                System.out.println("/// Modification compte apprenant ///");
                System.out.println("1- Voulez vous modifier le nom de l'apprenant ?");
                System.out.println("2- Voulez vous modifier le prenom de l'apprenant ?");
                System.out.println("3- Voulez vous modifier la date de naissance de l'apprenant ?");
                System.out.println("4- Voulez vous modifier l'adresse de l'apprenant ?");
                int k = sc.nextInt();
                switch (k) {
                    case 1:
                        System.out.println(this.apprenant.get(id).nom);
                        System.out.println("- Veuillez indiquer le nouveau nom de l'apprenant:");
                        this.apprenant.get(id).nom = sc.next();
                        break;
                    case 2:
                        System.out.println("- Veuillez indiquer le nouveau pr�nom de l'apprenant:");
                        this.apprenant.get(id).prenom = sc.next();
                        break;
                    case 3:
                        System.out.println("- Veuillez indiquer la date de naissance de l'apprenant:");
                        System.out.println("Service indisponible !");
                        break;
                    case 4:
                        System.out.println("- Veuillez indiquer l'adresse de l'apprenant:");
                        this.apprenant.get(id).adresse = sc.next();
                    default:
                        System.out.println("Vous ne pouvez effectuer aucune modification !");
                }
                System.out.println("////////////////////");
                this.apprenant.get(id).afficherApprenant();
                System.out.println("////////////////////");
                System.out.println("Voulez vous effectuer d'autres modifications ? Oui = */Non = 0");
                i = sc.nextInt();
            }

        }
    }

    public void supprimerCompteApprenant (int id) {
        if (id < Apprenant.nombreapprenant) {
            this.apprenant.remove(id);
            Apprenant.nombreapprenant--;
        } else {
            System.out.println("Etudiant n'existe pas !");
        }
    }
    public void creerQuiz (String nom, String dateouverture, String dateexpiration, String etat) {
        int i = 0;
        int j;
        int etudiant = 0;
        int notion = 0;
        int question = 0;
        this.formation.quiz.add(new Quiz(nom, dateouverture, dateexpiration, etat));
        int indice = Quiz.nombrequiz - 1;
        while (etudiant < this.apprenant.size()) {
            this.apprenant.get(etudiant).quizList.add(new Quiz(nom, dateouverture, dateexpiration, etat));
            etudiant++;
        }
        System.out.println(Quiz.nombrequiz);
    //    System.out.println("/// Traitement des notions ///");
        while (i < this.formation.notion.size()) {
       //     this.formation.notion.get(i).afficherNotion();
         //   System.out.println("Voulez-vous ajouter cette notion au quiz ? Oui = 1/ Non = *");
        
                this.formation.quiz.get(indice).notionQuiz.add(this.formation.notion.get(i));
                etudiant = 0;
                while (etudiant < this.apprenant.size()) {
                    this.apprenant.get(etudiant).quizList.get(indice).notionQuiz.add(this.formation.notion.get(i));
                    etudiant++;
                }
            
            i++;
        }
        i = 0;
        System.out.println("//////////////////////////////");
        System.out.println("/// Traitement des questions des notions choisies ///");
        while (i < this.formation.quiz.get(indice).notionQuiz.size()) {
            j = 0;
            while (j < this.formation.quiz.get(indice).notionQuiz.get(i).question.size()) {
              //  this.formation.quiz.get(indice).notionQuiz.get(i).question.get(j).afficherquestion();
               
                    this.formation.quiz.get(indice).questionQuiz.add(this.formation.quiz.get(indice).notionQuiz.get(i).question.get(j));
                    etudiant = 0;
                    while (etudiant < this.apprenant.size()) {
                        this.apprenant.get(etudiant).quizList.get(indice).questionQuiz.add(this.formation.quiz.get(indice).notionQuiz.get(i).question.get(j));
                        etudiant++;
                    }
                
                j++;
            }
            i++;
        }
        etudiant = 0;
        while (etudiant < this.apprenant.size()) {
            this.apprenant.get(etudiant).reponsequiz.add(new Reponsequiz());
            etudiant++;
        }
    }
/*
 public void afficherquestion(ArrayList<Quiz> quiz) {
	 
    	ArrayList<String> questionlist = new ArrayList<String>();
    	int i=0,j=0;
    	int indice = Quiz.nombrequiz - 1;
    	
    	 while (i < Formateur.formation.notion.size()) {
    		 Formateur.formation.notion.get(i).afficherNotion();;	    		 
    	 }
    	 i++;

    	 while (i < Formateur.formation.quiz.get(indice).notionQuiz.size()) {
             j = 0;
             while (j < Formateur.formation.quiz.get(indice).notionQuiz.get(i).question.size()) {
             	
            	 Formateur.formation.quiz.get(indice).notionQuiz.get(i).question.get(j).afficherquestion(quiz);
                    
                 j++;
             }
             i++;
         }
        int  etudiant = 0;
         while (etudiant < Formateur.apprenant.size()) {
        	 while (i< Formateur.apprenant.get(etudiant).reponsequiz.get(i).reponseList.size()) {
        		 Formateur.apprenant.get(etudiant).reponsequiz.get(0).reponseList.get(i);
				i++;
			}
             etudiant++;
         }
         /*
    	questionlist.add(question);
    	questionlist.add(reponse1);
    	questionlist.add(reponse2);
    	questionlist.add(reponse3);
    	questionlist.add(reponse4);   	
	}
*/
  /*  public void consulterQuiz (int id) {
        if (id < Quiz.nombrequiz) {
            Formateur.formation.quiz.get(id-1).afficherQuiz();
            int i = 0;
          System.out.println("/// Notions du quiz ///");
            while (i < Formateur.formation.quiz.get(id-1).notionQuiz.size()) {
            	
                Formateur.formation.quiz.get(id-1).notionQuiz.get(i).afficherNotion();
                i++;
            }
            i = 0;
          System.out.println("/// Questions du quiz ///");
            while (i <= Formateur.formation.quiz.get(id-1).questionQuiz.size()) {
               
             System.out.print("///////////// " + i + "");
             
             Formateur.formation.quiz.get(id-1).questionQuiz.get(i).afficherquestion();
                i++;
            }
        }
    }*/

    /*public void consulterQuiz (int id) {
        if (id < Quiz.nombrequiz) {
        	this.formation.quiz.get(id-1).afficherQuiz();
            int i = 0;
            System.out.println("/// Notions du quiz ///");
            while (i < this.formation.quiz.get(id-1).notionQuiz.size()) {
            	this.formation.quiz.get(id-1).notionQuiz.get(i).afficherNotion();
                i++;
            }
            int j= 0;
            
            System.out.println("/// Questions du quiz ///");
            System.out.println(this.formation.quiz.get(id-1).questionQuiz.size());
            for (Question qst : this.formation.quiz.get(id-1).questionQuiz)
            {
              //  i++;
           //     System.out.println("///////////// " + i + "size=="+ Formateur.formation.quiz.get(id-1).questionQuiz.size());
                //i--;
            	qst.afficherquestion();
               // System.out.println(qst.);
            //   Formateur.formation.quiz.get(id-1).questionQuiz.get(j).afficherquestion();
               // Formateur.formation.quiz.get(id-1).notionQuiz.get(0).question.get(j).afficherquestion();
                j++;
            }
        }
    }*/
    public void consulterQuiz (int id) {
        if (id < Quiz.nombrequiz) {
            this.formation.quiz.get(id-1).afficherQuiz();
            int i = 0;
            System.out.println("/// Notions du quiz ///");
            while (i < this.formation.quiz.get(id-1).notionQuiz.size()) {
                this.formation.quiz.get(id-1).notionQuiz.get(i).afficherNotion();
                i++;
            }
            i = 0;
            System.out.println("/// Questions du quiz ///");
            while (i < this.formation.quiz.get(id-1).questionQuiz.size()) {
                //i++;
                System.out.print("///////////// " + i + "");
                //i--;
                this.formation.quiz.get(id-1).questionQuiz.get(i).afficherquestion();
                i++;
            }
        }
    }
    public void supprimerQuestionQuiz (int id) {
        this.consulterQuiz(id);
        System.out.println("Veuillez indiquer le id de la question � supprimer");
        int i = sc.nextInt();
        i--;
        if (i < this.formation.quiz.get(id).questionQuiz.size()) {
            this.formation.quiz.get(id).questionQuiz.remove(i);
        } else {
            System.out.println("Question n'existe pas !");
        }
        this.consulterQuiz(id);
    }

    public void ajouterQuestionQuiz (int id) {
        int i = 0;
        int m = 0;
        int l = 0;
        int etudiant = 0;
        int j;
        int k;
        boolean notion = false;
        boolean question = false;
        boolean trouve = false;
        boolean ajout = false;
        while (i < this.formation.notion.size() && !notion) {
            this.formation.notion.get(i).afficherNotion();
            System.out.println("Voulez vous ajouter une question de cette notion, Oui = 1/Non = *");
            k = sc.nextInt();
            if (k == 1) {
                notion = true;
            } i++;
        }
        if (notion) {
            l = 0;
            while (l < this.formation.quiz.get(id-1).notionQuiz.size() && !question) {
                if (this.formation.quiz.get(id-1).notionQuiz.get(l).notion.equals(this.formation.notion.get(i-1).notion)) {
                    question = true;
                } else {
                    l++;
                }
            }
            if (question) {
                i--;
                j = 0;
                m = 0;
                while (j < this.formation.notion.get(i).question.size()) {
                    this.formation.quiz.get(id-1).notionQuiz.get(l).question.get(j).afficherquestion();
                    trouve = false;
                    while (m < this.formation.quiz.get(id-1).questionQuiz.size() && !trouve) {
                        if (this.formation.quiz.get(id-1).notionQuiz.get(l).question.get(j).question.equals(this.formation.quiz.get(id-1).questionQuiz.get(m).question)) {
                            System.out.println("Cette question existe déja !");
                            trouve = true;
                        } else {
                            System.out.println("Voulez vous ajouter cette question au quiz ? Oui = 1/Non = *");
                            k = sc.nextInt();
                            if (k == 1) {
                                this.formation.quiz.get(id-1).questionQuiz.add(this.formation.quiz.get(id-1).notionQuiz.get(l).question.get(j));
                                etudiant = 0;
                                while (etudiant < this.apprenant.size()) {
                                    this.apprenant.get(etudiant).quizList.get(id-1).questionQuiz.add(this.formation.quiz.get(id-1).notionQuiz.get(l).question.get(j));
                                    etudiant++;
                                }
                                System.out.println("Question ajoutée !");
                            }
                        }
                        m++;
                    }
                    j++;
                }
            } else {
                this.formation.notion.get(l).afficherNotion();
                this.formation.quiz.get(id-1).notionQuiz.add(this.formation.notion.get(l));
                etudiant = 0;
                while (etudiant < this.apprenant.size()) {
                    this.apprenant.get(etudiant).quizList.get(id-1).notionQuiz.add(this.formation.notion.get(l));
                    etudiant++;
                }
                System.out.println("Notion ajout�e !");
                j = 0;
                i = this.formation.quiz.get(id-1).notionQuiz.size() - 1;
                while (j < this.formation.quiz.get(id-1).notionQuiz.get(i).question.size() && !ajout) {
                    this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(j).afficherquestion();
                    System.out.println("Voulez-vous ajouter cette question au quiz ? Oui = 1/ Non = *");
                    k = sc.nextInt();
                    if (k == 1) {
                        this.formation.quiz.get(id-1).questionQuiz.add(this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(j));
                        etudiant = 0;
                        while (etudiant < this.apprenant.size()) {
                            this.apprenant.get(etudiant).quizList.get(id-1).questionQuiz.add(this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(j));
                            etudiant++;
                        }
                        ajout = true;
                        System.out.println("Question ajout�e !");
                    }
                    j++;
                }
            }
        } else {
            System.out.println("Aucune notion choisie ! Pas de question à ajouter");
        }
    }

    public void remplacerQuestionQuiz (int id) {
        consulterQuiz(id);
        int i = 0;
        int j = 0;
        int m;
        int k;
        int l;
        int etudiant = 0;
        boolean trouve = false;
        boolean arret = false;
        System.out.println("Veuillez indiquer le numéro de question à remplacer");
        k = sc.nextInt();
        k--;
        while (i < this.formation.quiz.get(id-1).notionQuiz.size() && !trouve) {
            j = 0;
            while (j < this.formation.quiz.get(id-1).questionQuiz.size() && !trouve) {
                if (this.formation.quiz.get(id-1).questionQuiz.get(k).question.equals(this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(j).question)) {
                    trouve = true;
                } else {
                    j++;
                }
            }
            i++;
        }
        if (trouve) {
            m = 0;
            i--;
            while (m < this.formation.quiz.get(id-1).notionQuiz.get(i).question.size() && !arret) {
                if (m != j) {
                    this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(m).afficherquestion();
                    System.out.println("Voulez vous remplacer la question par celle la� ? Oui = 1/Non = *");
                    l = sc.nextInt();
                    if (l == 1) {
                        this.formation.quiz.get(id-1).questionQuiz.set(k, this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(m));
                        System.out.println("Question remplac�e !");
                        arret = true;
                        while (etudiant < this.apprenant.size()) {
                            this.apprenant.get(etudiant).quizList.get(id-1).questionQuiz.set(k, this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(m));
                            etudiant++;
                        }
                    }
                }
                m++;
            }
            if (!arret) {
                System.out.println("Question non remplacée");
            }
            this.consulterQuiz(id);
         }
    }

   /* public void classementApprenant () {
        
    	Collections.sort(this.apprenant);

        for (Apprenant str:this.apprenant) {
            System.out.println(str);
        }
    }*/
}
