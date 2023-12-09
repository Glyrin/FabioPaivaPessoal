<?php echo "<h1>Tarefa 2</h1>";?>
<!DOCTYPE html>
<html>
	<head></head>
	<body>
		<h4>Exercício 1<br></h4>
		<?php
			$n1=rand();
			$n2=rand();
            if($n1==$n2){
                echo $n1." e ".$n2." são iguais";
            }else{
                echo $n1." e ".$n2." não são iguais";
            }
		?>
		<h4>Exercício 2<br></h4>
		<?php
			$n1=rand();
            if($n1<0){
                echo $n1." é negativo.";
            }elseif($n1==0){
                echo $n1." é zero.";
            }else{
                echo $n1." é positivo.";
            }
		?>
        <h4>Exercício 3<br></h4>
		<?php
			$n1=rand();
            $n2=rand();
            $n3=rand();
            $M=$n1;
            if($n2>$n1){$M=$n2;}
            if($n3>$n2){$M=$n3;}
            echo "Maior número entre (".$n1.", ".$n2.", ".$n3.")<br>";
            echo $M." é o maior dos números.";
		?>
        <h4>Exercício 4<br></h4>
		<?php
			$n1=rand();
            $n2=rand();
            if($n2==0){
                echo "Impossivél, o segundo número é zero. Todos os números que multipliquem por zero, dão zero. Logo zero não tem múltiplos.<br>";
            }else{
                $M=$n1%$n2;
                if($M==0){
                    echo "O número ".$n1." é multiplo de ".$n2.".<br>";
                }else{
                    echo "O número ".$n1." não é multiplo de ".$n2.".<br>";
                }
            }
		?>
        <h4>Exercício 5<br></h4>
		<?php
			$n1=rand();
            $p=$n1%2;
            if($n1/2==0 && $p==0){
                echo "O número ".$n1." é zero, logo, não é par nem ímpar.<br>";
            }elseif($p==0){
                echo "O número ".$n1." é par.<br>";
            }else{
                echo "O número ".$n1." é ímpar.<br>";
            }
		?>
        <h4>Exercício 6<br></h4>
		<?php
			$n1=rand(20, 280)/100;
            if($n1<0.24){
                echo "Uma pessoa com ".$n1."m de altura é baixíssima.<br>";
                echo "Novo recorde do Guiness. A pessoa mais pequena à nascença tinha 24 centímetros.<br>";
            }elseif($n1<1.30){
                echo "Uma pessoa com ".$n1."m de altura é baixíssima.<br>";
            }elseif($n1<1.60){
                echo "Uma pessoa com ".$n1."m de altura é baixa.<br>";
            }elseif($n1<1.75){
                echo "Uma pessoa com ".$n1."m de altura é mediana.<br>";
            }elseif($n1<1.90){
                echo "Uma pessoa com ".$n1."m de altura é alta.<br>";
            }elseif($n1<2.75){
                echo "Uma pessoa com ".$n1."m de altura é altíssima.<br>";
            }else{
                echo "Uma pessoa com ".$n1."m de altura é altíssima.<br>";
                echo "Novo recorde do Guiness. A pessoa mais mais alta do mundo tinha 2,74m de altura.<br>";
            }
		?>
        <h4>Exercício 7<br></h4>
		<?php
			$n1=rand();
            $n2=rand();
            $op="+";
            if($op!="+" && $op!="-" && $op!="*" && $op!="/"){
                echo "Operador inválido. Por favor corrigir.<br>";
            }elseif($n2==0 && $op=="/"){
                echo "A divisão por zero dá infinito.<br>";
            }else{
                switch($op){
                    case "+":
                        echo "Soma entre ".$n1." e ".$n2." = ".($n1+$n2).".<br>";
                        break;
                    case "-":
                        echo "Diferença entre ".$n1." e ".$n2." = ".($n1-$n2).".<br>";
                        break;
                    case "*":
                        echo "Multiplicação entre ".$n1." e ".$n2." = ".($n1*$n2).".<br>";
                        break;
                    case "/":
                        echo "Divisão entre ".$n1." e ".$n2." = ".($n1/$n2).".<br>";
                        break;
                }
            }
		?>
        <h4>Exercício 8<br></h4>
		<?php
            $n1=rand();
            $n2=rand();
            $n3=rand();
            echo "Ordem ascesdente entre (".$n1.", ".$n2.", ".$n3.")<br>";
            if($n1==$n2 || $n1==$n3 || $n2==$n3){
                echo "Existem números iguais.<br>";
            }elseif($n1<$n2 && $n1<$n3){
                if($n2<$n3){
                    echo $n1." < ".$n2." < ".$n3;
                }else{
                    echo $n1." < ".$n3." < ".$n2;
                }
            }elseif($n2<$n3){
                if($n1<$n3){
                    echo $n2." < ".$n1." < ".$n3;
                }else{
                    echo $n2." < ".$n3." < ".$n1;
                }
            }else{
                if($n1<$n2){
                    echo $n3." < ".$n1." < ".$n2;
                }else{
                    echo $n3." < ".$n2." < ".$n1;
                }
            }
		?>
        <h4>Exercício 9<br></h4>
		<?php
			$te1=rand(0,200)/10;
            $te2=rand(0,200)/10;
            $ta1=rand(0,200)/10;
            $ta2=rand(0,200)/10;
            $tf=rand(0,200)/10;
            $p1=0.65;
            $p2=0.15;
            $p3=0.2;
            $NF=($p1*($te1+$te2))/2+($p2*($ta1+$ta2))/2+($p3*$tf);
            if($NF<9.5){
                echo "A nota final do aluno foi ".round($NF,0).". O aluno foi reprovado.<br>";
            }else{
                echo "A nota final do aluno foi ".round($NF,0).". O aluno foi aprovado.<br>";
            }
		?>
	</body>