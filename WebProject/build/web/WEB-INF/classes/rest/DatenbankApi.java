/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author TimoK
 */
public class DatenbankApi {   
    @PersistenceContext(unitName = "WebProjectPU")
    private EntityManager em = Persistence.createEntityManagerFactory("WebProjectPU").createEntityManager();
    
    @Resource
    private UserTransaction utx = null;

    public DatenbankApi() {
        try {
            this.utx = (UserTransaction) new InitialContext().lookup("UserTransaction");
        } catch (NamingException ex) {
            Logger.getLogger(DatenbankApi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
