/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Doadores;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.PresentationLayer.Doacoes.AdicionarDOA;
import com.habitat.PresentationLayer.Doacoes.ConsultarDOA;
import java.awt.CardLayout;

/**
 *
 * @author filiperibeiro
 */
public class DoadoresJP extends javax.swing.JPanel {

    /**
     * Creates new form DoadoresJP
     */
    private final BusinessFacade businessFacade;
    public DoadoresJP(BusinessFacade bus) {
        this.businessFacade = bus;
        System.out.println("initializing....");
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add_ = new javax.swing.JButton();
        rem_ = new javax.swing.JButton();
        container = new javax.swing.JPanel();
        cons_ = new javax.swing.JButton();

        add_.setText("Adicionar");
        add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ActionPerformed(evt);
            }
        });

        rem_.setText("Remover");
        rem_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rem_ActionPerformed(evt);
            }
        });

        container.setLayout(new java.awt.CardLayout());

        cons_.setText("Consultar");
        cons_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cons_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(add_, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rem_, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cons_, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(add_, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rem_, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cons_, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.container.getLayout();
        cl.show(container, "add");
        container.setVisible(true);
    }//GEN-LAST:event_add_ActionPerformed

    private void rem_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rem_ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rem_ActionPerformed

    private void cons_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cons_ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.container.getLayout();
        cl.show(container, "cons");
        container.setVisible(true);
    }//GEN-LAST:event_cons_ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_;
    private javax.swing.JButton cons_;
    private javax.swing.JPanel container;
    private javax.swing.JButton rem_;
    // End of variables declaration//GEN-END:variables
    private void init(){
        String type = this.businessFacade.getActiveUser().getTipo();
        
        if(type.equals("admin") || type.equals("angariação")){

                this.container.add(new AdicionarDOADOR(businessFacade),"add");
                this.cons_.setText("Consultar/Atualizar");
        }
        else{
            this.add_.setEnabled(false);
        }
        
        this.container.add(new ConsultarDOADOR(),"cons");
        //--this.container.add(new )
        this.container.setVisible(false);
    }
}
