DROP TABLE IF EXISTS professor_curso;
DROP TABLE IF EXISTS professor_disciplina;
DROP TABLE IF EXISTS curso_modulo;
DROP TABLE IF EXISTS coordenador_curso;
DROP TABLE IF EXISTS disciplina;
DROP TABLE IF EXISTS modulo;
DROP TABLE IF EXISTS professor;
DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS coordenador;
DROP TABLE IF EXISTS profissional;


CREATE TABLE profissional(
    id serial primary key,
    cpf varchar(11) not null,
    nome varchar(100) not null,
    telefone varchar(11) not null
);

CREATE TABLE professor(
    id integer primary key,

    constraint rel_professor_profissional foreign key(id) references profissional
);

CREATE TABLE coordenador(
    id integer primary key,

    constraint rel_coordenador_profissional foreign key (id) references profissional
);

CREATE TABLE curso(
    id serial primary key,
    nome varchar(150) not null,
    nivel_Ensino integer not null,
    modalidade integer not null,
    qtd_Periodos integer not null,
    carga_Total integer,
    id_coordenador integer,

    constraint rel_curso_coordenador foreign key(id_coordenador) references coordenador
);

CREATE TABLE modulo(
    id serial primary key,
    numero integer not null,
    data_Inicio date not null,
    data_Fim date not null,
    id_curso integer,

    constraint rel_modulo_curso foreign key(id_curso) references curso
);

CREATE TABLE disciplina(
    id serial primary key,
    nome varchar(100) not null,
    id_modulo integer,

    constraint rel_disciplina_modulo foreign key(id_modulo) references modulo
);

CREATE TABLE professor_curso(
    id_professor integer,
    id_curso integer,

    PRIMARY KEY (id_professor, id_curso),

    constraint rel_professor_curso_curso foreign key (id_curso) references curso,
    constraint rel_professor_curso_professor foreign key(id_professor) references professor
);

CREATE TABLE professor_disciplina(
    id_professor integer,
    id_disciplina integer,

    PRIMARY KEY (id_professor, id_disciplina),

    constraint rel_professor_disciplina_professor foreign key(id_professor) references professor,
    constraint rel_professor_disciplina_disciplina foreign key(id_disciplina) references disciplina
);