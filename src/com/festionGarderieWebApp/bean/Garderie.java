package com.festionGarderieWebApp.bean;

import java.util.ArrayList;

public class Garderie {

    // Liste des attributs de classe
    private String nomGard;
    private int capGard;

    // Liste des nouveaux attributs de classe
    private ArrayList<Enfant> listEnf;
    private ArrayList<Employe> listEmp;

    // Le constructeur de la classe
    public Garderie(String nomGard, int capGard, ArrayList<Enfant> listEnf, ArrayList<Employe> listEmp) {
        this.nomGard = nomGard;
        this.capGard = capGard;
        this.listEnf = listEnf;
        this.listEmp = listEmp;
    }
    // Les getters

    public String getNomGard() {
        return nomGard;
    }

    public int getCapGard() {
        return capGard;
    }

    public ArrayList<Enfant> getListEnf() {
        return listEnf;
    }

    public ArrayList<Employe> getListEmp() {
        return listEmp;
    }

    // Les setters

    public void setNomGard(String nomGard) {
        this.nomGard = nomGard;
    }

    public void setCapGard(int capGard) {
        this.capGard = capGard;
    }

    public void setListEnf(ArrayList<Enfant> listEnf) {
        this.listEnf = listEnf;
    }

    public void setListEmp(ArrayList<Employe> listEmp) {
        this.listEmp = listEmp;
    }
}
