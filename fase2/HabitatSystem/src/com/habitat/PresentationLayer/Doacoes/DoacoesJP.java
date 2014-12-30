/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Doacoes;

import com.habitat.BusinessLayer.BusinessFacade;
import java.awt.CardLayout;

/**
 *
 * @author filiperibeiro
 */
public class DoacoesJP extends javax.swing.JPanel {

    /**
     * Creates new form DoacoesJP
     */
    BusinessFacade businessFacade;
    public DoacoesJP(BusinessFacade bus) {
        businessFacade = bus;
        initComponents();
        myInit();
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
        cons_ = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        add_.setText("Adicionar");
        add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ActionPerformed(evt);
            }
        });

        cons_.setText("Consultar");
        cons_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cons_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cons_, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(add_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cons_, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.jPanel1.getLayout();
        cl.show(jPanel1, "add");
        jPanel1.setVisible(true);

    }//GEN-LAST:event_add_ActionPerformed

    private void cons_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cons_ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.jPanel1.getLayout();
        cl.show(jPanel1, "cons");
        jPanel1.setVisible(true);
    }//GEN-LAST:event_cons_ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_;
    private javax.swing.JButton cons_;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

public void myInit(){

String type = this.businessFacade.getActiveUser().getTipo();
        
    if(type.equals("admin") || type.equals("angariação")){

                this.jPanel1.add(new AdicionarDOA(businessFacade),"add");
        }
        else{
            this.add_.setEnabled(false);
        }
        
    this.jPanel1.add(new ConsultarDOA(businessFacade),"cons");
    this.jPanel1.setVisible(false);
    }
    
}

