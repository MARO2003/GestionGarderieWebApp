package com.festionGarderieWebApp.bean;

public class Educatrice extends Employe {
    // Liste des attributs de classe
    private String diplome;
    private int nbEnfant;

    // Le constructeur de la classe
    public Educatrice(int numEmp,String mdp, String nomEmp, String preEmp, String diplome, int nbEnfant) {
        super(numEmp,mdp, nomEmp, preEmp);
        this.diplome = diplome;
        this.nbEnfant = nbEnfant;
    }
    public Educatrice(int numEmp, String nomEmp, String preEmp, String diplome, int nbEnfant) {
        super(numEmp, nomEmp, preEmp);
        this.diplome = diplome;
        this.nbEnfant = nbEnfant;
    }
    // Les getters

    public String getDiplome() {
        return diplome;
    }

    public int getNbEnfant() {
        return nbEnfant;
    }
    // Les setters

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public void setNbEnfant(int nbEnfant) {
        this.nbEnfant = nbEnfant;
    }

    @Override
    public String toString() {
        return this.afficher()+"Educatrice{" +
                "diplome='" + diplome + '\'' +
                ", nbEnfant=" + nbEnfant +
                '}';
    }
}
