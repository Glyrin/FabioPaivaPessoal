package InesFabio.MenuEscolar.Model;

import InesFabio.MenuEscolar.Enums.Especie;
import InesFabio.MenuEscolar.Enums.Sexo;
import InesFabio.MenuEscolar.Enums.TipoContrato;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Funcionario extends Pessoa{
// Atributos
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tipo de contrato é obrigatório")
    @Column(nullable = false)
    private TipoContrato tipoContrato;

    @NotNull(message = "NIF é obrigatório")
    @Column(nullable = false)
    @Digits(integer = 9, fraction = 0, message = "NIF tem de ter 9 dígitos")
    private Integer nif;

    @NotNull(message = "NISS é obrigatório")
    @Column(nullable = false)
    @Digits(integer = 11, fraction = 0, message = "NISS tem de ter 11 dígitos")
    private Long niss;

    @NotBlank(message = "IBAN é obrigatório")
    @Column(nullable = false)
    @Size(min = 25, max = 25, message = "IBAN tem de ter 25 caracteres")
    @Pattern(regexp = "[A-Z]{2}\\d{23}", message = "Formato de IBAN inválido.")
    private String iban;

// Construtores
    public Funcionario(){}

    public Funcionario(Long id, String nome, String apelido, Integer cc, LocalDate dataNascimento, Especie especie, Sexo sexo, String email, Integer telefone, String morada, String codPostal, String localidade, Boolean ativo, String detalhes, TipoContrato tipoContrato, Integer nif, Long niss, String iban) {
        super(id, nome, apelido, cc, dataNascimento, especie, sexo, email, telefone, morada, codPostal, localidade, ativo, detalhes);
        this.setTipoContrato(tipoContrato);
        this.setNif(nif);
        this.setNiss(niss);
        this.setIban(iban);
    }

// Métodos
    //

//Getters & Setters
    public TipoContrato getTipoContrato() {return tipoContrato;}
    public void setTipoContrato(TipoContrato tipoContrato) {this.tipoContrato = tipoContrato;}

    public Integer getNif() {return nif;}
    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public Long getNiss() {return niss;}
    public void setNiss(Long niss) {
        this.niss = niss;
    }

    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
}