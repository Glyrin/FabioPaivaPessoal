<?php include "config.php";?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portifolio | Administração</title>
    <link rel="stylesheet" href="css\estilo.css">

</head>
<body>
<?php
/* if (isset($_GET['success'])) {

    echo '<div class="success-message"><p>' . $_GET['success'] . '</p></div>';
    ?>
    <form method="GET" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
    <?php


    echo "<input class='inputbotao' type='submit' value='ok' name='ok'>"; 
    $ok = $_GET["ok"];
    if (isset($_GET["ok"])) {
    if($ok="ok"){
        echo "<meta http-equiv='refresh' content='0'>";

    } }

}    */     
        ?>
        <!-- </form> -->










    <header>
        <div class="container">
            <div id="branding">
                <a href="index.html"><img src="img/logopp.svg" alt="Logo"></a>
            </div>
            <nav>
                <ul>
                    <li><a href="about.html">Curso</a></li>
                    <li><a href="materias.php">Disciplinas</a></li>
                    <li><a href="trabalhos.php">Trabalhos</a></li>
                    <li><a href="contact.html">Contacto</a></li>
                    <li class="current"><a href="admin.php">Administração</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <section id="newsletter_trab">
    <div class="container">
            <h1>Administração</h1>
    </div>
    </section>
        <table>
            
            <tr>
                <td class="esquerda1">
                    <div class="col1">
                    <p> <h1>Disciplinas</h1> </p>
                    <p><h3>Clique na disciplina para excluí-la</h3></p>
                    <hr>
                    </div>

                <form method="POST" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
                <?php
                   
                        if (!$connection) {
                            die("Ligação não efetuada!" . mysqli_connect_error());
                        }
                        $sql = "SELECT * FROM disciplinas;";
                        $resultados = mysqli_query($connection, $sql);
                        $n = array();
                        $i=0;
                        if (mysqli_num_rows($resultados) > 0) {
                            /* $i=1; */
                            while ($linha = mysqli_fetch_assoc($resultados)) {
                                echo "<br>";
                                echo "<input class='inputbotao' type='submit' value='".$linha["NomeDisc"]."' name='$i'>";   
                                $n[]= $linha["CodDisc"];
                                $n1[]= $linha["NomeDisc"];
                                $i++;

                            }

                        } else {
                            echo "Não existem resultados a apresentar!";
                        }
                    
                    ?>
                    </form>
                </td>
                <td class="direita1">
        
                    <?php


                    if ($_SERVER["REQUEST_METHOD"] == "POST" && !isset($_POST["codigo"]) && !isset($_POST["codigo1"])) {
                        foreach ($_POST as $key => $value) {
                            if (strpos($key, '0') === 0) {
                               /*  $index = intval($key); */
                                $cod_disc = $n[$key];
                                $nome_disc = $n1[$key];

                                if (!$connection) {
                                    die("Ligação não efetuada!" . mysqli_connect_error());
                                }
                                $sql = "DELETE FROM disciplinas WHERE CodDisc = $cod_disc;";
                                $resultados = mysqli_query($connection, $sql);
                                 echo "<div class='trabalhoadm'>";
                                echo "<div class='retanguloadm'><p class='codigoadm'>Disciplina excluída com sucesso</p><p class='dic'>".$nome_disc."</p></div>";

                                ?>
                                <form method="GET" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
                                <?php
                                echo "<div class='informacoesadm'>";
                                echo "<input class='inputbotaodel' type='submit' value='ok' name='ok'>"; 
                                echo "</div>";
                            
                                /* echo "<input class='inputbotao' type='submit' value='ok' name='ok'>";  */
                                /* $ok = $_GET["ok"]; */
                                if (isset($_GET["ok"])) {
                                if($ok="ok"){
                                    echo "<meta http-equiv='refresh' content='0'>";
                            
                                } }
                                echo "</div>"; 
                                   
                                    ?>
                                    <!-- </form> -->

                                    <?php





     /*                            if ($resultados) {
                                    echo "<meta http-equiv='refresh' content='0'>";
                                    echo "<script>alert('Disciplina $nome_disc excluída com sucesso.');</script>"; 


                                }  */



                                  
/*                                 
                                if ($resultados) {
                                    mysqli_close($connection);
                                    header("Location: {$_SERVER['PHP_SELF']}?success=Disciplina ". $nome_disc." excluída com sucesso.");
                                    exit();
                                } */



                                /* if (mysqli_num_rows($resultados) > 0) {
                                    while ($linha = mysqli_fetch_assoc($resultados)) {
                                        echo "<div class='trabalho'>";
                                        echo "<img class='img' src='img/" . $linha["imagem"] . "' alt='" . $linha["NomeTrab"] . "'>";
                                        echo "<div class='informacoes'>";
                                        echo "<h3>" . $linha["NomeTrab"] . "</h3>";
                                        echo "<p>" . $linha["DescTrab"] . "</p>";
                                        echo "</div>";
                                        echo "</div>";
                                    } 
                                } else {
                                    echo "Não existem resultados a apresentar!";
                                } */

                                mysqli_close($connection);
                                
                            }
                            
                        }

                    }

                    ?>

                </td>
                <td class="esquerda2">
                    <div class="col1">
                    <p> <h1>Disciplinas</h1> </p>
                    <p><h3>Preencha os campos abaixo para adicionar disciplinas</h3></p>
                    <hr>
                    </div>

                <form method="POST" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
                <?php

                        if (!$connection) {
                            die("Ligação não efetuada!" . mysqli_connect_error());
                        }
                        echo '<input type="text" name="codigo" placeholder=" Código...">';
                        echo'<input type="text" name="carga" placeholder=" Carga horária...">';
                        echo'<input type="text" name="nome" placeholder=" Nome da disciplina...">';
                        echo '<textarea class="textarea2" name="descricao" rows="10" placeholder=" Descrição..."></textarea>';
                        echo '<button type="submit" class="button_send1">ENVIAR</button>';
                    
                    ?>
                    </form>
                </td>

                <td class="direita2">
        
        <?php


         if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["codigo"]) && !isset($_POST["codigo1"])) {
            $codigo = $_POST["codigo"];
            $carga = $_POST["carga"];
            $nome = $_POST["nome"];
            $descricao = $_POST["descricao"];


            
            

                    if (!$connection) {
                        die("Ligação não efetuada!" . mysqli_connect_error());
                    }
                    $sql = "INSERT INTO disciplinas (CodDisc, CargaHoraria, NomeDisc, DescDisc) VALUES
                    ('$codigo', '$carga','$nome', '$descricao');";
                    $resultados = mysqli_query($connection, $sql);
                     echo "<div class='trabalhoadm'>";
                    echo "<div class='retanguloadm'><p class='codigoadm'>Disciplina incluida com sucesso</p><p class='dic'>".$nome."</p></div>";

                    ?>
                    <form method="GET" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
                    <?php
                    echo "<div class='informacoesadm'>";
                    echo "<input class='inputbotaodel' type='submit' value='ok' name='ok'>"; 
                    echo "</div>";
                
                   /*  $ok = $_GET["ok"]; */
                    if (isset($_GET["ok"])) {
                    if($ok="ok"){
                        echo "<meta http-equiv='refresh' content='0'>";
                
                    } }
                    echo "</div>"; 
                       
                        ?>

                        <?php

                    mysqli_close($connection);
                    
                }

                
            

         

        ?>

    </td>





    </td>
                <td class="esquerda3">
                    <div class="col1">
                    <p> <h1>Disciplinas</h1> </p>
                    <p><h3>Digite o código da disciplina depois faça as alterações</h3></p>
                    <hr>
                    </div>

                <form method="POST" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
                <?php

                        if (!$connection) {
                            die("Ligação não efetuada!" . mysqli_connect_error());
                        }
                        echo '<input type="text" name="codigo1" placeholder=" Código...">';
                        echo '<button type="submit" class="button_send1">BUSCAR</button>';
                        echo '<br>';
                        echo '<br>';

                    
                    ?>
                    </form>
                    <form method="POST" action="<?php echo $_SERVER["PHP_SELF"]; ?>">

                    <?php
                    if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["codigo1"])) {

                    if (!$connection) {
                            die("Ligação não efetuada!" . mysqli_connect_error());
                        }
                        $dis=$_POST["codigo1"];
                        $sql = "SELECT * FROM disciplinas WHERE CodDisc LIKE $dis;";
                        $resultados = mysqli_query($connection, $sql);


                        if (mysqli_num_rows($resultados) > 0) {
                            while ($linha = mysqli_fetch_assoc($resultados)) {
                                echo '<input type="text" name="codigo2" value="' . $linha["CodDisc"] . '"readonly>';
                                echo'<input type="text" name="carga2"value="' . $linha["CargaHoraria"] . '">';
                                echo'<input type="text" name="nome2" value="' . $linha["NomeDisc"] . '">';
                                echo '<textarea class="textarea2" name="descricao2" rows="10">' . $linha["DescDisc"] . '</textarea>';
                                echo '<button type="submit" class="button_send1">ENVIAR</button>'; 
                            }


                        } else {
                            echo "Não existem resultados a apresentar!";
                        }
                    }



            
                    ?>


                </form>
                </td>
                <td class="direita3">
        
        <?php


         if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["codigo2"])) {
            $codigoup = $_POST["codigo2"];
            $cargaup = $_POST["carga2"];
            $nomeup = $_POST["nome2"];
            $descricaoup = $_POST["descricao2"];

            $sql = "SELECT * FROM disciplinas WHERE CodDisc LIKE $codigoup;";
            $resultados = mysqli_query($connection, $sql);
            /* $n = array(); */
            $i=0;
            if (mysqli_num_rows($resultados) > 0) {
                while ($linha1 = mysqli_fetch_assoc($resultados)) {
 
                    $codigo_old= $linha1["CodDisc"];
                    $carga_old= $linha1["CargaHoraria"];
                    $nome_old= $linha1["NomeDisc"];
                    $descricao_old= $linha1["DescDisc"];

                    $i++;

                }
            }
                    if (!$connection) {
                        die("Ligação não efetuada!" . mysqli_connect_error());
                    }
                   /*  UPDATE disciplinas SET CargaHoraria='25' WHERE CargaHoraria='50'AND CodDisc = '0782'; */
/*                     $sql = "UPDATE disciplinas SET CargaHoraria='$cargaup' WHERE CargaHoraria='$carga';"; */
/* $sql = "UPDATE disciplinas SET CargaHoraria= '$cargaup' WHERE CargaHoraria='$carga_old' AND CodDisc = '$codigo_old'; "; */
                 /*    $sql = "UPDATE disciplinas SET NomeDisc= '$nomeup' WHERE NomeDisc='$nome_old' AND CodDisc = '$codigo_old'; "; */


                    $sql = "UPDATE disciplinas SET CargaHoraria= '$cargaup' WHERE CargaHoraria='$carga_old' AND CodDisc = '$codigo_old'; ";
                    $sql1= "UPDATE disciplinas SET NomeDisc= '$nomeup' WHERE NomeDisc='$nome_old' AND CodDisc = '$codigo_old'; ";
                    $sql2= "UPDATE disciplinas SET DescDisc= '$descricaoup' WHERE DescDisc='$descricao_old' AND CodDisc = '$codigo_old'; ";
                    $resultados = mysqli_query($connection, $sql);
                    $resultados1 = mysqli_query($connection, $sql1);
                    $resultados1 = mysqli_query($connection, $sql2);
                     echo "<div class='trabalhoadm'>";
                    echo "<div class='retanguloadm'><p class='codigoadm'>Disciplina incluida com sucesso</p><p class='dic'>".$nomeup."</p></div>";

                    ?>
                    <form method="GET" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
                    <?php
                    echo "<div class='informacoesadm'>";
                    echo "<input class='inputbotaodel' type='submit' value='ok' name='ok'>"; 
                    echo "</div>";
                
/*                     $ok = $_GET["ok"]; */
                    if (isset($_GET["ok"])) {
                    if($ok="ok"){
                        echo "<meta http-equiv='refresh' content='0'>";
                
                    } }
                    echo "</div>"; 


                    mysqli_close($connection);
                    
                }

                
            

         

        ?>

    </td>
               






























            </tr>
        </table>








    <footer class="footer">
                 
        <div class="container">
            <div class="row">
             <div id="logo_footer" class="footer-col">
                 <a href="index.html"><img src="img/logopp.svg" alt="Logo"></a>
             </div>
                <div id="cols" class="footer-col">
                    <h4>Informações</h4>
                    <ul>
                        <li><a href="#">Informações</a></li>
                        <li><a href="#">Informações</a></li>
                        <li><a href="#">Informações</a></li>
                    </ul>
                </div>
                <div id="cols" class="footer-col">
                    <h4>Contactos</h4>
                    <ul>
                        <li><a href="contact.html">R. do Carmo 15, Porto</a></li>
                        <li><a href="contact.html">9322-97543</a></li>
                        <li><a href="contact.html">phcrepaldi@gmail.com</a></li>
                    </ul>
                </div>
                <div id="cols" class="footer-col">
                    <h4>Redes Sociais</h4>
                    <div class="social-links">
                     <a href=""><img src="img/facebook.svg" alt="FACEBOOK"></a>
                     <a href=""><img src="img/instagram.svg" alt="INSTAGRAM"></a>
                     <a href=""><img src="img/twitter.svg" alt="TWITTER"></a>
                    </div>
                </div>
            </div>
        </div>
<div class="copy">
<p>PP Web Design, Copyright &copy; 2023</p>
</div>  
</footer>
</body>
</html>
            























