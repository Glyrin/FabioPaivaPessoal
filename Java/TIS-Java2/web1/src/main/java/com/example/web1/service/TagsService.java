package com.example.web1.service;

import com.example.web1.model.Tag;
import com.example.web1.model.Tutorial;
import com.example.web1.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagsService {
// Atributos
    private final TagsRepository tagsRepository;

// Construtores
    @Autowired
    public TagsService(TagsRepository tagsRepository) {this.tagsRepository = tagsRepository;}

// Métodos
    public Tag saveTag(Tag tag){return tagsRepository.save(tag);}

    public List<Tag> getAllTags(){
        return tagsRepository.findAll();
    }

    public void deleteTag(Long id){tagsRepository.deleteById(id);}

    public Optional<Tag> getTagById(Long id){
        Optional<Tag> tag=tagsRepository.findById(id);
        return tag;
    }

    public Tag updateTag(Long id, Tag tag){
        Optional<Tag> tagAtualizada=getTagById(id);

        if(tagAtualizada.isPresent()){
            Tag _tag=tagAtualizada.get();
            _tag.setNome(tag.getNome());

            return tagsRepository.save(_tag);
        }

        return null;
    }
    public List<Tag> getTagsByTutorialId(Tutorial tutorial){
        return tagsRepository.findByTutoriais(tutorial);
    }
}
