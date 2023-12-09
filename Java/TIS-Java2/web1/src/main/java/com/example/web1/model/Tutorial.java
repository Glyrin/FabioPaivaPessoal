package com.example.web1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity // define como uma tabela na BD
@Table(name = "tutoriais") // dá o nome à tabela, pode ser capitalizado ou não
@Comment(value = "Tabela dos tutoriais") // gera comentários ao fazer reverse engineering na BD
public class Tutorial extends BaseEntity{
//Atributos
    @NotBlank(message = "Título é obrigatório")
    @Length(min=1, max=128, message = "Título tem de ter entre 1 e 128 caracteres")
    @Column(name = "titulo")
    private String title;

    @NotBlank(message = "Descrição é obrigatória")
    @Length(min=1, max=65000, message = "Descrição tem de ter entre 1 e 65000 caracteres")
    @Column(name = "descricao")
    private String description;

    @NotNull(message = "Preço é obrigatório")
    @Basic(optional = false)
    @DecimalMin(value = "0.00", message = "Preço tem de estar acima de 0€")
    @DecimalMax(value = "10.00", message = "Preço tem de estar abaixo de 10€")
    @Column(name = "preco")
    private Double price;

    @NotNull(message = "Nível é obrigatório")
    @Basic(optional = false)
    @Min(value = 1, message = "Nível tem de ser maior que 1")
    @Max(value = 5, message = "Nível tem de ser menor que 5")
    @Column(name = "nivel")
    private Integer level;

    @ColumnDefault(value = "false") // valor por defeito na coluna
    @Column(name = "publicado")
    private Boolean published;

    @ManyToOne(fetch = FetchType.LAZY) // chave externa o fetch lazy retorna só a pesquisa objetiva
    @JoinColumn(name="autor_id", nullable = false)
    private Author autor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Tutorials_tags", joinColumns = @JoinColumn(name="tutorial_id"), inverseJoinColumns = @JoinColumn(name="tag_id"))
    private List<Tag> tags;

//Construtores
    public Tutorial(){}
    public Tutorial(Long id, String title, String description, Double price, Integer level, Boolean published){
        super(id);
        this.title=title;
        this.description=description;
        this.price=price;
        this.level=level;
        this.published=published;
    }

//Getters & Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getPublished() {
        return published;
    }
    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Author getAutor() {return autor;}
    public void setAutor(Author autor) {this.autor = autor;}

    public List<Tag> getTags() {return tags;}
    public void setTags(List<Tag> tags) {this.tags = tags;}
}
