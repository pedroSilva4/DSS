/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Doacoes;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.BusinessLayer.Doadores.DMaterial;
import com.habitat.BusinessLayer.Doadores.Doacao;
import com.habitat.BusinessLayer.Doadores.Monetario;
import com.habitat.BusinessLayer.Doadores.Servicos;
import com.habitat.util.ErrorWindow;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.invoke.MethodHandles;
import java.sql.Date;
import java.sql.SQLException;
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
public class AdicionarDOA extends javax.swing.JPanel implements Observer{

    /**
     * Creates new form AdicionarDOA
     */
    BusinessFacade businessFacade;
    TipoDOAListener tipoDOA;
    public AdicionarDOA(BusinessFacade bus) {
        
        this.businessFacade = bus;
        initComponents();
        tipoDOA = new TipoDOAListener();
        bus.addObserver(this);
        this.init();
        for(Component c:this.getComponents())
            if(c.getClass() == javax.swing.JTextField.class)
                c.setEnabled(false);
        
        this.jComboBox1.addItemListener(tipoDOA);
        if(this.jComboBox1.getSelectedIndex()==0)montante.setEnabled(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        montante = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        unidade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        qtt = new javax.swing.JTextField();
        doadores_ = new javax.swing.JComboBox();
        eventos_ = new javax.swing.JComboBox();
        projectos_ = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        data = new javax.swing.JFormattedTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar"));

        jLabel12.setText("Cód. Doador:");

        jLabel4.setText("Unidade:");

        jLabel7.setText("Montante:");

        jLabel8.setText("Quantidade:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monetário", "Material", "Serviços" }));

        jLabel1.setText("Tipo:");

        jButton1.setText("Submeter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição:");

        jLabel3.setText("Data:");

        jLabel13.setText("Cód. Evento:");

        jLabel6.setText("Cód.Projeto:");

        doadores_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        eventos_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        projectos_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        try {
            data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(unidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(qtt, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(16, 16, 16)
                                .addComponent(montante, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(329, 329, 329)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(projectos_, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(4, 4, 4)
                                                .addComponent(doadores_, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(8, 8, 8)
                                                .addComponent(eventos_, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jScrollPane1))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doadores_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(projectos_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(eventos_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(montante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String des = this.jTextArea1.getText();
        String evento=null,doador = null,projeto=null,unid = null;
        int qtt_= 0;
        float valor = 0;
        Date data_ = null;
        boolean b = true;
        if(this.eventos_.getSelectedItem()!=null)
        {
            evento =((String)eventos_.getSelectedItem()).split(":")[1].trim();
           
        }
        if(this.projectos_.getSelectedItem()!=null)
        {
            projeto =((String)projectos_.getSelectedItem()).split(":")[1].trim();
            
        }
        if(this.doadores_.getSelectedItem()!=null)
        {
            doador =((String)doadores_.getSelectedItem()).split(":")[0].trim();
            
        }
        else{b=false;}
        if(!b){
            new ErrorWindow("Doação","Doador nao selecionado", "warning", new JFrame()).wshow();
            return;
        }
        String tipo =(String)this.jComboBox1.getSelectedItem();
        Doacao d = null;
          switch(tipo){
              case "Monetário": try{
                                    valor = Float.parseFloat(this.montante.getText());
                                    String[] date =this.data.getText().split("/");
                                    data_ = new Date(Integer.parseInt(date[2])-1900, Integer.parseInt(date[1])-1, Integer.parseInt(date[0]));
                                   }catch(NumberFormatException ex){b=false;}
                                   if(!b || des.equals("")){
                                        new ErrorWindow("Doação","Formulário com dados errados", "warning", new JFrame()).wshow();
                                        return;
                                   }
                                    d = new Monetario("", data_, des, valor);
                                break;
              case "Serviços":  try{
                                    String[] date =this.data.getText().split("/");
                                    data_ = new Date(Integer.parseInt(date[2])-1900, Integer.parseInt(date[1])-1, Integer.parseInt(date[0]));
                                   }catch(NumberFormatException ex){b=false;}
                                   if(!b || des.equals("")){
                                        new ErrorWindow("Doação","Formulário com dados errados", "warning", new JFrame()).wshow();
                                        return;
                                   }
                                d = new Servicos("", data_, des);
                                break;
              
              case "Material": try{
                                    String[] date =this.data.getText().split("/");
                                    data_ = new Date(Integer.parseInt(date[2])-1900, Integer.parseInt(date[1])-1, Integer.parseInt(date[0]));
                                    unid = this.unidade.getText();
                                    qtt_ = Integer.parseInt(this.qtt.getText());
                                   }catch(NumberFormatException ex){b=false;}
                                   if(!b || des.equals("") || unid.equals("") || qtt_ == 0){
                                        new ErrorWindow("Doação","Formulário com dados errados", "warning", new JFrame()).wshow();
                                        return;
                                   }
                                   d = new DMaterial(des, data_, des, unid, qtt_);
                                   break;
          }
        try {
            String s = null;
            if(d!=null && doador!=null){
                 s = this.businessFacade.addDoacao(doador, d);
            }
            if(s!=null){
                    if(projeto!=null)
                        this.businessFacade.associaDoacaoProjeto(projeto, s);
                    if(evento!=null)
                        this.businessFacade.associarDoacao(s, evento);
            }
            new ErrorWindow("Adicionar", "Doação adicionada com Sucesso", "message", new JFrame()).wshow();
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarDOA.class.getName()).log(Level.SEVERE, null, ex);
        }
         for(Component c:this.getComponents())
            if(c.getClass() == javax.swing.JTextField.class ||c.getClass() == javax.swing.JTextArea.class  || c.getClass() == javax.swing.JFormattedTextField.class )
                ((javax.swing.JTextField)c).setText("");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField data;
    private javax.swing.JComboBox doadores_;
    private javax.swing.JComboBox eventos_;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField montante;
    private javax.swing.JComboBox projectos_;
    private javax.swing.JTextField qtt;
    private javax.swing.JTextField unidade;
    // End of variables declaration//GEN-END:variables

    public void init(){
        try {
            this.eventos_.removeAllItems();
            this.eventos_.addItem(null);
            this.doadores_.removeAllItems();
            this.doadores_.addItem(null);
            this.projectos_.removeAllItems();
            this.projectos_.addItem(null);
          
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
                    projectos_.addItem("Projecto : "+s);
                }
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarDOA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        init();
    }
    
    class TipoDOAListener implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e) {
           data.setEnabled(true);
           if(e.getItem().equals("Monetário")){
               montante.setEnabled(true);
               unidade.setEnabled(false);
               qtt.setEnabled(false);
               return;
           }
           if(e.getItem().equals("Serviços")){
               montante.setEnabled(false);
               unidade.setEnabled(false);
               qtt.setEnabled(false);
               return;
           }
           if(e.getItem().equals("Material")){
               montante.setEnabled(false);
               unidade.setEnabled(true);
               qtt.setEnabled(true);
           }
        }
        
    }
}
