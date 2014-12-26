package com.habitat.BusinessLayer.Material;

public class Material {
    private String _cod;
    private String _descricao;
    private int _quantidade;
    private String _unidade;

    public Material(String _cod, String _descricao,  int _quantidade, String _unidade) {
        this._cod = _cod;
        this._descricao = _descricao;
        this._unidade = _unidade;
        this._quantidade = _quantidade;
    }

    public String getCod() {
        return this._cod;
    }

    public void setCod(String aCod) {
        this._cod = aCod;
    }

    public String getDescricao() {
        return this._descricao;
    }

    public void setDescricao(String aDescricao) {
        this._descricao = aDescricao;
    }

    public String getUnidade() {
        return this._unidade;
    }

    public void setUnidade(String aUnidade) {
        this._unidade = aUnidade;
    }

    public int getQuantidade() {
        return this._quantidade;
    }

    public void setQuantidade(int aQuantidade) {
        this._quantidade = aQuantidade;
    }

    @Override
    public String toString() {
        return "Material{" + "_cod=" + _cod + ", _descricao=" + _descricao + ", _quantidade=" + _quantidade + ", _unidade=" + _unidade + '}';
    }
    
    
}
