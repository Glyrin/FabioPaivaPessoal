package InesFabio.MenuEscolar.Service;

import InesFabio.MenuEscolar.Model.Aluno;
import InesFabio.MenuEscolar.Model.Docente;
import InesFabio.MenuEscolar.Model.NaoDocente;
import InesFabio.MenuEscolar.Model.Login;
import InesFabio.MenuEscolar.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    // Atributos
    private final LoginRepository loginRepository;

    // Construtores
    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    // Métodos
    public Login saveLoginAluno(Aluno aluno) {
        Login login = new Login();
        login.setUsername(Login.user(aluno.getNome(), aluno.getApelido(), aluno.getCc()));
        login.setPassword(Login.pass(aluno.getDataNascimento()));
        login.setAluno(aluno);
        loginRepository.save(login);

        return login;
    }

    public Login saveLoginDocente(Docente docente) {
        Login login = new Login();
        login.setUsername(Login.user(docente.getNome(), docente.getApelido(), docente.getCc()));
        login.setPassword(Login.pass(docente.getDataNascimento()));
        login.setDocente(docente);
        loginRepository.save(login);

        return login;
    }

    public Login saveLoginNaoDocente(NaoDocente naodocente) {
        Login login = new Login();
        login.setUsername(Login.user(naodocente.getNome(), naodocente.getApelido(), naodocente.getCc()));
        login.setPassword(Login.pass(naodocente.getDataNascimento()));
        login.setNaoDocente(naodocente);
        loginRepository.save(login);
        return login;
    }

    public List<Login> validarLogin(String username, String password) {
        return loginRepository.findByUsernameAndPassword(username, password);
    }
    public Optional<Login> viewLoginById (Long id){
        Optional<Login> login = loginRepository.findById(id);
        return login;
    }

    public Login updateLogin(Long id, Login login) {
        Optional<Login> loginAtualizado = viewLoginById(id);

        if (loginAtualizado.isPresent()) {
            Login _login = loginAtualizado.get();
            _login.setPassword(login.getPassword());

            return loginRepository.save(_login);
        }
        return null;
    }
}
