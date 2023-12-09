<html>
	<head>
        <style>

            /* TIPOS DE LETRAS
            font-family: 'Pacifico', cursive;
            font-family: 'Permanent Marker', cursive;
            font-family: 'Patrick Hand', cursive;
            */
            @import url('https://fonts.googleapis.com/css2?family=Pacifico&family=Patrick+Hand&family=Permanent+Marker&display=swap');
            /* FUNDO */
            body{
                background: radial-gradient(rgb(0, 0, 0), rgb(5, 23, 56));
            }

            /* BOTÕES MENU PRINCIPAL*/
            button {
                padding-left: 15px;
                padding-right: 15px;
                width: 200px;
                height: 50px;
                border-radius: 20px;
                border: none;
                background-color: rgb(241, 234, 215);
                font-family: 'Permanent Marker', cursive;
                text-align: center;
                font-size: larger;
                color: rgb(5, 23, 56);
            }
            button:hover {
                background-color: rgb(218, 215, 69);
                color: rgb(5, 23, 56);
            }
            .dropdown {
                display: inline-block;
                position: relative;
                }
            .dropdown-content {
                display: none;
                position: absolute;
                width: 100%;
                overflow: auto;
                box-shadow: 0px 10px 10px 0px rgba(0,0,0,0.4);
            }
            .dropdown:hover .dropdown-content {
                display: block;
            }
            .dropdown-content a {
                display: block;
                color: #000000;
                padding: 5px;
                text-decoration: none;
            }
            .dropdown-content a:hover {
                color: #FFFFFF;
                background-color: #00A4BD;
            }
        </style>

    </head>
<!--
    <h4>Exercício ?<br></h4>
    <h5>Pergunta<br></h5>
    <div class="texto">
        <?php

        ?>
    </div>
-->
	<body>
        <div align="center">
            <div class="dropdown">
                <button type="button">Homepage</button>
            </div>

            <div class="dropdown">
                <button type="button">Curso</button>
            </div>

            <div class="dropdown">
                <button>Disciplinas</button>
                    <div class="dropdown-content">
                    <a href="#">UFCD 1</a>
                    <a href="#">UFCD 2</a>
                    <a href="#">UFCD 3</a>
                    </div>
            </div>

            <div class="dropdown">
                <button>Trabalhos</button>
                    <div class="dropdown-content">
                    <a href="#">Trabalho 1</a>
                    <a href="#">Trabalho 2</a>
                    <a href="#">Trabalho 3</a>
                    </div>
            </div>

            <div class="dropdown">
                <button type="button">Contactos</button>
            </div>

            <div class="dropdown">
                <button type="button">Administração</button>
            </div>
        </div>
        <table align="center">
            <tr>
                <td>
                    <div class="texto" width="30%">
                        Foto
                    </div>
                </td>
                <td>
                    <div class="texto" width="30%">
                        <h1>Nome</h1>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="texto">
                        Texto sobre mim
                    </div>
                </td>
            </tr>
        </table>
	</body>
</html>