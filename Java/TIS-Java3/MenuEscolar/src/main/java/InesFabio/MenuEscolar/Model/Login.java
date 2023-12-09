package InesFabio.MenuEscolar.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.Comment;
import org.hibernate.validator.constraints.Length;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="Logins")
@Comment(value="Tabela de logins")
public class Login extends BaseEntity{
// Atributos
    @NotBlank
    @Column(nullable = false, unique=true)
    @Length(min = 1, max = 50)
    private String username;

    @NotBlank(message = "Password é obrigatória")
    @Column(nullable = false)
    @Length(min=8, max = 12, message = "Password deve ter entre 8 e 12 caracteres")
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", unique=true)
    private Aluno aluno;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_id", unique=true)
    private Docente docente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "naoDocente_id", unique=true)
    private NaoDocente naoDocente;

// Construtores
    public Login(){}

    public Login(Long id, String username, String password, Aluno aluno, Docente docente, NaoDocente naoDocente) {
        super(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setAluno(aluno);
        this.setDocente(docente);
        this.setNaoDocente(naoDocente);
    }

    public Login(String username, String password){
        this.setUsername(username);
        this.setPassword(password);
    }

// Métodos
    public static String user(String nome, String apelido, Integer cc){
        String[] separarNome=nome.toLowerCase().split(" ");
        String primeiroNome= separarNome[0];

        String[] separarApelido=apelido.toLowerCase().split(" ");
        String ultimoApelido= separarApelido[separarApelido.length-1];

        String digitosCC= cc.toString();
        String userCC=digitosCC.substring(1, 2)+digitosCC.substring(4, 5)+digitosCC.substring(6, 7);

        String user=primeiroNome+ultimoApelido+userCC;

        user=removerAcentos(user);

        return user;
    }
    public static String removerAcentos(String userAntes){
        String userDepois= Normalizer.normalize(userAntes, Normalizer.Form.NFD);
        userDepois=userDepois.replaceAll("[^\\p{ASCII}]", "");

        return userDepois;
    }
    public static String pass(LocalDate dataNascimento){
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("ddMMyyyy");
        String dataFormatada=dataNascimento.format(formatadorData);
        String pass = dataFormatada+"@Lsd";

        return pass;
    }

//Getters & Setters
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Aluno getAluno() {return aluno;}
    public void setAluno(Aluno aluno) {this.aluno = aluno;}

    public Docente getDocente() {return docente;}
    public void setDocente(Docente docente) {this.docente = docente;}

    public NaoDocente getNaoDocente() {return naoDocente;}
    public void setNaoDocente(NaoDocente naoDocente) {this.naoDocente = naoDocente;}
}