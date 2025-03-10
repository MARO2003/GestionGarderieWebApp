package com.festionGarderieWebApp.dao;
import com.festionGarderieWebApp.util.DbConnexion;

import java.sql.*;
public class SelectAllParent {

    public static void main(String[] args) {
        DbConnexion conn=new DbConnexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst=conn.getConnection().prepareStatement("SELECT * FROM PARENTS");
            rs=pst.executeQuery();
            System.out.println("Liste des parents:");

            while(rs.next()){
                System.out.println("\t Nom: "+rs.getString("nomPar")
                        +"\t Prenom:"+ rs.getString("prenomPar")+"\t Telephone: "+rs.getString("numTel" ));

            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de parent."+e.getMessage());
        }

    }




}
