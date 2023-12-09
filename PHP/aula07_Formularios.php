<h1><?php echo "Aula 7<br>";?></h1>
<!DOCTYPE html>
<html>
	<head></head>
	<body>
		<h4>
			<!-- Formulários para inserir dados para usar no PHP -->
			<!-- Formulários são feitos como em HTML -->
			<!-- método pode ser GET ou POST, action tem de ter o nome do ficheiro em que estamos a trabalhar -->


			<form method="GET" action="aula07_Formularios.php"><!-- esta action permite correr o resultado num ficheiro específico-->
				<!-- GET mostra ? e a informação toda na barra URL -->
				<label>Nome:</label>
				<input type="text" name="nome">
				<br>
				<label>Idade:</label>
				<input type="number" name="idade">
				<br>
				<input type="submit" value="submeter">
				<!-- Para este exemplo no método GET ficaria algo do género "...?nome=António&idade=37..." -->
			</form>
			<form method="POST" action="aula07_Formularios.php">
				<!-- POST só mostra ? na barra URL -->
				<label>Nome:</label>
				<input type="text" name="nome2">
				<br>
				<label>Idade:</label>
				<input type="number" name="idade2">
				<br>
				<input type="submit" value="submeter">
				<!-- Para este exemplo no método POST ficaria só o URL tradicional sem mais nada -->
			</form>
			<?php
			//nos casos em que se usa o método POST é necessário usar o php para ver se a informação foi enviada
			if($_SERVER["REQUEST_METHOD"]=="POST"){
				$nome=$_REQUEST["nome2"];//vai buscar o conteúdo do elemento, pode ir buscar GET e POST
				$idade=$_POST["idade2"];// vai buscar só se for método POST caso contrário preenche como vazio
				$_GET["idade"]; //vai buscar só se for método GET caso contrário preenche como vazio

				// imprimir informação no caso de ser ou não preenchido
				if(empty($nome)){
					echo "Nome não foi preenchido<br>";
				}else{
					echo "O nome é ".$nome."<br>";
				}
				if(empty($idade)){
					echo "Idade não foi preenchida<br>";
				}else{
					echo "A idade é ".$idade."<br>";
				}
			}
			?>
			<form method="POST" action="<?php echo $_SERVER['PHP_SELF'];?>"><!-- esta action permite correr o resultado no próprio ficheiro-->
				<!-- POST só mostra ? na barra URL -->
				<label>Nome:</label>
				<input type="text" name="nome2">
				<br>
				<input type="submit" value="submeter">
				<!-- Para este exemplo no método POST ficaria só o URL tradicional sem mais nada -->
			</form>
		</h4>
	</body>