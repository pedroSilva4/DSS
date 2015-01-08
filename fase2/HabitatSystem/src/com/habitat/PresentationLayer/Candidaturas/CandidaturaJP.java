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

        add_bt = new javax.swing.JButton();
        consCand_bt = new javax.swing.JButton();
        consProj = new javax.swing.JButton();
        container = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        addQuest_bt = new javax.swing.JButton();
        conQuest_bt = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(807, 400));

        add_bt.setText("Adicionar Candidatura");
        add_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btActionPerformed(evt);
            }
        });

        consCand_bt.setText("Consultar Candidatura");
        consCand_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consCand_btActionPerformed(evt);
            }
        });

        consProj.setText("Consultar Projeto");
        consProj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consProjActionPerformed(evt);
            }
        });

        container.setLayout(new java.awt.CardLayout());

        jButton1.setText("Criar Projeto");

        addQuest_bt.setText("Criar Questão");
        addQuest_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQuest_btActionPerformed(evt);
            }
        });

        conQuest_bt.setText("Consultar Questão");
        conQuest_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conQuest_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(consProj, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(conQuest_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(consCand_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addQuest_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                .addGap(52, 52, 52)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addQuest_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(consCand_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(consProj, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(conQuest_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(53, 53, 53))
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
        new AdicionarCandidatura(new JFrame(), true).setVisible(true);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addQuest_bt;
    private javax.swing.JButton add_bt;
    private javax.swing.JButton conQuest_bt;
    private javax.swing.JButton consCand_bt;
    private javax.swing.JButton consProj;
    private javax.swing.JPanel container;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
    public void myInit(/**tipo**/)
    {
        if(this.businessFacade.getActiveUser().getTipo().equals("famílias") || 
                this.businessFacade.getActiveUser().getTipo().equals("admin") ){
            this.consCand_bt.setText("Atual./Consultar\n Candidatura");
            this.consProj.setText("Atual./Consultar\n Projecto");
            this.conQuest_bt.setText("Atual./Consultar\n Questão");
        }
        else{
            this.add_bt.setEnabled(false);
        }
        
        this.container.add(new ConsultarCand(),"consCand");
        this.container.add(new ConsultarProj(),"consProj");
        this.container.add(new AddQuestaoPanel(businessFacade),"addQuest");
        this.container.add(new ConsultarQuest(this.businessFacade),"conQuest");
        this.container.setVisible(false);
    }

}
