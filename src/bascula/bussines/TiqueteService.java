/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.bussines;

import bascula.util.JPA;

/**
 *
 * @author Usuario1
 */
public class TiqueteService {
   private bascula.controller.TiqueteJpaController controller;   

    public TiqueteService() {
        controller=new bascula.controller.TiqueteJpaController(JPA.getEntityManagerFactory());
    }

    /**
     * @return the controller
     */
    public bascula.controller.TiqueteJpaController getController() {
        return controller;
    }
}
