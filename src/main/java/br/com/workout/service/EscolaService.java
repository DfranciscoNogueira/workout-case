package br.com.workout.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> getHorasComprometidasPorProfessor() {
        String sql = """
                    SELECT p.nome AS professor, SUM(EXTRACT(HOUR FROM (t.horario_fim - t.horario_inicio))) AS horas_comprometidas FROM Professor p
                    JOIN Disciplina d ON d.professor_id = p.id
                    JOIN Turma t ON t.disciplina_id = d.id
                    GROUP BY p.nome
                """;
        return entityManager.createNativeQuery(sql).getResultList();
    }

    public List<Object[]> getSalasComStatus() {
        String sql = """
                    SELECT s.numero AS sala,
                           CASE
                               WHEN t.id IS NULL THEN 'Livre'
                               ELSE 'Ocupado'
                           END AS status,
                           t.horario_inicio,
                           t.horario_fim
                    FROM Sala s
                    LEFT JOIN Turma t ON t.sala_id = s.id
                    ORDER BY s.numero, t.horario_inicio
                """;
        return entityManager.createNativeQuery(sql).getResultList();
    }

}
