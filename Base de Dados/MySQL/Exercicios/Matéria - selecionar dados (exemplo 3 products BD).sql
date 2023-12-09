USE products;

-- Selecionar dados

SELECT * FROM BD.tabela; -- seleciona dados de uma BD e tabela especificas mesmo que a BD não esteja a ser usada no momento

SELECT * FROM tabela; -- Seleciona todos os dados de todas as colunas numa determinada tabela
SELECT coluna FROM tabela; -- selecionar coluna específica de uma tabela específica
SELECT coluna1, coluna2 FROM tabela; -- selecionar colunas específicas de uma tabela específica
-- EXEMPLOS
SELECT * FROM categories;
SELECT * FROM customers;
SELECT CustomerName, City FROM customers;
SELECT DISTINCT Country FROM customers; -- Seleciona os dados sem dar repetidos

-- Filtrar dados na mesma tabela

SELECT * FROM tabela WHERE DadoColuna = dado; -- seleciona todos os dados de uma tabela que tenham o mesmo dado numa determinada coluna
											  -- se o dado for texto tem de levar ' '
SELECT * FROM customers WHERE Country = 'Mexico';
SELECT * FROM customers WHERE CustomerID = 50;
SELECT * FROM products Where Price > 30; -- todos os produtos com preço maior que 30
SELECT * FROM products Where Price < 30; -- todos os produtos com preço menor que 30
SELECT * FROM products Where Price >= 30; -- todos os produtos com preço maior ou igual que 30
SELECT * FROM products Where Price <= 30; -- todos os produtos com preço menor ou igual que 30
SELECT * FROM products Where Price <> 30; -- todos os produtos com preço maior e menor que 30
SELECT * FROM products Where Price != 30; -- todos os produtos com preço diferente que 30
SELECT * FROM products Where Price BETWEEN 50 AND 60; -- todos os produtos com preço entre 50 e 60, valor menor tem de vir antes. Em MySQL BETWEEN inclui os extremos
SELECT * FROM customers WHERE City IN ('Paris', 'Londres', 'Lisbon'); -- todos os clientes das cidades escolhidas

-- Filtragem personalizada

SELECT * FROM customers WHERE CustomerName LIKE 'S%'; -- Todos os clientes com nome começado por S
SELECT * FROM customers WHERE CustomerName LIKE '%s'; -- Todos os clientes com nome terminado por s
SELECT * FROM customers WHERE CustomerName LIKE '%s%'; -- Todos os clientes com nome com a letra s contida no nome
SELECT * FROM customers WHERE CustomerName LIKE '%na%'; -- Todos os clientes com 'na' contido no nome de forma seguida
SELECT * FROM customers WHERE CustomerName LIKE '%n%a%'; -- Todos os clientes com 'na' contido no nome independentemente do lugar
-- _ significa numeros de caracteres especificos
SELECT * FROM customers WHERE CustomerName LIKE 'S_'; -- Todos os clientes começam por S e só tem mais uma letra depois
SELECT * FROM customers WHERE CustomerName LIKE '_r%'; -- não interessa a letra por que começa, a segunda letra é um r pode ter qualquer coisa para a frente

SELECT * FROM customers WHERE Country ='Germany' AND City ='Berlin'; -- Todos os clientes da Alemanha e de Berlin (restringir o filtro) interseção de dados
SELECT * FROM customers WHERE City ='Berlin' OR City ='Aachen'; -- Todos os clientes de Berlin e Aachen (expande o filtro) reunião de dados
SELECT * FROM customers WHERE Country !='Germany'; -- Todos os clientes que não são da Alemanha
SELECT * FROM customers WHERE NOT Country ='Germany'; -- Todos os clientes que não são da Alemanha

-- Combinação de informações nos filtros !Atenção aos parentesis!

SELECT * FROM customers WHERE Country='Germany' AND City='Berlin'; -- 1 resultado
SELECT * FROM customers WHERE Country='Germany' AND City='Berlin' OR City='Aachen'; -- 2 resultados
SELECT * FROM customers WHERE Country='Germany' AND (City='Berlin' OR City='Aachen'); -- 2 resultados
SELECT * FROM customers WHERE Country='Germany' AND City='Berlin' OR City='Paris'; -- 3 resultados
SELECT * FROM customers WHERE Country='Germany' AND (City='Berlin' OR City='Paris'); -- 1 resultado
SELECT * FROM customers WHERE NOT Country='Germany' AND NOT Country='USA';
SELECT * FROM customers WHERE NOT Country IN ('Germany', 'USA');

