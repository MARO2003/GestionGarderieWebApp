<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="fr">
  <head>


    <title>Garderie - Tableau de Bord</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <link rel="stylesheet" type="text/css" href="static/css/TeachersDashboardCSS.css" />
        <script src="static/js/TeachersDashboardJS.js" defer></script>
  </head>
  <body>
    <div class="wrapper d-flex">
      <!-- Sidebar -->
      <nav id="sidebar">
        <div class="sidebar-header sidebar-toggle">
          <img
            src="images/logo.png"
            alt="Logo"
          />
        </div>

        <ul class="list-unstyled components">
          <li class="active">
            <a href="teacherDashboard.jsp" class="nav-link" id="nav-link-active">
              <i class="fas fa-home"></i>
              <span>enfants</span>
            </a>
          </li>
          <li>
            <a href="Parents.jsp" class="nav-link">
              <i class="fas fa-puzzle-piece"></i>
              <span>Parents</span>
            </a>
          </li>
          <li>
            <a href="employes.jsp" class="nav-link" id="nav-link">
              <i class="bi bi-calendar"></i>
              <span>Employe</span>
            </a>
          </li>
          <li>
            <a href="logout.html" class="nav-link">
              <i class="fas fa-sign-out-alt"></i>
              <span>Déconnexion</span>
            </a>
          </li>
        </ul>
      </nav>

      <!-- Content -->
      <div id="content">
        <div class="container-fluid p-4">
          <div class="row">
            <div class="col-12">
              <h2><c:out value="Bienvenue ${Emp.nomEmp}" /></h2>
              <!-- Cartes statistiques -->
              <div class="row mt-4">
                <div class="col-md-4">
                  <div class="stats-card">
                    <h3 class="text-center"><c:out value="${enfEmp.size()}" /></h3>
                    <p class="text-center mb-0">Enfants Inscrits</p>
                  </div>
                </div>
              </div>
              <!-- Liste des enfants -->
              <div class="table-container">
                <div
                  class="d-flex justify-content-between align-items-center mb-3"
                >
                  <h4>Liste des Enfants</h4>
                  <a href="create?numEmp=${Emp.numEmp}" class="btn btn-custom">
                    <i class="fas fa-plus"></i> Inscrire
                  </a>
                </div>
                <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Numero</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Age</th>
                        <th>Section</th>
                        <th>Numero Telephone</th>
                        <th>Nom Parent</th>
                        <th>Prenom Parent</th>
                        <th>Actions</th>
                      </tr>
                    </thead>
                    <tbody>
                       <c:forEach var="enfant" items="${enfEmp}">
                          <tr>
                            <td><c:out value="${enfant.numEnf}"/></td>
                            <td><c:out value="${enfant.nomEnf}"/></td>
                            <td><c:out value="${enfant.prenomEnf}"/></td>
                            <td><c:out value="${enfant.ageEnf}"/></td>
                            <td><c:out value="${enfant.affectSection(enfant.ageEnf)}"/></td>
                            <td><c:out value="${enfant.parentEnf.numTel}"/></td>
                            <td><c:out value="${enfant.parentEnf.nomPar}"/></td>
                            <td><c:out value="${enfant.parentEnf.prePar}"/></td>
                            <td>
                              <a
                                href="editerEnfant?numEnf=${enfant.numEnf}"
                                class="btn btn-sm btn-custom"
                              >
                                <i class="fas fa-edit"></i>
                              </a>
                              <a
                                href="supprimerEnfant?numEnf=${enfant.numEnf}"
                                class="btn btn-sm btn-danger"
                                onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet enfant ?')"
                              >
                                <i class="fas fa-trash"></i>
                              </a>
                            </td>
                          </tr>
                        </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>

  </body>
</html>
