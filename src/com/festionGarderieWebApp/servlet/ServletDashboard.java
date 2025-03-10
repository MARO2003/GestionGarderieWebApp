package com.festionGarderieWebApp.servlet;

import com.festionGarderieWebApp.bean.Employe;
import com.festionGarderieWebApp.bean.Enfant;
import com.festionGarderieWebApp.bean.Parent;
import com.festionGarderieWebApp.dao.EnfantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet({"/ListeEnfants"})
public class ServletDashboard extends HttpServlet {
    EnfantDAO eDAO = new EnfantDAO();
    ArrayList<Enfant> enfEmp = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlList = req.getServletPath();
        int numEnf;
        // Récupérer l'objet Employe depuis la session
        HttpSession session = req.getSession();
        Employe EmpConnecte = (Employe) session.getAttribute("Emp");
        session.setAttribute("Emp", EmpConnecte);

        switch (urlList) {
            case "/ListeEnfants":


                // Vérifiez si l'objet est null (par exemple, si l'utilisateur n'est pas connecté)
                if (EmpConnecte != null) {
                    enfEmp = eDAO.getEnfantsDeEmp(EmpConnecte.getNumEmp());
                    req.setAttribute("enfEmp", enfEmp);
                    this.getServletContext().getRequestDispatcher("/teacherDashboard.jsp").forward(req, resp);
                } else {
                    // Si l'utilisateur n'est pas connecté, rediriger vers la page de connexion
                    resp.sendRedirect("login");
                }
                break;

            case "/supprimerEnfant":
                numEnf = Integer.parseInt(req.getParameter("numEnf"));
                eDAO.deleteEnfant(numEnf);
                resp.sendRedirect("ListeEnfants");
                break;

            case "/editerEnfant":
                numEnf = Integer.parseInt(req.getParameter("numEnf"));
                Enfant enfant = eDAO.getEnfantByNum(numEnf);
                req.setAttribute("enfant", enfant);
                this.getServletContext().getRequestDispatcher("/formAjoutEnfant.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();

        if (url.equals("/updateEnfant")) {

            Enfant enfant = new Enfant(
                    Integer.parseInt(req.getParameter("numEnf")),
                    req.getParameter("nom"),
                    req.getParameter("prenom"),
                    Integer.parseInt(req.getParameter("age")),
                    new Parent(req.getParameter("nomParent"),
                            req.getParameter("prenomParent"),
                            req.getParameter("numTel"))
            );
            eDAO.updateEnfant( enfant); // Méthode pour mettre à jour l'enfant
            resp.sendRedirect("ListeComplete");
        }
    }

    //    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String urlList=req.getServletPath();
//        switch (urlList){
//            case "/create":
//                break;
//        }
//    }
}
