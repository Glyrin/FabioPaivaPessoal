package InesFabio.MenuEscolar.Controller;

import InesFabio.MenuEscolar.Enums.*;
import InesFabio.MenuEscolar.Model.Aluno;
import InesFabio.MenuEscolar.Model.Login;
import InesFabio.MenuEscolar.Model.Pessoa;
import InesFabio.MenuEscolar.Service.AlunoService;
import InesFabio.MenuEscolar.Service.LoginService;
import InesFabio.MenuEscolar.Service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;

@Controller
public class AlunoController {
// Atributos
    private final AlunoService alunoService;
    private final LoginService loginService;
    private final TurmaService turmaService;

// Construtores
    @Autowired
    public AlunoController(AlunoService alunoService, LoginService loginService, TurmaService turmaService) {
        this.alunoService = alunoService;
        this.loginService = loginService;
        this.turmaService = turmaService;
    }

// Métodos Base (Obrigatórios)
    @GetMapping("/alunos/new")
    public String addAluno(Model model){
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("listaEspecies", Especie.values());
        model.addAttribute("listaSexos", Sexo.values());
        model.addAttribute("listaCasas", Casa.values());
        model.addAttribute("listaTurmas", turmaService.listTurma());

        return "pages/Alunos/NovoAluno";
    }
    @PostMapping("/alunos/save")
    public String saveAluno(@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult result, Model model, RedirectAttributes redirectAttrs){
        if(result.hasErrors()){
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaCasas", Casa.values());
            model.addAttribute("listaTurmas", turmaService.listTurma());

            return "pages/Alunos/NovoAluno";
        }
        Aluno alunoCriado = alunoService.saveAluno(aluno);
        Login login = loginService.saveLoginAluno(alunoCriado);
        redirectAttrs.addAttribute("id", alunoCriado.getId());

        return "redirect:/alunos/view/{id}";
    }
    @GetMapping("/alunos/list")
    public String listAlunos(Model model){
        List<Aluno> alunos=alunoService.listAluno();
        model.addAttribute("listaTurmas", turmaService.listTurma());
        model.addAttribute("listaCasas", Casa.values());
        model.addAttribute("listaAlunos", alunos);

        return "pages/Alunos/ListarAluno";
    }
    @GetMapping("/alunos/view/{id}")
    public String viewAlunoById(@PathVariable("id") Long id, Model model){
        Optional<Aluno> aluno=alunoService.viewAlunoById(id);
        if(aluno.isPresent()){
            int idade = Pessoa.idade(aluno.get().getDataNascimento());
            model.addAttribute("inst", aluno.get());
            model.addAttribute("idade", idade);


            return "pages/Alunos/VerAluno";
        }

        return "redirect:/alunos/list";
    }
    @GetMapping("/alunos/edit/{id}")
    public String editAlunoById(@PathVariable("id") Long id, Model model){
        Optional<Aluno> aluno=alunoService.viewAlunoById(id);
        if(aluno.isPresent()){
            model.addAttribute("aluno", aluno.get());
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaCasas", Casa.values());
            model.addAttribute("listaTurmas", turmaService.listTurma());

            return "pages/Alunos/EditarAluno";
        }

        return "redirect:/alunos/list";
    }
    @PostMapping("/alunos/update/{id}")
    public String updateAluno(@Valid @ModelAttribute("naoDocente") Aluno aluno, BindingResult result, Model model, @PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaCasas", Casa.values());
            model.addAttribute("listaTurmas", turmaService.listTurma());

            return "pages/Alunos/EditarAluno";
        }
        Aluno alunoAtualizado=alunoService.updateAluno(id, aluno);
        if(alunoAtualizado==null){
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaCasas", Casa.values());
            model.addAttribute("listaTurmas", turmaService.listTurma());
            model.addAttribute("falha", "Rursum Asinus... Erro, tenta outra vez.");

            return "pages/Alunos/EditarAluno";
        }

        return "redirect:/alunos/view/{id}";
    }
    @GetMapping("/alunos/delete/{id}")
    public String deleteAluno(@PathVariable("id") Long id){
        alunoService.deleteAluno(id);

        return "redirect:/alunos/list";
    }

// Métodos Personalizados (opcionais)
    @GetMapping("/alunos/filterTurma")
    public String filterTurmas(@RequestParam("turmaFiltro") Long turmaFiltro, Model model){
        List<Aluno> alunos=alunoService.listAlunosByTurma(turmaFiltro);
        model.addAttribute("listaAlunos", alunos);
        model.addAttribute("listaTurmas", turmaService.listTurma());
        model.addAttribute("listaCasas", Casa.values());
        model.addAttribute("turmaFiltro", turmaFiltro);

        return "pages/Alunos/ListarAluno";
    }
    @GetMapping("/alunos/filterCc")
    public String filterCc(@RequestParam("ccFiltro") Integer ccFiltro, Model model){
        List<Aluno> alunos=alunoService.listByCc(ccFiltro);
        model.addAttribute("listaAlunos", alunos);
        model.addAttribute("listaTurmas", turmaService.listTurma());
        model.addAttribute("listaCasas", Casa.values());
        model.addAttribute("ccFiltro", ccFiltro);

        return "pages/Alunos/ListarAluno";
    }
    @GetMapping("/alunos/filterCasa")
    public String filterCasa(@RequestParam("casaFiltro") Casa casaFiltro, Model model){
        List<Aluno> alunos=alunoService.listByCasa(casaFiltro);
        model.addAttribute("listaAlunos", alunos);
        model.addAttribute("listaTurmas", turmaService.listTurma());
        model.addAttribute("listaCasas", Casa.values());
        model.addAttribute("casaFiltro", casaFiltro);

        return "pages/Alunos/ListarAluno";
    }
    @GetMapping("/alunos/filterAtivo")
    public String filterAtivo(@RequestParam("ativoFiltro") Boolean ativoFiltro, Model model){
        List<Aluno> alunos=alunoService.listByAtivo(ativoFiltro);
        model.addAttribute("listaAlunos", alunos);
        model.addAttribute("listaTurmas", turmaService.listTurma());
        model.addAttribute("listaCasas", Casa.values());
        model.addAttribute("ativoFiltro", ativoFiltro);

        return "pages/Alunos/ListarAluno";
    }
    @GetMapping("/alunos/filterNome")
    public String filterNome(@RequestParam("nomeFiltro") String nomeFiltro, Model model){
        List<Aluno> alunos=alunoService.listByNome(nomeFiltro);
        model.addAttribute("listaAlunos", alunos);
        model.addAttribute("listaTurmas", turmaService.listTurma());
        model.addAttribute("listaCasas", Casa.values());
        model.addAttribute("nomeFiltro", nomeFiltro);

        return "pages/Alunos/ListarAluno";
    }
}
