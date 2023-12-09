package InesFabio.MenuEscolar.Model;

import InesFabio.MenuEscolar.Enums.Especie;
import InesFabio.MenuEscolar.Enums.Funcao;
import InesFabio.MenuEscolar.Enums.Sexo;
import InesFabio.MenuEscolar.Enums.TipoContrato;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Comment;
import java.time.LocalDate;

@Entity
@Table(name="NaoDocentes")
@Comment(value="Tabela de não docentes")
public class NaoDocente extends Funcionario{
// Atributos
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Todos os não docentes têm de ter uma função")
    @Column(nullable = false)
    private Funcao funcoes;

    @Valid
    @OneToOne(mappedBy = "naoDocente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Login utilizador;

// Construtores
    public NaoDocente(){}

    public NaoDocente(Long id, String nome, String apelido, Integer cc, LocalDate dataNascimento, Especie especie, Sexo sexo, String email, Integer telefone, String morada, String codPostal, String localidade, Boolean ativo, String detalhes, TipoContrato tipoContrato, Integer nif, Long niss, String iban, Funcao funcoes, Login utilizador) {
        super(id, nome, apelido, cc, dataNascimento, especie, sexo, email, telefone, morada, codPostal, localidade, ativo, detalhes, tipoContrato, nif, niss, iban);
        this.setFuncoes(funcoes);
        this.setUtilizador(utilizador);
    }

// Métodos
    //

//Getters & Setters
    public Funcao getFuncoes() {return funcoes;}
    public void setFuncoes(Funcao funcoes) {this.funcoes = funcoes;}

    public Login getUtilizador() {return utilizador;}
    public void setUtilizador(Login utilizador) {this.utilizador = utilizador;}
}