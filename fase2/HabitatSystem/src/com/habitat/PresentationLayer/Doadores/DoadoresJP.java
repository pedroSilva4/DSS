/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Doadores;

import com.habitat.BusinessLayer.BusinessFacade;
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
        container = new javax.swing.JPanel();
        cons_ = new javax.swing.JButton();

        add_.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        add_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/add-icon.png"))); // NOI18N
        add_.setText("  Adicionar");
        add_.setToolTipText("");
        add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ActionPerformed(evt);
            }
        });

        container.setLayout(new java.awt.CardLayout());

        cons_.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cons_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/Search-icon.png"))); // NOI18N
        cons_.setText("  Consultar");
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
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(add_, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cons_, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cons_, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.container.getLayout();
        cl.show(container, "add");
        container.setVisible(true);
    }//GEN-LAST:event_add_ActionPerformed

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
        this.container.add(new ConsultarDOADOR(businessFacade),"cons");
        //--this.container.add(new )
        this.container.setVisible(false);
    }
}
