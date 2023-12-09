CREATE DATABASE rede_social;
USE rede_social;

CREATE TABLE utilizadores(
	id_utilizador INT
		AUTO_INCREMENT,
    login_utilizador VARCHAR(30)
		NOT NULL,
    nomes_proprios VARCHAR(30),
    nomes_familia VARCHAR(30),
    email VARCHAR(20)
		NOT NULL,
    PRIMARY KEY (id_utilizador)
);

CREATE TABLE posts(
	cod_post INT
		AUTO_INCREMENT,
    texto_post TEXT,
    id_utilizador INT,
    PRIMARY KEY (cod_post),
    FOREIGN KEY (id_utilizador)
		REFERENCES utilizadores(id_utilizador)
        ON DELETE CASCADE
);

CREATE TABLE comentarios(
	id_comentario INT
		AUTO_INCREMENT,
    num_comentario INT,
    texto_comentario TEXT,
    cod_post INT,
    id_utilizador INT,
    PRIMARY KEY (id_comentario),
    FOREIGN KEY (cod_post)
		REFERENCES posts(cod_post)
        ON DELETE CASCADE,
    FOREIGN KEY (id_utilizador)
		REFERENCES utilizadores(id_utilizador)
        ON DELETE CASCADE
);

CREATE TABLE etiquetas(
	cod_etiqueta INT
		AUTO_INCREMENT,
	nome_etiqueta VARCHAR(10),
    PRIMARY KEY (cod_etiqueta)
);

CREATE TABLE seguem(
	id INT
		AUTO_INCREMENT,
    seguidor INT,
    seguido INT,
    PRIMARY KEY (id),
    FOREIGN KEY (seguidor)
		REFERENCES utilizadores(id_utilizador)
        ON DELETE CASCADE,
    FOREIGN KEY (seguido)
		REFERENCES utilizadores(id_utilizador)
        ON DELETE CASCADE
);

CREATE TABLE seguidos(
	id INT
		AUTO_INCREMENT,
    seguido INT,
    seguidor INT,
    PRIMARY KEY (id),
    FOREIGN KEY (seguidor)
		REFERENCES utilizadores(id_utilizador)
        ON DELETE CASCADE,
    FOREIGN KEY (seguido)
		REFERENCES utilizadores(id_utilizador)
        ON DELETE CASCADE
    );
    
CREATE TABLE reagem_a(
	id INT
		AUTO_INCREMENT,
	cod_post INT,
    id_utilizador INT,
    PRIMARY KEY (id),
    FOREIGN KEY (cod_post)
		REFERENCES posts(cod_post)
        ON DELETE CASCADE,
    FOREIGN KEY (id_utilizador)
		REFERENCES utilizadores(id_utilizador)
        ON DELETE CASCADE
);

CREATE TABLE etiquetas_posts(
	id BIGINT,
    cod_post INT,
    cod_etiqueta INT,
    PRIMARY KEY (id),
    FOREIGN KEY (cod_post)
		REFERENCES posts(cod_post)
        ON DELETE CASCADE,
    FOREIGN KEY (cod_etiqueta)
		REFERENCES etiquetas(cod_etiqueta)
        ON DELETE CASCADE
);