package com.habitat.BusinessLayer.Candidaturas;

public class Questao {

    private String _cod;
    private String _pergunta;
    private String _resposta;
    private String _estado;

    public Questao(String _cod, String _pergunta, String _resposta, String _estado) {
        this._cod = _cod;
        this._pergunta = _pergunta;
        this._resposta = _resposta;
        this._estado = _estado;
    }
    public void setEstado(String estado){
        this._estado = estado;
    }
    
    public String getEstado(){
        return this._estado;
    }
    
    public void setPergunta(String pergunta) {
        this._pergunta = pergunta;
    }

    public void SetResposta(String resposta){
        this._resposta = resposta;
    }

    public String getPergunta() {
        return this._pergunta;
    }

    public String getResposta() {
        return this._resposta;
    }

    public String getCod() {
        return this._cod;
    }



    @Override
    public String toString() {
        return "Questao{" + "_cod=" + _cod + ", _pergunta=" + _pergunta + ", _resposta=" + _resposta + '}';
    }

}
