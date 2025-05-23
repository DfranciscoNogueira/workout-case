package br.com.workout.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class DimensoesDTO {

    @JsonProperty("altura")
    private int altura;

    @JsonProperty("largura")
    private int largura;

    @JsonProperty("comprimento")
    private int comprimento;

    public DimensoesDTO() {
    }

    public DimensoesDTO(int altura, int largura, int comprimento) {
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

}