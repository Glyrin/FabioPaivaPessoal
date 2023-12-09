<?php echo "Aula 1<br>";?>
<!DOCTYPE html>
<html>
	<head></head>
	<body>
		<h1><?php 
			// Comentário de uma linha
			/*
			Comentário de várias linhas
			*/
				/*
				1) Todas as variáveis começam com $
				2) O nome deve começar com letra ou _
				3) O nome não pode começar com um número
				4) O nome só pode ter caracteres alfanuméricos ou _
				5) O nome das variáveis é case sensitive
				*/
			$txt; //variável sem tipo
			$xtx= "título"; //variável com tipo
			$n1=5;
			$n2=5.5; // números décimais sempre com ponto e não vírgula
			$flag=false;
			$txt1= "porreiro <br>";
			echo "O meu ".$xtx." ".$txt1;
			echo $n1+$n2;
			/*
			Tipos de dados
				Strint -> "" ou ''
				Integer -> Números sem casas décimais
				Float -> Números com casas décimais
				Boolean -> true ou false
				Array -> Conjunto de elementos do mesmo tipo
				Object -> Variáveis personalizadas
				NULL -> Não existe
			*/
			$txt="";
			$txt1=null;
			?>
		</h1>
	</body>