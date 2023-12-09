<html>
	<head>
                <title>Visualizar Trabalhos</title>
                <link rel="stylesheet" href="tarefa06_Styles.css">
                <script>
                        asd
                </script>
        </head>

        <body>
        <?php include "tarefa06_Cabeçalho.php"?>
        <div>
            <table align="center">
                <tr>
                    <td class="titulos2">Pesquisar Trabalhos</td>
                </tr>
            </table>
        </div>
        <div class="espaco" align="center"></div>
        <div class="subtitulos">
                Inserir a informação necessária
                <div class="texto3">
                        <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="POST">
                                <select name="aluno" id="aluno" class="pesquisa">
                                        <option>-</option>
                                        <?php 
                                        $sql_alunos="SELECT * FROM alunos;";
                                                $resultados=mysqli_query($conn,$sql_alunos);
                                                if(mysqli_num_rows($resultados)>0){
                                                        while($linha=mysqli_fetch_assoc($resultados)){
                                                        echo "<option>".$linha["nome"]."</option>";
                                                        }
                                                }
                                        ?>
                                </select>
                                <select name="ufcd" id="ufcd" class="pesquisa">
                                        <option>-</option>
                                        <?php 
                                        $sql_ufcds="SELECT * FROM ufcds;";
                                                $resultados=mysqli_query($conn,$sql_ufcds);
                                                if(mysqli_num_rows($resultados)>0){
                                                        while($linha=mysqli_fetch_assoc($resultados)){
                                                        $cod="0".$linha["codigo_ufcd"];
                                                        $nome=$linha["nome"];
                                                        $desc=$linha["descricao"];
                                                        echo "<option>".$cod." - ".$nome."</option>";
                                                        }
                                                }
                                        ?>
                                </select>
                                <div class="espaco" align="center"></div>
                                <input class="botao" type="submit" value="Procurar">
                        </form>
                </div>
                <div class="espaco" align="center"></div>
                <div class="texto4">
                        Listagem de resusltados<br><br>
                        <?php 
                                if($_SERVER["REQUEST_METHOD"]=="POST"){
                                        $aluno=$_POST["aluno"];
                                        $ufcd=$_POST["ufcd"];

                                        if($aluno=="-"||$ufcd=="-"){
                                                echo "Por favor, preencha correatmente os campos.";
                                        }elseif($ufcd=="00 - Geral"){
                                                $sql_trabalhos="SELECT t.nome, t.caminho, u.codigo_ufcd FROM trabalhos AS t INNER JOIN ufcds AS u ON t.codigo_ufcd = u.id ";
                                                $resultados=mysqli_query($conn,$sql_trabalhos);
                                                if(mysqli_num_rows($resultados)>0){
                                                        while($linha=mysqli_fetch_assoc($resultados)){
                                                                $cod="0".$linha["codigo_ufcd"];
                                                                $nome=$linha["nome"];
                                                                $cam=$linha["caminho"];
                                                                echo "<a href='".$cam."'>".$cod." - ".$nome."</a><br>";
                                                        }
                                                }
                                        }else{
                                                $nomeufcd=explode(" - ",$ufcd);
                                                $nome=$nomeufcd[0];

                                                $sql_trabalhos="SELECT t.nome, t.caminho, u.codigo_ufcd FROM trabalhos AS t INNER JOIN ufcds AS u ON t.codigo_ufcd = u.id WHERE U.codigo_ufcd=$nome;";
                                                $resultados=mysqli_query($conn,$sql_trabalhos);
                                                if(mysqli_num_rows($resultados)>0){
                                                        while($linha=mysqli_fetch_assoc($resultados)){
                                                                $nome=$linha["nome"];
                                                                $cam=$linha["caminho"];
                                                                echo "<a href='".$cam."'>".$nome."</a><br>";
                                                        }
                                                }
                                        }

                                }
                        ?>
                </div>
        </div>
        <?php mysqli_close($conn); ?>
	</body>
</html>