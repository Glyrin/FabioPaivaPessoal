import java.text.ParseException;
import java.time.LocalDate;

public class Professor extends Pessoa{
/*Zona dos atributos*/
    private static int num=0;
    private String nProfessor;
    private String rank;
    private String disciplina;

/*Zona dos métodos*/


    @Override
    public String toString() {
        return "[ "+nProfessor+" ]"+super.toString()+", "+rank+" "+disciplina;
    }

    /*Zona dos construtores*/
    public Professor() throws ParseException {
        num++;
        this.nProfessor="P"+String.format("%03d",num);
    }

    public Professor(String nome, int nif, LocalDate dataNascimento, String sexo, String rank, String disciplina){
        super(nome, nif, dataNascimento, sexo);
        num++;
        this.nProfessor="P"+String.format("%03d",num);
        this.setRank(rank);
        this.setDisciplina(disciplina);
    }

/*Zona dos getters/setters*/
    public String getnProfessor() {return this.nProfessor;}
    public void setnProfessor(String nProfessor) {this.nProfessor = nProfessor;}
    ////////////////////////////////////////////////////////////////////
    public String getRank() {return this.rank;}
    public void setRank(String rank) {this.rank = rank;}
    ////////////////////////////////////////////////////////////////////
    public String getDisciplina() {return this.disciplina;}
    public void setDisciplina(String disciplina) {this.disciplina = disciplina;}
}
