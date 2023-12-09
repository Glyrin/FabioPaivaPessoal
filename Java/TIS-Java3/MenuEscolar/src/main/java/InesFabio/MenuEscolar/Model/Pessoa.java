package InesFabio.MenuEscolar.Model;

import InesFabio.MenuEscolar.Enums.Especie;
import InesFabio.MenuEscolar.Enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.Period;

@MappedSuperclass
public abstract class Pessoa extends BaseEntity{
// Atributos
    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    @Length(min=1, max=25, message = "Nome tem de ter entre 1 e 25 caracteres")
    private String nome;

    @NotBlank(message = "Apelido é obrigatório")
    @Column(nullable = false)
    @Length(min=1, max=25, message = "Apelido tem de ter entre 1 e 25 caracteres")
    private String apelido;

    @NotNull(message = "Nº de CC é obrigatório")
    @Column(nullable = false)
    @Digits(integer = 8, fraction = 0, message = "Nº CC tem de ter 8 dígitos")
    private Integer cc;

    @NotNull(message = "Data de Nascimento é obrigatória")
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "A data de nascimento não pode estar no futuro")
    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Pessoas têm de ter uma espécie")
    @Column(nullable = false)
    private Especie especie;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Sexo é um campo obrigatório")
    @Column(nullable = false)
    private Sexo sexo;

    @NotNull(message = "Email é obrigatório")
    @Column(nullable = false)
    @Email(message = "Formato de email incorreto")
    private String email;

    @NotNull(message = "Telefone é obrigatório")
    @Column(nullable = false)
    @Digits(integer = 9, fraction = 0, message = "Telefone tem de ter 9 dígitos")
    private Integer telefone;

    @NotBlank(message = "Morada é obrigatória")
    @Column(nullable = false)
    @Length(min=1, max=100, message = "Morada tem de ter entre 1 e 100 caracteres")
    private String morada;

    @NotBlank(message = "Código-Postal é obrigatório")
    @Column(nullable = false, length = 8)
    @Pattern(regexp = "\\d{4}-\\d{3}", message = "Formato de código-postal inválido. Formato correto xxxx-xxx")
    private String codPostal;

    @NotBlank(message = "Localidade é obrigatória")
    @Column(nullable = false)
    @Length(min=1, max=25, message = "Localidade tem de ter entre 1 e 25 caracteres")
    private String localidade;

    @ColumnDefault(value = "false")
    private Boolean ativo;

    @Length(min=0, max=10000, message = "Apelido tem de ter entre 1 e 25 caracteres")
    private String detalhes;

// Construtores
    public Pessoa(){}

    public Pessoa(Long id, String nome, String apelido, Integer cc, LocalDate dataNascimento, Especie especie, Sexo sexo, String email, Integer telefone, String morada, String codPostal, String localidade, Boolean ativo, String detalhes) {
        super(id);
        this.setNome(nome);
        this.setApelido(apelido);
        this.setCc(cc);
        this.setDataNascimento(dataNascimento);
        this.setEspecie(especie);
        this.setSexo(sexo);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setMorada(morada);
        this.setCodPostal(codPostal);
        this.setLocalidade(localidade);
        this.setAtivo(ativo);
        this.setDetalhes(detalhes);
    }

// Métodos
    public static int idade(LocalDate dataNascimento){
        Period periodoDecorrido = Period.between(dataNascimento, LocalDate.now());

        return periodoDecorrido.getYears();
    }

//Getters & Setters
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getApelido() {return apelido;}
    public void setApelido(String apelido) {this.apelido = apelido;}

    public Integer getCc() {return cc;}
    public void setCc(Integer cc) {this.cc = cc;}

    public LocalDate getDataNascimento() {return dataNascimento;}
    public void setDataNascimento(LocalDate dataNascimento) {this.dataNascimento = dataNascimento;}

    public Especie getEspecie() {return especie;}
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefone() {
        return telefone;
    }
    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }
    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCodPostal() {
        return codPostal;
    }
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getLocalidade() {
        return localidade;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getDetalhes() {
        return detalhes;
    }
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}