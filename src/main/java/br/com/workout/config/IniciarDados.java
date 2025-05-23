package br.com.workout.config;

import br.com.workout.model.Disciplina;
import br.com.workout.model.Professor;
import br.com.workout.model.Sala;
import br.com.workout.model.Turma;
import br.com.workout.repository.DisciplinaRepository;
import br.com.workout.repository.ProfessorRepository;
import br.com.workout.repository.SalaRepository;
import br.com.workout.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class IniciarDados implements CommandLineRunner {

    private final DisciplinaRepository disciplinaRepository;

    private final ProfessorRepository professorRepository;

    private final TurmaRepository turmaRepository;

    private final SalaRepository salaRepository;

    private List<Disciplina> disciplinas;
    private List<Professor> professores;
    private List<Sala> salas;

    @Autowired
    public IniciarDados(DisciplinaRepository disciplinaRepository, ProfessorRepository professorRepository, TurmaRepository turmaRepository, SalaRepository salaRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
        this.turmaRepository = turmaRepository;
        this.salaRepository = salaRepository;
    }

    @Override
    public void run(String... args) {
        this.criarProfessores();
        this.criarSalas();
        this.criarDisciplinas();
        this.criarTurmas();
    }

    private void criarProfessores() {
        List<Professor> lista = new ArrayList<>();
        lista.add(new Professor("Professor Girafales"));
        lista.add(new Professor("Ana Silva"));
        lista.add(new Professor("Carlos Mendes"));
        lista.add(new Professor("Beatriz Costa"));
        lista.add(new Professor("Daniel Souza"));
        lista.add(new Professor("Eduardo Lima"));
        lista.add(new Professor("Fernanda Oliveira"));
        lista.add(new Professor("Gabriel Santos"));
        lista.add(new Professor("Helena Martins"));
        lista.add(new Professor("Igor Ferreira"));
        lista.add(new Professor("Juliana Almeida"));
        lista.add(new Professor("Lucas Rocha"));
        lista.add(new Professor("Mariana Castro"));
        lista.add(new Professor("Nathan Oliveira"));
        lista.add(new Professor("Olivia Cardoso"));
        lista.add(new Professor("Pedro Marques"));
        lista.add(new Professor("Quésia Rangel"));
        lista.add(new Professor("Rafael Teixeira"));
        lista.add(new Professor("Simone Bastos"));
        lista.add(new Professor("Thiago Vasconcelos"));
        this.professores = this.professorRepository.saveAll(lista);
    }

    private void criarSalas() {
        List<Sala> lista = List.of(
                new Sala("101"), new Sala("102"), new Sala("103"), new Sala("104"), new Sala("105"),
                new Sala("106"), new Sala("107"), new Sala("108"), new Sala("109"), new Sala("110"),
                new Sala("201"), new Sala("202"), new Sala("203"), new Sala("204"), new Sala("205"),
                new Sala("206"), new Sala("207"), new Sala("208"), new Sala("209"), new Sala("210")
        );
        this.salas = this.salaRepository.saveAll(lista);
    }

    private void criarDisciplinas() {
        List<Disciplina> lista = List.of(
                new Disciplina("Matemática", professores.get(0)), new Disciplina("Português", professores.get(1)),
                new Disciplina("História", professores.get(2)), new Disciplina("Geografia", professores.get(3)),
                new Disciplina("Biologia", professores.get(4)), new Disciplina("Física", professores.get(5)),
                new Disciplina("Química", professores.get(6)), new Disciplina("Artes", professores.get(7)),
                new Disciplina("Educação Física", professores.get(8)), new Disciplina("Filosofia", professores.get(9)),
                new Disciplina("Sociologia", professores.get(10)), new Disciplina("Inglês", professores.get(11)),
                new Disciplina("Espanhol", professores.get(12)), new Disciplina("Computação", professores.get(13)),
                new Disciplina("Robótica", professores.get(14)), new Disciplina("Música", professores.get(15)),
                new Disciplina("Psicologia", professores.get(16)), new Disciplina("Administração", professores.get(17)),
                new Disciplina("Economia", professores.get(18)), new Disciplina("Direito", professores.get(19))
        );
        this.disciplinas = this.disciplinaRepository.saveAll(lista);
    }

    private void criarTurmas() {
        List<Turma> lista = List.of(
                new Turma(disciplinas.get(0), salas.get(0), LocalTime.of(8, 0), LocalTime.of(10, 0)),
                new Turma(disciplinas.get(1), salas.get(1), LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new Turma(disciplinas.get(2), salas.get(2), LocalTime.of(13, 0), LocalTime.of(15, 0)),
                new Turma(disciplinas.get(3), salas.get(3), LocalTime.of(15, 0), LocalTime.of(17, 0)),
                new Turma(disciplinas.get(4), salas.get(4), LocalTime.of(17, 0), LocalTime.of(19, 0)),
                new Turma(disciplinas.get(5), salas.get(5), LocalTime.of(8, 30), LocalTime.of(10, 30)),
                new Turma(disciplinas.get(6), salas.get(6), LocalTime.of(10, 30), LocalTime.of(12, 30)),
                new Turma(disciplinas.get(7), salas.get(7), LocalTime.of(13, 30), LocalTime.of(15, 30)),
                new Turma(disciplinas.get(8), salas.get(8), LocalTime.of(15, 30), LocalTime.of(17, 30)),
                new Turma(disciplinas.get(9), salas.get(9), LocalTime.of(17, 30), LocalTime.of(19, 30)),
                new Turma(disciplinas.get(10), salas.get(10), LocalTime.of(8, 0), LocalTime.of(9, 30)),
                new Turma(disciplinas.get(11), salas.get(11), LocalTime.of(9, 30), LocalTime.of(11, 0)),
                new Turma(disciplinas.get(12), salas.get(12), LocalTime.of(11, 0), LocalTime.of(12, 30)),
                new Turma(disciplinas.get(13), salas.get(13), LocalTime.of(13, 0), LocalTime.of(14, 30)),
                new Turma(disciplinas.get(14), salas.get(14), LocalTime.of(14, 30), LocalTime.of(16, 0)),
                new Turma(disciplinas.get(15), salas.get(15), LocalTime.of(16, 0), LocalTime.of(17, 30)),
                new Turma(disciplinas.get(16), salas.get(16), LocalTime.of(17, 30), LocalTime.of(19, 0)),
                new Turma(disciplinas.get(17), salas.get(17), LocalTime.of(8, 0), LocalTime.of(9, 30)),
                new Turma(disciplinas.get(18), salas.get(18), LocalTime.of(9, 30), LocalTime.of(11, 0)),
                new Turma(disciplinas.get(19), salas.get(19), LocalTime.of(11, 0), LocalTime.of(12, 30))
        );
        this.turmaRepository.saveAll(lista);
    }

}