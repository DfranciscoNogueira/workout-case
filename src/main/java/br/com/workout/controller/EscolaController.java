package br.com.workout.controller;

import br.com.workout.service.EscolaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/escola")
@Tag(name = "Escola", description = "Endpoints para consultar informações acadêmicas")
public class EscolaController {

    private final EscolaService escolaService;

    @Autowired
    public EscolaController(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @GetMapping("/professores/horas")
    @Operation(summary = "Obter horas comprometidas por professor", description = "Consulta a carga horária total de cada professor baseada nas aulas que ministra.")
    public List<Object[]> getHorasComprometidas() {
        return escolaService.getHorasComprometidasPorProfessor();
    }

    @GetMapping("/salas/status")
    @Operation(summary = "Obter status das salas", description = "Retorna uma lista das salas com horários livres e ocupados.")
    public List<Object[]> getSalasComStatus() {
        return escolaService.getSalasComStatus();
    }

}
