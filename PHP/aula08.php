<html>
	<head>
        <link rel="stylesheet" href="styles.css"> <!-- Puxa o estilo do ficheiro CSS -->
        <!-- Foi usado só para pôr texto a vermelho se existirem errosna verificação -->
    </head>
	<body>
        <h1>Aula 8</h1>
		<h4>
            <!-- Enviar dados para outro ficheiro, neste caso data.php que está na mesma pasta 
            O ficheiro que vai receber os dados pode ter qualquer nome-->

            <!--
                Foi comentado para não interferir com o resto do exercício
                <form method="POST" action="data.php"></form>
            -->
            
            <!-- Ele quer que o CSS esteja separado do HTML, por isso mandamos para ficheiro à parte,
            neste caso styles.css que está na mesma pasta e puxámos no <head></head> deste ficheiro -->

            <!-- Estabelecer verificações em PHP ao formulário -->
			<?php
                // criamos as variáveis de erro
                $nomeMsgErro="";
                $emailMsgErro="";
                // podemos criá-las assim também
                // $nomeMsgErro = $emailMsgErro = "";

                //verificamos se os campos estão vazios e geramos um erro
                if($_SERVER["REQUEST_METHOD"]=="POST"){
                    // verifica se o nome está vazio
                    if(empty($_POST["nome"])){
                        $nomeMsgErro="O nome é de preenchimento obrigatório!";
                    }
                    // verifica se o email está vazio
                    if(empty($_POST["email"])){
                        $emailMsgErro="O e-mail é de preenchimento obrigatório!";
                    }
                }
            ?>

            <p><span class="erro">* Campos Obrigatórios</span></p>
            <form method="POST" action="aula08.php">
				<label>Nome:</label>
				<input type="text" name="nome">
                <span class="erro">* <?php echo $nomeMsgErro ?></span>
                <!-- como a variável $nomeMsgErro é vazia, o PHP só vai mostrar o erro se existir ao submeter-->
				<br><br>
                <label>E-mail:</label>
				<input type="text" name="email">
                <span class="erro">*<?php echo $emailMsgErro ?></span>
                <!-- como a variável $emailMsgErro é vazia, o PHP só vai mostrar o erro se existir ao submeter -->
				<br><br>
				<input type="submit" value="submeter">
			</form>
            <?php
                // se os campos obrigatórios verificados antes estiverem preenchidos imprime os dados inseridos
                if($_SERVER["REQUEST_METHOD"]=="POST" && !empty($_POST["nome"]) && !empty($_POST["email"])){
                    echo "Formulário submetido com sucesso<br>";
                    echo "<h2>Dados Submetidos</h2>";
                    echo "Nome: ".$_POST["nome"]."<br>";
                    echo "E-mail: ".$_POST["email"]."<br>";
                }

                // O resto do PHP foi enviado para o data.php mas não fizemos nada com ele
            ?>
            <!-- Ficha 6 para ir fazendo até ao final do módulo que é depois da Páscoa-->
		</h4>
	</body>