package com.festionGarderieWebApp.dao;

import com.festionGarderieWebApp.bean.Enfant;
import com.festionGarderieWebApp.bean.Parent;
import com.festionGarderieWebApp.util.DbConnexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnfantDAO {
    private DbConnexion conn=new DbConnexion();
    private PreparedStatement pst;
    private ResultSet rs;

    public ArrayList<Enfant> getListeEnfant(){
        ArrayList<Enfant> enfants=new ArrayList<>();
        try {
            pst=conn.getConnection().prepareStatement("SELECT * FROM ENFANT , PARENTS WHERE " +
                    "PARENTS.numTel = ENFANT.numTelParentEnf");
            rs= pst.executeQuery();

            while(rs.next()){
                Enfant enf=new Enfant(rs.getInt("numEnf"),
                        rs.getString("nomEnf"),
                        rs.getString("prenomEnf"),
                        rs.getInt("ageEnf"),
                        new Parent(
                                rs.getString("numTel"),
                                rs.getString("nomPar"),
                                rs.getString("PrenomPar") ));
                enfants.add(enf);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enfants;

    }
    public int getLastId(){
        int maxNumEnf = 0;
        try {

            pst=conn.getConnection().prepareStatement("SELECT MAX(numEnf) as maxId FROM ENFANT ");
            rs= pst.executeQuery();

            if (rs.next()){
                maxNumEnf=rs.getInt("maxId");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxNumEnf;
    }
     public ArrayList<Enfant> getListeEnfantByGard(String nomGard){
        ArrayList<Enfant> enfants=new ArrayList<>();
        try {
            pst=conn.getConnection().prepareStatement("SELECT * FROM ENFANT , PARENTS WHERE " +
                    "PARENTS.numTel = ENFANT.numTelParentEnf and nomGard=?");
            pst.setString(1,nomGard);
            rs= pst.executeQuery();

            while(rs.next()){
                Enfant enf=new Enfant(rs.getInt("numEnf"),
                        rs.getString("nomEnf"),
                        rs.getString("prenomEnf"),
                        rs.getInt("ageEnf"),
                        new Parent(
                                rs.getString("numTel"),
                                rs.getString("nomPar"),
                                rs.getString("PrenomPar") ));
                enfants.add(enf);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enfants;

    }
    public void deleteEnfant(int numEnf){
        try {
            pst=conn.getConnection().prepareStatement("DELETE FROM ENFANT WHERE numEnf=?");
            pst.setInt(1,numEnf);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public ArrayList<Enfant> getEnfantsDeEmp(int emp){
        ArrayList<Enfant> enfants=new ArrayList<>();
        try {
            pst=conn.getConnection().prepareStatement("SELECT * FROM ENFANT, INSCRIPTION,parents WHERE parents.numTel=enfant.numTelParentEnf and enfant.numEnf=inscription.numEnf and inscription.numEmp=?");
            pst.setInt(1,emp);
            rs=pst.executeQuery();
            while(rs.next()){
                Enfant enf=new Enfant(
                        rs.getInt("numEnf"),
                        rs.getString("nomEnf"),
                        rs.getString("prenomEnf"),
                        rs.getInt("ageEnf"),
                        new Parent(
                                rs.getString("numTelParentEnf"),
                                rs.getString("nomPar"),
                                rs.getString("PrenomPar") ));
                enfants.add(enf);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  enfants;
    }



    public void ajouterEnfant(Enfant newEnfant){
        try {

            pst=conn.getConnection().prepareStatement("INSERT INTO ENFANT (nomEnf,prenomEnf,ageEnf,numTelParentEnf,nomGard) VALUES(?,?,?,?,?)");
            pst.setString(1,newEnfant.getNomEnf());
            pst.setString(2,newEnfant.getPrenomEnf());
            pst.setInt(3,newEnfant.getAgeEnf() );
            pst.setString(4,newEnfant.getParentEnf().getNumTel());
            pst.setString(5,"1");

            pst.executeUpdate();
            System.out.println("Enfant Ajoute avec succes");

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        EnfantDAO eDao=new EnfantDAO();
//        eDao.ajouterEnfant(new Enfant("Wafo","Fopa",18,new Parent("2341","Dadju","Djuna")));


        ArrayList<Enfant> enfants=eDao.getEnfantsDeEmp(8);

        for (Enfant enfant : enfants) {
            enfant.afficherEnfant("");

        }
    }


    public Enfant getEnfantByNum(int numEnf) {
        Enfant enf=null;
        try {
            pst=conn.getConnection().prepareStatement("SELECT * FROM ENFANT , PARENTS WHERE " +
                    "numEnf=?");
            pst.setInt(1,numEnf);
            rs= pst.executeQuery();

            while(rs.next()){
               enf=new Enfant(rs.getInt("numEnf"),
                        rs.getString("nomEnf"),
                        rs.getString("prenomEnf"),
                        rs.getInt("ageEnf"),
                        new Parent(
                                rs.getString("numTel"),
                                rs.getString("nomPar"),
                                rs.getString("PrenomPar") ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enf;
    }

    public void updateEnfant( Enfant enfant) {
        try {
            pst=conn.getConnection().prepareStatement("UPDATE ENFANT SET " +
                    "nomEnf=?," +
                    "prenomEnf=?," +
                    "ageEnf=?" +
                    "where numEnf=?");
            pst.setString(1,enfant.getNomEnf());
            pst.setString(2,enfant.getPrenomEnf());
            pst.setInt(3,enfant.getAgeEnf());
            pst.setInt(4,enfant.getNumEnf());
            pst.executeUpdate();
            System.out.println("enfant modifie");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
