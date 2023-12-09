package InesFabio.MenuEscolar.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.Comment;
import org.hibernate.validator.constraints.Length;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Disciplinas")
@Comment(value="Tabela de disciplinas")
public class Disciplina extends BaseEntity{
// Atributos
    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    @Length(min=1, max = 50, message = "Nome tem de ter entre 1 e 50 caracteres")
    private String nome;
    @ManyToMany(mappedBy = "especializacoes")
    private List<Docente> professores=new ArrayList<>();

    @ManyToMany(mappedBy = "disciplinas")
    private List<Turma> turmas=new ArrayList<>();

// Construtores
    public Disciplina(){}

    public Disciplina(Long id, String nome, List<Docente> professores, List<Turma> turmas) {
        super(id);
        this.setNome(nome);
        this.setProfessores(professores);
        this.setTurmas(turmas);
    }

// Métodos
    //

//Getters & Setters
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public List<Docente> getProfessores() {
        return professores;
    }
    public void setProfessores(List<Docente> professores) {
        this.professores = professores;
    }

    public List<Turma> getTurmas() {return turmas;}
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}