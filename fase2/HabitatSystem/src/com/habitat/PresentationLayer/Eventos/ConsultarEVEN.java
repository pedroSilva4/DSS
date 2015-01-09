/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Eventos;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.BusinessLayer.Eventos.Evento;
import com.habitat.PresentationLayer.Doadores.ConsultarDOADOR;
import com.habitat.util.ErrorWindow;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author filiperibeiro
 */
public class ConsultarEVEN extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form ConsultarDAO
     */
    private final BusinessFacade businessFacade;
    private ArrayList<Evento> eventos;
    
    public ConsultarEVEN(BusinessFacade bus) {
        this.businessFacade = bus;
        this.businessFacade.addObserver(this);
        
        try{
            this.eventos = businessFacade.getListaEventos();
            initComponents();
            updateComboBox();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarDOADOR.class.getName()).log(Level.SEVERE, null, ex);
        }   
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
        jButton3 = new javax.swing.JButton();
        evento_cb = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar"));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Evento:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 58, -1, -1));

        jButton3.setText("Consultar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 53, 115, -1));

        evento_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        add(evento_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 54, 131, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Evento d = (Evento)this.evento_cb.getSelectedItem();
        String type = this.businessFacade.getActiveUser().getTipo(); 
        if(d==null){new ErrorWindow("Evento","Evento não Existe", "warning", new JFrame()).wshow();return;}
        if(type.equals("admin") || type.equals("angariação")){
                    new ActualiarEVENDialog(new JFrame(), true, businessFacade,d).setVisible(true);
            }
        else{
                    new ConsultarEVENDialog(new JFrame(), true, d,businessFacade).setVisible(true);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox evento_cb;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public void updateComboBox(){
    
        this.evento_cb.removeAllItems(); 
       for(Evento v : eventos)
       {
                this.evento_cb.addItem(v);
       }
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            this.eventos = businessFacade.getListaEventos();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarEVEN.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateComboBox();
    }
}
