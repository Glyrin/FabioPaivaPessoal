<?php echo "<br>Aula 2<br><br>";?>
<!DOCTYPE html>
<html>
	<head><meta charset="UTF-8"></head>
	<body>
		<?php
			$texto="Olá mundo!";
			//contar o número de palavras
			echo str_word_count($texto);
			echo "<br>";
			// Colocar uma string ao contrário
			echo strrev($texto);
			echo "<br>";
			//posição de texto, mostra onde inicia se forem palavras
			echo strpos($texto, "m");
			echo "<br>";
			//substituir texto
			echo str_replace("mundo", "people", $texto);
			echo "<br>";
			echo md5($texto);
			echo "<br>";
			//comparar trings, (-1)a primeira é maior, (0)são iguais, (1)a segunda é maior
			echo strcmp ($texto, "Olá mundo meu!");
			//trim() - remove espaços em branco antes e depois
			//ltrim() - remove espaços em branco antes
			//rtrim() - remove espaços em branco depois
		?>
		<?php echo "<br>";?>
		<?php
			echo PHP_INT_MAX;
			echo "<br>";
			echo PHP_INT_MIN;
			echo "<br>";
			echo is_int(4);//devolve 0 se falso(pode não devolver no falso), 1 se verdadeiro
			//var_dump devolve valor e tipo de dado
			echo "<br>";
			var_dump(is_int(4));
			echo "<br>";
			var_dump(is_int(4.5));
			
			echo "<br>";
			echo PHP_FLOAT_MAX;
			echo "<br>";
			echo PHP_FLOAT_MIN;
			echo "<br>";
			echo is_float(4);//devolve 0 se falso(pode não devolver no falso), 1 se verdadeiro
			//var_dump devolve valor e tipo de dado
			echo "<br>";
			var_dump(is_float(4));
			echo "<br>";
			var_dump(is_float(4.5));
			echo "<br>";
			var_dump(is_nan(5));//pergunta se é um número
			echo "<br>";
			var_dump(!is_nan(5));//pergunta se não é um número
			echo "<br>";
			var_dump(is_numeric(9));//verifica se o dado é numérico
			
			echo "<br>";
			$x=123.45;
			$coiso=(int)$x;//regista só a parte inteira da variável
			echo $coiso;
			echo "<br>";
			$x2="123.45";
			$coiso2=(float)$x2;
			echo $coiso2;
			echo "<br>";
			echo pi();//devolve valor de pi
			echo "<br>";
			echo min(0,150,-8,-100);//devolve o valor mínimo
			echo "<br>";
			echo max(0,150,-8,-100);//devolve o valor máximo
			echo "<br>";
			echo abs(-6);//devolve valor absoluto ou módulo de um número
			echo "<br>";
			echo sqrt(9);//devolve a raíz quadrada
			echo "<br>";
			echo round(0,6);//arredondamento, segue regras normais matemáticas
			echo "<br>";
			echo rand ();//gera só um valor aleatório dentro de () pode-se restringir o intervalo de valores
			echo "<br>";
			echo pow (2,4);//calcula potência, primeiro número é a base, segundo é o expoente
		?>
	<body>
</html>