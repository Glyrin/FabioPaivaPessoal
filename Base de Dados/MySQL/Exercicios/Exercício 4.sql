-- Tarefa 4, Exercício 1

create database exercicio4;
use exercicio4;

create table Fornecedores(
	CodigoDoFornecedor smallint auto_increment,
    NomeDaEmpresa varchar(30),
    Endereco varchar(50),
    CodigoPostal char(8),
    Localidade varchar(30),
    Telefone int unique,
    NrContribuinte int(9) unique not null,
    Contacto varchar(30) unique,
    primary key (CodigoDoFornecedor)
);

create table Carros(
	CodigoDoCarro int auto_increment,
    Marca Varchar(20),
    Modelo varchar(30),
    PrecoUnitario decimal(9,2),
    Cilindrada smallint(4),
    Potencia smallint(4),
    NrPortas tinyint(1),
    DescricaoDoProduto text,
    Descontinuado boolean default false,
    primary key(CodigoDoCarro)
);

create table Compras(
	CodigoDaCompra bigint auto_increment,
    CodigoDoCarro int,
    CodigoDoFornecedor smallint,
    DataDaCompra date,
    PrecoCompra decimal(9,2),
    Cor varchar(20),
    primary key (CodigoDaCompra),
    constraint FK_Compras_Carros foreign key (CodigoDoCarro) references Carros(CodigoDoCarro),
    constraint FK_Compras_Fornecedores foreign key (CodigoDoFornecedor) references Fornecedores(CodigoDoFornecedor)
);

create table Clientes(
	NrBI int(8) not null,
    Nome varchar(50),
    Endereco varchar(50),
    CodigoPostal char(8),
    Localidade varchar(30),
    Telefone int unique,
    DataDeNascimento date,
    NrContribuinte int(9) unique not null,
    primary key (NrBI)
);

create table Vendedores(
	CodigoDoVendedor int auto_increment,
    Nome varchar(50),
    Endereco varchar(50),
    CodigoPostal char(8),
    Localidade varchar(30),
    Telefone int unique,
    NrContribuinte int(9) unique not null,
    NrBI int(8) not null,
    primary key (CodigoDoVendedor)
);

create table Vendas(
	CodigoDaCompra bigint not null,
    NrBI_Cliente int(8),
    CodigoDoVendedor int,
    Preco decimal(9,2) not null,
    Data date,
    FormaDePagamento varchar(20),
    primary key (CodigoDaCompra),
    constraint FK_Vendas_Compras foreign key (CodigoDaCompra) references Compras(CodigoDaCompra),
    constraint FK_Vendas_Clientes foreign key (NrBI_Cliente) references Clientes(NrBI),
    constraint FK_Vendas_Vendedores foreign key (CodigoDoVendedor) references Vendedores(CodigoDoVendedor)
);

-- Tarefa 4, Exercício 2

insert into fornecedores (NomeDaEmpresa, Endereco, CodigoPostal, Localidade, Telefone, NrContribuinte, Contacto) values ('XPTO', 'Rua Sobe e Desce nº1', '1000-001', 'Lisboa', 210000001, 500000001, 'geral@xpto.pt');
insert into fornecedores (NomeDaEmpresa, Endereco, CodigoPostal, Localidade, Telefone, NrContribuinte, Contacto) values ('Vroom', 'Rotunda Quadrada nº2', '4400-001', 'Vila Nova de Gaia', 220000002, 500000002, 'geral@vroom.pt');
insert into fornecedores (NomeDaEmpresa, Endereco, CodigoPostal, Localidade, Telefone, NrContribuinte, Contacto) values ('BipBip', 'Rua Sobe e Desce nº3', '1000-001', 'Lisboa', 910000003, 500000003, 'geral@bipbip.pt');
insert into fornecedores (NomeDaEmpresa, Endereco, CodigoPostal, Localidade, Telefone, NrContribuinte, Contacto) values ('Velocity', 'Rua Sobe e Desce nº4', '1000-001', 'Lisboa', 210000004, 500000004, 'geral@velocity.pt');
insert into fornecedores (NomeDaEmpresa, Endereco, CodigoPostal, Localidade, NrContribuinte, Contacto) values ('Premium', 'Rua Sobe e Desce nº5', '1000-001', 'Lisboa', 500000005, 'geral@premium.pt');
select * from fornecedores;

