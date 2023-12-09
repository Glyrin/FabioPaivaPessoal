<html>
	<head>
        <title>Inserir trabalhos</title>
        <link rel="stylesheet" href="tarefa06_Styles.css">
    </head>

	<body>
        <?php include "tarefa06_Cabeçalho.php"?>
        <div>
            <table align="center">
                <tr>
                    <td class="titulos2">Inserir Trabalhos</td>
                    <td class="enviar"><div class="enviar"><a href="#">Enviar</a></div></td>
                </tr>
            </table>
        </div>
        <div class="espaco" align="center"></div>
        <div class="subtitulos">
                Inserir a informação necessária
                <div class="texto1">
                        <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="POST">
                        <label>Aluno:</label>
                        <select name="aluno" id="aluno" class="pesquisa" required>
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
                        </select><br>
                        <label>UFCD:</label>
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
                        </form>
                </div>
                <div class="fundo">
                        Em Manutenção
                        <img src="https://gifs.eco.br/wp-content/uploads/2022/10/gifs-de-manutencao-5.gif" class="centrarelemento">
                </div>
        </div>
    <?php mysqli_close($conn); ?>
    </body>
</html>