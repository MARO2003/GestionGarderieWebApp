<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Parents</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="listeParents.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet">
</head>
<body>
    <div class="wrapper d-flex">
        <!-- Sidebar -->
        <nav id="sidebar">
            <div class="sidebar-header sidebar-toggle">
                <img src="logo.png" alt="Logo">
            </div>

            <ul class="list-unstyled components">
                <li>
                    <a href="#" class="nav-link">
                        <i class="fas fa-home"></i>
                        <span>Tableau de Bord</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="nav-link" id="nav-link-active">
                        <i class="fas fa-users"></i>
                        <span>Parents</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="nav-link">
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
                        <div class="table-container">
                            <h2 class="mb-4">Liste des Parents</h2>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Nom</th>
                                        <th>Prénom</th>
                                        <th>Numéro de Téléphone</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Dupont</td>
                                        <td>Jean</td>
                                        <td>0612345678</td>
                                        <td>
                                            <div class="btn-group" role="group">
                                                <button class="btn btn-sm btn-custom me-2">Modifier</button>
                                                <button class="btn btn-sm btn-danger">Supprimer</button>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Martin</td>
                                        <td>Marie</td>
                                        <td>0687654321</td>
                                        <td>
                                            <div class="btn-group" role="group">
                                                <button class="btn btn-sm btn-custom me-2">Modifier</button>
                                                <button class="btn btn-sm btn-danger">Supprimer</button>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>

                            <div class="text-end mt-3">
                                <button class="btn btn-custom">
                                    <i class="fas fa-plus me-2"></i>Ajouter un Parent
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
    <script>
        // Script pour toggle sidebar
        document.querySelector('.sidebar-header').addEventListener('click', function() {
            document.getElementById('sidebar').classList.toggle('collapsed');
            document.getElementById('content').classList.toggle('expanded');
        });
    </script>
</body>
</html>