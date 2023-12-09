package com.example.web1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name="autor_detalhes")
public class AutorDetalhes extends BaseEntity{
// Atributos
    @Column(nullable = false)
    @NotBlank(message= "Email obrigatório")
    @Email(message="Formato de email inválido")
    private String email;

    @Column
    @URL(message="Formato de URL inválido, tem de começar por http")
    private String website;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="autor_id", nullable = false, unique = true)
    private Author autor;

//Construtores
    public AutorDetalhes() { }


// Métodos

// Getters e Setters
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getWebsite() {return website;}
    public void setWebsite(String website) {this.website = website;}

    public Author getAutor() {return autor;}
    public void setAutor(Author autor) {this.autor = autor;}
}
