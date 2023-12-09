package InesFabio.MenuEscolar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
// Métodos
    @GetMapping("/")
    public String homepage(){return "pages/Homepage";}
}
