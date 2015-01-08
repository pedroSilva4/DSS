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

        add_.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        add_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/add-icon.png"))); // NOI18N
        add_.setText("  Adicionar");
        add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ActionPerformed(evt);
            }
        });

        cons_.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cons_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/Search-icon.png"))); // NOI18N
        cons_.setText("  Consultar");
        cons_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cons_ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cons_, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(add_, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cons_, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(100, 100, 100))
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
                //this.cons_.setText("Consultar/Atualizar");
        }
        else{
            this.add_.setEnabled(false);
        }
        
        this.jPanel1.add(new ConsultarDOA(businessFacade),"cons");
        this.jPanel1.setVisible(false);
}
    
}

