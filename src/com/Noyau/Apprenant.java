package com.Noyau;

import java.util.*;

public class Apprenant {

    public  String nom;
    public  String prenom;
	public  String datenasissance;
    public  String adresse;
    public double tauxReussiteMoy;
    public boolean valideEvaluer;
    public ArrayList<Quiz> quizList = new ArrayList<Quiz>();
    public ArrayList<Reponsequiz> reponsequiz = new ArrayList<Reponsequiz>();
    public static int nombreapprenant = 0;

    public Apprenant (String nom, String prenom, String datenaissance, String adresse) {
        this.nom =nom;
        this.prenom =prenom;
        this.datenasissance = datenaissance;
        this.adresse =adresse;
    /*    this.tauxReussiteMoy = 0;
        this.valideEvaluer = false;
        nombreapprenant++;*/
        
    }  
    public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getDatenasissance() {
		return datenasissance;
	}

	public String getAdresse() {
		return adresse;
	}

    Scanner sc = new Scanner(System.in);

    public void creerCompte () {
    	 String login ;
    	 String motdepassse;
    }

    public void seConnecter () {

    }

    public void afficherApprenant () {
        System.out.println("Apprenant " + this.nom + " " + this.prenom + " n�(e) le " + this.datenasissance + " habite � " + this.adresse);
    }

