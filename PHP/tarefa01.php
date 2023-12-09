<!DOCTYPE html>
<html>
	<head><meta charset="UTF-8"></head>
	<body>
		<?php
			echo "Exercício 1<br>";
			$n1=2;
			$n2=4;
			$soma=$n1+$n2;
			echo "Primeiro valor é ".$n1.", ";
			echo "Segundo valor é ".$n2.", ";
			echo "Soma é ".$soma."<br>";
		?>
		<?php
			echo "<br>Exercicio 2<br>";
			$n1=2;
			$n2=4;
			$quociente=$n2/$n1;
			echo "Primeiro valor é ".$n2.", ";
			echo "Segundo valor é ".$n1.", ";
			echo "Divisão é ".$quociente."<br>";
		?>
		<?php
			echo "<br>Exercicio 3<br>";
			$n1=2;
			$n2=4;
			$produto=$n2*$n1;
			echo "Primeiro valor é ".$n2.", ";
			echo "Segundo valor é ".$n1.", ";
			echo "Multiplicação é ".$produto."<br>";
		?>
		<?php
			echo "<br>Exercicio 4<br>";
			$n3=10;
			$n4=5;
			$soma=$n3+$n4;
			$sub=$n3-$n4;
			$mult=$n3*$n4;
			$div=$n3/$n4;
			$resto=$n3%$n4;
			echo "Primeiro valor é ".$n3.", ";
			echo "Segundo valor é ".$n4."<br>";
			echo "Soma é ".$soma.". Subtração é ".$sub.". Multiplicação é ".$mult.". Divisão é ".(int)$div." com resto ".$resto.".<br>";
		?>
		<?php
			echo "<br>Exercicio 5<br>";
			$raio=5;
			$dia=$raio*2;
			$area=round(pow($raio,2)*pi(),2);
			$peri=round(2*$raio*pi(),2);
			echo "O raio é ".$raio.".";
			echo "Diâmetro é ".$dia.". Área é ".$area.". Perimetro é ".$peri.".<br>";
		?>
		<?php
			echo "<br>Exercicio 6<br>";
			$n1=2;
			$n2=4;
			$n3=6;
			$n4=8;
			$n5=10;
			$soma=$n1+$n2+$n3+$n4+$n5;
			$media=$soma/5;
			echo "Números (".$n1.", ".$n2.", ".$n3.", ".$n4.", ".$n5.",)<br>";
			echo "Soma é ".$soma.". Média é ".$media.".<br>";
		?>
		<?php
			echo "<br>Exercicio 7<br>";
			$l1=5;
			$l2=3;
			$area=$l1*$l2;
			$peri=2*$l1+2*$l2;
			echo "O comprimento é ".$l1.". A largura é ".$l2.".<br>";
			echo "Área é ".$area.". Perimetro é ".$peri.".<br>";
		?>
		<?php
			echo "<br>Exercicio 8<br>";
			$c=20;
			$f=($c*1.8)+32;
			echo "A temperatura em Celsius é ".$c."ºC. ";
			echo "A temperatura em Fahrenheit é ".$f."ºF.<br>";
		?>
		<?php
			echo "<br>Exercicio 9<br>";
			$f=90;
			$c=round(($f-32)*(5/9),2);
			echo "A temperatura em Fahrenheit é ".$f."ºF. ";
			echo "A temperatura em Celsius é ".$c."ºC.<br>";
			
		?>
		<?php
			echo "<br>Exercicio 10<br>";
			$n=753;
			$n3=$n%10;
			$n2=(($n-$n3)/10)%10;
			$n1=(($n-($n2*10)-$n3)/100)%10;
			$soma=$n1+$n2+$n3;
			echo "O número é ".$n.". A soma dos seus digitos é ".$soma.".<br>";
		?>
		<?php
		/*
			!!! A divisão de dois numeros inteiros é sempre um número inteiro !!!

			echo "<br>Exercicio 10v2<br>";
			$num=876;
			
			$dig1=$num%10; //retorna o 6
			$numRest=$num/10; //retorna 87
			
			$dig2=$numRest%10; //retorna 7
			$numRest=$numRest/10; //retorna 8
			
			$dig3=$numRest%10; //retorna 8
			$soma=$dig1+$dig2+$dig3;
			echo "O número é ".$num.". A soma dos seus digitos é ".$soma.".<br>";
		*/
		?>
	<body>
</html>