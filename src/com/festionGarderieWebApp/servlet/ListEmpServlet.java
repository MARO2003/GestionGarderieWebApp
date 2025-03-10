package com.festionGarderieWebApp.servlet;

import com.festionGarderieWebApp.bean.Employe;
import com.festionGarderieWebApp.dao.EmployeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/adminListEmp","/deleteEmp","/updateEmp","/editEmp"})
public class ListEmpServlet extends HttpServlet {
    EmployeDAO empDao = new EmployeDAO();
    ArrayList<Employe> employes = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        String url = req.getServletPath();
        switch (url){
            case "/adminListEmp":
                employes = empDao.getEmployees();
                req.setAttribute("employes",employes);
                this.getServletContext().getRequestDispatcher("/adminListEmp.jsp").forward(req,resp);
                break;
            case "/deleteEmp":
                empDao.deleteEmploye(Integer.parseInt(req.getParameter("numEmp")));
                resp.sendRedirect("adminListEmp");
                break;
            case "/updateEmp":

                break;
        }
    }
}