    public void afficherListeQuiz () {
        int i = 0;
        while (i < this.quizList.size()) {
            this.quizList.get(i).afficherQuiz();
            
            i++;
        }
    }
/*
    public void afficherReponsesApprenant (int id) {
        int i = 0;
        int qcm = 0;
        Date date = new Date();
        if (date.before(this.quizList.get(id-1).dateexpiration)) {
            while (i < this.quizList.get(id-1).questionQuiz.size()) {
                this.quizList.get(id-1).questionQuiz.get(i).afficherquestion();
                if (this.quizList.get(id-1).questionQuiz.get(i) instanceof Qcm) {
                    while (qcm < this.reponsequiz.get(id-1).reponseList.get(i).reponse.size()) {
                        System.out.println("Reponse : " + this.reponsequiz.get(id-1).reponseList.get(i).reponse.get(qcm));
                        qcm++;
                    }
                } else {
                    System.out.println("Reponse : " + this.reponsequiz.get(id-1).reponseList.get(i).reponse.get(0));
                }
                i++;
            }
        } else {
            System.out.println("Pas de r�ponses, le quiz est expir� !");
        }
    }

    public void repondreQuiz (int id) {
        this.quizList.get(id-1).afficherQuiz();
        this.reponsequiz.get(id-1).idReponseQuiz = id-1;
        int i = 0;
        int w = 0;
        int q = 0;
        int cpt = 0;
        int indice = 0;
        int x = this.quizList.get(id-1).questionQuiz.size();
        double n = 0;
        int k;
        int m;
        boolean arreter = false;
        Date date = new Date();
        if (date.before(this.quizList.get(id-1).dateexpiration)) {
            if (!this.reponsequiz.get(id-1).accompli || !this.reponsequiz.get(id-1).valideEvaluer) {
                while (i < this.quizList.get(id-1).questionQuiz.size()) {
                    this.quizList.get(id-1).questionQuiz.get(i).afficherquestion();
                    if (this.quizList.get(id-1).questionQuiz.get(i) instanceof Qcu) {
                        System.out.println("Voulez vous repondre à cette question ? Oui = 1/ Non = *");
                        k = sc.nextInt();
                        if (k == 1) {
                            System.out.println("Veuillez indiquer une r�ponse à cette question !");
                            sc.nextLine();
                            this.reponsequiz.get(id-1).reponseList.add(new Reponse(sc.nextLine()));
                            n++;
                        } else {
                            this.reponsequiz.get(id-1).reponseList.add(new Reponse("Pas de r�ponse"));
                            System.out.println("Voulez vous quitter le quiz ? Oui = 1/Non = *");
                            q = sc.nextInt();
                            if (q == 1) {
                                w = this.reponsequiz.get(id-1).reponseList.size();
                                while (w < this.quizList.get(id-1).questionQuiz.size()) {
                                    this.reponsequiz.get(id-1).reponseList.add(new Reponse("Pas de r�ponse"));
                                    w++;
                                }
                                i = this.quizList.get(id-1).questionQuiz.size();
                                System.out.println("Quitter le Quiz ...");
                            }
                        }
                    } else if (this.quizList.get(id-1).questionQuiz.get(i) instanceof Qcm) {
                        System.out.println("Voulez vous repondre à cette question ? Oui = 1/ Non = *");
                        k = sc.nextInt();
                        if (k == 1) {
                            arreter = false;
                            cpt = 0;
                            while (!arreter) {
                                System.out.println("Veuillez indiquer une r�ponse à cette question !");
                                sc.nextLine();
                                if (cpt == 0) {
                                    this.reponsequiz.get(id-1).reponseList.add(new Reponse(sc.nextLine()));
                                } else {
                                    this.reponsequiz.get(id-1).reponseList.get(indice).reponse.add(sc.nextLine());
                                }
                                indice = this.reponsequiz.get(id-1).reponseList.size() - 1;
                                cpt++;
                                System.out.println("Voulez vous ajouter une autre r�ponse à la question ? Oui = 1/Non = *");
                                m = sc.nextInt();
                                if (m != 1) {
                                    arreter = true;
                                }
                            }
                            n++;
                        } else {
                            this.reponsequiz.get(id-1).reponseList.add(new Reponse("Pas de r�ponse"));
                            System.out.println("Voulez vous quitter le quiz ? Oui = 1/Non = *");
                            q = sc.nextInt();
                            if (q == 1) {
                                w = this.reponsequiz.get(id-1).reponseList.size();
                                while (w < this.quizList.get(id-1).questionQuiz.size()) {
                                    this.reponsequiz.get(id-1).reponseList.add(new Reponse("Pas de r�ponse"));
                                    w++;
                                }
                                i = this.quizList.get(id-1).questionQuiz.size();
                                System.out.println("Quitter le Quiz ...");
                            }
                        }
                    } else {
                        System.out.println("Voulez vous r�pondre à cette question ? Oui = 1/ Non = *");
                        k = sc.nextInt();
                        if (k == 1) {
                            System.out.println("Veuillez indiquer une r�ponse à cette question !");
                            sc.nextLine();
                            this.reponsequiz.get(id-1).reponseList.add(new Reponse(sc.nextLine()));
                            n++;
                        } else {
                            this.reponsequiz.get(id-1).reponseList.add(new Reponse("Pas de r�ponse"));
                            System.out.println("Voulez vous quitter le quiz ? Oui = 1/Non = *");
                            q = sc.nextInt();
                            if (q == 1) {
                                w = this.reponsequiz.get(id-1).reponseList.size();
                                while (w < this.quizList.get(id-1).questionQuiz.size()) {
                                    this.reponsequiz.get(id-1).reponseList.add(new Reponse("Pas de r�ponse"));
                                    w++;
                                }
                                i = this.quizList.get(id-1).questionQuiz.size();
                                System.out.println("Quitter le Quiz ...");
                            }
                        }
                    }
                    i++;
                }
                this.reponsequiz.get(id-1).tauxAccomplissement = n*100/x;
                if (q != 1) {
                    this.reponsequiz.get(id-1).accompli = true;
                }
            } else {
                if (this.reponsequiz.get(id-1).accompli) {
                    System.out.println("Ce Quiz est d�ja accomplis");
                } else {
                    System.out.println("Ce Quiz est d�ja �valuer");
                }
            }
        } else {
            System.out.println("Le quiz est expir� !");
        }
    }

    public void modifierReponseQuiz (int id) {
        this.quizList.get(id - 1).afficherQuiz();
        this.reponsequiz.get(id - 1).idReponseQuiz = id - 1;
        int i = 0;
        int q = 0;
        int cpt = 0;
        int x = this.quizList.get(id - 1).questionQuiz.size();
        double n = 0;
        int k;
        int m;
        boolean arreter = false;
        Date date = new Date();
        if (date.before(this.quizList.get(id-1).dateexpiration)) {
            if (!this.reponsequiz.get(id - 1).accompli || !this.reponsequiz.get(id - 1).valideEvaluer || this.reponsequiz.get(id-1).tauxAccomplissement == 0) {
                while (i < this.quizList.get(id - 1).questionQuiz.size()) {
                    this.quizList.get(id-1).questionQuiz.get(i).afficherquestion();
                    System.out.println("Reponse : " + this.reponsequiz.get(id-1).reponseList.get(i).reponse);
                    if (this.quizList.get(id-1).questionQuiz.get(i) instanceof Qcu) {
                        System.out.println("Voulez vous modifier la r�ponse de cette question ? Oui = 1/ Non = *");
                        k = sc.nextInt();
                        if (k == 1) {
                            System.out.println("Veuillez indiquer une r�ponse à cette question !");
                            sc.nextLine();
                            this.reponsequiz.get(id-1).reponseList.get(i).reponse.set(0, sc.nextLine());
                            n++;
                        } else {
                            System.out.println("Voulez vous quitter le quiz ? Oui = 1/Non = *");
                            q = sc.nextInt();
                            if (q == 1) {
                                i = this.quizList.get(id-1).questionQuiz.size();
                                System.out.println("Quitter le Quiz ...");
                            }
                        }
                    } else if (this.quizList.get(id-1).questionQuiz.get(i) instanceof Qcm) {
                        System.out.println("Voulez vous modifier la r�ponse de cette question ? Oui = 1/ Non = *");
                        k = sc.nextInt();
                        if (k == 1) {
                            k = 0;
                            while (!arreter) {
                                System.out.println("Veuillez indiquer une r�ponse à cette question !");
                                sc.nextLine();
                                if (k < this.reponsequiz.get(id-1).reponseList.get(i).reponse.size()) {
                                    this.reponsequiz.get(id-1).reponseList.get(i).reponse.set(k, sc.nextLine());
                                } else {
                                    this.reponsequiz.get(id-1).reponseList.get(i).reponse.add(sc.nextLine());
                                }
                                k++;
                                System.out.println("Voulez vous ajouter une autre r�ponse au quiz ? Oui = 1/Non = *");
                                m = sc.nextInt();
                                if (m != 1) {
                                    arreter = true;
                                    while (k < this.reponsequiz.get(id-1).reponseList.get(i).reponse.size()) {
                                        this.reponsequiz.get(id-1).reponseList.get(i).reponse.remove(k);
                                    }
                                }
                            }
                            n++;
                        } else {
                            System.out.println("Voulez vous quitter le quiz ? Oui = 1/Non = *");
                            q = sc.nextInt();
                            if (q == 1) {
                                i = this.quizList.get(id-1).questionQuiz.size();
                                System.out.println("Quitter le Quiz ...");
                            }
                        }
                    } else {
                        System.out.println("Voulez vous modifier la r�ponse de cette question ? Oui = 1/ Non = *");
                        k = sc.nextInt();
                        if (k == 1) {
                            System.out.println("Veuillez indiquer une r�ponse à cette question !");
                            sc.nextLine();
                            this.reponsequiz.get(id-1).reponseList.get(i).reponse.set(0, sc.nextLine());
                            n++;
                        } else {
                            System.out.println("Voulez vous quitter le quiz ? Oui = 1/Non = *");
                            q = sc.nextInt();
                            if (q == 1) {
                                i = this.quizList.get(id-1).questionQuiz.size();
                                System.out.println("Quitter le Quiz ...");
                            }
                        }
                    }
                    i++;
                }
                /*this.reponsequiz.get(id-1).tauxAccomplissement = n*100/x;
                if (q != 1) {
                    this.reponsequiz.get(id-1).accompli = true;
                }
            } else {
                if (this.reponsequiz.get(id-1).accompli) {
                    System.out.println("Ce Quiz est d�ja accomplis");
                } else if (this.reponsequiz.get(id-1).tauxAccomplissement == 0) {
                    System.out.println("Quiz pas encore entam� ! Aucune modification de r�ponse n'est possible !");
                } else {
                    System.out.println("Ce Quiz est d�ja �valuer");
                }
            }
        } else {
            System.out.println("Impossible de modifier la r�ponse, le quiz est expir� !");
        }
    }

    public void evaluerReponsesApprenant (int id) {
        double x = this.quizList.get(id-1).questionQuiz.size();
        double n = 0;
        double moy = 0;
        int j = 0;
        int cpt;
        double point = 0;
        Date date = new Date();
        if (date.before(this.quizList.get(id-1).dateexpiration)) {
            if ((id-1) < Quiz.nombrequiz) {
                if (!this.reponsequiz.get(id-1).valideEvaluer) {
                    System.out.println("Voulez vous valider le Quiz pour l'�valuer Oui = 1/Non = *");
                    int k = sc.nextInt();
                    if (k == 1) {
                        this.reponsequiz.get(id-1).valideEvaluer = true;
                        int i = 0;
                        while (i < this.quizList.get(id-1).questionQuiz.size()) {
                            this.quizList.get(id-1).questionQuiz.get(i).afficherquestion();
                            System.out.println("Votre r�ponse : " + this.reponsequiz.get(id-1).reponseList.get(i).reponse);
                            if (this.quizList.get(id-1).questionQuiz.get(i) instanceof Qcu) {
                                if (this.quizList.get(id-1).questionQuiz.get(i).evaluerQuestion(this.reponsequiz.get(id-1).reponseList.get(i).reponse.get(0))) {
                                    n++; 
                                }
                            } else if (this.quizList.get(id-1).questionQuiz.get(i) instanceof Qcm) {
                                point = ((Qcm) this.quizList.get(id-1).questionQuiz.get(i)).evaluerQuestionQcm(this.reponsequiz.get(id-1).reponseList.get(i));
                                n = n + point;
                            } else {
                                if (this.quizList.get(id-1).questionQuiz.get(i).evaluerQuestion(this.reponsequiz.get(id-1).reponseList.get(i).reponse.get(0))) {
                                    n++;
                                }
                            }
                            i++;
                        }
                        moy = (n*100)/x;
                        this.reponsequiz.get(id-1).tauxReussite = (n*100)/x;
                        this.tauxReussiteMoy = this.tauxReussiteMoy + (moy)/this.quizList.size();

                        System.out.println("Le taux d'accomplissement de l'apprenant au quiz est : " + this.reponsequiz.get(id-1).tauxAccomplissement + "%");
                        System.out.println("Le taux de r�ussite de l'apprenant au quiz est : " + this.reponsequiz.get(id-1).tauxReussite + "%");
                    } else {
                        System.out.println("Quiz non valid�, pas d'�valuation disponible !");
                    }
                } else {
                    System.out.println("Ce Quiz a d�ja �t� �valu� !");
                }
            } else {
                System.out.println("Ce Quiz n'existe pas !");
            }
        } else {
            System.out.println("Pas d'�valuation, le quiz est expir� !");
        }
    }

    public void activiteApprenant () {
        int i = 0;
        while (i < this.quizList.size()) {
            this.afficherApprenant();
            this.quizList.get(i).afficherQuiz();
            System.out.println("Taux d'accomplissement du quiz : " + this.reponsequiz.get(i).tauxAccomplissement + "%");
            System.out.println("Taux de r�ussite au quiz : " + this.reponsequiz.get(i).tauxReussite + "%");
            i++;
        }
    }

    @Override
    public int compareTo(Object o) {
        Apprenant apprenant = (Apprenant) o;
        int t = (int) ((Apprenant)apprenant).tauxReussiteMoy;
        return (int)this.tauxReussiteMoy - t;
    }

    @Override
    public String toString() {
        return "[ Nom = " + this.nom + "    Pr�nom = " + this.prenom + "    TauxR�ussiteMoyen = " + this.tauxReussiteMoy + "]";
    }
    */
}