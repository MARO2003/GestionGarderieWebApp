package com.festionGarderieWebApp.servlet;

import com.festionGarderieWebApp.bean.Employe;
import com.festionGarderieWebApp.bean.Enfant;
import com.festionGarderieWebApp.bean.Garderie;
import com.festionGarderieWebApp.bean.Parent;
import com.festionGarderieWebApp.dao.EnfantDAO;
import com.festionGarderieWebApp.dao.GarderieDAO;
import com.festionGarderieWebApp.dao.InscriptionDAO;
import com.festionGarderieWebApp.dao.ParentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet({"/create", "/inscrire"})
public class ServletAjoutEnfant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlAction = req.getServletPath();
        switch (urlAction) {
            case "/incrire":
                this.getServletContext().getRequestDispatcher("//formAjoutParent.jsp");
                break;


            case "/create":
                int numEmp = Integer.parseInt(req.getParameter("numEmp"));
                req.setAttribute("numEmp",numEmp);
                this.getServletContext().getRequestDispatcher("/formAjoutEnfant.jsp").forward(req,resp);
                System.out.println(numEmp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlAction = req.getServletPath();
//        HttpSession session = req.getSession();
//        Employe empConnecte = (Employe) session.getAttribute("Emp");
        switch (urlAction) {
            case "/inscrire":
                String nomEnf = req.getParameter("nom");
                String prenomEnf = req.getParameter("prenom");
                int ageEnf = Integer.parseInt(req.getParameter("age"));
                String phone = req.getParameter("phone");

                //Liste de parents
                ParentDAO pDAO = new ParentDAO();
                ArrayList<Parent> parents = pDAO.getListParent();
                GarderieDAO gDAO = new GarderieDAO();
                int numEmp= Integer.parseInt(req.getParameter("numEmp"));
                boolean trouve=false;
                for (Parent parent : parents) {
                    if (parent.getNumTel().equals(phone)) {
                        EnfantDAO enfDAO = new EnfantDAO();
                        Enfant enf = new Enfant(nomEnf, prenomEnf, ageEnf, parent);
                        enfDAO.ajouterEnfant(enf);
                        System.out.println();
                        InscriptionDAO insDao = new InscriptionDAO();
                        insDao.InscrireEnfant(enfDAO.getLastId(), numEmp);
                        System.out.println("je suis bien rentree");
                        resp.sendRedirect("ListeEnfants");
                        trouve = true;
                        break;
                    }
                }
                if(!trouve){
                    System.out.println("je suis mal rentree");
                    req.setAttribute("numEmp",numEmp);
                    req.setAttribute("enfant",new Enfant(nomEnf,prenomEnf,ageEnf,new Parent(phone,"","")));
                    this.getServletContext().getRequestDispatcher("/formAjoutParent.jsp").forward(req,resp);
                }


        }
    }
}
