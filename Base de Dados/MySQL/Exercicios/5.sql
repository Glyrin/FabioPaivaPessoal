select count(CodigoDaCompra) as 'Números de compras', Cor 
from compras 
group by Cor 
order by count(CodigoDaCompra) desc;

select Altura, Nome 
from funcionarios 
where Altura=(select min(Altura) from funcionarios);