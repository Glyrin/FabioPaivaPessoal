use empresataxis;

-- Alterações da base de dados
insert into paises(ID_Pais, Nome_Pais) value ('-1', 'Sem País');

insert into cidades(ID_Cidade, Nome_Cidade, FK_Pais) value ('-1', 'Sem Cidade', '-1');
ALTER TABLE cidades modify COLUMN FK_Pais smallint not null default '-1';

insert into localidades(ID_Localidade, Nome_Localidade, FK_Cidade) value ('-1', 'Sem Localidade', '-1');
ALTER TABLE localidades modify COLUMN FK_Cidade int not null default '-1';

insert into codigos_postais (ID_CodigoPostal, Codigo_Postal, FK_Localidade) value ('-1', '0000-000', '-1');
ALTER TABLE codigos_postais modify column FK_Localidade int not null default '-1';

insert into moradas (ID_Morada, Arruamento, NumPorta, FK_CodigoPostal) value ('-1', 'Morada Desconhecida',0, '-1');
ALTER TABLE moradas modify column FK_CodigoPostal int not null default '-1';

insert into funcoes (ID_Funcao, Nome_Funcao) value ('-1', 'Sem Função');
alter table funcoes modify column Nome_Funcao varchar(30) not null default '-1';

insert into condutores (ID_Condutor, NomesProprios, NomeFamilia, NumCarta, DataNascimento, FK_Morada, FK_Funcao) value ('-1', 'Condutor', 'Desconhecido', 'A-00000000', '0000-00-00', '-1', '-1');
alter table condutores modify column FK_Morada bigint default '-1';
alter table condutores modify column FK_Funcao tinyint default '-1';
alter table condutores drop foreign key FK_CONDUTORES_FUNCOES;
alter table condutores add constraint FK_CONDUTORES_FUNCOES foreign key (FK_Funcao) references FUNCOES(ID_Funcao) on delete set null;
alter table condutores drop foreign key FK_CONDUTORES_MORADAS;
alter table condutores add constraint FK_CONDUTORES_MORADAS foreign key (FK_Morada) references MORADAS(ID_Morada) on delete set null;

insert into marcas (ID_Marca, NomeMarca) value ('-1', 'Sem Marca');

insert into modelos (ID_Modelo, NomeModelo, FK_Marca) value ('-1', 'Sem Modelo', '-1');
alter table modelos modify column FK_Marca tinyint default '-1';

insert into taxis (ID_Taxi, NumMatricula, NumLugares, NomeTaxi, AnoFabrico, FK_Modelo) value ('-1', '00-AA-00', 0,'Taxi Desconhecido', 0000, '-1');
alter table taxis modify column FK_Modelo int default '-1';

alter table conduzem modify column FK_Condutor smallint default '-1';
alter table conduzem modify column FK_Taxi smallint default '-1';
alter table conduzem drop foreign key FK_CONDUZEM_CONDUTORES;
alter table conduzem drop foreign key FK_CONDUZEM_TAXIS;
alter table conduzem add constraint FK_CONDUZEM_CONDUTORES foreign key (FK_Condutor) references CONDUTORES(ID_Condutor) on delete set null;
alter table conduzem add constraint FK_CONDUZEM_TAXIS foreign key (FK_Taxi) references TAXIS(ID_Taxi) on delete set null;

alter table locais_partidas modify column FK_Morada bigint default '-1';
alter table locais_partidas drop foreign key FK_LOCAISPARTIDAS_MORADAS;
alter table locais_partidas add constraint FK_LOCAISPARTIDAS_MORADAS foreign key (FK_Morada) references MORADAS(ID_Morada) on delete set null;

alter table locais_chegadas modify column FK_Morada bigint default '-1';
alter table locais_chegadas drop foreign key FK_LOCAISCHEGADAS_MORADAS;
alter table locais_chegadas add constraint FK_LOCAISCHEGADAS_MORADAS foreign key (FK_Morada) references MORADAS(ID_Morada) on delete set null;

alter table viagens modify column FK_Taxi smallint default '-1';
alter table viagens drop foreign key FK_VIAGENS_TAXIS;
alter table viagens add constraint FK_VIAGENS_TAXIS foreign key (FK_Taxi) references TAXIS(ID_Taxi) on delete set null;

-- Inserir dados nas tabelas
insert into paises(Nome_Pais) value ('Portugal');
SELECT * FROM paises;

insert into cidades(Nome_Cidade, FK_Pais) value ('Porto',1);
insert into cidades(Nome_Cidade, FK_Pais) value ('Vila Nova de Gaia',1);
insert into cidades(Nome_Cidade, FK_Pais) value ('Matosinhos',1);
SELECT * FROM cidades;

