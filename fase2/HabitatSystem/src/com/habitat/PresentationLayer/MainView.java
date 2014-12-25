/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.habitat.PresentationLayer;

import com.alee.laf.WebLookAndFeel;
import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.PresentationLayer.Candidaturas.CandidaturaJP;
import com.habitat.PresentationLayer.Funcionarios.FuncionariosJP;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Pedro
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form HomeView
     * @param username
     */
    
    BusinessFacade businessFacade;
    public MainView(BusinessFacade bus) {
        this.businessFacade = bus;
        this.setTitle("Habitat");
        initComponents();
        this.initByType();
    }
    
    public MainView() {
        
        this.setTitle("Habitat");
        initComponents();
        this.initByType();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_tabs = new javax.swing.JTabbedPane();
        Home_jp = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        type_label = new javax.swing.JLabel();
        funcionarios_jp = new javax.swing.JPanel();
        candidaturas_jpanel = new javax.swing.JPanel();
        eventos_jp = new javax.swing.JPanel();
        doacoes_jp = new javax.swing.JPanel();
        voluntarios_jp = new javax.swing.JPanel();
        inventario_jp = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        logout_bt = new javax.swing.JMenuItem();
        exit_bt = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        main_tabs.setToolTipText("");
        main_tabs.setAlignmentX(0.0F);
        main_tabs.setAlignmentY(0.0F);
        main_tabs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        main_tabs.setFocusable(false);
        main_tabs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        main_tabs.setMaximumSize(new java.awt.Dimension(327670000, 327670000));
        main_tabs.setMinimumSize(new java.awt.Dimension(109, 148));

        jLabel1.setText("Funcionário : ");

        name_label.setText("nome asdasd");

        jLabel2.setText("Tipo :");

        type_label.setText("jLabel3");

        javax.swing.GroupLayout Home_jpLayout = new javax.swing.GroupLayout(Home_jp);
        Home_jp.setLayout(Home_jpLayout);
        Home_jpLayout.setHorizontalGroup(
            Home_jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Home_jpLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addGroup(Home_jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(Home_jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(type_label)
                    .addComponent(name_label))
                .addContainerGap(612, Short.MAX_VALUE))
        );
        Home_jpLayout.setVerticalGroup(
            Home_jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Home_jpLayout.createSequentialGroup()
                .addContainerGap(356, Short.MAX_VALUE)
                .addGroup(Home_jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Home_jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(type_label))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        main_tabs.addTab("Home", Home_jp);

        funcionarios_jp.setMaximumSize(new java.awt.Dimension(32767000, 32767000));
        funcionarios_jp.setLayout(new java.awt.CardLayout());
        main_tabs.addTab("Funcionários", funcionarios_jp);

        candidaturas_jpanel.setLayout(new java.awt.CardLayout());
        main_tabs.addTab("Candidaturas", candidaturas_jpanel);

        eventos_jp.setLayout(new java.awt.CardLayout());
        main_tabs.addTab("Eventos", eventos_jp);

        doacoes_jp.setLayout(new java.awt.CardLayout());
        main_tabs.addTab("Doações", doacoes_jp);

        voluntarios_jp.setLayout(new java.awt.CardLayout());
        main_tabs.addTab("Voluntários", voluntarios_jp);

        inventario_jp.setLayout(new java.awt.CardLayout());
        main_tabs.addTab("Inventário", inventario_jp);

        jMenu1.setText("Menu");

        logout_bt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        logout_bt.setText("Logout");
        logout_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btActionPerformed(evt);
            }
        });
        jMenu1.add(logout_bt);

        exit_bt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        exit_bt.setText("Sair");
        exit_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btActionPerformed(evt);
            }
        });
        jMenu1.add(exit_bt);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_tabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_tabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logout_btActionPerformed

    private void exit_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exit_btActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                boolean install = WebLookAndFeel.install();   
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Home_jp;
    private javax.swing.JPanel candidaturas_jpanel;
    private javax.swing.JPanel doacoes_jp;
    private javax.swing.JPanel eventos_jp;
    private javax.swing.JMenuItem exit_bt;
    private javax.swing.JPanel funcionarios_jp;
    private javax.swing.JPanel inventario_jp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem logout_bt;
    private javax.swing.JTabbedPane main_tabs;
    private javax.swing.JLabel name_label;
    private javax.swing.JLabel type_label;
    private javax.swing.JPanel voluntarios_jp;
    // End of variables declaration//GEN-END:variables


    public final void initByType()
    {
        //incializa coisas nice consante o tipo
       this.name_label.setText(this.businessFacade.getActiveUser().getNome());
       this.type_label.setText(this.businessFacade.getActiveUser().getTipo());
       this.funcionarios_jp.add(new FuncionariosJP(businessFacade));
       this.candidaturas_jpanel.add(new CandidaturaJP(businessFacade));
       // this.groupBox_func.setVisible(false);
    }

}
