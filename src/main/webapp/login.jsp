<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="static/css/LoginStyle.css" />
    <script src="static/js/login.js" defer></script>
    <title>Connexion</title>
  </head>
  <body>
    <div class="container">
      <div class="left-section">
        <img src="images/login1.jpg" alt="image 1" class="slide active" />
        <img src="images/login2.jpg" alt="image 2" class="slide" />
        <img src="images/login3.jpg" alt="image 3" class="slide" />
      </div>

      <div class="right-section">
        <div class="header">
          <img src="images/logo.png" alt="logo little angles" />
        </div>
        <form action="login" method="post">
          <label for="num">Name</label>
          <input type="text" id="num" name="num" required />

          <label for="mdp">Password</label>
          <input type="password" id="mdp" name="mdp" required />

          <label for="role">Select Role:</label>
          <select name="role" id="role" required>
            <option value="parent">Parent</option>
            <option value="teacher">Teacher</option>
            <option value="admin">Admin</option>
          </select>
          <c:out  value="${errorMessage}"/>

          <button type="submit" name="Se connecter">Login</button>
        </form>
      </div>
    </div>
  </body>
</html>
