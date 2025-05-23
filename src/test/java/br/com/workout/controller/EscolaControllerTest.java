package br.com.workout.controller;

import br.com.workout.service.EscolaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EscolaControllerTest {

    @Mock
    private EscolaService escolaService;

    @InjectMocks
    private EscolaController escolaController;

    @Test
    void deveRetornarHorasComprometidasPorProfessor() {

        when(escolaService.getHorasComprometidasPorProfessor()).thenReturn(List.of(
                new Object[]{"Professor Girafales", 10},
                new Object[]{"Ana Silva", 12}
        ));

        List<Object[]> resultado = escolaController.getHorasComprometidas();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Professor Girafales", resultado.get(0)[0]);
        assertEquals(10, resultado.get(0)[1]);
        verify(escolaService, times(1)).getHorasComprometidasPorProfessor();

    }

    @Test
    void deveRetornarSalasComStatus() {

        when(escolaService.getSalasComStatus()).thenReturn(List.of(
                new Object[]{"101", "Livre", null, null},
                new Object[]{"102", "Ocupado", "08:00", "10:00"}
        ));

        List<Object[]> resultado = escolaController.getSalasComStatus();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("101", resultado.get(0)[0]);
        assertEquals("Livre", resultado.get(0)[1]);
        verify(escolaService, times(1)).getSalasComStatus();

    }

}