import java.text.ParseException;
import java.time.LocalDate;

public class Pessoa {
/*Zona dos atributos*/
    private String nome = "primeiroNome últimoNome";
    private int nif = 999999999;
    private LocalDate dataNascimento = LocalDate.now();
    private int idade;
    private String sexo = "Indefinido";

/*Zona dos métodos*/

    @Override
    public String toString() {
        return "Nome: "+nome+", NIF: "+nif+", Data de Nascimento: "+dataNascimento+", Idade: "+idade+", Sexo: "+sexo;
    }

    /*Zona dos construtores*/
    public Pessoa() throws ParseException {
        this.idade=CalcularIdade.IdadeConstrutor(dataNascimento);
    }

    public Pessoa(String nome, int nif, LocalDate dataNascimento, String sexo) {
        this.setNome(nome);
        this.setNif(nif);
        this.setDataNascimento(dataNascimento);
        this.idade=CalcularIdade.IdadeConstrutor(dataNascimento);
        this.setSexo(sexo);
    }

/*Zona dos getters/setters*/
    public String getNome() {return this.nome;}
    public void setNome(String nome) {this.nome = nome;}
    ////////////////////////////////////////////////////////////////////
    public int getNif() {return this.nif;}
    public void setNif(int nif) {this.nif = nif;}
    ////////////////////////////////////////////////////////////////////
    public LocalDate getDataNascimento() {return dataNascimento;}
    public void setDataNascimento(LocalDate dataNascimento) {this.dataNascimento = dataNascimento;}
    ////////////////////////////////////////////////////////////////////
    public int getIdade() {return this.idade;}
    public void setIdade(int idade) {this.idade = idade;}
    ////////////////////////////////////////////////////////////////////
    public String getSexo() {return this.sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}
}
