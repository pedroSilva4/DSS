/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Eventos;

import com.habitat.PresentationLayer.Doacoes.*;

/**
 *
 * @author filiperibeiro
 */
public class AdicionarEVEN extends javax.swing.JPanel {

    /**
     * Creates new form AdicionarDOA
     */
    public AdicionarEVEN() {
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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        nome_tf = new javax.swing.JTextField();
        telefone_TF = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar"));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Funcionário:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 82, -1, -1));

        jLabel5.setText("Valor Angariado:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 82, -1, -1));
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 76, 117, -1));

        jLabel7.setText("Nº Participantes:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 36, -1, -1));
        add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 30, 114, -1));

        nome_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_tfActionPerformed(evt);
            }
        });
        add(nome_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 168, 357, -1));
        add(telefone_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 30, 119, -1));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 76, 119, -1));

        jButton1.setText("Submeter");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 214, -1, -1));

        jLabel2.setText("Observações:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 174, -1, -1));

        jLabel3.setText("Data:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 36, -1, -1));

        jLabel6.setText("Cód.Projeto:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 128, -1, -1));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 122, 119, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void nome_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_tfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField nome_tf;
    private javax.swing.JTextField telefone_TF;
    // End of variables declaration//GEN-END:variables
}
