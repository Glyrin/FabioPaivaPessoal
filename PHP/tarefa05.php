<?php "Tarefa 5";?>
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
        <h1>Tarefa 5<br></h1>
		<h4>Exercício 1<br></h4>
        <h5>Conteúdo do array<br></h5>
        <div class="texto">
            <?php
            echo "Método 1<br>";//mais complexo mas era o que sabia na altura
            $valores = array(rand(1,100),rand(1,100),rand(1,100),rand(1,100),rand(1,100));//rand(1,100) vai gerar valores aleatórios entre 1 e 100 pode usar-se só rand()
            //vai correndo os indices 1 a 1 e imprime o valor que estiver associado
            for($p=0;$p<count($valores);$p++){
                echo $valores[$p]."<br>";
            }
            echo "<br>";

            echo "Método 2<br>";//mais simples porque existe uma função para fazer a impressão de array
            echo "<pre>";
            print_r($valores);
            echo "</pre>";
            // se não tiver o block <pre> antes e </pre> depois ele imprime seguido sem a quebra de linha entre os valores
            ?>
        </div>

        <h4>Exercício 2<br></h4>
        <h5>Somatório de elementos do array<br></h5>
        <div class="texto">
            <?php
            $valores = array(rand(1,100),rand(1,100),rand(1,100),rand(1,100),rand(1,100));
            echo "Método 1<br>";
            //esta parte vai imprimir os valores no array já que usai a função rand() para os determinar
            echo "Valores inseridos no array: ";
            for($p=0;$p<count($valores);$p++){
                echo $valores[$p]."; ";
            }
            //inseri uma variável soma para ir guardando os valores conforme saem e para usar na resposta
            $soma=0;
            //atualizo o resultado da soma com um ciclo que vai somando valor a valor
            for($p=0;$p<count($valores);$p++){
                $soma=$soma+$valores[$p];
            }
            //dou a resposta
            echo "<br>A soma dos valores é ".$soma.".";
            echo "<br><br>";

            echo "Método 2<br>";//mais simples porque existe uma função para fazer a soma
            // imprimo os valores do array já que usai a função rand() para is determinar
            echo "<pre>";
            print_r($valores);
            echo "</pre>";
            // faço a soma e dou a resposta tudo num só
            echo "<br>A soma dos valores é ".array_sum($valores).".";
            //$soma=array_sum($valores);
            ?>
        </div>

        <h4>Exercício 3<br></h4>
        <h5>Média de elementos do array<br></h5>
        <div class="texto">
            <?php
            $valores = array(rand(1,100),rand(1,100),rand(1,100),rand(1,100),rand(1,100));
            echo "Método 1<br>";
            //esta parte vai imprimir os valores no array já que usai a função rand() para is determinar
            echo "Valores inseridos no array: ";
            for($p=0;$p<count($valores);$p++){
                echo $valores[$p]."; ";
            }
            //inseri uma variável soma para ir guardando os valores conforme saem porque não dá para fazer a média direto
            $soma=0;
            //atualizo o resultado da soma com um ciclo que vai somando valor a valor
            for($p=0;$p<count($valores);$p++){
                $soma=$soma+$valores[$p];
            }
            // calculo a média dividindo a $soma pela contagem dos valores no array
            $media=$soma/count($valores);//a função count() faz a contagem de quantos elementos existem dentro do array que é o número total de valores
            //dou a resposta
            echo "<br>A média dos valores é ".$media.".";
            echo "<br><br>";

            echo "Método 2<br>";//mais simples
            // imprimo os valores do array já que usai a função rand() para os determinar
            echo "<pre>";
            print_r($valores);
            echo "</pre>";
            // faço a média dividindo a array_sum() pelo count() e dou a resposta tudo num só
            echo "<br>A média dos valores é ".(array_sum($valores)/count($valores)).".";
            ?>
        </div>

        <h4>Exercício 4<br></h4>
        <h5>O valor existe no array?<br></h5>
        <div class="texto">
            <?php
            // neste como inseri manualmente os valores não me preocupei em mostrar o conteúdo do array
            $nomes = array("Mike Rack","Phil Wood","Moe Lester","Ben Dover","Mike Hunt");
            echo "Método 1<br>";
            // aqui estabeleço uma condição que é o valor que quero encontrar dentro do array
            $cond="Ben Dover";
            // uso um boleano para dizer que o valor não existe
            $ver=false;
            // faço um ciclo que corre os valores todos e procura se a condição existe
            for($p=0;$p<count($nomes);$p++){
                if($nomes[$p]==$cond){// a condição neste if é o que verifica se existe
                    $ver=true;// quando encontra torna o boleano em verdadeiro
                    break;// se encontrar sai logo do ciclo, não precisa de continuar a verificar
                }
            }
            //depois de estar verificado o estado do boleano, dá a resposta
            if($ver==true){// se for verdade
                echo $cond." existe no array.<br>"; 
            }else{// se for falso
                echo $cond." não existe no array.<br>";
            }
            echo "<br><br>";

            echo "Método 2<br>";//mais simples existe uma função que verifica se um valor existe ou não dentro do array
            //usei o mesmo array e condição do método 1
            if(in_array($cond,$nomes)){// se esistir dá esta resposta
                echo $cond." existe no array.<br>"; 
            }else{// se não existir dá esta
                echo $cond." não existe no array.<br>";
            }
            ?>
        </div>

        <h4>Exercício 5<br></h4>
        <h5>Copiar conteúdo de um array para outro<br></h5>
        <div class="texto">
            <?php
            $nomes = array("Mike Rack","Phil Wood","Moe Lester","Ben Dover","Mike Hunt");
            echo "Método 1<br>";
            // como quero demonstrar que são iguais imprimo o 1º array
            echo "Array original: ";
            for($p=0;$p<count($nomes);$p++){
                echo $nomes[$p]."; ";
            }
            echo "<br>";
            // estabeleço que o 2º array é igual ao primeiro
            $outro=$nomes;
            // imprimo o segundo array
            echo "Array cópia: ";
            for($p=0;$p<count($outro);$p++){
                echo $outro[$p]."; ";
            }
            echo "<br><br>";

            echo "Método 2<br>";//imprimo 2º arrau como string de texto
            // uso mesmo array do método 1 e como quero demonstrar que são iguais imprimo o 1º array
            echo "Array original: ";
            for($p=0;$p<count($nomes);$p++){
                echo $nomes[$p]."; ";
            }
            echo "<br>";
            echo "<br>Outro array: ";
            // uso o método do ponto para continuar a escrever à frente de texto existente
            $outro2="array(".$nomes[0];//insiro logo o 1º valor para ficar mais bonito na escrita
            // faço ciclo para ir inserindo os outros valores separados por ,
            for($p=1;$p<count($nomes);$p++){
                $outro2=$outro2.",".$nomes[$p];
            }
            //fecho a string do ciclo com )
            $outro2=$outro2.")";
            // imprimo a string de texto final
            echo $outro2;
            echo "<br><br>";

            echo "Método 3<br>";//o mais simples digo que o segundo array é igual ao 1º
            // usei o mesmo array do método 1
            //imprimo o conteúdo do array nomes
            echo "<pre>";
            print_r($nomes);
            echo "</pre>";
            echo "<br>";
            //"faço a cópia" do array nomes para o array cópia dizendo que são iguais
            $copia=$nomes;
            // imprimo o array cópia
            echo "<pre>";
            print_r($copia);
            echo "</pre>";
            echo "<br>";
            ?>
        </div>

        <h4>Exercício 6<br></h4>
        <h5>Maior e menor números do array<br></h5>
        <div class="texto">
            <?php
            $valores = array(rand(1,10),rand(1,10),rand(1,10),rand(1,10),rand(1,10));
            echo "Método 1<br>";// Método que aprendemos com Ana Maria em JavaScript
            // como usei rand() imprimo os valores do array
            echo "Valores inseridos no array: ";
            for($p=0;$p<count($valores);$p++){
                echo $valores[$p]."; ";
            }
            // defino o valor zero do array como sendo o Maior e o menor ao mesmo tempo
            $Ma=$valores[0];
            $me=$valores[0];
            // faço um ciclo para comparar o valor zero com os restantes
            for($p=0;$p<count($valores);$p++){
                if($valores[$p]<$me){$me=$valores[$p];}// se o valor em causa for menor vai substituindo o valor menor guardado acima
                if($valores[$p]>$Ma){$Ma=$valores[$p];}// se o valor em causa for Maior vai substituindo o valor Maior guardado acima     
            }
            // imprimo os dois resultados
            echo "<br>O maior dos valores é ".$Ma.".";
            echo "<br>O menor dos valores é ".$me.".";
            echo "<br><br>";

            echo "Método 2<br>";//existem funções para fazer isso que podem ser usadas logo na resposta
            // imprimo o array
            echo "<pre>";
            print_r($valores);
            echo "</pre>";
            // imprimo as respostas com as funções específicas
            echo "<br>O maior dos valores é ".max($valores).".";// procura o valor maior e imprime
            echo "<br>O menor dos valores é ".min($valores).".";// procura o valor menor e imprime
            ?>
        </div>

        <h4>Exercício 7<br></h4>
        <h5>Valores do array por ordem inversa<br></h5>
        <div class="texto">
            <?php
            $valores = array(rand(1,10),rand(1,10),rand(1,10),rand(1,10),rand(1,10));
            echo "Método 1<br>";// escrita simples
            // imprimo o array original porque usei rand()
            echo "Valores inseridos no array: ";
            for($p=0;$p<count($valores);$p++){
                echo $valores[$p]."; ";
            }
            // conto quantos elementos tem o array e subtraio 1 porque o array começa em zero logo a Maior ordem de valor é um menos do que a contagem
            $oM=count($valores)-1;
            // imprimo o array ao contrário começando na ordem mais alta $oM, e com incremento negativo $p--
            echo "<br>Valores do array pela ordem inversa: ";
            for($p=$oM;$p>=0;$p--){
                echo $valores[$p]."; ";
            }
            echo "<br><br>";

            echo "Método 2<br>";// criar um segundo array de raíz
            // usei o array do método 1 e imprimi
            echo "<pre>";
            print_r($valores);
            echo "</pre>";
            // crio um array vazio
            $inv=array();
            // insiro os valores no array por ordem inversa
            for($p=$oM;$p>=0;$p--){
                $inv[]=$valores[$p];// insere no array $inv o valor que estiver no momento no ciclo, como comecei do último ele inverte os valores
            }
            // imprimo o array $inv
            echo "<pre>";
            print_r($inv);
            echo "</pre>";
            echo "<br><br>";

            echo "Método 3<br>";// claro que existe uma função para fazer isto :)
            // uso o mesmo array do método 1 e imprimo
            echo "<pre>";
            print_r($valores);
            echo "</pre>";
            // digo que o novo array é o inverso do original
            $rev=array_reverse($valores);
            // imprimo o segundo array
            echo "<pre>";
            print_r($rev);
            echo "</pre>";
            ?>
        </div>

        <h4>Exercício 8<br></h4>
        <h5>Copiar conteúdo de um array para outro, na ordem inversa<br></h5>
        <div class="texto">
            <?php
            $nomes = array("Mike Rack","Phil Wood","Moe Lester","Ben Dover","Mike Hunt");
            echo "Método 1<br>";// escrita simples
            // imprimo o array original
            echo "Array original: ";
            for($p=0;$p<count($nomes);$p++){
                echo $nomes[$p]."; ";
            }
            // crio um array vazio para receber os valores do array original na ordem inversa
            $inv=array();
            // insiro os valores no array por ordem inversa, não me chateei com a variável de ordem maior meti logo no ciclo for
            for($p=count($nomes)-1;$p>=0;$p--){
                $inv[]=$nomes[$p];// insere no array $inv o valor que estiver no momento no ciclo, como comecei do último ele inverte os valores
            }
            // imprimo o array inv
            echo "<br>Valores do array pela ordem inversa: ";
            for($p=0;$p<count($inv);$p++){
                echo $inv[$p]."; ";
            }
            echo "<br><br>";

            echo "Método 2<br>";// usar a função correta e a cabeça
            //imprimo o array original
            echo "<pre>";
            print_r($nomes);
            echo "</pre>";
            // se vou criar um novo array inverso para que preciso da cópia do original antes de inverter? Afinal não vou alterar o original
            // crio o novo array com a função de inversão
            $rev=array_reverse($nomes);
            //imprimo o array invertido
            echo "<pre>";
            print_r($rev);
            echo "</pre>";
            ?>
        </div>

        <h4>Exercício 9<br></h4>
        <h5>Imprimir elementos duplicados dentro de um array<br></h5>
        <div class="texto">
            <?php
            $nomes = array("Mike Rack","Phil Wood","Moe Lester","Ben Dover","Mike Hunt","Mike Rack","Phil Wood");
            echo "Método 1<br>";// ciclo for dentro de outro ciclo for, pouco eficiente em termos de recursos
            echo "Array original: ";// imprimir o array inicial para mostrar que existem duplicados
            for($p=0;$p<count($nomes);$p++){
                echo $nomes[$p]."; ";
            }
            echo "<br><br>";
            //contagem de quantos elementos existem no array para facicitar os ciclos mais tarde
            $cont=count($nomes);
            // ciclo dentro de ciclo
            for ($p=0;$p<$cont;$p++){ // primeiro ciclo corre o array
                for($p2=$p+1;$p2<$cont;$p2++){ // segundo ciclo compara o valor do array contra todos os outros que se seguem
                    if($nomes[$p]==$nomes[$p2]){ // caso encontre que existe outro igual imprime a mensagem
                        echo $nomes[$p]." aparece esté duplicado no array.<br>";
                    }
                }
            }
            echo "<br><br>";

            echo "Método 2<br>";// usar a função própria para isso, é muito mais eficiente em termos de recursos
            //Imprimir o array
            echo "<pre>";
            print_r($nomes);
            echo "</pre>";
            // Usar a função para contar quantas vezes cada elemento aparece no array
            $cont=array_count_values($nomes);
            // ciclo para ver quais os valores que aparecem mais do que uma vez
            foreach($cont as $valor=>$NumOcorrencias){
                if($NumOcorrencias>1){ // quando se repete imprime valor repetido e quantas vezes aparece repetido
                    echo "$valor ocorre $NumOcorrencias vezes.<br>";
                }
            }
            ?>
        </div>

        <h4>Exercício 10<br></h4>
        <h5>Imprimir elementos comuns entre 2 arrays<br></h5>
        <div class="texto">
            <?php
            $nomes1 = array("Mike Rack","Phil Wood","Moe Lester","Ben Dover","Mike Hunt");
            $nomes2 = array("Mike Rack","Chris P. Bacon","Dixon Payne","Ben Dover","Krystal Ball");
            echo "Método 1<br>";// ciclo for dentro de outro ciclo for, pouco eficiente em termos de recursos
            echo "Array 1: ";// imprimir o array 1
            for($p=0;$p<count($nomes1);$p++){
                echo $nomes1[$p]."; ";
            }
            echo "<br>";
            echo "Array 2: ";// imprimir o array 2
            for($p=0;$p<count($nomes2);$p++){
                echo $nomes2[$p]."; ";
            }
            echo "<br><br>";
            // ciclo dentro de ciclo
            for ($p=0;$p<count($nomes1);$p++){ // primeiro ciclo corre o array
                for($p2=0;$p2<count($nomes2);$p2++){ // segundo ciclo compara o valor do array contra os valores do array 2
                    if($nomes1[$p]==$nomes2[$p2]){ // caso encontre um igual imprime
                        echo $nomes1[$p]." existe nos 2 arrays.<br>";
                    }
                }
            }
            echo "<br><br>";
            echo "Método 2<br>";// usar a função própria para isso, é muito mais eficiente em termos de recursos
            //Imprimir o array 1
            echo "<pre>";
            print_r($nomes1);
            echo "</pre>";
            //Imprimir o array 2
            echo "<pre>";
            print_r($nomes2);
            echo "</pre>";
            // estabelecer um array com o que é comum aos 2 arrays com uma interseção
            $comum=array_intersect($nomes1,$nomes2);
            foreach($comum as $valor){
                echo $valor." existe nos dois arrays.<br>";
            }
            ?>
        </div>

        <h4>Exercício 11<br></h4>
        <h5>Com 3 arrays criar uma frase aleatória<br></h5>
        <div class="texto">
            <?php
            // estabeleço os 2 arrays
            $texto1=array("O","Um","Aquele","Algum");
            $texto2=array("Chico","Zé","cão","Joãozinho");
            $texto3=array("sabe a resposta","se nicou","foi apanhado","está maluco");
            echo "Método 1<br>";// função que seleciona elemento aleatório na ordem do array
            $palavra1=$texto1[rand(0,3)];
            $palavra2=$texto2[rand(0,3)];
            $palavra3=$texto3[rand(0,3)];
            //crio uma frase com as palavras escolhidas
            $frase=$palavra1." ".$palavra2." ".$palavra3.".";
            echo $frase;

            echo "<br><br>";
            
            echo "Método 2<br>";// função que seleciona elemento aleatório do array
            // escolhe um elemento à toa de cada array
            $palavra_1=$texto1[array_rand($texto1)];
            $palavra_2=$texto2[array_rand($texto2)];
            $palavra_3=$texto3[array_rand($texto3)];
            //crio uma frase com as palavras escolhidas
            $frase2=$palavra_1." ".$palavra_2." ".$palavra_3.".";
            echo $frase2;

            ?>
        </div>
        <h4>Exercício 12<br></h4>
        <h5>Soma de elementos em 2 arrays e devolver resultado num terceiro array<br></h5>
        <div class="texto">
            <?php
            $valores1 = array(rand(1,10),rand(1,10),rand(1,10),rand(1,10),rand(1,10));
            $valores2 = array(rand(1,10),rand(1,10),rand(1,10),rand(1,10),rand(1,10));
            echo "<br>";
            echo "Método 1<br>";// imprimir em string
            // imprimo o 1º array
            echo "Array 1: ";
            for($p=0;$p<count($valores1);$p++){
                echo $valores1[$p].", ";
            }
            echo "<br>";
            // imprimo o segundo array
            echo "Array 2: ";
            for($p=0;$p<count($valores2);$p++){
                echo $valores2[$p].", ";
            }
            echo "<br>";
            //crio a string da soma
            $somar="array(".($valores1[0]+$valores2[0]);//insiro logo o 1º valor para ficar mais bonito na escrita
            // faço ciclo para ir inserindo os outros valores separados por ,
            for($p=1;$p<count($valores1);$p++){
                $somar=$somar.",".($valores1[$p]+$valores2[$p]);
            }
            //fecho a string da soma com )
            $somar=$somar.")";
            // imprimo a string da soma como texto
            echo $somar;
            echo "<br><br>";
            
            echo "Método 2<br>";// inserir soma num terceiro array
            //Imprimir o array 1
            echo "<pre>";
            print_r($valores1);
            echo "</pre>";
            //Imprimir o array 2
            echo "<pre>";
            print_r($valores2);
            echo "</pre>";
            $soma=array();
            // ciclo para a soma
            for($p=0;$p<count($valores1);$p++){
                $soma[$p]=$valores1[$p]+$valores2[$p];
            }
            //Imprimir o array soma
            echo "<pre>";
            print_r($soma);
            echo "</pre>";
            ?>
        </div>
	</body>