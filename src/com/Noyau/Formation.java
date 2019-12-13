package com.Noyau;

import java.util.ArrayList;
import java.util.Date;

public class Formation {
    public String nom;
    public String description;
    public String datedebut;
    public String datefin;
    public ArrayList<Notion> notion = new ArrayList<Notion>();
    public ArrayList<Quiz> quiz = new ArrayList<Quiz>();

    public Formation (String nom, String description, String datedebut, String datefin) {
        this.nom = nom;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public void afficherFormation () {
        System.out.println("Fomation : " + this.nom + this.description);
        System.out.println(this.datedebut+" - "+this.datefin);
    }

    public void creerNotion (String notion) {
        this.notion.add(new Notion(notion));
    }

    public void modifierNotion (String notion) {
    }
}