insert into Carros (Marca, Modelo, PrecoUnitario, Cilindrada, Potencia, NrPortas, DescricaoDoProduto) values ('Opel', 'Corsa', 7523.50, 1200, 500, 3, 'Rápido pa Carago, mas sem abusar');
insert into Carros (Marca, Modelo, PrecoUnitario, Cilindrada, Potencia, NrPortas, DescricaoDoProduto) values ('Renault', 'Clio', 7247.28, 1200, 500, 3, 'Era o que havia');
insert into Carros (Marca, Modelo, PrecoUnitario, Cilindrada, Potencia, NrPortas, DescricaoDoProduto) values ('Opel', 'Astra', 7523.50, 1200, 500, 5, 'Anda Fixe');
insert into Carros (Marca, Modelo, PrecoUnitario, Cilindrada, Potencia, NrPortas, DescricaoDoProduto) values ('Honda', 'Civic', 7523.50, 1200, 500, 5, 'Dá para tunning');
insert into Carros (Marca, Modelo, PrecoUnitario, Cilindrada, Potencia, NrPortas, DescricaoDoProduto, Descontinuado) values ('Renault', '5', 4200.69, 1000, 250, 3, 'Sem fundo', true);
select * from carros;

insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (1, 1, '2022-02-01', 7800, 'Azul');
insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (1, 1, '2022-02-03', 7800, 'Preto');
insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (1, 1, '2022-02-05', 7800, 'Amarelo');
insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (3, 1, '2022-02-02', 8000, 'Azul');
insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (3, 1, '2022-02-04', 8000, 'Azul');
insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (3, 1, '2022-02-06', 8000, 'Preto');
insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (2, 2, '2022-02-01', 7300, 'Preto');
insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (2, 2, '2022-02-02', 7300, 'Azul');
insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (5, 3, '2022-02-01', 4300, 'Vermelho');
insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (5, 3, '2022-02-01', 4300, 'Vermelho');
insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (4, 2, '2022-01-20', 7600, 'Preto');
insert into Compras (CodigoDoCarro, CodigoDoFornecedor, DataDaCompra, PrecoCompra, Cor) values (4, 2, '2022-01-09', 7600, 'Preto');
select * from Compras;

insert into Clientes (NrBI, Nome, Endereco, CodigoPostal, Localidade, Telefone, DataDeNascimento, NrContribuinte) values (01010101, 'Mike Rack', 'Travessa Torta 27', '1000-007', 'Lisboa', 930000001, '2000-04-25', 100000001);
insert into Clientes (NrBI, Nome, Endereco, CodigoPostal, Localidade, Telefone, DataDeNascimento, NrContribuinte) values (10101010, 'Mike Hunt', 'Largo Deserto 4', '1000-002', 'Lisboa', 920000002, '2001-04-25', 100000002);
insert into Clientes (NrBI, Nome, Endereco, CodigoPostal, Localidade, Telefone, DataDeNascimento, NrContribuinte) values (02020202, 'Phil Wood', 'Rua Escondida 69', '1000-003', 'Lisboa', 960000003, '2002-04-25', 100000003);
insert into Clientes (NrBI, Nome, Endereco, CodigoPostal, Localidade, Telefone, DataDeNascimento, NrContribuinte) values (20202020, 'Harry Cox', 'Rua a Subir 187', '1000-004', 'Lisboa', 910000004, '2003-04-25', 100000004);
insert into Clientes (NrBI, Nome, Endereco, CodigoPostal, Localidade, Telefone, DataDeNascimento, NrContribuinte) values (03030303, 'Dixon Payne', 'Travessa do Aleijado 30', 'Lisboa', '1000-005', 930000005, '1999-04-25', 100000005);
insert into Clientes (NrBI, Nome, Endereco, CodigoPostal, Localidade, Telefone, DataDeNascimento, NrContribuinte) values (30303030, 'Ben Dover', 'Rua de Trás 68', '1000-006', 'Lisboa', 960000006, '1998-05-20', 100000006);
insert into Clientes (NrBI, Nome, Endereco, CodigoPostal, Localidade, Telefone, DataDeNascimento, NrContribuinte) values (04040404, 'Moe Lester', 'Rua Escura 33', '4000-004', 'Porto', 910000007, '2000-05-23', 100000007);
insert into Clientes (NrBI, Nome, Endereco, CodigoPostal, Localidade, Telefone, DataDeNascimento, NrContribuinte) values (40404040, 'Jack Willie', 'Rua da Erva  420', '4000-005', 'Porto', 920000008, '2000-08-25', 100000008);
select * from Clientes;

