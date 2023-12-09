    <?php include "config.php";?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portifolio | Disciplinas</title>
    <link rel="stylesheet" href="css\estilo.css">
</head>
<body>
    <header>
        <div class="container">
            <div id="branding">
                <a href="index.html"><img src="img/logopp.svg" alt="Logo"></a>
            </div>
            <nav>
                <ul>
                    <li><a href="about.html">Curso</a></li>
                    <li class="current"><a href="materias.php">Disciplinas</a></li>
                    <li><a href="trabalhos.php">Trabalhos</a></li>
                    <li><a href="contact.html">Contacto</a></li>
                    <li><a href="admin.php">Administração</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <section id="newsletter_trab">
    <div class="container">
            <h1>Selecione a disciplina para ver mais detalhes</h1>
<!--             <form>
                <input type="email" placeholder="Enter e-mail...">
                <button type="submit" class="button">Enviar</button>
            </form> -->
        </div>
    </section>
    <table>
            <tr>
                <td class="esquerda">
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
                                echo "<input class='inputbotao' type='submit' value='".$linha["NomeDisc"]."' name='d_$i'>";   
                               /*  echo "<br>"; */
                                /* $i++; */
                                $n[]= $linha["CodDisc"];
                                /* $n = array($linha["CodDisc"]); */
                                $i++;

                            }
                            /* foreach ($n as $s) {
                                echo " $s, ";
                            } */
                        } else {
                            echo "Não existem resultados a apresentar!";
                        }
/*                         mysqli_close($connection); */
                    
                    ?>
                    </form>
<!--                 <form method="POST" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
                    <br>
                    <input type="submit" value="Sistemas de gestão de bases de dados" name="mat1">                  
                    <br>
                    <input type="submit" value="Scripts CGI e folhas de estilo" name="mat2">
                    <br>
                    <input type="submit" value="Instalação e administração de servidores WEB" name="mat3">   
                </form> -->
        
        
                </td>
        
                <td class="direita">
        
                    <?php
                   
                    if ($_SERVER["REQUEST_METHOD"] == "POST") {
                       
                        foreach ($_POST as $key => $value) {
                            if (strpos($key, 'd_') === 0) {
                                $index = intval(substr($key, strlen('d_')));
                               /*  $index = intval($key); */
                                $cod_disc = $n[$index];
                              
                               

                                if (!$connection) {
                                    die("Ligação não efetuada!" . mysqli_connect_error());
                                }
                                $sql = "SELECT * FROM disciplinas
                            WHERE CodDisc LIKE $cod_disc;";
                                $resultados = mysqli_query($connection, $sql);
                                if (mysqli_num_rows($resultados) > 0) {
                                    while ($linha = mysqli_fetch_assoc($resultados)) {
                                        echo "<div class='trabalho'>";
                                        echo "<div class='retangulo'><p class='codigo'>Código</p><p>".$linha["CodDisc"]."</p></div>";
                                        echo "<div class='informacoes'>";
                                        echo "<p>Carga horária: " . $linha["CargaHoraria"] . " horas</p>";
                                        echo "<h3>" . $linha["NomeDisc"] . "</h3>";
                                        echo "<p>" . $linha["DescDisc"] . "</p>";
                                        echo "</div>";
                                        echo "</div>";
                                    }
                                } else {
                                    echo "Não existem resultados a apresentar!";
                                }

                                mysqli_close($connection);
                            }
                        }
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
            























