/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.habitat.PresentationLayer.Candidaturas;

import com.habitat.PresentationLayer.Candidaturas.Perguntas.AddQuestaoPanel;
import com.habitat.PresentationLayer.Candidaturas.Projectos.ConsultarProj;
import com.habitat.PresentationLayer.Candidaturas.Perguntas.ConsultarQuest;
import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.PresentationLayer.Candidaturas.Projectos.AddProjectoJP;
import java.awt.CardLayout;
import javax.swing.JFrame;

/**
 *
 * @author Pedro
 */
public class CandidaturaJP extends javax.swing.JPanel {

    /**
     * Creates new form CandidaturaJP
     */
    private final BusinessFacade businessFacade;
    public CandidaturaJP(BusinessFacade bus) {
        this.businessFacade = bus;
        initComponents();
        myInit(/**tipo**/);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        add_bt = new javax.swing.JButton();
        consCand_bt = new javax.swing.JButton();
        addProjBT = new javax.swing.JButton();
        addQuest_bt = new javax.swing.JButton();
        consProj = new javax.swing.JButton();
        conQuest_bt = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(807, 400));

        container.setLayout(new java.awt.CardLayout());

        add_bt.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        add_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/add-icon.png"))); // NOI18N
        add_bt.setText("Adicionar Candidatura");
        add_bt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btActionPerformed(evt);
            }
        });

        consCand_bt.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        consCand_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/Search-icon.png"))); // NOI18N
        consCand_bt.setText("Consultar Candidatura");
        consCand_bt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        consCand_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consCand_btActionPerformed(evt);
            }
        });

        addProjBT.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        addProjBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/add-icon.png"))); // NOI18N
        addProjBT.setText("Criar Projeto");
        addProjBT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addProjBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProjBTActionPerformed(evt);
            }
        });

        addQuest_bt.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        addQuest_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/add-icon.png"))); // NOI18N
        addQuest_bt.setText("Criar Questão");
        addQuest_bt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addQuest_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQuest_btActionPerformed(evt);
            }
        });

        consProj.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        consProj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/Search-icon.png"))); // NOI18N
        consProj.setText("Consultar Projeto");
        consProj.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        consProj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consProjActionPerformed(evt);
            }
        });

        conQuest_bt.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        conQuest_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/habitat/PresentationLayer/ICONs/Search-icon.png"))); // NOI18N
        conQuest_bt.setText("Consultar Questão");
        conQuest_bt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        conQuest_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conQuest_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(add_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 2, Short.MAX_VALUE)
                        .addComponent(addProjBT, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                    .addComponent(addQuest_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(consProj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conQuest_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(consCand_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consCand_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProjBT, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consProj, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addQuest_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conQuest_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(91, 91, 91))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consCand_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consCand_btActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.container.getLayout();
        cl.show(container, "consCand");
        container.setVisible(true);
    }//GEN-LAST:event_consCand_btActionPerformed

    private void consProjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consProjActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.container.getLayout();
        cl.show(container, "consProj");
        container.setVisible(true);
    }//GEN-LAST:event_consProjActionPerformed

    private void add_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btActionPerformed
        // TODO add your handling code here:
        new AdicionarCandidatura(new JFrame(), true,businessFacade).setVisible(true);
    }//GEN-LAST:event_add_btActionPerformed

    private void addQuest_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQuest_btActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.container.getLayout();
        cl.show(container, "addQuest");
        container.setVisible(true);
        
    }//GEN-LAST:event_addQuest_btActionPerformed

    private void conQuest_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conQuest_btActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.container.getLayout();
        cl.show(container, "conQuest");
        container.setVisible(true);
    }//GEN-LAST:event_conQuest_btActionPerformed

    private void addProjBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProjBTActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.container.getLayout();
        cl.show(container, "addProj");
        container.setVisible(true);
    }//GEN-LAST:event_addProjBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProjBT;
    private javax.swing.JButton addQuest_bt;
    private javax.swing.JButton add_bt;
    private javax.swing.JButton conQuest_bt;
    private javax.swing.JButton consCand_bt;
    private javax.swing.JButton consProj;
    private javax.swing.JPanel container;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    public void myInit(/**tipo**/)
    {
        if(this.businessFacade.getActiveUser().getTipo().equals("famílias") || 
                this.businessFacade.getActiveUser().getTipo().equals("admin") ){
                this.consCand_bt.setText("Atual./Consultar Candidatura");
                this.consProj.setText("Atual./Consultar Projecto");
                this.conQuest_bt.setText("Atual./Consultar Questão");
        }
        else{
            this.add_bt.setEnabled(false);
            this.addQuest_bt.setEnabled(false);
        }
        if(this.businessFacade.getActiveUser().getTipo().equals("obras") || 
                this.businessFacade.getActiveUser().getTipo().equals("admin") ){
    
            this.consProj.setText("Atual./Consultar\n Projecto");
        
        }else{
            //
        }
        
        this.container.add(new ConsultarCand(businessFacade),"consCand");
        this.container.add(new ConsultarProj(this.businessFacade),"consProj");
        this.container.add(new AddQuestaoPanel(businessFacade),"addQuest");
        this.container.add(new ConsultarQuest(this.businessFacade),"conQuest");
        this.container.add(new AddProjectoJP(this.businessFacade),"addProj");
        this.container.setVisible(false);
    }

}
