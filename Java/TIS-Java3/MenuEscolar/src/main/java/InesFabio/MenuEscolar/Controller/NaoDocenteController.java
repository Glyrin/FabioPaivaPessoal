package InesFabio.MenuEscolar.Controller;

import InesFabio.MenuEscolar.Enums.*;
import InesFabio.MenuEscolar.Model.Login;
import InesFabio.MenuEscolar.Model.NaoDocente;
import InesFabio.MenuEscolar.Model.Pessoa;
import InesFabio.MenuEscolar.Service.LoginService;
import InesFabio.MenuEscolar.Service.NaoDocenteService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;

@Controller
public class NaoDocenteController {
// Atributos
    private final NaoDocenteService naoDocenteService;
    private final LoginService loginService;

// Construtores
    @Autowired
    public NaoDocenteController(NaoDocenteService naoDocenteService, LoginService loginService) {
        this.naoDocenteService = naoDocenteService;
        this.loginService = loginService;
    }

// Métodos Base (Obrigatórios)
    @GetMapping("/naodocentes/new")
    public String addNaoDocente(Model model){
        model.addAttribute("naoDocente", new NaoDocente());
        model.addAttribute("listaEspecies", Especie.values());
        model.addAttribute("listaSexos", Sexo.values());
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaFuncoes", Funcao.values());

        return "pages/NaoDocentes/NovoNaoDocente";
    }
    @PostMapping("/naodocentes/save")
    public String saveNaoDocente(@Valid @ModelAttribute("naoDocente") NaoDocente naoDocente, BindingResult result, Model model, RedirectAttributes redirectAttrs){
        if(result.hasErrors()){
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaTiposContratos", TipoContrato.values());
            model.addAttribute("listaFuncoes", Funcao.values());

            return "pages/NaoDocentes/NovoNaoDocente";
        }
            NaoDocente naoDocenteCriado = naoDocenteService.saveNaoDocente(naoDocente);
            Login login = loginService.saveLoginNaoDocente(naoDocenteCriado);
            redirectAttrs.addAttribute("id", naoDocenteCriado.getId());

            return "redirect:/naodocentes/view/{id}";
    }
    @GetMapping("/naodocentes/list")
    public String listNaoDocentes(Model model){
        List<NaoDocente> naoDocentes=naoDocenteService.listNaoDocente();
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaFuncoes", Funcao.values());
        model.addAttribute("listaNaoDocentes", naoDocentes);

        return "pages/NaoDocentes/ListarNaoDocente";
    }
    @GetMapping("naodocentes/view/{id}")
    public String viewNaoDocenteById(@PathVariable("id") Long id, Model model){
        Optional<NaoDocente> naoDocente=naoDocenteService.viewNaoDocenteById(id);
        if(naoDocente.isPresent()){
            int idade = Pessoa.idade(naoDocente.get().getDataNascimento());
            model.addAttribute("inst", naoDocente.get());
            model.addAttribute("idade", idade);


            return "pages/NaoDocentes/VerNaoDocente";
        }

        return "redirect:/naodocentes/list";
    }
    @GetMapping("/naodocentes/edit/{id}")
    public String editNaoDocenteById(@PathVariable("id") Long id, Model model){
        Optional<NaoDocente> naoDocente=naoDocenteService.viewNaoDocenteById(id);
        if(naoDocente.isPresent()){
            model.addAttribute("naoDocente", naoDocente.get());
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaTiposContratos", TipoContrato.values());
            model.addAttribute("listaFuncoes", Funcao.values());

            return "pages/NaoDocentes/EditarNaoDocente";
        }

        return "redirect:/naodocentes/list";
    }
    @PostMapping("/naodocentes/update/{id}")
    public String updateNaoDocente(@Valid @ModelAttribute("naoDocente") NaoDocente naoDocente, BindingResult naoDocentResult, Model model, @PathVariable("id") Long id){
        if(naoDocentResult.hasErrors()){
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaTiposContratos", TipoContrato.values());
            model.addAttribute("listaFuncoes", Funcao.values());

            return "pages/NaoDocentes/EditarNaoDocente";
        }
        NaoDocente naoDocenteAtualizado=naoDocenteService.updateNaoDocente(id, naoDocente);
        if(naoDocenteAtualizado==null){
            model.addAttribute("listaEspecies", Especie.values());
            model.addAttribute("listaSexos", Sexo.values());
            model.addAttribute("listaTiposContratos", TipoContrato.values());
            model.addAttribute("listaFuncoes", Funcao.values());
            model.addAttribute("falha", "Rursum Asinus... Erro, tenta outra vez.");

            return "pages/NaoDocentes/EditarNaoDocente";
        }

        return "redirect:/naodocentes/view/{id}";
    }
    @GetMapping("/naodocentes/delete/{id}")
    public String deleteNaoDocente(@PathVariable("id") Long id){
        naoDocenteService.deleteNaoDocente(id);

        return "redirect:/naodocentes/list";
    }

// Métodos Personalizados (opcionais)
    @GetMapping("/naodocentes/filterCc")
    public String filterCc(@RequestParam("ccFiltro") Integer ccFiltro, Model model){
        List<NaoDocente> naoDocentes=naoDocenteService.listByCc(ccFiltro);
        model.addAttribute("listaNaoDocentes", naoDocentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaFuncoes", Funcao.values());
        model.addAttribute("ccFiltro", ccFiltro);

        return "pages/NaoDocentes/ListarNaoDocente";
    }
    @GetMapping("/naodocentes/filterNif")
    public String filterNif(@RequestParam("nifFiltro") Integer nifFiltro, Model model){
        List<NaoDocente> naoDocentes=naoDocenteService.listByNif(nifFiltro);
        model.addAttribute("listaNaoDocentes", naoDocentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaFuncoes", Funcao.values());
        model.addAttribute("nifFiltro", nifFiltro);

        return "pages/NaoDocentes/ListarNaoDocente";
    }
    @GetMapping("/naodocentes/filterNiss")
    public String filterNiss(@RequestParam("nissFiltro") Long nissFiltro, Model model){
        List<NaoDocente> naoDocentes=naoDocenteService.listByNiss(nissFiltro);
        model.addAttribute("listaNaoDocentes", naoDocentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaFuncoes", Funcao.values());
        model.addAttribute("nissFiltro", nissFiltro);

        return "pages/NaoDocentes/ListarNaoDocente";
    }
    @GetMapping("/naodocentes/filterTipoContrato")
    public String filterTipoContrato(@RequestParam("tipoContratoFiltro") TipoContrato tipoContratoFiltro, Model model){
        List<NaoDocente> naoDocentes=naoDocenteService.listByTipoContrato(tipoContratoFiltro);
        model.addAttribute("listaNaoDocentes", naoDocentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaFuncoes", Funcao.values());
        model.addAttribute("tipoContratoFiltro", tipoContratoFiltro);

        return "pages/NaoDocentes/ListarNaoDocente";
    }
    @GetMapping("/naodocentes/filterFuncoes")
    public String filterFuncoes(@RequestParam("funcoesFiltro") Funcao funcoesFiltro, Model model){
        List<NaoDocente> naoDocentes=naoDocenteService.listByFuncao(funcoesFiltro);
        model.addAttribute("listaNaoDocentes", naoDocentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaFuncoes", Funcao.values());
        model.addAttribute("funcoesFiltro", funcoesFiltro);

        return "pages/NaoDocentes/ListarNaoDocente";
    }
    @GetMapping("/naodocentes/filterAtivo")
    public String filterAtivo(@RequestParam("ativoFiltro") Boolean ativoFiltro, Model model){
        List<NaoDocente> naoDocentes=naoDocenteService.listByAtivo(ativoFiltro);
        model.addAttribute("listaNaoDocentes", naoDocentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaFuncoes", Funcao.values());
        model.addAttribute("ativoFiltro", ativoFiltro);

        return "pages/NaoDocentes/ListarNaoDocente";
    }
    @GetMapping("/naodocentes/filterNome")
    public String filterNome(@RequestParam("nomeFiltro") String nomeFiltro, Model model){
        List<NaoDocente> naoDocentes=naoDocenteService.listByNome(nomeFiltro);
        model.addAttribute("listaNaoDocentes", naoDocentes);
        model.addAttribute("listaTiposContratos", TipoContrato.values());
        model.addAttribute("listaFuncoes", Funcao.values());
        model.addAttribute("nomeFiltro", nomeFiltro);

        return "pages/NaoDocentes/ListarNaoDocente";
    }
}
