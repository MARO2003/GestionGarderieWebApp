package com.festionGarderieWebApp.dao;
import com.festionGarderieWebApp.util.DbConnexion;

import  java.sql.*;
public class SelectAll {
    public static void main(String[] args) {
        DbConnexion conn=new DbConnexion();
        PreparedStatement pst;
        ResultSet rs;


        try {
            pst=conn.getConnection().prepareStatement(("SELECT " +
                    "nomEnf, prenomEnf, ageEnf, numTelParentEnf FROM ENFANT" ));
            rs=pst.executeQuery();
            System.out.println("liste d'enfants:");


            while (rs.next()){
                System.out.println(
                        "Nom:"+rs.getString("nomEnf")+
                        "\tPrenom:"+rs.getString("prenomEnf")+
                        "\tAgeEnf:"+ rs.getInt("ageEnf")+
                        "Numero Parent:"+rs.getString("numTelParentEnf"));
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}
