/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.habitat.PresentationLayer;

import com.alee.laf.WebLookAndFeel;

/**
 *
 * @author Pedro
 */
public class Login extends javax.swing.JFrame{

    /**
     * Creates new form Login
     */
    public Login() {
       this.setTitle("Habitat");
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

        username_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        username_tf = new javax.swing.JTextField();
        password_pf = new javax.swing.JPasswordField();
        login_bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        username_label.setText("Username :");

        password_label.setText("Password :");

        username_tf.setEnabled(true);
        username_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                username_tfKeyPressed(evt);
            }
        });

        password_pf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                password_pfKeyPressed(evt);
            }
        });

        login_bt.setText("Login");
        login_bt.setEnabled(false);
        login_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(login_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username_label)
                            .addComponent(password_label))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(password_pf, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(username_tf))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_label)
                    .addComponent(username_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_label)
                    .addComponent(password_pf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(login_bt)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void password_pfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password_pfKeyPressed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_password_pfKeyPressed

    private void username_tfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_username_tfKeyPressed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_username_tfKeyPressed

    private void login_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btActionPerformed
        // TODO add your handling code here:
        //tentar o login!
        String username =  this.username_tf.getText();
        String password = this.password_pf.getPassword().toString();
        //se conseguido  abrir nova janela  Main view e dispose esta     
        MainView hv = new MainView(username);
        hv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_login_btActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and boolean install = WebLookAndFeel.install();    feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                boolean install = WebLookAndFeel.install();   
                new Login().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton login_bt;
    private javax.swing.JLabel password_label;
    private javax.swing.JPasswordField password_pf;
    private javax.swing.JLabel username_label;
    private javax.swing.JTextField username_tf;
    // End of variables declaration//GEN-END:variables
   
    private void update()
    {
        if((this.username_tf.getText()!= null || this.username_tf.getText().equals("")) && this.password_pf.getPassword().length > 0)
            this.login_bt.setEnabled(true);
        else
            this.login_bt.setEnabled(false);
    }
}
