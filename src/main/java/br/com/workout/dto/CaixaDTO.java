package br.com.workout.dto;

import br.com.workout.enuns.TamanhoCaixa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaixaDTO {

    @JsonProperty("caixa_id")
    private String caixaId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("observacao")
    private String observacao;

    @JsonProperty("produtos")
    private List<String> produtos;

    @JsonIgnore
    private TamanhoCaixa tamanhoCaixa;

    public CaixaDTO(String caixaId, TamanhoCaixa tamanhoCaixa) {
        this.caixaId = caixaId;
        this.tamanhoCaixa = tamanhoCaixa;
        this.produtos = new ArrayList<>();
    }

    public CaixaDTO(String caixaId, TamanhoCaixa tamanhoCaixa, String observacao) {
        this.caixaId = caixaId;
        this.observacao = observacao;
        this.tamanhoCaixa = tamanhoCaixa;
        this.produtos = new ArrayList<>();
    }

    public boolean cabeProduto(ProdutoDTO produto) {

        if (Objects.isNull(this.tamanhoCaixa) || Objects.isNull(produto) || Objects.isNull(produto.getDimensoes())) {
            return false;
        }

        DimensoesDTO d = produto.getDimensoes();

        return d.getAltura() <= this.tamanhoCaixa.getAltura() &&
                d.getLargura() <= this.tamanhoCaixa.getLargura() &&
                d.getComprimento() <= this.tamanhoCaixa.getComprimento();
    }

    public void adicionarProduto(ProdutoDTO produto) {
        this.produtos.add(produto.getProdutoId());
    }

    public String getCaixaId() {
        return caixaId;
    }

    public void setCaixaId(String caixaId) {
        this.caixaId = caixaId;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }

}