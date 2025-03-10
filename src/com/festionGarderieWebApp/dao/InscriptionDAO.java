package com.festionGarderieWebApp.dao;

import com.festionGarderieWebApp.bean.Employe;
import com.festionGarderieWebApp.bean.Enfant;
import com.festionGarderieWebApp.util.DbConnexion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class InscriptionDAO {

    private DbConnexion conn=new DbConnexion();
    private PreparedStatement pst;

    public void InscrireEnfant(int numEnf, int numEmp){
        try {



            pst=conn.getConnection().prepareStatement("INSERT INTO INSCRIPTION(numEnf" +
                    ",numEmp) VALUES(?,?)");
            pst.setInt(1,numEnf);
            pst.setInt(2,numEmp);

            pst.executeUpdate();

            System.out.println("inscription reussie reussie");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
