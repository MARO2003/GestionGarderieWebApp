package com.festionGarderieWebApp.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainGarderie {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Enfant> listE = new ArrayList<>();
        ArrayList<Inscription> listEnfInscrits = new ArrayList<>();
        //---------------------------------------------------------------------------------------------------------------------------------------------------------

        Educatrice e1 = new Educatrice(1, "Dupont", "Marie", "DEC", 8);
        PersonnelAdministratif e2 = new PersonnelAdministratif(2, "Durocher", "Celine", "(438)6666666", "cline@royaume.com");
        PersonnelAdministratif e3 = new PersonnelAdministratif(3, "Martin", "Julie", "(438)5555555", "julie@royaume.com");
        //---------------------------------------------------------------------------------------------------------------------------------------------------------
        ArrayList<Employe> listEmploye = new ArrayList<>();
        listEmploye.add(e1);
        listEmploye.add(e2);
        listEmploye.add(e3);


        int choix;
        do {
            //Affichage du Menu Principal
            System.out.println("\n----------------------- GARDERIE ROYAUME DES ANGES ----------------------\n" +
                    "1. Afficher la liste des enfants et leur section.\n" +
                    "2. Afficher la liste des parents associés aux enfants.\n" +
                    "3. Ajouter un enfant et son parent.\n" +
                    "4. Inscrire un enfant et lui assigner un employé responsable.\n" +
                    "5. Quitter l'application.\n" +
                    "--------------------------------------------------------------------------\n" +
                    "Faites votre choix >> 1, 2, 3, 4 ou 5 :");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Liste des enfants et leur section");
                    for (Enfant enfant : listE) {
                        enfant.afficherEnfant();
                    }
                    /*
                    for (int i = 0; i < listE.size(); i++) {
                        listE.get(i).afficherEnfant();
                    }
                     */

                    break;
                case 2:
                    System.out.println("Liste des enfants et leurs parents");
                    for (Enfant enfant : listE) {
                        enfant.afficherEnfant("Parent");
                    }
                    /*
                    for (int i = 0; i < listE.size(); i++) {
                        listE.get(i).afficherEnfant();
                     */

                    break;
                case 3:
                    System.out.println("Ajouter un enfant et son parent");

                    //Saisie des informations de l'enfant
                    System.out.print("Numéro de l'enfant:");
                    int numEnf = sc.nextInt();
                    System.out.print("Nom de l'enfant:");
                    String nomEnf = sc.next();
                    System.out.print("Prénom de l'enfant:");
                    String preEnf = sc.next();
                    System.out.print("Age de l'enfant:");
                    int ageEnf = sc.nextInt();
                    //Saisie des informations du parent
                    System.out.print("Numéro de téléphone du parent:");
                    int numPar = sc.nextInt();
                    System.out.print("Nom du parent:");
                    String nomPar = sc.next();
                    System.out.print("Prénom du parent:");
                    String prePar = sc.next();
                    Parent p = new Parent(nomPar, nomPar, prePar);
                    Enfant e = new Enfant(numEnf, nomEnf, preEnf, ageEnf, p);
                    listE.add(e);
                    System.out.println("Enfant ajouté avec succés!");

                    break;
                case 4:
                    System.out.println("Inscrire un enfant et lui assigner un employé responsable.");
                    System.out.print("Veuillez saisir le numéro de l'enfant: ");
                    int numEnfant = sc.nextInt();
                    for (int i = 0; i < listE.size(); i++) {
                        if (listE.get(i).getNumEnf() == numEnfant) {

                            LocalDate dateActuelle = LocalDate.now();
                            System.out.println("Date d'inscription: " + dateActuelle);
                            System.out.print("Veillez saisir le numéro de l'employé: ");
                            int numEmp = sc.nextInt();
                            for (int j = 0; j < listEmploye.size(); j++) {
                                if (listEmploye.get(j).getNumEmp() == numEmp) {
                                    Inscription ins = new Inscription(dateActuelle, listE.get(i), listEmploye.get(j));
                                    listEnfInscrits.add(ins);
                                    System.out.println("Enfant N° " + listEnfInscrits.get(i).getEnfant().getNumEnf() + "\tEmployé N°: "
                                            + listEnfInscrits.get(j).getEmploye().getNumEmp() + "\nDate inscription:" + listEnfInscrits.get(j).getDateInscription());
                                }
                            }
                        }

                    }

                    break;
                case 5:
                    System.out.println("Fin du programme");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Erreur, le choix n'existe pas dans le menu!");
            }
        } while (choix < 6);
    }
}
