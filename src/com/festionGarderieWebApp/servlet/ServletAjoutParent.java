package com.festionGarderieWebApp.servlet;

import com.festionGarderieWebApp.bean.Enfant;
import com.festionGarderieWebApp.bean.Parent;
import com.festionGarderieWebApp.dao.EnfantDAO;
import com.festionGarderieWebApp.dao.InscriptionDAO;
import com.festionGarderieWebApp.dao.ParentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addParent")
public class ServletAjoutParent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/formAjoutParent.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomEnf=req.getParameter("nomEnf");
        String prenomEnf=req.getParameter("prenomEnf");
        int age= Integer.parseInt(req.getParameter("age"));
        String numTel=req.getParameter("tel");
        int numEmp= Integer.parseInt(req.getParameter("numEmp"));
        String nomPar=req.getParameter("nomPar");
        String prenomPar=req.getParameter("prenomPar");
        EnfantDAO edao=new EnfantDAO();
        ParentDAO pdao=new ParentDAO();
        InscriptionDAO idao=new InscriptionDAO();
        Parent par=new Parent(numTel,nomPar,prenomPar);
        pdao.ajouterParent(par);
        edao.ajouterEnfant(new Enfant(nomEnf,prenomEnf,age,par));
        idao.InscrireEnfant(edao.getLastId(),numEmp);
        resp.sendRedirect("ListeEnfants");


    }
}
