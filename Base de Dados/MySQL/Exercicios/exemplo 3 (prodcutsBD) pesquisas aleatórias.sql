USE products;

-- Quais são as categorias que tenho para classificar produtos?
SELECT * FROM categories;

-- Todos os clientes com o nome começado por 'Hungry'
SELECT * FROM customers WHERE CustomerName Like 'Hungry%';

-- Todos os clientes que sejam da Argentina ou do Brasil
SELECT * FROM customers WHERE Country='Argentina' OR Country='Brazil';
SELECT * FROM customers WHERE Country IN('Argentina', 'Brazil');

-- Todos os funcionários nascidos em 1958
SELECT * FROM employees WHERE BirthDate LIKE '1958%';
SELECT * FROM employees WHERE YEAR(BirthDate) = 1958;

-- Todos os funcionários nascidos na década de 1950
SELECT * FROM employees WHERE BirthDate BETWEEN '1950-01-01' AND '1959-12-31';
SELECT * FROM employees WHERE YEAR(BirthDate) BETWEEN 1950 AND 1959;

-- Todos os Produtos do Fornecedor 1 e da Categoria 1
SELECT * FROM products WHERE SupplierID=1 OR CategoryID=1;

-- Todos os Produtos da Categoria 1 fornecidos pelo Fornecedor 1
SELECT * FROM products WHERE SupplierID=1 AND CategoryID=1;