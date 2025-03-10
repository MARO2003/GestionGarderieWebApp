package com.festionGarderieWebApp.dao;

import com.festionGarderieWebApp.bean.Garderie;
import com.festionGarderieWebApp.util.DbConnexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GarderieDAO {
    DbConnexion conn = new DbConnexion();
    PreparedStatement pst;
    ResultSet rs;

    public Garderie getEmpGarderies(int numEmp) {
        Garderie gd = null;
        EnfantDAO enfDAO = new EnfantDAO();
        EmployeDAO empDAO = new EmployeDAO();
        try {
            pst = conn.getConnection().prepareStatement("SELECT * FROM GARDERIE,Employe where GARDERIE.nomGard=Employe.nomGard and Employe.numEmp=?");
            pst.setInt(1,numEmp);
            rs = pst.executeQuery();

           while(rs.next()){
               gd = new Garderie(
                       rs.getString("nomGard"),
                       rs.getInt("capGard"),
                       enfDAO.getListeEnfantByGard(rs.getString("nomGard")),
                       empDAO.getEmployeesbyGard(rs.getString("nomGard")));

           }

        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
        return gd;
    }
    public static void main(String[] args) {
        GarderieDAO gdao=new GarderieDAO();


        System.out.println(gdao.getEmpGarderies(8).toString());

    }
}


