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
public class AgricultorService {
    private bascula.controller.AgricultorJpaController controller;
    

    public AgricultorService() {
        controller=new bascula.controller.AgricultorJpaController(JPA.getEntityManagerFactory());
    }

    /**
     * @return the controller
     */
    public bascula.controller.AgricultorJpaController getController() {
        return controller;
    }

}
