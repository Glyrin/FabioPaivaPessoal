package InesFabio.MenuEscolar.Service;

import InesFabio.MenuEscolar.Enums.Casa;
import InesFabio.MenuEscolar.Model.Aluno;
import InesFabio.MenuEscolar.Model.Turma;
import InesFabio.MenuEscolar.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlunoService {
// Atributos
    private final AlunoRepository alunoRepository;

// Construtores
    @Autowired
    public AlunoService(AlunoRepository alunoRepository){this.alunoRepository=alunoRepository;}

// Métodos Base (Obrigatórios)
    public Aluno saveAluno(Aluno aluno) {return alunoRepository.save(aluno);}
    public List<Aluno> listAluno(){return alunoRepository.findAll();}
    public Optional<Aluno> viewAlunoById(Long id){
        Optional<Aluno> aluno=alunoRepository.findById(id);
        return aluno;
    }
    public Aluno updateAluno(Long id, Aluno aluno){
        Optional<Aluno> alunoAtualizado=viewAlunoById(id);

        if(alunoAtualizado.isPresent()){
            Aluno _aluno=alunoAtualizado.get();
            _aluno.setNome(aluno.getNome());
            _aluno.setApelido(aluno.getApelido());
            _aluno.setCc(aluno.getCc());
            _aluno.setDataNascimento(aluno.getDataNascimento());
            _aluno.setEspecie(aluno.getEspecie());
            _aluno.setSexo(aluno.getSexo());
            _aluno.setEmail(aluno.getEmail());
            _aluno.setTelefone(aluno.getTelefone());
            _aluno.setMorada(aluno.getMorada());
            _aluno.setCodPostal(aluno.getCodPostal());
            _aluno.setLocalidade(aluno.getLocalidade());
            _aluno.setAtivo(aluno.getAtivo());
            _aluno.setDetalhes(aluno.getDetalhes());
            _aluno.setTurma(aluno.getTurma());
            _aluno.setCasa(aluno.getCasa());

            return alunoRepository.save(_aluno);
        }

        return null;
    }
    public void deleteAluno(Long id){alunoRepository.deleteById(id);}

// Métodos Personalizados (opcionais)
    public List<Aluno> listAlunosByTurmaId(Turma turma){return alunoRepository.findByTurma(turma);}
    public List<Aluno> listAlunosByAtivo(){return alunoRepository.findByAtivoTrue();}
    public List<Aluno> listAlunosByTurma(Long turmaFiltro){return alunoRepository.findByTurmaId(turmaFiltro);}
    public List<Aluno> listByCc(Integer ccFiltro){return alunoRepository.findByCc(ccFiltro);}
    public List<Aluno> listByCasa(Casa casaFiltro){return alunoRepository.findByCasa(casaFiltro);}
    public List<Aluno> listByAtivo(Boolean ativoFiltro){return alunoRepository.findByAtivo(ativoFiltro);}
    public List<Aluno> listByNome(String nomeFiltro){
        String[] palavrasChave=nomeFiltro.split(" ");
        List<Aluno> alunosEncontrados=new ArrayList<>();
        for(String palavraChave:palavrasChave){
            List<Aluno> alunosPorChave=alunoRepository.findByNomeContainingIgnoreCaseOrApelidoContainingIgnoreCase(palavraChave, palavraChave);
            alunosEncontrados.addAll(alunosPorChave);
        }
        Set<Aluno> conjuntoAlunos=new HashSet<>(alunosEncontrados);
        alunosEncontrados.clear();
        alunosEncontrados.addAll(conjuntoAlunos);

        return alunosEncontrados;
    }
}
