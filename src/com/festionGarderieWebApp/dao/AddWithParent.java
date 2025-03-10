package com.festionGarderieWebApp.dao;
import com.festionGarderieWebApp.util.DbConnexion;

import java.sql.*;
public class AddWithParent {
    public static void main(String[] args) {
        DbConnexion conn=new DbConnexion();
        PreparedStatement pst;
        PreparedStatement pst2;
        String numTel="9897",
                nomPar="papa",
                prenomPar="Daddy",
                nomEnf="Madha",
                prenomEnf="Madhani";


        int numEnf=10,ageEnf=3,nomGard=876;
        try {
            pst=conn.getConnection().prepareStatement("INSERT INTO PARENTS(numTel,nomPar,prenomPar) VALUES(?,?,?)");
            pst2=conn.getConnection().prepareStatement("INSERT INTO ENFANT (numEnf,nomEnf,prenomEnf,ageEnf,numTelParentEnf,nomGard) VALUES(?,?,?,?,?,?)");
            pst.setString(1,numTel);
            pst.setString(2,nomPar);
            pst.setString(3,prenomPar);
            pst2.setInt(1,numEnf);
            pst2.setString(2,nomEnf);
            pst2.setString(3,prenomEnf);
            pst2.setInt(4,ageEnf);
            pst2.setString(5,numTel);
            pst2.setInt(6,nomGard);

            pst.executeUpdate();
            pst2.executeUpdate();
            System.out.println("Ajout avec succes.");


        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'enfant."+e.getMessage());;
        }
    }
}
