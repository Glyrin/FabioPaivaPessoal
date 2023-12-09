<html>
	<head>
        <title>UFCD 0793</title>
        <link rel="stylesheet" href="tarefa06_Styles.css">
        </head>

	<body>
        <?php include "tarefa06_Cabeçalho.php"?>
        <?php 
            $sql_ufcds="SELECT * FROM ufcds WHERE codigo_ufcd=0793;";
                $resultados=mysqli_query($conn,$sql_ufcds);
                    if(mysqli_num_rows($resultados)>0){
                        while($linha=mysqli_fetch_assoc($resultados)){
                        $cod="0".$linha["codigo_ufcd"];
                        $nome=$linha["nome"];
                        $desc=$linha["descricao"];
                        }
                    }
        ?>
        <table align="center">
            <tr>
                <td>
                    <div class="cod">
                        <?php echo $cod; ?>
                    </div>
                </td>
                <td>
                    <div class="titdis">
                    <?php echo $nome; ?>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="texto1">
                        <?php echo $desc; ?>
                    </div>
                </td>
            </tr>  
        </table>
        <div class="texto4">
            Listagem de trabalhos:<br><br>
            <?php 
            $sql_trabalhos="SELECT t.nome, t.caminho, u.codigo_ufcd FROM trabalhos AS t INNER JOIN ufcds AS u ON t.codigo_ufcd = u.id WHERE U.codigo_ufcd=793;";
                    $resultados=mysqli_query($conn,$sql_trabalhos);
                    if(mysqli_num_rows($resultados)>0){
                            while($linha=mysqli_fetch_assoc($resultados)){
                                    $nome=$linha["nome"];
                                    $cam=$linha["caminho"];
                                    echo "<a href='".$cam."'>".$nome."</a><br>";
                            }
                    }
            ?>
        </div>
        <?php mysqli_close($conn); ?>
	</body>
</html>