package br.com.workout.service;

import br.com.workout.dto.CaixaDTO;
import br.com.workout.dto.DimensoesDTO;
import br.com.workout.dto.ListaPedidosDTO;
import br.com.workout.dto.PedidoDTO;
import br.com.workout.dto.PedidoProcessadoDTO;
import br.com.workout.dto.ProdutoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PedidoServiceTest {

    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        pedidoService = new PedidoService();
    }

    @Test
    void deveEmpacotarProdutosCorretamente() {

        ProdutoDTO produto1 = new ProdutoDTO("Produto 1", new DimensoesDTO(10, 10, 10));
        ProdutoDTO produto2 = new ProdutoDTO("Produto 2", new DimensoesDTO(30, 30, 30));
        ProdutoDTO produto3 = new ProdutoDTO("Produto 3", new DimensoesDTO(50, 50, 50));

        PedidoDTO pedido = new PedidoDTO(1, List.of(produto1, produto2, produto3));
        ListaPedidosDTO listaPedidos = new ListaPedidosDTO(List.of(pedido));

        PedidoProcessadoDTO resultado = pedidoService.processarPedidos(listaPedidos);

        assertNotNull(resultado);
        assertEquals(1, resultado.getPedidos().size());

        List<CaixaDTO> caixas = resultado.getPedidos().get(0).getCaixas();
        assertFalse(caixas.isEmpty());

    }

    @Test
    void deveRetornarErroQuandoProdutoNaoCabeEmNenhumaCaixa() {

        ProdutoDTO produtoGrande = new ProdutoDTO("Produto Gigante", new DimensoesDTO(200, 200, 200));
        PedidoDTO pedido = new PedidoDTO(2, List.of(produtoGrande));
        ListaPedidosDTO listaPedidos = new ListaPedidosDTO(List.of(pedido));

        PedidoProcessadoDTO resultado = pedidoService.processarPedidos(listaPedidos);

        assertNotNull(resultado);
        assertEquals(1, resultado.getPedidos().size());
        assertEquals("Produto não cabe em nenhuma caixa disponível.", resultado.getPedidos().get(0).getCaixas().get(0).getObservacao());

    }

}