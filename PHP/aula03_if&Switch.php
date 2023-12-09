<?php echo "Aula 3<br>";?>
<!DOCTYPE html>
<html>
	<head></head>
	<body>
		<h1></h1>
        <?php 
			/**/
			$t=21; //date("H") y-m-d-h-m-s
            if($t<6||$t==6){
                echo "Boa noite!";
            }elseif($t<12||$t==12){
                echo "Bom dia";
            }elseif($t<20||$t==20){
                echo "Boa tarde";
            }else{
                echo "Boa noite";
            }
            "<br>"
		?>
        <?php 
			/**/
			$t=date("H"); //y-m-d-h-m-s
            switch($t){ // usa-se para verificar contra valores exatos
                case 17:
                        echo "Olá são 17 horas";
                        break;
                    case 18:
                        echo "Olá são 18 horas";
                        break;
                    case 19:
                        echo "Olá são 19 horas";
                        break;
                    default:
                        echo "Olá não são horas";
            }
            "<br>"
		?>
		
	</body>