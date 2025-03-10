package com.festionGarderieWebApp.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnexion {

    //Parametres de connexion a la base de donnees
    private String url="jdbc:oracle:thin:@localhost:1521/xe";
    private String username="system";
    private String password="oracle";

    public Connection conn;
    public DbConnexion(){
        try{

            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection(url,username,password);
            System.out.println("La connexion  a ete etablie avec succes!");

        }
        catch(SQLException | ClassNotFoundException e){
            System.err.println("echec de connexion :"+e.getMessage());
        }

    }
    public  Connection getConnection(){
        return this.conn;
    }

    public static void main(String[] args) {
        DbConnexion test= new DbConnexion();
        test.getConnection();
    }
}
