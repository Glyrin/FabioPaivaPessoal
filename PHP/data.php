<h1><?php echo "Aula 8<br>";?></h1>
<?php
// Vai receber a informação que veio do ficheiro aula08

			if($_SERVER["REQUEST_METHOD"]=="POST"){
				$nome=$_REQUEST["nome"];
				$email=$_POST["email"];

				if(empty($nome)){
					echo "Nome não foi preenchido<.br>";
				}else{
					echo "O nome é ".$nome.".<br>";
				}
                if(empty($email)){
					echo "E-mail não foi preenchido.<br>";
				}else{
					echo "O e-mail é ".$email.".<br>";
				}
			}
?>