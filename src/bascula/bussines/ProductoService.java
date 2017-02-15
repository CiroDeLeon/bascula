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
public class ProductoService {
    private bascula.controller.ProductoJpaController controller;

    public ProductoService() {
        controller=new bascula.controller.ProductoJpaController(JPA.getEntityManagerFactory());
    }

    /**
     * @return the controller
     */
    public bascula.controller.ProductoJpaController getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(bascula.controller.ProductoJpaController controller) {
        this.controller = controller;
    }

}
