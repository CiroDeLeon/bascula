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
public class ConductorService {
private bascula.controller.ConductorJpaController controller;

    public ConductorService() {
        controller=new bascula.controller.ConductorJpaController(JPA.getEntityManagerFactory());
    }

    /**
     * @return the controller
     */
    public bascula.controller.ConductorJpaController getController() {
        return controller;
    }

}
