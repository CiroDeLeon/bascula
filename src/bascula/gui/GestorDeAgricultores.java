/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui;

import bascula.bussines.AgricultorService;
import bascula.controller.exceptions.NonexistentEntityException;
import bascula.controller.exceptions.PreexistingEntityException;
import bascula.entity.Agricultor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario1
 */
public class GestorDeAgricultores extends javax.swing.JFrame implements bascula.gui.suscripciones.ISuscripcionBuscarAgricultor{
    Agricultor agricultor;
    AgricultorService service;
    bascula.gui.BuscarAgricultor ba;
    /**
     * Creates new form GestorDeAgricultores
     */
    public GestorDeAgricultores() {
        initComponents();
        this.jFormattedTextField1.setValue(new Long(0));
        service= new AgricultorService();
    }
    void Buscar(){
        ba=new bascula.gui.BuscarAgricultor();
        ba.setSuscripcion(this);
        ba.show();
        this.dispose();
    }
    public void Ingresar(){
        Long id=(Long)this.jFormattedTextField1.getValue();
        agricultor=new Agricultor();
        agricultor.setIdAgricultor(id);
        agricultor.setNaturaleza(this.jComboBox1.getSelectedItem().toString());
        agricultor.setNombres(this.jTextField1.getText());
        agricultor.setApellidos(this.jTextField2.getText());
        agricultor.setRazonSocial(this.jTextField3.getText());
        try {
            service.getController().create(agricultor);
            JOptionPane.showMessageDialog(this,"Ingresado con exito");
            this.AsignarAgricultor(null);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(GestorDeAgricultores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"ERROR NO SE PUDO INGRESAR ESE AGRICULTOR YA EXISTE");
        } catch (Exception ex) {
            Logger.getLogger(GestorDeAgricultores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"ERROR NO SE PUDO INGRESAR HUBO UNA EXCEPCION");
        }
    }
    public void Modificar(){
        Long id=(Long)this.jFormattedTextField1.getValue();        
        agricultor.setIdAgricultor(id);
        agricultor.setNaturaleza(this.jComboBox1.getSelectedItem().toString());
        agricultor.setNombres(this.jTextField1.getText());
        agricultor.setApellidos(this.jTextField2.getText());
        agricultor.setRazonSocial(this.jTextField3.getText());
        try {
            service.getController().edit(agricultor);
            this.jButton1.setEnabled(true);
            this.jButton2.setEnabled(true);
            this.jButton3.setEnabled(false);
            this.jButton4.setEnabled(false);
            this.jFormattedTextField1.setEnabled(true);
            JOptionPane.showMessageDialog(this,"Agricultor Modificado con Exito");
            this.AsignarAgricultor(null);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GestorDeAgricultores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Ese Agricultor Actualmente No Existe");
        } catch (Exception ex) {
            Logger.getLogger(GestorDeAgricultores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Hubo Una Excepcion");
        }
    }
    public void Eliminar(){
        try {
            service.getController().destroy(agricultor.getIdAgricultor());
            JOptionPane.showMessageDialog(this,"AGRICULTOR ELIMINADO CON EXITO");
            this.jButton1.setEnabled(true);
            this.jButton2.setEnabled(true);
            this.jButton3.setEnabled(false);
            this.jButton4.setEnabled(false);
            this.jFormattedTextField1.setEnabled(true);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GestorDeAgricultores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"ESTE AGRICULTOR NO EXISTE EN NUESTRA BASE DE DATOS");
        }catch (Exception ex) {
            Logger.getLogger(GestorDeAgricultores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Hubo Una Excepcion");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTION DE AGRICULTORES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NIT/CEDULA :");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextField1FocusGained(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("NATURALEZA :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PERSONA NATURAL", "PERSONA JURIDICA" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("NOMBRES :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("APELLIDOS :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("RAZON SOCIAL :");

        jTextField3.setEditable(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("MODIFICAR");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("ELIMINAR");
        jButton4.setEnabled(false);
        jPanel1.add(jButton4);

        jMenu1.setText("Opciones");

        jMenuItem1.setText("Limpiar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.Ingresar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if(this.jComboBox1.getSelectedIndex()==0){
            this.jTextField1.setEditable(true);
            this.jTextField2.setEditable(true);
            this.jTextField3.setEditable(false);
            this.jTextField3.setText("");
        }else{
            this.jTextField1.setEditable(false);
            this.jTextField2.setEditable(false);
            this.jTextField3.setEditable(true);
            this.jTextField2.setText("");
            this.jTextField3.setText("");
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jFormattedTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField1FocusGained
        // TODO add your handling code here:
        this.jFormattedTextField1.setText("");
    }//GEN-LAST:event_jFormattedTextField1FocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.Buscar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.Modificar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.jButton1.setEnabled(true);
        this.jButton3.setEnabled(false);
        this.jButton4.setEnabled(false);
        this.AsignarAgricultor(null);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestorDeAgricultores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void EventoDeBusquedaDeAgricultor() {
        ba.dispose();
        this.show();
        this.AsignarAgricultor(ba.getSeleccionado());        
        this.jButton1.setEnabled(false);
        this.jButton2.setEnabled(true);
        this.jButton3.setEnabled(true);
        this.jButton4.setEnabled(true);
        this.jFormattedTextField1.setEnabled(false);
    }

    @Override
    public void AsignarAgricultor(Agricultor a) {
        this.agricultor=a;
        if(a!=null){
            this.jFormattedTextField1.setValue(a.getIdAgricultor());
            this.jComboBox1.setSelectedItem(a.getNaturaleza());
            this.jTextField1.setText(""+a.getNombres());
            this.jTextField2.setText(""+a.getApellidos());
            this.jTextField3.setText(""+a.getRazonSocial());
            this.jComboBox1.requestFocus();
        }else{
            this.jFormattedTextField1.setValue(new Long(0));
            this.jComboBox1.setSelectedIndex(0);
            this.jTextField1.setText("");
            this.jTextField2.setText("");
            this.jTextField3.setText("");
        }
    }
}
