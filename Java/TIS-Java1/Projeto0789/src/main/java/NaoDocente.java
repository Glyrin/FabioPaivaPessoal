import java.text.ParseException;
import java.time.LocalDate;

public class NaoDocente extends Pessoa{
/*Zona dos atributos*/
    private static int num=0;
    private String nFuncionario="F000";
    private String rank;
    private String departamento;

/*Zona dos métodos*/


    @Override
    public String toString() {
        return "[ "+nFuncionario+" ]"+super.toString()+", "+rank+" "+departamento;
    }

    /*Zona dos construtores*/
    public NaoDocente() throws ParseException {
        num++;
        this.nFuncionario="F"+String.format("%03d",num);
    }

    public NaoDocente(String nome, int nif, LocalDate dataNascimento, String sexo, String rank, String departamento){
        super(nome, nif, dataNascimento, sexo);
        num++;
        this.nFuncionario="F"+String.format("%03d",num);
        this.setRank(rank);
        this.setDepartamento(departamento);
    }
/*Zona dos getters/setters*/
    public String getnFuncionario() {return this.nFuncionario;}
    public void setnFuncionario(String nFuncionario) {this.nFuncionario = nFuncionario;}
    ////////////////////////////////////////////////////////////////////
    public String getRank() {return this.rank;}
    public void setRank(String rank) {this.rank = rank;}
    ////////////////////////////////////////////////////////////////////
    public String getDepartamento() {return this.departamento;}
    public void setDepartamento(String departamento) {this.departamento = departamento;}
}
