/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Candidaturas;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.PresentationLayer.Candidaturas.Elementos.ActCandPanel;
import com.habitat.PresentationLayer.Candidaturas.Elementos.AddCandtoPanel;
import com.habitat.PresentationLayer.Candidaturas.Elementos.ElemPanel;
import com.habitat.PresentationLayer.Candidaturas.Perguntas.ActQuestPanel;
import com.habitat.PresentationLayer.Candidaturas.Perguntas.QuestPanel;

/**
 *
 * @author filiperibeiro
 */
public class AtualizarCondidatura extends javax.swing.JPanel {

    /**
     * Creates new form AtualizarCondidatura
     */
    private BusinessFacade bus;
    public AtualizarCondidatura(java.awt.Frame parent, boolean modal,BusinessFacade bus) {
        initComponents();
        //super(parent, modal);
        initComponents();
         cand_cont.add(new ActCandPanel(bus));
         triv_cont.add(new ActuaTrivia(bus));
         containerQuest2.add(new ActQuestPanel(bus));
         //containerElem2.add(new ElemPanel());
    }
    
    public AtualizarCondidatura(java.awt.Frame parent, boolean modal)
{
        //super(parent, modal);
        initComponents();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        cand_cont = new javax.swing.JPanel();
        containerQuest2 = new javax.swing.JPanel();
        containerElem2 = new javax.swing.JPanel();
        triv_cont = new javax.swing.JPanel();
        canc_bt2 = new javax.swing.JButton();
        act_bt2 = new javax.swing.JButton();

        cand_cont.setLayout(new java.awt.CardLayout());

        containerQuest2.setLayout(new java.awt.CardLayout());

        containerElem2.setLayout(new java.awt.CardLayout());

        triv_cont.setLayout(new java.awt.CardLayout());

        canc_bt2.setText("Cancelar");

        act_bt2.setText("Atualizar");
        act_bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                act_bt2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(act_bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(canc_bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(containerElem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(containerQuest2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(triv_cont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cand_cont, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))))
                .addGap(67, 67, 67))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cand_cont, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(triv_cont, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(containerQuest2, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(containerElem2, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(act_bt2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(canc_bt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void act_bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_act_bt2ActionPerformed
        /* TODO add your handling code here:
        Elemento cand = ((AddCandtoPanel)this.containerCand.getComponent(0)).getCandidato();
        if(cand == null){
            new ErrorWindow("Adicionar Quandidatura", "Exitem Campos para o Candidato não preenchidos", "warning", new JFrame()).wshow();
            return;
        }
        ArrayList<Questao> questionario = ((QuestPanel)this.containerQuest.getComponent(0)).getQuestionario();
        if(questionario == null){
            new ErrorWindow("Adicionar Quandidatura", "Questionario não respondido", "warning", new JFrame()).wshow();
            return;
        }
        System.out.println("questionario ok");*/
    }//GEN-LAST:event_act_bt2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton act_bt2;
    private javax.swing.JButton canc_bt2;
    private javax.swing.JPanel cand_cont;
    private javax.swing.JPanel containerElem2;
    private javax.swing.JPanel containerQuest2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel triv_cont;
    // End of variables declaration//GEN-END:variables
}
