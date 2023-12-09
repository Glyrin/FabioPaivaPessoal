package InesFabio.MenuEscolar.Model;

import InesFabio.MenuEscolar.Enums.Casa;
import InesFabio.MenuEscolar.Enums.Especie;
import InesFabio.MenuEscolar.Enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Comment;
import java.time.LocalDate;

@Entity
@Table(name="Alunos")
@Comment(value="Tabela de alunos")
public class Aluno extends Pessoa{
// Atributos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Alunos têm de estar associados a uma casa")
    @Column(nullable = false)
    private Casa casa;

    @Valid
    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Login utilizador;

// Construtores
    public Aluno(){}

    public Aluno(Long id, String nome, String apelido, Integer cc, LocalDate dataNascimento, Especie especie, Sexo sexo, String email, Integer telefone, String morada, String codPostal, String localidade, Boolean ativo, String detalhes, Turma turma, Casa casa, Login utilizador) {
        super(id, nome, apelido, cc, dataNascimento, especie, sexo, email, telefone, morada, codPostal, localidade, ativo, detalhes);
        this.setTurma(turma);
        this.setCasa(casa);
        this.setUtilizador(utilizador);
    }

// Métodos
    //

//Getters & Setters
    public Turma getTurma() {return turma;}
    public void setTurma(Turma turma) {this.turma = turma;}

    public Casa getCasa() {return casa;}
    public void setCasa(Casa casa) {this.casa = casa;}

    public Login getUtilizador() {return utilizador;}
    public void setUtilizador(Login utilizador) {this.utilizador = utilizador;}
}