/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Doacoes;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.BusinessLayer.Doadores.Doacao;
import com.habitat.util.ErrorWindow;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author filiperibeiro
 */
public class ConsultarDOA extends javax.swing.JPanel implements Observer{

    /**
     * Creates new form ConsultarDAO
     */
    BusinessFacade businessFacade;
    public ConsultarDOA(BusinessFacade bus) {
        this.businessFacade = bus;
        businessFacade.addObserver(this);
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

        jLabel1 = new javax.swing.JLabel();
        id_ = new javax.swing.JTextField();
        cons = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        doadores_ = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        eventos_ = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        projetos_ = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar"));

        jLabel1.setText("Código Doação:");

        cons.setText("Consultar");
        cons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consActionPerformed(evt);
            }
        });

        jLabel2.setText("Doador :");

        doadores_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Evento :");

        eventos_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Projecto :");

        projetos_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cons, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(52, 52, 52)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(53, 53, 53))
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(doadores_, 0, 150, Short.MAX_VALUE)
                            .addComponent(id_)
                            .addComponent(eventos_, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(projetos_, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(doadores_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(eventos_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(projetos_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(cons)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consActionPerformed
        // TODO add your handling code here:
        if(!this.id_.getText().isEmpty()){
            try {
               Doacao d = this.businessFacade.getDoacao(id_.getText());
               if(d!=null){
                    new ConsDoacaoDialog(new JFrame(), true, d).setVisible(true);
               }
            } catch (SQLException ex) {
                new ErrorWindow("Pesquisa",ex.getMessage(), "error", new JFrame()).wshow();
            }
        }
        else{
            if(this.doadores_.getSelectedItem()==null && this.eventos_.getSelectedItem()==null && this.projetos_.getSelectedItem()==null){
                new ErrorWindow("Pesquisa", "Tem de fornecer pelo menos um parametro de pesquisa", "error", new JFrame()).wshow();
                return;
            }
            String evento=null,doador = null,projeto=null,unid = null;
            if(this.eventos_.getSelectedItem()!=null)
            {
                evento =((String)eventos_.getSelectedItem()).split(":")[1].trim();

            }
            if(this.projetos_.getSelectedItem()!=null)
            {
                projeto =((String)projetos_.getSelectedItem()).split(":")[1].trim();

            }
            if(this.doadores_.getSelectedItem()!=null)
            {
                doador =((String)doadores_.getSelectedItem()).split(":")[0].trim();

            }
            try {
                ArrayList<Doacao> doacoes = businessFacade.getListaDoacoes(doador, projeto, evento);
                if(!doacoes.isEmpty()){
                    new ConsDoacaoDialog(new JFrame(), true, doacoes).setVisible(true);
                }
            } catch (SQLException ex) {
                 new ErrorWindow("Pesquisa",ex.getMessage(), "error", new JFrame()).wshow();
            }
        }
        
    }//GEN-LAST:event_consActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cons;
    private javax.swing.JComboBox doadores_;
    private javax.swing.JComboBox eventos_;
    private javax.swing.JTextField id_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox projetos_;
    // End of variables declaration//GEN-END:variables
    public void init(){
            try {
                this.eventos_.removeAllItems();
                this.eventos_.addItem(null);
                this.doadores_.removeAllItems();
                this.doadores_.addItem(null);
                this.projetos_.removeAllItems();
                this.projetos_.addItem(null);

                    for(String s : businessFacade.getListaIdsEventos()){

                        this.eventos_.addItem("Evento: "+s);
                    }
                    HashMap<String,String> doadores = businessFacade.getListaIdDoadores();
                    for(String s : doadores.keySet())
                    {
                        doadores_.addItem(s+": "+doadores.get(s));
                    }
                    for(String s: businessFacade.getListaIdProjectos())
                    {
                        projetos_.addItem("Projecto : "+s);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(AdicionarDOA.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void update(Observable o, Object arg) {
        init();
    }
}
