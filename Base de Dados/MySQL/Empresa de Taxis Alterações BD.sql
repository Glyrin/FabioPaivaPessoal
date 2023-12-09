PAISES
	criar default ('-1', 'Sem País')

CIDADES
	criar default ('-1', 'Sem Cidade', '-1')

    FK_Pais smallint not null default '-1',

LOCALIDADES
    criar default ('-1', 'Sem Localidade', '-1')

    FK_Cidade int not null default '-1',

CODIGOS_POSTAIS
    criar default ('-1', '0000-000', '-1')

    FK_Localidade int not null default '-1',

MORADAS
    criar default ('-1', 'Morada Desconhecida',0, '-1')

	FK_CodigoPostal int not null default '-1',

FUNCOES
    criar default ('-1', 'Sem Função')

    Nome_Funcao varchar(30) not null default '-1',

CONDUTORES
    criar default ('-1', 'Condutor', 'Desconhecido', 'A-00000000', '0000-00-00', '-1', '-1')

    FK_Morada bigint not null default '-1',
    FK_Funcao tinyint not null default '-1',    
    constraint FK_CONDUTORES_MORADAS foreign key (FK_Morada) references MORADAS(ID_Morada) on delete set default,
    constraint FK_CONDUTORES_FUNCOES foreign key (FK_Funcao) references FUNCOES(ID_Funcao) on delete set default

MARCAS
    criar default ('-1', 'Sem Marca')

MODELOS
    criar default ('-1', 'Sem Modelo', '-1')

    FK_Marca tinyint default '-1',

TAXIS
    criar default ('-1', '00-AA-00', 0,'Taxi Desconhecido', 0000, '-1')

    FK_Modelo int default '-1',

CONDUZEM
    FK_Condutor smallint not null default '-1',
    FK_Taxi smallint not null default '-1',
    constraint FK_CONDUZEM_CONDUTORES foreign key (FK_Condutor) references CONDUTORES(ID_Condutor) on delete set default,
    constraint FK_CONDUZEM_TAXIS foreign key (FK_Taxi) references TAXIS(ID_Taxi) on delete set default

LOCAIS_PARTIDAS
    FK_Morada bigint default '-1',
    constraint FK_LOCAISPARTIDAS_MORADAS foreign key (FK_Morada) references MORADAS(ID_Morada) on delete set default

LOCAIS_CHEGADAS
    FK_Morada bigint default '-1',
    constraint FK_LOCAISCHEGADAS_MORADAS foreign key (FK_Morada) references MORADAS(ID_Morada) on delete set default

VIAGENS
    NumPassageiros tinyint not null default 1,
    PrecoViagem decimal(6,2) default 2.5,
    FK_Taxi smallint not null default '-1',
    constraint FK_VIAGENS_TAXIS foreign key (FK_Taxi) references TAXIS(ID_Taxi) on delete set default