insert into localidades(Nome_Localidade, FK_Cidade) value ('Porto',1);
insert into localidades(Nome_Localidade, FK_Cidade) value ('Massarelos',1);
insert into localidades(Nome_Localidade, FK_Cidade) value ('Vila Nova de Gaia',2);
insert into localidades(Nome_Localidade, FK_Cidade) value ('Candal',2);
insert into localidades(Nome_Localidade, FK_Cidade) value ('Perafita',3);
insert into localidades(Nome_Localidade, FK_Cidade) value ('Vila Nova da Telha',3);
SELECT * FROM localidades;

insert into codigos_postais (Codigo_Postal, FK_Localidade) value ('4000-234',1);
insert into codigos_postais (Codigo_Postal, FK_Localidade) value ('4000-255',2);
insert into codigos_postais (Codigo_Postal, FK_Localidade) value ('4400-123',3);
insert into codigos_postais (Codigo_Postal, FK_Localidade) value ('4400-007',4);
insert into codigos_postais (Codigo_Postal, FK_Localidade) value ('4470-550',5);
insert into codigos_postais (Codigo_Postal, FK_Localidade) value ('4470-558',6);
SELECT * FROM codigos_postais;

insert into moradas (Arruamento, NumPorta, FK_CodigoPostal) value ('Praça do General Humberto Delgado',266,1);
insert into moradas (Arruamento, NumPorta, FK_CodigoPostal) value ('Rua do Campo Alegre',169,2);
insert into moradas (Arruamento, NumPorta, FK_CodigoPostal) value ('Rua do General Torres',600,3);
insert into moradas (Arruamento, NumPorta, FK_CodigoPostal) value ('Rua Trás',16,4);
insert into moradas (Arruamento, NumPorta, FK_CodigoPostal) value ('Rua Ocidental',614,5);
insert into moradas (Arruamento, NumPorta, FK_CodigoPostal) value ('Aeroporto do Porto',1, 6);
SELECT * FROM moradas;

insert into funcoes (Nome_Funcao) value ('Condutor');
insert into funcoes (Nome_Funcao) value ('Administrativo');
SELECT * FROM funcoes;

insert into condutores (NomesProprios, NomeFamilia, NumCarta, DataNascimento, FK_Morada, FK_Funcao) value ('Felicidade', 'Barata', 'p-00000001', '1995-05-25', 2, 1);
insert into condutores (NomesProprios, NomeFamilia, NumCarta, DataNascimento, FK_Morada, FK_Funcao) value ('José', 'Machuca', 'p-00000002', '1994-04-24', 3, 1);
insert into condutores (NomesProprios, NomeFamilia, NumCarta, DataNascimento, FK_Morada, FK_Funcao) value ('Rolando', 'Alegre', 'p-00000003', '1993-03-23', 3, 1);
insert into condutores (NomesProprios, NomeFamilia, NumCarta, DataNascimento, FK_Morada, FK_Funcao) value ('Jacinto', 'Pinto', 'p-00000004', '1992-02-22', 1, 1);
insert into condutores (NomesProprios, NomeFamilia, NumCarta, DataNascimento, FK_Morada, FK_Funcao) value ('Generosa', 'Rola', 'p-00000005', '1991-01-21', 5, 1);
insert into condutores (NomesProprios, NomeFamilia, NumCarta, DataNascimento, FK_Morada, FK_Funcao) value ('Cuomo', 'Llama', 'p-00000006', '1990-12-20', 4, 1);
insert into condutores (NomesProprios, NomeFamilia, NumCarta, DataNascimento, FK_Morada, FK_Funcao) value ('Benvinda', 'Barbuda', 'p-00000007', '1970-11-10', 4, 1);
SELECT * FROM condutores;

insert into marcas (NomeMarca) value ('Mercedes');
insert into marcas (NomeMarca) value ('Valvo');
SELECT * FROM marcas;

insert into modelos (NomeModelo, FK_Marca) value ('Classe A', 1);
insert into modelos (NomeModelo, FK_Marca) value ('Classe B', 1);
insert into modelos (NomeModelo, FK_Marca) value ('XC60', 2);
insert into modelos (NomeModelo, FK_Marca) value ('XC40', 2);
SELECT * FROM modelos;

