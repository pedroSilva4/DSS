/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.BusinessLayer.Projetos;

import java.sql.Date;

/**
 *
 * @author carlosmorais
 */
public class ProjetoTarefas {
    private String aTarefa; 
    private Date aDataI; 
    private Date aDataF; 

    public ProjetoTarefas( Date aDataI, Date aDataF, String aTarefa) {
        this.aTarefa = aTarefa;
        this.aDataI = aDataI;
        this.aDataF = aDataF;
    }

    public String getaTarefa() {
        return aTarefa;
    }

    public Date getaDataI() {
        return aDataI;
    }

    public Date getaDataF() {
        return aDataF;
    }

    @Override
    public String toString() {
        return "ProjetoTarefas{" + "aTarefa=" + aTarefa + ", aDataI=" + aDataI + ", aDataF=" + aDataF + '}';
    }
    
    
}
