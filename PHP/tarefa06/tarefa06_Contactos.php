<html>
	<head>
        <title>Contactos</title>
        <link rel="stylesheet" href="tarefa06_Styles.css">
    </head>

	<body>
        <?php include "tarefa06_Cabeçalho.php"?>
        <?php 
            $sql_alunos="SELECT * FROM alunos;";
                $resultados=mysqli_query($conn,$sql_alunos);
                    if(mysqli_num_rows($resultados)>0){
                        while($linha=mysqli_fetch_assoc($resultados)){
                        $telefone=$linha["telefone"];
                        $email=$linha["email"];
                        }
                    }
        ?>
        <div class="subtitulos">
                Contactos
                        <table class="texto2">
                                <tr>
                                        <td width="400px">Email: <?php echo $email; ?></td>
                                        <td>Telefone: <?php echo $telefone; ?></td>
                                </tr>
                        </table>
        </div>
        <div class="espaco" align="center"></div>
        <div class="subtitulos">
                Formulário contacto
                <div class="texto3">
                        <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="POST">
                                <label>Nome:</label>
                                <br>
                                <input class="texto4" type="text" id="nome" name="nome" required placeholder=" Insira o seu nome completo"><br>
                                <label>Email</label>
                                <br>
                                <input class="texto4" type="email" id="email" name="email" required placeholder=" Insira o endereço de e-mail"><br>
                                <label>Assunto</label>
                                <br>
                                <select class="texto4" name="ufcd" id="ufcd">
                                        <option selected>Por favor, escolha uma opção</option>
                                        <?php 
                                        $sql_ufcds="SELECT * FROM ufcds;";
                                                $resultados=mysqli_query($conn,$sql_ufcds);
                                                if(mysqli_num_rows($resultados)>0){
                                                        while($linha=mysqli_fetch_assoc($resultados)){
                                                        $cod="0".$linha["codigo_ufcd"];
                                                        $nome=$linha["nome"];
                                                        $desc=$linha["descricao"];
                                                        echo "<option>".$nome."</option>";
                                                        }
                                                }
                                        ?>
                                </select><br>
                                <label>Mensagem</label><br>
                                <textarea class="texto4" type="text" id="msn" name="msn" required placeholder=" Insira a sua mensagem" rows="6"></textarea><br><br>
                                <input class="botao" type="submit" value="Enviar">
                        </form>
                        <?php
			if($_SERVER["REQUEST_METHOD"]=="POST"){
				$nome=$_POST["nome"];
				$email=$_POST["email"];
				$ufcd=$_POST["ufcd"];
                                $msn=$_POST["msn"];

                                if($ufcd=="Por favor, escolha uma opção"){
                                        echo "Insira o assunto";
                                }

                                $procura=mysqli_query($conn, "select id from ufcds where nome='".$ufcd."'");
                                if(mysqli_num_rows($procura)>0){
                                        while($linha=mysqli_fetch_assoc($procura)){
                                              $FK=$linha["id"];
                                        }
                                }
                                
                                $sql = "INSERT INTO contactos(nome, email, assunto, mensagem) VALUES ('$nome', '$email','$FK', '$msn');";
                                $inserir = mysqli_query($conn, $sql);
			}
                
			?>
                </div>
        </div>
        <?php mysqli_close($conn); ?>
	</body>
</html>