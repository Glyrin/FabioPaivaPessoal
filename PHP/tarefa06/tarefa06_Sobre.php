<html>
	<head>
        <title>Sobre</title>
        <link rel="stylesheet" href="tarefa06_Styles.css">
    </head>

	<body>
        <?php include "tarefa06_Cabeçalho.php"?>
        <?php 
            $sql_alunos="SELECT * FROM alunos;";
                $resultados=mysqli_query($conn,$sql_alunos);
                    if(mysqli_num_rows($resultados)>0){
                        while($linha=mysqli_fetch_assoc($resultados)){
                        $foto=$linha["foto"];
                        $nome=$linha["nome"];
                        $desc=$linha["descricao"];
                        }
                    }
        ?>
        <div>
        <table align="center">
            <tr>
                <td>
                    <div class="foto">
                        <img src="<?php echo $foto; ?>" height="190px" class="centrarelemento">
                    </div>
                </td>
                <td>
                    <div class="nome">
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
    <?php mysqli_close($conn); ?>
    </body>
</html>