package br.com.workout.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoEmpacotadoDTO {

    @JsonProperty("pedido_id")
    private int pedidoId;

    @JsonProperty("caixas")
    private List<CaixaDTO> caixas;

    public PedidoEmpacotadoDTO(int pedidoId, List<CaixaDTO> caixas) {
        this.pedidoId = pedidoId;
        this.caixas = caixas;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public List<CaixaDTO> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<CaixaDTO> caixas) {
        this.caixas = caixas;
    }

}