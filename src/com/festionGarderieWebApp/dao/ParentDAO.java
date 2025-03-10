package com.festionGarderieWebApp.dao;

import com.festionGarderieWebApp.bean.Parent;
import com.festionGarderieWebApp.util.DbConnexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParentDAO {
    private DbConnexion conn=new DbConnexion();
    private PreparedStatement pst;
    ResultSet rs;

    public Parent ajouterParent(Parent newParent) {
        try {
            pst = conn.getConnection().prepareStatement("INSERT INTO PARENT(numTel,nomPar,prenomPar) values (?,?,?)");
            pst.setString(1, newParent.getNumTel());
            pst.setString(2, newParent.getNomPar());
            pst.setString(3, newParent.getPrePar());
            pst.executeUpdate();
            return newParent;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new RuntimeException(e);
        }


    }
    public ArrayList<Parent> getListParent(){
        ArrayList<Parent> parents=new ArrayList<>();
        try {
            pst=conn.getConnection().prepareStatement("SELECT * FROM PARENTS");
            rs=pst.executeQuery();
            while(rs.next()){
                Parent p=new Parent(
                        rs.getString("numTel"),
                        rs.getString("nomPar"),
                        rs.getString("prenomPar") );
                parents.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return parents;

    }
}
