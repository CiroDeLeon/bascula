/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario1
 */
public class JPA {
    public static EntityManagerFactory getEntityManagerFactory(){
     return Persistence.createEntityManagerFactory("basculaPU");
    }
}
