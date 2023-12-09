create database EMPRESATAXIS;

use EMPRESATAXIS;

create table PAISES(
	ID_Pais smallint auto_increment,
	Nome_Pais varchar (30) not null,
    primary key (ID_Pais)
);

create table CIDADES(
	ID_Cidade int auto_increment,
    Nome_Cidade varchar (30) not null,
    FK_Pais smallint not null,
    primary key (ID_Cidade),
	constraint FK_CIDADES_PAISES foreign key (FK_Pais) references PAISES(ID_Pais) on delete cascade
);

create table LOCALIDADES(
	ID_Localidade int auto_increment,
    Nome_Localidade varchar(50) not null,
    FK_Cidade int not null,
    primary key (ID_Localidade),
    constraint FK_LOCALIDADES_CIDADES foreign key (FK_Cidade) references CIDADES(ID_Cidade) on delete cascade
);

create table CODIGOS_POSTAIS(
	ID_CodigoPostal int auto_increment,
    Codigo_Postal varchar(10) not null,
    FK_Localidade int not null,
    primary key (ID_CodigoPostal),
    constraint FK_CODIGOSPOSTAIS_LOCALIDADES foreign key (FK_Localidade) references LOCALIDADES(ID_Localidade) on delete cascade
);

create table MORADAS(
	ID_Morada bigint auto_increment,
	Arruamento varchar(50) not null,
	NumPorta smallint not null,
	Andar varchar (20),
	FK_CodigoPostal int not null,
	primary key (ID_Morada),
	constraint FK_MORADAS_CODIGOSPOSTAIS foreign key (FK_CodigoPostal) references CODIGOS_POSTAIS(ID_CodigoPostal) on delete cascade
);

create table FUNCOES(
	ID_Funcao tinyint auto_increment,
    Nome_Funcao varchar(30) not null,
    primary key (ID_Funcao)
);

create table CONDUTORES (
	ID_Condutor smallint auto_increment,
    NomesProprios varchar(50) not null,
    NomeFamilia varchar(50) not null,
    NumCarta varchar(10) not null unique,
    DataNascimento date not null,
    FK_Morada bigint not null,
    FK_Funcao tinyint not null,    
    primary key (ID_Condutor),
    constraint FK_CONDUTORES_MORADAS foreign key (FK_Morada) references MORADAS(ID_Morada),
    constraint FK_CONDUTORES_FUNCOES foreign key (FK_Funcao) references FUNCOES(ID_Funcao)
);

create table MARCAS (
	ID_Marca tinyint auto_increment,
    NomeMarca varchar(20) not null,
    primary key (ID_Marca)
);

create table MODELOS (
	ID_Modelo int auto_increment,
    NomeModelo varchar(20) not null,
    FK_Marca tinyint,
    primary key (ID_Modelo),
    constraint FK_MODELOS_MARCAS foreign key (FK_Marca) references MARCAS(ID_Marca) on delete cascade
);

create table TAXIS (
	ID_Taxi smallint auto_increment,
    NumMatricula varchar(8) unique not null,
    NumLugares tinyint not null,
    NomeTaxi varchar(20),
    AnoFabrico year not null,
    Cor varchar (20),
    Gps boolean default false,
    FK_Modelo int,
    primary key (ID_Taxi),
    constraint FK_TAXIS_MODELOS foreign key (FK_Modelo) references MODELOS(ID_Modelo) on delete cascade
);

create table CONDUZEM (
	ID_Conducao serial,
    FK_Condutor smallint not null,
    FK_Taxi smallint not null,
    Levantamento datetime not null,
    Entrega datetime,
    primary key (ID_Conducao),
    constraint FK_CONDUZEM_CONDUTORES foreign key (FK_Condutor) references CONDUTORES(ID_Condutor),
    constraint FK_CONDUZEM_TAXIS foreign key (FK_Taxi) references TAXIS(ID_Taxi)
);

create table LOCAIS_PARTIDAS (
	ID_LocalPartida bigint auto_increment,
    FK_Morada bigint,
    primary key (ID_LocalPartida),
    constraint FK_LOCAISPARTIDAS_MORADAS foreign key (FK_Morada) references MORADAS(ID_Morada)
);

create table LOCAIS_CHEGADAS (
	ID_LocalChegada bigint auto_increment,
    FK_Morada bigint,
    primary key (ID_LocalChegada),
    constraint FK_LOCAISCHEGADAS_MORADAS foreign key (FK_Morada) references MORADAS(ID_Morada)
);

create table VIAGENS (
	ID_Viagem serial,
    InfoPartida datetime not null,
    InfoChegada datetime,
    NumPassageiros tinyint not null,
    PrecoViagem decimal(4,2),
    FK_LocalPartida bigint not null,
    FK_LocalChegada bigint,
    FK_Taxi smallint not null,
    primary key (ID_Viagem),
    constraint FK_VIAGENS_LOCAISPARTIDAS foreign key (FK_LocalPartida) references LOCAIS_PARTIDAS(ID_LocalPartida),
    constraint FK_VIAGENS_LOCAISCHEGADAS foreign key (FK_LocalChegada) references LOCAIS_CHEGADAS(ID_LocalChegada),
    constraint FK_VIAGENS_TAXIS foreign key (FK_Taxi) references TAXIS(ID_Taxi)
);