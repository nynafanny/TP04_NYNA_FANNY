<%-- 
    Document   : listAccount.jsp
    Created on : 7 févr. 2021, 23:02:18
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
        <h1>Gestionnaire d'utilisateurs</h1>
      
        <!-- Message qui s'affiche lorsque la page est appelé avec un paramètre http message -->

        <h2>Menu de gestion des utilisateurs</h2>
        <ul>
            <li><a href="myServlet?action=listeAccount">Afficher/raffraichir la liste de tous les utilisateurs</a></li>
            <p>
        </ul>
           
        <!-- Fin du menu -->

        <!-- Zone qui affiche les utilisateurs si le paramètre action vaut listerComptes -->
        <c:if test="${param['action'] == 'listeAccount'}" >
            <h2>Liste des utilisateurs</h2>

            <table border="10">
                <!-- La ligne de titre du tableau des comptes -->
                <tr>
                    <td><b>Nom</b></td>
                    <td><b>Prénom</b></td>
                    <td><b>Numéro de Compte</b></td>
                    <td><b>Sold</b></td>
                </tr>

                <!-- Ici on affiche les lignes, une par utilisateur -->
                <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->
                <c:set var="total" value="0"/>

               <c:forEach var="compt" items="${requestScope['listeDesCompts']}">
                    <tr>
                        <td>${compt.firstName}</td>
                        <td>${compt.lastName}</td>
                        <td>${compt.accountNumber}</td>
                        <td>${compt.balance}</td>
                        <!-- On compte le nombre de users -->
                        <c:set var="total" value="${total+1}"/>
                    </tr>
                </c:forEach>

                <!-- Affichage du solde total dans la dernière ligne du tableau -->
                <tr><td><b>TOTAL</b></td><td></td><td><b>${total}</b></td><td></td></tr>
            </table>
            <br>
            <h3><a href="newAccount.jsp">Ajouter un compte</a></h3> 
        </c:if>
    </body>
</html>
