<?php "Tarefa 3";?>
<!DOCTYPE html>
<html>
	<head>
        <style>
            /*
            font-family: 'Pacifico', cursive;
            font-family: 'Permanent Marker', cursive;
            font-family: 'Patrick Hand', cursive;
            */

            @import url('https://fonts.googleapis.com/css2?family=Pacifico&family=Patrick+Hand&family=Permanent+Marker&display=swap');
            body{
                background: radial-gradient(rgb(0, 0, 0), rgb(5, 23, 56));
            }
            h1{
                text-align: center;
                color: rgb(241, 234, 215);
                font-family: 'Pacifico', cursive;
                font-size: 50px;
            }
            h4{
                padding-left: 15px;
                padding-right: 15px;
                width: 150px;
                height: 30px;
                border-radius: 55px;
                border: none;
                background-color: rgb(241, 234, 215);
                font-family: 'Permanent Marker', cursive;
                text-align: center;
                font-size: larger;
                color: rgb(5, 23, 56);
            }
            h5{
                padding-left: 15px;
                color: rgb(241, 234, 215);
                font-size: larger;
                font-family: 'Patrick Hand', cursive;
            }
            .texto{
                border-radius: 10px;
                padding: 5px;
                padding-left: 15px;
                background-color: rgba(243, 237, 220, 0.048);
                color: rgb(241, 234, 215);
                font-weight: bolder;
            }
        </style>
    </head>
	<body>
        <h1>Tarefa 3<br></h1>
		<h4>Exercício 1<br></h4>
        <h5>Escreva um programa que imprima os primeiros 10 números inteiros.<br></h5>
        <div class="texto">
            <?php
                $num=1;
                while($num<=10){
                    echo $num."<br>";
                    $num++;
                }
            ?>
        </div>
        <h4>Exercício 2<br></h4>
        <h5>Escreva um programa que peça 1 número ao utilizador e imprima a sua tabuada.<br></h5>
        <div class="texto">
            <?php
                $num=rand(0,10);
                $tab=0;
                while($tab<=12){
                    echo $num." x ".$tab." = ".($num*$tab)."<br>";
                    $tab++;
                }
            ?>
        </div>
        <h4>Exercício 3<br></h4>
        <h5>Escreva um programa que peça 1número ao utilizador e o imprima na sua ordem inversa.<br></h5>
        <div class="texto">
            <?php
                $num=rand();
                $o=$num;
                $inv="";
                while($num>=1){
                    $resto=$num%10;
                    $inv=$inv.$resto;
                    $num=$num/10;
                }
                echo "O número inverso de ".$o.", é o número ".$inv.".<br>"
            ?>
        </div>
        <h4>Exercício 4<br></h4>
        <h5>Escreva um programa que peça 1 número ao utilizador e calcule a soma dos seus dígitos.<br></h5>
		<div class="texto">
            <?php
                $num=rand();
                $o=$num;
                $soma=0;
                while($num>=1){
                    $resto=$num%10;
                    $soma=$soma+$resto;
                    $num=$num/10;
                }
                echo "A soma dos dígitos de ".$o.", é o número ".$soma.".<br>"
            ?>
        </div>
        <h4>Exercício 5<br></h4>
        <h5>Escreva um programa que imprima todos os números inteiros (entre 101 e 200) que são divisíveis por 9, e apresentea soma de todos esses números.<br></h5>
        <div class="texto">
            <?php
                $num=101;
                $soma=0;
                while($num<=200){
                    if($num%9==0){
                        echo $num." é divisível por 9.<br>";
                        $soma=$soma+$num;
                    }
                $num++;
                }
                echo "<br>A soma dos multiplos de 9 entre 101 e 200 é ".$soma.".<br>";
            ?>
        </div>
        <h4>Exercício 6<br></h4>
        <h5>Escreva um programa que peça um número ao utilizador e indique se é um número primo.<br></h5>
        <div class="texto">
            <?php
                $num=rand(1,9999);
                $primo=true;
                    if($num==1){
                        $primo=false;
                    }elseif($num!=2 && $num%2==0){
                        $primo=false;
                    }for($n=3;$n<=($num/2);$n=$n+2){
                        if($num%$n==0){
                            $primo=false;
                            break;
                        }
                    }

                if($primo==true){
                    echo $num." é número primo.<br>";
                }else{
                    echo $num." não é número primo.<br>";
                }
            ?>
        </div>
        <h4>Exercício 7<br></h4>
        <h5>Escreva um programa que peça um número ao utilizador e indique se é capicua.<br></h5>
        <div class="texto">
            <?php
                $num=rand();
                $o=$num;
                $inv="";
                while($num>=1){
                    $resto=$num%10;
                    $inv=$inv.$resto;
                    $num=$num/10;
                }
                if($o==$inv){
                    echo "O número ".$o.", é capicua.<br>";
                }else{
                    echo "O número ".$o.", não é capicua.<br>";
                }
            ?>
        </div>
        <h4>Exercício 8<br></h4>
        <h5>Escreva um programa que peça ao utilizador um número de bases de um número e apresente o quadrado de cada uma dessas bases.(Ex: 12= 1, 22= 4, ...).<br></h5>
        <div class="texto">
            <?php
                $num=rand(1,10);
                echo "Bases ao quadrado pedidas: ".$num."<br>";
                echo "<br>( ";
                for($base=1;$base<=$num;$base++){
                    $quad=pow($base,2);
                    echo $base."<sup>2</sup> = ".$quad."; ";
                }
                    echo " ...).";
            ?>
        </div>
        <h4>Exercício 9<br></h4>
        <h5>Escreva um programa que peça ao utilizador a quantidade de números ímpares a somar, e apresente a sua soma.<br></h5>
        <div class="texto">
            <?php
                $num=rand(1,10);
                echo "Foi pedida a soma dos primeiros ".$num." números inteiros ímpares.<br>";
                $imp=1;
                $soma=0;
                while($imp<($num*2)){
                        $soma=$soma+$imp;
                        $imp=$imp+2;
                }
                echo "<br>A soma dos números ímpares é ".$soma.".<br>";
            ?>
        </div>
        <h4>Exercício 10<br></h4>
        <h5>Escreva um programa que peça 1 número ao utilizador e calculeo seu fatorial.<br></h5>
        <div class="texto">
        <?php
            $num=rand(1,10);
            $fat=1;
            for($f=$num;$f>=1;$f--){
                $fat=$fat*$f;
            }
            echo "O fatorial de (".$num."!) é ".$fat.".<br>";
		?>
        </div>
        <h4>Exercício 11<br></h4>
        <h5>Escreva um programa que peça um nome ao utilizador, tente adivinhar esse nome e quando o conseguir imprima o número de tentativa que realizou até o conseguir.<br></h5>
        <div class="texto">
        <?php
        // António deu autorização para saltar
        /*
        - especificar uma palavra
        - contar caracteres na palavra
        - gerar texto aleatório com o mesmo número de caracteres da palavra original
        - iniciar variável de contagem em 1
        - ciclo para gerar texto aleatório até texto gerado ser igual ao texto original, por cada tentativa fazer +1 ao contador
        - quando acertar na palavra imprimir palavra original e valor da contagem
        */
            echo "Não demos como gerar texto aleatório."
		?>
        </div>
        <h4>Exercício 12<br></h4>
        <h5>Escreva um programa para a música “Beer Song”. Começamos com 99 cervejas, e enquanto houver cervejas o programa deverá ir apresentando o seguinte ouput:<br>
        “99 bottles of beer on the Wall<br>
        99 bottles of beer<br>
        Take one down.<br>
        Pass it around.” ...<br></h5>
        <div class="texto">
        <?php
            echo "<b>Beer Song</b><br><br>";
            $num=99;
            while($num>=1){
				echo
                $num." botles of beer on the Wall<br>".
                $num." botles of beer<br>
                Take one down.<br>
                Pass it around.<br><br>";
				$num--;
			}
            echo "No more bottles of beer on the Wall.<br>
            You go to the store and buy some more<br>
            99 botles of beer back on the Wall.<br>";
		?>
        </div>
        <h4>Exercício 13<br></h4>
        <h5>Escreva um programa que calcula a área de uma casa. Para tal será necessário o utilizador inserir a área de cada uma das divisões da casa. 
            O programa deverá pedir área de cada uma das divisões enquanto o utilizador responder “sim” quando questionado se tem mais divisões a inserir.<br></h5>
            <div class="texto">
        <?php
            $divisoes=rand(2,10);
            echo "Número de divisões = ".$divisoes.".<br><br>";
            $soma=0;
            $Ndiv=1;
            while($Ndiv<=$divisoes){
                $area=rand(4,100);
                echo "Área da ".$Ndiv."ª divisão tem ".$area."m<sup>2</sup>.<br>";
                $soma=$soma+$area;
                $Ndiv++;
            }
            echo "<br>A área total da casa é de ".$soma."m<sup>2</sup>.<br>";
		?>
        </div>
	</body>