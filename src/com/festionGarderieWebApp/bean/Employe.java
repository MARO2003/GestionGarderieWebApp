package com.festionGarderieWebApp.bean;

public class Employe {

    // Liste des attributs de classe
    private int numEmp;
    private String nomEmp;
    private String preEmp;
    private String mdp;

    // Le constructeur de la classe
    public Employe(int numEmp,String mdp, String nomEmp, String preEmp) {
        this.mdp=mdp;
        this.numEmp = numEmp;
        this.nomEmp = nomEmp;
        this.preEmp = preEmp;
    }
    public Employe(int numEmp, String nomEmp, String preEmp) {

        this.numEmp = numEmp;
        this.nomEmp = nomEmp;
        this.preEmp = preEmp;
    }
    // Les getters

    public int getNumEmp() {
        return numEmp;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public String getPreEmp() {
        return preEmp;
    }
    // Les setters


    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public void setPreEmp(String preEmp) {
        this.preEmp = preEmp;
    }


    public String afficher() {
        return "Employe{" +
                "numEmp=" + numEmp +
                ", nomEmp='" + nomEmp + '\'' +
                ", preEmp='" + preEmp + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}

