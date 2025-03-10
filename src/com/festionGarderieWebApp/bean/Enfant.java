package com.festionGarderieWebApp.bean;

public class Enfant implements Affectation {

    // Liste des attributs de classe
    private int numEnf;
    private String nomEnf;
    private String prenomEnf;
    private int ageEnf;

    // Liste des nouveaux attributs de classe
    private Parent parentEnf;
    // Le constructeur de la classe

    public Enfant(int numEnf, String nomEnf, String prenomEnf, int ageEnf, Parent parentEnf) {
        this.numEnf = numEnf;
        this.nomEnf = nomEnf;
        this.prenomEnf = prenomEnf;
        this.ageEnf = ageEnf;
        this.parentEnf = parentEnf;
    }
    public Enfant( String nomEnf, String prenomEnf, int ageEnf, Parent parentEnf) {
        this.nomEnf = nomEnf;
        this.prenomEnf = prenomEnf;
        this.ageEnf = ageEnf;
        this.parentEnf = parentEnf;
    }
    // Les getters

    public int getNumEnf() {
        return numEnf;
    }

    public String getNomEnf() {
        return nomEnf;
    }

    public String getPrenomEnf() {
        return prenomEnf;
    }

    public int getAgeEnf() {
        return ageEnf;
    }

    public Parent getParentEnf() {
        return parentEnf;
    }
    // Les setters


    public void setNumEnf(int numEnf) {
        this.numEnf = numEnf;
    }

    public void setNomEnf(String nomEnf) {
        this.nomEnf = nomEnf;
    }

    public void setPrenomEnf(String prenomEnf) {
        this.prenomEnf = prenomEnf;
    }

    public void setAgeEnf(int ageEnf) {
        this.ageEnf = ageEnf;
    }

    public void setParentEnf(Parent parentEnf) {
        this.parentEnf = parentEnf;
    }

    // Méthode redéfinie
    @Override
    public String affectSection(int age) {

        String sectionEnf = "";
        if (age < 1) {
            sectionEnf = "Section Poupon";
        } else if (age >= 1 && age < 2) {
            sectionEnf = "Petite Section";
        } else if (age >= 2 && age < 3) {
            sectionEnf = "Moyenne Section";
        } else if (age >= 3 && age < 4) {
            sectionEnf = "Grande Section";
        } else if (age >= 4 && age <= 5) {
            sectionEnf = "Petite Section";
        }
        /*if (age < 1) {
                    sectionEnf = "Section Poupon";
                } else if (age < 2) {
                    sectionEnf = "Petite Section";
                } else if (age < 3) {
                    sectionEnf = "Moyenne Section";
                } else if (age < 4) {
                    sectionEnf = "Grande Section";
                } else if (age <= 5) {
                    sectionEnf = "Petite Section";
                }*/
        return sectionEnf;
    }

    // Méthode d'affichage des enfants et leur section
    public void afficherEnfant() {

        System.out.println("Numéro: " + numEnf + "\tNom: " + nomEnf +
                "\tPrénom: " + prenomEnf + "\tAge: " + ageEnf +
                "\tSection: " + affectSection(ageEnf));
    }

    // Méthode d'affichage des enfants et leur section "Surcharge de la méthode  afficherEnfant
    public void afficherEnfant(String prt) {

        System.out.println("Numéro: " + numEnf + "\tNom: " + nomEnf +
                "\tPrénom: " + prenomEnf + "\tAge: " + ageEnf +
                "\tSection: " + affectSection(ageEnf) + "\n--> " + prt + "\tNuméro de téléphone: " + parentEnf.getNumTel() +
                "\tNom: " + parentEnf.getNomPar() + "\tPrénom: " + parentEnf.getPrePar());
    }
}
