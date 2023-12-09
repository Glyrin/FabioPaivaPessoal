<?php 
    $servidor="localhost";
    $utilizador="root";
    $password="";
    $nomebd="tarefa06";
    $porta=3306;

    $conn=mysqli_connect($servidor,$utilizador,$password,$nomebd,$porta);

    if(!$conn){
        die("Ligação não efetuada!<br>".mysqli_connect_error());
    }
?>