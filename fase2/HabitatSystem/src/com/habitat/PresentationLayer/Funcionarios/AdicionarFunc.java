package com.habitat.PresentationLayer.Funcionarios;

import com.habitat.BusinessLayer.BusinessFacade;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Pedro
 */
public class AdicionarFunc extends javax.swing.JPanel {

    /**
     * Creates new form AdicionarFunc
     */
    private BusinessFacade businessFacade;
    public AdicionarFunc(BusinessFacade bus) {
        businessFacade =bus;
        initComponents();
        setVisible(true);
        this.sub_btt.setEnabled(false);
    }
    
    public void update()
    {
        boolean b = true;
        for(Component c : this.getComponents()){
           if(c.getClass()==JTextField.class)
               if(((JTextField)c).getText()==null || ((JTextField)c).getText().equals("")) {
                   b= false;
                   break;
               }
        }
        this.sub_btt.setEnabled(b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tipos_cb = new javax.swing.JComboBox();
        nome_tf = new javax.swing.JTextField();
        username_tf = new javax.swing.JTextField();
        password_pf = new javax.swing.JPasswordField();
        sub_btt = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nif_tf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        postal_tf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        street_tf = new javax.swing.JTextField();
        local_tf = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("Tipo :");

        jLabel2.setText("Nome :");

        jLabel3.setText("Username :");

        jLabel5.setText("Password :");

        tipos_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Obras", "Famílias", "Angariação" }));
        tipos_cb.setToolTipText("");

        nome_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_tfActionPerformed(evt);
            }
        });

        sub_btt.setText("Submeter");
        sub_btt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_bttActionPerformed(evt);
            }
        });

        jLabel6.setText("nif :");

        nif_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nif_tfActionPerformed(evt);
            }
        });

        jLabel7.setText("CodPostal :");

        jLabel8.setText("Rua :");

        jLabel9.setText("Localidade :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sub_btt)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(username_tf))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tipos_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(132, 132, 132))
                                .addComponent(nome_tf)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel5))
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(password_pf)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(nif_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(postal_tf))
                                .addComponent(street_tf)
                                .addComponent(local_tf)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tipos_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nome_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(username_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(password_pf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nif_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(postal_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(street_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(local_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sub_btt))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nome_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_tfActionPerformed
    public void clean()
    {
       for(Component c : this.getComponents())
           if(c.getClass()==JTextField.class)
              ((JTextField)c).setText("");
    }
    private void sub_bttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_bttActionPerformed
        // TODO add your handling code here:
        String name = this.nome_tf.getText();
        String username = this.username_tf.getText();
        
        String tipo = this.tipos_cb.getSelectedItem().toString();
        tipo = tipo.toLowerCase();
        
        System.out.println(tipo);
        String password ="";
        for(char c : this.password_pf.getPassword())
            password+=c; 
        String rua = this.street_tf.getText();
        String local = this.local_tf.getText();
        String cod_postal = this.postal_tf.getText();
        String nif =this.nif_tf.getText();
        clean();
        try {
           boolean b = this.businessFacade.addUtilizador(username, password, name, nif,tipo, rua, local, cod_postal);
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_sub_bttActionPerformed

    private void nif_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nif_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nif_tfActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_formMouseMoved

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField local_tf;
    private javax.swing.JTextField nif_tf;
    private javax.swing.JTextField nome_tf;
    private javax.swing.JPasswordField password_pf;
    private javax.swing.JTextField postal_tf;
    private javax.swing.JTextField street_tf;
    private javax.swing.JButton sub_btt;
    private javax.swing.JComboBox tipos_cb;
    private javax.swing.JTextField username_tf;
    // End of variables declaration//GEN-END:variables
}
