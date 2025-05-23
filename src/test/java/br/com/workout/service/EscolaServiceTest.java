package br.com.workout.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EscolaServiceTest {

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private EscolaService escolaService;

    @Mock
    private Query queryMock;

    @BeforeEach
    void setUp() {
        when(entityManager.createNativeQuery(anyString())).thenReturn(queryMock);
    }

    @Test
    void deveRetornarHorasComprometidasPorProfessor() {

        when(queryMock.getResultList()).thenReturn(List.of(
                new Object[]{"Professor Girafales", 10},
                new Object[]{"Ana Silva", 12}
        ));

        List<Object[]> resultado = escolaService.getHorasComprometidasPorProfessor();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Professor Girafales", resultado.get(0)[0]);
        assertEquals(10, resultado.get(0)[1]);

    }

    @Test
    void deveRetornarSalasComStatus() {

        when(queryMock.getResultList()).thenReturn(List.of(
                new Object[]{"101", "Livre", null, null},
                new Object[]{"102", "Ocupado", "08:00", "10:00"}
        ));

        List<Object[]> resultado = escolaService.getSalasComStatus();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("101", resultado.get(0)[0]);
        assertEquals("Livre", resultado.get(0)[1]);
        assertEquals("Ocupado", resultado.get(1)[1]);

    }

}