insert into Vendedores (Nome, Endereco, CodigoPostal, Localidade, Telefone, NrContribuinte, NrBI) values ('Seymour Beaver', 'Rua que Sabes 55', '1000-024', 'Lisboa', 920000024, 200000001, 05050505);
insert into Vendedores (Nome, Endereco, CodigoPostal, Localidade, Telefone, NrContribuinte, NrBI) values ('Dick Muncher', 'Rua da Esquerda 490', '1000-006', 'Sintra', 910000025, 200000002, 50505050);
insert into Vendedores (Nome, Endereco, CodigoPostal, Localidade, Telefone, NrContribuinte, NrBI) values ('Holden Wood', 'Travesas das Árvores 86', '1000-025', 'Lisboa', 930000026, 200000003, 06060606);
insert into Vendedores (Nome, Endereco, CodigoPostal, Localidade, Telefone, NrContribuinte, NrBI) values ('Johnson Stroker', 'Escadas Apertadas 14', '4000-030', 'Porto', 960000027, 200000004, 60606060);
insert into Vendedores (Nome, Endereco, CodigoPostal, Localidade, Telefone, NrContribuinte, NrBI) values ('Rowdy Bacon', 'Rua dos Suínos 18', '4400-031', 'Vila Nova de Gaia', 920000028, 200000005, 07070707);
select * from Vendedores;

insert into Vendas (CodigoDaCompra, NrBI_Cliente, CodigoDoVendedor, Preco, Data, FormaDePagamento) values (3, 01010101, 1, 10000, '2023-03-05', 'Cartão Débito');
insert into Vendas (CodigoDaCompra, NrBI_Cliente, CodigoDoVendedor, Preco, Data, FormaDePagamento) values (1, 01010101, 1, 10000, '2023-03-01', 'Cartão Débito');
insert into Vendas (CodigoDaCompra, NrBI_Cliente, CodigoDoVendedor, Preco, Data, FormaDePagamento) values (4, 10101010, 2, 12000, '2023-03-02', 'Cartão Crédito');
insert into Vendas (CodigoDaCompra, NrBI_Cliente, CodigoDoVendedor, Preco, Data, FormaDePagamento) values (5, 02020202, 1, 12000, '2023-03-04', 'Numerário');
insert into Vendas (CodigoDaCompra, NrBI_Cliente, CodigoDoVendedor, Preco, Data, FormaDePagamento) values (2, 20202020, 1, 10000, '2023-03-03', 'Cartão Crédito');
insert into Vendas (CodigoDaCompra, NrBI_Cliente, CodigoDoVendedor, Preco, Data, FormaDePagamento) values (6, 03030303, 1, 11000, '2023-03-06', 'Numerário');
insert into Vendas (CodigoDaCompra, NrBI_Cliente, CodigoDoVendedor, Preco, Data, FormaDePagamento) values (7, 30303030, 1, 9000, '2023-03-01', 'Cartão Crédito');
insert into Vendas (CodigoDaCompra, NrBI_Cliente, CodigoDoVendedor, Preco, Data, FormaDePagamento) values (11, 04040404, 4, 8500, '2023-02-20', 'Numerário');
insert into Vendas (CodigoDaCompra, NrBI_Cliente, CodigoDoVendedor, Preco, Data, FormaDePagamento) values (9, 40404040, 5, 7000, '2023-03-01', 'Cartão Crédito');
select * from Vendas;

