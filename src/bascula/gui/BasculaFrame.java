/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui;

import bascula.hardware.strategy.BasculaStandard;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Usuario1
 */
public class BasculaFrame extends JFrame implements KeyListener,java.awt.event.WindowListener{
    BasculaPanel bp;
    private bascula.gui.suscripciones.ISuscripcionVerBascula suscripcion=null;

    public BasculaFrame() throws Exception {        
        bp=new BasculaPanel();
        this.setContentPane(bp);        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(0,0,300,190);
        this.addKeyListener(this);
        this.addWindowListener(this);
        this.setTitle("t para capturar el peso");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        BasculaStandard.CargarDLL();
        BasculaFrame bf=new BasculaFrame();                  
        bf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bf.setVisible(true);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_T){
            bp.Stop();                 
            if(suscripcion!=null){
                suscripcion.EventoDeSeleccionDePeso();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    public double getPeso(){
        return this.bp.getPeso();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        bp.Stop();        
        if(suscripcion!=null){
            suscripcion.show();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    /**
     * @param suscripcion the suscripcion to set
     */
    public void setSuscripcion(bascula.gui.suscripciones.ISuscripcionVerBascula suscripcion) {
        this.suscripcion = suscripcion;
    }

    
}
