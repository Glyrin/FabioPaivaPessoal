package InesFabio.MenuEscolar.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.Comment;
import org.hibernate.validator.constraints.Length;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Turmas")
@Comment(value="Tabela de turmas")
public class Turma extends BaseEntity{
// Atributos
    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    @Length(min=1, max = 25, message = "Nome tem de ter entre 1 e 25 caracteres")
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Turmas_Disciplinas", joinColumns = @JoinColumn(name="turma_id"), inverseJoinColumns = @JoinColumn(name="disciplina_id"))
    private List<Disciplina> disciplinas=new ArrayList<>();

    @OneToMany(mappedBy = "turma", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Aluno> alunos=new ArrayList<>();

// Construtores
    public Turma(){}

    public Turma(Long id, String nome, List<Disciplina> disciplinas, List<Aluno> alunos) {
        super(id);
        this.setNome(nome);
        this.setDisciplinas(disciplinas);
        this.setAlunos(alunos);
    }

// Métodos
    //

//Getters & Setters
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Aluno> getAlunos() {return alunos;}
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}