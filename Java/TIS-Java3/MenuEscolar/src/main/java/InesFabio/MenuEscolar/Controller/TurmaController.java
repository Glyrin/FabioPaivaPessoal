package InesFabio.MenuEscolar.Controller;

import InesFabio.MenuEscolar.Model.Aluno;
import InesFabio.MenuEscolar.Model.AtualizacaoTurmasDTO;
import InesFabio.MenuEscolar.Model.Turma;
import InesFabio.MenuEscolar.Service.AlunoService;
import InesFabio.MenuEscolar.Service.DisciplinaService;
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
public class TurmaController {
// Atributos
    private final TurmaService turmaService;
    private final DisciplinaService disciplinaService;
    private final AlunoService alunoService;

// Construtores
    @Autowired
    public TurmaController(TurmaService turmaService, DisciplinaService disciplinaService, AlunoService alunoService) {
        this.turmaService = turmaService;
        this.disciplinaService = disciplinaService;
        this.alunoService = alunoService;
    }

// Métodos Base (Obrigatórios)
    @GetMapping("/turmas/new")
    public String addTurma(Model model){
        model.addAttribute("turma", new Turma());
        model.addAttribute("listaDisciplinas", disciplinaService.listDisciplina());

        return "pages/Turmas/NovoTurma";
    }
    @PostMapping("/turmas/save")
    public String saveTurma(@Valid @ModelAttribute("turma") Turma turma, BindingResult result, RedirectAttributes redirectAttrs, Model model){
        if(result.hasErrors()){
            model.addAttribute("listaDisciplinas", disciplinaService.listDisciplina());

            return "pages/Turmas/NovoTurma";
        }

        Turma criada=turmaService.saveTurma(turma);
        redirectAttrs.addAttribute("id", criada.getId());

        return "redirect:/turmas/view/{id}";
    }
    @GetMapping("/turmas/list")
    public String listTurma(Model model){
        List<Turma> turmas=turmaService.listTurma();
        model.addAttribute("listaTurmas", turmas);

        return "pages/Turmas/ListarTurma";
    }
    @GetMapping("turmas/view/{id}")
    public String viewTurmaById(@PathVariable("id")Long id, Model model){
        Optional<Turma> turma=turmaService.viewTurmaById(id);
        if(turma.isPresent()){
            model.addAttribute("inst", turma.get());
            model.addAttribute("listaDisciplinas", disciplinaService.listDisciplinasByTurmaId(turma.get()));
            model.addAttribute("listaAlunos", alunoService.listAlunosByTurmaId(turma.get()));

            return "pages/Turmas/VerTurma";
        }

        return "redirect:/turmas/list";
    }
    @GetMapping("/turmas/edit/{id}")
    public String editTurmaById(@PathVariable("id")Long id, Model model){
        Optional<Turma> turma=turmaService.viewTurmaById(id);
        if(turma.isPresent()){
            model.addAttribute("turma", turma.get());
            model.addAttribute("listaDisciplinas", disciplinaService.listDisciplina());

            return "pages/Turmas/EditarTurma";
        }

        return "redirect:/turmas/list";
    }
    @PostMapping("/turmas/update/{id}")
    public String updateTurma(@Valid @ModelAttribute("turma")Turma turma, BindingResult result, Model model, @PathVariable("id")Long id){
        if(result.hasErrors()){
            model.addAttribute("listaDisciplinas", disciplinaService.listDisciplina());

            return "pages/Turmas/EditarTurma";
        }
        Turma turmaAtualizada=turmaService.updateTurma(id, turma);
        if(turmaAtualizada==null){
            model.addAttribute("listaDisciplinas", disciplinaService.listDisciplina());
            model.addAttribute("falha", "Rursum Asinus... Erro, tenta outra vez.");

            return "pages/Turma/EditarTurma";
        }

        return "redirect:/turmas/view/{id}";
    }
    @GetMapping("turmas/delete/{id}")
    public String deleteTurma(@PathVariable("id")Long id){
        turmaService.deleteTurma(id);

        return "redirect:/turmas/list";
    }

// Métodos Personalizados (opcionais)
    @GetMapping("/alunosTurmas/edit")
    public String editAlunosTurmas(@RequestParam(value = "success", required = false) String sucess, Model model){
        List<Aluno> alunos=alunoService.listAlunosByAtivo();
        model.addAttribute("listaAlunos", alunos);
        model.addAttribute("listaTurmas", turmaService.listTurma());

        if("true".equals(sucess)){
            model.addAttribute("gravou", "Turmas atualizadas com sucesso.");
        }

        return "pages/Turmas/EditarTurmaAluno";
    }
    @PostMapping("/alunosTurmas/update")
    public String updateAlunosTurmas(@ModelAttribute AtualizacaoTurmasDTO dto){
        turmaService.updateTurmasAlunos(dto);

        return "redirect:/alunosTurmas/edit?success=true";
   }
    @GetMapping("/turmas/filterTurma")
    public String filterAlunosTurmas(@RequestParam("turmaFiltro") Long turmaFiltro, Model model){
        List<Aluno> alunos=alunoService.listAlunosByTurma(turmaFiltro);
        model.addAttribute("listaAlunos", alunos);
        model.addAttribute("listaTurmas", turmaService.listTurma());
        model.addAttribute("turmaFiltro", turmaFiltro);

        return "pages/Turmas/EditarTurmaAluno";
    }
}
