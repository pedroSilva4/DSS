package com.habitat.PresentationLayer.Voluntários;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.BusinessLayer.Voluntarios.Morada;
import com.habitat.util.ErrorWindow;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Pedro
 */
public class AdicionarVol extends javax.swing.JPanel {

    /**
     * Creates new form AdicionarVol
     */
    private BusinessFacade businessFacade;
    private JDatePicker jdatePicker;
    public AdicionarVol(BusinessFacade bus) {
        businessFacade =bus;
        initComponents();
        setVisible(true);
       
        this.sub_btt.setEnabled(false);
    }
    
    public void update()
    {
        kl =  new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                verifyFields();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                 verifyFields();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                 verifyFields();
            }
        };
        for(Component c : this.getComponents()){
           if(c.getClass()==JTextField.class || c.getClass()==JFormattedTextField.class)
                c.addKeyListener(kl);
        }
        
    }
    public void verifyFields(){
        boolean b = true;
        for(Component c : this.getComponents()){
           if(c.getClass()==JTextField.class || c.getClass()==JFormattedTextField.class && !(c==this.team_tf) )
               
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

        jLabel2 = new javax.swing.JLabel();
        nome_tf = new javax.swing.JTextField();
        sub_btt = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        street_tf = new javax.swing.JTextField();
        local_tf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        team_tf = new javax.swing.JTextField();
        job_tf = new javax.swing.JTextField();
        bday_tf = new javax.swing.JFormattedTextField();
        phone_tf = new javax.swing.JFormattedTextField();
        postal_tf = new javax.swing.JFormattedTextField();

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

        jLabel2.setText("Nome :");

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

        jLabel7.setText("CodPostal :");

        jLabel8.setText("Rua :");

        jLabel9.setText("Localidade :");

        street_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                street_tfActionPerformed(evt);
            }
        });

        jLabel1.setText("Equipa :");

        jLabel3.setText("DataNasc :");

        jLabel5.setText("Contacto :");

        jLabel10.setText("Profissão :");

        try {
            bday_tf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        bday_tf.setToolTipText("dd/mm/aaaa");

        try {
            phone_tf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            postal_tf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phone_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(postal_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome_tf)
                            .addComponent(bday_tf)
                            .addComponent(team_tf)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(local_tf))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sub_btt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(job_tf))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(35, 35, 35)
                        .addComponent(street_tf)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nome_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(team_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(bday_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(phone_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(postal_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(job_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(street_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(local_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sub_btt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nome_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_tfActionPerformed
    public void clean()
    {
       for(Component c : this.getComponents())
           if(c.getClass()==JTextField.class || c.getClass()==JFormattedTextField.class)
              ((JTextField)c).setText("");
       
      
    }
    private void sub_bttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_bttActionPerformed
        // TODO add your handling code here:
        String name = this.nome_tf.getText();
        String equipa = this.team_tf.getText();

        String[] dateArr = this.bday_tf.getText().split("/");
   
        Date date = new Date(Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[1])-1, Integer.parseInt(dateArr[0]));
        System.out.println(date.getDate()+"-"+date.getMonth()+"-"+date.getYear());
        
        Calendar cal = Calendar.getInstance();
        Date dateNow = new Date(cal.getTimeInMillis());
        String rua = this.street_tf.getText();
        String local = this.local_tf.getText();
        String cod_postal = this.postal_tf.getText();
        String contact = this.phone_tf.getText();
        String job =  this.job_tf.getText();
        try {
           boolean b =  businessFacade.addVoluntario(name, date, dateNow, contact, equipa, job, new Morada(rua, local, cod_postal));
        } catch (SQLException ex) {
            new ErrorWindow("Voluntário", ex.getMessage(), "error", new JFrame()).wshow();
        }
    
        clean();
      
        
        
    }//GEN-LAST:event_sub_bttActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_formMouseMoved

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_formKeyPressed

    private void street_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_street_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_street_tfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField bday_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField job_tf;
    private javax.swing.JTextField local_tf;
    private javax.swing.JTextField nome_tf;
    private javax.swing.JFormattedTextField phone_tf;
    private javax.swing.JFormattedTextField postal_tf;
    private javax.swing.JTextField street_tf;
    private javax.swing.JButton sub_btt;
    private javax.swing.JTextField team_tf;
    // End of variables declaration//GEN-END:variables
    private KeyListener kl;
}
