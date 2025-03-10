package com.festionGarderieWebApp.bean;

import java.time.LocalDate;

public class Inscription {
    // Liste des attributs de classe
    private LocalDate dateInscription;
    private Enfant enfant;
    private Employe employe;

    // Le constructeur de la classe
    public Inscription(LocalDate dateInscription, Enfant enfant, Employe employe) {
        this.dateInscription = dateInscription;
        this.enfant = enfant;
        this.employe = employe;
    }

    // Les getters
    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public Employe getEmploye() {
        return employe;
    }

    // Les setters
    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
