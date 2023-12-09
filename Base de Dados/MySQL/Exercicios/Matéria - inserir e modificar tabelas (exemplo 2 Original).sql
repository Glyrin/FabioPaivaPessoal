CREATE DATABASE livros; -- cria uma base de dados
USE livros; -- seleciona qual a base de dados a utilizar

-- Criação de tabelas numa base de dados:

CREATE TABLE utilizadores(
	id INT
		AUTO_INCREMENT, -- aumenta automaticamente
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
    CONSTRAINT fk_enderecos_utilizadores -- define o nome que a coluna de chave externa vai ter para se se quiser apagar, caso contrário é dado nome aleatório
    FOREIGN KEY (utilizador_id)
		REFERENCES utilizadores(id)
		ON DELETE CASCADE -- apaga os registos filhos ao apagar o utilizador
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
	id SERIAL, -- SERIAL é um tipo de dado BIGINT, UNSIGNED, NOT NULL, AUTO_INCREMENT, UNIQUE
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

-- MODIFICAÇÃO DE TABELAS:

ALTER TABLE nome_tabela ADD nome_coluna tipo_dado; -- acrescentar uma coluna
ALTER TABLE clientes ADD email VARCHAR(255);

ALTER TABLE nome_tabela ADD nome_coluna tipo_dado, ADD	nome_coluna tipo_dado; -- acrescentar várias colunas de uma vez
ALTER TABLE clientes
	ADD email VARCHAR(255) NOT NULL AFTER nome_cliente, -- acrescenta a coluna depois de outra
	ADD telefone CHAR(9) UNIQUE FIRST; -- acrescenta a coluna logo no início

ALTER TABLE nome_tabela DROP COLUMN nome_coluna; -- eliminar uma coluna
ALTER TABLE clientes DROP COLUMN email;

ALTER TABLE nome_tabela MODIFY COLUMN nome_coluna tipo_dado; -- modificar tipo de dado
ALTER TABLE clientes MODIFY COLUMN email CHAR(12);

ALTER TABLE nome_tabela CHANGE COLUMN nome_atual nome_novo TIPO_DADOS; -- mudar nome de uma coluna
ALTER TABLE clientes CHANGE COLUMN email contacto_email VARCHAR(255);

ALTER TABLE clientes DROP PRIMARY KEY; -- remove a chave primária de uma coluna depois de já ter sido criada
ALTER TABLE clientes ADD PRIMARY KEY (telefone); -- selecionar uma coluna como chave primária depois da tabela criada

ALTER TABLE encomendas
	ADD CONSTRAINT fk_encomendas_clientes
	ADD FOREIGN KEY(cliente_telefone) REFERENCES clientes(telefone); -- acrescenta chaves externas,
    -- garantir que a tabela que vai receber a informação da chave externa já existe, senão acrescentar antes de adicionar a chave

ALTER TABLE encomendas DROP FOREIGN KEY fk_encomendas_clientes -- dropa a chave externa de uma tabela