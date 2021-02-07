/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compteBanque;

import javax.ejb.Stateless;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import  compteBanque.CompteBancaire;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author NYNA FANNY
 */
@Stateless
public class mySession {
@PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void creeUnCompteDeTest() {
        creerCompte("nyna", "fanny", "123c", 40000000);
        creerCompte("Youan", "Bi Youan", "3245c", 20000000);
        creerCompte("KONE", "Ftim", "8765c", 100000);
        creerCompte("kouassi", "mids", "12342c", 80000000);
    }

    public CompteBancaire creerCompte(String firstName,String lastName,String accountNumber, double balance) {
        CompteBancaire compt = new CompteBancaire( firstName, lastName, accountNumber, balance);
        em.persist(compt);
        return compt;
    }
    
    public Collection<CompteBancaire> getAllCompts() {
        // Exécution d'une requête équivalente à un select *
        Query q = em.createQuery("select compt from CompteBancaire compt");
        return q.getResultList();
    }

}

