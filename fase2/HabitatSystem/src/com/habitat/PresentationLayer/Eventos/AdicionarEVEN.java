/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Eventos;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.BusinessLayer.Voluntarios.Morada;
import com.habitat.util.ErrorWindow;
import java.awt.Component;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.jdatepicker.JDatePicker;
import com.habitat.DataLayer.EventosDAO;
import com.habitat.PresentationLayer.Doacoes.AdicionarDOA;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author filiperibeiro
 */
public class AdicionarEVEN extends javax.swing.JPanel {

    /**
     * Creates new form AdicionarDOA
     */
    private BusinessFacade businessFacade;
    //private TipoDOAListener tipoDOA;
    public AdicionarEVEN(BusinessFacade bus) {
        businessFacade =bus;
        initComponents();
        setVisible(true);
        this.init();
       
        this.submetar_but.setEnabled(false);
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

        jLabel5 = new javax.swing.JLabel();
        tf_valorAnga = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nunParticipantes_tf = new javax.swing.JTextField();
        submetar_but = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        data_tf = new javax.swing.JFormattedTextField();
        codProj_cbox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        observacoes_ta = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar"));

        jLabel5.setText("Valor Angariado:");

        jLabel7.setText("Nº Participantes:");

        submetar_but.setText("Submeter");
        submetar_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submetar_butActionPerformed(evt);
            }
        });

        jLabel2.setText("Observações:");

        jLabel3.setText("Data:");

        jLabel6.setText("Cód.Projeto:");

        data_tf.setText("  /  /    ");

        codProj_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        observacoes_ta.setColumns(20);
        observacoes_ta.setRows(5);
        jScrollPane1.setViewportView(observacoes_ta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submetar_but)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(data_tf)
                                .addComponent(codProj_cbox, 0, 120, Short.MAX_VALUE))
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_valorAnga, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nunParticipantes_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(data_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nunParticipantes_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(codProj_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(tf_valorAnga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(submetar_but)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submetar_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submetar_butActionPerformed
        // TODO add your handling code here:
        String num = this.nunParticipantes_tf.getText();
        int num_i = Integer.parseInt(num);
        String codProj = null;
        if(this.codProj_cbox.getSelectedItem()!=null)
        {
            codProj =((String)codProj_cbox.getSelectedItem()).split(":")[1].trim();
           
        } 
        System.out.println(codProj);
        String val_s = this.tf_valorAnga.getText();
        float val_f = Float.parseFloat(val_s);
        String observ = this.observacoes_ta.getText();

        String[] dateArr = this.data_tf.getText().split("/");
   
        Date date = new Date(Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[1])-1, Integer.parseInt(dateArr[0]));
        System.out.println(date.getDate()+"-"+date.getMonth()+"-"+date.getYear());
        
        String fun = this.businessFacade.getActiveUser().getUsername();
        try {
           businessFacade.addEvento(date,val_f,num_i,fun,observ); 
        } catch (SQLException ex) {
            new ErrorWindow("Voluntário", ex.getMessage(), "error", new JFrame()).wshow();
        }
    
        clean();
    }//GEN-LAST:event_submetar_butActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox codProj_cbox;
    private javax.swing.JFormattedTextField data_tf;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nunParticipantes_tf;
    private javax.swing.JTextArea observacoes_ta;
    private javax.swing.JButton submetar_but;
    private javax.swing.JTextField tf_valorAnga;
    // End of variables declaration//GEN-END:variables


public void init(){
        try {
            this.codProj_cbox.removeAllItems();
            this.codProj_cbox.addItem(null);
          
                for(String s : businessFacade.getListaIdsEventos()){
                    
                    this.codProj_cbox.addItem("Evento: "+s);
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarDOA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
