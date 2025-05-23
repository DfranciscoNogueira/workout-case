package br.com.workout.controller;

import br.com.workout.dto.ListaPedidosDTO;
import br.com.workout.dto.PedidoProcessadoDTO;
import br.com.workout.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PedidoControllerTest {

    @Mock
    private PedidoService pedidoService;

    @InjectMocks
    private PedidoController pedidoController;

    @Test
    void deveProcessarPedidosComSucesso() {

        ListaPedidosDTO listaPedidosDTO = new ListaPedidosDTO();
        PedidoProcessadoDTO pedidoProcessadoDTO = new PedidoProcessadoDTO(Collections.emptyList());

        when(pedidoService.processarPedidos(listaPedidosDTO)).thenReturn(pedidoProcessadoDTO);
        ResponseEntity<PedidoProcessadoDTO> resposta = pedidoController.processarPedidos(listaPedidosDTO);

        assertNotNull(resposta);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(pedidoProcessadoDTO, resposta.getBody());
        verify(pedidoService, times(1)).processarPedidos(listaPedidosDTO);

    }

}