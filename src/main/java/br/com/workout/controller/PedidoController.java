package br.com.workout.controller;

import br.com.workout.dto.ListaPedidosDTO;
import br.com.workout.dto.PedidoProcessadoDTO;
import br.com.workout.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@Tag(name = "Pedidos", description = "Endpoints para processamento de pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @Operation(summary = "Processar pedidos", description = "Recebe uma lista de pedidos e retorna um objeto com os pedidos processados e embalados.")
    public ResponseEntity<PedidoProcessadoDTO> processarPedidos(@RequestBody ListaPedidosDTO listaPedidosDTO) {
        PedidoProcessadoDTO resposta = pedidoService.processarPedidos(listaPedidosDTO);
        return ResponseEntity.ok(resposta);
    }

}
