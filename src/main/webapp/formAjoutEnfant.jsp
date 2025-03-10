<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link rel="stylesheet" type="text/css" href="static/css/formAjoutEnfantCss.css" />
                <script src="static/js/formAjoutEnfantJS.js" defer></script>


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
            <a href="/views/Teachers.html" class="nav-link">
              <i class="fas fa-home"></i>
              <span>Tableau de Bord</span>
            </a>
          </li>
          <li>
            <a
              href="/views/activite.html"
              class="nav-link"
              id="nav-link-active"
            >
              <i class="fas fa-puzzle-piece"></i>
              <span>Activités</span>
            </a>
          </li>
          <li>
            <a href="/views/emploie.html" class="nav-link" id="nav-link">
              <i class="bi bi-calendar"></i>
              <span>Emploie</span>
            </a>
          </li>
          <li>
            <a href="/views/logout.html" class="nav-link">
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
              <h2>${enfant != null ? 'Modifier un Enfant' : 'Inscrire un Enfant'}</h2>
              <!-- formulaire -->

              <form method="POST" action="${enfant != null ? 'updateEnfant' : 'inscrire'}">
                  <input type="hidden" name="numEnf" value="${enfant.numEnf}" >
                  <input type="hidden" name="numEmp" value="${numEmp != null ? numEmp : ''}"/>
                  <div class="mb-3">
                      <label for="nom">Nom</label>
                      <input type="text" class="form-control" id="nom" name="nom" value="${enfant != null ? enfant.nomEnf : ''}" required>
                  </div>
                  <div class="mb-3">
                      <label for="prenom">Prenom</label>
                      <input type="text" class="form-control" id="prenom" name="prenom" value="${enfant != null ? enfant.prenomEnf : ''}" required>
                  </div>
                  <div class="mb-3">
                      <label for="age" class="form-label">Age</label>
                      <input type="number" class="form-control" id="age" name="age" min="0" max="4" step="1" value="${enfant != null ? enfant.ageEnf : 1}" required>
                  </div>
                  <div class="mb-3">
                      <label for="phone" class="form-label">Numéro de téléphone du parent</label>
                      <input type="tel" class="form-control" id="phone" name="phone" placeholder="XXX-XXX-XXXX" pattern="^\d{3}-\d{3}-\d{4}$" value="${enfant != null ? enfant.parentEnf.numTel : ''}" required>
                      <div class="form-text">Entrez un numéro valide au format canadien.</div>
                  </div>

                  <button type="submit" class="btn btn-primary w-100">
                      ${enfant != null ? 'Mettre à jour' : 'Inscrire'}
                  </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>

  </body>
</html>
