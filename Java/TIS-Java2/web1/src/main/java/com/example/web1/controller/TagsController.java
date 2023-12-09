package com.example.web1.controller;

import com.example.web1.model.Tag;
import com.example.web1.service.TagsService;
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
public class TagsController {
// Atributos
    private final TagsService tagsService;

// Construtores
    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

// Métodos
    @GetMapping("/tags/new")
    public String addTag(Model model){
        model.addAttribute("tag", new Tag());

        return "pages/tags/new";
    }

    @PostMapping("/tags/save")
    public String saveTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model model, RedirectAttributes redirectAttrs){
        if(result.hasErrors()){
            return "pages/tags/new";
        }

        Tag tagCriada=tagsService.saveTag(tag);
        redirectAttrs.addAttribute("id", tagCriada.getId());

        return "redirect:/tags/view/{id}";
    }

    @GetMapping("/tags/list")
    public String getAllTags(Model model){
        List<Tag> tags=tagsService.getAllTags();
        model.addAttribute("listaTags", tags);

        return "pages/tags/list";
    }

    @GetMapping("/tags/delete/{id}")
    public String deleteTags(@PathVariable("id") Long id){
        tagsService.deleteTag(id);

        return "redirect:/tags/list";
    }

    @GetMapping("tags/view/{id}")
    public String getTagById(@PathVariable("id") Long id, Model model){
        Optional<Tag> tag=tagsService.getTagById(id);
        if(tag.isPresent()){
            model.addAttribute("inst", tag.get());
            return "pages/tags/view";
        }

        return "redirect:/tags/list";
    }

    @GetMapping("tags/edit/{id}")
    public String editTagById(@PathVariable("id") Long id, Model model){
        Optional<Tag> tag=tagsService.getTagById(id);
        if(tag.isPresent()){
            model.addAttribute("tag", tag.get());
            return "pages/tags/edit";
        }

        return "redirect:/tags/list";
    }

    @PostMapping("tags/update/{id}")
    public String updateTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model model, @PathVariable("id") Long id){
        if(result.hasErrors()){
            return "pages/tags/edit";
        }
        Tag tagAtualizada=tagsService.updateTag(id, tag);
        if(tagAtualizada==null){
            model.addAttribute("falhou", "Não foi possível editar.");
            return "pages/tags/edit";
        }

        return "redirect:/tags/view/{id}";
    }
}
