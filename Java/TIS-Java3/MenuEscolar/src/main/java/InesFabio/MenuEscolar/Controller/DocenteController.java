package InesFabio.MenuEscolar.Controller;

import InesFabio.MenuEscolar.Enums.Especie;
import InesFabio.MenuEscolar.Enums.Sexo;
import InesFabio.MenuEscolar.Enums.TipoContrato;
import InesFabio.MenuEscolar.Model.*;
import InesFabio.MenuEscolar.Service.DisciplinaService;
import InesFabio.MenuEscolar.Service.DocenteService;
import InesFabio.MenuEscolar.Service.LoginService;
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
public class DocenteController {
// Atributos

    private final DocenteService docenteService;
    private final LoginService loginService;
    private final DisciplinaService disciplinaService;

// Construtores
    @Autowired
    public DocenteController(DocenteService docenteService, LoginService loginService,DisciplinaService disciplinaService){
        this.docenteService = docenteService;
        this.loginService = loginService;
        this.disciplinaService = disciplinaService;
    }

// Métodos

    @GetMapping("/docentes/new")
    public String addDocente(Model model){
        model.addAttribute("Docente", new Docente());
        model.addAttribute("listaEspecies", Especie.values());
        model.addAttribute("listaSexos", Sexo.values());
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());

        return "pages/Docentes/NovoDocente";
    }
    @PostMapping("/docentes/save")
    public String saveDocente(@Valid @ModelAttribute("Docente") Docente docente, BindingResult result, Model model, RedirectAttributes redirectAttrs){
        if(result.hasErrors()){
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaTiposContratos", TipoContrato.values());
            model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());

            return "pages/Docentes/NovoDocente";
        }
        Docente DocenteCriado = docenteService.saveDocente(docente);
        Login login = loginService.saveLoginDocente(DocenteCriado);
        redirectAttrs.addAttribute("id", DocenteCriado.getId());

        return "redirect:/docentes/view/{id}";
    }
    @GetMapping("/docentes/list")
    public String listDocentes(Model model){
        List<Docente> Docentes=docenteService.listDocente();
        model.addAttribute("listaDocentes", Docentes);
        model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());

        return "pages/Docentes/ListarDocente";
    }
    @GetMapping("docentes/view/{id}")
    public String viewDocenteById(@PathVariable("id") Long id, Model model){
        Optional<Docente> Docente=docenteService.viewDocenteById(id);
        if(Docente.isPresent()){
            int idade = Pessoa.idade(Docente.get().getDataNascimento());
            model.addAttribute("inst", Docente.get());
            model.addAttribute("idade", idade);
            model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplinasByDocenteId(Docente.get()));


            return "pages/Docentes/VerDocente";
        }

        return "redirect:/docentes/list";
    }
    @GetMapping("/docentes/edit/{id}")
    public String editDocenteById(@PathVariable("id") Long id, Model model){
        Optional<Docente> Docente=docenteService.viewDocenteById(id);
        if(Docente.isPresent()){
            model.addAttribute("Docente", Docente.get());
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaTiposContratos", TipoContrato.values());
            model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());

            return "pages/Docentes/EditarDocente";
        }

        return "redirect:/docentes/list";
    }
    @PostMapping("/docentes/update/{id}")
    public String updateDocente(@Valid @ModelAttribute("Docente") Docente Docente, BindingResult DocentResult, Model model, @PathVariable("id") Long id){
        if(DocentResult.hasErrors()){
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaTiposContratos", TipoContrato.values());
            model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());

            return "pages/Docentes/EditarDocente";
        }
        Docente DocenteAtualizado=docenteService.updateDocente(id, Docente);
        if(DocenteAtualizado==null){
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaTiposContratos", TipoContrato.values());
            model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());
            model.addAttribute("falha", "Rursum Asinus... Erro, tenta outra vez.");

            return "pages/Docentes/EditarDocente";
        }

        return "redirect:/docentes/view/{id}";
    }
    @GetMapping("/docentes/delete/{id}")
    public String deleteDocente(@PathVariable("id") Long id){
        docenteService.deleteDocente(id);

        return "redirect:/docentes/list";
    }

    // Métodos Personalizados (opcionais)
    @GetMapping("/docentes/filterCc")
    public String filterCc(@RequestParam("ccFiltro") Integer ccFiltro, Model model){
        List<Docente> Docentes=docenteService.listByCc(ccFiltro);
        model.addAttribute("listaDocentes", Docentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());
        model.addAttribute("ccFiltro", ccFiltro);

        return "pages/Docentes/ListarDocente";
    }
    @GetMapping("/docentes/filterNif")
    public String filterNif(@RequestParam("nifFiltro") Integer nifFiltro, Model model){
        List<Docente> Docentes=docenteService.listByNif(nifFiltro);
        model.addAttribute("listaDocentes", Docentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());
        model.addAttribute("nifFiltro", nifFiltro);

        return "pages/Docentes/ListarDocente";
    }
    @GetMapping("/docentes/filterNiss")
    public String filterNiss(@RequestParam("nissFiltro") Long nissFiltro, Model model){
        List<Docente> Docentes=docenteService.listByNiss(nissFiltro);
        model.addAttribute("listaDocentes", Docentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());
        model.addAttribute("nissFiltro", nissFiltro);

        return "pages/Docentes/ListarDocente";
    }
    @GetMapping("/docentes/filterTipoContrato")
    public String filterTipoContrato(@RequestParam("tipoContratoFiltro") TipoContrato tipoContratoFiltro, Model model){
        List<Docente> Docentes=docenteService.listByTipoContrato(tipoContratoFiltro);
        model.addAttribute("listaDocentes", Docentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());
        model.addAttribute("tipoContratoFiltro", tipoContratoFiltro);

        return "pages/Docentes/ListarDocente";
    }
    @GetMapping("/docentes/filterEspecializacoes")
    public String filterEspecializacoes(@RequestParam("especializacoesFiltro") Disciplina especializacoesFiltro, Model model){
        List<Docente> Docentes=docenteService.listByEspecializacoes(especializacoesFiltro);
        model.addAttribute("listaDocentes", Docentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());
        model.addAttribute("especializacoesFiltro", especializacoesFiltro);

        return "pages/Docentes/ListarDocente";
    }
    @GetMapping("/docentes/filterAtivo")
    public String filterAtivo(@RequestParam("ativoFiltro") Boolean ativoFiltro, Model model){
        List<Docente> Docentes=docenteService.listByAtivo(ativoFiltro);
        model.addAttribute("listaDocentes", Docentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());
        model.addAttribute("ativoFiltro", ativoFiltro);

        return "pages/Docentes/ListarDocente";
    }
    @GetMapping("/docentes/filterNome")
    public String filterNome(@RequestParam("nomeFiltro") String nomeFiltro, Model model){
        List<Docente> Docentes=docenteService.listByNome(nomeFiltro);
        model.addAttribute("listaDocentes", Docentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaEspecializacoes", disciplinaService.listDisciplina());
        model.addAttribute("nomeFiltro", nomeFiltro);

        return "pages/Docentes/ListarDocente";
    }
}
