<?php 
    $servidor="localhost";
    $utilizador="root";
    $password="";
    $nomebd="livros_v0";
    $porta=3306;

    // criar a ligação
    $conn=mysqli_connect($servidor,$utilizador,$password,$nomebd,$porta);
?>