insert into taxis (NumMatricula, NumLugares, NomeTaxi, AnoFabrico, Cor, Gps, FK_Modelo) value ('39-ZS-08', 5, 'Taxi 1', 2010, 'Branco', true, 1);
insert into taxis (NumMatricula, NumLugares, NomeTaxi, AnoFabrico, Cor, Gps, FK_Modelo) value ('90-GN-13', 5, 'Taxi 2', 2011, 'Preto', true, 2);
insert into taxis (NumMatricula, NumLugares, NomeTaxi, AnoFabrico, Cor, Gps, FK_Modelo) value ('71-68-QD', 5, 'Taxi 3', 2012, 'Branco', true, 1);
insert into taxis (NumMatricula, NumLugares, NomeTaxi, AnoFabrico, Cor, Gps, FK_Modelo) value ('92-74-MA', 5, 'Taxi 4', 2013, 'Amarelo', true, 3);
insert into taxis (NumMatricula, NumLugares, NomeTaxi, AnoFabrico, Cor, Gps, FK_Modelo) value ('AA-AA-00', 5, 'Taxi 5', 1995, 'Amarelo', false, 2);
insert into taxis (NumMatricula, NumLugares, NomeTaxi, AnoFabrico, Cor, Gps, FK_Modelo) value ('AA-00-00', 5, 'Taxi 6', 1999, 'Preto', false, 4);
SELECT * FROM taxis;

insert into locais_chegadas (FK_Morada) value (1);
insert into locais_chegadas (FK_Morada) value (2);
insert into locais_chegadas (FK_Morada) value (3);
insert into locais_chegadas (FK_Morada) value (4);
insert into locais_chegadas (FK_Morada) value (5);
insert into locais_chegadas (FK_Morada) value (6);
SELECT * FROM locais_chegadas;

insert into locais_partidas (FK_Morada) value (1);
insert into locais_partidas (FK_Morada) value (2);
insert into locais_partidas (FK_Morada) value (3);
insert into locais_partidas (FK_Morada) value (4);
insert into locais_partidas (FK_Morada) value (5);
insert into locais_partidas (FK_Morada) value (6);
SELECT * FROM locais_partidas;

insert into viagens (InfoPartida, NumPassageiros, PrecoViagem, FK_LocalPartida, FK_Taxi) value ('2023-02-23 18:46:23', 5, 2.5, 1, 1);
insert into viagens (InfoPartida, NumPassageiros, PrecoViagem, FK_LocalPartida, FK_Taxi) value ('2023-02-23 18:46:23', 4, 5, 2, 1);
insert into viagens (InfoPartida, NumPassageiros, PrecoViagem, FK_LocalPartida, FK_Taxi) value ('2023-02-23 18:46:23', 5, 3, 3, 2);
insert into viagens (InfoPartida, NumPassageiros, PrecoViagem, FK_LocalPartida, FK_Taxi) value ('2023-02-23 18:46:23', 3, 25, 3, 2);
insert into viagens (InfoPartida, NumPassageiros, PrecoViagem, FK_LocalPartida, FK_Taxi) value ('2023-02-23 18:46:23', 1, 10.8, 4, 2);
insert into viagens (InfoPartida, NumPassageiros, PrecoViagem, FK_LocalPartida, FK_Taxi) value ('2023-02-23 18:46:23', 2, 15, 6, 3);
insert into viagens (InfoPartida, NumPassageiros, PrecoViagem, FK_LocalPartida, FK_Taxi) value ('2023-02-23 18:46:23', 5, 7, 4, 4);
insert into viagens (InfoPartida, NumPassageiros, PrecoViagem, FK_LocalPartida, FK_Taxi) value ('2023-02-23 18:46:23', 3, 9, 5, 5);
insert into viagens (InfoPartida, NumPassageiros, PrecoViagem, FK_LocalPartida, FK_Taxi) value ('2023-02-23 18:46:23', 2, 12.3, 1, 6);
insert into viagens (InfoPartida, NumPassageiros, PrecoViagem, FK_LocalPartida, FK_Taxi) value ('2023-02-23 18:46:23', 4, 13, 1, 3);
SELECT * FROM viagens;

-- Alterações de dados

-- 3.a)
update marcas set NomeMarca= 'Volvo' where NomeMarca= 'Valvo';
SELECT * FROM marcas;

-- 3.b)
alter table viagens modify column PrecoViagem decimal(6,2) default 3.5;

-- 3.c)
update moradas set Arruamento= 'Aeroporto Sá Carneiro' where Arruamento= 'Aeroporto do Porto';
SELECT * FROM moradas;

-- 3.d)
update viagens set PrecoViagem= 3.5 where PrecoViagem< 3.5;
SELECT * FROM viagens;

-- Remover dados

-- 4.a)
delete from marcas where NomeMarca= 'Mercedes';
SELECT * FROM marcas;

-- 4.b)
delete from condutores where ID_Condutor> 5;
SELECT * FROM condutores;

-- 4.c)
delete from taxis where Cor= 'Amarelo';
delete from taxis where Cor= 'Branco';
delete from taxis where AnoFabrico< 2000;
SELECT * FROM taxis;

-- 4.d)
delete from viagens where NumPassageiros> 4;
SELECT * FROM viagens;