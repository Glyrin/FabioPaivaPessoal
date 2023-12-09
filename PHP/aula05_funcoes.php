<h1><?php echo "Aula 5<br>";?></h1>
<!DOCTYPE html>
<html>
	<head></head>
	<body>
		<h4><?php 
			/*
			
			*/

            //Exemplo 1
			function escreveOla(){
                echo "Olá pessoal";
            }

            escreveOla();
            echo "<br><br>";
            
            //Exemplo 2
            function escreveNome($nome){
                echo "Olá, ".$nome;
            }

            $meuNome="António";
            escreveNome("$meuNome");
            echo "<br><br>";

            //Exemplo 3
            function somaNumeros($n1, $n2){
                $soma=$n1+$n2;
                echo "soma = ".$soma;
            }
            somaNumeros(3,4);
            echo "<br><br>";

            //Exemplo 4
            $coiso;
            function somaNumeros2($n1, $n2){
                $soma=$n1+$n2;
                return $soma;
            }
            
            $coiso=somaNumeros2(5,4);
            echo $coiso;
            echo "<br><br>";

            //Exemplo 4
            function maior($n1, $n2){
                return $n1<$n2;
            }
            
            echo maior(3,2); // se for falso não retorna nada, só retorna se for verdadeiro
            echo "<br><br>";
			?>
		</h4>
	</body>