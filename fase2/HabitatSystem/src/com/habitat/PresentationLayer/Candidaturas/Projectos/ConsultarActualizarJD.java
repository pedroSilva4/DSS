/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.PresentationLayer.Candidaturas.Projectos;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.BusinessLayer.Material.Material;
import com.habitat.BusinessLayer.Projetos.Projeto;
import com.habitat.BusinessLayer.Projetos.ProjetoTarefas;
import com.habitat.BusinessLayer.Tarefas.Tarefa;
import com.habitat.BusinessLayer.Voluntarios.Voluntario;
import com.habitat.util.ErrorWindow;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xavier
 */
public class ConsultarActualizarJD extends javax.swing.JDialog implements Observer {

    /**
     * Creates new form ConsultarActualizarJD
     */
    private BusinessFacade bus;
    private String idProjecto;
    private Projeto p;
    private ArrayList<Tarefa> tarefas;
    private ArrayList<Tarefa> tarefasAssociadas;
    private HashMap<String,Material> material;
    private HashMap<String,ProjetoTarefas> projetoTarefas;
    private ArrayList<Voluntario> voluntarios;
    private ArrayList<Voluntario> voluntariosTarefas;
    public ConsultarActualizarJD(java.awt.Frame parent, boolean modal,BusinessFacade b, String idProjecto) {
        super(parent, modal);
        this.bus = b;
        this.bus.addObserver(this);
        this.idProjecto = idProjecto;
        try {
            this.p = bus.getProjeto(idProjecto);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        this.idLabel.setText(p.getCod());
        this.dataLabel.setText(p.getDataI().toString());
        this.funcLabel.setText(p.getFuncionario());
        this.descricao_ta.setText(p.getDescricao());
        if(p.getDataF() !=null)
            this.data_tf.setText(p.getDataF().toString());
        updateCBTarefas();
        updateCBTarefasAssociadas();
        updateCBMaterial();
        updateCBVoluntarios();
        updateTableVols();
        ItemListener it = new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                String s = ((String)e.getItem()).split(":")[0];
                dataProjetoTarefa_tf.setText(projetoTarefas.get(s).getaDataF().toString());
                if(cbTarefasAssociadas.getSelectedItem() != null)
                    updateTableVols();
            }
        };
        cbTarefasAssociadas.addItemListener(it);
        ItemListener itMat = new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                String s = ((String)e.getItem()).split(":")[0];
                Integer i = new Integer(material.get(s).getQuantidade());
                lbquant.setText(i.toString());
                lbunidade.setText(material.get(s).getUnidade());
            }
            
        };
        cbMaterial.addItemListener(itMat);
    }
    
    void updateCBTarefas(){
        cbtarefa.removeAllItems();
        try {
            this.tarefas = bus.getListaTarefas();
            for(Tarefa t : this.tarefas){
                cbtarefa.addItem(t.getCod()+": "+t.getDescricao());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void updateCBTarefasAssociadas(){
        try {
            cbTarefasAssociadas.removeAllItems();
            this.tarefasAssociadas = bus.getTarefasAssociadas(idProjecto);
            this.projetoTarefas = bus.getListaProjetoTarefa(idProjecto);
            for(Tarefa t : this.tarefasAssociadas){
                cbTarefasAssociadas.addItem(t.getCod()+": "+t.getDescricao());
            }
            if(!this.tarefasAssociadas.isEmpty()){
                String s = ((String)cbtarefa.getSelectedItem()).split(":")[0];
                dataProjetoTarefa_tf.setText(projetoTarefas.get(s).getaDataF().toString());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void updateCBMaterial(){
        try {
            cbMaterial.removeAllItems();
            this.material = bus.getMapMaterial();
            for(String m : material.keySet()){
                cbMaterial.addItem(material.get(m).getCod()+": "+material.get(m).getDescricao());
                Integer i = new Integer(material.get(m).getQuantidade());
            }
            String s = ((String)cbMaterial.getSelectedItem()).split(":")[0];
            Integer i = new Integer(material.get(s).getQuantidade());
            lbquant.setText(i.toString());
            lbunidade.setText(material.get(s).getUnidade());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    void updateCBVoluntarios(){
        try {
            cbVoluntarios.removeAllItems();
            this.voluntarios = bus.getListaVoluntario();
            for(Voluntario v : this.voluntarios){
                cbVoluntarios.addItem(v.getCod()+": "+v.getNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void updateTableVols(){
        try {
            String s = ((String)cbTarefasAssociadas.getSelectedItem()).split(":")[0];
            voluntariosTarefas = bus.getListaVolProjTar(idProjecto, s);
            DefaultTableModel model = new DefaultTableModel(new String[]{"voluntario","tarefa","horas","data"}, 0);
            tableVols.setModel(model);
            tableVols.setCellSelectionEnabled(false);
            for(int i=0;i<voluntariosTarefas.size();i++)
            {
                Voluntario v = voluntariosTarefas.get(i);
                //(String cTar, String cProj, String cVol)
                String dh = bus.getDuracaoParticipacao(s, idProjecto, v.getCod());
                Date dr = bus.getDataParticipacao(s, idProjecto, v.getCod());
                model.addRow(new String[]{v.getCod()+": "+v.getNome(),s,dh,dr.toString()});
                model.fireTableDataChanged();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricao_ta = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        funcLabel = new javax.swing.JLabel();
        btActualiza = new javax.swing.JButton();
        data_tf = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbtarefa = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        btAssociaTarefa = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_novaTarefa = new javax.swing.JTextField();
        btAddNovaTarefa = new javax.swing.JButton();
        dataAssociaInicio_tf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        dataAssociaFim_tf = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cbTarefasAssociadas = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbVoluntarios = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableVols = new javax.swing.JTable();
        btAddParticipTarefa = new javax.swing.JButton();
        btAtualizaData = new javax.swing.JButton();
        dataProjetoTarefa_tf = new javax.swing.JFormattedTextField();
        tfHorasParticip = new javax.swing.JFormattedTextField();
        tfDataParticip = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        cbMaterial = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        lbunidade = new javax.swing.JLabel();
        btAddMAtProj = new javax.swing.JButton();
        tf_quantRequer = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        lbquant = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Candidatura: ");

        idLabel.setText("jLabel2");

        jLabel3.setText("Data de início: ");

        dataLabel.setText("jLabel4");

        jLabel5.setText("Data de Fim: ");

        jLabel6.setText("Descrição: ");

        descricao_ta.setColumns(20);
        descricao_ta.setRows(5);
        jScrollPane1.setViewportView(descricao_ta);

        jLabel7.setText("Funcionario: ");

        funcLabel.setText("jLabel8");

        btActualiza.setText("Atualizar");
        btActualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizaActionPerformed(evt);
            }
        });

        try {
            data_tf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(idLabel))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btActualiza)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(funcLabel)
                                .addComponent(dataLabel)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(data_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(322, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dataLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(data_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(funcLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btActualiza)
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("Projeto", jPanel1);

        jLabel9.setText("Tarefa: ");

        cbtarefa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Data de inicio: ");

        btAssociaTarefa.setText("Adicionar");
        btAssociaTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAssociaTarefaActionPerformed(evt);
            }
        });

        jLabel11.setText("Adicionar tarefa à Lista");

        jLabel12.setText("Descrição:");

        btAddNovaTarefa.setText("Adicionar à lista");
        btAddNovaTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddNovaTarefaActionPerformed(evt);
            }
        });

        try {
            dataAssociaInicio_tf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Data de fim:");

        try {
            dataAssociaFim_tf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_novaTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btAddNovaTarefa))
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbtarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataAssociaInicio_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(dataAssociaFim_tf))
                        .addGap(32, 32, 32)
                        .addComponent(btAssociaTarefa)))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbtarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(dataAssociaInicio_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dataAssociaFim_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAssociaTarefa))
                .addGap(28, 28, 28)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tf_novaTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAddNovaTarefa))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adicionar Tarefas", jPanel2);

        jLabel13.setText("Tarefa:");

        cbTarefasAssociadas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Data de Fim:");

        jLabel15.setText("Voluntário:");

        cbVoluntarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setText("horas:");

        jLabel17.setText("Data:");

        tableVols.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "tarefa", "horas", "data"
            }
        ));
        jScrollPane2.setViewportView(tableVols);

        btAddParticipTarefa.setText("Adicionar");
        btAddParticipTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddParticipTarefaActionPerformed(evt);
            }
        });

        btAtualizaData.setText("Atualizar data");
        btAtualizaData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizaDataActionPerformed(evt);
            }
        });

        try {
            dataProjetoTarefa_tf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tfHorasParticip.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));

        try {
            tfDataParticip.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTarefasAssociadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbVoluntarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dataProjetoTarefa_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(tfHorasParticip, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDataParticip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btAtualizaData)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAddParticipTarefa)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbTarefasAssociadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(dataProjetoTarefa_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizaData))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbVoluntarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(tfHorasParticip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataParticip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAddParticipTarefa)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar/atualizar Tarefas", jPanel3);

        jLabel18.setText("Material:");

        cbMaterial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setText("Quantidade:");

        lbunidade.setText("aparece a unidade");

        btAddMAtProj.setText("Adicionar ao projeto");
        btAddMAtProj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddMAtProjActionPerformed(evt);
            }
        });

        tf_quantRequer.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));

        jLabel4.setText("Quantidade:");

        lbquant.setText("quantidade");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAddMAtProj, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_quantRequer, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(cbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lbquant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbunidade)
                        .addGap(161, 161, 161))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(lbquant)
                    .addComponent(lbunidade))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tf_quantRequer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btAddMAtProj)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adicionar Material", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAssociaTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAssociaTarefaActionPerformed
        try {
            // TODO add your handling code here:
            String[] d1 = this.dataAssociaInicio_tf.getText().split("-");
            Date date1 = new Date(Integer.parseInt(d1[0])-1900, Integer.parseInt(d1[1])-1, Integer.parseInt(d1[2]));
            String[] d2 = this.dataAssociaFim_tf.getText().split("-");
            Date date2 = new Date(Integer.parseInt(d2[0])-1900, Integer.parseInt(d2[1])-1, Integer.parseInt(d2[2]));
            String [] parse = ((String)this.cbtarefa.getSelectedItem()).split(":");
            String idTar = parse[0];
            this.bus.addTarefaProjeto(idTar, idProjecto, date1, date2);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAssociaTarefaActionPerformed

    private void btActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizaActionPerformed
        // TODO add your handling code here:
        String[] d = this.data_tf.getText().split("-");
        Date date = new Date(Integer.parseInt(d[0])-1900, Integer.parseInt(d[1])-1, Integer.parseInt(d[2]));
        p.setDataF(date);
        p.setDescricao(this.descricao_ta.getText());
        try {
            this.bus.updateProjeto(p);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btActualizaActionPerformed

    private void btAddNovaTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddNovaTarefaActionPerformed
        try {
            // TODO add your handling code here:
            Tarefa t = new Tarefa("",this.tf_novaTarefa.getText());
            this.bus.addTarefa(t);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAddNovaTarefaActionPerformed

    private void btAddMAtProjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddMAtProjActionPerformed
        // TODO add your handling code here:
        int qtDisp = new Integer(lbquant.getText()).intValue();
        int qtRequer = new Integer(tf_quantRequer.getText()).intValue();
        if(qtRequer <= qtDisp){
            try {
                int i = qtDisp-qtRequer;
                String s = ((String)cbMaterial.getSelectedItem()).split(":")[0];
                Material m = material.get(s);
                this.bus.associaMaterialProjecto(m.getCod(), idProjecto, qtRequer);
                m.setQuantidade(i);
                this.bus.setMaterial(m);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            new ErrorWindow("Erro","Quantidade requerida indisponível","error",new JFrame()).wshow();
        }
    }//GEN-LAST:event_btAddMAtProjActionPerformed

    private void btAtualizaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizaDataActionPerformed
        try {
            // TODO add your handling code here:
            String[] d1 = this.dataProjetoTarefa_tf.getText().split("-");
            Date date1 = new Date(Integer.parseInt(d1[0])-1900, Integer.parseInt(d1[1])-1, Integer.parseInt(d1[2]));
            String s = ((String)cbtarefa.getSelectedItem()).split(":")[0];
            this.bus.setProjectoTarefa(date1, idProjecto, s);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAtualizaDataActionPerformed

    private void btAddParticipTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddParticipTarefaActionPerformed
        try {
            // TODO add your handling code here:
            
            //(String cVol, String cTar, String cProj,  Date dataR, int dHoras)
            String cVol =((String) this.cbVoluntarios.getSelectedItem()).split(":")[0];
            String cTar = ((String)this.cbTarefasAssociadas.getSelectedItem()).split(":")[0];
            String[] d1 = this.tfDataParticip.getText().split("-");
            Date date1 = new Date(Integer.parseInt(d1[0])-1900, Integer.parseInt(d1[1])-1, Integer.parseInt(d1[2]));
            Integer i = new Integer(tfHorasParticip.getText());
            bus.addParticipacaoTarefa(cVol, cTar, idProjecto, date1, i);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarActualizarJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAddParticipTarefaActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarActualizarJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarActualizarJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarActualizarJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarActualizarJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultarActualizarJD dialog = new ConsultarActualizarJD(new javax.swing.JFrame(), true,null,"");
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
    private javax.swing.JButton btActualiza;
    private javax.swing.JButton btAddMAtProj;
    private javax.swing.JButton btAddNovaTarefa;
    private javax.swing.JButton btAddParticipTarefa;
    private javax.swing.JButton btAssociaTarefa;
    private javax.swing.JButton btAtualizaData;
    private javax.swing.JComboBox cbMaterial;
    private javax.swing.JComboBox cbTarefasAssociadas;
    private javax.swing.JComboBox cbVoluntarios;
    private javax.swing.JComboBox cbtarefa;
    private javax.swing.JFormattedTextField dataAssociaFim_tf;
    private javax.swing.JFormattedTextField dataAssociaInicio_tf;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JFormattedTextField dataProjetoTarefa_tf;
    private javax.swing.JFormattedTextField data_tf;
    private javax.swing.JTextArea descricao_ta;
    private javax.swing.JLabel funcLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbquant;
    private javax.swing.JLabel lbunidade;
    private javax.swing.JTable tableVols;
    private javax.swing.JFormattedTextField tfDataParticip;
    private javax.swing.JFormattedTextField tfHorasParticip;
    private javax.swing.JTextField tf_novaTarefa;
    private javax.swing.JFormattedTextField tf_quantRequer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        updateCBTarefas();
        updateCBTarefasAssociadas();
        updateCBMaterial();
        updateCBVoluntarios();
        updateTableVols();
    }
}