-- Tarefa 4, Exercício 3.a)

select distinct Marca, Modelo, NrPortas as 'Número de Portas' from carros where NrPortas=3;

-- Tarefa 4, Exercício 3.b)

select NomeDaEmpresa as 'Fornecedor', Telefone, Contacto as 'E-mail' from fornecedores where Telefone is null order by NomeDaEmpresa;

-- Tarefa 4, Exercício 3.c)

select distinct Modelo from carros;

-- Tarefa 4, Exercício 3.d), sim foram feitas 3 compras com o mesmo valor à mesma empresa

select f.NomeDaEmpresa as 'Fornecedor', f.Localidade, co.PrecoCompra as 'Preço de Compra mais alto'
from fornecedores as f
inner join compras as co on co.CodigoDoFornecedor=f.CodigoDoFornecedor
where co.PrecoCompra=(select max(PrecoCompra) from compras);

-- Tarefa 4, Exercício 3.e)

select NomeDaEmpresa as 'Fornecedor', Telefone from fornecedores where Telefone like '91%';

-- Tarefa 4, Exercício 3.f)

select NomeDaEmpresa as 'Fornecedor', CodigoPostal as 'Código Postal'from fornecedores where CodigoPostal not like '4400%';

-- Tarefa 4, Exercício 3.g)

select count(CodigoDaCompra) as 'Números de compras', Cor from compras group by Cor order by count(CodigoDaCompra) desc;

-- Tarefa 4, Exercício 3.h)

select f.NomeDaEmpresa as 'Fornecedor' from fornecedores as f
left join compras as co on co.CodigoDoFornecedor=f.CodigoDoFornecedor
where co.CodigoDoFornecedor is null;

-- Tarefa 4, Exercício 3.i)

select vo.Nome as 'Vendedor', count(ve.CodigoDaCompra) as 'Vendas'
from vendedores as vo
inner join vendas as ve on ve.CodigoDoVendedor=vo.CodigoDoVendedor
group by ve.CodigoDoVendedor
having count(ve.CodigoDoVendedor)>5;

-- Tarefa 4, Exercício 3.j)

select Cor as 'Côr', count(CodigoDaCompra) as 'Carros comprados nesta côr'
from compras
group by Cor
having count(CodigoDaCompra)=(select count(CodigoDaCompra) from compras group by Cor order by count(cor) desc limit 1);

-- Tarefa 4, Exercício 3.k)

select f.NomeDaEmpresa as 'Fornecedor', count(co.CodigoDaCompra) as 'Compras em 2022'
from fornecedores as f
inner join compras as co on co.CodigoDoFornecedor=f.CodigoDoFornecedor
where year(co.DataDaCompra)=2022
group by f.NomeDaEmpresa
having count(co.CodigoDoFornecedor)=(select count(CodigoDoFornecedor) from compras where year(DataDaCompra)=2022 group by CodigoDoFornecedor order by count(CodigoDoFornecedor) desc limit 1);

-- Tarefa 4, Exercício 3.l)

select ca.Marca, ca.Modelo, ve.Data as 'Último vendido'
from carros as ca
inner join compras as co on co.CodigoDoCarro=ca.CodigoDoCarro
inner join vendas as ve on ve.CodigoDaCompra=co.CodigoDaCompra
where ve.Data=(select max(Data) from vendas);