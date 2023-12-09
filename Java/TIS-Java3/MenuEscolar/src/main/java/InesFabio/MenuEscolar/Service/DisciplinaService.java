package InesFabio.MenuEscolar.Service;

import InesFabio.MenuEscolar.Model.Disciplina;
import InesFabio.MenuEscolar.Model.Docente;
import InesFabio.MenuEscolar.Model.Turma;
import InesFabio.MenuEscolar.Repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    // Atributos
    private final DisciplinaRepository disciplinaRepository;

// Construtores

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }


// Métodos

    public Disciplina saveDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listDisciplina() {
        return disciplinaRepository.findAll();
    }

    public void deleteDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
    }

    public Optional<Disciplina> viewDisciplinaById(Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        return disciplina;
    }
    public Disciplina updateDisciplina(Long id, Disciplina disciplina){
        Optional<Disciplina> disciplinaAtualizada = viewDisciplinaById(id);

        if (disciplinaAtualizada.isPresent()) {
            Disciplina _disciplina = disciplinaAtualizada.get();
            _disciplina.setNome(disciplina.getNome());

            return disciplinaRepository.save(_disciplina);
        }

        return null;
    }

    public List<Disciplina> listDisciplinasByTurmaId(Turma turma){return disciplinaRepository.findByTurmas(turma);}

    public List<Disciplina> listDisciplinasByDocenteId(Docente docente){return disciplinaRepository.findByProfessores(docente);}

}

