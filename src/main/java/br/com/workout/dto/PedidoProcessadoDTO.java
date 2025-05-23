package br.com.workout.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PedidoProcessadoDTO {

    @JsonProperty("pedidos")
    private List<PedidoEmpacotadoDTO> pedidos;

    public PedidoProcessadoDTO(List<PedidoEmpacotadoDTO> pedidos) {
        this.pedidos = pedidos;
    }

    public List<PedidoEmpacotadoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoEmpacotadoDTO> pedidos) {
        this.pedidos = pedidos;
    }

}