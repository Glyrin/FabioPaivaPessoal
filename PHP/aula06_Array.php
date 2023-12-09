<h1><?php echo "Aula 6<br>";?></h1>
<!DOCTYPE html>
<html>
	<head></head>
	<body>
		<h4><?php 
			/*
			Array - guarda variáveis do mesmo tipo lá dentro, só texto, só números, etc...
            ordem do último elemento do array, é igual ao tamanho do array menos 1, porque começa contagem em zero
            percorre-se o array usando ciclos
			*/

            // !!! ESTE É O ARRAY QUE VAMOS UTILIZAR QUASE SEMPRE !!!

            // Array Normal
			$nomeVariavel = array("a","b","c"); //estabelece o array
            $tamanhoArray = count($nomeVariavel); //conta o número de elementos do array
            $nomeVariavel[1]; //vai buscar o elemento ao array com a ordem específica, 1 neste caso
            $nomeVariavel[1] = "k"; //altera o valor do elemento naquela posição

            //percorrer o array
            for($i=0;$i<count($nomeVariavel);$i++){
                echo $nomeVariavel[$i].", ";
            }

            // ! ISTO DÁ MUITO JEITO PARA RESOLVER EXERCÍCIOS !

            //arrays podem ser abertos como vazios
            $vazio=array();
            //e podem ser inseridos valores lá atravez de um ciclo for
            for($p=count($original)-1;$p>=0;$p--){
                $vazio[]=$original[$p]; // insere no primeiro campo vazio do novo array o valor que estiver no ciclo naquela altura
            }

            echo "<br><br>";

            // !!! ESTE ARRAY QUASE NUNCA É UTILIZADO, FOI DADO COMO COMPLEMENTO DA TEORIA,
            // A FUNÇÃO FOREACH É A ÚNICA COISA QUE PODE SER ÚTIL PARA EXERCÍCIOS !!!

            // Array associativo
            $nomeVariavel = array("Pedro"=>"Aluno","João"=>"Professor","Francisco"=>22); //estabelece o array
            //neste caso: "Pedro" é a chave; => é como se fosse uma seta que envia para o valor; "Aluno" é o valor
            echo $nomeVariavel["Pedro"]; //imprime Aluno que é o avlor da chave "Pedro"
            $nomeVariavel["Pedro"]="Professor"; //Altera o valor da chave "Pedro"

			echo "<br><br>";

            // Ciclos para este tipo de elemento
            // $nomeVariavel é a ordem
            // $chave é o conteúdo que demos na chave ao criar o array
            // $valor é o conteúdo que demos no valor ao criar o array
            foreach($nomeVariavel as $chave=>$valor){
                echo "Chave: ".$chave."; valor: ".$valor;
                echo "<br>";
            }
			?>
		</h4>
	</body>