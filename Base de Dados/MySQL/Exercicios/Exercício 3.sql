-- Tarefa 3, Exercício 1

create database exercicio3;
use exercicio3;

create table Departamentos(
	ID_dep tinyint auto_increment,
    Nome varchar(30) not null,
    primary key (ID_dep)
);
alter table Departamentos auto_increment = 41;
create table Funcionarios(
	ID_func tinyint auto_increment,
    Nome varchar(30) not null,
    Num_Departamento tinyint not null,
    Altura decimal(3,2) not null,
    Localidade varchar(30) not null,
    DataNascimento date,
    primary key (ID_func),
    constraint FK_Funcionarios_Departamentos
    foreign key (Num_Departamento) references Departamentos(ID_dep)
);

-- Tarefa 3, Exercício 2
insert into departamentos (Nome) values ('Marketing');
insert into departamentos (Nome) values ('Informática');
insert into departamentos (Nome) values ('Recursos Humanos');
insert into departamentos (Nome) values ('Financeiro');
insert into departamentos (Nome) values ('Higiene e Segurança');
select * from departamentos;

insert into funcionarios (Nome, Num_Departamento, Altura, Localidade, DataNascimento) values ('João Santos', 41, 1.8, 'Valença', '1980-02-24');
insert into funcionarios (Nome, Num_Departamento, Altura, Localidade, DataNascimento) values ('Miguel Silva', 43, 1.75, 'Viana do Castelo', '1966-04-02');
insert into funcionarios (Nome, Num_Departamento, Altura, Localidade, DataNascimento) values ('Carolina Sousa', 44, 1.61, 'Valença', '1971-11-12');
insert into funcionarios (Nome, Num_Departamento, Altura, Localidade, DataNascimento) values ('Patrícia Patrício', 42, 1.79, 'Braga', '1975-01-31');
insert into funcionarios (Nome, Num_Departamento, Altura, Localidade) values ('Maria Santos', 42, 1.69, 'Porto');
insert into funcionarios (Nome, Num_Departamento, Altura, Localidade, DataNascimento) values ('Rodrigo Gomes', 44, 1.85, 'Viana do Castelo', '1969-03-21');
select * from funcionarios;

-- Tarefa 3, Exercício 3.a)

select f.Nome as 'Funcionário', d.Nome as 'Departamento', f.Altura
from funcionarios as f
inner join departamentos as d on f.Num_Departamento = d.ID_dep
where d.ID_dep = 43
and f.Altura >1.8
order by f.Nome;

-- Tarefa 3, Exercício 3.b)

select round(avg(f.Altura),2) as 'Média de alturas'
from funcionarios as f
inner join departamentos as d on f.Num_Departamento = d.ID_dep
where d.ID_dep = 41;

-- Tarefa 3, Exercício 3.c)

select f.Nome as 'Funcionário', f.Localidade, d.Nome as 'Departamento'
from funcionarios as f
inner join departamentos as d on f.Num_Departamento = d.ID_dep
where d.ID_dep = 42
and (f.Localidade='Valença' or f.Localidade='Porto');

-- Tarefa 3, Exercício 3.d)

select f.Nome as 'Funcionário', d.Nome as 'Departamento', f.DataNascimento as 'Data de nascimento'
from funcionarios as f
inner join departamentos as d on f.Num_Departamento = d.ID_dep
where f.DataNascimento between '1980-01-01' and '1989-12-31';

-- Tarefa 3, Exercício 3.e)

-- select min(Altura), Nome from funcionarios
-- group by Nome limit 1;

select Altura, Nome from funcionarios where Altura=(select min(Altura) from funcionarios);

-- Tarefa 3, Exercício 3.f)

select ID_func as 'Número', Nome, DataNascimento as 'Data de Nascimento' from funcionarios where DataNascimento is null;

-- Tarefa 3, Exercício 3.g)

select count(ID_func) as 'Nº Funcionários' from funcionarios;

-- Tarefa 3, Exercício 3.h)

select Altura, Nome from funcionarios
order by Altura desc, Nome;

-- Tarefa 3, Exercício 3.i)

select DataNascimento as 'Data de Nascimento', Nome from funcionarios
where month(DataNascimento)=month(now())+1
order by day(DataNascimento);