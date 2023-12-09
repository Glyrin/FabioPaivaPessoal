<h1><?php echo "Aula 9<br>";?></h1>
<?php include "config.php"?>
<!DOCTYPE html>
<html>
    <?php include "header.php"?>
	<body>
        <?php
            if(!$conn){// se não existir ligação
                die("Ligação não efetuada!<br>".mysqli_connect_error());
            }
/* 
    // verificar a ligação
            if(!$conn){// se não existir ligação
                die("Ligação não efetuada!<br>".mysqli_connect_error());
            }else{
                echo "Ligação efetuada com sucesso!";  
            }

    // inserir dados numa base de dados
            $sql="INSERT INTO utilizadores (nome,username,ativo) VALUES('João', 'joao56789',true)";

            if(mysqli_query($conn,$sql)){
                echo "Novo utilizador inserido";
            }else{
                echo "Erro ao inserir:<br>".mysqli_error($conn);
            }
    // eliminar dados é igual ao insert mas com o comando DELETE INTO
*/
    //fazer pesquisas na base de dados
            $sql="SELECT * FROM utilizadores;";
            $resultados=mysqli_query($conn,$sql);
            if(mysqli_num_rows($resultados)>0){
                while($linha=mysqli_fetch_assoc($resultados)){
                    // os resultados saem como array associativo
                    echo "id: ".$linha["id"]."; Nome: ".$linha["nome"]."; Username: ".$linha["username"];
                    echo "<br>";
                }
            }else{
                echo "Não existem resultados a apresentar";
            }
            
            
            mysqli_close($conn);
        ?>
        <?php include "footer.php"?>
	</body>
</html>