package com.example.web1.controller;

import com.example.web1.model.Tutorial;
import com.example.web1.service.AuthorService;
import com.example.web1.service.TagsService;
import com.example.web1.service.TutorialService;
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
public class TutorialsController {
// Atributos
    private final TutorialService tutorialService;
    private final AuthorService authorService;
    private final TagsService tagsService;

// Construtores
    @Autowired
    public TutorialsController(TutorialService tutorialService, AuthorService authorService, TagsService tagsService){
        this.tutorialService=tutorialService;
        this.authorService = authorService;
        this.tagsService = tagsService;
    }

// Métodos
    @GetMapping("/tutorials/new")
    public String addTutorial(Model model){
        model.addAttribute("tutorial", new Tutorial());
        model.addAttribute("autores", authorService.getAllAuthors());
        model.addAttribute("tags", tagsService.getAllTags());

        return "pages/tutorials/new";
    }
    @PostMapping("/tutorials/save")
    public String saveTutorial(@Valid @ModelAttribute("tutorial") Tutorial tutorial, BindingResult result, RedirectAttributes redirectAttrs, Model model){
        if (result.hasErrors()){
            model.addAttribute("autores", authorService.getAllAuthors());
            model.addAttribute("tags", tagsService.getAllTags());
            return "pages/tutorials/new";
        }

        Tutorial criado = tutorialService.saveTutorial(tutorial);
        redirectAttrs.addAttribute("id", criado.getId());

        return "redirect:/tutorials/view/{id}";
    }
    @GetMapping("tutorials/list")
    public String getAllTutorials(Model model){
        List<Tutorial> tutoriais=tutorialService.getAllTutorials();
        model.addAttribute("listaTutorials", tutoriais);
        model.addAttribute("autores", authorService.getAllAuthors());

        return "pages/tutorials/list";
    }
    @GetMapping("/tutorials/delete/{id}")
    public String deleteTutorial(@PathVariable("id") Long id){
        tutorialService.deleteTutorial(id);

        return "redirect:/tutorials/list";
    }
    @GetMapping("tutorials/view/{id}")
    public String getTutorialById(@PathVariable("id") Long id, Model model){
        Optional<Tutorial> tutorial=tutorialService.getTutorialById(id);
        if(tutorial.isPresent()){
            model.addAttribute("inst", tutorial.get());
            model.addAttribute("tags", tagsService.getTagsByTutorialId(tutorial.get()));
            return "pages/tutorials/view";
        }

        return "redirect:/tutorials/list";
    }
    @GetMapping("tutorials/edit/{id}")
    public String editTutorialById(@PathVariable("id") Long id, Model model){
        Optional<Tutorial> tutorial=tutorialService.getTutorialById(id);
        if(tutorial.isPresent()){
            model.addAttribute("tutorial", tutorial.get());
            model.addAttribute("autores", authorService.getAllAuthors());
            model.addAttribute("tags", tagsService.getAllTags());
            return "pages/tutorials/edit";
        }

        return "redirect:/tutorials/list";
    }
    @PostMapping("/tutorials/update/{id}")
    public String updateTutorial(@Valid @ModelAttribute("tutorial") Tutorial tutorial, BindingResult result,Model model, @PathVariable("id") Long id){
        if (result.hasErrors()){
            model.addAttribute("autores", authorService.getAllAuthors());
            model.addAttribute("tags", tagsService.getAllTags());
            return "pages/tutorials/edit";
        }
        Tutorial tutorialAtualizado=tutorialService.updateTutorial(id, tutorial);
        if(tutorialAtualizado==null){
            model.addAttribute("falhou", "Não foi possível editar.");
            return "pages/tutorials/edit";
        }

        return "redirect:/tutorials/view/{id}";
    }

    @GetMapping("/tutorials/search")
    public String pesquisaTutoriais(@RequestParam("keyword") String keyword, Model model){
        List<Tutorial> tutoriais=tutorialService.getTutorialByTitle(keyword);
        model.addAttribute("listaTutorials", tutoriais);
        model.addAttribute("keyword", keyword);

        return "pages/tutorials/list";
    }
}
