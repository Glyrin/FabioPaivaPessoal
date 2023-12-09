USE livros;

CREATE TABLE perfis(
	id INT
		AUTO_INCREMENT,
	nome_perfil VARCHAR (10),
    PRIMARY KEY (id)
);

ALTER TABLE utilizadores MODIFY COLUMN username CHAR (9) NOT NULL UNIQUE;
ALTER TABLE utilizadores
	ADD perfil_id INT AFTER ultimo_login,
    ADD CONSTRAINT fk_perfis_utilizadores
		FOREIGN KEY (perfil_id)
			REFERENCES perfis(id);

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
            
ALTER TABLE enderecos ADD num_porta INT AFTER arruamento;
ALTER TABLE enderecos CHANGE COLUMN cidade cidade_id INT;
ALTER TABLE enderecos
	DROP COLUMN distrito;
ALTER TABLE enderecos 
	ADD CONSTRAINT fk_enderecos_cidades
		FOREIGN KEY (cidade_id)
			REFERENCES cidades(id);

ALTER TABLE livros CHANGE COLUMN autor autor_id INT;
ALTER TABLE livros
	ADD CONSTRAINT fk_livros_autores
    FOREIGN KEY (autor_id)
		REFERENCES utilizadores(id)
        ON DELETE CASCADE;

ALTER TABLE criticas CHANGE COLUMN id id SERIAL;
ALTER TABLE criticas CHANGE COLUMN nome_critico critico_id INT;
ALTER TABLE criticas CHANGE COLUMN classificacao classificacao FLOAT,
		ADD CONSTRAINT check_classificacao
		CHECK (classificacao BETWEEN 0 AND 5);
ALTER TABLE criticas
	ADD CONSTRAINT fk_criticas_critico
		FOREIGN KEY (critico_id)
			REFERENCES utilizadores(id)
			ON DELETE CASCADE;