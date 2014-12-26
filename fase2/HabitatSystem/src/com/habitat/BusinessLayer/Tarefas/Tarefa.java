package com.habitat.BusinessLayer.Tarefas;

public class Tarefa {

    private String cod;
    private String _descricao;

    public Tarefa(String cod, String _descricao) {
        this.cod = cod;
        this._descricao = _descricao;
    }

    public String getDescricao() {
        return this._descricao;
    }

    public String getCod() {
        return cod;
    }
    

    public void setDescricao(String aDescricao) {
        this._descricao = aDescricao;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "cod=" + cod + ", _descricao=" + _descricao + '}';
    }
        
}
