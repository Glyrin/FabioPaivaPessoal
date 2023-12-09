package com.example.web1.model;

import com.example.web1.enums.Genre;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="autores")
@Comment(value="Tabela dos autores")
public class Author extends BaseEntity {
//Atributos
    @NotBlank(message = "Nome é obrigatório")
    @Length(min=1, max=128, message = "Nome tem de ter entre 1 e 128 caracteres") // também pode ser @Size
    private String nome;

    @NotBlank(message = "Apelido é obrigatório")
    @Length(min=1, max=128, message = "Apelido tem de ter entre 1 e 128 caracteres")
    private String apelido;

    @NotNull(message = "Idade é obrigatória")
    @Basic(optional = false)
    @Min(value=0, message = "Idade tem de ser maior do que 0 anos")
    private Integer idade;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Género é obrigatório")
    @Basic(optional = false)
    private Genre genero;

    @NotBlank(message = "País é obrigatório")
    private String pais;

    @ColumnDefault(value = "false")
    private Boolean ativo;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true) // cascade pode ser feito com {tipo1, tipo2}
    private List<Tutorial> tutoriais=new ArrayList<>();

    @Valid
    @OneToOne(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private AutorDetalhes autorDetalhes;

//Construtores
    public Author(){}

    public Author(Long id, String nome, String apelido, Integer idade, Genre genero, String pais, Boolean ativo) {
        super(id);
        this.nome = nome;
        this.apelido = apelido;
        this.idade = idade;
        this.genero = genero;
        this.pais = pais;
        this.ativo = ativo;
    }
// Métodos
    public void adicionarTutorial(Tutorial tutorial){
        tutoriais.add(tutorial);
        tutorial.setAutor(this);
    }

    public void apagarTutorial(Tutorial tutorial){
        tutoriais.remove(tutorial);
        tutorial.setAutor(null);
    }

//Getters & Setters

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getApelido() {return apelido;}
    public void setApelido(String apelido) {this.apelido = apelido;}

    public Integer getIdade() {return idade;}
    public void setIdade(Integer idade) {this.idade = idade;}

    public Genre getGenero() {return genero;}
    public void setGenero(Genre genero) {this.genero = genero;}

    public String getPais() {return pais;}
    public void setPais(String pais) {this.pais = pais;}

    public Boolean getAtivo() {return ativo;}
    public void setAtivo(Boolean ativo) {this.ativo = ativo;}

    public List<Tutorial> getTutoriais() {return tutoriais;}
    public void setTutoriais(List<Tutorial> tutoriais) {this.tutoriais = tutoriais;}

    public AutorDetalhes getAutorDetalhes() {return autorDetalhes;}
    public void setAutorDetalhes(AutorDetalhes autorDetalhes) {this.autorDetalhes = autorDetalhes;}
}

