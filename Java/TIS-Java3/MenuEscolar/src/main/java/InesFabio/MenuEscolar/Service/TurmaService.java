package InesFabio.MenuEscolar.Service;

import InesFabio.MenuEscolar.Model.Aluno;
import InesFabio.MenuEscolar.Model.AtualizacaoTurmasDTO;
import InesFabio.MenuEscolar.Model.Turma;
import InesFabio.MenuEscolar.Repository.AlunoRepository;
import InesFabio.MenuEscolar.Repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
// Atributos
    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;

// Construtores
    @Autowired
    public TurmaService(TurmaRepository turmaRepository, AlunoRepository alunoRepository) {
        this.turmaRepository = turmaRepository;
        this.alunoRepository = alunoRepository;
    }

// Métodos Base (Obrigatórios)
    public Turma saveTurma(Turma turma){return turmaRepository.save(turma);}
    public List<Turma> listTurma(){return turmaRepository.findAll();}
    public Optional<Turma> viewTurmaById(Long id){
        Optional<Turma> turma=turmaRepository.findById(id);
        return turma;
    }
    public Turma updateTurma(Long id, Turma turma){
        Optional<Turma> turmaAtualizada=viewTurmaById(id);

        if(turmaAtualizada.isPresent()){
            Turma _turma=turmaAtualizada.get();
            _turma.setNome(turma.getNome());
            _turma.setDisciplinas(turma.getDisciplinas());
            _turma.setAlunos(turma.getAlunos());

            return turmaRepository.save(_turma);
        }

        return null;
    }
    public void deleteTurma(Long id){turmaRepository.deleteById(id);}

// Métodos Personalizados (opcionais)
    public void updateTurmasAlunos(AtualizacaoTurmasDTO dto){
        for (int i = 0; i < dto.getIdsAlunos().size(); i++) {
            Long idAluno = dto.getIdsAlunos().get(i);
            Long novoIdTurma = dto.getIdsTurmas().get(i);

            Aluno aluno = alunoRepository.getById(idAluno);
            Turma novaTurma = turmaRepository.getById(novoIdTurma);

            aluno.setTurma(novaTurma);
            alunoRepository.save(aluno);
        }
    }
}
