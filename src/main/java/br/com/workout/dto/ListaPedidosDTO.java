package br.com.workout.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListaPedidosDTO {

    @JsonProperty("pedidos")
    private List<PedidoDTO> pedidos;

    public ListaPedidosDTO() {
    }

    public ListaPedidosDTO(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }

}
