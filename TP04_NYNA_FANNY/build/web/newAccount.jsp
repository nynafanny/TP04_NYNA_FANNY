<%-- 
    Document   : newAccount.jsp
    Created on : 7 févr. 2021, 23:01:34
    Author     : NYNA FANNY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center" text-color="red">
            <h1>Gestionnaire d'utilisateurs</h1>
            <ol>
           <a href="myServlet?action=creerComptDeTest">Créons 4 utilisateurs de test</a>
            <br>
            <a href="listAccount.jsp">Liste des comptes </a>
            <h3>Créer un Compte</h3> <br>
            <form action="myServlet" method="get"> <br>
                 <input type="text" name="numcompt" placeholder="numero compte"/><br> <br>
                 <input type="text" name="nom" placeholder="nom"/><br> <br>
                 <input type="text" name="prenom" placeholder="prénom"/><br> <br>
                 <input type="number" name="montant" placeholder="montant en chiffre"/><br> <br>
                <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->
                <input type="hidden" name="action" value="creerCompte"/>
                <input type="submit" value="création" name="submit"/>
            </form>
            <br>
            <h3><a href="listAccount.jsp">Liste des comptes </a></h3> 
          </ol>
        </div>
    </body>
</html>
