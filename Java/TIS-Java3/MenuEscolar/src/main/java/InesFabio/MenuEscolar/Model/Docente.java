package InesFabio.MenuEscolar.Model;

import InesFabio.MenuEscolar.Enums.Especie;
import InesFabio.MenuEscolar.Enums.Sexo;
import InesFabio.MenuEscolar.Enums.TipoContrato;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import org.hibernate.annotations.Comment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Docentes")
@Comment(value="Tabela de docentes")
public class Docente extends Funcionario{
// Atributos

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Docentes_Disciplinas", joinColumns = @JoinColumn(name="docente_id"), inverseJoinColumns = @JoinColumn(name="disciplina_id"))
    private List<Disciplina> especializacoes=new ArrayList<>();

    @Valid
    @OneToOne(mappedBy = "docente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Login utilizador;


// Construtores
    public Docente(){}

    public Docente(Long id, String nome, String apelido, Integer cc, LocalDate dataNascimento, Especie especie, Sexo sexo, String email, Integer telefone, String morada, String codPostal, String localidade, Boolean ativo, String detalhes, TipoContrato tipoContrato, Integer nif, Long niss, String iban, List<Disciplina> especializacoes, Login utilizador) {
        super(id, nome, apelido, cc, dataNascimento, especie, sexo, email, telefone, morada, codPostal, localidade, ativo, detalhes, tipoContrato, nif, niss, iban);
        this.setEspecializacoes(especializacoes);
        this.setUtilizador(utilizador);
    }

// Métodos
    //

//Getters & Setters
    public List<Disciplina> getEspecializacoes() {return especializacoes;}
    public void setEspecializacoes(List<Disciplina> especializacoes) {this.especializacoes = especializacoes;}

    public Login getUtilizador() {return utilizador;}
    public void setUtilizador(Login utilizador) {this.utilizador = utilizador;}
}