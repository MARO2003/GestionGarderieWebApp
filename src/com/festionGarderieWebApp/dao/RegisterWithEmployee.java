package com.festionGarderieWebApp.dao;
import com.festionGarderieWebApp.util.DbConnexion;

import java.sql.*;
import java.time.LocalDate;

public class RegisterWithEmployee {
    public static void main(String[] args) {
        DbConnexion conn=new DbConnexion();
        PreparedStatement pst;
        int numEnf=1,numEmp=1;

        try {
            pst=conn.getConnection().prepareStatement("INSERT INTO INSCRIPRION(numEnf,numEmp,DATEINSCRIPTION) VALUES(?,?,?)");
            pst.setInt(1,numEnf);
            pst.setInt(2,numEmp);
            pst.setDate(3, Date.valueOf(LocalDate.now()));
            pst.executeUpdate();

            System.out.println("insertion reussie");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
