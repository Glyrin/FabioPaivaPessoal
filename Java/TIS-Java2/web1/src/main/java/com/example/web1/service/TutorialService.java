package com.example.web1.service;

import com.example.web1.model.Tutorial;
import com.example.web1.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {
//Atributos
    private final TutorialRepository tutorialRepository;

//Construtores
    @Autowired
    public TutorialService(TutorialRepository tutorialRepository){
        this.tutorialRepository = tutorialRepository;
    }

//Métodos
    public Tutorial saveTutorial(Tutorial tutorial){
        //Tutorial _tutorial = tutorialRepository.save(tutorial);
        //return _tutorial;
        return tutorialRepository.save(tutorial);
    }

    public List<Tutorial> getAllTutorials(){
        return tutorialRepository.findAll();
    }

    public void deleteTutorial(Long id){
        tutorialRepository.deleteById(id);
    }

    public Optional<Tutorial> getTutorialById(Long id){
        Optional<Tutorial> tutorial=tutorialRepository.findById(id);
        return tutorial;
    }

    public Tutorial updateTutorial(Long id, Tutorial tutorial){
        Optional<Tutorial> tutorialAtualizado=getTutorialById(id);

        if(tutorialAtualizado.isPresent()){
            Tutorial _tutorial=tutorialAtualizado.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPrice(tutorial.getPrice());
            _tutorial.setLevel(tutorial.getLevel());
            _tutorial.setPublished(tutorial.getPublished());
            _tutorial.setAutor(tutorial.getAutor());
            _tutorial.setTags(tutorial.getTags());

            return tutorialRepository.save(_tutorial);
        }

        return null;
    }

    public List<Tutorial> getTutorialByTitle(String keyword){
        return tutorialRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
