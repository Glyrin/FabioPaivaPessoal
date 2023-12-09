package com.example.web1.service;

import com.example.web1.model.Author;
import com.example.web1.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
//Atributos
    private final AuthorRepository authorRepository;

//Construtores
    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
    }

//Métodos
    public Author saveAutor(Author autor){
        return authorRepository.save(autor);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();

    }

    public void deleteAutor(Long id){
        authorRepository.deleteById(id);
    }

    public Optional<Author> getAuthorById(Long id){
        Optional<Author> autor=authorRepository.findById(id);
        return autor;
    }

    public Author updateAutor(Long id, Author autor){
        Optional<Author> autorAtualizado=getAuthorById(id);

        if(autorAtualizado.isPresent()){
            Author _autor=autorAtualizado.get();
            _autor.setNome(autor.getNome());
            _autor.setApelido(autor.getApelido());
            _autor.setIdade(autor.getIdade());
            _autor.setPais(autor.getPais());
            _autor.setGenero(autor.getGenero());
            _autor.setAtivo(autor.getAtivo());
            _autor.getAutorDetalhes().setEmail(autor.getAutorDetalhes().getEmail());
            _autor.getAutorDetalhes().setWebsite(autor.getAutorDetalhes().getWebsite());

            return authorRepository.save(_autor);
        }

        return null;
    }
}
