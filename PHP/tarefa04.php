<?php "Tarefa 4";?>
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
<!--
    <h4>Exercício ?<br></h4>
    <h5>Pergunta<br></h5>
    <div class="texto">
        <?php

        ?>
    </div>
-->
	<body>
        <h1>Tarefa 4<br></h1>
		<h4>Exercício 1<br></h4>
        <h5>Menor de 3 números<br></h5>
        <div class="texto">
            <?php
            function menor($n1,$n2,$n3){
                echo "Numeros escolhidos :".$n1.", ".$n2.", ".$n3.".<br>";
                $m=$n1;
                if($n2<$n1){$m=$n2;}
                if($n3<$n2){$m=$n3;}
                return $m;
            }
            echo "O menor dos números é o ".menor(rand(), rand(), rand()).".<br>";
            ?>
        </div>
        <h4>Exercício 2<br></h4>
        <h5>Média de 3 números<br></h5>
        <div class="texto">
            <?php
            function media($n1,$n2,$n3){
                echo "Numeros escolhidos :".$n1.", ".$n2.", ".$n3.".<br>";
                $med=($n1+$n2+$n3)/3;
            return $med;
            }
            echo "A média dos números é ".media(rand(), rand(), rand()).".<br>";
            ?>
        </div>
        </div>
        <h4>Exercício 3<br></h4>
        <h5>Caracteres centrais de uma string<br></h5>
        <div class="texto">
            <?php
            function central($texto){
                echo "String original: ".$texto."<br>";
                $t=strlen(trim($texto));
                if ($t%2==0){
                    $centro="Os caracteres centrais da string são: ".substr($texto,(($t/2)-1),2);
                    // -1 para retornar correto uma vez que a os lugares de posição começam em zero
                }else{
                    $centro="O caracter centra da string é: ".substr($texto,($t/2),1);
                    // não precisa de -1 porque a parte inteira da divisão já corrige o começar a posição em 0
                }
                
            return $centro;
            }
            echo central("desespero").".<br>";
            ?>
        </div>
        <h4>Exercício 4<br></h4>
        <h5>Número de vogais numa string<br></h5>
        <div class="texto">
            <?php
            function vogais($txt){
                $tam=strlen($txt);
                $cont=0;
                for($p=0;$p<$tam;$p++){
                    if(substr($txt,$p,1)=="a" || substr($txt,$p,1)=="e" || substr($txt,$p,1)=="i" || substr($txt,$p,1)=="o" || substr($txt,$p,1)=="u" || 
                       substr($txt,$p,1)=="A" || substr($txt,$p,1)=="E" || substr($txt,$p,1)=="I" || substr($txt,$p,1)=="O" || substr($txt,$p,1)=="U" ||
                       substr($txt,$p,1)=="á" || substr($txt,$p,1)=="é" || substr($txt,$p,1)=="í" || substr($txt,$p,1)=="ó" || substr($txt,$p,1)=="ú" ||
                       substr($txt,$p,1)=="Á" || substr($txt,$p,1)=="É" || substr($txt,$p,1)=="Í" || substr($txt,$p,1)=="Ó" || substr($txt,$p,1)=="Ú" ||
                       substr($txt,$p,1)=="à" || substr($txt,$p,1)=="ã" || substr($txt,$p,1)=="õ" || substr($txt,$p,1)=="â" || substr($txt,$p,1)=="ê" ||
                       substr($txt,$p,1)=="À" || substr($txt,$p,1)=="Ã" || substr($txt,$p,1)=="Õ" || substr($txt,$p,1)=="Â" || substr($txt,$p,1)=="Ê" ||
                       substr($txt,$p,1)=="ô" || substr($txt,$p,1)=="Ô"){
                        // não reconhece diferença entre maiusculas, minusculas ou letras com acentos, em código são caracteres diferentes, daí ter mais condições no if
                        $cont++;
                    }
                }
                $resposta="A palavra ".$txt.", tem ".$cont." vogais.";

                return $resposta;
            }
                echo vogais("Songamonga");
            ?>
        </div>
        <h4>Exercício 5<br></h4>
        <h5>Número de palavras numa string<br></h5>
        <div class="texto">
            <?php
            function npal($texto){
                echo "String original: ".$texto."<br>";
                $np="A string tem ".str_word_count(trim($texto),0,"áàãâéèêíìîóòõôúùûçÁÀÃÂÉÈÊÍÌÎÓÒÕÔÚÙÛÇ")." palavras<br>";
                // str_word_count usa caracteres ASCII, que são reconhece todos os caracteres portugueses
                // não reconhece letras com acentos isoladas no texto como sendo palavras, ex: "é" "à" ..., conflito entre str_word_count e caracteres específicos da língua
                
            return $np;
            }
            echo npal("Quero é ir para casa ");
            ?>
        </div>
        <h4>Exercício 6<br></h4>
        <h5>Somatório dos digitos de um número<br></h5>
        <div class="texto">
            <?php
            function somatorio($n1){
                echo "O número selecionado é: ".$n1."<br>";
                $o=$n1;
                $soma=0;
                while($n1>=1){
                    $resto=$n1%10;
                    $soma=$soma+$resto;
                    $n1=$n1/10;
                }
                $r="A soma dos dígitos de ".$o.", é o número ".$soma.".<br>";
                
                return $r;
            }
            echo somatorio(rand());
            ?>
        </div>
        <h4>Exercício 7<br></h4>
        <h5>Será o ano bissexto ou não?<br></h5>
        <div class="texto">
            <?php
            function bi($ano){
                $bissexto=false;
                if($ano % 4 ==0 && $ano % 100 !=0 || $ano % 400 ==0){
                    $bissexto=true;
                }

                if($bissexto==true){
                    $b="O ano ".$ano." é bissexto";
                }else{
                    $b="O ano ".$ano." não é bissexto";
                }
                return $b;
            } 
            echo bi(rand(1,2100));
            ?>
        </div>
        <h4>Exercício 8<br></h4>
        <h5>A palavra passe é válida?<br></h5>
        <div class="texto">
            <?php
            function verificar($pass){
                echo "Palavra-passe inserida: ".$pass."<br>";
                $tp=strlen($pass);
                if ($tp<8){
                    $v="A senha tem de ter pelo menos 8 caracteres.";
                }elseif(!ctype_alnum($pass)){
                    // não demos !ctype_alnum(), significa que os caracteres não podem ser diferentes de letras e números
                    $v="A senha só pode conter letras e números, por favor também não utilize acentos.";
                }else{
                    $c=0;
                    for($p=0; $p<$tp;$p++){
                        if(is_numeric($pass[$p])){
                            $c++;
                        }
                    }

                    if($c<2){
                        $v="A senha tem de ter pelo menos 2 números";
                    }else{
                        $v="Palavra-passe é válida";
                    }
                }

                return $v;
            }
                echo verificar("JeSuisTresContent420");
            ?>
        </div>
        <h4>Exercício 9<br></h4>
        <h5>Área de um triângulo<br></h5>
        <div class="texto">
            <?php
            function area($b,$a){
                if($b<=0||$a<=0){
                    $area="Impossivél calcular, pelo menos um dos valores não é válido";
                }else{
                    $area="A base é ".$b." e a altura é ".$a.".<br>A área do triângulo é ".($b*$a/2).".";
                }

                return $area;
            } 
            echo area(rand(1,10),rand(1,10));
            ?>
        </div>
	</body>