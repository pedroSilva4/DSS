/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.habitat.PresentationLayer.Voluntários;

import com.habitat.BusinessLayer.BusinessFacade;
import java.awt.CardLayout;

/**
 *
 * @author Pedro
 */
public class VoluntarioJP extends javax.swing.JPanel {

    /**
     * Creates new form VoluntarioJP
     */
    BusinessFacade businessFacade;
    public VoluntarioJP(BusinessFacade bus) {
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

        add_bt = new javax.swing.JButton();
        con_bt = new javax.swing.JButton();
        container = new javax.swing.JPanel();

        add_bt.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        add_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/add-icon.png"))); // NOI18N
        add_bt.setText("  Adicionar");
        add_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btActionPerformed(evt);
            }
        });

        con_bt.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        con_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/Search-icon.png"))); // NOI18N
        con_bt.setText("  Consultar");
        con_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                con_btActionPerformed(evt);
            }
        });

        container.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(con_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(add_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(con_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.container.getLayout();
        cl.show(container, "add");
        container.setVisible(true);
    }//GEN-LAST:event_add_btActionPerformed

    private void con_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_con_btActionPerformed
        // TODO add your handling code here
         CardLayout cl = (CardLayout)this.container.getLayout();
         cl.show(container, "cons");
         container.setVisible(true);
    }//GEN-LAST:event_con_btActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_bt;
    private javax.swing.JButton con_bt;
    private javax.swing.JPanel container;
    // End of variables declaration//GEN-END:variables

    public void myInit()
    {
        String type = this.businessFacade.getActiveUser().getTipo();
        if(type.equals("admin") || type.equals("angariação")){
            
                this.container.add(new AdicionarVol(businessFacade),"add");
                this.con_bt.setText("Consultar/Atualizar");
        }
        else{
            
            this.add_bt.setEnabled(false);
           
        }
        
        this.container.add(new ConsultarVol(businessFacade),"cons");
        this.container.setVisible(false);
    }
}

