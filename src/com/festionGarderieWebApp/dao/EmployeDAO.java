package com.festionGarderieWebApp.dao;

import com.festionGarderieWebApp.bean.Educatrice;
import com.festionGarderieWebApp.bean.Employe;
import com.festionGarderieWebApp.bean.PersonnelAdministratif;
import com.festionGarderieWebApp.util.DbConnexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeDAO {
    DbConnexion conn=new DbConnexion();
    PreparedStatement pst;
    ResultSet rs;
    public ArrayList<Employe> getEmployees(){
        ArrayList<Employe> employes= new ArrayList<>();
        try {
            pst=conn.getConnection().prepareStatement("SELECT * FROM EMPLOYE");
            rs=pst.executeQuery();
            while(rs.next()){
                if(rs.getString("typeEmp").equals("Educatrice")){
                    Educatrice ed=new Educatrice(
                            rs.getInt("numEmp"),
                            rs.getString("mdp"),
                            rs.getString("nomEmp"),
                            rs.getString("prenomEmp"),
                            rs.getString("diplomeEmp"),
                            rs.getInt("nbEnf"));
                    employes.add(ed);
                }
                if(rs.getString("typeEmp").equals("Admin"))
                {
                    PersonnelAdministratif pa=new PersonnelAdministratif(
                            rs.getInt("numEmp"),
                            rs.getString("mdp"),
                            rs.getString("nomEmp"),
                            rs.getString("prenomEmp"),
                            rs.getString("numTel"),
                            rs.getString("emailEmp")
                    );
                    employes.add(pa);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employes;
    }

    public ArrayList<Employe> getEmployeesbyGard(String nomGard){
        ArrayList<Employe> employes= new ArrayList<>();
        try {
            pst=conn.getConnection().prepareStatement("SELECT * FROM EMPLOYE WHERE nomGard=?");
            pst.setString(1,nomGard);
            rs=pst.executeQuery();
            while(rs.next()){
                if(rs.getString("typeEmp").equals("Educatrice")){
                    Educatrice ed=new Educatrice(
                            rs.getInt("numEmp"),
                            rs.getString("mdp"),
                            rs.getString("nomEmp"),
                            rs.getString("prenomEmp"),
                            rs.getString("diplomeEmp"),
                            rs.getInt("nbEnf"));
                    employes.add(ed);
                }
                if(rs.getString("typeEmp").equals("Admin"))
                {
                    PersonnelAdministratif pa=new PersonnelAdministratif(
                            rs.getInt("numEmp"),
                            rs.getString("mdp"),
                            rs.getString("nomEmp"),
                            rs.getString("prenomEmp"),
                            rs.getString("numTel"),
                            rs.getString("emailEmp")
                    );
                    employes.add(pa);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employes;
    }

    public static void main(String[] args) {
        EmployeDAO edao=new EmployeDAO();
        ArrayList<Employe> employes=edao.getEmployees();

        for (int i = 0; i < employes.size(); i++) {
            System.out.println(employes.get(i).toString());
        }
    }

    public void deleteEmploye(int numEmp) {
        try {
            pst=conn.getConnection().prepareStatement("DELETE FROM EMPLOYE WHERE numEmp=?");
            pst.setInt(1,numEmp);
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
