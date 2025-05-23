package br.com.workout.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoDTO {

    @JsonProperty("produto_id")
    private String produtoId;

    @JsonProperty("dimensoes")
    private DimensoesDTO dimensoes;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String produtoId, DimensoesDTO dimensoes) {
        this.produtoId = produtoId;
        this.dimensoes = dimensoes;
    }

    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public DimensoesDTO getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(DimensoesDTO dimensoes) {
        this.dimensoes = dimensoes;
    }

}
