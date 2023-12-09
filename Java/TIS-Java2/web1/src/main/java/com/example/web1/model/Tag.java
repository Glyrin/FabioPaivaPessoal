package com.example.web1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tags")
public class Tag extends BaseEntity{
// Atributos
    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    @Length(min=1, max=25, message = "O tamanho tem de ser entre 1 e 25 caracteres")
    private String nome;

    @ManyToMany(mappedBy = "tags")
    private List<Tutorial> tutoriais=new ArrayList<>();

// Construtores
    public Tag() {}

    public Tag(String nome) {
        this.nome = nome;
    }

// Getters e Setters
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public List<Tutorial> getTutoriais() {return tutoriais;}
    public void setTutoriais(List<Tutorial> tutoriais) {this.tutoriais = tutoriais;}
}
