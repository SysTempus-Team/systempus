INSERT INTO profissional(cpf, nome, telefone) VALUES ('00000000000', 'Marcelo', '900000000');
INSERT INTO profissional(cpf, nome, telefone) VALUES ('11111111111', 'Itair', '911111111');
INSERT INTO profissional(cpf, nome, telefone) VALUES ('22222222222', 'Roussian', '922222222');
INSERT INTO profissional(cpf, nome, telefone) VALUES ('33333333333', 'Kelly', '933333333');
INSERT INTO profissional(cpf, nome, telefone) VALUES ('44444444444', 'Susana', '944444444');
INSERT INTO profissional(cpf, nome, telefone) VALUES ('55555555555', 'Galdino', '955555555');
INSERT INTO profissional(cpf, nome, telefone) VALUES ('12345678901', 'Tércia', '912345678');
INSERT INTO profissional(cpf, nome, telefone) VALUES ('09876543211', 'Rafael', '909876543');
INSERT INTO profissional(cpf, nome, telefone) VALUES ('78945612331', 'Gustavo', '922345678');
INSERT INTO profissional(cpf, nome, telefone) VALUES ('78945612331', 'Daniele', '988888888');

INSERT INTO coordenador(id) VALUES(4);
INSERT INTO coordenador(id) VALUES(5);
INSERT INTO coordenador(id) VALUES(9);

INSERT INTO professor(id) VALUES(1);
INSERT INTO professor(id) VALUES(2);
INSERT INTO professor(id) VALUES(3);
INSERT INTO professor(id) VALUES(6);
INSERT INTO professor(id) VALUES(7);
INSERT INTO professor(id) VALUES(8);

INSERT INTO curso(carga_Total, modalidade, nivel_Ensino, nome, qtd_Periodos, id_coordenador) VALUES (500, 0, 4, 'Análise e Desenvolvimento de Sistemas', 5, 4);
INSERT INTO curso(carga_Total, modalidade, nivel_Ensino, nome, qtd_Periodos, id_coordenador) VALUES (400, 1, 4, 'Design Gráfico', 4, 5);
INSERT INTO curso(carga_Total, modalidade, nivel_Ensino, nome, qtd_Periodos, id_coordenador) VALUES (350, 2, 4, 'Administrador de Banco de Dados', 8, 9);
INSERT INTO curso(carga_Total, modalidade, nivel_Ensino, nome, qtd_Periodos, id_coordenador) VALUES (400, 2, 4, 'Programador de Sistemas', 8, 9);
INSERT INTO curso(carga_Total, modalidade, nivel_Ensino, nome, qtd_Periodos, id_coordenador) VALUES (400, 2, 4, 'Desenvolvedor Web', 8, 4);

INSERT INTO modulo(numero, data_Inicio, data_Fim, id_curso) VALUES (1, '2023-02-01', '2023-06-15', 1);
INSERT INTO modulo(numero, data_Inicio, data_Fim, id_curso) VALUES (2, '2023-08-01', '2023-12-10', 1);
INSERT INTO modulo(numero, data_Inicio, data_Fim, id_curso) VALUES (2, '2023-02-01', '2023-06-12', 2);
INSERT INTO modulo(numero, data_Inicio, data_Fim, id_curso) VALUES (3, '2023-08-01', '2023-12-15', 2);
INSERT INTO modulo(numero, data_Inicio, data_Fim, id_curso) VALUES (4, '2023-02-01', '2023-06-12', 3);
INSERT INTO modulo(numero, data_Inicio, data_Fim, id_curso) VALUES (4, '2023-08-01', '2023-12-10', 3);

INSERT INTO disciplina(nome, id_modulo) VALUES ('Fundamentos de Redes', 1);
INSERT INTO disciplina(nome, id_modulo) VALUES ('Programação Orientada a Objetos', 2);
INSERT INTO disciplina(nome, id_modulo) VALUES ('Engenharia de Software', 1);
INSERT INTO disciplina(nome, id_modulo) VALUES ('Fundamentos de Banco de Dados', 2);
INSERT INTO disciplina(nome, id_modulo) VALUES ('Fundamento das Cores', 3);
INSERT INTO disciplina(nome, id_modulo) VALUES ('Arte Pré-Histórica', 4);

INSERT INTO professor_curso(id_curso, id_professor) VALUES (1, 1);
INSERT INTO professor_curso(id_curso, id_professor) VALUES (1, 2);
INSERT INTO professor_curso(id_curso, id_professor) VALUES (1, 3);
INSERT INTO professor_curso(id_curso, id_professor) VALUES (2, 6);

INSERT INTO professor_disciplina(id_professor, id_disciplina) VALUES (1, 4);
INSERT INTO professor_disciplina(id_professor, id_disciplina) VALUES (3, 1);
INSERT INTO professor_disciplina(id_professor, id_disciplina) VALUES (2, 2);
INSERT INTO professor_disciplina(id_professor, id_disciplina) VALUES (3, 3);
INSERT INTO professor_disciplina(id_professor, id_disciplina) VALUES (7, 6);