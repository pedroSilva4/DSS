/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Doadores;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.BusinessLayer.Doadores.Doador;
import com.habitat.util.ErrorWindow;
import java.awt.Component;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.jdatepicker.JDatePicker;

/**
 *
 * @author filiperibeiro
 */
public class AdicionarDOADOR_indiv extends javax.swing.JPanel {

    /**
     * Creates new form AdicionarDOAindiv
     */
    private BusinessFacade businessFacade;
    private JDatePicker jdatePicker;
    public AdicionarDOADOR_indiv(BusinessFacade bus) {
        businessFacade =bus;
        initComponents();
        setVisible(true);
        
        //this.submeter_bt.setEnabled(false);
        
    }
    
    public void clean()
    {
       for(Component c : this.getComponents())
           if(c.getClass()==JTextField.class || c.getClass()==JFormattedTextField.class)
              ((JTextField)c).setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome_tf = new javax.swing.JTextField();
        telefone_TF = new javax.swing.JTextField();
        rua_tf = new javax.swing.JTextField();
        submeter_bt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        localidade_tf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nif_tf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        email_tf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        postal_tf = new javax.swing.JFormattedTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nome_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_tfActionPerformed(evt);
            }
        });
        add(nome_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 6, 301, -1));
        add(telefone_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 46, 123, -1));
        add(rua_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 132, 307, -1));

        submeter_bt.setText("Submeter");
        submeter_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submeter_btActionPerformed(evt);
            }
        });
        add(submeter_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 218, -1, -1));

        jLabel2.setText("Nome:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, 45, -1));

        jLabel10.setText("Localidade:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 184, -1, -1));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        add(localidade_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 178, 131, -1));

        jLabel4.setText("Rua:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 138, -1, -1));

        jLabel5.setText("Email:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 92, -1, -1));
        add(nif_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 46, 141, -1));

        jLabel6.setText("NIF:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 52, -1, -1));
        add(email_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 86, 307, -1));

        jLabel9.setText("Contacto:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, -1, -1));

        jLabel7.setText("CodPostal:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 186, -1, 20));

        try {
            postal_tf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        add(postal_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void nome_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_tfActionPerformed

    private void submeter_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submeter_btActionPerformed
        // TODO add your handling code here:
        Calendar cal = Calendar.getInstance();
            Date dateASSOC = new Date(cal.getTimeInMillis());
        String nome = this.nome_tf.getText();
        String contact = this.telefone_TF.getText();
        String nif = this.nif_tf.getText();
        String email = this.email_tf.getText();
        String rua = this.rua_tf.getText();
        String localidade = this.localidade_tf.getText();
        String cod_postal = this.postal_tf.getText();
  
        try {
           Doador doa = new Doador("",nome,nif,rua,localidade,
                                   cod_postal,contact,email,dateASSOC);
           
         
        businessFacade.addDoador(doa);
        } catch (SQLException ex) {
            new ErrorWindow("Doador", ex.getMessage(), "error", new JFrame()).wshow();
        }
    
        clean();
    }//GEN-LAST:event_submeter_btActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email_tf;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField localidade_tf;
    private javax.swing.JTextField nif_tf;
    private javax.swing.JTextField nome_tf;
    private javax.swing.JFormattedTextField postal_tf;
    private javax.swing.JTextField rua_tf;
    private javax.swing.JButton submeter_bt;
    private javax.swing.JTextField telefone_TF;
    // End of variables declaration//GEN-END:variables
}
