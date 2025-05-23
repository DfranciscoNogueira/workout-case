package br.com.workout.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PedidoDTO {

    @JsonProperty("pedido_id")
    private int pedidoId;

    @JsonProperty("produtos")
    private List<ProdutoDTO> produtos;

    public PedidoDTO(int pedidoId, List<ProdutoDTO> produtos) {
        this.pedidoId = pedidoId;
        this.produtos = produtos;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

}
