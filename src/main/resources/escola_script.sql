-- Criando as tabelas

CREATE TABLE Professor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Sala (
    id SERIAL PRIMARY KEY,
    numero VARCHAR(10) NOT NULL
);

CREATE TABLE Disciplina (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    professor_id INT NOT NULL,
    FOREIGN KEY (professor_id) REFERENCES Professor(id) ON DELETE CASCADE
);

CREATE TABLE Turma (
    id SERIAL PRIMARY KEY,
    disciplina_id INT NOT NULL,
    sala_id INT NOT NULL,
    horario_inicio TIME NOT NULL,
    horario_fim TIME NOT NULL,
    FOREIGN KEY (disciplina_id) REFERENCES Disciplina(id) ON DELETE CASCADE,
    FOREIGN KEY (sala_id) REFERENCES Sala(id) ON DELETE CASCADE
);

-- Criando massa para teste

INSERT INTO Professor (nome) VALUES
('Professor Girafales'), ('Ana Silva'), ('Carlos Mendes'), ('Beatriz Costa'),
('Daniel Souza'), ('Eduardo Lima'), ('Fernanda Oliveira'), ('Gabriel Santos'),
('Helena Martins'), ('Igor Ferreira'), ('Juliana Almeida'), ('Lucas Rocha'),
('Mariana Castro'), ('Nathan Oliveira'), ('Olivia Cardoso'), ('Pedro Marques'),
('Quésia Rangel'), ('Rafael Teixeira'), ('Simone Bastos'), ('Thiago Vasconcelos');

INSERT INTO Sala (numero) VALUES
('101'), ('102'), ('103'), ('104'), ('105'), ('106'), ('107'), ('108'), ('109'), ('110'),
('201'), ('202'), ('203'), ('204'), ('205'), ('206'), ('207'), ('208'), ('209'), ('210');

INSERT INTO Disciplina (nome, professor_id) VALUES
('Matemática', 1), ('Português', 2), ('História', 3), ('Geografia', 4),
('Biologia', 5), ('Física', 6), ('Química', 7), ('Artes', 8),
('Educação Física', 9), ('Filosofia', 10), ('Sociologia', 11), ('Inglês', 12),
('Espanhol', 13), ('Computação', 14), ('Robótica', 15), ('Música', 16),
('Psicologia', 17), ('Administração', 18), ('Economia', 19), ('Direito', 20);

INSERT INTO Turma (disciplina_id, sala_id, horario_inicio, horario_fim) VALUES
(1, 1, '08:00', '10:00'), (2, 2, '10:00', '12:00'), (3, 3, '13:00', '15:00'), (4, 4, '15:00', '17:00'),
(5, 5, '17:00', '19:00'), (6, 6, '08:30', '10:30'), (7, 7, '10:30', '12:30'), (8, 8, '13:30', '15:30'),
(9, 9, '15:30', '17:30'), (10, 10, '17:30', '19:30'), (11, 11, '08:00', '09:30'), (12, 12, '09:30', '11:00'),
(13, 13, '11:00', '12:30'), (14, 14, '13:00', '14:30'), (15, 15, '14:30', '16:00'), (16, 16, '16:00', '17:30'),
(17, 17, '17:30', '19:00'), (18, 18, '08:00', '09:30'), (19, 19, '09:30', '11:00'), (20, 20, '11:00', '12:30');

-- Consulta SQL - Horas de Aula por Professor

SELECT p.nome AS professor, SUM(EXTRACT(HOUR FROM (t.horario_fim - t.horario_inicio))) AS horas_comprometidas FROM Professor p
JOIN Disciplina d ON d.professor_id = p.id
JOIN Turma t ON t.disciplina_id = d.id
GROUP BY p.nome;

-- Consulta SQL - Salas Livres e Ocupadas

SELECT s.numero AS sala,
       CASE
           WHEN t.id IS NULL THEN 'Livre'
           ELSE 'Ocupado'
       END AS status,
       t.horario_inicio,
       t.horario_fim
FROM Sala s
LEFT JOIN Turma t ON t.sala_id = s.id
ORDER BY s.numero, t.horario_inicio;