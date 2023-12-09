package InesFabio.MenuEscolar.Controller;

import InesFabio.MenuEscolar.Model.Disciplina;
import InesFabio.MenuEscolar.Service.DisciplinaService;
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
public class DisciplinaController {
// Atributos

    private final DisciplinaService disciplinaService;

// Construtores

    @Autowired
    public DisciplinaController (DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

// Métodos
    @GetMapping("/disciplina/new")
    public String addDisciplina(Model model){
        model.addAttribute("disciplina", new Disciplina());

        return "pages/Disciplinas/NovaDisciplina";
    }

    @PostMapping("/disciplina/save")
    public String saveDisciplina(@Valid @ModelAttribute("disciplina") Disciplina disciplina, BindingResult result, RedirectAttributes redirectAttrs){
        if(result.hasErrors()){
            return "pages/Disciplinas/NovaDisciplina";
        }

        Disciplina disciplinaCriada=disciplinaService.saveDisciplina(disciplina);
        redirectAttrs.addAttribute("id", disciplinaCriada.getId());

        return "redirect:/disciplina/view/{id}";
    }

    @GetMapping("/disciplina/list")
    public String listDisciplina(Model model){
        List<Disciplina> disciplina=disciplinaService.listDisciplina();

////// Lista Disciplinas
        model.addAttribute("listaDisciplina", disciplina);

        return "pages/Disciplinas/listarDisciplina";
    }

    @GetMapping("disciplina/view/{id}")
    public String viewDisciplinaById(@PathVariable("id") Long id, Model model){
        Optional<Disciplina> disciplina=disciplinaService.viewDisciplinaById(id);
        if(disciplina.isPresent()){
            model.addAttribute("inst", disciplina.get());
            return "pages/Disciplinas/VerDisciplina";
        }

        return "redirect:/disciplina/list";
    }

    @GetMapping("disciplina/edit/{id}")
    public String editDisciplinaById(@PathVariable("id") Long id, Model model){
        Optional<Disciplina> disciplina=disciplinaService.viewDisciplinaById(id);
        if(disciplina.isPresent()){
            model.addAttribute("disciplina", disciplina.get());
            return "pages/Disciplinas/EditarDisciplina";
        }

        return "redirect:/disciplina/list";
    }

    @PostMapping("disciplina/update/{id}")
    public String updateDisciplina(@Valid @ModelAttribute("disciplina") Disciplina disciplina, BindingResult result, Model model, @PathVariable("id") Long id){
        if(result.hasErrors()){
            return "pages/Disciplinas/EditarDisciplina";
        }
        Disciplina disciplinaAtualizada=disciplinaService.updateDisciplina(id, disciplina);
        if(disciplinaAtualizada==null){
            model.addAttribute("falhou", "Não foi possível editar.");
            return "pages/Disciplinas/EditarDisciplina";
        }

        return "redirect:/disciplina/view/{id}";
    }
    @GetMapping("/disciplina/delete/{id}")
    public String deleteDisciplina(@PathVariable("id") Long id){
        disciplinaService.deleteDisciplina(id);

        return "redirect:/disciplina/list";
    }

}
