CREATE DATABASE empresa_importacao;
USE empresa_importacao;

CREATE TABLE fornecedores (
	cod_fornecedor INT
		AUTO_INCREMENT,
    nome_fornecedor VARCHAR(50),
    PRIMARY KEY (cod_fornecedor)
);

CREATE TABLE telefones (
	cod_telefone INT
		AUTO_INCREMENT,
    num_telefone INT
		NOT NULL,
    fk_codfornecedor INT,
    PRIMARY KEY (cod_telefone),
    FOREIGN KEY (fk_codfornecedor)
		REFERENCES fornecedores(cod_fornecedor)
        ON DELETE CASCADE
);

CREATE TABLE faxes (
	cod_fax INT
		AUTO_INCREMENT,
    num_fax INT
		NOT NULL,
    fk_codfornecedor INT,
    PRIMARY KEY (cod_fax),
    FOREIGN KEY (fk_codfornecedor)
		REFERENCES fornecedores(cod_fornecedor)
        ON DELETE CASCADE
);

CREATE TABLE paises (
	cod_pais INT
		AUTO_INCREMENT,
	Nome_pais VARCHAR(50),
    PRIMARY KEY (cod_pais)
);

CREATE TABLE cidades (
	cod_cidade INT
		AUTO_INCREMENT,
	nome_cidade VARCHAR (50),
    fk_codpais INT,
    PRIMARY KEY (cod_cidade),
    FOREIGN KEY (fk_codpais)
		REFERENCES paises(cod_pais)
);

CREATE TABLE localidades (
	cod_localidade INT
		AUTO_INCREMENT,
	nome_localidade VARCHAR (50),
    fk_codcidade INT,
    PRIMARY KEY (cod_localidade),
    FOREIGN KEY (fk_codcidade)
		REFERENCES cidades(cod_cidade)
);

CREATE TABLE codigos_postais (
	cod_codigopostal INT
		AUTO_INCREMENT,
	codigopostal VARCHAR (8),
    fk_codlocalidade INT,
    PRIMARY KEY (cod_codigopostal),
    FOREIGN KEY (fk_codlocalidade)
		REFERENCES localidades(cod_localidade)
);

CREATE TABLE moradas (
	cod_morada INT
		AUTO_INCREMENT,
	arruamento VARCHAR (10),
    num_porta INT,
    andar VARCHAR (20),
    fk_codcodigopostal INT,
    fk_codfornecedor INT,
    PRIMARY KEY (cod_morada),
    FOREIGN KEY (fk_codcodigopostal)
		REFERENCES codigos_postais(cod_codigopostal),
	FOREIGN KEY (fk_codfornecedor)
		REFERENCES fornecedores(cod_fornecedor)
);

CREATE TABLE produtos (
	cod_produto INT
		AUTO_INCREMENT,
	nome_produto VARCHAR(50),
	unidade_medida VARCHAR(15),
	PRIMARY KEY (cod_produto)
);

CREATE TABLE tipos_transportes (
	cod_tipotransporte INT
		AUTO_INCREMENT,
    nome_tipotransporte VARCHAR(20),
    PRIMARY KEY (cod_tipotransporte)
);

CREATE TABLE transportes (
	num_transporte SERIAL,
	data_partida DATE,
    data_chegada DATE,
    fk_codtipotransporte INT,
    PRIMARY KEY (num_transporte),
    FOREIGN KEY (fk_codtipotransporte)
		REFERENCES tipos_transportes(cod_tipotransporte)
);

CREATE TABLE mercadorias (
	cod_mercadoria INT
		AUTO_INCREMENT,
    nome_mercadoria VARCHAR (30),
    fk_codproduto INT,
    fk_codfornecedor INT,
    fk_numtransporte INT,
    PRIMARY KEY (cod_mercadoria),
    FOREIGN KEY (fk_codproduto)
		REFERENCES produtos(cod_produto),
	FOREIGN KEY (fk_codfornecedor)
		REFERENCES fornecedores(cod_fornecedor),
	FOREIGN KEY (fk_numtransporte)
		REFERENCES transportes(num_transporte)
);

CREATE TABLE quantidades_compradas (

);

CREATE TABLE precos_unitarios (

);

CREATE TABLE moedas (

);

CREATE TABLE contratos (

);