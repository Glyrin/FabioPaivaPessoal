CREATE DATABASE livros_v2;
USE livros_v2;

CREATE TABLE perfis(
	id INT
		AUTO_INCREMENT,
	nome_perfil VARCHAR (10),
    PRIMARY KEY (id)
);

CREATE TABLE utilizadores(
	id INT
		AUTO_INCREMENT,
    nome VARCHAR (100),
    username CHAR (9)
		NOT NULL
        UNIQUE,
    ativo BOOLEAN
		DEFAULT FALSE,
    ultimo_login TIMESTAMP
		DEFAULT CURRENT_TIMESTAMP
		ON UPDATE CURRENT_TIMESTAMP,
	perfil_id INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_perfis_utilizadores
    FOREIGN KEY (perfil_id)
		REFERENCES perfis(id)
);

CREATE TABLE distritos(
	id INT
		AUTO_INCREMENT,
   	nome_distrito VARCHAR (50),
    PRIMARY KEY (id)
);

CREATE TABLE cidades(
	id INT
		AUTO_INCREMENT,
   	nome_cidade VARCHAR (50),
    distrito_id INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_distritos_cidades
    FOREIGN KEY (distrito_id)
		REFERENCES distritos(id)
);

CREATE TABLE enderecos(
	id INT
		AUTO_INCREMENT,
    arruamento VARCHAR (50)
		NOT NULL,
	num_porta INT,
	cidade_id INT,
	utilizador_id INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_enderecos_cidades
    FOREIGN KEY (cidade_id)
		REFERENCES cidades(id),
    CONSTRAINT fk_enderecos_utilizadores
    FOREIGN KEY (utilizador_id)
		REFERENCES utilizadores(id)
		ON DELETE CASCADE
);

CREATE TABLE livros(
	id INT
		AUTO_INCREMENT,
    titulo VARCHAR(100)
		NOT NULL,
	autor_id INT,
	data_publicacao DATE
		NOT NULL,
	isbn CHAR(12),
	PRIMARY KEY (id),
    CONSTRAINT fk_livros_autores
    FOREIGN KEY (autor_id)
		REFERENCES utilizadores(id),
    UNIQUE(isbn)
);

CREATE TABLE criticas(
	id SERIAL,
	critico_id INT,
	conteudo LONGTEXT,
    classificacao FLOAT,
		CONSTRAINT check_classificacao
		CHECK (classificacao BETWEEN 0 AND 5),
    data_critica TIMESTAMP
		DEFAULT CURRENT_TIMESTAMP,
	livro_id INT
		NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_criticas_critico
    FOREIGN KEY (critico_id)
		REFERENCES utilizadores(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_criticas_livros
    FOREIGN KEY (livro_id)
		REFERENCES livros(id)
        ON DELETE CASCADE
);

CREATE TABLE requisicoes(
	id SERIAL,
	levantamento_data TIMESTAMP
		NULL
        DEFAULT CURRENT_TIMESTAMP,
	entrega_data TIMESTAMP
		NULL
        DEFAULT NULL,
	utilizador_id INT
		NOT NULL,
	livro_id INT
		NOT NULL,
	PRIMARY KEY (id),
    CONSTRAINT fk_requisicoes_utilizadores
    FOREIGN KEY (utilizador_id)
		REFERENCES utilizadores(id)
		ON DELETE CASCADE,
	CONSTRAINT fk_requisicoes_livros
	FOREIGN KEY (livro_id)
		REFERENCES livros(id)
		ON DELETE CASCADE
);