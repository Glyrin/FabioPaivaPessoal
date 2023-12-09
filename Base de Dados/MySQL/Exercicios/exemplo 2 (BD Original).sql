CREATE DATABASE livros;
USE livros;

CREATE TABLE utilizadores(
	id INT
		AUTO_INCREMENT,
    nome VARCHAR (100),
    username CHAR(9)
		NOT NULL,
    ativo BOOLEAN
		DEFAULT FALSE,
    ultimo_login TIMESTAMP
		DEFAULT CURRENT_TIMESTAMP
		ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE enderecos(
	id INT
		AUTO_INCREMENT,
    arruamento VARCHAR (50)
		NOT NULL,
	cidade VARCHAR (50),
    distrito VARCHAR (50),
	utilizador_id INT,
    PRIMARY KEY (id),
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
	autor VARCHAR(100)
		NOT NULL,
	data_publicacao DATE
		NOT NULL,
	isbn CHAR(12),
	PRIMARY KEY (id),
    UNIQUE(isbn)
);

CREATE TABLE criticas(
	id INT
		AUTO_INCREMENT,
	nome_critico VARCHAR(100)
		NOT NULL,
	conteudo LONGTEXT,
    classificacao FLOAT,
    data_critica TIMESTAMP
		DEFAULT CURRENT_TIMESTAMP,
	livro_id INT
		NOT NULL,
    PRIMARY KEY (id),
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