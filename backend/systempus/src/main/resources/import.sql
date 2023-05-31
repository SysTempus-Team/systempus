INSERT INTO tb_profissional(cpf, nome, telefone) VALUES ('000.000.000-00', 'Marcelo', '9-0000-0000');
INSERT INTO tb_profissional(cpf, nome, telefone) VALUES ('111.111.111-11', 'Itair', '9-1111-1111');
INSERT INTO tb_profissional(cpf, nome, telefone) VALUES ('222.222.222-22', 'Roussian', '9-2222-2222');
INSERT INTO tb_profissional(cpf, nome, telefone) VALUES ('333.333.333-33', 'Kelly', '9-3333-3333');
INSERT INTO tb_profissional(cpf, nome, telefone) VALUES ('444.444.444-44', 'Susana', '9-4444-4444');

INSERT INTO tb_coordenador(id) VALUES(4);
INSERT INTO tb_coordenador(id) VALUES(5);

INSERT INTO tb_professor(id) VALUES(1);
INSERT INTO tb_professor(id) VALUES(2);
INSERT INTO tb_professor(id) VALUES(3);

INSERT INTO tb_curso(carga_total, modalidade, nivel_ensino, nome, qtd_periodos, coordenador) VALUES (500, 0, 4, 'Análise e Desenvolvimento de Sistemas', 5, 4);
INSERT INTO tb_curso(carga_total, modalidade, nivel_ensino, nome, qtd_periodos, coordenador) VALUES (400, 1, 4, 'Design Gráfico', 4, 5);
INSERT INTO tb_curso(carga_total, modalidade, nivel_ensino, nome, qtd_periodos, coordenador) VALUES (400, 2, 4, 'Administrador de Banco de Dados', 8, 4);

INSERT INTO tb_modulo(numero, data_Inicio, data_Fim) VALUES (1, '01-02-2023', '15-06-2023');
INSERT INTO tb_modulo(numero, data_Inicio, data_Fim) VALUES (1, '01-08-2023', '10-12-2023');

INSERT INTO tb_disciplina(nome) VALUES ('Fundamentos de Redes');
INSERT INTO tb_disciplina(nome) VALUES ('Programação Orientada a Objetos');

INSERT INTO tb_professor_cursos(professor_id, cursos_id) VALUES (1, 1);--Marcelo
INSERT INTO tb_professor_cursos(professor_id, cursos_id) VALUES (2, 1);--Itair
INSERT INTO tb_professor_cursos(professor_id, cursos_id) VALUES (3, 1);--Roussian

INSERT INTO tb_disciplina_professores(disciplina_id, professores_id) VALUES (1, 3);
INSERT INTO tb_disciplina_professores(disciplina_id, professores_id) VALUES (2, 1);
