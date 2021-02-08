/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compteBanque;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NYNA FANNY
 */
public class myServlet extends HttpServlet {

    @EJB
    private mySession mySession;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String action = request.getParameter("action");
        String reception = "";
        String message = "";
        
         if (action != null) {
            if (action.equals("listeAccount")) {
                Collection<CompteBancaire> liste = mySession.getAllCompts();
                request.setAttribute("listeDesCompts", liste);
                reception = "listAccount.jsp?action=listeAccount";
                message = "Liste des Comptes";
            } else if (action.equals("creerComptDeTest")) {
               mySession.creeUnCompteDeTest();
                Collection<CompteBancaire> liste = mySession.getAllCompts();
                request.setAttribute("listeDesCompts", liste);
                reception = "newAccount.jsp?action=listeAccount";
                message = "Liste des comptes";
            }else if(action.equals("creerCompte")){
                creerCompte(request);
                Collection<CompteBancaire> liste = mySession.getAllCompts();
                request.setAttribute("listeDesCompts", liste);
                reception = "newAccount.jsp?action=listeAccount";
                message = "Liste des compts";
            }
            else {
                reception = "index.jsp?action=todo";
                message = "La fonctionnalité pour le paramètre " + action + " est à implémenter !";
            }
        }
         RequestDispatcher dp = request.getRequestDispatcher(reception + "&message=" + message);
        dp.forward(request, response);
        // Après un forward, plus rien ne peut être exécuté après !
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public void creerCompte(HttpServletRequest request) {
        String firstName;
        String lastName;
        String accountNumber, montant;
        double balance;
        
        firstName= request.getParameter("nom");
        lastName = request.getParameter("prenom");
        accountNumber = request.getParameter("numcompt");
        montant = request.getParameter("montant");
        balance = Double.parseDouble(montant);
       mySession.creerCompte(firstName, lastName,accountNumber,balance);
    }

}
