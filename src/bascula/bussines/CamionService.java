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
public class CamionService {
    private bascula.controller.CamionJpaController controller;
    

    public CamionService() {
        controller=new bascula.controller.CamionJpaController(JPA.getEntityManagerFactory());
    }

    /**
     * @return the controller
     */
    public bascula.controller.CamionJpaController getController() {
        return controller;
    }

}
