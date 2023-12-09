<h1><?php echo "Aula 7<br>";?></h1>
<!DOCTYPE html>
<html>
	<head></head>
	<body>
		<h4><?php 
			/*
			Super globais - são variáveis ou funções que já existem na própria linguagem e podem ser sempre utilizadas
			$_VARIÁVEL - !TEM DE VIR EM MAIUSCULAS!
			['CHAVE'] - !TEM DE VIR EM MAIUSCULAS!
			*/
			echo $_SERVER['PHP_SELF']."<br>"; //array associativo que indica o sitio onde está o ficheiro, começa no servidor(htdocs)
            echo $_SERVER['SERVER_NAME']."<br>";// retorna o nome do servidor onde está a ser executado
            echo $_SERVER['SERVER_SOFTWARE']."<br>";//retorna as informações sobre a versão do software que estamos a usar
			echo $_SERVER['REQUEST_METHOD']."<br>";//
			echo "<br><br>";
			var_dump($_SERVER)."<br>";// retorna todas as informações da estrutura do servidor ao monte
			echo "<br><br>";
			?>
		</h4>
	</body>