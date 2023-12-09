package com.example.web1.service;

import com.example.web1.model.Author;
import com.example.web1.model.AutorDetalhes;
import com.example.web1.repository.AutorDetalhesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorDetalhesService {
// Atributos
    private final AutorDetalhesRepository autorDetalhesRepository;

// Construtores
    @Autowired
    public AutorDetalhesService(AutorDetalhesRepository autorDetalhesRepository) {
        this.autorDetalhesRepository = autorDetalhesRepository;
    }

// Métodos
    public AutorDetalhes saveAutorDetalhes(AutorDetalhes detalhes){
        return autorDetalhesRepository.save(detalhes);
    }

    public List<AutorDetalhes> getAllAutoresDetalhes(){
        return autorDetalhesRepository.findAll();

    }
}
