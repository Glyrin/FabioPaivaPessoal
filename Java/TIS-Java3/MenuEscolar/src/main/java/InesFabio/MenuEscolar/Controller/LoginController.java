package InesFabio.MenuEscolar.Controller;

import InesFabio.MenuEscolar.Model.Login;
import InesFabio.MenuEscolar.Service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {

    //Atributos
    private final LoginService loginService;

    //Construtor
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    //Métodos
    @GetMapping("/login")
    public String fazerLogin(Model model) {
        model.addAttribute("login", new Login());
        return "pages/Login/FazerLogin";
    }

    @PostMapping("/validarLogin")
    public String validarLogin(@ModelAttribute("login") Login login, RedirectAttributes redirectAttrs, Model model){
        String username = login.getUsername();
        String password = login.getPassword();
        List<Login> _login = loginService.validarLogin(username, password);
        if (_login == null || _login.isEmpty()) {
            model.addAttribute("falha", "Username ou password inválidos.");

            return "pages/Login/FazerLogin";
        }
        Login loginAutenticado = _login.get(0);
        redirectAttrs.addAttribute ("id", loginAutenticado.getId());

        return "redirect:/login/edit/{id}";
    }
    @GetMapping ("/login/edit/{id}")
    public String editLoginById (@PathVariable("id")Long id, Model model){
        Optional<Login> login=loginService.viewLoginById(id);
        if(login.isPresent()){
            model.addAttribute("login", login.get());

            return "pages/Login/EditarLogin";
        }

        return "redirect:/login";
    }

    @PostMapping("/login/update/{id}")
    public String updateLogin(@Valid @ModelAttribute("login")Login login, BindingResult result, Model model, @PathVariable("id")Long id){
        if (result.hasErrors()) {

            return "pages/Login/EditarLogin";
        }

        Login loginAtualizado = loginService.updateLogin(id, login);

        if (loginAtualizado == null) {
            model.addAttribute("falha", "Não foi possível editar.");
            return "redirect:/login";
        }

        return "redirect:/login/verLogin/{id}";
    }

    @GetMapping("/login/verLogin/{id}")
    public String verLoginById(@PathVariable("id") Long id, Model model) {
        Optional<Login> login = loginService.viewLoginById(id);
        if (login.isPresent()) {
            model.addAttribute("login", login.get());
            model.addAttribute("sucesso", "A Password foi alterada.");
        }
        return "pages/Login/EditarLogin";
    }
}

