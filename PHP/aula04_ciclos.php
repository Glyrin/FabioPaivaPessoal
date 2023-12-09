<h1><?php echo "Aula 4<br>";?></h1>
<!DOCTYPE html>
<html>
	<head></head>
	<body>
		<h4><?php 
			/*
			automatizar um número de tarefas as vezes que forem necessárias
			while - enquanto - testar uma condição sem saber quantas vezes vai ser executado e verificação no fim
			for - para - testar uma condição quando sabemos quantas vezes vamos executar e verificação no fim
			do{}while - fazer enquanto - não se sabe quantas vezes vai ser executada e verificação é feita no fim
			*/
			// ciclo while
			$num=1;
			while($num<=5){
				echo $num."<br>";
				$num++;
			} // para quando $num=6

			echo "<br>";
			$n=1;
			while($n<=10){
				echo ($n*10)."<br>";
				$n++;
			}
			// ciclo do{}while
			echo "<br>";
			$num=0;
			do{
				echo $num."<br>";
				$num++;
			}while($num<=5);
			echo "<br>";
			$num=6;
			do{
				echo $num."<br>";
				$num++;
			}while($num<=5); // como a condição é falsa devolve o 6 apesas do erro mas depois pára

			echo "<br>";
			$num=1;
			do{
				echo ($num*10)."<br>";
				$num++;
			}while($num<=10);
			
			//ciclo for
			echo "<br>";
			for($i=0;$i<=10;$i++){
				echo $i."<br>";
			}

			echo "<br>";
			for($i=1;$i<=10;$i++){
				echo ($i*10)."<br>";
			}
			echo "<br>";
			for($i=10;$i<=100;$i=$i+10){
				echo $i."<br>";
			}

			echo "<br>";
			$n=10;
			while($n>0){
				echo $n."<br>";
				$n=$n-1;
			}
			echo "<br>";
			for($i=10;$i>0;$i--){
				echo $i."<br>";
			}
			echo "<br>";
			for($i=10;$i>0;$i--){
				if($i%2==0){
				echo "O número ".$i." é par!<br>";
				}
			}
			echo "<br>";
			for($i=9;$i>0;$i--){
				if($i%2!=0){
				echo "O número ".$i." é ímpar!<br>";
				break; // para o ciclo quando a a condição se verifica com a primreira verificaçãp verdadeira
				}
			}
			echo "<br>";
			for($i=9;$i>0;$i--){
				if($i%2!=0){
				echo "O número ".$i." é ímpar!<br>";
				continue; // continua o ciclo enquanto a condição se verifica, quando não se verifica vai para o passo seguinte
				}
				echo "Olá! Sou o número".$i."<br>";
			}

			$soma+=$i; //$soma=$soma+$i;
			?>
		</h4>
	</body>