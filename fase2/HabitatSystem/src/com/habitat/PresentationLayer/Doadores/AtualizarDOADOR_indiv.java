/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Doadores;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.BusinessLayer.Doadores.Doador;
import com.habitat.BusinessLayer.Voluntarios.Morada;
import com.habitat.BusinessLayer.Voluntarios.Voluntario;
import com.habitat.util.ErrorWindow;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author filiperibeiro
 */
public class AtualizarDOADOR_indiv extends javax.swing.JDialog {

    /**
     * Creates new form AtualizarDOADOR_indiv
     */
    
    private final Doador d;
    private final BusinessFacade businessFacade;
    public AtualizarDOADOR_indiv(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        d = null;
        businessFacade = null;
        initComponents();
    }

    public AtualizarDOADOR_indiv(java.awt.Frame parent, boolean modal,BusinessFacade bus,Doador ut) {
        super(parent, modal);
        this.d = ut;
        this.businessFacade = bus;
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

        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        nome_tf2 = new javax.swing.JTextField();
        update_btt2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        rua_tf = new javax.swing.JTextField();
        localidade_tf = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        contacto_tf = new javax.swing.JTextField();
        codPstal_tf = new javax.swing.JTextField();
        back2 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        nif_tf = new javax.swing.JTextField();
        email_tf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        data_tf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atualizar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel3jPanel1formMouseMoved(evt);
            }
        });
        jPanel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel3jPanel1formKeyPressed(evt);
            }
        });

        jLabel23.setText("Nome :");

        nome_tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_tf2nome_tfActionPerformed(evt);
            }
        });

        update_btt2.setText("Submeter");
        update_btt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btt2update_bttActionPerformed(evt);
            }
        });

        jLabel24.setText("Rua :");

        jLabel25.setText("Localidade :");

        rua_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rua_tfstreet_tfActionPerformed(evt);
            }
        });

        jLabel26.setText("Contacto:");

        jLabel27.setText("Email:");

        jLabel28.setText("CodPostal:");

        back2.setText("Voltar");
        back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back2backActionPerformed(evt);
            }
        });

        jLabel29.setText("NIF:");

        jLabel1.setText("Data de Associação:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(data_tf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(contacto_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nif_tf))
                            .addComponent(email_tf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rua_tf)
                            .addComponent(nome_tf2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(localidade_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(update_btt2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(back2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codPstal_tf)))))
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(nome_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(contacto_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(nif_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(data_tf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(email_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(rua_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(localidade_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(codPstal_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_btt2)
                    .addComponent(back2))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nome_tf2nome_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_tf2nome_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_tf2nome_tfActionPerformed

    private void update_btt2update_bttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btt2update_bttActionPerformed
        // TODO add your handling code here:
        String name = this.nome_tf2.getText();
        String nif = this.nif_tf.getText();
        String contac = this.contacto_tf.getText();
        String rua = this.rua_tf.getText();
        String local = this.localidade_tf.getText();
        String cod_postal = this.codPstal_tf.getText();
        String email =  this.email_tf.getText(); 
        
        this.d.setNome(name);
        this.d.setContacto(contac);
        this.d.setNIF(nif);
        this.d.setCodPostal(cod_postal);
        this.d.setLocalidade(local);
        this.d.setRua(rua);
        this.d.setEmail(email);
        
        try {
             businessFacade.updateDoador(d);
        } catch (SQLException ex) {
            ex.printStackTrace();
            new ErrorWindow("Doador", ex.getMessage(), "error", new JFrame()).wshow();
        }
    }//GEN-LAST:event_update_btt2update_bttActionPerformed

    private void rua_tfstreet_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rua_tfstreet_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rua_tfstreet_tfActionPerformed

    private void back2backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back2backActionPerformed
        // TODO add your handling code here:
        ((JFrame)this.getParent()).dispose();
    }//GEN-LAST:event_back2backActionPerformed

    private void jPanel3jPanel1formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3jPanel1formMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3jPanel1formMouseMoved

    private void jPanel3jPanel1formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3jPanel1formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3jPanel1formKeyPressed

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
            java.util.logging.Logger.getLogger(AtualizarDOADOR_indiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarDOADOR_indiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarDOADOR_indiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarDOADOR_indiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AtualizarDOADOR_indiv dialog = new AtualizarDOADOR_indiv(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back2;
    private javax.swing.JTextField codPstal_tf;
    private javax.swing.JTextField contacto_tf;
    private javax.swing.JLabel data_tf;
    private javax.swing.JTextField email_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField localidade_tf;
    private javax.swing.JTextField nif_tf;
    private javax.swing.JTextField nome_tf2;
    private javax.swing.JTextField rua_tf;
    private javax.swing.JButton update_btt2;
    // End of variables declaration//GEN-END:variables

public void init(){
            this.nome_tf2.setText(this.d.getNome());
            this.nif_tf.setText(this.d.getNIF());
            this.contacto_tf.setText((this.d.getContacto()));
            this.email_tf.setText(this.d.getEmail());
            this.rua_tf.setText(this.d.getRua());
            this.localidade_tf.setText(this.d.getLocalidade());
            this.codPstal_tf.setText(this.d.getCodPostal());
            this.data_tf.setText(this.d.getDataAssoc().toString());
    }



}
