import java.text.ParseException;
import java.time.LocalDate;

public class Aluno extends Pessoa{
/*Zona dos atributos*/
    private static int num=0;
    private String nAluno;
    private String rank;
    private int ano;


/*Zona dos métodos*/

    @Override
    public String toString() {
        return "[ "+nAluno+" ]"+ super.toString()+", "+rank+" "+ano+"º ano";
    }

    /*Zona dos construtores*/
    public Aluno() throws ParseException {
        num++;
        this.nAluno="A"+String.format("%04d",num);
    }

    public Aluno(String nome, int nif, LocalDate dataNascimento, String sexo, String rank, int ano){
        super(nome, nif, dataNascimento, sexo);
        num++;
        this.nAluno="A"+String.format("%04d",num);
        this.setRank(rank);
        this.setAno(ano);
    }
/*Zona dos getters/setters*/
    public String getnAluno() {return this.nAluno;}
    public void setnAluno(String nAluno) {this.nAluno = nAluno;}
    ////////////////////////////////////////////////////////////////////
    public String getRank() {return this.rank;}
    public void setRank(String rank) {this.rank = rank;}
    ////////////////////////////////////////////////////////////////////
    public int getAno() {return this.ano;}
    public void setAno(int ano) {
        if(ano<1 && ano>12){
            this.ano=1;
        }else {
            this.ano = ano;
        }
    }
}
