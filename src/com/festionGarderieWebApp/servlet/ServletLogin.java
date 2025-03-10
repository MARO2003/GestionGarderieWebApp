package com.festionGarderieWebApp.servlet;

import com.festionGarderieWebApp.bean.Educatrice;
import com.festionGarderieWebApp.bean.Employe;
import com.festionGarderieWebApp.bean.Garderie;
import com.festionGarderieWebApp.bean.PersonnelAdministratif;
import com.festionGarderieWebApp.dao.EmployeDAO;
import com.festionGarderieWebApp.dao.GarderieDAO;
import com.festionGarderieWebApp.dao.ParentDAO;
//import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numEmp = Integer.parseInt(req.getParameter("num"));
        String mdp = req.getParameter("mdp");
        String role = req.getParameter("role");
        EmployeDAO eDAO = new EmployeDAO();
        GarderieDAO gDAO = new GarderieDAO();
        Garderie garderie = null;
        ArrayList<Employe> employes = eDAO.getEmployees();

        boolean userFound = false;
        for (Employe employe : employes) {
            if (employe.getNumEmp() == numEmp && Objects.equals(employe.getMdp(), mdp)) {
                garderie = gDAO.getEmpGarderies(employe.getNumEmp());

                // Stocker l'employé dans la session
                HttpSession session = req.getSession();
                session.setAttribute("Emp", employe);

                if (employe instanceof Educatrice) {
                    Educatrice educateur = (Educatrice) employe;
                    resp.sendRedirect("ListeEnfants");
                    break;

                } else if (employe instanceof PersonnelAdministratif) {
                    PersonnelAdministratif admin = (PersonnelAdministratif) employe;
                    resp.sendRedirect("ListeComplete");
                    break;

                }
            }
            userFound=true;

        }

        if (!userFound) {
            req.setAttribute("errorMessage", "Identifiants incorrects.");
            resp.sendRedirect("login");
        }
    }
}
