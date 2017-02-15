/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui;

import bascula.hardware.BasculaService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Usuario1
 */
public class BasculaPanel extends JPanel implements Runnable{
    BasculaService service;
    Thread t;
    private double peso;
    boolean activo=true;
    public BasculaPanel() throws Exception {
        service=new BasculaService();
        t=new Thread(this);
        t.start();
    }
    public void Stop(){
        activo=false;
    }
    @Override
    public void paint(Graphics g) {
       g.setColor(Color.BLACK);
       g.fillRect(0,0,285,150);
       g.setColor(Color.WHITE);
       g.drawRect(5,5,275,140);      
       g.setFont(new Font("TimesRoman", Font.BOLD, 65)); 
       g.drawString(""+NumberFormat.getInstance().format(getPeso())+"kg",5,100);
       g.setFont(new Font("TimesRoman", Font.BOLD, 12)); 
       //g.drawString("tecla t para capturar el peso",20,140);
    }

    @Override
    public void run() {
        for(;;){
            if(activo==true){
               try {
                   peso=service.ObtenerPeso();
                   this.repaint();                
                   Thread.sleep(20);                
                } catch (InterruptedException ex) {
                   Logger.getLogger(BasculaPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                break;
            }
        }
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

}
