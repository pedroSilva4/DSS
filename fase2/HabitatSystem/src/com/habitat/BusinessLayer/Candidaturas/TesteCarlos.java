/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.BusinessLayer.Candidaturas;

import com.habitat.BusinessLayer.BusinessFacade;
import com.habitat.BusinessLayer.Material.Material;
import com.habitat.BusinessLayer.Doadores.Doacao;
import com.habitat.BusinessLayer.Doadores.Monetario;
import com.habitat.BusinessLayer.Projetos.Projeto;
import com.habitat.BusinessLayer.Projetos.ProjetoTarefas;
import com.habitat.BusinessLayer.Tarefas.Tarefa;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author carlosmorais
 */
public class TesteCarlos {
    public static void main(String args[]) throws SQLException, ParseException {
        BusinessFacade businessFacade = new BusinessFacade();
        /*
        
        
        Date d1 = new Date(2012-1900,12-1,12);
        Doacao doa = new Monetario("", new Date(2012-1900,12-1,12), "nova", (float) 1000.0);
        
        businessFacade.addDoacao("1", doa);
        
        System.out.println("a data 1 é "+d1.getDate()+"-"+(d1.getMonth()+1)+"-"+(d1.getYear()+1900));
        System.out.println("a data 1 é "+d1.toString());
        
        Doacao doa2 = businessFacade.getDoacao("18");
        //System.out.println("a data 2 é "+doa2.getDate());
        System.out.println("a data 2 é "+doa2.getData()+"ou"+doa2.getData().toString());*/
        
        /*teste Candidaturas*/
        
        //quetoes ativas
        
        ArrayList<Questao> questA = businessFacade.getQuestoesActivas();        
            
        //preencher respostas
        int i=1;
        for(Questao q: questA){
            q.SetResposta("esta é a resposta "+i);
            i++;
        }
        
        i=1;
        for(Questao q: questA){
            System.out.println("questao "+i+" : "+q.toString());
            i++;
        }
        
        //contruir elementos        
        Elemento e1 = new Elemento("","Jose",new Date(1978-1900,10-1,11),"12ºano","sol","pai","arrumador de carros","portuguesa","portuguesa");
        Elemento e2 = new Elemento("","carlos",new Date(2000-1900,5-1,19),"12ºano","sol","irmao","arrumador de vacas","portuguesa","portuguesa");
        Elemento e3 = new Elemento("","Morais",new Date(2002-1900,2-1,22),"12ºano","casado","filho","vadio","portuguesa","portuguesa");
        ArrayList<Elemento> elems = new ArrayList<>();
        elems.add(e1);
        elems.add(e2);
        elems.add(e3);
        
        Calendar cal = Calendar.getInstance();
        Candidatura nova = new Candidatura("", new Date(cal.getTimeInMillis()), new Date(2014-1900,5-1,19),
            "opah, nada a observar", "analise, ou outro...", "pedro",
            questA, elems, (float) 1000.00, "nua do césamo", "berço","1233-222", e1,"708242424");
        
        System.out.println(nova.toString());
        
        businessFacade.addCandidatura(nova);
        
        Candidatura nova2 = businessFacade.getCandidatura("21");
        
        System.out.println(nova2.toString());
        
        
        /*
        Candidatura c = businessFacade.getCandidatura("1");
        System.out.println(c.toString());
        
        if (businessFacade.containsCadidatura("1"))
            System.out.println("existe a candidatura 1");
        else
            System.out.println("nao existe a candidatura 1");
        
        if (businessFacade.containsCadidatura("2222"))
            System.out.println("existe a candidatura 2222");
        else
            System.out.println("nao existe a candidatura 2222");
        
        */
        
        
        /*
        Questao q1 = new Questao("1","pergunta?","nao quero");
        Questao q2 = new Questao("2","pergunta?","2000");
        Questao q3 = new Questao("3","pergunta?","sei la");
        
        ArrayList<Questao> quest = new ArrayList<Questao>();
        quest.add(q1);
        quest.add(q2);
        quest.add(q3);
        
        
        Date d2 = new Date(2220,1,1);
 
        Elemento e1 = new Elemento("","Jose",d1,"12ºano","sol","pai","arrumador de carros");
        Elemento e2 = new Elemento("","carlos",d1,"12ºano","sol","irmao","arrumador de vacas");
        Elemento e3 = new Elemento("","Morais",d1,"12ºano","casado","filho","vadio");
        ArrayList<Elemento> elems = new ArrayList<Elemento>();
        
        Candidatura nova = new Candidatura("",d1,d2,"nada a dizer","em analise","xavier",quest, elems);
        System.out.println(nova.toString());
        businessFacade.addCandidatura(nova);                
        
        /*Teste Material*/
        /*
        businessFacade.addMaterial("telhas", "palete", 10);
        Material m = businessFacade.getMaterial("3");
        System.out.println(m.toString());
        m.setQuantidade(25);
        businessFacade.setMaterial(m);*/
        
        /*teste tarefas
        //businessFacade.addTarefa("pintar paredes");
        
        Tarefa t = businessFacade.getTarefa("16");
        System.out.println(t.toString());
        t.setDescricao("pintar bem as paredes");
        businessFacade.updateTarefa(t);*/
        
        
        // TESTE PROJETO
        /*
        Date dataI = new Date(2010,10,10);
        Date dataF = new Date(2220,1,1);
                        
        Projeto p = new Projeto("","1", dataI, dataF, "analise", "construçao de casa", 10000.00, "xavier", null);
        businessFacade.addProjeto(p);                    
        
        Projeto p2 = businessFacade.getProjeto("5");
        System.out.println(p2.toString());        

         Date dataI = new Date(2010,10,10);
        Date dataF = new Date(2220,1,1);
        businessFacade.addTarefaProjeto("1", "5", dataI, dataF);
        businessFacade.addTarefaProjeto("2", "5", dataI, dataF);
        businessFacade.addTarefaProjeto("3", "5", dataI, dataF);
        
        Projeto p2 = businessFacade.getProjeto("5");
        System.out.println(p2.toString()); 
                
        
        if (businessFacade.existeProjeto("5"))
            System.out.println("existe o projeto 5");
        else
            System.out.println("nao existe o projeto 5");
        
        if (businessFacade.containsCadidatura("2222"))
            System.out.println("existe o projeto 2222");
        else
            System.out.println("nao existe o projeto 2222");
                
                
        
        Date dataI = new Date(2010,10,10);
        businessFacade.addExeTarefaProjeto("1", "5", "1", dataI, 10.0);
        
        Projeto p2 = businessFacade.getProjeto("5");
        p2.setDescricao("esta é a minha nova descrição!");
        businessFacade.updateProjeto(p2);
                */
    }
}
