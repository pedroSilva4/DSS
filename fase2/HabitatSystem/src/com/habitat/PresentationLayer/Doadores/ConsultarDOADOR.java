/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Doadores;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.BusinessLayer.Doadores.Doador;
import com.habitat.BusinessLayer.Doadores.Empresa;
import com.habitat.BusinessLayer.Voluntarios.Voluntario;
import com.habitat.PresentationLayer.Doacoes.*;
import com.habitat.PresentationLayer.Voluntários.ConsultarVol;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author filiperibeiro
 */
public class ConsultarDOADOR extends javax.swing.JPanel implements Observer{

    /**
     * Creates new form ConsultarDAO
     */
    
    private final BusinessFacade businessFacade;
    private ArrayList<Doador> doadores;
    
    public ConsultarDOADOR(BusinessFacade bus) {
        this.businessFacade = bus;
        try{
            this.doadores = businessFacade.getListaDoadores();
            businessFacade.addObserver(this);
            initComponents();
            updateComboBox();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarDOADOR.class.getName()).log(Level.SEVERE, null, ex);
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
        consultar_bt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        filtrar_tf = new javax.swing.JTextField();
        doador_cb = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar"));

        jLabel1.setText("Doador:");

        consultar_bt.setText("Consultar");
        consultar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar_btActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtrar:");

        filtrar_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtrar_tfKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filtrar_tfKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtrar_tfKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(consultar_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(filtrar_tf)
                            .addComponent(doador_cb, 0, 165, Short.MAX_VALUE))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(filtrar_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(doador_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consultar_bt)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consultar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar_btActionPerformed
        // TODO add your handling code here:
        Doador d = (Doador)this.doador_cb.getSelectedItem();
        String type = this.businessFacade.getActiveUser().getTipo(); 
        
        if(type.equals("admin") || type.equals("angariação")){
            if(d.getClass() == Empresa.class){
                Empresa emp = (Empresa) d;
                    new ConsultarDOADOR_emp(new JFrame(), true, emp).setVisible(true);
                    //mudar aqui
            }
            else{
                    new AtualizarDOADOR_indiv(new JFrame(), true, businessFacade ,d).setVisible(true);
            }
        }
        else{
                if(d.getClass() == Empresa.class){
                    Empresa emp = (Empresa) d;
                        new ConsultarDOADOR_emp(new JFrame(), true, emp).setVisible(true);
                }
            else{
                        new ConsultarDOADOR_indv(new JFrame(), true ,d).setVisible(true);
            }        
        }   
    }//GEN-LAST:event_consultar_btActionPerformed

    private void filtrar_tfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrar_tfKeyPressed
        // TODO add your handling code here:
        updateComboBox();
    }//GEN-LAST:event_filtrar_tfKeyPressed

    private void filtrar_tfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrar_tfKeyReleased
        // TODO add your handling code here:
        updateComboBox();
    }//GEN-LAST:event_filtrar_tfKeyReleased

    private void filtrar_tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrar_tfKeyTyped
        // TODO add your handling code here:
        updateComboBox();
    }//GEN-LAST:event_filtrar_tfKeyTyped

    public void updateComboBox(){
       this.doador_cb.removeAllItems(); 
       for(Doador v : doadores)
       {
           if(v.getNome().startsWith(this.filtrar_tf.getText())) 
                this.doador_cb.addItem(v);
       }
   }
    
    public void update(Observable o, Object arg) {
        try {
            this.doadores = businessFacade.getListaDoadores();
            updateComboBox();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarVol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultar_bt;
    private javax.swing.JComboBox doador_cb;
    private javax.swing.JTextField filtrar_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
