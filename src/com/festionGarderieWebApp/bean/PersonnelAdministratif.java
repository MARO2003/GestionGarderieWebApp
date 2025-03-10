package com.festionGarderieWebApp.bean;

public class PersonnelAdministratif extends Employe {

    // Liste des attributs de classe
    private String numTel;
    private String emailProf;

    // Le constructeur de la classe
    public PersonnelAdministratif(int numEmp,String mdp, String nomEmp, String preEmp, String numTel, String emailProf) {
        super(numEmp,mdp, nomEmp, preEmp);
        this.numTel = numTel;
        this.emailProf = emailProf;
    }
    public PersonnelAdministratif(int numEmp, String nomEmp, String preEmp, String numTel, String emailProf) {
        super(numEmp, nomEmp, preEmp);
        this.numTel = numTel;
        this.emailProf = emailProf;
    }

    // Les getters

    public String getNumTel() {
        return numTel;
    }

    public String getEmailProf() {
        return emailProf;
    }
    // Les setters

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setEmailProf(String emailProf) {
        this.emailProf = emailProf;
    }

    @Override
    public String toString() {
        return this.afficher()+"PersonnelAdministratif{" +
                "numTel='" + numTel + '\'' +
                ", emailProf='" + emailProf + '\'' +
                '}';
    }
}
