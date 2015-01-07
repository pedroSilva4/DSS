/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.habitat.PresentationLayer.Funcionarios;

import com.habitat.BusinessLayer.BusinessFacade;
import java.awt.CardLayout;

/**
 *
 * @author Pedro
 */
public class FuncionariosJP extends javax.swing.JPanel {

    /**
     * Creates new form FuncionariosJP
     */
    BusinessFacade businessFacade;
    public FuncionariosJP(BusinessFacade bus) {
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
        rm_bt = new javax.swing.JButton();
        con_bt = new javax.swing.JButton();
        container = new javax.swing.JPanel();

        add_bt.setText("Adicionar");
        add_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btActionPerformed(evt);
            }
        });

        rm_bt.setText("Remover");
        rm_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rm_btActionPerformed(evt);
            }
        });

        con_bt.setText("Consultar");
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
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(con_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(rm_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(add_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rm_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(con_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rm_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rm_btActionPerformed
        // TODO add your handling code here:
         CardLayout cl = (CardLayout)this.container.getLayout();
         cl.show(container, "rm");
         container.setVisible(true);
    }//GEN-LAST:event_rm_btActionPerformed

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
    private javax.swing.JButton rm_bt;
    // End of variables declaration//GEN-END:variables

    public void myInit()
    {
        String type = this.businessFacade.getActiveUser().getTipo();
        if(type.equals("admin")){
            
                this.container.add(new AdicionarFunc(businessFacade),"add");
                this.container.add(new removerFunc(businessFacade),"rm");
                this.con_bt.setText("Consultar/Atualizar");
        }
        else{
            
            this.add_bt.setEnabled(false);
            this.rm_bt.setEnabled(false);
           
        }
        
        this.container.add(new ConsultarFunc(businessFacade),"cons");
        this.container.setVisible(false);
    }
}

