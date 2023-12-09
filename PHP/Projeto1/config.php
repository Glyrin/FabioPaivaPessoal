<?php
    $servidor="localhost";
    $utilizador="root";
    $password="";
    $nomebd="portifolio";
    $porta=3306;
    
    //criar ligação
    $connection=mysqli_connect($servidor,$utilizador,$password,$nomebd,$porta);
?>