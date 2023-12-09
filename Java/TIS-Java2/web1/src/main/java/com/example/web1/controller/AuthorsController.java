package com.example.web1.controller;

import com.example.web1.enums.Genre;
import com.example.web1.model.Author;
import com.example.web1.model.AutorDetalhes;
import com.example.web1.service.AuthorService;
import com.example.web1.service.AutorDetalhesService;
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
public class AuthorsController {
// Atributos
    private final AuthorService authorService;
    private final AutorDetalhesService autorDetalhesService;

// Construtores
    @Autowired
    public AuthorsController(AuthorService authorService, AutorDetalhesService autorDetalhesService){
        this.authorService=authorService;
        this.autorDetalhesService = autorDetalhesService;
    }

// Métodos
    @GetMapping("/autores/new")
    public String addAutor(Model model){
        model.addAttribute("autor", new Author());
        model.addAttribute("generos", Genre.values());
        model.addAttribute("detalhes", new AutorDetalhes());

        return "pages/autores/new";
    }

    @PostMapping("/autores/save")
    public String saveAutor(@Valid @ModelAttribute("autor") Author autor, BindingResult autorResult, @Valid @ModelAttribute("detalhes") AutorDetalhes autorDetalhes, BindingResult autorDetalhesResult, Model model, RedirectAttributes redirectAttrs){
        if (autorResult.hasErrors() || autorDetalhesResult.hasErrors()){
            model.addAttribute("generos", Genre.values());

            return "pages/autores/new";
        }

        Author autorCriado = authorService.saveAutor(autor);
        autorDetalhes.setAutor(autorCriado);
        AutorDetalhes detalhes = autorDetalhesService.saveAutorDetalhes(autorDetalhes);
        redirectAttrs.addAttribute("id", autorCriado.getId());


        return "redirect:/autores/view/{id}";
    }

    @GetMapping("/autores/list")
    public String getAllAutores(Model model){
        List<Author> autores=authorService.getAllAuthors();
        model.addAttribute("listaAutores", autores);

        return "pages/autores/list";
    }

    @GetMapping("/autores/delete/{id}")
    public String deleteAutores(@PathVariable("id") Long id){
        authorService.deleteAutor(id);

        return "redirect:/autores/list";
    }

    @GetMapping("autores/view/{id}")
    public String getAuthorById(@PathVariable("id") Long id, Model model){
        Optional<Author> autor=authorService.getAuthorById(id);
        if(autor.isPresent()){
            model.addAttribute("inst",autor.get());
            return "pages/autores/view";
        }

        return "redirect:/autores/list";
    }

    @GetMapping("autores/edit/{id}")
    public String editAuthorById(@PathVariable("id") Long id, Model model){
        Optional<Author> autor=authorService.getAuthorById(id);
        if(autor.isPresent()){
            model.addAttribute("autor",autor.get());
            model.addAttribute("generos", Genre.values());
            model.addAttribute("detalhes", authorService.getAllAuthors());
            return "pages/autores/edit";
        }

        return "redirect:/autores/list";
    }

    @PostMapping("/autores/update/{id}")
    public String updateAutor(@Valid @ModelAttribute("autor") Author autor, BindingResult result, Model model, @PathVariable("id") Long id){
        if (result.hasErrors()){
            model.addAttribute("generos", Genre.values());
            return "pages/autores/edit";
        }
        Author autorAtualizado=authorService.updateAutor(id, autor);
        if (autorAtualizado==null){
            model.addAttribute("generos", Genre.values());
            model.addAttribute("falhou", "Não foi possível editar.");
            return "pages/autores/edit";
        }

        return "redirect:/autores/view/{id}";
    }
}
