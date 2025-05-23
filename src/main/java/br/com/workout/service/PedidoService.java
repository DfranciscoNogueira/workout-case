package br.com.workout.service;

import br.com.workout.dto.CaixaDTO;
import br.com.workout.dto.ListaPedidosDTO;
import br.com.workout.dto.PedidoDTO;
import br.com.workout.dto.PedidoEmpacotadoDTO;
import br.com.workout.dto.PedidoProcessadoDTO;
import br.com.workout.dto.ProdutoDTO;
import br.com.workout.enuns.TamanhoCaixa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class PedidoService {

    public PedidoProcessadoDTO processarPedidos(ListaPedidosDTO listaPedidosDTO) {
        List<PedidoEmpacotadoDTO> pedidos = empacotarPedidos(listaPedidosDTO.getPedidos());
        return new PedidoProcessadoDTO(pedidos);
    }

    private List<PedidoEmpacotadoDTO> empacotarPedidos(List<PedidoDTO> pedidos) {

        List<PedidoEmpacotadoDTO> pedidosEmpacotados = new ArrayList<>();

        for (PedidoDTO pedido : pedidos) {
            List<CaixaDTO> caixas = empacotarPedido(pedido);
            pedidosEmpacotados.add(new PedidoEmpacotadoDTO(pedido.getPedidoId(), caixas));
        }

        return pedidosEmpacotados;
    }

    private List<CaixaDTO> empacotarPedido(PedidoDTO pedido) {

        List<CaixaDTO> resultado = new ArrayList<>();

        List<ProdutoDTO> produtosOrdenados = pedido.getProdutos().stream()
                .sorted(Comparator.comparingInt(p -> p.getDimensoes().getAltura() * p.getDimensoes().getLargura() * p.getDimensoes().getComprimento()))
                .toList();

        List<CaixaDTO> caixasDisponiveis = Arrays.asList(
                new CaixaDTO("Caixa 1", TamanhoCaixa.CAIXA_1),
                new CaixaDTO("Caixa 2", TamanhoCaixa.CAIXA_2),
                new CaixaDTO("Caixa 3", TamanhoCaixa.CAIXA_3)
        );

        for (ProdutoDTO produto : produtosOrdenados) {

            boolean produtoEmpacotado = false;

            for (CaixaDTO caixa : caixasDisponiveis) {
                if (caixa.cabeProduto(produto)) {
                    caixa.adicionarProduto(produto);
                    produtoEmpacotado = true;
                    break;
                }
            }

            if (!produtoEmpacotado) {
                CaixaDTO caixaNaoCabem = new CaixaDTO(null, null, "Produto não cabe em nenhuma caixa disponível.");
                caixaNaoCabem.adicionarProduto(produto);
                resultado.add(caixaNaoCabem);
            }

        }

        resultado.addAll(caixasDisponiveis.stream().filter(c -> !c.getProdutos().isEmpty()).toList());

        return resultado;
    }

}