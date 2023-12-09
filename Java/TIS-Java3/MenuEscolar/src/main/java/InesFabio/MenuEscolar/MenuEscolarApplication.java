package InesFabio.MenuEscolar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MenuEscolarApplication {

	public static void main(String[] args) {
		System.out.println("***************************************\nA iniciar a aplicação...");
		System.out.println("***************************************");
		SpringApplication.run(MenuEscolarApplication.class, args);
		System.out.println("\n***************************************");
		System.out.println("Pode utilizar o website...\n***************************************");
	}

}