-- Limitar resultados obtidos nas pesquisas
SELECT * FROM customers;
SELECT * FROM customers LIMIT 3; -- Limita o resultado da pesquisa apenas a 3 registos

SELECT min(Price) FROM products; -- Procura valores mínimos
SELECT max(Price) FROM products; -- Procura valores máximos
SELECT count(ProductID) FROM products; -- Conta o número de produtos
SELECT avg(Price) FROM products; -- Determina preço médio
SELECT sum(quantity) FROM order_details WHERE OrderID=10249; -- Quantos produtos tinha a ordem 10249

-- Alias, mostra nomes diferentes para as colunas do que os originais contidos nas tabelas
select CustomerName as Nome, PostalCode as 'Código Postal' from customers as Clientes;

-- Pesquisas de dados de várias tabelas ao mesmo tempo
-- forma antiga
select c.* -- todos os clientes
from customers as c, orders as o
where c.CustomerId = o.CustomerId;
-- forma nova
select c.*, o.OrderDate
from Customers as c
inner join Orders as o on c.CustomerID = o.CustomerId
where ContactName like 'A%';

select c.*, o.OrderDate, s.ShipperName
from Customers as c
inner join Orders as o on c.CustomerID = o.CustomerId
inner join Shippers as s on o.ShipperID = s.ShipperID
where year(o.orderDate)=1996 and s.ShipperID=2 and c.Country='Brazil';

select c.CustomerName, o.OrderId
from Customers as c
left join Orders as o on c.CustomerID = o.CustomerId;

select c.CustomerName, o.OrderId
from Orders as o
right join customers as c on o.CustomerID = c.CustomerId;

-- união de pesquisas, têm de devolver o mesmo tipo de dados

select City from Customers
where country='Brazil'
union -- union elimina os repetidos, também pode ser union all que vai juntar mas não elimina os repetidos
select City from Suppliers
where country='Germany';

select 'Customer' as Type, ContactName, City, Country from Customers
union -- union elimina os repetidos, também pode ser union all que vai juntar mas não elimina os repetidos
select 'Supplier', ContactName, City, Country from Suppliers

-- Exemplos pesquisas com várias tabelas
select o.OrderID, c.CustomerName,o.OrderDate, s.ShipperName
from Orders as o
inner join Customers as c on c.CustomerID = o.CustomerId
inner join Shippers as s on o.ShipperID = s.ShipperID;

select p.ProductName, c.CategoryName, s.SupplierName
from products as p
inner join Categories as c on p.CategoryID = c.CategoryID
inner join Suppliers as s on p.SupplierID = s.SupplierID;

select p.ProductName, c.CustomerName
from products as p
inner join order_details as od on od.ProductID = p.ProductID
inner join orders as o on o.OrderID = od.OrderID
inner join customers as c on c.CustomerID = o.CustomerID
where c.Country = 'USA';

select p.Unit, p.ProductName -- a quantidade total de dado produto
from products as p
where p.ProductID = 77;

select p.Unit, p.ProductName, s.SupplierName -- QUANTIDADE DE UM DADO PRODUTO QUE UM DADO FORNECEDOR TEM
from products as p
inner join suppliers as s on s.SupplierID = p.SupplierID
where p.ProductID = 77
and p.SupplierID = 12;

select * from products;

select round(avg(p.Price),2) as 'Preço Médio', s.SupplierName -- MEDIA DE PRECOS DOS PRODUTOS DE UM DADO FORNECEDOR
from products as p
inner join suppliers as s on s.SupplierID = p.SupplierID
where s.SupplierID = 12;

-- quantos clientes cada país tem
SELECT Country, City, COUNT(CustomerID)
FROM customers
GROUP BY Country, City -- group by agrega para poder contar por grupos
order by count(CustomerID) desc; -- order by, ordena e vem sempre no fim

SELECT Country, City, COUNT(CustomerID)
FROM customers
GROUP BY Country, City
having COUNT(CustomerID)>=5; -- having é o mesmo que where

-- Nº encomendas enviadas por cada transportadora
select s.shippername, count(o.OrderID) as 'Número encomendas'
from orders o
left join shippers s on o.ShipperID = s.ShipperID
group by s.Shippername;