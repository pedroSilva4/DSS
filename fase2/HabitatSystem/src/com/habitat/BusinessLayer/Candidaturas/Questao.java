package com.habitat.BusinessLayer.Candidaturas;

public class Questao {

    private String _cod;
    private String _pergunta;
    private String _resposta;

    public Questao(String _cod, String _pergunta, String _resposta) {
        this._cod = _cod;
        this._pergunta = _pergunta;
        this._resposta = _resposta;
    }

    public void setPergunta(String pergunta) {
        this._pergunta = pergunta;
    }

    public void SetResposta() {
        throw new UnsupportedOperationException();
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

    public void setCod(String aCod) {
        this._cod = aCod;
    }

    @Override
    public String toString() {
        return "Questao{" + "_cod=" + _cod + ", _pergunta=" + _pergunta + ", _resposta=" + _resposta + '}';
    }

}
