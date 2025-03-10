package com.festionGarderieWebApp.bean;

public class Parent {
    // Liste des attributs de classe
    private String numTel;
    private String nomPar;
    private String prePar;

    // Le constructeur  de la classe
    public Parent(String numTel, String nomPar, String prePar) {
        this.numTel = numTel;
        this.nomPar = nomPar;
        this.prePar = prePar;
    }
    // Les getters

    public String getNumTel() {
        return numTel;
    }

    public String getNomPar() {
        return nomPar;
    }

    public String getPrePar() {
        return prePar;
    }
    // Les setters


    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setNomPar(String nomPar) {
        this.nomPar = nomPar;
    }

    public void setPrePar(String prePar) {
        this.prePar = prePar;
    }
}
